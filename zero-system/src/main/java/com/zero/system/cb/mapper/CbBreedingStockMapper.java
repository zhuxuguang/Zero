package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbBreedingStock;

/**
 * 存栏情况Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-01-30
 */
public interface CbBreedingStockMapper 
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
     * 删除存栏情况
     * 
     * @param id 存栏情况主键
     * @return 结果
     */
    public int deleteCbBreedingStockById(Long id);

    /**
     * 批量删除存栏情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbBreedingStockByIds(Long[] ids);
}
