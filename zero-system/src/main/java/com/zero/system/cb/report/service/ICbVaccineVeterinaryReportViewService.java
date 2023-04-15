package com.zero.system.cb.report.service;

import java.util.List;
import com.zero.system.cb.report.domain.CbVaccineVeterinaryReportView;

/**
 * 疫苗-兽药报表视图Service接口
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
public interface ICbVaccineVeterinaryReportViewService 
{
    /**
     * 查询疫苗-兽药报表视图
     * 
     * @param type 疫苗-兽药报表视图主键
     * @return 疫苗-兽药报表视图
     */
    public CbVaccineVeterinaryReportView selectCbVaccineVeterinaryReportViewByType(String type);

    /**
     * 查询疫苗-兽药报表视图列表
     * 
     * @param cbVaccineVeterinaryReportView 疫苗-兽药报表视图
     * @return 疫苗-兽药报表视图集合
     */
    public List<CbVaccineVeterinaryReportView> selectCbVaccineVeterinaryReportViewList(CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView);

    /**
     * 新增疫苗-兽药报表视图
     * 
     * @param cbVaccineVeterinaryReportView 疫苗-兽药报表视图
     * @return 结果
     */
    public int insertCbVaccineVeterinaryReportView(CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView);

    /**
     * 修改疫苗-兽药报表视图
     * 
     * @param cbVaccineVeterinaryReportView 疫苗-兽药报表视图
     * @return 结果
     */
    public int updateCbVaccineVeterinaryReportView(CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView);

    /**
     * 批量删除疫苗-兽药报表视图
     * 
     * @param types 需要删除的疫苗-兽药报表视图主键集合
     * @return 结果
     */
    public int deleteCbVaccineVeterinaryReportViewByTypes(String[] types);

    /**
     * 删除疫苗-兽药报表视图信息
     * 
     * @param type 疫苗-兽药报表视图主键
     * @return 结果
     */
    public int deleteCbVaccineVeterinaryReportViewByType(String type);
}
