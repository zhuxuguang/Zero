package com.zero.system.cb.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 成本分析报表对象 cb_cost_analysis_report
 *
 * @author zhuxuguang
 * @date 2023-02-21
 */
public class CbCostAnalysisReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private String cbType;

    /** 项目 */
    @Excel(name = "项目")
    private String project;

    /** 种类 */
    @Excel(name = "种类")
    private String variety;

    /** 年份 */
    @Excel(name = "年份")
    private String cbYear;

    /** 组织ID */
    @Excel(name = "组织ID")
    private Long hoggeryId;

    /** 组织名称 */
    @Excel(name = "组织名称")
    private String hoggeryName;

    /** 平均/合计 */
    @Excel(name = "平均/合计")
    private BigDecimal avgOrTotal;

    /** 一月 */
    @Excel(name = "一月")
    private BigDecimal jan;

    /** 二月 */
    @Excel(name = "二月")
    private BigDecimal february;

    /** 三月 */
    @Excel(name = "三月")
    private BigDecimal march;

    /** 四月 */
    @Excel(name = "四月")
    private BigDecimal april;

    /** 五月 */
    @Excel(name = "五月")
    private BigDecimal may;

    /** 六月 */
    @Excel(name = "六月")
    private BigDecimal june;

    /** 七月 */
    @Excel(name = "七月")
    private BigDecimal july;

    /** 八月 */
    @Excel(name = "八月")
    private BigDecimal august;

    /** 九月 */
    @Excel(name = "九月")
    private BigDecimal september;

    /** 十月 */
    @Excel(name = "十月")
    private BigDecimal october;

    /** 十一月 */
    @Excel(name = "十一月")
    private BigDecimal november;

    /** 十二月 */
    @Excel(name = "十二月")
    private BigDecimal december;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCbType(String cbType)
    {
        this.cbType = cbType;
    }

    public String getCbType()
    {
        return cbType;
    }
    public void setProject(String project)
    {
        this.project = project;
    }

    public String getProject()
    {
        return project;
    }
    public void setVariety(String variety)
    {
        this.variety = variety;
    }

    public String getVariety()
    {
        return variety;
    }
    public void setCbYear(String cbYear)
    {
        this.cbYear = cbYear;
    }

    public String getCbYear()
    {
        return cbYear;
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
    public void setAvgOrTotal(BigDecimal avgOrTotal)
    {
        this.avgOrTotal = avgOrTotal;
    }

    public BigDecimal getAvgOrTotal()
    {
        return avgOrTotal;
    }
    public void setJan(BigDecimal jan)
    {
        this.jan = jan;
    }

    public BigDecimal getJan()
    {
        return jan;
    }
    public void setFebruary(BigDecimal february)
    {
        this.february = february;
    }

    public BigDecimal getFebruary()
    {
        return february;
    }
    public void setMarch(BigDecimal march)
    {
        this.march = march;
    }

    public BigDecimal getMarch()
    {
        return march;
    }
    public void setApril(BigDecimal april)
    {
        this.april = april;
    }

    public BigDecimal getApril()
    {
        return april;
    }
    public void setMay(BigDecimal may)
    {
        this.may = may;
    }

    public BigDecimal getMay()
    {
        return may;
    }
    public void setJune(BigDecimal june)
    {
        this.june = june;
    }

    public BigDecimal getJune()
    {
        return june;
    }
    public void setJuly(BigDecimal july)
    {
        this.july = july;
    }

    public BigDecimal getJuly()
    {
        return july;
    }
    public void setAugust(BigDecimal august)
    {
        this.august = august;
    }

    public BigDecimal getAugust()
    {
        return august;
    }
    public void setSeptember(BigDecimal september)
    {
        this.september = september;
    }

    public BigDecimal getSeptember()
    {
        return september;
    }
    public void setOctober(BigDecimal october)
    {
        this.october = october;
    }

    public BigDecimal getOctober()
    {
        return october;
    }
    public void setNovember(BigDecimal november)
    {
        this.november = november;
    }

    public BigDecimal getNovember()
    {
        return november;
    }
    public void setDecember(BigDecimal december)
    {
        this.december = december;
    }

    public BigDecimal getDecember()
    {
        return december;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("cbType", getCbType())
                .append("project", getProject())
                .append("variety", getVariety())
                .append("cbYear", getCbYear())
                .append("hoggeryId", getHoggeryId())
                .append("hoggeryName", getHoggeryName())
                .append("avgOrTotal", getAvgOrTotal())
                .append("jan", getJan())
                .append("february", getFebruary())
                .append("march", getMarch())
                .append("april", getApril())
                .append("may", getMay())
                .append("june", getJune())
                .append("july", getJuly())
                .append("august", getAugust())
                .append("september", getSeptember())
                .append("october", getOctober())
                .append("november", getNovember())
                .append("december", getDecember())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
