package com.zero.system.cb.report.service;

import java.util.List;
import com.zero.system.cb.report.domain.CbSowBankMonthAvgCostReportView;

/**
 * 母猪存栏月平均成本(元/头)Service接口
 * 
 * @author zhuxuguang
 * @date 2023-02-25
 */
public interface ICbSowBankMonthAvgCostReportViewService 
{
    /**
     * 查询母猪存栏月平均成本(元/头)
     * 
     * @param type 母猪存栏月平均成本(元/头)主键
     * @return 母猪存栏月平均成本(元/头)
     */
    public CbSowBankMonthAvgCostReportView selectCbSowBankMonthAvgCostReportViewByType(String type);

    /**
     * 查询母猪存栏月平均成本(元/头)列表
     * 
     * @param cbSowBankMonthAvgCostReportView 母猪存栏月平均成本(元/头)
     * @return 母猪存栏月平均成本(元/头)集合
     */
    public List<CbSowBankMonthAvgCostReportView> selectCbSowBankMonthAvgCostReportViewList(CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView);

    /**
     * 新增母猪存栏月平均成本(元/头)
     * 
     * @param cbSowBankMonthAvgCostReportView 母猪存栏月平均成本(元/头)
     * @return 结果
     */
    public int insertCbSowBankMonthAvgCostReportView(CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView);

    /**
     * 修改母猪存栏月平均成本(元/头)
     * 
     * @param cbSowBankMonthAvgCostReportView 母猪存栏月平均成本(元/头)
     * @return 结果
     */
    public int updateCbSowBankMonthAvgCostReportView(CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView);

    /**
     * 批量删除母猪存栏月平均成本(元/头)
     * 
     * @param types 需要删除的母猪存栏月平均成本(元/头)主键集合
     * @return 结果
     */
    public int deleteCbSowBankMonthAvgCostReportViewByTypes(String[] types);

    /**
     * 删除母猪存栏月平均成本(元/头)信息
     * 
     * @param type 母猪存栏月平均成本(元/头)主键
     * @return 结果
     */
    public int deleteCbSowBankMonthAvgCostReportViewByType(String type);
}
