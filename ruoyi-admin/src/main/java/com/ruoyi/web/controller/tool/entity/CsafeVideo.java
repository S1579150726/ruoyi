package com.ruoyi.web.controller.tool.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 * 视频字典对象 csafe_video
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public class CsafeVideo implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 视频id */
    private Long vedioId;

    /** 视频url */
    @Excel(name = "视频url")
    private String vedioUrl;

    public void setVedioId(Long vedioId) 
    {
        this.vedioId = vedioId;
    }

    public Long getVedioId() 
    {
        return vedioId;
    }
    public void setVedioUrl(String vedioUrl) 
    {
        this.vedioUrl = vedioUrl;
    }

    public String getVedioUrl() 
    {
        return vedioUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("vedioId", getVedioId())
            .append("vedioUrl", getVedioUrl())
            .toString();
    }
}
