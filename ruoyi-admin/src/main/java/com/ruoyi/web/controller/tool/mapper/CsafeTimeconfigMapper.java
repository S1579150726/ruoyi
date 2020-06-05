package com.ruoyi.web.controller.tool.mapper;

import java.util.List;
import com.ruoyi.web.controller.tool.entity.CsafeTimeconfig;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
public interface CsafeTimeconfigMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param configName 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CsafeTimeconfig selectCsafeTimeconfigById(String configName);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param csafeTimeconfig 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CsafeTimeconfig> selectCsafeTimeconfigList(CsafeTimeconfig csafeTimeconfig);

    /**
     * 新增【请填写功能名称】
     * 
     * @param csafeTimeconfig 【请填写功能名称】
     * @return 结果
     */
    public int insertCsafeTimeconfig(CsafeTimeconfig csafeTimeconfig);

    /**
     * 修改【请填写功能名称】
     * 
     * @param csafeTimeconfig 【请填写功能名称】
     * @return 结果
     */
    public int updateCsafeTimeconfig(CsafeTimeconfig csafeTimeconfig);

    /**
     * 删除【请填写功能名称】
     * 
     * @param configName 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCsafeTimeconfigById(String configName);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param configNames 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafeTimeconfigByIds(String[] configNames);
}
