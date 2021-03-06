package com.ruoyi.web.controller.tool.mapper;

import com.ruoyi.web.controller.tool.entity.CsafeVideo;

import java.util.List;

/**
 * 视频字典Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public interface CsafeVideoMapper 
{
    /**
     * 查询视频字典
     * 
     * @param vedioId 视频字典ID
     * @return 视频字典
     */
    public CsafeVideo selectCsafeVideoById(Long vedioId);

    /**
     * 查询视频字典列表
     * 
     * @param csafeVideo 视频字典
     * @return 视频字典集合
     */
    public List<CsafeVideo> selectCsafeVideoList(CsafeVideo csafeVideo);

    /**
     * 新增视频字典
     * 
     * @param csafeVideo 视频字典
     * @return 结果
     */
    public int insertCsafeVideo(CsafeVideo csafeVideo);

    /**
     * 修改视频字典
     * 
     * @param csafeVideo 视频字典
     * @return 结果
     */
    public int updateCsafeVideo(CsafeVideo csafeVideo);

    /**
     * 删除视频字典
     * 
     * @param vedioId 视频字典ID
     * @return 结果
     */
    public int deleteCsafeVideoById(Long vedioId);

    /**
     * 批量删除视频字典
     * 
     * @param vedioIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafeVideoByIds(String[] vedioIds);
}
