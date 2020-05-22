package com.ruoyi.web.controller.tool;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.utils.bean.Query;
import com.ruoyi.web.controller.tool.entity.CsafeWorkdev;
import com.ruoyi.web.controller.tool.service.ICsafeWorkdevService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 工作动态Controller
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Api(tags="工作状态信息管理")
@RestController
@RequestMapping("/system/workdev")
public class CsafeWorkdevController extends BaseController
{
    private String prefix = "system/workdev";

    @Autowired
    private ICsafeWorkdevService csafeWorkdevService;

    @RequiresPermissions("system:workdev:view")
    @GetMapping()
    public String workdev()
    {
        return prefix + "/workdev";
    }

    /**
     * 根据ID查询工作动态列表
     */
    @RequiresPermissions("system:workdev:list")
    @ApiOperation("获取工作状态信息")
    @ApiImplicitParam(name = "wdevId", value = "工作状态ID", required = true, dataType = "int", paramType = "path")
    @PostMapping("/{wdevId}")
    public AjaxResult getById(@PathVariable @ApiParam(value = "工作状态信息") Long wdevId)
    {
        CsafeWorkdev csafeWorkdev = csafeWorkdevService.selectCsafeWorkdevById(wdevId);
        if (csafeWorkdev.toString()!=null&&csafeWorkdev.toString().length()>0){
            return AjaxResult.success("查询成功",csafeWorkdev);
        }else{
            return AjaxResult.error(" 查询失败");
        }
    }
    /*
    * 获取分页查询数据*/
    @ApiOperation("获取工作动态列表")
    @ApiImplicitParams
            ({  @ApiImplicitParam(name = "page", value = "跳转的页数", dataType = "int", required = true, paramType = "query"),
                    @ApiImplicitParam(name = "limit", value = "显示的数量", dataType = "int", required = true, paramType = "query"),
                    @ApiImplicitParam(name="params",required = false)
            })
    @RequiresPermissions("system:picscoll:list")
    @PostMapping("/list")
    public TableDataInfo list(@RequestParam Map<String, Object> params){
        Query query=new Query(params);
        Page<Object> page = PageHelper.startPage(query.getPage(), query.getLimit());
        List<CsafeWorkdev> list = csafeWorkdevService.page(query);
        return getDataTable(list);
    }

    /**
     * 导出工作动态列表
     */
    @RequiresPermissions("system:workdev:export")
    @Log(title = "工作动态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsafeWorkdev csafeWorkdev)
    {
        List<CsafeWorkdev> list = csafeWorkdevService.selectCsafeWorkdevList(csafeWorkdev);
        ExcelUtil<CsafeWorkdev> util = new ExcelUtil<CsafeWorkdev>(CsafeWorkdev.class);
        return util.exportExcel(list, "workdev");
    }

    /**
     * 新增工作动态
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工作动态
     */
    @ApiOperation("新增工作动态信息")
    @ApiImplicitParam(name = "CsafeWorkdev", value = "新增工作动态信息", dataType = "CsafeWorkdev")
    @RequiresPermissions("system:workdev:add")
    @Log(title = "工作动态", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult addSave(@RequestBody @ApiParam(value = "工作状态信息")CsafeWorkdev csafeWorkdev)
    {
        return toAjax(csafeWorkdevService.insertCsafeWorkdev(csafeWorkdev));
    }

    /**
     * 修改工作动态
     */
    @GetMapping("/edit/{wdevId}")
    public String edit(@PathVariable("wdevId") Long wdevId, ModelMap mmap)
    {
        CsafeWorkdev csafeWorkdev = csafeWorkdevService.selectCsafeWorkdevById(wdevId);
        mmap.put("csafeWorkdev", csafeWorkdev);
        return prefix + "/edit";
    }

    /**
     * 修改保存工作动态
     */

    @ApiOperation("修改工作动态")
    @ApiImplicitParam(name = "CsafeWorkdev", value = "修改工作动态", dataType = "CsafeWorkdev")
    @RequiresPermissions("system:workdev:edit")
    @Log(title = "工作动态", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult editSave(@RequestBody @ApiParam(value = "工作状态信息")CsafeWorkdev csafeWorkdev)
    {
        return toAjax(csafeWorkdevService.updateCsafeWorkdev(csafeWorkdev));
    }

    /**
     * 删除工作动态
     */
    @ApiOperation("删除工作动态信息")
    @ApiImplicitParam(name = "wdevId", value = "工作动态ID", required = true, dataType = "Long", paramType = "query")
    @RequiresPermissions("system:workdev:remove")
    @Log(title = "工作动态", businessType = BusinessType.DELETE)
    @DeleteMapping( "/remove")
    public AjaxResult remove(@RequestParam("wdevId") Long wdevId)
    {
        return toAjax(csafeWorkdevService.deleteCsafeWorkdevById(wdevId));
    }
}
