package com.zero.system.cb.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 人工对象 cb_artificial
 * 
 * @author zhuxuguang
 * @date 2023-02-06
 */
public class CbArtificial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 年 */
    @Excel(name = "年")
    private String cbYear;

    /** 月 */
    @Excel(name = "月")
    private String cbMonth;

    /** 公司ID */
    @Excel(name = "公司ID")
    private Long companyId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 场别id */
    @Excel(name = "场别id")
    private Long hoggeryId;

    /** 场别名称 */
    @Excel(name = "场别名称")
    private String hoggeryName;

    /** 费用属性 */
    @Excel(name = "费用属性")
    private String costAttribute;

    /** 费用类型 */
    @Excel(name = "费用类型")
    private String cosTypes;

    /** 人数 */
    @Excel(name = "人数")
    private Long population;

    /** 计提金额 */
    @Excel(name = "计提金额")
    private Long amountWithdrawn;

    /** 备注 */
    @Excel(name = "备注")
    private String remark;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCbYear(String cbYear) 
    {
        this.cbYear = cbYear;
    }

    public String getCbYear() 
    {
        return cbYear;
    }
    public void setCbMonth(String cbMonth) 
    {
        this.cbMonth = cbMonth;
    }

    public String getCbMonth() 
    {
        return cbMonth;
    }
    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setHoggeryId(Long hoggeryId) 
    {
        this.hoggeryId = hoggeryId;
    }

    public Long getHoggeryId() 
    {
        return hoggeryId;
    }
    public void setHoggeryName(String hoggeryName) 
    {
        this.hoggeryName = hoggeryName;
    }

    public String getHoggeryName() 
    {
        return hoggeryName;
    }
    public void setCostAttribute(String costAttribute) 
    {
        this.costAttribute = costAttribute;
    }

    public String getCostAttribute() 
    {
        return costAttribute;
    }
    public void setCosTypes(String cosTypes) 
    {
        this.cosTypes = cosTypes;
    }

    public String getCosTypes() 
    {
        return cosTypes;
    }
    public void setPopulation(Long population) 
    {
        this.population = population;
    }

    public Long getPopulation() 
    {
        return population;
    }
    public void setAmountWithdrawn(Long amountWithdrawn) 
    {
        this.amountWithdrawn = amountWithdrawn;
    }

    public Long getAmountWithdrawn() 
    {
        return amountWithdrawn;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cbYear", getCbYear())
            .append("cbMonth", getCbMonth())
            .append("companyId", getCompanyId())
            .append("companyName", getCompanyName())
            .append("hoggeryId", getHoggeryId())
            .append("hoggeryName", getHoggeryName())
            .append("costAttribute", getCostAttribute())
            .append("cosTypes", getCosTypes())
            .append("population", getPopulation())
            .append("amountWithdrawn", getAmountWithdrawn())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
