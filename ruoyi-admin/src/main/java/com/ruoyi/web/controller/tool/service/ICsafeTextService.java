package com.ruoyi.web.controller.tool.service;

import java.util.List;
import com.ruoyi.web.controller.tool.entity.CsafeText;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-06-02
 */
public interface ICsafeTextService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param textId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CsafeText selectCsafeTextById(Long textId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param csafeText 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CsafeText> selectCsafeTextList(CsafeText csafeText);

    /**
     * 新增【请填写功能名称】
     * 
     * @param csafeText 【请填写功能名称】
     * @return 结果
     */
    public int insertCsafeText(CsafeText csafeText);

    /**
     * 修改【请填写功能名称】
     * 
     * @param csafeText 【请填写功能名称】
     * @return 结果
     */
    public int updateCsafeText(CsafeText csafeText);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafeTextByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param textId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCsafeTextById(Long textId);
}
