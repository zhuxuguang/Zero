package com.zero.system.cb.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.report.mapper.CbHeadAverageWeaningCostReportViewMapper;
import com.zero.system.cb.report.domain.CbHeadAverageWeaningCostReportView;
import com.zero.system.cb.report.service.ICbHeadAverageWeaningCostReportViewService;

/**
 * 头均断奶成本计算Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-25
 */
@Service
public class CbHeadAverageWeaningCostReportViewServiceImpl implements ICbHeadAverageWeaningCostReportViewService 
{
    @Autowired
    private CbHeadAverageWeaningCostReportViewMapper cbHeadAverageWeaningCostReportViewMapper;

    /**
     * 查询头均断奶成本计算
     * 
     * @param type 头均断奶成本计算主键
     * @return 头均断奶成本计算
     */
    @Override
    public CbHeadAverageWeaningCostReportView selectCbHeadAverageWeaningCostReportViewByType(String type)
    {
        return cbHeadAverageWeaningCostReportViewMapper.selectCbHeadAverageWeaningCostReportViewByType(type);
    }

    /**
     * 查询头均断奶成本计算列表
     * 
     * @param cbHeadAverageWeaningCostReportView 头均断奶成本计算
     * @return 头均断奶成本计算
     */
    @Override
    public List<CbHeadAverageWeaningCostReportView> selectCbHeadAverageWeaningCostReportViewList(CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView)
    {
        return cbHeadAverageWeaningCostReportViewMapper.selectCbHeadAverageWeaningCostReportViewList(cbHeadAverageWeaningCostReportView);
    }

    /**
     * 新增头均断奶成本计算
     * 
     * @param cbHeadAverageWeaningCostReportView 头均断奶成本计算
     * @return 结果
     */
    @Override
    public int insertCbHeadAverageWeaningCostReportView(CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView)
    {
        return cbHeadAverageWeaningCostReportViewMapper.insertCbHeadAverageWeaningCostReportView(cbHeadAverageWeaningCostReportView);
    }

    /**
     * 修改头均断奶成本计算
     * 
     * @param cbHeadAverageWeaningCostReportView 头均断奶成本计算
     * @return 结果
     */
    @Override
    public int updateCbHeadAverageWeaningCostReportView(CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView)
    {
        return cbHeadAverageWeaningCostReportViewMapper.updateCbHeadAverageWeaningCostReportView(cbHeadAverageWeaningCostReportView);
    }

    /**
     * 批量删除头均断奶成本计算
     * 
     * @param types 需要删除的头均断奶成本计算主键
     * @return 结果
     */
    @Override
    public int deleteCbHeadAverageWeaningCostReportViewByTypes(String[] types)
    {
        return cbHeadAverageWeaningCostReportViewMapper.deleteCbHeadAverageWeaningCostReportViewByTypes(types);
    }

    /**
     * 删除头均断奶成本计算信息
     * 
     * @param type 头均断奶成本计算主键
     * @return 结果
     */
    @Override
    public int deleteCbHeadAverageWeaningCostReportViewByType(String type)
    {
        return cbHeadAverageWeaningCostReportViewMapper.deleteCbHeadAverageWeaningCostReportViewByType(type);
    }
}
