package com.zero.system.cb.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.mapper.CbRentInvoicesMapper;
import com.zero.system.cb.domain.CbRentInvoices;
import com.zero.system.cb.service.ICbRentInvoicesService;

/**
 * 租金录入单据Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-08
 */
@Service
public class CbRentInvoicesServiceImpl implements ICbRentInvoicesService 
{
    @Autowired
    private CbRentInvoicesMapper cbRentInvoicesMapper;

    /**
     * 查询租金录入单据
     * 
     * @param id 租金录入单据主键
     * @return 租金录入单据
     */
    @Override
    public CbRentInvoices selectCbRentInvoicesById(Long id)
    {
        return cbRentInvoicesMapper.selectCbRentInvoicesById(id);
    }

    /**
     * 查询租金录入单据列表
     * 
     * @param cbRentInvoices 租金录入单据
     * @return 租金录入单据
     */
    @Override
    public List<CbRentInvoices> selectCbRentInvoicesList(CbRentInvoices cbRentInvoices)
    {
        return cbRentInvoicesMapper.selectCbRentInvoicesList(cbRentInvoices);
    }

    /**
     * 新增租金录入单据
     * 
     * @param cbRentInvoices 租金录入单据
     * @return 结果
     */
    @Override
    public int insertCbRentInvoices(CbRentInvoices cbRentInvoices)
    {
        //创建日期
        cbRentInvoices.setCreateTime(DateUtils.getNowDate());
        return cbRentInvoicesMapper.insertCbRentInvoices(cbRentInvoices);
    }

    /**
     * 修改租金录入单据
     * 
     * @param cbRentInvoices 租金录入单据
     * @return 结果
     */
    @Override
    public int updateCbRentInvoices(CbRentInvoices cbRentInvoices)
    {
        cbRentInvoices.setUpdateTime(DateUtils.getNowDate());
        return cbRentInvoicesMapper.updateCbRentInvoices(cbRentInvoices);
    }

    /**
     * 批量删除租金录入单据
     * 
     * @param ids 需要删除的租金录入单据主键
     * @return 结果
     */
    @Override
    public int deleteCbRentInvoicesByIds(Long[] ids)
    {
        return cbRentInvoicesMapper.deleteCbRentInvoicesByIds(ids);
    }

    /**
     * 删除租金录入单据信息
     * 
     * @param id 租金录入单据主键
     * @return 结果
     */
    @Override
    public int deleteCbRentInvoicesById(Long id)
    {
        return cbRentInvoicesMapper.deleteCbRentInvoicesById(id);
    }

    /**
     * 审核租金录入单据信息
     *
     * @param id 租金录入单据主键
     * @return 结果
     */
    @Override
    public int checkCbRentInvoicesById(Long id) {
        return 0;
    }

    /**
     * 反审核租金录入单据信息
     *
     * @param id 租金录入单据主键
     * @return 结果
     */
    @Override
    public int onCheckCbRentInvoicesById(Long id) {
        return 0;
    }


}
