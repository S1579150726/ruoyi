package com.ruoyi.web.controller.tool.mapper;

import java.util.List;
import com.ruoyi.web.controller.tool.entity.CsafeSrefresh;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-06-05
 */
public interface CsafeSrefreshMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param screenid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public CsafeSrefresh selectCsafeSrefreshById(Long screenid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param csafeSrefresh 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CsafeSrefresh> selectCsafeSrefreshList(CsafeSrefresh csafeSrefresh);

    /**
     * 新增【请填写功能名称】
     * 
     * @param csafeSrefresh 【请填写功能名称】
     * @return 结果
     */
    public int insertCsafeSrefresh(CsafeSrefresh csafeSrefresh);

    /**
     * 修改【请填写功能名称】
     * 
     * @param csafeSrefresh 【请填写功能名称】
     * @return 结果
     */
    public int updateCsafeSrefresh(CsafeSrefresh csafeSrefresh);

    /**
     * 删除【请填写功能名称】
     * 
     * @param screenid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCsafeSrefreshById(Long screenid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param screenids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCsafeSrefreshByIds(String[] screenids);
}
