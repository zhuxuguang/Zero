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
import com.zero.system.cb.mapper.CbSyntheticalMapper;
import com.zero.system.cb.domain.CbSynthetical;
import com.zero.system.cb.service.ICbSyntheticalService;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;

/**
 * 其他数据Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-02-21
 */
@Service
public class CbSyntheticalServiceImpl implements ICbSyntheticalService 
{
    private static final Logger log = LoggerFactory.getLogger(CbProductionTargetServiceImpl.class);

    @Autowired
    private CbSyntheticalMapper cbSyntheticalMapper;

    @Autowired
    protected Validator validator;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询其他数据
     * 
     * @param id 其他数据主键
     * @return 其他数据
     */
    @Override
    public CbSynthetical selectCbSyntheticalById(Long id)
    {
        return cbSyntheticalMapper.selectCbSyntheticalById(id);
    }

    /**
     * 查询其他数据列表
     * 
     * @param cbSynthetical 其他数据
     * @return 其他数据
     */
    @Override
    public List<CbSynthetical> selectCbSyntheticalList(CbSynthetical cbSynthetical)
    {
        return cbSyntheticalMapper.selectCbSyntheticalList(cbSynthetical);
    }

    /**
     * 新增其他数据
     * 
     * @param cbSynthetical 其他数据
     * @return 结果
     */
    @Override
    public int insertCbSynthetical(CbSynthetical cbSynthetical)
    {
        cbSynthetical.setCreateTime(DateUtils.getNowDate());
        return cbSyntheticalMapper.insertCbSynthetical(cbSynthetical);
    }

    /**
     * 修改其他数据
     * 
     * @param cbSynthetical 其他数据
     * @return 结果
     */
    @Override
    public int updateCbSynthetical(CbSynthetical cbSynthetical)
    {
        cbSynthetical.setUpdateTime(DateUtils.getNowDate());
        return cbSyntheticalMapper.updateCbSynthetical(cbSynthetical);
    }

    /**
     * 批量删除其他数据
     * 
     * @param ids 需要删除的其他数据主键
     * @return 结果
     */
    @Override
    public int deleteCbSyntheticalByIds(Long[] ids)
    {
        return cbSyntheticalMapper.deleteCbSyntheticalByIds(ids);
    }

    /**
     * 删除其他数据信息
     * 
     * @param id 其他数据主键
     * @return 结果
     */
    @Override
    public int deleteCbSyntheticalById(Long id)
    {
        return cbSyntheticalMapper.deleteCbSyntheticalById(id);
    }

    /**
     * 导入其他数据
     *
     * @param cbSList         其他数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    @Override
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public String importCbSyntheticalTarget(List<CbSynthetical> cbSList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(cbSList) || cbSList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        int countNum = 1;//总数
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbSynthetical cbSynthetical : cbSList){
            try{
                countNum++;
                BeanValidators.validateWithException(validator, cbSynthetical);
                cbSynthetical.setCreateBy(operName);
                if (StringUtils.isNull(cbSynthetical.getHoggeryId())){
                    throw new ServiceException("数据不完整，缺少组织或部门ID！");
                }else {
                    //组织名称
                    SysDept dept = deptService.selectDeptById(cbSynthetical.getHoggeryId());
                    cbSynthetical.setHoggeryName(dept.getDeptName());
                    this.insertCbSynthetical(cbSynthetical);
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
