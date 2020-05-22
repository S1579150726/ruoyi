package com.ruoyi.web.controller.tool.service;

import com.ruoyi.common.utils.bean.Query;
import com.ruoyi.web.controller.tool.entity.CsafeInfo;

import java.util.List;

/**
 * 综合信息Service接口
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public interface ICsafeInfoService 
{
    /**
     * 查询综合信息
     * 
     * @param infoId 综合信息ID
     * @return 综合信息
     */
    public CsafeInfo selectCsafeInfoById(Long infoId);
    /*
    * 分页查询
    * */
    public List<CsafeInfo> page(Query query);

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
     * 批量删除综合信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafeInfoByIds(String ids);

    /**
     * 删除综合信息信息
     * 
     * @param infoId 综合信息ID
     * @return 结果
     */
    public int deleteCsafeInfoById(Long infoId);
}
