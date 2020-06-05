package com.ruoyi.web.controller.tool.service.impl;

import java.util.List;

import com.ruoyi.web.controller.tool.entity.CsafeText;
import com.ruoyi.web.controller.tool.mapper.CsafeTextMapper;
import com.ruoyi.web.controller.tool.service.ICsafeTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-06-02
 */
@Service
public class CsafeTextServiceImpl implements ICsafeTextService
{
    @Autowired
    private CsafeTextMapper csafeTextMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param textId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public CsafeText selectCsafeTextById(Long textId)
    {
        return csafeTextMapper.selectCsafeTextById(textId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param csafeText 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CsafeText> selectCsafeTextList(CsafeText csafeText)
    {
        return csafeTextMapper.selectCsafeTextList(csafeText);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param csafeText 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCsafeText(CsafeText csafeText)
    {
        return csafeTextMapper.insertCsafeText(csafeText);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param csafeText 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCsafeText(CsafeText csafeText)
    {
        return csafeTextMapper.updateCsafeText(csafeText);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCsafeTextByIds(String ids)
    {
        return csafeTextMapper.deleteCsafeTextByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param textId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCsafeTextById(Long textId)
    {
        return csafeTextMapper.deleteCsafeTextById(textId);
    }
}
