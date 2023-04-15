package com.zero.system.k3cloud.k3Material.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 第三方简单生产领料单对象 k3_sp_pickmtrl
 *
 * @author zhuxuguang
 * @date 2023-04-03
 */
public class K3SpPickmtrl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 源单ID */
    @Excel(name = "源单ID")
    private Long fid;

    /** 单据编号 */
    @Excel(name = "单据编号")
    private String fbillno;

    /** 业务日期 */
    @Excel(name = "业务日期")
    private String fdate;

    /** 单据状态 */
    @Excel(name = "单据状态")
    private String fdocumentStatus;

    /** 发料组织ID */
    @Excel(name = "发料组织ID")
    private String fstockorgId;

    /** 发料组织名称 */
    @Excel(name = "发料组织名称")
    private String fstockorgName;

    /** 物料内码 */
    @Excel(name = "物料内码")
    private String fmaterialId;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String fmaterialName;

    /** 跨组织业务类型 */
    @Excel(name = "跨组织业务类型")
    private String ftransferbiztypeId;

    /** 规格 */
    @Excel(name = "规格")
    private String fspecification;

    /** 单位编号 */
    @Excel(name = "单位编号")
    private String funitid;

    /** 实发数量 */
    @Excel(name = "实发数量")
    private BigDecimal factualqty;

    /** 栋舍 */
    @Excel(name = "栋舍")
    private String fds;

    /** 仓库 */
    @Excel(name = "仓库")
    private String fstockId;

    /** 总成本 */
    @Excel(name = "总成本")
    private BigDecimal famount;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setFid(Long fid)
    {
        this.fid = fid;
    }

    public Long getFid()
    {
        return fid;
    }
    public void setFbillno(String fbillno)
    {
        this.fbillno = fbillno;
    }

    public String getFbillno()
    {
        return fbillno;
    }
    public void setFdate(String fdate)
    {
        this.fdate = fdate;
    }

    public String getFdate()
    {
        return fdate;
    }
    public void setFdocumentStatus(String fdocumentStatus)
    {
        this.fdocumentStatus = fdocumentStatus;
    }

    public String getFdocumentStatus()
    {
        return fdocumentStatus;
    }
    public void setFstockorgId(String fstockorgId)
    {
        this.fstockorgId = fstockorgId;
    }

    public String getFstockorgId()
    {
        return fstockorgId;
    }
    public void setFstockorgName(String fstockorgName)
    {
        this.fstockorgName = fstockorgName;
    }

    public String getFstockorgName()
    {
        return fstockorgName;
    }
    public void setFmaterialId(String fmaterialId)
    {
        this.fmaterialId = fmaterialId;
    }

    public String getFmaterialId()
    {
        return fmaterialId;
    }
    public void setFmaterialName(String fmaterialName)
    {
        this.fmaterialName = fmaterialName;
    }

    public String getFmaterialName()
    {
        return fmaterialName;
    }
    public void setFtransferbiztypeId(String ftransferbiztypeId)
    {
        this.ftransferbiztypeId = ftransferbiztypeId;
    }

    public String getFtransferbiztypeId()
    {
        return ftransferbiztypeId;
    }
    public void setFspecification(String fspecification)
    {
        this.fspecification = fspecification;
    }

    public String getFspecification()
    {
        return fspecification;
    }
    public void setFunitid(String funitid)
    {
        this.funitid = funitid;
    }

    public String getFunitid()
    {
        return funitid;
    }
    public void setFactualqty(BigDecimal factualqty)
    {
        this.factualqty = factualqty;
    }

    public BigDecimal getFactualqty()
    {
        return factualqty;
    }
    public void setFds(String fds)
    {
        this.fds = fds;
    }

    public String getFds()
    {
        return fds;
    }
    public void setFstockId(String fstockId)
    {
        this.fstockId = fstockId;
    }

    public String getFstockId()
    {
        return fstockId;
    }
    public void setFamount(BigDecimal famount)
    {
        this.famount = famount;
    }

    public BigDecimal getFamount()
    {
        return famount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("fid", getFid())
                .append("fbillno", getFbillno())
                .append("fdate", getFdate())
                .append("fdocumentStatus", getFdocumentStatus())
                .append("fstockorgId", getFstockorgId())
                .append("fstockorgName", getFstockorgName())
                .append("fmaterialId", getFmaterialId())
                .append("fmaterialName", getFmaterialName())
                .append("ftransferbiztypeId", getFtransferbiztypeId())
                .append("fspecification", getFspecification())
                .append("funitid", getFunitid())
                .append("factualqty", getFactualqty())
                .append("fds", getFds())
                .append("fstockId", getFstockId())
                .append("famount", getFamount())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
