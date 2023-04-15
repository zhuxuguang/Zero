package com.zero.system.cb.report.mapper;

import java.util.List;
import com.zero.system.cb.report.domain.CbFixedCostReportView;

/**
 * 固定成本报表视图Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-02-23
 */
public interface CbFixedCostReportViewMapper 
{
    /**
     * 查询固定成本报表视图
     * 
     * @param type 固定成本报表视图主键
     * @return 固定成本报表视图
     */
    public CbFixedCostReportView selectCbFixedCostReportViewByType(String type);

    /**
     * 查询固定成本报表视图列表
     * 
     * @param cbFixedCostReportView 固定成本报表视图
     * @return 固定成本报表视图集合
     */
    public List<CbFixedCostReportView> selectCbFixedCostReportViewList(CbFixedCostReportView cbFixedCostReportView);

    /**
     * 新增固定成本报表视图
     * 
     * @param cbFixedCostReportView 固定成本报表视图
     * @return 结果
     */
    public int insertCbFixedCostReportView(CbFixedCostReportView cbFixedCostReportView);

    /**
     * 修改固定成本报表视图
     * 
     * @param cbFixedCostReportView 固定成本报表视图
     * @return 结果
     */
    public int updateCbFixedCostReportView(CbFixedCostReportView cbFixedCostReportView);

    /**
     * 删除固定成本报表视图
     * 
     * @param type 固定成本报表视图主键
     * @return 结果
     */
    public int deleteCbFixedCostReportViewByType(String type);

    /**
     * 批量删除固定成本报表视图
     * 
     * @param types 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbFixedCostReportViewByTypes(String[] types);
}
