package com.ruoyi.web.controller.tool.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.bean.Query;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.tool.entity.CsafeInfo;
import com.ruoyi.web.controller.tool.service.ICsafeInfoService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 综合信息Controller
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Api(tags = "综合信息管理")
@RestController
@RequestMapping("/system/info")
public class CsafeInfoController extends BaseController {
    private String prefix = "system/info";

    @Autowired
    private ICsafeInfoService csafeInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info() {
        return prefix + "/info";
    }

    /**
     * 查询综合信息
     */
    @ApiOperation("通过ID获取综合信息")
    @ApiImplicitParam(name = "infoId", value = "综合信息ID", required = true, dataType = "Long", paramType = "path")
    @RequiresPermissions("system:info:list")
    @GetMapping("/getById/{infoId}")
    public AjaxResult getById(@PathVariable @ApiParam(value = "综合信息") Long infoId) {
        CsafeInfo csafeInfo = csafeInfoService.selectCsafeInfoById(infoId);
        if (csafeInfo.toString() != null && csafeInfo.toString().length() > 0) {
            return AjaxResult.success("查询成功", csafeInfo);
        } else {
            return AjaxResult.error(" 查询失败");
        }
    }
    /**
     * 获取所有综合信息
     */
    @ApiOperation("获取所有综合信息")
    @ApiImplicitParam(name = "params", value = "综合信息", required = false,  paramType = "data")
    @GetMapping("/getAllInfo")
    public AjaxResult getAllInfo(CsafeInfo csafeInfo) {
        List<CsafeInfo> list = csafeInfoService.selectCsafeInfoList(csafeInfo);
        Map map=new HashMap();
        for (int i=0;i<list.size();i++){
            String infoLabel = list.get(i).getInfoLabel();
            String infoValue = list.get(i).getInfoValue();
            map.put(infoLabel,infoValue);
        }if(!map.isEmpty()&&map.size()>0){
            return AjaxResult.success("获取成功",map);
        }else {
            return AjaxResult.error("获取失败");
        }

    }
    /*public TableDataInfo list(@RequestBody @ApiParam(value = "综合信息") CsafeInfo csafeInfo)
    {
        startPage();
        List<CsafeInfo> list = csafeInfoService.selectCsafeInfoList(csafeInfo);
        return getDataTable(list);
    }*/


    /**
     * 导出综合信息列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "综合信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsafeInfo csafeInfo) {
        List<CsafeInfo> list = csafeInfoService.selectCsafeInfoList(csafeInfo);
        ExcelUtil<CsafeInfo> util = new ExcelUtil<CsafeInfo>(CsafeInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增综合信息
     */

    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存综合信息
     */

    @RequiresPermissions("system:info:add")
    @ApiOperation("新增综合信息")
    @ApiImplicitParam(name = "CsafeInfoId", value = "新增综合信息", dataType = "String")
    @Log(title = "综合信息", businessType = BusinessType.INSERT)
    @PostMapping("/addSave")
    public AjaxResult addSave(@RequestBody @ApiParam(value = "综合信息") CsafeInfo csafeInfo) {
        return toAjax(csafeInfoService.insertCsafeInfo(csafeInfo));
    }

    /**
     * 修改综合信息
     */

    @GetMapping("/edit/{infoId}")
    public String edit(@PathVariable("infoId") Long infoId, ModelMap mmap) {
        CsafeInfo csafeInfo = csafeInfoService.selectCsafeInfoById(infoId);
        mmap.put("csafeInfo", csafeInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存综合信息
     */
    @ApiOperation("修改综合信息")
    @ApiImplicitParam(name = "CsafeInfoId", value = "新增用户信息", dataType = "CsafeInfo")
    @RequiresPermissions("system:info:edit")
    @Log(title = "综合信息", businessType = BusinessType.UPDATE)
    @PutMapping("/editSave")
    public AjaxResult editSave(@RequestBody @ApiParam(value = "综合信息") CsafeInfo csafeInfo) {
        return toAjax(csafeInfoService.updateCsafeInfo(csafeInfo));
    }

    /**
     * 删除综合信息
     */
    @ApiOperation("删除综合信息")
    @ApiImplicitParam(name = "infoId", value = "综合信息ID", required = true, dataType = "Long", paramType = "query")
    @RequiresPermissions("system:info:remove")
    @Log(title = "综合信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/remove}")
    public AjaxResult remove(@RequestParam("infoId") Long infoId) {
        return toAjax(csafeInfoService.deleteCsafeInfoById(infoId));
    }

    /**
     * 分页查询综合信息
     */
    @ApiOperation("分页查询综合信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "跳转的页数", dataType = "int", required = true, paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "显示的数量", dataType = "int", required = true, paramType = "query"),
            @ApiImplicitParam(name = "params", value = "不用填写", dataType = "String", required = false, paramType = "query")})
    @RequiresPermissions("system:info:page")
    @Log(title = "综合信息", businessType = BusinessType.EXPORT)
    @PostMapping("/page")
    @ResponseBody
    public TableDataInfo page(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        Page<CsafeInfo> objects = PageHelper.startPage(query.getPage(), query.getLimit());
        List<CsafeInfo> page = csafeInfoService.page(query);
        long total = objects.getTotal();//总数
        return new TableDataInfo(page,total );
    }
}
