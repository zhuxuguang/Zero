package com.zero.system.cb.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.report.mapper.CbAvgAdfiCostViewMapper;
import com.zero.system.cb.report.domain.CbAvgAdfiCostView;
import com.zero.system.cb.report.service.ICbAvgAdfiCostViewService;

/**
 * 头均日采食量和成本计算视图Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@Service
public class CbAvgAdfiCostViewServiceImpl implements ICbAvgAdfiCostViewService 
{
    @Autowired
    private CbAvgAdfiCostViewMapper cbAvgAdfiCostViewMapper;

    /**
     * 查询头均日采食量和成本计算视图
     * 
     * @param type 头均日采食量和成本计算视图主键
     * @return 头均日采食量和成本计算视图
     */
    @Override
    public CbAvgAdfiCostView selectCbAvgAdfiCostViewByType(String type)
    {
        return cbAvgAdfiCostViewMapper.selectCbAvgAdfiCostViewByType(type);
    }

    /**
     * 查询头均日采食量和成本计算视图列表
     * 
     * @param cbAvgAdfiCostView 头均日采食量和成本计算视图
     * @return 头均日采食量和成本计算视图
     */
    @Override
    public List<CbAvgAdfiCostView> selectCbAvgAdfiCostViewList(CbAvgAdfiCostView cbAvgAdfiCostView)
    {
        return cbAvgAdfiCostViewMapper.selectCbAvgAdfiCostViewList(cbAvgAdfiCostView);
    }

    /**
     * 新增头均日采食量和成本计算视图
     * 
     * @param cbAvgAdfiCostView 头均日采食量和成本计算视图
     * @return 结果
     */
    @Override
    public int insertCbAvgAdfiCostView(CbAvgAdfiCostView cbAvgAdfiCostView)
    {
        return cbAvgAdfiCostViewMapper.insertCbAvgAdfiCostView(cbAvgAdfiCostView);
    }

    /**
     * 修改头均日采食量和成本计算视图
     * 
     * @param cbAvgAdfiCostView 头均日采食量和成本计算视图
     * @return 结果
     */
    @Override
    public int updateCbAvgAdfiCostView(CbAvgAdfiCostView cbAvgAdfiCostView)
    {
        return cbAvgAdfiCostViewMapper.updateCbAvgAdfiCostView(cbAvgAdfiCostView);
    }

    /**
     * 批量删除头均日采食量和成本计算视图
     * 
     * @param types 需要删除的头均日采食量和成本计算视图主键
     * @return 结果
     */
    @Override
    public int deleteCbAvgAdfiCostViewByTypes(String[] types)
    {
        return cbAvgAdfiCostViewMapper.deleteCbAvgAdfiCostViewByTypes(types);
    }

    /**
     * 删除头均日采食量和成本计算视图信息
     * 
     * @param type 头均日采食量和成本计算视图主键
     * @return 结果
     */
    @Override
    public int deleteCbAvgAdfiCostViewByType(String type)
    {
        return cbAvgAdfiCostViewMapper.deleteCbAvgAdfiCostViewByType(type);
    }
}
