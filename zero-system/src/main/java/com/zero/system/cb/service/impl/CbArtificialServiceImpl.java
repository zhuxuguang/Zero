package com.zero.system.cb.service.impl;

import java.util.List;

import com.zero.common.core.domain.AjaxResult;
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
import com.zero.system.cb.mapper.CbArtificialMapper;
import com.zero.system.cb.domain.CbArtificial;
import com.zero.system.cb.service.ICbArtificialService;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;

import static com.zero.common.core.domain.AjaxResult.error;

/**
 * 人工Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-06
 */
@Service
public class CbArtificialServiceImpl implements ICbArtificialService 
{


    private static final Logger log = LoggerFactory.getLogger(CbProductionTargetServiceImpl.class);

    @Autowired
    private CbArtificialMapper cbArtificialMapper;

    @Autowired
    protected Validator validator;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询人工
     * 
     * @param id 人工主键
     * @return 人工
     */
    @Override
    public CbArtificial selectCbArtificialById(Long id)
    {
        return cbArtificialMapper.selectCbArtificialById(id);
    }

    /**
     * 查询人工列表
     * 
     * @param cbArtificial 人工
     * @return 人工
     */
    @Override
    public List<CbArtificial> selectCbArtificialList(CbArtificial cbArtificial)
    {
        return cbArtificialMapper.selectCbArtificialList(cbArtificial);
    }

    /**
     * 新增人工
     * 
     * @param cbArtificial 人工
     * @return 结果
     */
    @Override
    public int insertCbArtificial(CbArtificial cbArtificial)
    {
        cbArtificial.setCreateTime(DateUtils.getNowDate());
        return cbArtificialMapper.insertCbArtificial(cbArtificial);
    }

    /**
     * 修改人工
     * 
     * @param cbArtificial 人工
     * @return 结果
     */
    @Override
    public int updateCbArtificial(CbArtificial cbArtificial)
    {
        cbArtificial.setUpdateTime(DateUtils.getNowDate());
        return cbArtificialMapper.updateCbArtificial(cbArtificial);
    }

    /**
     * 批量删除人工
     * 
     * @param ids 需要删除的人工主键
     * @return 结果
     */
    @Override
    public int deleteCbArtificialByIds(Long[] ids)
    {
        return cbArtificialMapper.deleteCbArtificialByIds(ids);
    }

    /**
     * 删除人工信息
     * 
     * @param id 人工主键
     * @return 结果
     */
    @Override
    public int deleteCbArtificialById(Long id)
    {
        return cbArtificialMapper.deleteCbArtificialById(id);
    }

    /**
     * 导入人工数据数据
     *
     * @param cbAList         人工数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    @Override
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public String importCbArtificial(List<CbArtificial> cbAList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(cbAList) || cbAList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbArtificial cbArtificial : cbAList){
            try{
                BeanValidators.validateWithException(validator, cbArtificial);
                cbArtificial.setCreateBy(operName);
                //根据组织、部门ID来获取名称
                if (StringUtils.isNull(cbArtificial.getCompanyId()) && StringUtils.isNull(cbArtificial.getHoggeryId())){
                    throw new ServiceException("数据不完整，缺少组织或部门ID，请检查数据！");
                }else {
                    //组织名称
                    SysDept dept = deptService.selectDeptById(cbArtificial.getCompanyId());
                    cbArtificial.setCompanyName(dept.getDeptName());
                    //部门名称
                    SysDept dept_ = deptService.selectDeptById(cbArtificial.getHoggeryId());
                    cbArtificial.setHoggeryName(dept_.getDeptName());

                    this.insertCbArtificial(cbArtificial);
                    successNum++;
                    //successMsg.append("人工数据全部导入成功");
                }
            }catch (Exception e){
                failureNum++;
                String msg = "人工数据导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，数据导入失败，回滚至导入前状态！错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！");
        }
        return successMsg.toString();
    }
}
