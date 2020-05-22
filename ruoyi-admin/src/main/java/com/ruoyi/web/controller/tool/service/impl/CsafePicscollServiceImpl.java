package com.ruoyi.web.controller.tool.service.impl;

import java.util.List;

import com.ruoyi.common.utils.bean.Query;
import com.ruoyi.web.controller.tool.entity.CsafePicscoll;
import com.ruoyi.web.controller.tool.mapper.CsafePicscollMapper;
import com.ruoyi.web.controller.tool.service.ICsafePicscollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 图片Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
@Service
public class CsafePicscollServiceImpl implements ICsafePicscollService
{
    @Autowired
    private CsafePicscollMapper csafePicscollMapper;

    /**
     * 查询图片
     * 
     * @param picId 图片ID
     * @return 图片
     */
    @Override
    public CsafePicscoll selectCsafePicscollById(Long picId)
    {
        return csafePicscollMapper.selectCsafePicscollById(picId);
    }

    /**
     * 查询图片列表
     * 
     * @param csafePicscoll 图片
     * @return 图片
     */
    @Override
    public List<CsafePicscoll> selectCsafePicscollList(CsafePicscoll csafePicscoll)
    {
        return csafePicscollMapper.selectCsafePicscollList(csafePicscoll);
    }

    @Override
    public List<CsafePicscoll> page(Query query) {
        return csafePicscollMapper.page(query);
    }

    /**
     * 新增图片
     * 
     * @param csafePicscoll 图片
     * @return 结果
     */
    @Override
    public int insertCsafePicscoll(CsafePicscoll csafePicscoll)
    {
        return csafePicscollMapper.insertCsafePicscoll(csafePicscoll);
    }

    /**
     * 修改图片
     * 
     * @param csafePicscoll 图片
     * @return 结果
     */
    @Override
    public int updateCsafePicscoll(CsafePicscoll csafePicscoll)
    {
        return csafePicscollMapper.updateCsafePicscoll(csafePicscoll);
    }

    /**
     * 删除图片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCsafePicscollByIds(String ids)
    {
        return csafePicscollMapper.deleteCsafePicscollByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除图片信息
     * 
     * @param picId 图片ID
     * @return 结果
     */
    @Override
    public int deleteCsafePicscollById(Long picId)
    {
        return csafePicscollMapper.deleteCsafePicscollById(picId);
    }
}
