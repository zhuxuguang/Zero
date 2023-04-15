package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbProductionTarget;

/**
 * 生产目标Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-01-05
 */
public interface CbProductionTargetMapper 
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
     * 删除生产目标
     * 
     * @param id 生产目标主键
     * @return 结果
     */
    public int deleteCbProductionTargetById(Long id);

    /**
     * 批量删除生产目标
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbProductionTargetByIds(Long[] ids);
}
