package com.zero.system.cb.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 租金及摊销对象 cb_rent_and_amortization
 *
 * @author zhuxuguang
 * @date 2023-02-15
 */
public class CbRentAndAmortization extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 源单ID */
    @Excel(name = "源单ID")
    private Long riId;

    /** 年 */
    @Excel(name = "年")
    private String cbYear;

    /** 月 */
    @Excel(name = "月")
    private String cbMonth;

    /** 业务日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "业务日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date businessDate;

    /** 资产名称 */
    @Excel(name = "资产名称")
    private String assetName;

    /** 场别ID */
    @Excel(name = "场别ID")
    private Long hoggeryId;

    /** 场别名称 */
    @Excel(name = "场别名称")
    private String hoggeryName;

    /** 公司ID */
    @Excel(name = "公司ID")
    private Long companyId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 费用类型 */
    @Excel(name = "费用类型")
    private String costTypes;

    /** 资产原值 */
    @Excel(name = "资产原值")
    private BigDecimal initialAssetValue;

    /** 摊销月数 */
    @Excel(name = "摊销月数")
    private String amortizeMonths;

    /** 摊销起始月份 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "摊销起始月份", width = 30, dateFormat = "yyyy-MM-dd")
    private Date amortizeStartMonth;

    /** 摊销结束月份 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "摊销结束月份", width = 30, dateFormat = "yyyy-MM-dd")
    private Date amortizeEndMonth;

    /** 本月摊销金额 */
    @Excel(name = "本月摊销金额")
    private BigDecimal instantAmortizedMoney;

    /** 已摊销月数 */
    @Excel(name = "已摊销月数")
    private String alreadyAmortizedMonths;

    /** 已摊销金额 */
    @Excel(name = "已摊销金额")
    private BigDecimal alreadyAmortizedMoney;

    /** 核算维度 */
    @Excel(name = "核算维度")
    private String dimensionOfAccounting;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 单据状态 */
    @Excel(name = "单据状态")
    private String documentStatus;

    /** 备注 */
    @Excel(name = "备注")
    private String remake;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setRiId(Long riId)
    {
        this.riId = riId;
    }

    public Long getRiId()
    {
        return riId;
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
    public void setBusinessDate(Date businessDate)
    {
        this.businessDate = businessDate;
    }

    public Date getBusinessDate()
    {
        return businessDate;
    }
    public void setAssetName(String assetName)
    {
        this.assetName = assetName;
    }

    public String getAssetName()
    {
        return assetName;
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
    public void setCostTypes(String costTypes)
    {
        this.costTypes = costTypes;
    }

    public String getCostTypes()
    {
        return costTypes;
    }
    public void setInitialAssetValue(BigDecimal initialAssetValue)
    {
        this.initialAssetValue = initialAssetValue;
    }

    public BigDecimal getInitialAssetValue()
    {
        return initialAssetValue;
    }
    public void setAmortizeMonths(String amortizeMonths)
    {
        this.amortizeMonths = amortizeMonths;
    }

    public String getAmortizeMonths()
    {
        return amortizeMonths;
    }
    public void setAmortizeStartMonth(Date amortizeStartMonth)
    {
        this.amortizeStartMonth = amortizeStartMonth;
    }

    public Date getAmortizeStartMonth()
    {
        return amortizeStartMonth;
    }
    public void setAmortizeEndMonth(Date amortizeEndMonth)
    {
        this.amortizeEndMonth = amortizeEndMonth;
    }

    public Date getAmortizeEndMonth()
    {
        return amortizeEndMonth;
    }
    public void setInstantAmortizedMoney(BigDecimal instantAmortizedMoney)
    {
        this.instantAmortizedMoney = instantAmortizedMoney;
    }

    public BigDecimal getInstantAmortizedMoney()
    {
        return instantAmortizedMoney;
    }
    public void setAlreadyAmortizedMonths(String alreadyAmortizedMonths)
    {
        this.alreadyAmortizedMonths = alreadyAmortizedMonths;
    }

    public String getAlreadyAmortizedMonths()
    {
        return alreadyAmortizedMonths;
    }
    public void setAlreadyAmortizedMoney(BigDecimal alreadyAmortizedMoney)
    {
        this.alreadyAmortizedMoney = alreadyAmortizedMoney;
    }

    public BigDecimal getAlreadyAmortizedMoney()
    {
        return alreadyAmortizedMoney;
    }
    public void setDimensionOfAccounting(String dimensionOfAccounting)
    {
        this.dimensionOfAccounting = dimensionOfAccounting;
    }

    public String getDimensionOfAccounting()
    {
        return dimensionOfAccounting;
    }
    public void setBalance(BigDecimal balance)
    {
        this.balance = balance;
    }

    public BigDecimal getBalance()
    {
        return balance;
    }
    public void setDocumentStatus(String documentStatus)
    {
        this.documentStatus = documentStatus;
    }

    public String getDocumentStatus()
    {
        return documentStatus;
    }
    public void setRemake(String remake)
    {
        this.remake = remake;
    }

    public String getRemake()
    {
        return remake;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("riId", getRiId())
                .append("cbYear", getCbYear())
                .append("cbMonth", getCbMonth())
                .append("businessDate", getBusinessDate())
                .append("assetName", getAssetName())
                .append("hoggeryId", getHoggeryId())
                .append("hoggeryName", getHoggeryName())
                .append("companyId", getCompanyId())
                .append("companyName", getCompanyName())
                .append("costTypes", getCostTypes())
                .append("initialAssetValue", getInitialAssetValue())
                .append("amortizeMonths", getAmortizeMonths())
                .append("amortizeStartMonth", getAmortizeStartMonth())
                .append("amortizeEndMonth", getAmortizeEndMonth())
                .append("instantAmortizedMoney", getInstantAmortizedMoney())
                .append("alreadyAmortizedMonths", getAlreadyAmortizedMonths())
                .append("alreadyAmortizedMoney", getAlreadyAmortizedMoney())
                .append("dimensionOfAccounting", getDimensionOfAccounting())
                .append("balance", getBalance())
                .append("documentStatus", getDocumentStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remake", getRemake())
                .toString();
    }
}
