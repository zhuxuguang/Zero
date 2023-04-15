package com.zero.system.cb.report.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 头均断奶成本计算对象 cb_head_average_weaning_cost_report_view
 * 
 * @author zhuxuguang
 * @date 2023-02-25
 */
public class CbHeadAverageWeaningCostReportView extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 项目 */
    @Excel(name = "项目")
    private String project;

    /** 种类 */
    @Excel(name = "种类")
    private String variety;

    /** 组织ID */
    @Excel(name = "组织ID")
    private Long hoggeryId;

    /** 年份 */
    @Excel(name = "年份")
    private String cbYear;

    /** 平均-合计 */
    @Excel(name = "平均-合计")
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

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
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
    public void setHoggeryId(Long hoggeryId) 
    {
        this.hoggeryId = hoggeryId;
    }

    public Long getHoggeryId() 
    {
        return hoggeryId;
    }
    public void setCbYear(String cbYear) 
    {
        this.cbYear = cbYear;
    }

    public String getCbYear() 
    {
        return cbYear;
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
            .append("type", getType())
            .append("project", getProject())
            .append("variety", getVariety())
            .append("hoggeryId", getHoggeryId())
            .append("cbYear", getCbYear())
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
            .toString();
    }
}
