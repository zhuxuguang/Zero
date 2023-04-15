package com.zero.system.cb.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.report.mapper.CbFabricateReportViewMapper;
import com.zero.system.cb.report.domain.CbFabricateReportView;
import com.zero.system.cb.report.service.ICbFabricateReportViewService;

/**
 * 制造费用报表视图Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@Service
public class CbFabricateReportViewServiceImpl implements ICbFabricateReportViewService 
{
    @Autowired
    private CbFabricateReportViewMapper cbFabricateReportViewMapper;

    /**
     * 查询制造费用报表视图
     * 
     * @param type 制造费用报表视图主键
     * @return 制造费用报表视图
     */
    @Override
    public CbFabricateReportView selectCbFabricateReportViewByType(String type)
    {
        return cbFabricateReportViewMapper.selectCbFabricateReportViewByType(type);
    }

    /**
     * 查询制造费用报表视图列表
     * 
     * @param cbFabricateReportView 制造费用报表视图
     * @return 制造费用报表视图
     */
    @Override
    public List<CbFabricateReportView> selectCbFabricateReportViewList(CbFabricateReportView cbFabricateReportView)
    {
        return cbFabricateReportViewMapper.selectCbFabricateReportViewList(cbFabricateReportView);
    }

    /**
     * 新增制造费用报表视图
     * 
     * @param cbFabricateReportView 制造费用报表视图
     * @return 结果
     */
    @Override
    public int insertCbFabricateReportView(CbFabricateReportView cbFabricateReportView)
    {
        return cbFabricateReportViewMapper.insertCbFabricateReportView(cbFabricateReportView);
    }

    /**
     * 修改制造费用报表视图
     * 
     * @param cbFabricateReportView 制造费用报表视图
     * @return 结果
     */
    @Override
    public int updateCbFabricateReportView(CbFabricateReportView cbFabricateReportView)
    {
        return cbFabricateReportViewMapper.updateCbFabricateReportView(cbFabricateReportView);
    }

    /**
     * 批量删除制造费用报表视图
     * 
     * @param types 需要删除的制造费用报表视图主键
     * @return 结果
     */
    @Override
    public int deleteCbFabricateReportViewByTypes(String[] types)
    {
        return cbFabricateReportViewMapper.deleteCbFabricateReportViewByTypes(types);
    }

    /**
     * 删除制造费用报表视图信息
     * 
     * @param type 制造费用报表视图主键
     * @return 结果
     */
    @Override
    public int deleteCbFabricateReportViewByType(String type)
    {
        return cbFabricateReportViewMapper.deleteCbFabricateReportViewByType(type);
    }
}
