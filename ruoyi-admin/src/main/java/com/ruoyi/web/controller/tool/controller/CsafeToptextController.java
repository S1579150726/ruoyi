package com.ruoyi.web.controller.tool.controller;

import java.util.List;

import com.ruoyi.web.controller.tool.entity.CsafeToptext;
import com.ruoyi.web.controller.tool.service.ICsafeToptextService;
import io.swagger.annotations.Api;
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

/**
 * 顶部数据Controller
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Api(tags = "顶部数据")
@RestController
@RequestMapping("/system/toptext")
public class CsafeToptextController extends BaseController
{
    private String prefix = "system/toptext";

    @Autowired
    private ICsafeToptextService csafeToptextService;

    @RequiresPermissions("system:toptext:view")
    @GetMapping()
    public String toptext()
    {
        return prefix + "/toptext";
    }

    /**
     * 查询顶部数据列表
     */
    @ApiOperation("获取顶部数据")
    @RequiresPermissions("system:toptext:getList")
    @GetMapping("/getList")
    @ResponseBody
    public AjaxResult getList(CsafeToptext csafeToptext)
    {
        List<CsafeToptext> list = csafeToptextService.selectCsafeToptextList(csafeToptext);
        if (list!=null&&list.size()>0){
            return AjaxResult.success("查询成功",list);
        }else {
            return AjaxResult.error("查询失败");
        }
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @ApiOperation("导出顶部数据")
    @RequiresPermissions("system:toptext:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    @ResponseBody
    public AjaxResult export(CsafeToptext csafeToptext)
    {
        List<CsafeToptext> list = csafeToptextService.selectCsafeToptextList(csafeToptext);
        if (list!=null&&list.size()>0){
            return AjaxResult.success("查询成功",list);
        }else {
            return AjaxResult.error("查询失败");
        }
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:toptext:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsafeToptext csafeToptext)
    {
        return toAjax(csafeToptextService.insertCsafeToptext(csafeToptext));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        CsafeToptext csafeToptext = csafeToptextService.selectCsafeToptextById(id);
        mmap.put("csafeToptext", csafeToptext);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:toptext:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsafeToptext csafeToptext)
    {
        return toAjax(csafeToptextService.updateCsafeToptext(csafeToptext));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:toptext:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csafeToptextService.deleteCsafeToptextByIds(ids));
    }
}
