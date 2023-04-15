package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbArtificial;

/**
 * 人工Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-02-06
 */
public interface CbArtificialMapper 
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
     * 删除人工
     * 
     * @param id 人工主键
     * @return 结果
     */
    public int deleteCbArtificialById(Long id);

    /**
     * 批量删除人工
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbArtificialByIds(Long[] ids);
}
