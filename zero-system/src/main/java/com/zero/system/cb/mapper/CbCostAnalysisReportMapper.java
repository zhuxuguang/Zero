package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbCostAnalysisReport;

/**
 * 成本分析报表Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-02-20
 */
public interface CbCostAnalysisReportMapper 
{
    /**
     * 查询成本分析报表
     * 
     * @param id 成本分析报表主键
     * @return 成本分析报表
     */
    public CbCostAnalysisReport selectCbCostAnalysisReportById(Long id);

    /**
     * 查询成本分析报表列表
     * 
     * @param cbCostAnalysisReport 成本分析报表
     * @return 成本分析报表集合
     */
    public List<CbCostAnalysisReport> selectCbCostAnalysisReportList(CbCostAnalysisReport cbCostAnalysisReport);

    /**
     * 新增成本分析报表
     * 
     * @param cbCostAnalysisReport 成本分析报表
     * @return 结果
     */
    public int insertCbCostAnalysisReport(CbCostAnalysisReport cbCostAnalysisReport);

    /**
     * 修改成本分析报表
     * 
     * @param cbCostAnalysisReport 成本分析报表
     * @return 结果
     */
    public int updateCbCostAnalysisReport(CbCostAnalysisReport cbCostAnalysisReport);

    /**
     * 删除成本分析报表
     * 
     * @param id 成本分析报表主键
     * @return 结果
     */
    public int deleteCbCostAnalysisReportById(Long id);

    /**
     * 批量删除成本分析报表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbCostAnalysisReportByIds(Long[] ids);

    /**
     * 执行全部删除
     */
    public void deleteAllCostAnalysisReport();
}
