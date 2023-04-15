package com.zero.system.cb.service;

import java.util.List;

import com.zero.system.cb.domain.CbProductionTarget;
import com.zero.system.cb.domain.CbSynthetical;

/**
 * 其他数据Service接口
 * 
 * @author zhuxuguang
 * @date 2023-02-21
 */
public interface ICbSyntheticalService 
{
    /**
     * 查询其他数据
     * 
     * @param id 其他数据主键
     * @return 其他数据
     */
    public CbSynthetical selectCbSyntheticalById(Long id);

    /**
     * 查询其他数据列表
     * 
     * @param cbSynthetical 其他数据
     * @return 其他数据集合
     */
    public List<CbSynthetical> selectCbSyntheticalList(CbSynthetical cbSynthetical);

    /**
     * 新增其他数据
     * 
     * @param cbSynthetical 其他数据
     * @return 结果
     */
    public int insertCbSynthetical(CbSynthetical cbSynthetical);

    /**
     * 修改其他数据
     * 
     * @param cbSynthetical 其他数据
     * @return 结果
     */
    public int updateCbSynthetical(CbSynthetical cbSynthetical);

    /**
     * 批量删除其他数据
     * 
     * @param ids 需要删除的其他数据主键集合
     * @return 结果
     */
    public int deleteCbSyntheticalByIds(Long[] ids);

    /**
     * 删除其他数据信息
     * 
     * @param id 其他数据主键
     * @return 结果
     */
    public int deleteCbSyntheticalById(Long id);

    /**
     * 导入其他数据
     *
     * @param cbSList 其他数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importCbSyntheticalTarget(List<CbSynthetical> cbSList, Boolean isUpdateSupport, String operName);
}
