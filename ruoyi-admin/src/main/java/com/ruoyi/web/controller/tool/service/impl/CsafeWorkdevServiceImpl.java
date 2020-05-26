package com.ruoyi.web.controller.tool.service.impl;

import java.util.List;

import com.ruoyi.common.utils.bean.Query;
import com.ruoyi.web.controller.tool.entity.CsafeWorkdev;
import com.ruoyi.web.controller.tool.mapper.CsafeWorkdevMapper;
import com.ruoyi.web.controller.tool.service.ICsafeWorkdevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 工作动态Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Service
public class CsafeWorkdevServiceImpl implements ICsafeWorkdevService
{
    @Autowired
    private CsafeWorkdevMapper csafeWorkdevMapper;

    /**
     * 查询工作动态
     * 
     * @param wdevId 工作动态ID
     * @return 工作动态
     */
    @Override
    public CsafeWorkdev selectCsafeWorkdevById(Long wdevId)
    {
        return csafeWorkdevMapper.selectCsafeWorkdevById(wdevId);
    }

    /**
     * 查询工作动态列表
     * 
     * @param csafeWorkdev 工作动态
     * @return 工作动态
     */
    @Override
    public List<CsafeWorkdev> selectCsafeWorkdevList(CsafeWorkdev csafeWorkdev)
    {
        return csafeWorkdevMapper.selectCsafeWorkdevList(csafeWorkdev);
    }

    @Override
    public List<CsafeWorkdev> page(Query query) {
        return csafeWorkdevMapper.page(query);
    }

    /**
     * 新增工作动态
     * 
     * @param csafeWorkdev 工作动态
     * @return 结果
     */
    @Override
    public int insertCsafeWorkdev(CsafeWorkdev csafeWorkdev)
    {
        return csafeWorkdevMapper.insertCsafeWorkdev(csafeWorkdev);
    }

    /**
     * 修改工作动态
     * 
     * @param csafeWorkdev 工作动态
     * @return 结果
     */
    @Override
    public int updateCsafeWorkdev(CsafeWorkdev csafeWorkdev)
    {
        return csafeWorkdevMapper.updateCsafeWorkdev(csafeWorkdev);
    }

    /**
     * 删除工作动态对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCsafeWorkdevByIds(String ids)
    {
        return csafeWorkdevMapper.deleteCsafeWorkdevByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工作动态信息
     * 
     * @param wdevId 工作动态ID
     * @return 结果
     */
    @Override
    public int deleteCsafeWorkdevById(Long wdevId)
    {
        return csafeWorkdevMapper.deleteCsafeWorkdevById(wdevId);
    }
}
