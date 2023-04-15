package com.zero.system.cb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.mapper.CbProductionParametersViewMapper;
import com.zero.system.cb.domain.CbProductionParametersView;
import com.zero.system.cb.service.ICbProductionParametersViewService;

/**
 * 成本分析数据获取Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-20
 */
@Service
public class CbProductionParametersViewServiceImpl implements ICbProductionParametersViewService 
{
    @Autowired
    private CbProductionParametersViewMapper cbProductionParametersViewMapper;

    /**
     * 查询成本分析数据获取
     * 
     * @param type 成本分析数据获取主键
     * @return 成本分析数据获取
     */
    @Override
    public CbProductionParametersView selectCbProductionParametersViewByType(String type)
    {
        return cbProductionParametersViewMapper.selectCbProductionParametersViewByType(type);
    }

    /**
     * 查询成本分析数据获取列表
     * 
     * @param cbProductionParametersView 成本分析数据获取
     * @return 成本分析数据获取
     */
    @Override
    public List<CbProductionParametersView> selectCbProductionParametersViewList(CbProductionParametersView cbProductionParametersView)
    {
        return cbProductionParametersViewMapper.selectCbProductionParametersViewList(cbProductionParametersView);
    }

    /**
     * 新增成本分析数据获取
     * 
     * @param cbProductionParametersView 成本分析数据获取
     * @return 结果
     */
    @Override
    public int insertCbProductionParametersView(CbProductionParametersView cbProductionParametersView)
    {
        return cbProductionParametersViewMapper.insertCbProductionParametersView(cbProductionParametersView);
    }

    /**
     * 修改成本分析数据获取
     * 
     * @param cbProductionParametersView 成本分析数据获取
     * @return 结果
     */
    @Override
    public int updateCbProductionParametersView(CbProductionParametersView cbProductionParametersView)
    {
        return cbProductionParametersViewMapper.updateCbProductionParametersView(cbProductionParametersView);
    }

    /**
     * 批量删除成本分析数据获取
     * 
     * @param types 需要删除的成本分析数据获取主键
     * @return 结果
     */
    @Override
    public int deleteCbProductionParametersViewByTypes(String[] types)
    {
        return cbProductionParametersViewMapper.deleteCbProductionParametersViewByTypes(types);
    }

    /**
     * 删除成本分析数据获取信息
     * 
     * @param type 成本分析数据获取主键
     * @return 结果
     */
    @Override
    public int deleteCbProductionParametersViewByType(String type)
    {
        return cbProductionParametersViewMapper.deleteCbProductionParametersViewByType(type);
    }
}
