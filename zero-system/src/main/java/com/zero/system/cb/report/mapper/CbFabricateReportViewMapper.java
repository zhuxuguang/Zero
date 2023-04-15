package com.zero.system.cb.report.mapper;

import java.util.List;
import com.zero.system.cb.report.domain.CbFabricateReportView;

/**
 * 制造费用报表视图Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
public interface CbFabricateReportViewMapper 
{
    /**
     * 查询制造费用报表视图
     * 
     * @param type 制造费用报表视图主键
     * @return 制造费用报表视图
     */
    public CbFabricateReportView selectCbFabricateReportViewByType(String type);

    /**
     * 查询制造费用报表视图列表
     * 
     * @param cbFabricateReportView 制造费用报表视图
     * @return 制造费用报表视图集合
     */
    public List<CbFabricateReportView> selectCbFabricateReportViewList(CbFabricateReportView cbFabricateReportView);

    /**
     * 新增制造费用报表视图
     * 
     * @param cbFabricateReportView 制造费用报表视图
     * @return 结果
     */
    public int insertCbFabricateReportView(CbFabricateReportView cbFabricateReportView);

    /**
     * 修改制造费用报表视图
     * 
     * @param cbFabricateReportView 制造费用报表视图
     * @return 结果
     */
    public int updateCbFabricateReportView(CbFabricateReportView cbFabricateReportView);

    /**
     * 删除制造费用报表视图
     * 
     * @param type 制造费用报表视图主键
     * @return 结果
     */
    public int deleteCbFabricateReportViewByType(String type);

    /**
     * 批量删除制造费用报表视图
     * 
     * @param types 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbFabricateReportViewByTypes(String[] types);
}
