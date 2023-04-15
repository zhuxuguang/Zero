package com.zero.system.cb.service;

import java.util.List;
import com.zero.system.cb.domain.CbFeedingFirstDay;

/**
 * 饲养头日Service接口
 * 
 * @author zhuxuguang
 * @date 2023-01-31
 */
public interface ICbFeedingFirstDayService 
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
     * 批量删除饲养头日
     * 
     * @param ids 需要删除的饲养头日主键集合
     * @return 结果
     */
    public int deleteCbFeedingFirstDayByIds(Long[] ids);

    /**
     * 删除饲养头日信息
     * 
     * @param id 饲养头日主键
     * @return 结果
     */
    public int deleteCbFeedingFirstDayById(Long id);

    /**
     * 导入饲养头日数据
     *
     * @param cbFFList 饲养头日数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importCbFeedingFirstDay(List<CbFeedingFirstDay> cbFFList, Boolean isUpdateSupport, String operName);
}
