package com.zero.system.cb.service;

import java.util.List;

import com.zero.common.core.domain.entity.SysUser;
import com.zero.system.cb.domain.CbProductionTarget;

/**
 * 生产目标Service接口
 * 
 * @author zhuxuguang
 * @date 2023-01-05
 */
public interface ICbProductionTargetService 
{
    /**
     * 查询生产目标
     * 
     * @param id 生产目标主键
     * @return 生产目标
     */
    public CbProductionTarget selectCbProductionTargetById(Long id);

    /**
     * 查询生产目标列表
     * 
     * @param cbProductionTarget 生产目标
     * @return 生产目标集合
     */
    public List<CbProductionTarget> selectCbProductionTargetList(CbProductionTarget cbProductionTarget);

    /**
     * 新增生产目标
     * 
     * @param cbProductionTarget 生产目标
     * @return 结果
     */
    public int insertCbProductionTarget(CbProductionTarget cbProductionTarget);

    /**
     * 修改生产目标
     * 
     * @param cbProductionTarget 生产目标
     * @return 结果
     */
    public int updateCbProductionTarget(CbProductionTarget cbProductionTarget);

    /**
     * 批量删除生产目标
     * 
     * @param ids 需要删除的生产目标主键集合
     * @return 结果
     */
    public int deleteCbProductionTargetByIds(Long[] ids);

    /**
     * 删除生产目标信息
     * 
     * @param id 生产目标主键
     * @return 结果
     */
    public int deleteCbProductionTargetById(Long id);



    /**
     * 导入生产目标数据
     *
     * @param cbPtList 生产目标数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importCbProductionTarget(List<CbProductionTarget> cbPtList, Boolean isUpdateSupport, String operName);
}
