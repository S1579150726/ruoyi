package com.ruoyi.web.controller.tool.mapper;

import com.ruoyi.common.utils.bean.Query;
import com.ruoyi.web.controller.tool.entity.CsafeWorkdev;

import java.util.List;

/**
 * 工作动态Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public interface CsafeWorkdevMapper 
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
     * 删除工作动态
     * 
     * @param wdevId 工作动态ID
     * @return 结果
     */
    public int deleteCsafeWorkdevById(Long wdevId);

    /**
     * 批量删除工作动态
     * 
     * @param wdevIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafeWorkdevByIds(String[] wdevIds);
}
