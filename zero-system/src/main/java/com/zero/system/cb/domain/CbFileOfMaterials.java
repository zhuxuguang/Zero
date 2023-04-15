package com.zero.system.cb.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 物料档案对象 cb_file_of_materials
 * 
 * @author zhuxuguang
 * @date 2023-01-18
 */
public class CbFileOfMaterials extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 创建组织ID */
    @Excel(name = "创建组织ID")
    private Long creatingAnOrganizationId;

    /** 创建组织 */
    @Excel(name = "创建组织")
    private String creatingAnOrganizationName;

    /** 使用组织ID */
    @Excel(name = "使用组织ID")
    private Long organizationOfUseId;

    /** 使用组织名称 */
    @Excel(name = "使用组织名称")
    private String organizationOfUseName;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialName;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materialCoding;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specifications;

    /** 物料分组 */
    @Excel(name = "物料分组")
    private String groupingOfMaterials;

    /** 物料分组编码 */
    @Excel(name = "物料分组编码")
    private String groupingOfMaterialsCoding;

    /** 数据状态 */
    @Excel(name = "数据状态")
    private String dataState;

    /** 存货类别 */
    @Excel(name = "存货类别")
    private String category;

    /** 物料属性 */
    @Excel(name = "物料属性")
    private String propertiesOfMaterials;

    /** 单位 */
    @Excel(name = "单位")
    private String units;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreatingAnOrganizationId(Long creatingAnOrganizationId) 
    {
        this.creatingAnOrganizationId = creatingAnOrganizationId;
    }

    public Long getCreatingAnOrganizationId() 
    {
        return creatingAnOrganizationId;
    }
    public void setCreatingAnOrganizationName(String creatingAnOrganizationName) 
    {
        this.creatingAnOrganizationName = creatingAnOrganizationName;
    }

    public String getCreatingAnOrganizationName() 
    {
        return creatingAnOrganizationName;
    }
    public void setOrganizationOfUseId(Long organizationOfUseId) 
    {
        this.organizationOfUseId = organizationOfUseId;
    }

    public Long getOrganizationOfUseId() 
    {
        return organizationOfUseId;
    }
    public void setOrganizationOfUseName(String organizationOfUseName) 
    {
        this.organizationOfUseName = organizationOfUseName;
    }

    public String getOrganizationOfUseName() 
    {
        return organizationOfUseName;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setMaterialCoding(String materialCoding) 
    {
        this.materialCoding = materialCoding;
    }

    public String getMaterialCoding() 
    {
        return materialCoding;
    }
    public void setSpecifications(String specifications) 
    {
        this.specifications = specifications;
    }

    public String getSpecifications() 
    {
        return specifications;
    }
    public void setGroupingOfMaterials(String groupingOfMaterials) 
    {
        this.groupingOfMaterials = groupingOfMaterials;
    }

    public String getGroupingOfMaterials() 
    {
        return groupingOfMaterials;
    }
    public void setGroupingOfMaterialsCoding(String groupingOfMaterialsCoding) 
    {
        this.groupingOfMaterialsCoding = groupingOfMaterialsCoding;
    }

    public String getGroupingOfMaterialsCoding() 
    {
        return groupingOfMaterialsCoding;
    }
    public void setDataState(String dataState) 
    {
        this.dataState = dataState;
    }

    public String getDataState() 
    {
        return dataState;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setPropertiesOfMaterials(String propertiesOfMaterials) 
    {
        this.propertiesOfMaterials = propertiesOfMaterials;
    }

    public String getPropertiesOfMaterials() 
    {
        return propertiesOfMaterials;
    }
    public void setUnits(String units) 
    {
        this.units = units;
    }

    public String getUnits() 
    {
        return units;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("creatingAnOrganizationId", getCreatingAnOrganizationId())
            .append("creatingAnOrganizationName", getCreatingAnOrganizationName())
            .append("organizationOfUseId", getOrganizationOfUseId())
            .append("organizationOfUseName", getOrganizationOfUseName())
            .append("materialName", getMaterialName())
            .append("materialCoding", getMaterialCoding())
            .append("specifications", getSpecifications())
            .append("groupingOfMaterials", getGroupingOfMaterials())
            .append("groupingOfMaterialsCoding", getGroupingOfMaterialsCoding())
            .append("dataState", getDataState())
            .append("category", getCategory())
            .append("propertiesOfMaterials", getPropertiesOfMaterials())
            .append("units", getUnits())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
