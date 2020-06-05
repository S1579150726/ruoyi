package com.ruoyi.web.controller.tool.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.utils.bean.Query;
import com.ruoyi.web.controller.tool.entity.CsafeWorkdev;
import com.ruoyi.web.controller.tool.entity.CsafeWorkdev2;
import com.ruoyi.web.controller.tool.service.ICsafeWorkdevService;
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

/**
 * 工作动态Controller
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
@Controller
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
     * 查询工作动态列表
     */
    @RequiresPermissions("system:workdev:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsafeWorkdev csafeWorkdev)
    {
        startPage();
        List<CsafeWorkdev> list = csafeWorkdevService.selectCsafeWorkdevList(csafeWorkdev);
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
    /*
     * 获取分页查询数据*/
    @ApiOperation("获取工作动态列表")
    @ApiImplicitParams
            ({  @ApiImplicitParam(name = "page", value = "跳转的页数", dataType = "int", required = true, paramType = "query"),
                    @ApiImplicitParam(name = "limit", value = "显示的数量", dataType = "int", required = true, paramType = "query"),
                    @ApiImplicitParam(name="params",required = false)
            })
    @GetMapping("/getlist")
    @ResponseBody
    public TableDataInfo getlist(@RequestParam Map<String, Object> params){
        Query query=new Query(params);
        Page<Object> page = PageHelper.startPage(query.getPage(), query.getLimit());
        List<CsafeWorkdev> list = csafeWorkdevService.page(query);
        List<CsafeWorkdev> list2=new ArrayList< >();
        SimpleDateFormat smonth = new SimpleDateFormat("MM");
        SimpleDateFormat sday = new SimpleDateFormat("dd");
        CsafeWorkdev2 cs=null;
        TableDataInfo tableDataInfo =null;
        if (list!=null&list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                Date wdevDate = list.get(i).getWdevDate();
                String wdevContent = list.get(i).getWdevContent();
                Long wdevId = list.get(i).getWdevId();
                String month = smonth.format(wdevDate);
                String day = sday.format(wdevDate);
                cs = new CsafeWorkdev2();
                cs.setMonth(month);
                cs.setWdevDate(wdevDate);
                cs.setDay(day);
                cs.setWdevContent(wdevContent);
                cs.setWdevId(wdevId);
                list2.add(cs);
            }
            long total = page.getTotal();
            tableDataInfo = new TableDataInfo(list2, total);
            tableDataInfo.setCode(0);
            tableDataInfo.setMsg("查询成功");
            return tableDataInfo;
        }else {
            tableDataInfo.setCode(500);
            tableDataInfo.setMsg("查询失败");
            return tableDataInfo;
        }
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
    @RequiresPermissions("system:workdev:add")
    @Log(title = "工作动态", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsafeWorkdev csafeWorkdev)
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
    @RequiresPermissions("system:workdev:edit")
    @Log(title = "工作动态", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsafeWorkdev csafeWorkdev)
    {
        return toAjax(csafeWorkdevService.updateCsafeWorkdev(csafeWorkdev));
    }

    /**
     * 删除工作动态
     */
    @RequiresPermissions("system:workdev:remove")
    @Log(title = "工作动态", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csafeWorkdevService.deleteCsafeWorkdevByIds(ids));
    }
}
