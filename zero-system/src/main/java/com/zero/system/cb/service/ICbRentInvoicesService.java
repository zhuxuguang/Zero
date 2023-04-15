package com.zero.system.cb.service;

import java.util.List;
import com.zero.system.cb.domain.CbRentInvoices;

/**
 * 租金录入单据Service接口
 * 
 * @author zhuxuguang
 * @date 2023-02-08
 */
public interface ICbRentInvoicesService 
{
    /**
     * 查询租金录入单据
     * 
     * @param id 租金录入单据主键
     * @return 租金录入单据
     */
    public CbRentInvoices selectCbRentInvoicesById(Long id);

    /**
     * 查询租金录入单据列表
     * 
     * @param cbRentInvoices 租金录入单据
     * @return 租金录入单据集合
     */
    public List<CbRentInvoices> selectCbRentInvoicesList(CbRentInvoices cbRentInvoices);

    /**
     * 新增租金录入单据
     * 
     * @param cbRentInvoices 租金录入单据
     * @return 结果
     */
    public int insertCbRentInvoices(CbRentInvoices cbRentInvoices);

    /**
     * 修改租金录入单据
     * 
     * @param cbRentInvoices 租金录入单据
     * @return 结果
     */
    public int updateCbRentInvoices(CbRentInvoices cbRentInvoices);

    /**
     * 批量删除租金录入单据
     * 
     * @param ids 需要删除的租金录入单据主键集合
     * @return 结果
     */
    public int deleteCbRentInvoicesByIds(Long[] ids);

    /**
     * 删除租金录入单据信息
     * 
     * @param id 租金录入单据主键
     * @return 结果
     */
    public int deleteCbRentInvoicesById(Long id);

    /**
     * 审核租金录入单据信息
     *
     * @param id 租金录入单据主键
     * @return 结果
     */
    public int checkCbRentInvoicesById(Long id);

    /**
     * 反审核租金录入单据信息
     *
     * @param id 租金录入单据主键
     * @return 结果
     */
    public int onCheckCbRentInvoicesById(Long id);
}
