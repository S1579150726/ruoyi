package com.ruoyi.web.controller.tool.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 * 图片对象 csafe_picscoll
 * 
 * @author ruoyi
 * @date 2020-05-20
 */
public class CsafePicscoll implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 图片id */
    private Long picId;

    /** 图片url */
    @Excel(name = "图片url")
    private String picUrl;

    public void setPicId(Long picId) 
    {
        this.picId = picId;
    }

    public Long getPicId() 
    {
        return picId;
    }
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("picId", getPicId())
            .append("picUrl", getPicUrl())
            .toString();
    }
}
