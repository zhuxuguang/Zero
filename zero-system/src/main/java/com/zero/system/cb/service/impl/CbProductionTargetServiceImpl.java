package com.zero.system.cb.service.impl;

import java.util.List;

import com.zero.common.core.domain.entity.SysDept;
import com.zero.common.exception.ServiceException;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.StringUtils;
import com.zero.common.utils.bean.BeanValidators;
import com.zero.system.service.ISysDeptService;
import com.zero.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.mapper.CbProductionTargetMapper;
import com.zero.system.cb.domain.CbProductionTarget;
import com.zero.system.cb.service.ICbProductionTargetService;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;

/**
 * 生产目标Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-01-05
 */
@Service
public class CbProductionTargetServiceImpl implements ICbProductionTargetService 
{

    private static final Logger log = LoggerFactory.getLogger(CbProductionTargetServiceImpl.class);

    @Autowired
    private CbProductionTargetMapper cbProductionTargetMapper;


    @Autowired
    protected Validator validator;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询生产目标
     * 
     * @param id 生产目标主键
     * @return 生产目标
     */
    @Override
    public CbProductionTarget selectCbProductionTargetById(Long id)
    {
        return cbProductionTargetMapper.selectCbProductionTargetById(id);
    }

    /**
     * 查询生产目标列表
     * 
     * @param cbProductionTarget 生产目标
     * @return 生产目标
     */
    @Override
    public List<CbProductionTarget> selectCbProductionTargetList(CbProductionTarget cbProductionTarget)
    {
        return cbProductionTargetMapper.selectCbProductionTargetList(cbProductionTarget);
    }

    /**
     * 新增生产目标
     * 
     * @param cbProductionTarget 生产目标
     * @return 结果
     */
    @Override
    public int insertCbProductionTarget(CbProductionTarget cbProductionTarget)
    {
        cbProductionTarget.setCreateTime(DateUtils.getNowDate());
        return cbProductionTargetMapper.insertCbProductionTarget(cbProductionTarget);
    }

    /**
     * 修改生产目标
     * 
     * @param cbProductionTarget 生产目标
     * @return 结果
     */
    @Override
    public int updateCbProductionTarget(CbProductionTarget cbProductionTarget)
    {
        cbProductionTarget.setUpdateTime(DateUtils.getNowDate());
        return cbProductionTargetMapper.updateCbProductionTarget(cbProductionTarget);
    }

    /**
     * 批量删除生产目标
     * 
     * @param ids 需要删除的生产目标主键
     * @return 结果
     */
    @Override
    public int deleteCbProductionTargetByIds(Long[] ids)
    {
        return cbProductionTargetMapper.deleteCbProductionTargetByIds(ids);
    }

    /**
     * 删除生产目标信息
     * 
     * @param id 生产目标主键
     * @return 结果
     */
    @Override
    public int deleteCbProductionTargetById(Long id)
    {
        return cbProductionTargetMapper.deleteCbProductionTargetById(id);
    }

    /**
     * 导入生产目标数据
     *
     * @param cbPtList        生产目标数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    @Override
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public String importCbProductionTarget(List<CbProductionTarget> cbPtList, Boolean isUpdateSupport, String operName) {

        if (StringUtils.isNull(cbPtList) || cbPtList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        int countNum = 1;//总数
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbProductionTarget cbProductionTarget : cbPtList){
            try{
                countNum++;
                BeanValidators.validateWithException(validator, cbProductionTarget);
                cbProductionTarget.setCreateBy(operName);
                if (StringUtils.isNull(cbProductionTarget.getFieldId())){
                    throw new ServiceException("数据不完整，缺少组织或部门ID！");
                }else {
                    //组织名称
                    SysDept dept = deptService.selectDeptById(Long.parseLong(cbProductionTarget.getFieldId()));
                    cbProductionTarget.setFieldName(dept.getDeptName());
                    this.insertCbProductionTarget(cbProductionTarget);
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
}
