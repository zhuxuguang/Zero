package com.zero.system.cb.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zero.common.core.domain.AjaxResult;
import com.zero.common.core.domain.entity.SysDept;
import com.zero.common.exception.ServiceException;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.SecurityUtils;
import com.zero.common.utils.StringUtils;
import com.zero.common.utils.bean.BeanValidators;
import com.zero.system.cb.domain.CbFileOfMaterials;
import com.zero.system.cb.service.ICbFileOfMaterialsService;
import com.zero.system.k3cloud.k3Material.domain.K3BdMaterialbase;
import com.zero.system.k3cloud.k3Material.domain.K3SpPickmtrl;
import com.zero.system.k3cloud.k3Material.mapper.K3SpPickmtrlMapper;
import com.zero.system.k3cloud.k3Material.service.IK3BdMaterialbaseService;
import com.zero.system.k3cloud.k3Organization.domain.K3OrganizationMap;
import com.zero.system.k3cloud.k3Organization.service.IK3OrganizationMapService;
import com.zero.system.service.ISysDeptService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.mapper.CbProductionMaterialMapper;
import com.zero.system.cb.domain.CbProductionMaterial;
import com.zero.system.cb.service.ICbProductionMaterialService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.validation.Validator;

/**
 * 生产领料Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-01-05
 */
@Service
public class CbProductionMaterialServiceImpl implements ICbProductionMaterialService 
{

    private static final Logger log = LoggerFactory.getLogger(CbProductionMaterialServiceImpl.class);

    @Autowired
    private CbProductionMaterialMapper cbProductionMaterialMapper;

    @Autowired
    protected Validator validator;

    @Autowired
    private ISysDeptService deptService;

    //本地物料档案
    @Autowired
    private ICbFileOfMaterialsService cbFileOfMaterialsService;

    //组织间映射
    @Autowired
    private IK3OrganizationMapService k3OrganizationMapService;

    //第三方物料基础信息
    @Autowired
    private IK3BdMaterialbaseService k3BdMaterialbaseService;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 查询生产领料
     * 
     * @param id 生产领料主键
     * @return 生产领料
     */
    @Override
    public CbProductionMaterial selectCbProductionMaterialById(Long id)
    {
        return cbProductionMaterialMapper.selectCbProductionMaterialById(id);
    }

    /**
     * 查询生产领料列表
     * 
     * @param cbProductionMaterial 生产领料
     * @return 生产领料
     */
    @Override
    public List<CbProductionMaterial> selectCbProductionMaterialList(CbProductionMaterial cbProductionMaterial)
    {
        return cbProductionMaterialMapper.selectCbProductionMaterialList(cbProductionMaterial);
    }

    /**
     * 新增生产领料
     * 
     * @param cbProductionMaterial 生产领料
     * @return 结果
     */
    @Override
    public int insertCbProductionMaterial(CbProductionMaterial cbProductionMaterial)
    {
        cbProductionMaterial.setCreateTime(DateUtils.getNowDate());
        return cbProductionMaterialMapper.insertCbProductionMaterial(cbProductionMaterial);
    }

    /**
     * 修改生产领料
     * 
     * @param cbProductionMaterial 生产领料
     * @return 结果
     */
    @Override
    public int updateCbProductionMaterial(CbProductionMaterial cbProductionMaterial)
    {
        cbProductionMaterial.setUpdateTime(DateUtils.getNowDate());
        return cbProductionMaterialMapper.updateCbProductionMaterial(cbProductionMaterial);
    }

    /**
     * 批量删除生产领料
     * 
     * @param ids 需要删除的生产领料主键
     * @return 结果
     */
    @Override
    public int deleteCbProductionMaterialByIds(Long[] ids)
    {
        return cbProductionMaterialMapper.deleteCbProductionMaterialByIds(ids);
    }

    /**
     * 删除生产领料信息
     * 
     * @param id 生产领料主键
     * @return 结果
     */
    @Override
    public int deleteCbProductionMaterialById(Long id)
    {
        return cbProductionMaterialMapper.deleteCbProductionMaterialById(id);
    }

    /**
     * 导入生产目标数据
     *
     * @param cbPmList        生产目标数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    @Override
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public String importCbProductionMaterial(List<CbProductionMaterial> cbPmList, Boolean isUpdateSupport, String operName) {

        if (StringUtils.isNull(cbPmList) || cbPmList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;//成功数
        int failureNum = 0;//失败数
        int countNum = 1;//总数
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbProductionMaterial cbProductionMaterial : cbPmList){
            try{
                countNum++;
                BeanValidators.validateWithException(validator, cbProductionMaterial);
                cbProductionMaterial.setCreateBy(operName);
                if (StringUtils.isNull(cbProductionMaterial.getFieldId())){
                    throw new ServiceException("数据不完整，缺少组织或部门ID！");
                }else {
                    //组织名称
                    SysDept dept = deptService.selectDeptById(cbProductionMaterial.getFieldId());
                    cbProductionMaterial.setFieldName(dept.getDeptName());
                    //物料类型 根据物料档案查询物料类型
                    CbFileOfMaterials cbFileOfMaterials = cbFileOfMaterialsService.selectCbFileOfMaterialsByMaterialCoding(cbProductionMaterial.getMaterialCoding());
                    cbProductionMaterial.setCategory(cbFileOfMaterials.getCategory());
                    this.insertCbProductionMaterial(cbProductionMaterial);
                    successNum++;
                }
                //successMsg.append("<br/>" + successNum + "、数据全部导入成功");
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>"+ "第" + countNum + "行数据 导入失败,异常信息如下：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，数据回滚至导入前状态，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条");
        }
        return successMsg.toString();
    }


    /**
     * 合并第三方单据信息
     * 1、发料组织要做特殊处理、首先要检查映射关系，存在映射关系的才将单据合并到映射组织上去
     *
     * @param k3SpPickmtrlList
     * @return
     */
    @Override
    //事务回滚
    @Transactional(rollbackFor = { Exception.class })
    public String mergeCbProductionMaterial(List<K3SpPickmtrl> k3SpPickmtrlList) throws ParseException {
        //构建新的集合，用作批量插入
        List<CbProductionMaterial> cbPmList = new ArrayList<>();
        //处理数据
        for (K3SpPickmtrl k3Sp : k3SpPickmtrlList){
            CbProductionMaterial cbPm = new CbProductionMaterial();
            //处理日期 2018-06-01T00:00:00
            //替换字符串 2018-06-01 00:00:00
            String _dd = k3Sp.getFdate().replaceAll("T"," ");
            //日期转换
            Date K3Dd = DateUtils.parseDate(_dd);
            //年
            cbPm.setCbYear(_dd.substring(0,4));
            //月
            cbPm.setCbMonth(_dd.substring(5,7));
            //单据编号
            cbPm.setDocumentCode(k3Sp.getFbillno());
            //业务日期
            cbPm.setBusinessDate(K3Dd);
            //单据状态
            cbPm.setDocumentStatus(k3Sp.getFdocumentStatus());
            /**
             * 发料组织
             * 1、发料组织要做特殊处理、根据第三方ID查询本地组织信息，进行存储
             */
            K3OrganizationMap k3Om = k3OrganizationMapService.selectK3OMByk3Forgid(k3Sp.getFstockorgId());
            //发料组织ID
            cbPm.setFieldId(Long.parseLong(k3Om.getDeptId()));
            //发料名称
            cbPm.setFieldName(k3Om.getDeptName());
            //物料编码
            //根据物料内码查询物料编码
            K3BdMaterialbase k3BMb = k3BdMaterialbaseService.selectK3BMById(Long.parseLong(k3Sp.getFmaterialId()));
            cbPm.setMaterialCoding(k3BMb.getFnumber());
            //物料名称
            cbPm.setMaterialName(k3Sp.getFmaterialName());
            //业务类型
            cbPm.setBusinessType(k3Sp.getFtransferbiztypeId());
            //规格型号
            cbPm.setSpecifications(k3Sp.getFspecification());
            //单位
            cbPm.setUnits(k3Sp.getFunitid());
            //实发数量
            cbPm.setActualQuantityIssued(k3Sp.getFactualqty());
            //领入栋舍
            cbPm.setShowInHouse(k3Sp.getFds());
            //仓库
            cbPm.setWarehouse(k3Sp.getFstockId());
            //总成本
            cbPm.setTotalCost(k3Sp.getFamount());
            //物料类别-存货类别
            cbPm.setCategory(k3BMb.getFcategoryName());
            //创建者
            cbPm.setCreateBy(SecurityUtils.getUsername());
            //插入
            cbPmList.add(cbPm);
        }
        //批量插入
        // ExecutorType.SIMPLE: 这个执行器类型不做特殊的事情。它为每个语句的执行创建一个新的预处理语句。
        // ExecutorType.REUSE: 这个执行器类型会复用预处理语句。
        // ExecutorType.BATCH: 这个执行器会批量执行所有更新语句,如果 SELECT 在它们中间执行还会标定它们是 必须的,来保证一个简单并易于理解的行为。
        // 关闭session的自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try{
            CbProductionMaterialMapper cbProductionMaterialMapper = sqlSession.getMapper(CbProductionMaterialMapper.class);
            cbPmList.stream().forEach(cbProductionMaterial -> cbProductionMaterialMapper.saveInfo(cbProductionMaterial));
            // 提交数据
            sqlSession.commit();
            sqlSession.rollback();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return e.getMessage();
        }finally {
            sqlSession.close();
        }
        return "已完成合并，请核对数据";
    }

    /**
     * String 字符串裁剪
     * @param sourceString
     * @param chElemData
     * @return
     */
    public String deleteCharString(String sourceString, String chElemData){
        String tmpString = "";
        tmpString += chElemData;
        StringBuffer stringBuffer = new StringBuffer(sourceString);
        int iFlag = -1;
        do {
            iFlag = stringBuffer.indexOf(tmpString);
            if (iFlag != -1) {
                stringBuffer.deleteCharAt(iFlag);
            }
        } while (iFlag != -1);
        return stringBuffer.toString();
    }
}
