package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbExpenseDetail;

/**
 * 费用明细Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-01-17
 */
public interface CbExpenseDetailMapper 
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
     * 删除费用明细
     * 
     * @param id 费用明细主键
     * @return 结果
     */
    public int deleteCbExpenseDetailById(Long id);

    /**
     * 批量删除费用明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbExpenseDetailByIds(Long[] ids);
}
