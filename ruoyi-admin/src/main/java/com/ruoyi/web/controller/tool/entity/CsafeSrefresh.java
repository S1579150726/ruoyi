package com.ruoyi.web.controller.tool.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 csafe_srefresh
 * 
 * @author ruoyi
 * @date 2020-06-05
 */
public class CsafeSrefresh extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long screenid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String screenurl;

    /** 跳转时间 */
    @Excel(name = "跳转时间")
    private Long screentime;

    public void setScreenid(Long screenid) 
    {
        this.screenid = screenid;
    }

    public Long getScreenid() 
    {
        return screenid;
    }
    public void setScreenurl(String screenurl) 
    {
        this.screenurl = screenurl;
    }

    public String getScreenurl() 
    {
        return screenurl;
    }
    public void setScreentime(Long screentime) 
    {
        this.screentime = screentime;
    }

    public Long getScreentime() 
    {
        return screentime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("screenid", getScreenid())
            .append("screenurl", getScreenurl())
            .append("screentime", getScreentime())
            .toString();
    }
}
