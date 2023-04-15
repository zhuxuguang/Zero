package com.zero.system.cb.report.mapper;

import java.util.List;
import com.zero.system.cb.report.domain.CbReceiptGoodsReportView;

/**
 * 物资领用报表视图Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
public interface CbReceiptGoodsReportViewMapper 
{
    /**
     * 查询物资领用报表视图
     * 
     * @param type 物资领用报表视图主键
     * @return 物资领用报表视图
     */
    public CbReceiptGoodsReportView selectCbReceiptGoodsReportViewByType(String type);

    /**
     * 查询物资领用报表视图列表
     * 
     * @param cbReceiptGoodsReportView 物资领用报表视图
     * @return 物资领用报表视图集合
     */
    public List<CbReceiptGoodsReportView> selectCbReceiptGoodsReportViewList(CbReceiptGoodsReportView cbReceiptGoodsReportView);

    /**
     * 新增物资领用报表视图
     * 
     * @param cbReceiptGoodsReportView 物资领用报表视图
     * @return 结果
     */
    public int insertCbReceiptGoodsReportView(CbReceiptGoodsReportView cbReceiptGoodsReportView);

    /**
     * 修改物资领用报表视图
     * 
     * @param cbReceiptGoodsReportView 物资领用报表视图
     * @return 结果
     */
    public int updateCbReceiptGoodsReportView(CbReceiptGoodsReportView cbReceiptGoodsReportView);

    /**
     * 删除物资领用报表视图
     * 
     * @param type 物资领用报表视图主键
     * @return 结果
     */
    public int deleteCbReceiptGoodsReportViewByType(String type);

    /**
     * 批量删除物资领用报表视图
     * 
     * @param types 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbReceiptGoodsReportViewByTypes(String[] types);
}
