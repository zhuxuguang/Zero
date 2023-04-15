package com.zero.system.cb.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 饲养头日对象 cb_feeding_first_day
 * 
 * @author zhuxuguang
 * @date 2023-01-31
 */
public class CbFeedingFirstDay extends BaseEntity
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

    /** 业务日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "业务日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date businessDay;

    /** 后备母猪头数 */
    @Excel(name = "后备母猪头数")
    private Long replacementGilt;

    /** 哺乳母猪头数 */
    @Excel(name = "哺乳母猪头数")
    private Long lactatingSow;

    /** 空怀母猪头数 */
    @Excel(name = "空怀母猪头数")
    private Long emptySow;

    /** 能繁母猪头数 */
    @Excel(name = "能繁母猪头数")
    private Long breedingSow;

    /** 在群母猪头数 */
    @Excel(name = "在群母猪头数")
    private Long sowInHerd;

    /** 妊娠母猪头数 */
    @Excel(name = "妊娠母猪头数")
    private Long pregnantSow;

    /** 场别id */
    @Excel(name = "场别id")
    private Long hoggeryId;

    /** 场别名称 */
    @Excel(name = "场别名称")
    private String hoggeryName;

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
    public void setBusinessDay(Date businessDay) 
    {
        this.businessDay = businessDay;
    }

    public Date getBusinessDay() 
    {
        return businessDay;
    }
    public void setReplacementGilt(Long replacementGilt) 
    {
        this.replacementGilt = replacementGilt;
    }

    public Long getReplacementGilt() 
    {
        return replacementGilt;
    }
    public void setLactatingSow(Long lactatingSow) 
    {
        this.lactatingSow = lactatingSow;
    }

    public Long getLactatingSow() 
    {
        return lactatingSow;
    }
    public void setEmptySow(Long emptySow) 
    {
        this.emptySow = emptySow;
    }

    public Long getEmptySow() 
    {
        return emptySow;
    }
    public void setBreedingSow(Long breedingSow) 
    {
        this.breedingSow = breedingSow;
    }

    public Long getBreedingSow() 
    {
        return breedingSow;
    }
    public void setSowInHerd(Long sowInHerd) 
    {
        this.sowInHerd = sowInHerd;
    }

    public Long getSowInHerd() 
    {
        return sowInHerd;
    }
    public void setPregnantSow(Long pregnantSow) 
    {
        this.pregnantSow = pregnantSow;
    }

    public Long getPregnantSow() 
    {
        return pregnantSow;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cbYear", getCbYear())
            .append("cbMonth", getCbMonth())
            .append("businessDay", getBusinessDay())
            .append("replacementGilt", getReplacementGilt())
            .append("lactatingSow", getLactatingSow())
            .append("emptySow", getEmptySow())
            .append("breedingSow", getBreedingSow())
            .append("sowInHerd", getSowInHerd())
            .append("pregnantSow", getPregnantSow())
            .append("hoggeryId", getHoggeryId())
            .append("hoggeryName", getHoggeryName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
