package com.zero.quartz.task;

import com.zero.common.core.domain.entity.SysDept;
import com.zero.system.cb.domain.CbCostAnalysisReport;
import com.zero.system.cb.domain.CbProductionParametersView;
import com.zero.system.cb.report.domain.*;
import com.zero.system.cb.report.service.*;
import com.zero.system.cb.service.ICbCostAnalysisReportService;
import com.zero.system.cb.service.ICbProductionParametersViewService;
import com.zero.system.service.ISysDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @Author: ZhuXuGuang
 * @Description: 成本分析数据存储
 * @Date: create in 2023/2/20 20:25
 */
@Component("cbAnalyseStoreTask")
@Slf4j
public class CbAnalyseStoreTask {

    @Autowired
    private ICbCostAnalysisReportService cbCostAnalysisReportService;

    //生产参数
    @Autowired
    private ICbProductionParametersViewService cbProductionParametersViewService;

    //固定成本
    @Autowired
    private ICbFixedCostReportViewService cbFixedCostReportViewService;

    //饲料汇总视图
    @Autowired
    private ICbFodderViewService cbFodderViewService;

    //饲料计算视图 头均日采食量和成本
    @Autowired
    private ICbAvgAdfiCostViewService cbAvgAdfiCostViewService;

    //兽药疫苗视图
    @Autowired
    private ICbVaccineVeterinaryReportViewService cbVaccineVeterinaryReportViewService;

    //人工成本报表视图
    @Autowired
    private ICbArtificialCostReportViewService cbArtificialCostReportViewService;

    //物资领用报表视图
    @Autowired
    private ICbReceiptGoodsReportViewService cbReceiptGoodsReportViewService;

    //制造费用报表视图
    @Autowired
    private ICbFabricateReportViewService cbFabricateReportViewService;

    //母猪存栏月平均成本(元/头)
    @Autowired
    private ICbSowBankMonthAvgCostReportViewService cbSowBankMonthAvgCostReportViewService;

    //头均断奶成本计算
    @Autowired
    private ICbHeadAverageWeaningCostReportViewService cbHeadAverageWeaningCostReportViewService;

    @Autowired
    private ISysDeptService deptService;

    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public void insertCbAnalyseStoreTask(){

        log.info("@@开始自动存储计算后的数据......");

        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();

        //生产参数视图
        CbProductionParametersView cbProductionParametersView = new CbProductionParametersView();
        //查询生产参数视图，进行生产参数存储
        List<CbProductionParametersView> listCPPV = cbProductionParametersViewService.selectCbProductionParametersViewList(cbProductionParametersView);
        try {
            //手动获取前需要先清空数据
            cbCostAnalysisReportService.deleteAllCostAnalysisReport();
            //生产视图插入
            for (int i = 0; i < listCPPV.size(); i++){
                CbProductionParametersView cbPPV = listCPPV.get(i);
                insertCbProductionParametersViewVoid(cbPPV);
            }
            //固定成本
            CbFixedCostReportView cbFixedCostReportView = new CbFixedCostReportView();
            List<CbFixedCostReportView> listCbFCRV = cbFixedCostReportViewService.selectCbFixedCostReportViewList(cbFixedCostReportView);
            for (int i = 0; i < listCbFCRV.size(); i++){
                CbFixedCostReportView cbFCRV = listCbFCRV.get(i);
                insertCbFixedCostReportViewVoid(cbFCRV);
            }
            //饲料明细成本
            CbFodderView cbFodderView = new CbFodderView();
            List<CbFodderView> listCbFV = cbFodderViewService.selectCbFodderViewList(cbFodderView);
            for (int i = 0; i < listCbFV.size(); i++){
                CbFodderView cbFv = listCbFV.get(i);
                insertCbFodderViewVoid(cbFv);
            }
            //饲料计算视图 头均日采食量和成本
            CbAvgAdfiCostView cbAvgAdfiCostView = new CbAvgAdfiCostView();
            List<CbAvgAdfiCostView> listCbAACV = cbAvgAdfiCostViewService.selectCbAvgAdfiCostViewList(cbAvgAdfiCostView);
            for (int i = 0; i < listCbAACV.size(); i++){
                CbAvgAdfiCostView cbAaCV = listCbAACV.get(i);
                insertCbAvgAdfiCostViewVoid(cbAaCV);
            }
            //执行兽药疫苗视图 头均日采食量和成本视图从报表数据插入、传入视图集合
            CbVaccineVeterinaryReportView cbVaccineVeterinaryReportView = new CbVaccineVeterinaryReportView();
            List<CbVaccineVeterinaryReportView> listCbVVR = cbVaccineVeterinaryReportViewService.selectCbVaccineVeterinaryReportViewList(cbVaccineVeterinaryReportView);
            for (int i = 0; i < listCbVVR.size(); i++){
                CbVaccineVeterinaryReportView cbVVR = listCbVVR.get(i);
                insertCbVaccineVeterinaryReportViewVoid(cbVVR);
            }
            //执行人工成本报表视图集合
            CbArtificialCostReportView cbArtificialCostReportView = new CbArtificialCostReportView();
            List<CbArtificialCostReportView> listCbACRV = cbArtificialCostReportViewService.selectCbArtificialCostReportViewList(cbArtificialCostReportView);
            for (int i = 0; i < listCbACRV.size(); i++){
                CbArtificialCostReportView cbAcRV= listCbACRV.get(i);
                insertCbArtificialCostReportViewVoid(cbAcRV);
            }
            //执行物资领用报表视图集合
            CbReceiptGoodsReportView cbReceiptGoodsReportView = new CbReceiptGoodsReportView();
            List<CbReceiptGoodsReportView> listCbRGRV = cbReceiptGoodsReportViewService.selectCbReceiptGoodsReportViewList(cbReceiptGoodsReportView);
            for (int i = 0; i < listCbRGRV.size(); i++){
                CbReceiptGoodsReportView cbRgRv= listCbRGRV.get(i);
                insertCbReceiptGoodsReportViewVoid(cbRgRv);
            }
            //执行制造费用报表视图集合
            CbFabricateReportView cbFabricateReportView = new CbFabricateReportView();
            List<CbFabricateReportView> listCbFRV = cbFabricateReportViewService.selectCbFabricateReportViewList(cbFabricateReportView);
            for (int i = 0; i < listCbFRV.size(); i++){
                CbFabricateReportView cbFRV = listCbFRV.get(i);
                insertCbFabricateReportViewVoid(cbFRV);
            }
            //执行母猪存栏月平均成本(元/头)
            CbSowBankMonthAvgCostReportView cbSowBankMonthAvgCostReportView = new CbSowBankMonthAvgCostReportView();
            List<CbSowBankMonthAvgCostReportView> listCbSbMAcRv = cbSowBankMonthAvgCostReportViewService.selectCbSowBankMonthAvgCostReportViewList(cbSowBankMonthAvgCostReportView);
            for (int i = 0; i < listCbSbMAcRv.size(); i++){
                CbSowBankMonthAvgCostReportView cbSbMAcRv = listCbSbMAcRv.get(i);
                insertCbSowBankMonthAvgCostReportViewVoid(cbSbMAcRv);
            }
            //头均断奶成本计算
            CbHeadAverageWeaningCostReportView cbHeadAverageWeaningCostReportView = new CbHeadAverageWeaningCostReportView();
            List<CbHeadAverageWeaningCostReportView> listCbHaWcRV = cbHeadAverageWeaningCostReportViewService.selectCbHeadAverageWeaningCostReportViewList(cbHeadAverageWeaningCostReportView);
            for (int i = 0; i < listCbHaWcRV.size(); i++){
                CbHeadAverageWeaningCostReportView cbCbHaWcRV = listCbHaWcRV.get(i);
                insertCbHeadAverageWeaningCostReportViewVoid(cbCbHaWcRV);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    /**
     * 执行生产参数视图从报表数据插入、传入视图集合
     * @param cbCc
     */
    void insertCbProductionParametersViewVoid(CbProductionParametersView cbCc){
        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();
        //类型
        cbCostAnalysisReport.setCbType(cbCc.getType());
        //项目
        cbCostAnalysisReport.setProject(cbCc.getProject());
        //种类
        cbCostAnalysisReport.setVariety(cbCc.getVariety());
        //年份
        cbCostAnalysisReport.setCbYear(cbCc.getCbYear());
        //组织ID
        cbCostAnalysisReport.setHoggeryId(cbCc.getHoggeryId());
        //组织名称
        SysDept dept = deptService.selectDeptById(cbCc.getHoggeryId());
        cbCostAnalysisReport.setHoggeryName(dept.getDeptName());
        //平均/合计
        cbCostAnalysisReport.setAvgOrTotal(cbCc.getAvgOrTotal());
        //一月
        cbCostAnalysisReport.setJan(cbCc.getJan());
        //二月
        cbCostAnalysisReport.setFebruary(cbCc.getFebruary());
        //三月
        cbCostAnalysisReport.setMarch(cbCc.getMarch());
        //四月
        cbCostAnalysisReport.setApril(cbCc.getApril());
        //五月
        cbCostAnalysisReport.setMay(cbCc.getMay());
        //六月
        cbCostAnalysisReport.setJune(cbCc.getJune());
        //七月
        cbCostAnalysisReport.setJuly(cbCc.getJuly());
        //八月
        cbCostAnalysisReport.setAugust(cbCc.getAugust());
        //九月
        cbCostAnalysisReport.setSeptember(cbCc.getSeptember());
        //十月
        cbCostAnalysisReport.setOctober(cbCc.getOctober());
        //十一月
        cbCostAnalysisReport.setNovember(cbCc.getNovember());
        //十二月
        cbCostAnalysisReport.setDecember(cbCc.getDecember());
        cbCostAnalysisReportService.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }

    /**
     * 执行固定成本视图从报表数据插入、传入视图集合
     * @param cbCc
     */
    void insertCbFixedCostReportViewVoid(CbFixedCostReportView cbCc){
        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();
        //类型
        cbCostAnalysisReport.setCbType(cbCc.getType());
        //项目
        cbCostAnalysisReport.setProject(cbCc.getProject());
        //种类
        cbCostAnalysisReport.setVariety(cbCc.getVariety());
        //年份
        cbCostAnalysisReport.setCbYear(cbCc.getCbYear());
        //组织ID
        cbCostAnalysisReport.setHoggeryId(cbCc.getHoggeryId());
        //组织名称
        SysDept dept = deptService.selectDeptById(cbCc.getHoggeryId());
        cbCostAnalysisReport.setHoggeryName(dept.getDeptName());
        //平均/合计
        cbCostAnalysisReport.setAvgOrTotal(cbCc.getAvgOrTotal());
        //一月
        cbCostAnalysisReport.setJan(cbCc.getJan());
        //二月
        cbCostAnalysisReport.setFebruary(cbCc.getFebruary());
        //三月
        cbCostAnalysisReport.setMarch(cbCc.getMarch());
        //四月
        cbCostAnalysisReport.setApril(cbCc.getApril());
        //五月
        cbCostAnalysisReport.setMay(cbCc.getMay());
        //六月
        cbCostAnalysisReport.setJune(cbCc.getJune());
        //七月
        cbCostAnalysisReport.setJuly(cbCc.getJuly());
        //八月
        cbCostAnalysisReport.setAugust(cbCc.getAugust());
        //九月
        cbCostAnalysisReport.setSeptember(cbCc.getSeptember());
        //十月
        cbCostAnalysisReport.setOctober(cbCc.getOctober());
        //十一月
        cbCostAnalysisReport.setNovember(cbCc.getNovember());
        //十二月
        cbCostAnalysisReport.setDecember(cbCc.getDecember());
        cbCostAnalysisReportService.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }


    /**
     * 执行饲料明细视图从报表数据插入、传入视图集合
     * @param cbCc
     */
    void insertCbFodderViewVoid(CbFodderView cbCc){
        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();
        //类型
        cbCostAnalysisReport.setCbType(cbCc.getType());
        //项目
        cbCostAnalysisReport.setProject(cbCc.getProject());
        //种类
        cbCostAnalysisReport.setVariety(cbCc.getVariety());
        //年份
        cbCostAnalysisReport.setCbYear(cbCc.getCbYear());
        //组织ID
        cbCostAnalysisReport.setHoggeryId(cbCc.getHoggeryId());
        //组织名称
        SysDept dept = deptService.selectDeptById(cbCc.getHoggeryId());
        cbCostAnalysisReport.setHoggeryName(dept.getDeptName());
        //平均/合计
        cbCostAnalysisReport.setAvgOrTotal(cbCc.getAvgOrTotal());
        //一月
        cbCostAnalysisReport.setJan(cbCc.getJan());
        //二月
        cbCostAnalysisReport.setFebruary(cbCc.getFebruary());
        //三月
        cbCostAnalysisReport.setMarch(cbCc.getMarch());
        //四月
        cbCostAnalysisReport.setApril(cbCc.getApril());
        //五月
        cbCostAnalysisReport.setMay(cbCc.getMay());
        //六月
        cbCostAnalysisReport.setJune(cbCc.getJune());
        //七月
        cbCostAnalysisReport.setJuly(cbCc.getJuly());
        //八月
        cbCostAnalysisReport.setAugust(cbCc.getAugust());
        //九月
        cbCostAnalysisReport.setSeptember(cbCc.getSeptember());
        //十月
        cbCostAnalysisReport.setOctober(cbCc.getOctober());
        //十一月
        cbCostAnalysisReport.setNovember(cbCc.getNovember());
        //十二月
        cbCostAnalysisReport.setDecember(cbCc.getDecember());
        cbCostAnalysisReportService.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }

    /**
     * 执行饲料计算视图 头均日采食量和成本视图从报表数据插入、传入视图集合
     * @param cbCc
     */
    void insertCbAvgAdfiCostViewVoid(CbAvgAdfiCostView cbCc){
        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();
        //类型
        cbCostAnalysisReport.setCbType(cbCc.getType());
        //项目
        cbCostAnalysisReport.setProject(cbCc.getProject());
        //种类
        cbCostAnalysisReport.setVariety(cbCc.getVariety());
        //年份
        cbCostAnalysisReport.setCbYear(cbCc.getCbYear());
        //组织ID
        cbCostAnalysisReport.setHoggeryId(cbCc.getHoggeryId());
        //组织名称
        SysDept dept = deptService.selectDeptById(cbCc.getHoggeryId());
        cbCostAnalysisReport.setHoggeryName(dept.getDeptName());
        //平均/合计
        cbCostAnalysisReport.setAvgOrTotal(cbCc.getAvgOrTotal());
        //一月
        cbCostAnalysisReport.setJan(cbCc.getJan());
        //二月
        cbCostAnalysisReport.setFebruary(cbCc.getFebruary());
        //三月
        cbCostAnalysisReport.setMarch(cbCc.getMarch());
        //四月
        cbCostAnalysisReport.setApril(cbCc.getApril());
        //五月
        cbCostAnalysisReport.setMay(cbCc.getMay());
        //六月
        cbCostAnalysisReport.setJune(cbCc.getJune());
        //七月
        cbCostAnalysisReport.setJuly(cbCc.getJuly());
        //八月
        cbCostAnalysisReport.setAugust(cbCc.getAugust());
        //九月
        cbCostAnalysisReport.setSeptember(cbCc.getSeptember());
        //十月
        cbCostAnalysisReport.setOctober(cbCc.getOctober());
        //十一月
        cbCostAnalysisReport.setNovember(cbCc.getNovember());
        //十二月
        cbCostAnalysisReport.setDecember(cbCc.getDecember());
        cbCostAnalysisReportService.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }


    /**
     * 执行兽药疫苗视图 头均日采食量和成本视图从报表数据插入、传入视图集合
     * @param cbCc
     */
    void insertCbVaccineVeterinaryReportViewVoid(CbVaccineVeterinaryReportView cbCc){
        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();
        //类型
        cbCostAnalysisReport.setCbType(cbCc.getType());
        //项目
        cbCostAnalysisReport.setProject(cbCc.getProject());
        //种类
        cbCostAnalysisReport.setVariety(cbCc.getVariety());
        //年份
        cbCostAnalysisReport.setCbYear(cbCc.getCbYear());
        //组织ID
        cbCostAnalysisReport.setHoggeryId(cbCc.getHoggeryId());
        //组织名称
        SysDept dept = deptService.selectDeptById(cbCc.getHoggeryId());
        cbCostAnalysisReport.setHoggeryName(dept.getDeptName());
        //平均/合计
        cbCostAnalysisReport.setAvgOrTotal(cbCc.getAvgOrTotal());
        //一月
        cbCostAnalysisReport.setJan(cbCc.getJan());
        //二月
        cbCostAnalysisReport.setFebruary(cbCc.getFebruary());
        //三月
        cbCostAnalysisReport.setMarch(cbCc.getMarch());
        //四月
        cbCostAnalysisReport.setApril(cbCc.getApril());
        //五月
        cbCostAnalysisReport.setMay(cbCc.getMay());
        //六月
        cbCostAnalysisReport.setJune(cbCc.getJune());
        //七月
        cbCostAnalysisReport.setJuly(cbCc.getJuly());
        //八月
        cbCostAnalysisReport.setAugust(cbCc.getAugust());
        //九月
        cbCostAnalysisReport.setSeptember(cbCc.getSeptember());
        //十月
        cbCostAnalysisReport.setOctober(cbCc.getOctober());
        //十一月
        cbCostAnalysisReport.setNovember(cbCc.getNovember());
        //十二月
        cbCostAnalysisReport.setDecember(cbCc.getDecember());
        cbCostAnalysisReportService.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }

    /**
     * 执行人工成本报表视图集合
     * @param cbCc
     */
    void insertCbArtificialCostReportViewVoid(CbArtificialCostReportView cbCc){
        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();
        //类型
        cbCostAnalysisReport.setCbType(cbCc.getType());
        //项目
        cbCostAnalysisReport.setProject(cbCc.getProject());
        //种类
        cbCostAnalysisReport.setVariety(cbCc.getVariety());
        //年份
        cbCostAnalysisReport.setCbYear(cbCc.getCbYear());
        //组织ID
        cbCostAnalysisReport.setHoggeryId(cbCc.getHoggeryId());
        //组织名称
        SysDept dept = deptService.selectDeptById(cbCc.getHoggeryId());
        cbCostAnalysisReport.setHoggeryName(dept.getDeptName());
        //平均/合计
        cbCostAnalysisReport.setAvgOrTotal(cbCc.getAvgOrTotal());
        //一月
        cbCostAnalysisReport.setJan(cbCc.getJan());
        //二月
        cbCostAnalysisReport.setFebruary(cbCc.getFebruary());
        //三月
        cbCostAnalysisReport.setMarch(cbCc.getMarch());
        //四月
        cbCostAnalysisReport.setApril(cbCc.getApril());
        //五月
        cbCostAnalysisReport.setMay(cbCc.getMay());
        //六月
        cbCostAnalysisReport.setJune(cbCc.getJune());
        //七月
        cbCostAnalysisReport.setJuly(cbCc.getJuly());
        //八月
        cbCostAnalysisReport.setAugust(cbCc.getAugust());
        //九月
        cbCostAnalysisReport.setSeptember(cbCc.getSeptember());
        //十月
        cbCostAnalysisReport.setOctober(cbCc.getOctober());
        //十一月
        cbCostAnalysisReport.setNovember(cbCc.getNovember());
        //十二月
        cbCostAnalysisReport.setDecember(cbCc.getDecember());
        cbCostAnalysisReportService.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }


    /**
     * 执行物资领用报表视图集合
     * @param cbCc
     */
    void insertCbReceiptGoodsReportViewVoid(CbReceiptGoodsReportView cbCc){
        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();
        //类型
        cbCostAnalysisReport.setCbType(cbCc.getType());
        //项目
        cbCostAnalysisReport.setProject(cbCc.getProject());
        //种类
        cbCostAnalysisReport.setVariety(cbCc.getVariety());
        //年份
        cbCostAnalysisReport.setCbYear(cbCc.getCbYear());
        //组织ID
        cbCostAnalysisReport.setHoggeryId(cbCc.getHoggeryId());
        //组织名称
        SysDept dept = deptService.selectDeptById(cbCc.getHoggeryId());
        cbCostAnalysisReport.setHoggeryName(dept.getDeptName());
        //平均/合计
        cbCostAnalysisReport.setAvgOrTotal(cbCc.getAvgOrTotal());
        //一月
        cbCostAnalysisReport.setJan(cbCc.getJan());
        //二月
        cbCostAnalysisReport.setFebruary(cbCc.getFebruary());
        //三月
        cbCostAnalysisReport.setMarch(cbCc.getMarch());
        //四月
        cbCostAnalysisReport.setApril(cbCc.getApril());
        //五月
        cbCostAnalysisReport.setMay(cbCc.getMay());
        //六月
        cbCostAnalysisReport.setJune(cbCc.getJune());
        //七月
        cbCostAnalysisReport.setJuly(cbCc.getJuly());
        //八月
        cbCostAnalysisReport.setAugust(cbCc.getAugust());
        //九月
        cbCostAnalysisReport.setSeptember(cbCc.getSeptember());
        //十月
        cbCostAnalysisReport.setOctober(cbCc.getOctober());
        //十一月
        cbCostAnalysisReport.setNovember(cbCc.getNovember());
        //十二月
        cbCostAnalysisReport.setDecember(cbCc.getDecember());
        cbCostAnalysisReportService.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }


    /**
     * 执行制造费用报表视图集合
     * @param cbCc
     */
    void insertCbFabricateReportViewVoid(CbFabricateReportView cbCc){
        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();
        //类型
        cbCostAnalysisReport.setCbType(cbCc.getType());
        //项目
        cbCostAnalysisReport.setProject(cbCc.getProject());
        //种类
        cbCostAnalysisReport.setVariety(cbCc.getVariety());
        //年份
        cbCostAnalysisReport.setCbYear(cbCc.getCbYear());
        //组织ID
        cbCostAnalysisReport.setHoggeryId(cbCc.getHoggeryId());
        //组织名称
        SysDept dept = deptService.selectDeptById(cbCc.getHoggeryId());
        cbCostAnalysisReport.setHoggeryName(dept.getDeptName());
        //平均/合计
        cbCostAnalysisReport.setAvgOrTotal(cbCc.getAvgOrTotal());
        //一月
        cbCostAnalysisReport.setJan(cbCc.getJan());
        //二月
        cbCostAnalysisReport.setFebruary(cbCc.getFebruary());
        //三月
        cbCostAnalysisReport.setMarch(cbCc.getMarch());
        //四月
        cbCostAnalysisReport.setApril(cbCc.getApril());
        //五月
        cbCostAnalysisReport.setMay(cbCc.getMay());
        //六月
        cbCostAnalysisReport.setJune(cbCc.getJune());
        //七月
        cbCostAnalysisReport.setJuly(cbCc.getJuly());
        //八月
        cbCostAnalysisReport.setAugust(cbCc.getAugust());
        //九月
        cbCostAnalysisReport.setSeptember(cbCc.getSeptember());
        //十月
        cbCostAnalysisReport.setOctober(cbCc.getOctober());
        //十一月
        cbCostAnalysisReport.setNovember(cbCc.getNovember());
        //十二月
        cbCostAnalysisReport.setDecember(cbCc.getDecember());
        cbCostAnalysisReportService.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }


    /**
     * 执行母猪存栏月平均成本(元/头)
     * @param cbCc
     */
    void insertCbSowBankMonthAvgCostReportViewVoid(CbSowBankMonthAvgCostReportView cbCc){
        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();
        //类型
        cbCostAnalysisReport.setCbType(cbCc.getType());
        //项目
        cbCostAnalysisReport.setProject(cbCc.getProject());
        //种类
        cbCostAnalysisReport.setVariety(cbCc.getVariety());
        //年份
        cbCostAnalysisReport.setCbYear(cbCc.getCbYear());
        //组织ID
        cbCostAnalysisReport.setHoggeryId(cbCc.getHoggeryId());
        //组织名称
        SysDept dept = deptService.selectDeptById(cbCc.getHoggeryId());
        cbCostAnalysisReport.setHoggeryName(dept.getDeptName());
        //平均/合计
        cbCostAnalysisReport.setAvgOrTotal(cbCc.getAvgOrTotal());
        //一月
        cbCostAnalysisReport.setJan(cbCc.getJan());
        //二月
        cbCostAnalysisReport.setFebruary(cbCc.getFebruary());
        //三月
        cbCostAnalysisReport.setMarch(cbCc.getMarch());
        //四月
        cbCostAnalysisReport.setApril(cbCc.getApril());
        //五月
        cbCostAnalysisReport.setMay(cbCc.getMay());
        //六月
        cbCostAnalysisReport.setJune(cbCc.getJune());
        //七月
        cbCostAnalysisReport.setJuly(cbCc.getJuly());
        //八月
        cbCostAnalysisReport.setAugust(cbCc.getAugust());
        //九月
        cbCostAnalysisReport.setSeptember(cbCc.getSeptember());
        //十月
        cbCostAnalysisReport.setOctober(cbCc.getOctober());
        //十一月
        cbCostAnalysisReport.setNovember(cbCc.getNovember());
        //十二月
        cbCostAnalysisReport.setDecember(cbCc.getDecember());
        cbCostAnalysisReportService.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }


    /**
     * 执行头均断奶成本计算平均成本(元/头)
     * @param cbCc
     */
    void insertCbHeadAverageWeaningCostReportViewVoid(CbHeadAverageWeaningCostReportView cbCc){
        CbCostAnalysisReport cbCostAnalysisReport = new CbCostAnalysisReport();
        //类型
        cbCostAnalysisReport.setCbType(cbCc.getType());
        //项目
        cbCostAnalysisReport.setProject(cbCc.getProject());
        //种类
        cbCostAnalysisReport.setVariety(cbCc.getVariety());
        //年份
        cbCostAnalysisReport.setCbYear(cbCc.getCbYear());
        //组织ID
        cbCostAnalysisReport.setHoggeryId(cbCc.getHoggeryId());
        //组织名称
        SysDept dept = deptService.selectDeptById(cbCc.getHoggeryId());
        cbCostAnalysisReport.setHoggeryName(dept.getDeptName());
        //平均/合计
        cbCostAnalysisReport.setAvgOrTotal(cbCc.getAvgOrTotal());
        //一月
        cbCostAnalysisReport.setJan(cbCc.getJan());
        //二月
        cbCostAnalysisReport.setFebruary(cbCc.getFebruary());
        //三月
        cbCostAnalysisReport.setMarch(cbCc.getMarch());
        //四月
        cbCostAnalysisReport.setApril(cbCc.getApril());
        //五月
        cbCostAnalysisReport.setMay(cbCc.getMay());
        //六月
        cbCostAnalysisReport.setJune(cbCc.getJune());
        //七月
        cbCostAnalysisReport.setJuly(cbCc.getJuly());
        //八月
        cbCostAnalysisReport.setAugust(cbCc.getAugust());
        //九月
        cbCostAnalysisReport.setSeptember(cbCc.getSeptember());
        //十月
        cbCostAnalysisReport.setOctober(cbCc.getOctober());
        //十一月
        cbCostAnalysisReport.setNovember(cbCc.getNovember());
        //十二月
        cbCostAnalysisReport.setDecember(cbCc.getDecember());
        cbCostAnalysisReportService.insertCbCostAnalysisReport(cbCostAnalysisReport);
    }

}
