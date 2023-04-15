package com.zero.system.cb.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zero.common.annotation.Excel;
import com.zero.common.core.domain.BaseEntity;

/**
 * 存栏情况对象 cb_breeding_stock
 *
 * @author zhuxuguang
 * @date 2023-02-20
 */
public class CbBreedingStock extends BaseEntity
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
    private Date businessDate;

    /** 场别id */
    @Excel(name = "场别id")
    private Long hoggeryId;

    /** 场别名称 */
    @Excel(name = "场别名称")
    private String hoggeryName;

    /** 种母猪 */
    @Excel(name = "种母猪")
    private Long breedingSow;

    /** 种公猪 */
    @Excel(name = "种公猪")
    private Long stockBoar;

    /** 后备猪 */
    @Excel(name = "后备猪")
    private Long backupPig;

    /** 哺仔猪 */
    @Excel(name = "哺仔猪")
    private Long pigletFeeding;

    /** 保育猪 */
    @Excel(name = "保育猪")
    private Long nurseryPig;

    /** 育肥猪 */
    @Excel(name = "育肥猪")
    private Long fatteningPig;

    /** 合计 */
    @Excel(name = "合计")
    private Long totalPig;

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
    public void setBusinessDate(Date businessDate)
    {
        this.businessDate = businessDate;
    }

    public Date getBusinessDate()
    {
        return businessDate;
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
    public void setBreedingSow(Long breedingSow)
    {
        this.breedingSow = breedingSow;
    }

    public Long getBreedingSow()
    {
        return breedingSow;
    }
    public void setStockBoar(Long stockBoar)
    {
        this.stockBoar = stockBoar;
    }

    public Long getStockBoar()
    {
        return stockBoar;
    }
    public void setBackupPig(Long backupPig)
    {
        this.backupPig = backupPig;
    }

    public Long getBackupPig()
    {
        return backupPig;
    }
    public void setPigletFeeding(Long pigletFeeding)
    {
        this.pigletFeeding = pigletFeeding;
    }

    public Long getPigletFeeding()
    {
        return pigletFeeding;
    }
    public void setNurseryPig(Long nurseryPig)
    {
        this.nurseryPig = nurseryPig;
    }

    public Long getNurseryPig()
    {
        return nurseryPig;
    }
    public void setFatteningPig(Long fatteningPig)
    {
        this.fatteningPig = fatteningPig;
    }

    public Long getFatteningPig()
    {
        return fatteningPig;
    }
    public void setTotalPig(Long totalPig)
    {
        this.totalPig = totalPig;
    }

    public Long getTotalPig()
    {
        return totalPig;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("cbYear", getCbYear())
                .append("cbMonth", getCbMonth())
                .append("businessDate", getBusinessDate())
                .append("hoggeryId", getHoggeryId())
                .append("hoggeryName", getHoggeryName())
                .append("breedingSow", getBreedingSow())
                .append("stockBoar", getStockBoar())
                .append("backupPig", getBackupPig())
                .append("pigletFeeding", getPigletFeeding())
                .append("nurseryPig", getNurseryPig())
                .append("fatteningPig", getFatteningPig())
                .append("totalPig", getTotalPig())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
