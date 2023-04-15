package com.zero.system.cb.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 折旧对象 cb_deprecition
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
public class CbDeprecition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 货主组织ID */
    @Excel(name = "货主组织ID")
    private Long shipperOrganizationId;

    /** 货主组织名称 */
    @Excel(name = "货主组织名称")
    private String fieldName;

    /** 折旧 */
    @Excel(name = "折旧")
    private String cbYear;

    /** 年期 */
    @Excel(name = "年期")
    private String cbMonth;

    /** 资产类别 */
    @Excel(name = "资产类别")
    private String documentCode;

    /** 业务日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date businessDate;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long userDepartmentId;

    /** 使用部门 */
    @Excel(name = "使用部门")
    private String userDepartment;

    /** 资产状态 */
    @Excel(name = "资产状态")
    private String propertyStatus;

    /** 资产位置 */
    @Excel(name = "资产位置")
    private String propertyPlace;

    /** 变动方式 */
    @Excel(name = "变动方式")
    private String modeOfChange;

    /** 卡片编码 */
    @Excel(name = "卡片编码")
    private String cardCoding;

    /** 资产名称 */
    @Excel(name = "资产名称")
    private String assetName;

    /** 资产数量 */
    @Excel(name = "资产数量")
    private Long assetAmount;

    /** 开始使用日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始使用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginUseDate;

    /** 入账日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入账日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryDate;

    /** 使用寿命 */
    @Excel(name = "使用寿命")
    private Long useLifetime;

    /** 已使用寿命 */
    @Excel(name = "已使用寿命")
    private Long usedLifetime;

    /** 月折旧率 */
    @Excel(name = "月折旧率")
    private BigDecimal monthlyDepreciationRate;

    /** (期初)期初原值 */
    @Excel(name = "(期初)期初原值")
    private BigDecimal initialValue;

    /** (期初)期初累计折旧 */
    @Excel(name = "(期初)期初累计折旧")
    private BigDecimal qcAggregateDeprecition;

    /** (期初)期初净值 */
    @Excel(name = "(期初)期初净值")
    private BigDecimal qcNetValue;

    /** (期初)期初减值准备 */
    @Excel(name = "(期初)期初减值准备")
    private BigDecimal qcDepreciReserves;

    /** (期初)期初可回收静额 */
    @Excel(name = "(期初)期初可回收静额")
    private BigDecimal qcRecoverableNet;

    /** (本期发生)本期折旧额 */
    @Excel(name = "(本期发生)本期折旧额")
    private BigDecimal cgBqzje;

    /** (本期发生)本期累计折旧额 */
    @Excel(name = "(本期发生)本期累计折旧额")
    private BigDecimal cgBnljzje;

    /** (期末)期末原值 */
    @Excel(name = "(期末)期末原值")
    private BigDecimal qmQmyz;

    /** (期末)期末累计折旧 */
    @Excel(name = "(期末)期末累计折旧")
    private BigDecimal qmQmljzj;

    /** (期末)期末净值 */
    @Excel(name = "(期末)期末净值")
    private BigDecimal qmQmjz;

    /** (期末)期末减值准备 */
    @Excel(name = "(期末)期末减值准备")
    private BigDecimal qmQmjzzb;

    /** (期末)期末可回收金额 */
    @Excel(name = "(期末)期末可回收金额")
    private BigDecimal qmQmkhsje;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShipperOrganizationId(Long shipperOrganizationId) 
    {
        this.shipperOrganizationId = shipperOrganizationId;
    }

    public Long getShipperOrganizationId() 
    {
        return shipperOrganizationId;
    }
    public void setFieldName(String fieldName) 
    {
        this.fieldName = fieldName;
    }

    public String getFieldName() 
    {
        return fieldName;
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
    public void setBusinessDate(Date businessDate) 
    {
        this.businessDate = businessDate;
    }

    public Date getBusinessDate() 
    {
        return businessDate;
    }
    public void setUserDepartmentId(Long userDepartmentId) 
    {
        this.userDepartmentId = userDepartmentId;
    }

    public Long getUserDepartmentId() 
    {
        return userDepartmentId;
    }
    public void setUserDepartment(String userDepartment) 
    {
        this.userDepartment = userDepartment;
    }

    public String getUserDepartment() 
    {
        return userDepartment;
    }
    public void setPropertyStatus(String propertyStatus) 
    {
        this.propertyStatus = propertyStatus;
    }

    public String getPropertyStatus() 
    {
        return propertyStatus;
    }
    public void setPropertyPlace(String propertyPlace) 
    {
        this.propertyPlace = propertyPlace;
    }

    public String getPropertyPlace() 
    {
        return propertyPlace;
    }
    public void setModeOfChange(String modeOfChange) 
    {
        this.modeOfChange = modeOfChange;
    }

    public String getModeOfChange() 
    {
        return modeOfChange;
    }
    public void setCardCoding(String cardCoding) 
    {
        this.cardCoding = cardCoding;
    }

    public String getCardCoding() 
    {
        return cardCoding;
    }
    public void setAssetName(String assetName) 
    {
        this.assetName = assetName;
    }

    public String getAssetName() 
    {
        return assetName;
    }
    public void setAssetAmount(Long assetAmount) 
    {
        this.assetAmount = assetAmount;
    }

    public Long getAssetAmount() 
    {
        return assetAmount;
    }
    public void setBeginUseDate(Date beginUseDate) 
    {
        this.beginUseDate = beginUseDate;
    }

    public Date getBeginUseDate() 
    {
        return beginUseDate;
    }
    public void setEntryDate(Date entryDate) 
    {
        this.entryDate = entryDate;
    }

    public Date getEntryDate() 
    {
        return entryDate;
    }
    public void setUseLifetime(Long useLifetime) 
    {
        this.useLifetime = useLifetime;
    }

    public Long getUseLifetime() 
    {
        return useLifetime;
    }
    public void setUsedLifetime(Long usedLifetime) 
    {
        this.usedLifetime = usedLifetime;
    }

    public Long getUsedLifetime() 
    {
        return usedLifetime;
    }
    public void setMonthlyDepreciationRate(BigDecimal monthlyDepreciationRate) 
    {
        this.monthlyDepreciationRate = monthlyDepreciationRate;
    }

    public BigDecimal getMonthlyDepreciationRate() 
    {
        return monthlyDepreciationRate;
    }
    public void setInitialValue(BigDecimal initialValue) 
    {
        this.initialValue = initialValue;
    }

    public BigDecimal getInitialValue() 
    {
        return initialValue;
    }
    public void setQcAggregateDeprecition(BigDecimal qcAggregateDeprecition) 
    {
        this.qcAggregateDeprecition = qcAggregateDeprecition;
    }

    public BigDecimal getQcAggregateDeprecition() 
    {
        return qcAggregateDeprecition;
    }
    public void setQcNetValue(BigDecimal qcNetValue) 
    {
        this.qcNetValue = qcNetValue;
    }

    public BigDecimal getQcNetValue() 
    {
        return qcNetValue;
    }
    public void setQcDepreciReserves(BigDecimal qcDepreciReserves) 
    {
        this.qcDepreciReserves = qcDepreciReserves;
    }

    public BigDecimal getQcDepreciReserves() 
    {
        return qcDepreciReserves;
    }
    public void setQcRecoverableNet(BigDecimal qcRecoverableNet) 
    {
        this.qcRecoverableNet = qcRecoverableNet;
    }

    public BigDecimal getQcRecoverableNet() 
    {
        return qcRecoverableNet;
    }
    public void setCgBqzje(BigDecimal cgBqzje) 
    {
        this.cgBqzje = cgBqzje;
    }

    public BigDecimal getCgBqzje() 
    {
        return cgBqzje;
    }
    public void setCgBnljzje(BigDecimal cgBnljzje) 
    {
        this.cgBnljzje = cgBnljzje;
    }

    public BigDecimal getCgBnljzje() 
    {
        return cgBnljzje;
    }
    public void setQmQmyz(BigDecimal qmQmyz) 
    {
        this.qmQmyz = qmQmyz;
    }

    public BigDecimal getQmQmyz() 
    {
        return qmQmyz;
    }
    public void setQmQmljzj(BigDecimal qmQmljzj) 
    {
        this.qmQmljzj = qmQmljzj;
    }

    public BigDecimal getQmQmljzj() 
    {
        return qmQmljzj;
    }
    public void setQmQmjz(BigDecimal qmQmjz) 
    {
        this.qmQmjz = qmQmjz;
    }

    public BigDecimal getQmQmjz() 
    {
        return qmQmjz;
    }
    public void setQmQmjzzb(BigDecimal qmQmjzzb) 
    {
        this.qmQmjzzb = qmQmjzzb;
    }

    public BigDecimal getQmQmjzzb() 
    {
        return qmQmjzzb;
    }
    public void setQmQmkhsje(BigDecimal qmQmkhsje) 
    {
        this.qmQmkhsje = qmQmkhsje;
    }

    public BigDecimal getQmQmkhsje() 
    {
        return qmQmkhsje;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shipperOrganizationId", getShipperOrganizationId())
            .append("fieldName", getFieldName())
            .append("cbYear", getCbYear())
            .append("cbMonth", getCbMonth())
            .append("documentCode", getDocumentCode())
            .append("businessDate", getBusinessDate())
            .append("userDepartmentId", getUserDepartmentId())
            .append("userDepartment", getUserDepartment())
            .append("propertyStatus", getPropertyStatus())
            .append("propertyPlace", getPropertyPlace())
            .append("modeOfChange", getModeOfChange())
            .append("cardCoding", getCardCoding())
            .append("assetName", getAssetName())
            .append("assetAmount", getAssetAmount())
            .append("beginUseDate", getBeginUseDate())
            .append("entryDate", getEntryDate())
            .append("useLifetime", getUseLifetime())
            .append("usedLifetime", getUsedLifetime())
            .append("monthlyDepreciationRate", getMonthlyDepreciationRate())
            .append("initialValue", getInitialValue())
            .append("qcAggregateDeprecition", getQcAggregateDeprecition())
            .append("qcNetValue", getQcNetValue())
            .append("qcDepreciReserves", getQcDepreciReserves())
            .append("qcRecoverableNet", getQcRecoverableNet())
            .append("cgBqzje", getCgBqzje())
            .append("cgBnljzje", getCgBnljzje())
            .append("qmQmyz", getQmQmyz())
            .append("qmQmljzj", getQmQmljzj())
            .append("qmQmjz", getQmQmjz())
            .append("qmQmjzzb", getQmQmjzzb())
            .append("qmQmkhsje", getQmQmkhsje())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
