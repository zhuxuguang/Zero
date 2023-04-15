package com.zero.system.k3cloud.k3Material.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 存储第三方物料类别信息对象 k3_bd_materialcategory
 * 
 * @author zhuxuguang
 * @date 2023-03-30
 */
public class K3BdMaterialcategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 物料类别内码 */
    @Excel(name = "物料类别内码")
    private Long fcateGoryid;

    /** 物料类别编码 */
    @Excel(name = "物料类别编码")
    private String fnumber;

    /** 物料类别名称 */
    @Excel(name = "物料类别名称")
    private String fname;

    /** 数据状态 */
    @Excel(name = "数据状态")
    private String fforbidStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFcateGoryid(Long fcateGoryid) 
    {
        this.fcateGoryid = fcateGoryid;
    }

    public Long getFcateGoryid() 
    {
        return fcateGoryid;
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
            .append("fcateGoryid", getFcateGoryid())
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
