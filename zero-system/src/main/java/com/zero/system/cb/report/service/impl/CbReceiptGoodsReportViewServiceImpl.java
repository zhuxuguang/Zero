package com.zero.system.cb.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.report.mapper.CbReceiptGoodsReportViewMapper;
import com.zero.system.cb.report.domain.CbReceiptGoodsReportView;
import com.zero.system.cb.report.service.ICbReceiptGoodsReportViewService;

/**
 * 物资领用报表视图Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@Service
public class CbReceiptGoodsReportViewServiceImpl implements ICbReceiptGoodsReportViewService 
{
    @Autowired
    private CbReceiptGoodsReportViewMapper cbReceiptGoodsReportViewMapper;

    /**
     * 查询物资领用报表视图
     * 
     * @param type 物资领用报表视图主键
     * @return 物资领用报表视图
     */
    @Override
    public CbReceiptGoodsReportView selectCbReceiptGoodsReportViewByType(String type)
    {
        return cbReceiptGoodsReportViewMapper.selectCbReceiptGoodsReportViewByType(type);
    }

    /**
     * 查询物资领用报表视图列表
     * 
     * @param cbReceiptGoodsReportView 物资领用报表视图
     * @return 物资领用报表视图
     */
    @Override
    public List<CbReceiptGoodsReportView> selectCbReceiptGoodsReportViewList(CbReceiptGoodsReportView cbReceiptGoodsReportView)
    {
        return cbReceiptGoodsReportViewMapper.selectCbReceiptGoodsReportViewList(cbReceiptGoodsReportView);
    }

    /**
     * 新增物资领用报表视图
     * 
     * @param cbReceiptGoodsReportView 物资领用报表视图
     * @return 结果
     */
    @Override
    public int insertCbReceiptGoodsReportView(CbReceiptGoodsReportView cbReceiptGoodsReportView)
    {
        return cbReceiptGoodsReportViewMapper.insertCbReceiptGoodsReportView(cbReceiptGoodsReportView);
    }

    /**
     * 修改物资领用报表视图
     * 
     * @param cbReceiptGoodsReportView 物资领用报表视图
     * @return 结果
     */
    @Override
    public int updateCbReceiptGoodsReportView(CbReceiptGoodsReportView cbReceiptGoodsReportView)
    {
        return cbReceiptGoodsReportViewMapper.updateCbReceiptGoodsReportView(cbReceiptGoodsReportView);
    }

    /**
     * 批量删除物资领用报表视图
     * 
     * @param types 需要删除的物资领用报表视图主键
     * @return 结果
     */
    @Override
    public int deleteCbReceiptGoodsReportViewByTypes(String[] types)
    {
        return cbReceiptGoodsReportViewMapper.deleteCbReceiptGoodsReportViewByTypes(types);
    }

    /**
     * 删除物资领用报表视图信息
     * 
     * @param type 物资领用报表视图主键
     * @return 结果
     */
    @Override
    public int deleteCbReceiptGoodsReportViewByType(String type)
    {
        return cbReceiptGoodsReportViewMapper.deleteCbReceiptGoodsReportViewByType(type);
    }
}
