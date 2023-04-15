package com.zero.system.service;

import java.util.List;
import com.zero.system.domain.SysSpecialConfig;

/**
 * 专项参数配置Service接口
 * 
 * @author zhuxuguang
 * @date 2023-04-13
 */
public interface ISysSpecialConfigService 
{
    /**
     * 查询专项参数配置
     * 
     * @param configId 专项参数配置主键
     * @return 专项参数配置
     */
    public SysSpecialConfig selectSysSpecialConfigByConfigId(Long configId);

    /**
     * 查询专项参数配置列表
     * 
     * @param sysSpecialConfig 专项参数配置
     * @return 专项参数配置集合
     */
    public List<SysSpecialConfig> selectSysSpecialConfigList(SysSpecialConfig sysSpecialConfig);

    /**
     * 新增专项参数配置
     * 
     * @param sysSpecialConfig 专项参数配置
     * @return 结果
     */
    public int insertSysSpecialConfig(SysSpecialConfig sysSpecialConfig);

    /**
     * 修改专项参数配置
     * 
     * @param sysSpecialConfig 专项参数配置
     * @return 结果
     */
    public int updateSysSpecialConfig(SysSpecialConfig sysSpecialConfig);

    /**
     * 批量删除专项参数配置
     * 
     * @param configIds 需要删除的专项参数配置主键集合
     * @return 结果
     */
    public int deleteSysSpecialConfigByConfigIds(Long[] configIds);

    /**
     * 删除专项参数配置信息
     * 
     * @param configId 专项参数配置主键
     * @return 结果
     */
    public int deleteSysSpecialConfigByConfigId(Long configId);
}
