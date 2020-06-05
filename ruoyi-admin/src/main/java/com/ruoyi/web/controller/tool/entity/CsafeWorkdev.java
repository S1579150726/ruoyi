package com.ruoyi.web.controller.tool.entity;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 工作动态对象 csafe_workdev
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public class CsafeWorkdev extends BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 工作动态id */
    private Long wdevId;

    /** 工作动态日期 */
    @Excel(name = "工作动态日期", width = 30, dateFormat = "MM-dd")
    private Date wdevDate;


    /** 工作动态内容 */
    @Excel(name = "工作动态内容")
    private String wdevContent;

    public void setWdevId(Long wdevId) 
    {
        this.wdevId = wdevId;
    }

    public Long getWdevId() 
    {
        return wdevId;
    }
    public void setWdevDate(Date wdevDate) 
    {
        this.wdevDate = wdevDate;
    }

    public Date getWdevDate() 
    {
        return wdevDate;
    }
    public void setWdevContent(String wdevContent)
    {
        this.wdevContent = wdevContent;
    }

    public String getWdevContent()
    {
        return wdevContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wdevId", getWdevId())
            .append("wdevDate", getWdevDate())
            .append("wdevContent", getWdevContent())
            .toString();
    }
}
