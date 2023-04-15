package com.zero.system.cb.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.report.mapper.CbFixedCostReportViewMapper;
import com.zero.system.cb.report.domain.CbFixedCostReportView;
import com.zero.system.cb.report.service.ICbFixedCostReportViewService;

/**
 * 固定成本报表视图Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-23
 */
@Service
public class CbFixedCostReportViewServiceImpl implements ICbFixedCostReportViewService 
{
    @Autowired
    private CbFixedCostReportViewMapper cbFixedCostReportViewMapper;

    /**
     * 查询固定成本报表视图
     * 
     * @param type 固定成本报表视图主键
     * @return 固定成本报表视图
     */
    @Override
    public CbFixedCostReportView selectCbFixedCostReportViewByType(String type)
    {
        return cbFixedCostReportViewMapper.selectCbFixedCostReportViewByType(type);
    }

    /**
     * 查询固定成本报表视图列表
     * 
     * @param cbFixedCostReportView 固定成本报表视图
     * @return 固定成本报表视图
     */
    @Override
    public List<CbFixedCostReportView> selectCbFixedCostReportViewList(CbFixedCostReportView cbFixedCostReportView)
    {
        return cbFixedCostReportViewMapper.selectCbFixedCostReportViewList(cbFixedCostReportView);
    }

    /**
     * 新增固定成本报表视图
     * 
     * @param cbFixedCostReportView 固定成本报表视图
     * @return 结果
     */
    @Override
    public int insertCbFixedCostReportView(CbFixedCostReportView cbFixedCostReportView)
    {
        return cbFixedCostReportViewMapper.insertCbFixedCostReportView(cbFixedCostReportView);
    }

    /**
     * 修改固定成本报表视图
     * 
     * @param cbFixedCostReportView 固定成本报表视图
     * @return 结果
     */
    @Override
    public int updateCbFixedCostReportView(CbFixedCostReportView cbFixedCostReportView)
    {
        return cbFixedCostReportViewMapper.updateCbFixedCostReportView(cbFixedCostReportView);
    }

    /**
     * 批量删除固定成本报表视图
     * 
     * @param types 需要删除的固定成本报表视图主键
     * @return 结果
     */
    @Override
    public int deleteCbFixedCostReportViewByTypes(String[] types)
    {
        return cbFixedCostReportViewMapper.deleteCbFixedCostReportViewByTypes(types);
    }

    /**
     * 删除固定成本报表视图信息
     * 
     * @param type 固定成本报表视图主键
     * @return 结果
     */
    @Override
    public int deleteCbFixedCostReportViewByType(String type)
    {
        return cbFixedCostReportViewMapper.deleteCbFixedCostReportViewByType(type);
    }
}
