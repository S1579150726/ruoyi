package com.ruoyi.web.controller.tool;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.bean.Query;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.web.controller.tool.entity.CsafeInfo;
import com.ruoyi.web.controller.tool.entity.CsafePicscoll;
import com.ruoyi.web.controller.tool.entity.CsafeVideo;
import com.ruoyi.web.controller.tool.service.ICsafePicscollService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 图片Controller
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Api(tags="图片轮播管理")
@RestController
@RequestMapping("/system/picscoll")
public class CsafePicscollController extends BaseController
{
    private String prefix = "system/picscoll";
    private static CsafePicscoll csafePicscoll;
    private  static String defaultBaseDir = Global.getUploadPath();
    @Autowired
    private ICsafePicscollService csafePicscollService;

    @RequiresPermissions("system:picscoll:view")
    @GetMapping()
    public String picscoll()
    {
        return prefix + "/picscoll";
    }

    /**
     * 根据ID查询图片
     */
    @ApiOperation("获取图片")
    @ApiImplicitParam(name = "picId", value = "图片ID", required = true, dataType = "Long ", paramType = "query")
    @PostMapping("/getPic")
    public AjaxResult getPic(@RequestParam("picId") Long picId)
    {
        CsafePicscoll csafePicscoll = csafePicscollService.selectCsafePicscollById(picId);
        return AjaxResult.success(csafePicscoll.getPicUrl());
    }
    /**
     * 查询图片列表
     */
    @ApiOperation("获取图片列表")
    @ApiImplicitParams
    ({  @ApiImplicitParam(name = "page", value = "跳转的页数", dataType = "int", required = true, paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "显示的数量", dataType = "int", required = true, paramType = "query"),
            @ApiImplicitParam(name="params",required = false)
    })
    @RequiresPermissions("system:picscoll:getPicList")
    @PostMapping("/getPicList")
    @ResponseBody
    public TableDataInfo getPicList(@RequestParam Map<String, Object> params)
    {
        Query query=new Query(params);
        Page<Object> page = PageHelper.startPage(query.getPage(), query.getLimit());
        List<CsafePicscoll> list = csafePicscollService.page(query);
        long total = page.getTotal();
        return new TableDataInfo(list,total);
    }

    /**
     * 导出图片列表
     */
    @RequiresPermissions("system:picscoll:export")
    @Log(title = "图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public AjaxResult export(CsafePicscoll csafePicscoll)
    {
        List<CsafePicscoll> list = csafePicscollService.selectCsafePicscollList(csafePicscoll);
        ExcelUtil<CsafePicscoll> util = new ExcelUtil<CsafePicscoll>(CsafePicscoll.class);
        return util.exportExcel(list, "picscoll");
    }

    /**
     * 新增图片
     */

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存图片
     */
    @ApiOperation("新增图片")
    @RequiresPermissions("system:picscoll:addSave")
    @Log(title = "图片", businessType = BusinessType.INSERT)
    @PostMapping("/addSave")
    public AjaxResult addSave(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
                // 上传文件路径
                String defaultBaseDir = Global.getUploadPath();
                String fileName = file.getOriginalFilename();
                String fileTyle = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                String upload = FileUploadUtils.upload(defaultBaseDir, file);
                String url = defaultBaseDir + upload;
                CsafePicscoll csafePicscoll = new CsafePicscoll();
                csafePicscoll.setPicUrl(url);
                return toAjax(csafePicscollService.insertCsafePicscoll(csafePicscoll));
        }
        return null;
    }
    /**
     * 修改图片
     */

    @GetMapping("/edit/{picId}")
    public String edit(@PathVariable("picId") Long picId, ModelMap mmap)
    {
        CsafePicscoll csafePicscoll = csafePicscollService.selectCsafePicscollById(picId);
        mmap.put("csafePicscoll", csafePicscoll);
        return prefix + "/edit";
    }

    /**
     * 修改保存图片
     */
    /*@ApiOperation("更新图片")
    @ApiImplicitParam(name = "picId", value = "图片ID", dataType = "Long",required = true,paramType = "query")
    @RequiresPermissions("system:picscoll:edit")
    @Log(title = "图片", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult editSave(@RequestParam("file") MultipartFile file, HttpServletRequest request,
                               @RequestParam("picId")Long picId) throws IOException {

        String upload = FileUploadUtils.upload(defaultBaseDir,file);
        String url=defaultBaseDir+upload;
        csafePicscoll.setPicUrl(url);
        csafePicscoll.setPicId(picId);
        return toAjax(csafePicscollService.updateCsafePicscoll(csafePicscoll));
    }*/
    @ApiOperation("更新图片")
    @ApiImplicitParam(name = "picId", value = "图片ID", dataType = "Long",paramType = "query",required = true)
    @RequiresPermissions("system:video:edit")
    @Log(title = "图片", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult editSave(@RequestParam("file") MultipartFile file,HttpServletRequest request,@RequestParam("picId") Long picId)
    {
        String defaultBaseDir = Global.getUploadPath();
        try {
            String upload = FileUploadUtils.upload(defaultBaseDir, file);
            String url=defaultBaseDir+upload;
            String originalFilename = file.getOriginalFilename();
            CsafePicscoll csafePicscoll=new CsafePicscoll();
            csafePicscoll.setPicUrl(url);
            csafePicscoll.setPicId(picId);
            csafePicscollService.updateCsafePicscoll(csafePicscoll);
            return AjaxResult.success("上传成功", url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AjaxResult.error("上传失败");
    }

    /**
     * 删除图片
     */
    @ApiOperation("删除图片")
    @ApiImplicitParam(name = "picId", value = "图片ID", required = true, dataType = "Long", paramType = "query")
    @RequiresPermissions("system:picscoll:remove")
    @Log(title = "图片", businessType = BusinessType.DELETE)
    @DeleteMapping( "/remove")
    public AjaxResult remove(@RequestParam("picId") Long picId)
    {
        return toAjax(csafePicscollService.deleteCsafePicscollById(picId));
    }
}
