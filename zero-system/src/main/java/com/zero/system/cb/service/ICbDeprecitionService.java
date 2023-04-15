package com.zero.system.cb.service;

import java.util.List;
import com.zero.system.cb.domain.CbDeprecition;
import com.zero.system.cb.domain.CbProductionTarget;

/**
 * 折旧Service接口
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
public interface ICbDeprecitionService 
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
     * 批量删除折旧
     * 
     * @param ids 需要删除的折旧主键集合
     * @return 结果
     */
    public int deleteCbDeprecitionByIds(Long[] ids);

    /**
     * 删除折旧信息
     * 
     * @param id 折旧主键
     * @return 结果
     */
    public int deleteCbDeprecitionById(Long id);



    /**
     * 导入折旧数据
     *
     * @param cbDtList 折旧数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importCbDeprecition(List<CbDeprecition> cbDtList, Boolean isUpdateSupport, String operName);
}
