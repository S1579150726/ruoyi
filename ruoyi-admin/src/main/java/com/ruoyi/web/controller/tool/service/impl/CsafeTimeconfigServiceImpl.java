package com.ruoyi.web.controller.tool.service.impl;

import java.util.List;

import com.ruoyi.web.controller.tool.entity.CsafeTimeconfig;
import com.ruoyi.web.controller.tool.mapper.CsafeTimeconfigMapper;
import com.ruoyi.web.controller.tool.service.ICsafeTimeconfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
@Service
public class CsafeTimeconfigServiceImpl implements ICsafeTimeconfigService
{
    @Autowired
    private CsafeTimeconfigMapper csafeTimeconfigMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param configName 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public CsafeTimeconfig selectCsafeTimeconfigById(String configName)
    {
        return csafeTimeconfigMapper.selectCsafeTimeconfigById(configName);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param csafeTimeconfig 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CsafeTimeconfig> selectCsafeTimeconfigList(CsafeTimeconfig csafeTimeconfig)
    {
        return csafeTimeconfigMapper.selectCsafeTimeconfigList(csafeTimeconfig);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param csafeTimeconfig 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCsafeTimeconfig(CsafeTimeconfig csafeTimeconfig)
    {
        return csafeTimeconfigMapper.insertCsafeTimeconfig(csafeTimeconfig);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param csafeTimeconfig 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCsafeTimeconfig(CsafeTimeconfig csafeTimeconfig)
    {
        return csafeTimeconfigMapper.updateCsafeTimeconfig(csafeTimeconfig);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCsafeTimeconfigByIds(String ids)
    {
        return csafeTimeconfigMapper.deleteCsafeTimeconfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param configName 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCsafeTimeconfigById(String configName)
    {
        return csafeTimeconfigMapper.deleteCsafeTimeconfigById(configName);
    }
}
