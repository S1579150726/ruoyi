package com.ruoyi.web.controller.tool.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 【请填写功能名称】对象 csafe_timeconfig
 * 
 * @author ruoyi
 * @date 2020-06-04
 */
public class CsafeTimeconfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 接口配置名称 */
    @Excel(name = "接口配置名称")
    private String configName;

    /** 跳转时间(毫秒) */
    @Excel(name = "跳转时间(毫秒)")
    private Integer configTimeinterval;

    /** 接口配置名称缩写 */
    @Excel(name = "接口配置名称缩写")
    private String code;

    /** 创建日期 */
    @Excel(name = "创建日期 ")
    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setConfigName(String configName)
    {
        this.configName = configName;
    }

    public String getConfigName() 
    {
        return configName;
    }
    public void setConfigTimeinterval(Integer configTimeinterval) 
    {
        this.configTimeinterval = configTimeinterval;
    }

    public Integer getConfigTimeinterval() 
    {
        return configTimeinterval;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("configName", getConfigName())
            .append("configTimeinterval", getConfigTimeinterval())
            .append("code", getCode())
            .append("createtime", getCreatetime())
            .toString();
    }
}
