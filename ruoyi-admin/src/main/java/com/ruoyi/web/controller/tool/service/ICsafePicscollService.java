package com.ruoyi.web.controller.tool.service;

import com.ruoyi.common.utils.bean.Query;
import com.ruoyi.web.controller.tool.entity.CsafePicscoll;

import java.util.List;

/**
 * 图片Service接口
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public interface ICsafePicscollService 
{
    /**
     * 查询图片
     * 
     * @param picId 图片ID
     * @return 图片
     */
    public CsafePicscoll selectCsafePicscollById(Long picId);

    /**
     * 查询图片列表
     * 
     * @param csafePicscoll 图片
     * @return 图片集合
     */
    public List<CsafePicscoll> selectCsafePicscollList(CsafePicscoll csafePicscoll);
    public List<CsafePicscoll> page(Query query);

    /**
     * 新增图片
     * 
     * @param csafePicscoll 图片
     * @return 结果
     */
    public int insertCsafePicscoll(CsafePicscoll csafePicscoll);

    /**
     * 修改图片
     * 
     * @param csafePicscoll 图片
     * @return 结果
     */
    public int updateCsafePicscoll(CsafePicscoll csafePicscoll);

    /**
     * 批量删除图片
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafePicscollByIds(String ids);

    /**
     * 删除图片信息
     * 
     * @param picId 图片ID
     * @return 结果
     */
    public int deleteCsafePicscollById(Long picId);
}
