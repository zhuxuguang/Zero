package com.zero.system.cb.report.mapper;

import java.util.List;
import com.zero.system.cb.report.domain.CbAvgAdfiCostView;

/**
 * 头均日采食量和成本计算视图Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
public interface CbAvgAdfiCostViewMapper 
{
    /**
     * 查询头均日采食量和成本计算视图
     * 
     * @param type 头均日采食量和成本计算视图主键
     * @return 头均日采食量和成本计算视图
     */
    public CbAvgAdfiCostView selectCbAvgAdfiCostViewByType(String type);

    /**
     * 查询头均日采食量和成本计算视图列表
     * 
     * @param cbAvgAdfiCostView 头均日采食量和成本计算视图
     * @return 头均日采食量和成本计算视图集合
     */
    public List<CbAvgAdfiCostView> selectCbAvgAdfiCostViewList(CbAvgAdfiCostView cbAvgAdfiCostView);

    /**
     * 新增头均日采食量和成本计算视图
     * 
     * @param cbAvgAdfiCostView 头均日采食量和成本计算视图
     * @return 结果
     */
    public int insertCbAvgAdfiCostView(CbAvgAdfiCostView cbAvgAdfiCostView);

    /**
     * 修改头均日采食量和成本计算视图
     * 
     * @param cbAvgAdfiCostView 头均日采食量和成本计算视图
     * @return 结果
     */
    public int updateCbAvgAdfiCostView(CbAvgAdfiCostView cbAvgAdfiCostView);

    /**
     * 删除头均日采食量和成本计算视图
     * 
     * @param type 头均日采食量和成本计算视图主键
     * @return 结果
     */
    public int deleteCbAvgAdfiCostViewByType(String type);

    /**
     * 批量删除头均日采食量和成本计算视图
     * 
     * @param types 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbAvgAdfiCostViewByTypes(String[] types);
}
