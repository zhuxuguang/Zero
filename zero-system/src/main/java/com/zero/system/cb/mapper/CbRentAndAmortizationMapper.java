package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbRentAndAmortization;

/**
 * 租金及摊销Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-01-12
 */
public interface CbRentAndAmortizationMapper 
{
    /**
     * 查询租金及摊销
     * 
     * @param id 租金及摊销主键
     * @return 租金及摊销
     */
    public CbRentAndAmortization selectCbRentAndAmortizationById(Long id);

    /**
     * 查询租金及摊销列表
     * 
     * @param cbRentAndAmortization 租金及摊销
     * @return 租金及摊销集合
     */
    public List<CbRentAndAmortization> selectCbRentAndAmortizationList(CbRentAndAmortization cbRentAndAmortization);

    /**
     * 新增租金及摊销
     * 
     * @param cbRentAndAmortization 租金及摊销
     * @return 结果
     */
    public int insertCbRentAndAmortization(CbRentAndAmortization cbRentAndAmortization);

    /**
     * 修改租金及摊销
     * 
     * @param cbRentAndAmortization 租金及摊销
     * @return 结果
     */
    public int updateCbRentAndAmortization(CbRentAndAmortization cbRentAndAmortization);

    /**
     * 删除租金及摊销
     * 
     * @param id 租金及摊销主键
     * @return 结果
     */
    public int deleteCbRentAndAmortizationById(Long id);

    /**
     * 批量删除租金及摊销
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbRentAndAmortizationByIds(Long[] ids);

    /**
     * 删除租金及摊销信息
     *
     * @param id 租金单据id
     * @return 结果
     */
    public int deleteCbRentAndAmortizationByRiId(Long id);
}
