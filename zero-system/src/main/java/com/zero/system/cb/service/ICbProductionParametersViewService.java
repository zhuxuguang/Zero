package com.zero.system.cb.service;

import java.util.List;
import com.zero.system.cb.domain.CbProductionParametersView;

/**
 * 成本分析数据获取Service接口
 * 
 * @author zhuxuguang
 * @date 2023-02-20
 */
public interface ICbProductionParametersViewService 
{
    /**
     * 查询成本分析数据获取
     * 
     * @param type 成本分析数据获取主键
     * @return 成本分析数据获取
     */
    public CbProductionParametersView selectCbProductionParametersViewByType(String type);

    /**
     * 查询成本分析数据获取列表
     * 
     * @param cbProductionParametersView 成本分析数据获取
     * @return 成本分析数据获取集合
     */
    public List<CbProductionParametersView> selectCbProductionParametersViewList(CbProductionParametersView cbProductionParametersView);

    /**
     * 新增成本分析数据获取
     * 
     * @param cbProductionParametersView 成本分析数据获取
     * @return 结果
     */
    public int insertCbProductionParametersView(CbProductionParametersView cbProductionParametersView);

    /**
     * 修改成本分析数据获取
     * 
     * @param cbProductionParametersView 成本分析数据获取
     * @return 结果
     */
    public int updateCbProductionParametersView(CbProductionParametersView cbProductionParametersView);

    /**
     * 批量删除成本分析数据获取
     * 
     * @param types 需要删除的成本分析数据获取主键集合
     * @return 结果
     */
    public int deleteCbProductionParametersViewByTypes(String[] types);

    /**
     * 删除成本分析数据获取信息
     * 
     * @param type 成本分析数据获取主键
     * @return 结果
     */
    public int deleteCbProductionParametersViewByType(String type);
}
