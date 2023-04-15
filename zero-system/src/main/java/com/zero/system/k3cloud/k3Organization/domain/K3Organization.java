package com.zero.system.k3cloud.k3Organization.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 存储第三方组织信息对象 k3_organization
 *
 * @author zhuxuguang
 * @date 2023-03-30
 */
public class K3Organization extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 组织内码 */
    @Excel(name = "组织内码")
    private Long forgid;

    /** 组织编码 */
    @Excel(name = "组织编码")
    private String fnumber;

    /** 组织名称 */
    @Excel(name = "组织名称")
    private String fname;

    /** 禁用状态 */
    @Excel(name = "禁用状态")
    private String fforbidStatus;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setForgid(Long forgid)
    {
        this.forgid = forgid;
    }

    public Long getForgid()
    {
        return forgid;
    }
    public void setFnumber(String fnumber)
    {
        this.fnumber = fnumber;
    }

    public String getFnumber()
    {
        return fnumber;
    }
    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getFname()
    {
        return fname;
    }
    public void setFforbidStatus(String fforbidStatus)
    {
        this.fforbidStatus = fforbidStatus;
    }

    public String getFforbidStatus()
    {
        return fforbidStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("forgid", getForgid())
                .append("fnumber", getFnumber())
                .append("fname", getFname())
                .append("fforbidStatus", getFforbidStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
