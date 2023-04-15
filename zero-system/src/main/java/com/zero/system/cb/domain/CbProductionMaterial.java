package com.zero.system.cb.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zero.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 生产领料对象 cb_production_material
 * 
 * @author zhuxuguang
 * @date 2023-01-05
 */
public class CbProductionMaterial extends BaseEntity
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

    /** 单据编号 */
    @Excel(name = "单据编号")
    private String documentCode;

    /** 业务日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "业务日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date businessDate;

    /** 单据状态 */
    @Excel(name = "单据状态")
    private String documentStatus;

    /** 发料组织ID */
    @Excel(name = "发料组织ID")
    private Long fieldId;

    /** 发料组织名称 */
    @Excel(name = "发料组织名称")
    private String fieldName;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materialCoding;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialName;

    /** 业务类型 */
    @Excel(name = "业务类型")
    private String businessType;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specifications;

    /** 单位 */
    @Excel(name = "单位")
    private String units;

    /** 实发数量 */
    @Excel(name = "实发数量")
    private BigDecimal actualQuantityIssued;

    /** 领入栋舍 */
    @Excel(name = "领入栋舍")
    private String showInHouse;

    /** 仓库 */
    @Excel(name = "仓库")
    private String warehouse;

    /** 总成本 */
    @Excel(name = "总成本")
    private BigDecimal totalCost;

    /** 类别 */
    @Excel(name = "类别")
    private String category;

    /** 部门对象 */
    private SysDept dept;

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
    public void setBusinessDate(Date businessDate) 
    {
        this.businessDate = businessDate;
    }

    public Date getBusinessDate() 
    {
        return businessDate;
    }
    public void setFieldId(Long fieldId) 
    {
        this.fieldId = fieldId;
    }

    public Long getFieldId() 
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
    public void setDocumentStatus(String documentStatus) 
    {
        this.documentStatus = documentStatus;
    }

    public String getDocumentStatus() 
    {
        return documentStatus;
    }
    public void setMaterialCoding(String materialCoding) 
    {
        this.materialCoding = materialCoding;
    }

    public String getMaterialCoding() 
    {
        return materialCoding;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setBusinessType(String businessType) 
    {
        this.businessType = businessType;
    }

    public String getBusinessType() 
    {
        return businessType;
    }
    public void setSpecifications(String specifications) 
    {
        this.specifications = specifications;
    }

    public String getSpecifications() 
    {
        return specifications;
    }
    public void setUnits(String units) 
    {
        this.units = units;
    }

    public String getUnits() 
    {
        return units;
    }
    public void setActualQuantityIssued(BigDecimal actualQuantityIssued) 
    {
        this.actualQuantityIssued = actualQuantityIssued;
    }

    public BigDecimal getActualQuantityIssued() 
    {
        return actualQuantityIssued;
    }
    public void setShowInHouse(String showInHouse) 
    {
        this.showInHouse = showInHouse;
    }

    public String getShowInHouse() 
    {
        return showInHouse;
    }
    public void setWarehouse(String warehouse) 
    {
        this.warehouse = warehouse;
    }

    public String getWarehouse() 
    {
        return warehouse;
    }
    public void setTotalCost(BigDecimal totalCost) 
    {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalCost() 
    {
        return totalCost;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
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
            .append("cbYear", getCbYear())
            .append("cbMonth", getCbMonth())
            .append("documentCode", getDocumentCode())
            .append("businessDate", getBusinessDate())
            .append("documentStatus", getDocumentStatus())
            .append("fieldId", getFieldId())
            .append("fieldName", getFieldName())
            .append("materialCoding", getMaterialCoding())
            .append("materialName", getMaterialName())
            .append("businessType", getBusinessType())
            .append("specifications", getSpecifications())
            .append("units", getUnits())
            .append("actualQuantityIssued", getActualQuantityIssued())
            .append("showInHouse", getShowInHouse())
            .append("warehouse", getWarehouse())
            .append("totalCost", getTotalCost())
            .append("category", getCategory())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dept", getDept())
            .toString();
    }
}
