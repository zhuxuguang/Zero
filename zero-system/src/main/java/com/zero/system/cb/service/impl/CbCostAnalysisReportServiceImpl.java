package com.zero.system.cb.service.impl;

import java.util.List;
import com.zero.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.mapper.CbCostAnalysisReportMapper;
import com.zero.system.cb.domain.CbCostAnalysisReport;
import com.zero.system.cb.service.ICbCostAnalysisReportService;

/**
 * 成本分析报表Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-20
 */
@Service
public class CbCostAnalysisReportServiceImpl implements ICbCostAnalysisReportService 
{
    @Autowired
    private CbCostAnalysisReportMapper cbCostAnalysisReportMapper;

    /**
     * 查询成本分析报表
     * 
     * @param id 成本分析报表主键
     * @return 成本分析报表
     */
    @Override
    public CbCostAnalysisReport selectCbCostAnalysisReportById(Long id)
    {
        return cbCostAnalysisReportMapper.selectCbCostAnalysisReportById(id);
    }

    /**
     * 查询成本分析报表列表
     * 
     * @param cbCostAnalysisReport 成本分析报表
     * @return 成本分析报表
     */
    @Override
    public List<CbCostAnalysisReport> selectCbCostAnalysisReportList(CbCostAnalysisReport cbCostAnalysisReport)
    {
        return cbCostAnalysisReportMapper.selectCbCostAnalysisReportList(cbCostAnalysisReport);
    }

    /**
     * 新增成本分析报表
     * 
     * @param cbCostAnalysisReport 成本分析报表
     * @return 结果
     */
    @Override
    public int insertCbCostAnalysisReport(CbCostAnalysisReport cbCostAnalysisReport)
    {
        cbCostAnalysisReport.setCreateTime(DateUtils.getNowDate());
        return cbCostAnalysisReportMapper.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }

    /**
     * 修改成本分析报表
     * 
     * @param cbCostAnalysisReport 成本分析报表
     * @return 结果
     */
    @Override
    public int updateCbCostAnalysisReport(CbCostAnalysisReport cbCostAnalysisReport)
    {
        cbCostAnalysisReport.setUpdateTime(DateUtils.getNowDate());
        return cbCostAnalysisReportMapper.updateCbCostAnalysisReport(cbCostAnalysisReport);
    }

    /**
     * 批量删除成本分析报表
     * 
     * @param ids 需要删除的成本分析报表主键
     * @return 结果
     */
    @Override
    public int deleteCbCostAnalysisReportByIds(Long[] ids)
    {
        return cbCostAnalysisReportMapper.deleteCbCostAnalysisReportByIds(ids);
    }

    /**
     * 删除成本分析报表信息
     * 
     * @param id 成本分析报表主键
     * @return 结果
     */
    @Override
    public int deleteCbCostAnalysisReportById(Long id)
    {
        return cbCostAnalysisReportMapper.deleteCbCostAnalysisReportById(id);
    }

    /**
     * 执行全部删除
     */
    @Override
    public void deleteAllCostAnalysisReport() {
        cbCostAnalysisReportMapper.deleteAllCostAnalysisReport();
    }
}
