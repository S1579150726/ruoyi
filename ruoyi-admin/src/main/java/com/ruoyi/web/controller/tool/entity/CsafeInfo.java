package com.ruoyi.web.controller.tool.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 综合信息对象 csafe_info
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
public class CsafeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 信息编号 */
    private Long infoId;

    /** 信息标题 */
    @Excel(name = "信息标题")
    private String infoLabel;

    /** 信息详细内容 */
    @Excel(name = "信息详细内容")
    private String infoValue;

    /** 信息标题英文名 */
    @Excel(name = "信息标题英文名")
    private String infoCode;

    /** 信息单位 */
    @Excel(name = "信息单位")
    private String infoUnit;

    public void setInfoId(Long infoId) 
    {
        this.infoId = infoId;
    }

    public Long getInfoId() 
    {
        return infoId;
    }
    public void setInfoLabel(String infoLabel) 
    {
        this.infoLabel = infoLabel;
    }

    public String getInfoLabel() 
    {
        return infoLabel;
    }
    public void setInfoValue(String infoValue) 
    {
        this.infoValue = infoValue;
    }

    public String getInfoValue() 
    {
        return infoValue;
    }
    public void setInfoCode(String infoCode) 
    {
        this.infoCode = infoCode;
    }

    public String getInfoCode() 
    {
        return infoCode;
    }
    public void setInfoUnit(String infoUnit) 
    {
        this.infoUnit = infoUnit;
    }

    public String getInfoUnit() 
    {
        return infoUnit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("infoId", getInfoId())
            .append("infoLabel", getInfoLabel())
            .append("infoValue", getInfoValue())
            .append("infoCode", getInfoCode())
            .append("infoUnit", getInfoUnit())
            .toString();
    }
}
