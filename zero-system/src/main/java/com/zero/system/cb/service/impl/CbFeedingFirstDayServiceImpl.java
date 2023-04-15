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
import com.zero.system.cb.mapper.CbFeedingFirstDayMapper;
import com.zero.system.cb.domain.CbFeedingFirstDay;
import com.zero.system.cb.service.ICbFeedingFirstDayService;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;

/**
 * 饲养头日Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-01-31
 */
@Service
public class CbFeedingFirstDayServiceImpl implements ICbFeedingFirstDayService 
{

    private static final Logger log = LoggerFactory.getLogger(CbProductionTargetServiceImpl.class);

    @Autowired
    private CbFeedingFirstDayMapper cbFeedingFirstDayMapper;

    @Autowired
    protected Validator validator;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询饲养头日
     * 
     * @param id 饲养头日主键
     * @return 饲养头日
     */
    @Override
    public CbFeedingFirstDay selectCbFeedingFirstDayById(Long id)
    {
        return cbFeedingFirstDayMapper.selectCbFeedingFirstDayById(id);
    }

    /**
     * 查询饲养头日列表
     * 
     * @param cbFeedingFirstDay 饲养头日
     * @return 饲养头日
     */
    @Override
    public List<CbFeedingFirstDay> selectCbFeedingFirstDayList(CbFeedingFirstDay cbFeedingFirstDay)
    {
        return cbFeedingFirstDayMapper.selectCbFeedingFirstDayList(cbFeedingFirstDay);
    }

    /**
     * 新增饲养头日
     * 
     * @param cbFeedingFirstDay 饲养头日
     * @return 结果
     */
    @Override
    public int insertCbFeedingFirstDay(CbFeedingFirstDay cbFeedingFirstDay)
    {
        cbFeedingFirstDay.setCreateTime(DateUtils.getNowDate());
        return cbFeedingFirstDayMapper.insertCbFeedingFirstDay(cbFeedingFirstDay);
    }

    /**
     * 修改饲养头日
     * 
     * @param cbFeedingFirstDay 饲养头日
     * @return 结果
     */
    @Override
    public int updateCbFeedingFirstDay(CbFeedingFirstDay cbFeedingFirstDay)
    {
        cbFeedingFirstDay.setUpdateTime(DateUtils.getNowDate());
        return cbFeedingFirstDayMapper.updateCbFeedingFirstDay(cbFeedingFirstDay);
    }

    /**
     * 批量删除饲养头日
     * 
     * @param ids 需要删除的饲养头日主键
     * @return 结果
     */
    @Override
    public int deleteCbFeedingFirstDayByIds(Long[] ids)
    {
        return cbFeedingFirstDayMapper.deleteCbFeedingFirstDayByIds(ids);
    }

    /**
     * 删除饲养头日信息
     *
     * @param id 饲养头日主键
     * @return 结果
     */
    @Override
    public int deleteCbFeedingFirstDayById(Long id)
    {
        return cbFeedingFirstDayMapper.deleteCbFeedingFirstDayById(id);
    }

    /**
     * 导入饲养头日数据
     *
     * @param cbFFList        饲养头日数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String importCbFeedingFirstDay(List<CbFeedingFirstDay> cbFFList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(cbFFList) || cbFFList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        int countNum = 1;//总数
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbFeedingFirstDay cbFeedingFirstDay : cbFFList){
            try{
                countNum++;
                BeanValidators.validateWithException(validator, cbFeedingFirstDay);
                cbFeedingFirstDay.setCreateBy(operName);
                if (StringUtils.isNull(cbFeedingFirstDay.getHoggeryId())){
                    throw new ServiceException("数据不完整，缺少组织或部门ID！");
                }else {
                    //组织名称
                    SysDept dept = deptService.selectDeptById(cbFeedingFirstDay.getHoggeryId());
                    cbFeedingFirstDay.setHoggeryName(dept.getDeptName());
                    this.insertCbFeedingFirstDay(cbFeedingFirstDay);
                    successNum++;
                    //successMsg.append("<br/>" + successNum + "、数据全部导入成功");
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
