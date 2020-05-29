package com.ruoyi.web.controller.tool.service.impl;

import java.util.List;

import com.ruoyi.web.controller.tool.entity.CsafeToptext;
import com.ruoyi.web.controller.tool.mapper.CsafeToptextMapper;
import com.ruoyi.web.controller.tool.service.ICsafeToptextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Service
public class CsafeToptextServiceImpl implements ICsafeToptextService
{
    @Autowired
    private CsafeToptextMapper csafeToptextMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public CsafeToptext selectCsafeToptextById(Integer id)
    {
        return csafeToptextMapper.selectCsafeToptextById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param csafeToptext 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CsafeToptext> selectCsafeToptextList(CsafeToptext csafeToptext)
    {
        return csafeToptextMapper.selectCsafeToptextList(csafeToptext);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param csafeToptext 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCsafeToptext(CsafeToptext csafeToptext)
    {
        return csafeToptextMapper.insertCsafeToptext(csafeToptext);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param csafeToptext 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCsafeToptext(CsafeToptext csafeToptext)
    {
        return csafeToptextMapper.updateCsafeToptext(csafeToptext);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCsafeToptextByIds(String ids)
    {
        return csafeToptextMapper.deleteCsafeToptextByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCsafeToptextById(Integer id)
    {
        return csafeToptextMapper.deleteCsafeToptextById(id);
    }
}
