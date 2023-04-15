package com.zero.system.cb.service.impl;

import java.util.List;

import com.zero.common.core.domain.entity.SysDept;
import com.zero.common.exception.ServiceException;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.StringUtils;
import com.zero.common.utils.bean.BeanValidators;
import com.zero.system.service.ISysDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.mapper.CbDeprecitionMapper;
import com.zero.system.cb.domain.CbDeprecition;
import com.zero.system.cb.service.ICbDeprecitionService;

import javax.validation.Validator;

/**
 * 折旧Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-06
 */
@Service
public class CbDeprecitionServiceImpl implements ICbDeprecitionService 
{

    private static final Logger log = LoggerFactory.getLogger(CbProductionTargetServiceImpl.class);

    @Autowired
    private CbDeprecitionMapper cbDeprecitionMapper;

    @Autowired
    protected Validator validator;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询折旧
     * 
     * @param id 折旧主键
     * @return 折旧
     */
    @Override
    public CbDeprecition selectCbDeprecitionById(Long id)
    {
        return cbDeprecitionMapper.selectCbDeprecitionById(id);
    }

    /**
     * 查询折旧列表
     * 
     * @param cbDeprecition 折旧
     * @return 折旧
     */
    @Override
    public List<CbDeprecition> selectCbDeprecitionList(CbDeprecition cbDeprecition)
    {
        return cbDeprecitionMapper.selectCbDeprecitionList(cbDeprecition);
    }

    /**
     * 新增折旧
     * 
     * @param cbDeprecition 折旧
     * @return 结果
     */
    @Override
    public int insertCbDeprecition(CbDeprecition cbDeprecition)
    {
        cbDeprecition.setCreateTime(DateUtils.getNowDate());
        return cbDeprecitionMapper.insertCbDeprecition(cbDeprecition);
    }

    /**
     * 修改折旧
     * 
     * @param cbDeprecition 折旧
     * @return 结果
     */
    @Override
    public int updateCbDeprecition(CbDeprecition cbDeprecition)
    {
        cbDeprecition.setUpdateTime(DateUtils.getNowDate());
        return cbDeprecitionMapper.updateCbDeprecition(cbDeprecition);
    }

    /**
     * 批量删除折旧
     * 
     * @param ids 需要删除的折旧主键
     * @return 结果
     */
    @Override
    public int deleteCbDeprecitionByIds(Long[] ids)
    {
        return cbDeprecitionMapper.deleteCbDeprecitionByIds(ids);
    }

    /**
     * 删除折旧信息
     * 
     * @param id 折旧主键
     * @return 结果
     */
    @Override
    public int deleteCbDeprecitionById(Long id)
    {
        return cbDeprecitionMapper.deleteCbDeprecitionById(id);
    }

    /**
     * 导入折旧数据
     *
     * @param cbDtList        折旧数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    @Override
    public String importCbDeprecition(List<CbDeprecition> cbDtList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(cbDtList) || cbDtList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        int countNum = 1;//总数
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbDeprecition cbDeprecition : cbDtList){
            try{
                BeanValidators.validateWithException(validator, cbDeprecition);
                cbDeprecition.setCreateBy(operName);
                //根据组织、部门ID来获取名称
                if(StringUtils.isNull(cbDeprecition.getShipperOrganizationId()) || StringUtils.isNull(cbDeprecition.getUserDepartmentId())){
                    throw new ServiceException("数据不完整，缺少组织或部门ID！");
                }else {
                    //组织名称
                    SysDept dept = deptService.selectDeptById(cbDeprecition.getShipperOrganizationId());
                    cbDeprecition.setFieldName(dept.getDeptName());
                    //部门名称
                    SysDept dept_ = deptService.selectDeptById(cbDeprecition.getUserDepartmentId());
                    cbDeprecition.setUserDepartment(dept_.getDeptName());
                    this.insertCbDeprecition(cbDeprecition);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据全部导入成功");
                }
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>"+ "第" + countNum + "行数据 导入失败,异常信息如下：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
