package com.ruoyi.web.controller.tool.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 水位图形下标文字对象 csafe_watertext
 * 
 * @author ruoyi
 * @date 2020-06-01
 */
public class CsafeWatertext 
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String waterText;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setWaterText(String waterText) 
    {
        this.waterText = waterText;
    }

    public String getWaterText() 
    {
        return waterText;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("waterText", getWaterText())
            .toString();
    }
}
