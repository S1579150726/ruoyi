package com.ruoyi.web.controller.tool.controller;

import java.util.HashMap;
import java.util.List;

import com.ruoyi.web.controller.tool.entity.CsafeSrefresh;
import com.ruoyi.web.controller.tool.service.ICsafeSrefreshService;
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
 * @date 2020-06-05
 */
@Controller
@RequestMapping("/system/srefresh")
public class CsafeSrefreshController extends BaseController
{
    private String prefix = "system/srefresh";

    @Autowired
    private ICsafeSrefreshService csafeSrefreshService;

    @RequiresPermissions("system:srefresh:view")
    @GetMapping()
    public String srefresh()
    {
        return prefix + "/srefresh";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:srefresh:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CsafeSrefresh csafeSrefresh)
    {
        startPage();
        List<CsafeSrefresh> list = csafeSrefreshService.selectCsafeSrefreshList(csafeSrefresh);

        return getDataTable(list);
    }
    /**
     * 获取【页面刷新配置】列表
     */
   // @RequiresPermissions("system:srefresh:list")
    @GetMapping("/getSRlist")
    @ResponseBody
    public AjaxResult list2()
    {
        CsafeSrefresh csafeSrefresh=null;
        List<CsafeSrefresh> list = csafeSrefreshService.selectCsafeSrefreshList(csafeSrefresh);
        HashMap<Object, Object> map = new HashMap<>();
        Long screentime=null;
        if (list!=null&&list.size()>0){
            for (int i=0;i<list.size();i++){
                String screenurl = list.get(i).getScreenurl();
                screentime= list.get(i).getScreentime();
                map.put("screenurl"+i,screenurl);

            }
            map.put("screentime",screentime);
        }
        if (!map.isEmpty()&&map.size()>0){
            return AjaxResult.success("获取成功",map);
        }
       return AjaxResult.error("获取失败");
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:srefresh:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CsafeSrefresh csafeSrefresh)
    {
        List<CsafeSrefresh> list = csafeSrefreshService.selectCsafeSrefreshList(csafeSrefresh);
        ExcelUtil<CsafeSrefresh> util = new ExcelUtil<CsafeSrefresh>(CsafeSrefresh.class);
        return util.exportExcel(list, "srefresh");
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
    @RequiresPermissions("system:srefresh:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CsafeSrefresh csafeSrefresh)
    {
        int c = csafeSrefreshService.insertCsafeSrefresh(csafeSrefresh);
        int count=0;
        List<CsafeSrefresh> l1=null;
        if (c>0){
            CsafeSrefresh csafeSrefresh1 = csafeSrefreshService.selectCsafeSrefreshById(csafeSrefresh.getScreenid());
            Long screentime1 = csafeSrefresh1.getScreentime();
            //Long screentime = csafeSrefresh.getScreentime();
            CsafeSrefresh csafeSrefresh2=null;
            l1 = csafeSrefreshService.selectCsafeSrefreshList(csafeSrefresh2);
            if (l1!=null&&l1.size()>0){
                for (int i=0;i<l1.size();i++){
                    Long screenid = l1.get(i).getScreenid();
                    CsafeSrefresh csafeSrefrcesh2=new CsafeSrefresh();
                    csafeSrefrcesh2.setScreentime(screentime1);
                    csafeSrefrcesh2.setScreenid(screenid);
                   int i1 = csafeSrefreshService.updateCsafeSrefresh(csafeSrefrcesh2);
                   if (i1>0){
                       count++;
                   }
                }
            }
        }
        if (count==l1.size()){
            return toAjax(1);
        }else {
            return toAjax(-1);
        }

    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{screenid}")
    public String edit(@PathVariable("screenid") Long screenid, ModelMap mmap)
    {
        CsafeSrefresh csafeSrefresh = csafeSrefreshService.selectCsafeSrefreshById(screenid);
        mmap.put("csafeSrefresh", csafeSrefresh);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:srefresh:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CsafeSrefresh csafeSrefresh)
    {
        int c = csafeSrefreshService.updateCsafeSrefresh(csafeSrefresh);
        Long screentime = csafeSrefresh.getScreentime();
        CsafeSrefresh CsafeSrefrcesh=null;
        int i1=0;
        List<CsafeSrefresh> l1 = csafeSrefreshService.selectCsafeSrefreshList(CsafeSrefrcesh);
        if (l1!=null&&l1.size()>0){
            for (int i=0;i<l1.size();i++){
                Long screenid = l1.get(i).getScreenid();
                CsafeSrefresh csafeSrefrcesh2=new CsafeSrefresh();
                csafeSrefrcesh2.setScreentime(screentime);
                csafeSrefrcesh2.setScreenid(screenid);
                i1 = csafeSrefreshService.updateCsafeSrefresh(csafeSrefrcesh2);
            }
        }
        return toAjax(i1);
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:srefresh:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(csafeSrefreshService.deleteCsafeSrefreshByIds(ids));
    }
}
