package com.zero.system.service.impl;

import java.util.List;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.mapper.SysSpecialConfigMapper;
import com.zero.system.domain.SysSpecialConfig;
import com.zero.system.service.ISysSpecialConfigService;

/**
 * 专项参数配置Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-04-13
 */
@Service
public class SysSpecialConfigServiceImpl implements ISysSpecialConfigService 
{
    @Autowired
    private SysSpecialConfigMapper sysSpecialConfigMapper;

    /**
     * 查询专项参数配置
     * 
     * @param configId 专项参数配置主键
     * @return 专项参数配置
     */
    @Override
    public SysSpecialConfig selectSysSpecialConfigByConfigId(Long configId)
    {
        return sysSpecialConfigMapper.selectSysSpecialConfigByConfigId(configId);
    }

    /**
     * 查询专项参数配置列表
     * 
     * @param sysSpecialConfig 专项参数配置
     * @return 专项参数配置
     */
    @Override
    public List<SysSpecialConfig> selectSysSpecialConfigList(SysSpecialConfig sysSpecialConfig)
    {
        return sysSpecialConfigMapper.selectSysSpecialConfigList(sysSpecialConfig);
    }

    /**
     * 新增专项参数配置
     * 
     * @param sysSpecialConfig 专项参数配置
     * @return 结果
     */
    @Override
    public int insertSysSpecialConfig(SysSpecialConfig sysSpecialConfig)
    {
        sysSpecialConfig.setCreateBy(SecurityUtils.getUsername());
        sysSpecialConfig.setCreateTime(DateUtils.getNowDate());
        return sysSpecialConfigMapper.insertSysSpecialConfig(sysSpecialConfig);
    }

    /**
     * 修改专项参数配置
     * 
     * @param sysSpecialConfig 专项参数配置
     * @return 结果
     */
    @Override
    public int updateSysSpecialConfig(SysSpecialConfig sysSpecialConfig)
    {
        sysSpecialConfig.setUpdateTime(DateUtils.getNowDate());
        return sysSpecialConfigMapper.updateSysSpecialConfig(sysSpecialConfig);
    }

    /**
     * 批量删除专项参数配置
     * 
     * @param configIds 需要删除的专项参数配置主键
     * @return 结果
     */
    @Override
    public int deleteSysSpecialConfigByConfigIds(Long[] configIds)
    {
        return sysSpecialConfigMapper.deleteSysSpecialConfigByConfigIds(configIds);
    }

    /**
     * 删除专项参数配置信息
     * 
     * @param configId 专项参数配置主键
     * @return 结果
     */
    @Override
    public int deleteSysSpecialConfigByConfigId(Long configId)
    {
        return sysSpecialConfigMapper.deleteSysSpecialConfigByConfigId(configId);
    }
}
