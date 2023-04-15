package com.zero.system.k3cloud.k3Organization.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 组织间映射对象 k3_organization_map
 * 
 * @author zhuxuguang
 * @date 2023-04-05
 */
public class K3OrganizationMap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 本地组织ID */
    @Excel(name = "本地组织ID")
    private String deptId;

    /** 部门名称 */
    private String deptName;

    /** 第三方组织内码 */
    @Excel(name = "第三方组织内码")
    private String k3Forgid;

    /** 组织名称 */
    @Excel(name = "组织名称")
    private String fname;

    /** 第三方组织编码 */
    @Excel(name = "第三方组织编码")
    private String k3Fnumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeptId(String deptId) 
    {
        this.deptId = deptId;
    }

    public String getDeptId() 
    {
        return deptId;
    }
    public void setK3Forgid(String k3Forgid) 
    {
        this.k3Forgid = k3Forgid;
    }

    public String getK3Forgid() 
    {
        return k3Forgid;
    }
    public void setK3Fnumber(String k3Fnumber) 
    {
        this.k3Fnumber = k3Fnumber;
    }

    public String getK3Fnumber() 
    {
        return k3Fnumber;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deptId", getDeptId())
                .append("deptName", getDeptName())
            .append("k3Forgid", getK3Forgid())
                .append("fname", getFname())
            .append("k3Fnumber", getK3Fnumber())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
