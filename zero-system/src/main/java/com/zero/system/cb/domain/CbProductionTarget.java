package com.zero.system.cb.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zero.common.annotation.Excels;
import com.zero.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 生产目标对象 cb_production_target
 * 
 * @author zhuxuguang
 * @date 2023-01-05
 */
public class CbProductionTarget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 场别ID */
    @Excel(name = "场别ID")
    private String fieldId;

    /** 场别名称 */
    @Excel(name = "场别名称")
    private String fieldName;

    /** 年 */
    @Excel(name = "年")
    private String cbYear;

    /** 月 */
    @Excel(name = "月")
    private String cbMonth;

    /** 业务日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "业务日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date businessDate;

    /** 生产指标 */
    @Excel(name = "生产指标")
    private String productionIndex;

    /** 预算 */
    @Excel(name = "预算")
    private BigDecimal budget;

    /** 预算累计 */
    @Excel(name = "预算累计")
    private BigDecimal budgetAccumulative;

    /** 实际 */
    @Excel(name = "实际")
    private BigDecimal practical;

    /** 月度完成率 */
    @Excel(name = "月度完成率")
    private BigDecimal finishingRate;

    /** 实际累计 */
    @Excel(name = "实际累计")
    private BigDecimal actualAccumulation;

    /** 累计完成率 */
    @Excel(name = "累计完成率")
    private BigDecimal cumulativeCompletionRate;

    /** 全年任务完成率 */
    @Excel(name = "全年任务完成率")
    private BigDecimal yearCompletionRate;

    /** 年度目标差异值 */
    @Excel(name = "年度目标差异值")
    private BigDecimal yearTargetVariance;

    /** 备注 */
    @Excel(name = "备注")
    private String remark;

    /** 部门对象 */
//    @Excel(name = "部门名称", targetAttr = "deptName", type = Excel.Type.EXPORT)
    private SysDept dept;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFieldId(String fieldId)
    {
        this.fieldId = fieldId;
    }

    public String getFieldId()
    {
        return fieldId;
    }
    public void setFieldName(String fieldName) 
    {
        this.fieldName = fieldName;
    }

    public String getFieldName() 
    {
        return fieldName;
    }
    public void setBusinessDate(Date businessDate) 
    {
        this.businessDate = businessDate;
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

    public Date getBusinessDate() 
    {
        return businessDate;
    }
    public void setProductionIndex(String productionIndex) 
    {
        this.productionIndex = productionIndex;
    }

    public String getProductionIndex() 
    {
        return productionIndex;
    }
    public void setBudget(BigDecimal budget) 
    {
        this.budget = budget;
    }

    public BigDecimal getBudget() 
    {
        return budget;
    }
    public void setBudgetAccumulative(BigDecimal budgetAccumulative) 
    {
        this.budgetAccumulative = budgetAccumulative;
    }

    public BigDecimal getBudgetAccumulative() 
    {
        return budgetAccumulative;
    }
    public void setPractical(BigDecimal practical) 
    {
        this.practical = practical;
    }

    public BigDecimal getPractical() 
    {
        return practical;
    }
    public void setFinishingRate(BigDecimal finishingRate) 
    {
        this.finishingRate = finishingRate;
    }

    public BigDecimal getFinishingRate() 
    {
        return finishingRate;
    }
    public void setActualAccumulation(BigDecimal actualAccumulation) 
    {
        this.actualAccumulation = actualAccumulation;
    }

    public BigDecimal getActualAccumulation() 
    {
        return actualAccumulation;
    }
    public void setCumulativeCompletionRate(BigDecimal cumulativeCompletionRate) 
    {
        this.cumulativeCompletionRate = cumulativeCompletionRate;
    }

    public BigDecimal getCumulativeCompletionRate() 
    {
        return cumulativeCompletionRate;
    }
    public void setYearCompletionRate(BigDecimal yearCompletionRate) 
    {
        this.yearCompletionRate = yearCompletionRate;
    }

    public BigDecimal getYearCompletionRate() 
    {
        return yearCompletionRate;
    }
    public void setYearTargetVariance(BigDecimal yearTargetVariance) 
    {
        this.yearTargetVariance = yearTargetVariance;
    }

    public BigDecimal getYearTargetVariance() 
    {
        return yearTargetVariance;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public SysDept getDept()
    {
        return dept;
    }

    public void setDept(SysDept dept)
    {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fieldId", getFieldId())
            .append("fieldName", getFieldName())
            .append("cbYear", getCbYear())
            .append("cbMonth", getCbMonth())
            .append("businessDate", getBusinessDate())
            .append("productionIndex", getProductionIndex())
            .append("budget", getBudget())
            .append("budgetAccumulative", getBudgetAccumulative())
            .append("practical", getPractical())
            .append("finishingRate", getFinishingRate())
            .append("actualAccumulation", getActualAccumulation())
            .append("cumulativeCompletionRate", getCumulativeCompletionRate())
            .append("yearCompletionRate", getYearCompletionRate())
            .append("yearTargetVariance", getYearTargetVariance())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dept", getDept())
            .toString();
    }
}
