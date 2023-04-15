package com.zero.system.cb.service;

import java.util.List;
import com.zero.system.cb.domain.CbArtificial;
import com.zero.system.cb.domain.CbProductionTarget;

/**
 * 人工Service接口
 * 
 * @author zhuxuguang
 * @date 2023-02-06
 */
public interface ICbArtificialService 
{
    /**
     * 查询人工
     * 
     * @param id 人工主键
     * @return 人工
     */
    public CbArtificial selectCbArtificialById(Long id);

    /**
     * 查询人工列表
     * 
     * @param cbArtificial 人工
     * @return 人工集合
     */
    public List<CbArtificial> selectCbArtificialList(CbArtificial cbArtificial);

    /**
     * 新增人工
     * 
     * @param cbArtificial 人工
     * @return 结果
     */
    public int insertCbArtificial(CbArtificial cbArtificial);

    /**
     * 修改人工
     * 
     * @param cbArtificial 人工
     * @return 结果
     */
    public int updateCbArtificial(CbArtificial cbArtificial);

    /**
     * 批量删除人工
     * 
     * @param ids 需要删除的人工主键集合
     * @return 结果
     */
    public int deleteCbArtificialByIds(Long[] ids);

    /**
     * 删除人工信息
     * 
     * @param id 人工主键
     * @return 结果
     */
    public int deleteCbArtificialById(Long id);


    /**
     * 导入人工数据数据
     *
     * @param cbAList 人工数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importCbArtificial(List<CbArtificial> cbAList, Boolean isUpdateSupport, String operName);
}
