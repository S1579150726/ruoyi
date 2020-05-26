package com.ruoyi.web.controller.tool.service;

import java.util.List;
import com.ruoyi.web.controller.tool.entity.CsafeToptext;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public interface ICsafeToptextService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CsafeToptext selectCsafeToptextById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param csafeToptext 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CsafeToptext> selectCsafeToptextList(CsafeToptext csafeToptext);

    /**
     * 新增【请填写功能名称】
     * 
     * @param csafeToptext 【请填写功能名称】
     * @return 结果
     */
    public int insertCsafeToptext(CsafeToptext csafeToptext);

    /**
     * 修改【请填写功能名称】
     * 
     * @param csafeToptext 【请填写功能名称】
     * @return 结果
     */
    public int updateCsafeToptext(CsafeToptext csafeToptext);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafeToptextByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCsafeToptextById(Integer id);
}
