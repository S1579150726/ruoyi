package com.ruoyi.web.controller.tool.service.impl;

import java.util.List;

import com.ruoyi.web.controller.tool.entity.CsafeInfo;
import com.ruoyi.web.controller.tool.mapper.CsafeInfoMapper;
import com.ruoyi.web.controller.tool.service.ICsafeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 综合信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
@Service
public class CsafeInfoServiceImpl implements ICsafeInfoService
{
    @Autowired
    private CsafeInfoMapper csafeInfoMapper;

    /**
     * 查询综合信息
     * 
     * @param infoId 综合信息ID
     * @return 综合信息
     */
    @Override
    public CsafeInfo selectCsafeInfoById(Long infoId)
    {
        return csafeInfoMapper.selectCsafeInfoById(infoId);
    }

    /**
     * 查询综合信息列表
     * 
     * @param csafeInfo 综合信息
     * @return 综合信息
     */
    @Override
    public List<CsafeInfo> selectCsafeInfoList(CsafeInfo csafeInfo)
    {
        return csafeInfoMapper.selectCsafeInfoList(csafeInfo);
    }

    /**
     * 新增综合信息
     * 
     * @param csafeInfo 综合信息
     * @return 结果
     */
    @Override
    public int insertCsafeInfo(CsafeInfo csafeInfo)
    {
        return csafeInfoMapper.insertCsafeInfo(csafeInfo);
    }

    /**
     * 修改综合信息
     * 
     * @param csafeInfo 综合信息
     * @return 结果
     */
    @Override
    public int updateCsafeInfo(CsafeInfo csafeInfo)
    {
        return csafeInfoMapper.updateCsafeInfo(csafeInfo);
    }

    /**
     * 删除综合信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCsafeInfoByIds(String ids)
    {
        return csafeInfoMapper.deleteCsafeInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除综合信息信息
     * 
     * @param infoId 综合信息ID
     * @return 结果
     */
    @Override
    public int deleteCsafeInfoById(Long infoId)
    {
        return csafeInfoMapper.deleteCsafeInfoById(infoId);
    }
}
