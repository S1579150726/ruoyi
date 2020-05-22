package com.ruoyi.web.controller.tool;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.web.controller.tool.entity.CsafeVideo;
import com.ruoyi.web.controller.tool.service.ICsafeVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
 * 视频字典Controller
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Api(tags = "视频播放管理")
@RestController
@RequestMapping("/system/video")
public class CsafeVideoController extends BaseController
{
    private String prefix = "system/video";

    @Autowired
    private ICsafeVideoService csafeVideoService;

    @Autowired
    private ServerConfig serverConfig;

    @RequiresPermissions("system:video:view")
    @GetMapping()
    public String video()
    {
        return prefix + "/video";
    }

    /**
     * 查询视频信息列表
     */
    @RequiresPermissions("system:video:get")
    @ApiOperation("获取视频信息")
    @ApiImplicitParam(name = "infoId", value = "视频ID", required = true, dataType = "Long", paramType = "query")
    @GetMapping("/get")
    public AjaxResult get(@RequestParam("infoId") Long id)
    {
        CsafeVideo csafeVideo = csafeVideoService.selectCsafeVideoById(id);
        String vedioUrl = csafeVideo.getVedioUrl();
        return AjaxResult.success("查询成功",vedioUrl);
    }

    /**
     * 导出视频字典列表
     */
    @RequiresPermissions("system:video:export")
    @Log(title = "视频字典", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsafeVideo csafeVideo)
    {
        List<CsafeVideo> list = csafeVideoService.selectCsafeVideoList(csafeVideo);
        ExcelUtil<CsafeVideo> util = new ExcelUtil<CsafeVideo>(CsafeVideo.class);
        return util.exportExcel(list, "video");
    }

    /**
     * 新增视频字典
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存视频字典
     */
    @ApiOperation("新增视频")
    //@ApiImplicitParam(name = "type", value = "文件类型", dataType = "String", required = true, paramType = "query",example = "file,image,video")
    /*@RequiresPermissions("system:video:add")*/
    @Log(title = "视频字典", businessType = BusinessType.INSERT)
    @PutMapping("/addSave")
    public AjaxResult addSave(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws InterruptedException {
        if (!file.isEmpty()) {
            try {
                // 上传文件路径
                String defaultBaseDir = Global.getUploadPath();
                String fileName = file.getOriginalFilename();
                String fileTyle = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                String upload = FileUploadUtils.upload(defaultBaseDir, file);
                String url=defaultBaseDir+upload;
               // String url = serverConfig.getUrl() + fileName;
                CsafeVideo csafeVideo=new CsafeVideo();
                csafeVideo.setVedioUrl(url);

                int i = csafeVideoService.insertCsafeVideo(csafeVideo);
                if (i > 0) {
                   return AjaxResult.success("上传成功");
                }
            } catch (Exception e) {
                return AjaxResult.error("上传失败");
            }
        }
        return AjaxResult.success("上传成功");
    }
    /**
     * 修改视频字典
     */

    @GetMapping("/edit/{vedioId}")
    public String edit(@PathVariable("vedioId") Long vedioId, ModelMap mmap)
    {
        CsafeVideo csafeVideo = csafeVideoService.selectCsafeVideoById(vedioId);
        mmap.put("csafeVideo", csafeVideo);
        return prefix + "/edit";
    }

    /**
     * 修改保存视频字典
     */
    @ApiOperation("修改视频")
    @ApiImplicitParam(name = "infoId", value = "视频Id", dataType = "Long",paramType = "query",required = true)
    @RequiresPermissions("system:video:edit")
    @Log(title = "视频字典", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult editSave(@RequestParam("file") MultipartFile file,@RequestParam("infoId") Long infoId)
    {
        String defaultBaseDir = Global.getUploadPath();
        try {
            String upload = FileUploadUtils.upload(defaultBaseDir, file);
            String url=defaultBaseDir+upload;
            String originalFilename = file.getOriginalFilename();
            CsafeVideo csafeVideo=new CsafeVideo();
            csafeVideo.setVedioId(infoId);
            csafeVideo.setVedioUrl(url);
            csafeVideoService.updateCsafeVideo(csafeVideo);
            return AjaxResult.success("上传成功", url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AjaxResult.error("上传失败");
    }

    /**
     * 删除视频字典
     */
    @ApiOperation("删除视频")
    @ApiImplicitParam(name = "infoId", value = "视频Id", required = true, dataType = "Long", paramType = "query")
    @RequiresPermissions("system:video:remove")
    @Log(title = "视频字典", businessType = BusinessType.DELETE)
    @DeleteMapping( "/remove/")
    public AjaxResult remove(@RequestParam("infoID") Long id)
    {
        return toAjax(csafeVideoService.deleteCsafeVideoById(id));
    }
}
