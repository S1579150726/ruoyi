package com.ruoyi.web.controller.tool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.web.controller.tool.entity.CsafeText;
import com.ruoyi.web.controller.tool.service.ICsafeTextService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/system/text")
public class CsafeTextController extends BaseController
{
    private String prefix = "system/text";

    @Autowired
    private ICsafeTextService csafeTextService;

    @RequiresPermissions("system:text:view")
    @GetMapping()
    public String text()
    {
        return prefix + "/text";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:text:list")
    @PostMapping("/list2")
    @ResponseBody
    public TableDataInfo list2(CsafeText csafeText)
    {
        startPage();
        List<CsafeText> list = csafeTextService.selectCsafeTextList(csafeText);
        return getDataTable(list);
    }
    /**
     * 查询【三防大屏文本】列表
     */
    @ApiOperation("查询【三防大屏文本】列表")
    @ApiImplicitParam(name="params",required = false,dataType = "body")
    //@RequiresPermissions("system:text:list")
    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(CsafeText csafeText)
    {
        Map<Object, Object> map=null;
        JSONArray objects = new JSONArray();
        List<CsafeText> list = csafeTextService.selectCsafeTextList(csafeText);
        if (list!=null&&list.size()>0){
            CsafeText csafeText1 = list.get(0);
            String textLable = csafeText1.getTextLable();
            String textValue = csafeText1.getTextValue();
            Integer isscroll = csafeText1.getIsscroll();
            map=new HashMap<>();
            map.put(textLable,textValue);
            map.put("topIsscroll",isscroll);
            CsafeText csafeText2 = list.get(1);
            String textLable2 = csafeText2.getTextLable();
            String textValue2 = csafeText2.getTextValue();
            Integer isscroll2 = csafeText2.getIsscroll();
            map.put(textLable2,textValue2);
            map.put("waterIsscroll",isscroll2);
            ///objects.add(map);
        }
        if (map!=null&&map.size()>0){
            return AjaxResult.success("获取成功",map);
        }
        return AjaxResult.error("获取失败");
    }
    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:text:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsafeText csafeText)
    {
        List<CsafeText> list = csafeTextService.selectCsafeTextList(csafeText);
        ExcelUtil<CsafeText> util = new ExcelUtil<CsafeText>(CsafeText.class);
        return util.exportExcel(list, "text");
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
    @RequiresPermissions("system:text:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsafeText csafeText)
    {
        return toAjax(csafeTextService.insertCsafeText(csafeText));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{textId}")
    public String edit(@PathVariable("textId") Long textId, ModelMap mmap)
    {
        CsafeText csafeText = csafeTextService.selectCsafeTextById(textId);
        mmap.put("csafeText", csafeText);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:text:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsafeText csafeText)
    {
        return toAjax(csafeTextService.updateCsafeText(csafeText));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:text:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csafeTextService.deleteCsafeTextByIds(ids));
    }
}
