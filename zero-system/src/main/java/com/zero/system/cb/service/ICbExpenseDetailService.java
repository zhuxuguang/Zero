package com.zero.system.cb.service;

import java.util.List;
import com.zero.system.cb.domain.CbExpenseDetail;
import com.zero.system.cb.domain.CbProductionTarget;

/**
 * 费用明细Service接口
 * 
 * @author zhuxuguang
 * @date 2023-01-17
 */
public interface ICbExpenseDetailService 
{
    /**
     * 查询费用明细
     * 
     * @param id 费用明细主键
     * @return 费用明细
     */
    public CbExpenseDetail selectCbExpenseDetailById(Long id);

    /**
     * 查询费用明细列表
     * 
     * @param cbExpenseDetail 费用明细
     * @return 费用明细集合
     */
    public List<CbExpenseDetail> selectCbExpenseDetailList(CbExpenseDetail cbExpenseDetail);

    /**
     * 新增费用明细
     * 
     * @param cbExpenseDetail 费用明细
     * @return 结果
     */
    public int insertCbExpenseDetail(CbExpenseDetail cbExpenseDetail);

    /**
     * 修改费用明细
     * 
     * @param cbExpenseDetail 费用明细
     * @return 结果
     */
    public int updateCbExpenseDetail(CbExpenseDetail cbExpenseDetail);

    /**
     * 批量删除费用明细
     * 
     * @param ids 需要删除的费用明细主键集合
     * @return 结果
     */
    public int deleteCbExpenseDetailByIds(Long[] ids);

    /**
     * 删除费用明细信息
     * 
     * @param id 费用明细主键
     * @return 结果
     */
    public int deleteCbExpenseDetailById(Long id);


    /**
     * 导入费用明细数据
     *
     * @param cbEdList 费用明细数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importCbExpenseDetail(List<CbExpenseDetail> cbEdList, Boolean isUpdateSupport, String operName);
}
