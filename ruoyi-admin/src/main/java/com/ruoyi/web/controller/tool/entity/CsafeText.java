package com.ruoyi.web.controller.tool.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 csafe_text
 * 
 * @author ruoyi
 * @date 2020-06-02
 */
public class CsafeText
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long textId;

    /** 顶部文字 */
    @Excel(name = "顶部文字")
    private String textLable;

    /** 水位图底部文字 */
    @Excel(name = "水位图底部文字")
    private String textValue;

    /** 是否滚动，1表示滚动，0表示不滚动 */
    @Excel(name = "是否滚动，1表示滚动，0表示不滚动")
    private Integer isscroll;

    public void setTextId(Long textId) 
    {
        this.textId = textId;
    }

    public Long getTextId() 
    {
        return textId;
    }
    public void setTextLable(String textLable) 
    {
        this.textLable = textLable;
    }

    public String getTextLable() 
    {
        return textLable;
    }
    public void setTextValue(String textValue) 
    {
        this.textValue = textValue;
    }

    public String getTextValue() 
    {
        return textValue;
    }
    public void setIsscroll(Integer isscroll)
    {
        this.isscroll = isscroll;
    }

    public Integer getIsscroll()
    {
        return isscroll;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("textId", getTextId())
            .append("textLable", getTextLable())
            .append("textValue", getTextValue())
            .append("isscroll", getIsscroll())
            .toString();
    }
}
