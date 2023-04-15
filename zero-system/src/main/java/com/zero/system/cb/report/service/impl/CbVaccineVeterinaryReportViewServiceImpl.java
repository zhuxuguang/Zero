package com.zero.system.cb.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.report.mapper.CbVaccineVeterinaryReportViewMapper;
import com.zero.system.cb.report.domain.CbVaccineVeterinaryReportView;
import com.zero.system.cb.report.service.ICbVaccineVeterinaryReportViewService;

/**
 * 疫苗-兽药报表视图Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-24
 */
@Service
public class CbVaccineVeterinaryReportViewServiceImpl implements ICbVaccineVeterinaryReportViewService 
{
    @Autowired
    private CbVaccineVeterinaryReportViewMapper cbVaccineVeterinaryReportViewMapper;

    /**
     * 查询疫苗-兽药报表视图
     * 
     * @param type 疫苗-兽药报表视图主键
     * @return 疫苗-兽药报表视图
     */
    @Override
    public CbVaccineVeterinaryReportView selectCbVaccineVeterinaryReportViewByType(String type)
    {
        return cbVaccineVeterinaryReportViewMapper.selectCbVaccineVeterinaryReportViewByType(type);
    }

    /**
     * 查询疫苗-兽药报表视图列表
     * 
     * @param cbVaccineVeterinaryReportView 疫苗-兽药报表视图
     * @return 疫苗-兽药报表视图
     */
    @Override
    public List<CbVaccineVeterinaryReportView> selectCbVaccineVeterinaryReportViewList(CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView)
    {
        return cbVaccineVeterinaryReportViewMapper.selectCbVaccineVeterinaryReportViewList(cbVaccineVeterinaryReportView);
    }

    /**
     * 新增疫苗-兽药报表视图
     * 
     * @param cbVaccineVeterinaryReportView 疫苗-兽药报表视图
     * @return 结果
     */
    @Override
    public int insertCbVaccineVeterinaryReportView(CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView)
    {
        return cbVaccineVeterinaryReportViewMapper.insertCbVaccineVeterinaryReportView(cbVaccineVeterinaryReportView);
    }

    /**
     * 修改疫苗-兽药报表视图
     * 
     * @param cbVaccineVeterinaryReportView 疫苗-兽药报表视图
     * @return 结果
     */
    @Override
    public int updateCbVaccineVeterinaryReportView(CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView)
    {
        return cbVaccineVeterinaryReportViewMapper.updateCbVaccineVeterinaryReportView(cbVaccineVeterinaryReportView);
    }

    /**
     * 批量删除疫苗-兽药报表视图
     * 
     * @param types 需要删除的疫苗-兽药报表视图主键
     * @return 结果
     */
    @Override
    public int deleteCbVaccineVeterinaryReportViewByTypes(String[] types)
    {
        return cbVaccineVeterinaryReportViewMapper.deleteCbVaccineVeterinaryReportViewByTypes(types);
    }

    /**
     * 删除疫苗-兽药报表视图信息
     * 
     * @param type 疫苗-兽药报表视图主键
     * @return 结果
     */
    @Override
    public int deleteCbVaccineVeterinaryReportViewByType(String type)
    {
        return cbVaccineVeterinaryReportViewMapper.deleteCbVaccineVeterinaryReportViewByType(type);
    }
}
