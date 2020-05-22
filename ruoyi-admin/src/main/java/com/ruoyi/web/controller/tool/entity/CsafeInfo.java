package com.ruoyi.web.controller.tool.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 * 综合信息对象 csafe_info
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public class CsafeInfo implements Serializable
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("infoId", getInfoId())
            .append("infoLabel", getInfoLabel())
            .append("infoValue", getInfoValue())
            .toString();
    }
}
