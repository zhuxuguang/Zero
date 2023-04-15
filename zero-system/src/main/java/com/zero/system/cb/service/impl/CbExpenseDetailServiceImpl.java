package com.zero.system.cb.service.impl;

import java.util.List;

import com.zero.common.core.domain.entity.SysDept;
import com.zero.common.exception.ServiceException;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.StringUtils;
import com.zero.common.utils.bean.BeanValidators;
import com.zero.system.cb.domain.CbProductionTarget;
import com.zero.system.service.ISysDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.mapper.CbExpenseDetailMapper;
import com.zero.system.cb.domain.CbExpenseDetail;
import com.zero.system.cb.service.ICbExpenseDetailService;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;

/**
 * 费用明细Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-01-17
 */
@Service
public class CbExpenseDetailServiceImpl implements ICbExpenseDetailService 
{

    private static final Logger log = LoggerFactory.getLogger(CbProductionTargetServiceImpl.class);

    @Autowired
    private CbExpenseDetailMapper cbExpenseDetailMapper;

    @Autowired
    protected Validator validator;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询费用明细
     * 
     * @param id 费用明细主键
     * @return 费用明细
     */
    @Override
    public CbExpenseDetail selectCbExpenseDetailById(Long id)
    {
        return cbExpenseDetailMapper.selectCbExpenseDetailById(id);
    }

    /**
     * 查询费用明细列表
     * 
     * @param cbExpenseDetail 费用明细
     * @return 费用明细
     */
    @Override
    public List<CbExpenseDetail> selectCbExpenseDetailList(CbExpenseDetail cbExpenseDetail)
    {
        return cbExpenseDetailMapper.selectCbExpenseDetailList(cbExpenseDetail);
    }

    /**
     * 新增费用明细
     * 
     * @param cbExpenseDetail 费用明细
     * @return 结果
     */
    @Override
    public int insertCbExpenseDetail(CbExpenseDetail cbExpenseDetail)
    {
        cbExpenseDetail.setCreateTime(DateUtils.getNowDate());
        return cbExpenseDetailMapper.insertCbExpenseDetail(cbExpenseDetail);
    }

    /**
     * 修改费用明细
     * 
     * @param cbExpenseDetail 费用明细
     * @return 结果
     */
    @Override
    public int updateCbExpenseDetail(CbExpenseDetail cbExpenseDetail)
    {
        cbExpenseDetail.setUpdateTime(DateUtils.getNowDate());
        return cbExpenseDetailMapper.updateCbExpenseDetail(cbExpenseDetail);
    }

    /**
     * 批量删除费用明细
     * 
     * @param ids 需要删除的费用明细主键
     * @return 结果
     */
    @Override
    public int deleteCbExpenseDetailByIds(Long[] ids)
    {
        return cbExpenseDetailMapper.deleteCbExpenseDetailByIds(ids);
    }

    /**
     * 删除费用明细信息
     * 
     * @param id 费用明细主键
     * @return 结果
     */
    @Override
    public int deleteCbExpenseDetailById(Long id)
    {
        return cbExpenseDetailMapper.deleteCbExpenseDetailById(id);
    }

    /**
     * 导入费用明细数据
     *
     * @param cbEdList        费用明细数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    @Override
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public String importCbExpenseDetail(List<CbExpenseDetail> cbEdList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(cbEdList) || cbEdList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        int countNum = 1;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbExpenseDetail cbExpenseDetail : cbEdList){
            try{
                countNum++;
                BeanValidators.validateWithException(validator, cbExpenseDetail);
                cbExpenseDetail.setCreateBy(operName);
                //根据组织、部门ID来获取名称
                if (StringUtils.isNull(cbExpenseDetail.getPetitionerDepartmentId()) ||
                        StringUtils.isNull(cbExpenseDetail.getPetitionerOrganizationId()) || StringUtils.isNull(cbExpenseDetail.getCostBearingOrganizationId())){
                    throw new ServiceException("数据不完整，缺少组织或部门、费用承担组织ID！");
                }else {
                    //组织名称
                    //申请部门名称
                    SysDept dept = deptService.selectDeptById(cbExpenseDetail.getPetitionerDepartmentId());
                    cbExpenseDetail.setPetitionerDepartmentName(dept.getDeptName());
                    //申请组织名称
                    SysDept dept_ = deptService.selectDeptById(cbExpenseDetail.getPetitionerOrganizationId());
                    cbExpenseDetail.setPetitionerOrganizationName(dept_.getDeptName());
                    //费用承担组织ID
                    SysDept dept__ = deptService.selectDeptById(cbExpenseDetail.getCostBearingOrganizationId());
                    cbExpenseDetail.setCostBearingOrganization(dept__.getDeptName());
                    this.insertCbExpenseDetail(cbExpenseDetail);
                    successNum++;
                    //successMsg.append("<br/>" + successNum + "、数据全部导入成功");
                }

            }catch (Exception e){
                failureNum++;
                String msg = "<br/>\"+ \"第\" + countNum + \"行数据 导入失败,异常信息如下：";
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


}
