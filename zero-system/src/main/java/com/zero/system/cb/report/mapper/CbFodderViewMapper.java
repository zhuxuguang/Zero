package com.zero.system.cb.report.mapper;

import java.util.List;
import com.zero.system.cb.report.domain.CbFodderView;

/**
 * 饲料详情报表Mapper接口
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
public interface CbFodderViewMapper 
{
    /**
     * 查询饲料详情报表
     * 
     * @param type 饲料详情报表主键
     * @return 饲料详情报表
     */
    public CbFodderView selectCbFodderViewByType(String type);

    /**
     * 查询饲料详情报表列表
     * 
     * @param cbFodderView 饲料详情报表
     * @return 饲料详情报表集合
     */
    public List<CbFodderView> selectCbFodderViewList(CbFodderView cbFodderView);

    /**
     * 新增饲料详情报表
     * 
     * @param cbFodderView 饲料详情报表
     * @return 结果
     */
    public int insertCbFodderView(CbFodderView cbFodderView);

    /**
     * 修改饲料详情报表
     * 
     * @param cbFodderView 饲料详情报表
     * @return 结果
     */
    public int updateCbFodderView(CbFodderView cbFodderView);

    /**
     * 删除饲料详情报表
     * 
     * @param type 饲料详情报表主键
     * @return 结果
     */
    public int deleteCbFodderViewByType(String type);

    /**
     * 批量删除饲料详情报表
     * 
     * @param types 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCbFodderViewByTypes(String[] types);
}
