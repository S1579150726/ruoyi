package com.ruoyi.web.controller.tool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.web.controller.tool.entity.CsafeInfo;
import com.ruoyi.web.controller.tool.service.ICsafeInfoService;
import io.swagger.annotations.Api;
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
 * 综合信息Controller
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
@Api("综合信息接口")
@Controller
@RequestMapping("/system/info")
public class CsafeInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private ICsafeInfoService csafeInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询综合信息列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsafeInfo csafeInfo)
    {
        startPage();
        List<CsafeInfo> list = csafeInfoService.selectCsafeInfoList(csafeInfo);
        return getDataTable(list);
    }
    /**
     * 获取所有综合信息
     */
    @ApiOperation("获取所有综合信息")
    @ApiImplicitParam(name = "params", value = "综合信息", required = false,  paramType = "data")
    @GetMapping("/getAllInfo")
    @ResponseBody
    public AjaxResult getAllInfo(CsafeInfo csafeInfo) {
        List<CsafeInfo> list = csafeInfoService.selectCsafeInfoList(csafeInfo);
        Map map=new HashMap();
        for (int i=0;i<list.size();i++){
            String infoCode = list.get(i).getInfoCode();
            String infoValue = list.get(i).getInfoValue();
            String infoUnit = list.get(i).getInfoUnit();
            map.put(infoCode,infoValue+infoUnit);
        }if(!map.isEmpty()&&map.size()>0){
            return AjaxResult.success("获取成功",map);
        }else {
            return AjaxResult.error("获取失败");
        }

    }
    /**
     * 导出综合信息列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "综合信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsafeInfo csafeInfo)
    {
        List<CsafeInfo> list = csafeInfoService.selectCsafeInfoList(csafeInfo);
        ExcelUtil<CsafeInfo> util = new ExcelUtil<CsafeInfo>(CsafeInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增综合信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存综合信息
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "综合信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsafeInfo csafeInfo)
    {
        return toAjax(csafeInfoService.insertCsafeInfo(csafeInfo));
    }

    /**
     * 修改综合信息
     */
    @GetMapping("/edit/{infoId}")
    public String edit(@PathVariable("infoId") Long infoId, ModelMap mmap)
    {
        CsafeInfo csafeInfo = csafeInfoService.selectCsafeInfoById(infoId);
        mmap.put("csafeInfo", csafeInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存综合信息
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "综合信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsafeInfo csafeInfo)
    {
        return toAjax(csafeInfoService.updateCsafeInfo(csafeInfo));
    }

    /**
     * 删除综合信息
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "综合信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csafeInfoService.deleteCsafeInfoByIds(ids));
    }
}
