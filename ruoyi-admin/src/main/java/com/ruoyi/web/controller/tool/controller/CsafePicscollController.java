package com.ruoyi.web.controller.tool.controller;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.web.controller.tool.entity.CsafePicscoll;
import com.ruoyi.web.controller.tool.service.ICsafePicscollService;
import io.swagger.annotations.ApiImplicitParam;
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
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/system/picscoll")
public class CsafePicscollController extends BaseController
{
    private String prefix = "system/picscoll";

    @Autowired
    private ICsafePicscollService csafePicscollService;

    @RequiresPermissions("system:picscoll:view")
    @GetMapping()
    public String picscoll()
    {
        return prefix + "/picscoll";
    }

    /**
     * 查询图片列表
     */
    @RequiresPermissions("system:picscoll:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsafePicscoll csafePicscoll)
    {
        startPage();
        List<CsafePicscoll> list = csafePicscollService.selectCsafePicscollList(csafePicscoll);
        return getDataTable(list);
    }

    /**
     * 导出图片列表
     */
    @RequiresPermissions("system:picscoll:export")
    @Log(title = "图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export2")
    @ResponseBody
    public AjaxResult export2(CsafePicscoll csafePicscoll)
    {
        List<CsafePicscoll> list = csafePicscollService.selectCsafePicscollList(csafePicscoll);
        ExcelUtil<CsafePicscoll> util = new ExcelUtil<CsafePicscoll>(CsafePicscoll.class);
        return util.exportExcel(list, "picscoll");
    }
    /**
     * 导出图片列表
     */
    @ApiOperation("导出图片列表")
    //@Log(title = "图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsafePicscoll csafePicscoll)
    {

        List<CsafePicscoll> list = csafePicscollService.selectCsafePicscollList(csafePicscoll);
        String url=null;
        if (list!=null&&list.size()>0){
            for (CsafePicscoll cs:list) {
                cs.setPicUrl(cs.getPicUrl());
            }
            return AjaxResult.success("获取图片成功",list);
        }else
        {
            return AjaxResult.error("获取失败");
        }

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
    @RequiresPermissions("system:picscoll:add")
    @Log(title = "图片", businessType = BusinessType.INSERT)
    @PostMapping("/add1")
    @ResponseBody
    public AjaxResult addSave(CsafePicscoll csafePicscoll)
    {
        return toAjax(csafePicscollService.insertCsafePicscoll(csafePicscoll));
    }
    /**
     * 新增保存图片
     */
    @ApiOperation("新增图片")
    @RequiresPermissions("system:picscoll:add")
    @Log(title = "图片", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            // 上传文件路径
            String defaultBaseDir = Global.getUploadPath();//C:/Users/edison\Desktop\item\RuoYi
            String fileName = file.getOriginalFilename();//上传文件名
            String upload = FileUploadUtils.upload(defaultBaseDir, file);
            String url ="/RuoYi"+upload;
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
    //@RequiresPermissions("system:picscoll:edit")
    @Log(title = "图片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit1")
    @ResponseBody
    public AjaxResult editSave(CsafePicscoll csafePicscoll)
    {
        return toAjax(csafePicscollService.updateCsafePicscoll(csafePicscoll));
    }
    /**
     * 修改保存图片
     */
   // @ApiOperation("更新图片")
   // @ApiImplicitParam(name = "picId", value = "图片ID", dataType = "Long",paramType = "query",required = true)
    @RequiresPermissions("system:picscoll:edit")
    @Log(title = "图片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestParam("file") MultipartFile file,@RequestParam("picId") Long picId)
    {
        String defaultBaseDir = Global.getUploadPath();
        try {
            String upload = FileUploadUtils.upload(defaultBaseDir, file);
            String url="/RuoYi"+upload;
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
    @RequiresPermissions("system:picscoll:remove")
    @Log(title = "图片", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csafePicscollService.deleteCsafePicscollByIds(ids));
    }
}
