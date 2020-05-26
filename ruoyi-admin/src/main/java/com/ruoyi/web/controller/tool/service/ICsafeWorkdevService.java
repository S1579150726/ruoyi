package com.ruoyi.web.controller.tool.service;

import java.util.List;

import com.ruoyi.common.utils.bean.Query;
import com.ruoyi.web.controller.tool.entity.CsafeWorkdev;

/**
 * 工作动态Service接口
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public interface ICsafeWorkdevService 
{
    /**
     * 查询工作动态
     * 
     * @param wdevId 工作动态ID
     * @return 工作动态
     */
    public CsafeWorkdev selectCsafeWorkdevById(Long wdevId);

    /**
     * 查询工作动态列表
     * 
     * @param csafeWorkdev 工作动态
     * @return 工作动态集合
     */
    public List<CsafeWorkdev> selectCsafeWorkdevList(CsafeWorkdev csafeWorkdev);
    /*分页查询*/
    public List<CsafeWorkdev> page(Query query);

    /**
     * 新增工作动态
     * 
     * @param csafeWorkdev 工作动态
     * @return 结果
     */
    public int insertCsafeWorkdev(CsafeWorkdev csafeWorkdev);

    /**
     * 修改工作动态
     * 
     * @param csafeWorkdev 工作动态
     * @return 结果
     */
    public int updateCsafeWorkdev(CsafeWorkdev csafeWorkdev);

    /**
     * 批量删除工作动态
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafeWorkdevByIds(String ids);

    /**
     * 删除工作动态信息
     * 
     * @param wdevId 工作动态ID
     * @return 结果
     */
    public int deleteCsafeWorkdevById(Long wdevId);

}

