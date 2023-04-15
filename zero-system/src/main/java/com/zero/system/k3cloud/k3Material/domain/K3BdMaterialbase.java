package com.zero.system.k3cloud.k3Material.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 存储物料信息对象 k3_bd_materialbase
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
public class K3BdMaterialbase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 物料内码 */
    @Excel(name = "物料内码")
    private Long fmaterialId;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String fnumber;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String fname;

    /** 存货类别ID */
    @Excel(name = "存货类别ID")
    private Long fcategoryId;

    /** 存货类别名称 */
    @Excel(name = "存货类别名称")
    private String fcategoryName;

    /** 创建组织ID */
    @Excel(name = "创建组织ID")
    private Long fcreateorgId;

    /** 创建组织名称 */
    @Excel(name = "创建组织名称")
    private String fcreateorgName;

    /** 使用组织ID */
    @Excel(name = "使用组织ID")
    private Long fuseorgId;

    /** 使用组织名称 */
    @Excel(name = "使用组织名称")
    private String fuseorgName;

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
    public void setFmaterialId(Long fmaterialId) 
    {
        this.fmaterialId = fmaterialId;
    }

    public Long getFmaterialId() 
    {
        return fmaterialId;
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
    public void setFcategoryId(Long fcategoryId) 
    {
        this.fcategoryId = fcategoryId;
    }

    public Long getFcategoryId() 
    {
        return fcategoryId;
    }
    public void setFcategoryName(String fcategoryName) 
    {
        this.fcategoryName = fcategoryName;
    }

    public String getFcategoryName() 
    {
        return fcategoryName;
    }
    public void setFcreateorgId(Long fcreateorgId) 
    {
        this.fcreateorgId = fcreateorgId;
    }

    public Long getFcreateorgId() 
    {
        return fcreateorgId;
    }
    public void setFcreateorgName(String fcreateorgName) 
    {
        this.fcreateorgName = fcreateorgName;
    }

    public String getFcreateorgName() 
    {
        return fcreateorgName;
    }
    public void setFuseorgId(Long fuseorgId) 
    {
        this.fuseorgId = fuseorgId;
    }

    public Long getFuseorgId() 
    {
        return fuseorgId;
    }
    public void setFuseorgName(String fuseorgName) 
    {
        this.fuseorgName = fuseorgName;
    }

    public String getFuseorgName() 
    {
        return fuseorgName;
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
            .append("fmaterialId", getFmaterialId())
            .append("fnumber", getFnumber())
            .append("fname", getFname())
            .append("fcategoryId", getFcategoryId())
            .append("fcategoryName", getFcategoryName())
            .append("fcreateorgId", getFcreateorgId())
            .append("fcreateorgName", getFcreateorgName())
            .append("fuseorgId", getFuseorgId())
            .append("fuseorgName", getFuseorgName())
            .append("fforbidStatus", getFforbidStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
