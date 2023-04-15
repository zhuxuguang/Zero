package com.zero.system.cb.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.report.mapper.CbFodderViewMapper;
import com.zero.system.cb.report.domain.CbFodderView;
import com.zero.system.cb.report.service.ICbFodderViewService;

/**
 * 饲料详情报表Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@Service
public class CbFodderViewServiceImpl implements ICbFodderViewService 
{
    @Autowired
    private CbFodderViewMapper cbFodderViewMapper;

    /**
     * 查询饲料详情报表
     * 
     * @param type 饲料详情报表主键
     * @return 饲料详情报表
     */
    @Override
    public CbFodderView selectCbFodderViewByType(String type)
    {
        return cbFodderViewMapper.selectCbFodderViewByType(type);
    }

    /**
     * 查询饲料详情报表列表
     * 
     * @param cbFodderView 饲料详情报表
     * @return 饲料详情报表
     */
    @Override
    public List<CbFodderView> selectCbFodderViewList(CbFodderView cbFodderView)
    {
        return cbFodderViewMapper.selectCbFodderViewList(cbFodderView);
    }

    /**
     * 新增饲料详情报表
     * 
     * @param cbFodderView 饲料详情报表
     * @return 结果
     */
    @Override
    public int insertCbFodderView(CbFodderView cbFodderView)
    {
        return cbFodderViewMapper.insertCbFodderView(cbFodderView);
    }

    /**
     * 修改饲料详情报表
     * 
     * @param cbFodderView 饲料详情报表
     * @return 结果
     */
    @Override
    public int updateCbFodderView(CbFodderView cbFodderView)
    {
        return cbFodderViewMapper.updateCbFodderView(cbFodderView);
    }

    /**
     * 批量删除饲料详情报表
     * 
     * @param types 需要删除的饲料详情报表主键
     * @return 结果
     */
    @Override
    public int deleteCbFodderViewByTypes(String[] types)
    {
        return cbFodderViewMapper.deleteCbFodderViewByTypes(types);
    }

    /**
     * 删除饲料详情报表信息
     * 
     * @param type 饲料详情报表主键
     * @return 结果
     */
    @Override
    public int deleteCbFodderViewByType(String type)
    {
        return cbFodderViewMapper.deleteCbFodderViewByType(type);
    }
}
