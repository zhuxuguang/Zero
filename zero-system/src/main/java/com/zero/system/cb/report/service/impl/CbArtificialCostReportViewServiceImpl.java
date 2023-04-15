package com.zero.system.cb.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.report.mapper.CbArtificialCostReportViewMapper;
import com.zero.system.cb.report.domain.CbArtificialCostReportView;
import com.zero.system.cb.report.service.ICbArtificialCostReportViewService;

/**
 * 人工成本计算视图Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@Service
public class CbArtificialCostReportViewServiceImpl implements ICbArtificialCostReportViewService 
{
    @Autowired
    private CbArtificialCostReportViewMapper cbArtificialCostReportViewMapper;

    /**
     * 查询人工成本计算视图
     * 
     * @param type 人工成本计算视图主键
     * @return 人工成本计算视图
     */
    @Override
    public CbArtificialCostReportView selectCbArtificialCostReportViewByType(String type)
    {
        return cbArtificialCostReportViewMapper.selectCbArtificialCostReportViewByType(type);
    }

    /**
     * 查询人工成本计算视图列表
     * 
     * @param cbArtificialCostReportView 人工成本计算视图
     * @return 人工成本计算视图
     */
    @Override
    public List<CbArtificialCostReportView> selectCbArtificialCostReportViewList(CbArtificialCostReportView cbArtificialCostReportView)
    {
        return cbArtificialCostReportViewMapper.selectCbArtificialCostReportViewList(cbArtificialCostReportView);
    }

    /**
     * 新增人工成本计算视图
     * 
     * @param cbArtificialCostReportView 人工成本计算视图
     * @return 结果
     */
    @Override
    public int insertCbArtificialCostReportView(CbArtificialCostReportView cbArtificialCostReportView)
    {
        return cbArtificialCostReportViewMapper.insertCbArtificialCostReportView(cbArtificialCostReportView);
    }

    /**
     * 修改人工成本计算视图
     * 
     * @param cbArtificialCostReportView 人工成本计算视图
     * @return 结果
     */
    @Override
    public int updateCbArtificialCostReportView(CbArtificialCostReportView cbArtificialCostReportView)
    {
        return cbArtificialCostReportViewMapper.updateCbArtificialCostReportView(cbArtificialCostReportView);
    }

    /**
     * 批量删除人工成本计算视图
     * 
     * @param types 需要删除的人工成本计算视图主键
     * @return 结果
     */
    @Override
    public int deleteCbArtificialCostReportViewByTypes(String[] types)
    {
        return cbArtificialCostReportViewMapper.deleteCbArtificialCostReportViewByTypes(types);
    }

    /**
     * 删除人工成本计算视图信息
     * 
     * @param type 人工成本计算视图主键
     * @return 结果
     */
    @Override
    public int deleteCbArtificialCostReportViewByType(String type)
    {
        return cbArtificialCostReportViewMapper.deleteCbArtificialCostReportViewByType(type);
    }
}
