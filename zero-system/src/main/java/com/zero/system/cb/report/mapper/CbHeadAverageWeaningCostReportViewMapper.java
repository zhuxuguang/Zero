package com.zero.system.cb.report.mapper;

import java.util.List;
import com.zero.system.cb.report.domain.CbHeadAverageWeaningCostReportView;

/**
 * 头均断奶成本计算Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-02-25
 */
public interface CbHeadAverageWeaningCostReportViewMapper 
{
    /**
     * 查询头均断奶成本计算
     * 
     * @param type 头均断奶成本计算主键
     * @return 头均断奶成本计算
     */
    public CbHeadAverageWeaningCostReportView selectCbHeadAverageWeaningCostReportViewByType(String type);

    /**
     * 查询头均断奶成本计算列表
     * 
     * @param cbHeadAverageWeaningCostReportView 头均断奶成本计算
     * @return 头均断奶成本计算集合
     */
    public List<CbHeadAverageWeaningCostReportView> selectCbHeadAverageWeaningCostReportViewList(CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView);

    /**
     * 新增头均断奶成本计算
     * 
     * @param cbHeadAverageWeaningCostReportView 头均断奶成本计算
     * @return 结果
     */
    public int insertCbHeadAverageWeaningCostReportView(CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView);

    /**
     * 修改头均断奶成本计算
     * 
     * @param cbHeadAverageWeaningCostReportView 头均断奶成本计算
     * @return 结果
     */
    public int updateCbHeadAverageWeaningCostReportView(CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView);

    /**
     * 删除头均断奶成本计算
     * 
     * @param type 头均断奶成本计算主键
     * @return 结果
     */
    public int deleteCbHeadAverageWeaningCostReportViewByType(String type);

    /**
     * 批量删除头均断奶成本计算
     * 
     * @param types 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbHeadAverageWeaningCostReportViewByTypes(String[] types);
}
