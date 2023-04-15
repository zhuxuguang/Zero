package com.zero.system.cb.service;

import java.util.List;
import com.zero.system.cb.domain.CbBreedingStock;
import com.zero.system.cb.domain.CbProductionTarget;

/**
 * 存栏情况Service接口
 * 
 * @author zhuxuguang
 * @date 2023-01-30
 */
public interface ICbBreedingStockService 
{
    /**
     * 查询存栏情况
     * 
     * @param id 存栏情况主键
     * @return 存栏情况
     */
    public CbBreedingStock selectCbBreedingStockById(Long id);

    /**
     * 查询存栏情况列表
     * 
     * @param cbBreedingStock 存栏情况
     * @return 存栏情况集合
     */
    public List<CbBreedingStock> selectCbBreedingStockList(CbBreedingStock cbBreedingStock);

    /**
     * 新增存栏情况
     * 
     * @param cbBreedingStock 存栏情况
     * @return 结果
     */
    public int insertCbBreedingStock(CbBreedingStock cbBreedingStock);

    /**
     * 修改存栏情况
     * 
     * @param cbBreedingStock 存栏情况
     * @return 结果
     */
    public int updateCbBreedingStock(CbBreedingStock cbBreedingStock);

    /**
     * 批量删除存栏情况
     * 
     * @param ids 需要删除的存栏情况主键集合
     * @return 结果
     */
    public int deleteCbBreedingStockByIds(Long[] ids);

    /**
     * 删除存栏情况信息
     * 
     * @param id 存栏情况主键
     * @return 结果
     */
    public int deleteCbBreedingStockById(Long id);

    /**
     * 导入存栏情况数据
     *
     * @param cbBsList 存栏情况数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importCbBreedingStock(List<CbBreedingStock> cbBsList, Boolean isUpdateSupport, String operName);
}
