package com.ruoyi.web.controller.tool.service;

import java.util.List;
import com.ruoyi.web.controller.tool.entity.CsafeTimeconfig;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
public interface ICsafeTimeconfigService 
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
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafeTimeconfigByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param configName 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCsafeTimeconfigById(String configName);
}
