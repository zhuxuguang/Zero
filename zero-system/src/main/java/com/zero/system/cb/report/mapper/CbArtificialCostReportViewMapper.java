package com.zero.system.cb.report.mapper;

import java.util.List;
import com.zero.system.cb.report.domain.CbArtificialCostReportView;

/**
 * 人工成本计算视图Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
public interface CbArtificialCostReportViewMapper 
{
    /**
     * 查询人工成本计算视图
     * 
     * @param type 人工成本计算视图主键
     * @return 人工成本计算视图
     */
    public CbArtificialCostReportView selectCbArtificialCostReportViewByType(String type);

    /**
     * 查询人工成本计算视图列表
     * 
     * @param cbArtificialCostReportView 人工成本计算视图
     * @return 人工成本计算视图集合
     */
    public List<CbArtificialCostReportView> selectCbArtificialCostReportViewList(CbArtificialCostReportView cbArtificialCostReportView);

    /**
     * 新增人工成本计算视图
     * 
     * @param cbArtificialCostReportView 人工成本计算视图
     * @return 结果
     */
    public int insertCbArtificialCostReportView(CbArtificialCostReportView cbArtificialCostReportView);

    /**
     * 修改人工成本计算视图
     * 
     * @param cbArtificialCostReportView 人工成本计算视图
     * @return 结果
     */
    public int updateCbArtificialCostReportView(CbArtificialCostReportView cbArtificialCostReportView);

    /**
     * 删除人工成本计算视图
     * 
     * @param type 人工成本计算视图主键
     * @return 结果
     */
    public int deleteCbArtificialCostReportViewByType(String type);

    /**
     * 批量删除人工成本计算视图
     * 
     * @param types 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbArtificialCostReportViewByTypes(String[] types);
}
