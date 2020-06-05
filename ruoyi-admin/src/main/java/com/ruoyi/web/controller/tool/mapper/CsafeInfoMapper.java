package com.ruoyi.web.controller.tool.mapper;

import java.util.List;
import com.ruoyi.web.controller.tool.entity.CsafeInfo;

/**
 * 综合信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
public interface CsafeInfoMapper 
{
    /**
     * 查询综合信息
     * 
     * @param infoId 综合信息ID
     * @return 综合信息
     */
    public CsafeInfo selectCsafeInfoById(Long infoId);

    /**
     * 查询综合信息列表
     * 
     * @param csafeInfo 综合信息
     * @return 综合信息集合
     */
    public List<CsafeInfo> selectCsafeInfoList(CsafeInfo csafeInfo);

    /**
     * 新增综合信息
     * 
     * @param csafeInfo 综合信息
     * @return 结果
     */
    public int insertCsafeInfo(CsafeInfo csafeInfo);

    /**
     * 修改综合信息
     * 
     * @param csafeInfo 综合信息
     * @return 结果
     */
    public int updateCsafeInfo(CsafeInfo csafeInfo);

    /**
     * 删除综合信息
     * 
     * @param infoId 综合信息ID
     * @return 结果
     */
    public int deleteCsafeInfoById(Long infoId);

    /**
     * 批量删除综合信息
     * 
     * @param infoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafeInfoByIds(String[] infoIds);
}
