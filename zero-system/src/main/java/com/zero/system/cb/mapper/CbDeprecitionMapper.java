package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbDeprecition;

/**
 * 折旧Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
public interface CbDeprecitionMapper 
{
    /**
     * 查询折旧
     * 
     * @param id 折旧主键
     * @return 折旧
     */
    public CbDeprecition selectCbDeprecitionById(Long id);

    /**
     * 查询折旧列表
     * 
     * @param cbDeprecition 折旧
     * @return 折旧集合
     */
    public List<CbDeprecition> selectCbDeprecitionList(CbDeprecition cbDeprecition);

    /**
     * 新增折旧
     * 
     * @param cbDeprecition 折旧
     * @return 结果
     */
    public int insertCbDeprecition(CbDeprecition cbDeprecition);

    /**
     * 修改折旧
     * 
     * @param cbDeprecition 折旧
     * @return 结果
     */
    public int updateCbDeprecition(CbDeprecition cbDeprecition);

    /**
     * 删除折旧
     * 
     * @param id 折旧主键
     * @return 结果
     */
    public int deleteCbDeprecitionById(Long id);

    /**
     * 批量删除折旧
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbDeprecitionByIds(Long[] ids);
}
