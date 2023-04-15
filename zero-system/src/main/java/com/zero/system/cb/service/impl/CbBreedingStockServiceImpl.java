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
import com.zero.system.cb.mapper.CbBreedingStockMapper;
import com.zero.system.cb.domain.CbBreedingStock;
import com.zero.system.cb.service.ICbBreedingStockService;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;

/**
 * 存栏情况Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-01-30
 */
@Service
public class CbBreedingStockServiceImpl implements ICbBreedingStockService 
{

    private static final Logger log = LoggerFactory.getLogger(CbProductionTargetServiceImpl.class);

    @Autowired
    private CbBreedingStockMapper cbBreedingStockMapper;

    @Autowired
    protected Validator validator;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 查询存栏情况
     * 
     * @param id 存栏情况主键
     * @return 存栏情况
     */
    @Override
    public CbBreedingStock selectCbBreedingStockById(Long id)
    {
        return cbBreedingStockMapper.selectCbBreedingStockById(id);
    }

    /**
     * 查询存栏情况列表
     * 
     * @param cbBreedingStock 存栏情况
     * @return 存栏情况
     */
    @Override
    public List<CbBreedingStock> selectCbBreedingStockList(CbBreedingStock cbBreedingStock)
    {
        return cbBreedingStockMapper.selectCbBreedingStockList(cbBreedingStock);
    }

    /**
     * 新增存栏情况
     * 
     * @param cbBreedingStock 存栏情况
     * @return 结果
     */
    @Override
    public int insertCbBreedingStock(CbBreedingStock cbBreedingStock)
    {
        cbBreedingStock.setCreateTime(DateUtils.getNowDate());
        return cbBreedingStockMapper.insertCbBreedingStock(cbBreedingStock);
    }

    /**
     * 修改存栏情况
     * 
     * @param cbBreedingStock 存栏情况
     * @return 结果
     */
    @Override
    public int updateCbBreedingStock(CbBreedingStock cbBreedingStock)
    {
        cbBreedingStock.setUpdateTime(DateUtils.getNowDate());
        return cbBreedingStockMapper.updateCbBreedingStock(cbBreedingStock);
    }

    /**
     * 批量删除存栏情况
     * 
     * @param ids 需要删除的存栏情况主键
     * @return 结果
     */
    @Override
    public int deleteCbBreedingStockByIds(Long[] ids)
    {
        return cbBreedingStockMapper.deleteCbBreedingStockByIds(ids);
    }

    /**
     * 删除存栏情况信息
     * 
     * @param id 存栏情况主键
     * @return 结果
     */
    @Override
    public int deleteCbBreedingStockById(Long id)
    {
        return cbBreedingStockMapper.deleteCbBreedingStockById(id);
    }

    /**
     * 导入存栏情况数据
     *
     * @param cbBsList        存栏情况数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    @Override
    //事务回滚
    @Transactional(rollbackFor = Exception.class)
    public String importCbBreedingStock(List<CbBreedingStock> cbBsList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(cbBsList) || cbBsList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        int countNum = 1;//总数
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbBreedingStock cbBreedingStock : cbBsList){
            try{
                countNum++;
                BeanValidators.validateWithException(validator, cbBreedingStock);
                cbBreedingStock.setCreateBy(operName);
                if(StringUtils.isNull(cbBreedingStock.getHoggeryId())){
                    throw new ServiceException("数据不完整，缺少组织或部门ID！");
                }else {
                    //组织名称
                    SysDept dept = deptService.selectDeptById(cbBreedingStock.getHoggeryId());
                    cbBreedingStock.setHoggeryName(dept.getDeptName());
                    this.insertCbBreedingStock(cbBreedingStock);
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
