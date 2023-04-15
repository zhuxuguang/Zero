package com.zero.system.cb.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.report.mapper.CbSowBankMonthAvgCostReportViewMapper;
import com.zero.system.cb.report.domain.CbSowBankMonthAvgCostReportView;
import com.zero.system.cb.report.service.ICbSowBankMonthAvgCostReportViewService;

/**
 * 母猪存栏月平均成本(元/头)Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-25
 */
@Service
public class CbSowBankMonthAvgCostReportViewServiceImpl implements ICbSowBankMonthAvgCostReportViewService 
{
    @Autowired
    private CbSowBankMonthAvgCostReportViewMapper cbSowBankMonthAvgCostReportViewMapper;

    /**
     * 查询母猪存栏月平均成本(元/头)
     * 
     * @param type 母猪存栏月平均成本(元/头)主键
     * @return 母猪存栏月平均成本(元/头)
     */
    @Override
    public CbSowBankMonthAvgCostReportView selectCbSowBankMonthAvgCostReportViewByType(String type)
    {
        return cbSowBankMonthAvgCostReportViewMapper.selectCbSowBankMonthAvgCostReportViewByType(type);
    }

    /**
     * 查询母猪存栏月平均成本(元/头)列表
     * 
     * @param cbSowBankMonthAvgCostReportView 母猪存栏月平均成本(元/头)
     * @return 母猪存栏月平均成本(元/头)
     */
    @Override
    public List<CbSowBankMonthAvgCostReportView> selectCbSowBankMonthAvgCostReportViewList(CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView)
    {
        return cbSowBankMonthAvgCostReportViewMapper.selectCbSowBankMonthAvgCostReportViewList(cbSowBankMonthAvgCostReportView);
    }

    /**
     * 新增母猪存栏月平均成本(元/头)
     * 
     * @param cbSowBankMonthAvgCostReportView 母猪存栏月平均成本(元/头)
     * @return 结果
     */
    @Override
    public int insertCbSowBankMonthAvgCostReportView(CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView)
    {
        return cbSowBankMonthAvgCostReportViewMapper.insertCbSowBankMonthAvgCostReportView(cbSowBankMonthAvgCostReportView);
    }

    /**
     * 修改母猪存栏月平均成本(元/头)
     * 
     * @param cbSowBankMonthAvgCostReportView 母猪存栏月平均成本(元/头)
     * @return 结果
     */
    @Override
    public int updateCbSowBankMonthAvgCostReportView(CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView)
    {
        return cbSowBankMonthAvgCostReportViewMapper.updateCbSowBankMonthAvgCostReportView(cbSowBankMonthAvgCostReportView);
    }

    /**
     * 批量删除母猪存栏月平均成本(元/头)
     * 
     * @param types 需要删除的母猪存栏月平均成本(元/头)主键
     * @return 结果
     */
    @Override
    public int deleteCbSowBankMonthAvgCostReportViewByTypes(String[] types)
    {
        return cbSowBankMonthAvgCostReportViewMapper.deleteCbSowBankMonthAvgCostReportViewByTypes(types);
    }

    /**
     * 删除母猪存栏月平均成本(元/头)信息
     * 
     * @param type 母猪存栏月平均成本(元/头)主键
     * @return 结果
     */
    @Override
    public int deleteCbSowBankMonthAvgCostReportViewByType(String type)
    {
        return cbSowBankMonthAvgCostReportViewMapper.deleteCbSowBankMonthAvgCostReportViewByType(type);
    }
}
