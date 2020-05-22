package com.ruoyi.web.controller.tool.service.impl;

import java.util.List;

import com.ruoyi.web.controller.tool.entity.CsafeVideo;
import com.ruoyi.web.controller.tool.mapper.CsafeVideoMapper;
import com.ruoyi.web.controller.tool.service.ICsafeVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 视频字典Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Service
public class CsafeVideoServiceImpl implements ICsafeVideoService
{
    @Autowired
    private CsafeVideoMapper csafeVideoMapper;

    /**
     * 查询视频字典
     * 
     * @param vedioId 视频字典ID
     * @return 视频字典
     */
    @Override
    public CsafeVideo selectCsafeVideoById(Long vedioId)
    {
        return csafeVideoMapper.selectCsafeVideoById(vedioId);
    }

    /**
     * 查询视频字典列表
     * 
     * @param csafeVideo 视频字典
     * @return 视频字典
     */
    @Override
    public List<CsafeVideo> selectCsafeVideoList(CsafeVideo csafeVideo)
    {
        return csafeVideoMapper.selectCsafeVideoList(csafeVideo);
    }


    /**
     * 新增视频字典
     * 
     * @param csafeVideo 视频字典
     * @return 结果
     */
    @Override
    public int insertCsafeVideo(CsafeVideo csafeVideo)
    {
        return csafeVideoMapper.insertCsafeVideo(csafeVideo);
    }

    /**
     * 修改视频字典
     * 
     * @param csafeVideo 视频字典
     * @return 结果
     */
    @Override
    public int updateCsafeVideo(CsafeVideo csafeVideo)
    {
        return csafeVideoMapper.updateCsafeVideo(csafeVideo);
    }

    /**
     * 删除视频字典对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCsafeVideoByIds(String ids)
    {
        return csafeVideoMapper.deleteCsafeVideoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除视频字典信息
     * 
     * @param vedioId 视频字典ID
     * @return 结果
     */
    @Override
    public int deleteCsafeVideoById(Long vedioId)
    {
        return csafeVideoMapper.deleteCsafeVideoById(vedioId);
    }
}
