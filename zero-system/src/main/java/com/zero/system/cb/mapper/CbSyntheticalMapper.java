package com.zero.system.cb.mapper;

import java.util.List;
import com.zero.system.cb.domain.CbSynthetical;

/**
 * 其他数据Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-02-21
 */
public interface CbSyntheticalMapper 
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
     * 删除其他数据
     * 
     * @param id 其他数据主键
     * @return 结果
     */
    public int deleteCbSyntheticalById(Long id);

    /**
     * 批量删除其他数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbSyntheticalByIds(Long[] ids);
}
