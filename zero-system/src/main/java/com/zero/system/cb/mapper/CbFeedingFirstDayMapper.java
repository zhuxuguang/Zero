package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbFeedingFirstDay;

/**
 * 饲养头日Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-01-31
 */
public interface CbFeedingFirstDayMapper 
{
    /**
     * 查询饲养头日
     * 
     * @param id 饲养头日主键
     * @return 饲养头日
     */
    public CbFeedingFirstDay selectCbFeedingFirstDayById(Long id);

    /**
     * 查询饲养头日列表
     * 
     * @param cbFeedingFirstDay 饲养头日
     * @return 饲养头日集合
     */
    public List<CbFeedingFirstDay> selectCbFeedingFirstDayList(CbFeedingFirstDay cbFeedingFirstDay);

    /**
     * 新增饲养头日
     * 
     * @param cbFeedingFirstDay 饲养头日
     * @return 结果
     */
    public int insertCbFeedingFirstDay(CbFeedingFirstDay cbFeedingFirstDay);

    /**
     * 修改饲养头日
     * 
     * @param cbFeedingFirstDay 饲养头日
     * @return 结果
     */
    public int updateCbFeedingFirstDay(CbFeedingFirstDay cbFeedingFirstDay);

    /**
     * 删除饲养头日
     * 
     * @param id 饲养头日主键
     * @return 结果
     */
    public int deleteCbFeedingFirstDayById(Long id);

    /**
     * 批量删除饲养头日
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbFeedingFirstDayByIds(Long[] ids);
}
