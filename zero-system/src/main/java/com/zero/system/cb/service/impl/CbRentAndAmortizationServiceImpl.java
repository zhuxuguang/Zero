package com.zero.system.cb.service.impl;

import java.util.List;
import com.zero.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.mapper.CbRentAndAmortizationMapper;
import com.zero.system.cb.domain.CbRentAndAmortization;
import com.zero.system.cb.service.ICbRentAndAmortizationService;

/**
 * 租金及摊销Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-01-12
 */
@Service
public class CbRentAndAmortizationServiceImpl implements ICbRentAndAmortizationService 
{
    @Autowired
    private CbRentAndAmortizationMapper cbRentAndAmortizationMapper;

    /**
     * 查询租金及摊销
     * 
     * @param id 租金及摊销主键
     * @return 租金及摊销
     */
    @Override
    public CbRentAndAmortization selectCbRentAndAmortizationById(Long id)
    {
        return cbRentAndAmortizationMapper.selectCbRentAndAmortizationById(id);
    }

    /**
     * 查询租金及摊销列表
     * 
     * @param cbRentAndAmortization 租金及摊销
     * @return 租金及摊销
     */
    @Override
    public List<CbRentAndAmortization> selectCbRentAndAmortizationList(CbRentAndAmortization cbRentAndAmortization)
    {
        return cbRentAndAmortizationMapper.selectCbRentAndAmortizationList(cbRentAndAmortization);
    }

    /**
     * 新增租金及摊销
     * 
     * @param cbRentAndAmortization 租金及摊销
     * @return 结果
     */
    @Override
    public int insertCbRentAndAmortization(CbRentAndAmortization cbRentAndAmortization)
    {
        cbRentAndAmortization.setCreateTime(DateUtils.getNowDate());
        return cbRentAndAmortizationMapper.insertCbRentAndAmortization(cbRentAndAmortization);
    }

    /**
     * 修改租金及摊销
     * 
     * @param cbRentAndAmortization 租金及摊销
     * @return 结果
     */
    @Override
    public int updateCbRentAndAmortization(CbRentAndAmortization cbRentAndAmortization)
    {
        cbRentAndAmortization.setUpdateTime(DateUtils.getNowDate());
        return cbRentAndAmortizationMapper.updateCbRentAndAmortization(cbRentAndAmortization);
    }

    /**
     * 批量删除租金及摊销
     * 
     * @param ids 需要删除的租金及摊销主键
     * @return 结果
     */
    @Override
    public int deleteCbRentAndAmortizationByIds(Long[] ids)
    {
        return cbRentAndAmortizationMapper.deleteCbRentAndAmortizationByIds(ids);
    }

    /**
     * 删除租金及摊销信息
     * 
     * @param id 租金及摊销主键
     * @return 结果
     */
    @Override
    public int deleteCbRentAndAmortizationById(Long id)
    {
        return cbRentAndAmortizationMapper.deleteCbRentAndAmortizationById(id);
    }

    /**
     * 删除租金及摊销信息
     *
     * @param id 租金单据id
     * @return 结果
     */
    @Override
    public int deleteCbRentAndAmortizationByRiId(Long id) {
        return cbRentAndAmortizationMapper.deleteCbRentAndAmortizationByRiId(id);
    }
}
