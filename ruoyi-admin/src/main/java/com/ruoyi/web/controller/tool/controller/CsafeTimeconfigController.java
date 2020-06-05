package com.ruoyi.web.controller.tool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.web.controller.tool.entity.CsafeTimeconfig;
import com.ruoyi.web.controller.tool.service.ICsafeTimeconfigService;
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
@RequestMapping("/system/timeconfig")
public class CsafeTimeconfigController extends BaseController
{
    private String prefix = "system/timeconfig";

    @Autowired
    private ICsafeTimeconfigService csafeTimeconfigService;

    @RequiresPermissions("system:timeconfig:view")
    @GetMapping()
    public String timeconfig()
    {
        return prefix + "/timeconfig";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:timeconfig:list")
    @PostMapping("/list2")
    @ResponseBody
    public TableDataInfo list2(CsafeTimeconfig csafeTimeconfig)
    {
        startPage();
        List<CsafeTimeconfig> list = csafeTimeconfigService.selectCsafeTimeconfigList(csafeTimeconfig);
        return getDataTable(list);
    }
    /**
     * 查询【所有时间配置的信息】列表
     */
    //@ApiOperation("查询所有时间配置的信息")
   // @ApiImplicitParam(name = "params",required = false,dataType = "CsafeTimeconfig",paramType = "data")
    //@RequiresPermissions("system:timeconfig:list")
    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list( CsafeTimeconfig csafeTimeconfig)
    {
        List<CsafeTimeconfig> list = csafeTimeconfigService.selectCsafeTimeconfigList(csafeTimeconfig);
        Map<Object, Object> map=null;
        if (list!=null&&list.size()>0){
            map = new HashMap<>();
            for (int i=0;i<list.size();i++){
                CsafeTimeconfig cs = list.get(i);
                String code = cs.getCode();
                Integer configTimeinterval = cs.getConfigTimeinterval();
                if (code!=null&&code.length()>0&&configTimeinterval!=null)
                    map.put(code,configTimeinterval);
            } }
        if (map!=null&&map.size()>0) {
            return AjaxResult.success("成功", map);
        }
        return AjaxResult.error("查询失败");
    }
    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:timeconfig:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsafeTimeconfig csafeTimeconfig)
    {
        List<CsafeTimeconfig> list = csafeTimeconfigService.selectCsafeTimeconfigList(csafeTimeconfig);
        ExcelUtil<CsafeTimeconfig> util = new ExcelUtil<CsafeTimeconfig>(CsafeTimeconfig.class);
        return util.exportExcel(list, "timeconfig");
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
    @RequiresPermissions("system:timeconfig:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsafeTimeconfig csafeTimeconfig)
    {
        return toAjax(csafeTimeconfigService.insertCsafeTimeconfig(csafeTimeconfig));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{configName}")
    public String edit(@PathVariable("configName") String configName, ModelMap mmap)
    {
        CsafeTimeconfig csafeTimeconfig = csafeTimeconfigService.selectCsafeTimeconfigById(configName);
        mmap.put("csafeTimeconfig", csafeTimeconfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:timeconfig:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsafeTimeconfig csafeTimeconfig)
    {
        return toAjax(csafeTimeconfigService.updateCsafeTimeconfig(csafeTimeconfig));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:timeconfig:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csafeTimeconfigService.deleteCsafeTimeconfigByIds(ids));
    }
}
