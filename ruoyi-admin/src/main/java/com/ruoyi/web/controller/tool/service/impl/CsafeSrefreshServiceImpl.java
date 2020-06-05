package com.ruoyi.web.controller.tool.service.impl;

import java.util.List;

import com.ruoyi.web.controller.tool.entity.CsafeSrefresh;
import com.ruoyi.web.controller.tool.mapper.CsafeSrefreshMapper;
import com.ruoyi.web.controller.tool.service.ICsafeSrefreshService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-06-05
 */
@Service
public class CsafeSrefreshServiceImpl implements ICsafeSrefreshService
{
    @Autowired
    private CsafeSrefreshMapper csafeSrefreshMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param screenid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public CsafeSrefresh selectCsafeSrefreshById(Long screenid)
    {
        return csafeSrefreshMapper.selectCsafeSrefreshById(screenid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param csafeSrefresh 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<CsafeSrefresh> selectCsafeSrefreshList(CsafeSrefresh csafeSrefresh)
    {
        return csafeSrefreshMapper.selectCsafeSrefreshList(csafeSrefresh);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param csafeSrefresh 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCsafeSrefresh(CsafeSrefresh csafeSrefresh)
    {
        return csafeSrefreshMapper.insertCsafeSrefresh(csafeSrefresh);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param csafeSrefresh 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCsafeSrefresh(CsafeSrefresh csafeSrefresh)
    {
        return csafeSrefreshMapper.updateCsafeSrefresh(csafeSrefresh);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCsafeSrefreshByIds(String ids)
    {
        return csafeSrefreshMapper.deleteCsafeSrefreshByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param screenid 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCsafeSrefreshById(Long screenid)
    {
        return csafeSrefreshMapper.deleteCsafeSrefreshById(screenid);
    }
}
