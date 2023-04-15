package com.zero.system.cb.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 费用明细对象 cb_expense_detail
 *
 * @author zhuxuguang
 * @date 2023-01-27
 */
public class CbExpenseDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 单据编号 */
    @Excel(name = "单据编号")
    private String documentCode;

    /** 年 */
    @Excel(name = "年")
    private String cbYear;

    /** 月 */
    @Excel(name = "月")
    private String cbMonth;


    /** 事由 */
    @Excel(name = "事由")
    private String cause;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date businessDate;

    /** 申请人 */
    @Excel(name = "申请人")
    private String petitioner;

    /** 申请部门ID */
    @Excel(name = "申请部门ID")
    private Long petitionerDepartmentId;

    /** 申请部门 */
    @Excel(name = "申请部门")
    private String petitionerDepartmentName;

    /** 申请组织ID */
    @Excel(name = "申请组织ID")
    private Long petitionerOrganizationId;

    /** 申请组织 */
    @Excel(name = "申请组织")
    private String petitionerOrganizationName;

    /** 来往类型 */
    @Excel(name = "退款/付款")
    private String typeOfTraffic;

    /** 申请报销金额汇总 */
    @Excel(name = "申请报销金额汇总")
    private BigDecimal reimburseAmountSummary;

    /** 费用项目 */
    @Excel(name = "费用项目")
    private String expenseItem;

    /** 申请退付款金额汇总 */
    @Excel(name = "申请退付款金额汇总")
    private BigDecimal tefundOfPaymentCollect;

    /** 单据状态 */
    @Excel(name = "单据状态")
    private String documentStatus;

    /** 费用承担组织id */
    @Excel(name = "费用承担组织ID")
    private Long costBearingOrganizationId;

    /** 费用承担组织 */
    @Excel(name = "费用承担组织")
    private String costBearingOrganization;

    /** 审核人 */
    @Excel(name = "审核人")
    private String auditor;

    /** 已付款金额 */
    @Excel(name = "已付款金额")
    private BigDecimal amountPaid;

    /** 已退款金额 */
    @Excel(name = "已退款金额")
    private BigDecimal amountRefunded;

    /** 创建人 */
    @Excel(name = "创建人")
    private String founder;

    /** 费用大类 */
    @Excel(name = "费用大类")
    private String categoriesOfExpenses;

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
    public void setDocumentCode(String documentCode)
    {
        this.documentCode = documentCode;
    }

    public String getDocumentCode()
    {
        return documentCode;
    }
    public void setCause(String cause)
    {
        this.cause = cause;
    }

    public String getCause()
    {
        return cause;
    }
    public void setBusinessDate(Date businessDate)
    {
        this.businessDate = businessDate;
    }

    public Date getBusinessDate()
    {
        return businessDate;
    }
    public void setPetitioner(String petitioner)
    {
        this.petitioner = petitioner;
    }

    public String getPetitioner()
    {
        return petitioner;
    }
    public void setPetitionerDepartmentId(Long petitionerDepartmentId)
    {
        this.petitionerDepartmentId = petitionerDepartmentId;
    }

    public Long getPetitionerDepartmentId()
    {
        return petitionerDepartmentId;
    }
    public void setPetitionerDepartmentName(String petitionerDepartmentName)
    {
        this.petitionerDepartmentName = petitionerDepartmentName;
    }

    public String getPetitionerDepartmentName()
    {
        return petitionerDepartmentName;
    }
    public void setPetitionerOrganizationId(Long petitionerOrganizationId)
    {
        this.petitionerOrganizationId = petitionerOrganizationId;
    }

    public Long getPetitionerOrganizationId()
    {
        return petitionerOrganizationId;
    }
    public void setPetitionerOrganizationName(String petitionerOrganizationName)
    {
        this.petitionerOrganizationName = petitionerOrganizationName;
    }

    public String getPetitionerOrganizationName()
    {
        return petitionerOrganizationName;
    }
    public void setTypeOfTraffic(String typeOfTraffic)
    {
        this.typeOfTraffic = typeOfTraffic;
    }

    public String getTypeOfTraffic()
    {
        return typeOfTraffic;
    }
    public void setReimburseAmountSummary(BigDecimal reimburseAmountSummary)
    {
        this.reimburseAmountSummary = reimburseAmountSummary;
    }

    public BigDecimal getReimburseAmountSummary()
    {
        return reimburseAmountSummary;
    }
    public void setExpenseItem(String expenseItem)
    {
        this.expenseItem = expenseItem;
    }

    public String getExpenseItem()
    {
        return expenseItem;
    }
    public void setTefundOfPaymentCollect(BigDecimal tefundOfPaymentCollect)
    {
        this.tefundOfPaymentCollect = tefundOfPaymentCollect;
    }

    public BigDecimal getTefundOfPaymentCollect()
    {
        return tefundOfPaymentCollect;
    }
    public void setDocumentStatus(String documentStatus)
    {
        this.documentStatus = documentStatus;
    }

    public String getDocumentStatus()
    {
        return documentStatus;
    }
    public void setCostBearingOrganizationId(Long costBearingOrganizationId)
    {
        this.costBearingOrganizationId = costBearingOrganizationId;
    }

    public Long getCostBearingOrganizationId()
    {
        return costBearingOrganizationId;
    }
    public void setCostBearingOrganization(String costBearingOrganization)
    {
        this.costBearingOrganization = costBearingOrganization;
    }

    public String getCostBearingOrganization()
    {
        return costBearingOrganization;
    }
    public void setAuditor(String auditor)
    {
        this.auditor = auditor;
    }

    public String getAuditor()
    {
        return auditor;
    }
    public void setAmountPaid(BigDecimal amountPaid)
    {
        this.amountPaid = amountPaid;
    }

    public BigDecimal getAmountPaid()
    {
        return amountPaid;
    }
    public void setAmountRefunded(BigDecimal amountRefunded)
    {
        this.amountRefunded = amountRefunded;
    }

    public BigDecimal getAmountRefunded()
    {
        return amountRefunded;
    }
    public void setFounder(String founder)
    {
        this.founder = founder;
    }

    public String getFounder()
    {
        return founder;
    }
    public void setCategoriesOfExpenses(String categoriesOfExpenses)
    {
        this.categoriesOfExpenses = categoriesOfExpenses;
    }

    public String getCategoriesOfExpenses()
    {
        return categoriesOfExpenses;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("cbYear", getCbYear())
                .append("cbMonth", getCbMonth())
                .append("documentCode", getDocumentCode())
                .append("cause", getCause())
                .append("businessDate", getBusinessDate())
                .append("petitioner", getPetitioner())
                .append("petitionerDepartmentId", getPetitionerDepartmentId())
                .append("petitionerDepartmentName", getPetitionerDepartmentName())
                .append("petitionerOrganizationId", getPetitionerOrganizationId())
                .append("petitionerOrganizationName", getPetitionerOrganizationName())
                .append("typeOfTraffic", getTypeOfTraffic())
                .append("reimburseAmountSummary", getReimburseAmountSummary())
                .append("expenseItem", getExpenseItem())
                .append("tefundOfPaymentCollect", getTefundOfPaymentCollect())
                .append("documentStatus", getDocumentStatus())
                .append("costBearingOrganizationId", getCostBearingOrganizationId())
                .append("costBearingOrganization", getCostBearingOrganization())
                .append("auditor", getAuditor())
                .append("amountPaid", getAmountPaid())
                .append("amountRefunded", getAmountRefunded())
                .append("founder", getFounder())
                .append("categoriesOfExpenses", getCategoriesOfExpenses())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}