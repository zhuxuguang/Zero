package com.zero.system.cb.service.impl;

import java.util.List;

import com.zero.common.exception.ServiceException;
import com.zero.common.utils.DateUtils;
import com.zero.common.utils.StringUtils;
import com.zero.common.utils.bean.BeanValidators;
import com.zero.system.cb.domain.CbProductionTarget;
import com.zero.system.cb.mapper.CbProductionTargetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.cb.mapper.CbFileOfMaterialsMapper;
import com.zero.system.cb.domain.CbFileOfMaterials;
import com.zero.system.cb.service.ICbFileOfMaterialsService;

import javax.validation.Validator;

/**
 * 物料档案Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-01-18
 */
@Service
public class CbFileOfMaterialsServiceImpl implements ICbFileOfMaterialsService 
{
    @Autowired
    private CbFileOfMaterialsMapper cbFileOfMaterialsMapper;

    private static final Logger log = LoggerFactory.getLogger(CbProductionTargetServiceImpl.class);

    @Autowired
    protected Validator validator;

    /**
     * 查询物料档案
     * 
     * @param id 物料档案主键
     * @return 物料档案
     */
    @Override
    public CbFileOfMaterials selectCbFileOfMaterialsById(Long id)
    {
        return cbFileOfMaterialsMapper.selectCbFileOfMaterialsById(id);
    }

    /**
     * 查询物料档案列表
     * 
     * @param cbFileOfMaterials 物料档案
     * @return 物料档案
     */
    @Override
    public List<CbFileOfMaterials> selectCbFileOfMaterialsList(CbFileOfMaterials cbFileOfMaterials)
    {
        return cbFileOfMaterialsMapper.selectCbFileOfMaterialsList(cbFileOfMaterials);
    }

    /**
     * 新增物料档案
     * 
     * @param cbFileOfMaterials 物料档案
     * @return 结果
     */
    @Override
    public int insertCbFileOfMaterials(CbFileOfMaterials cbFileOfMaterials)
    {
        cbFileOfMaterials.setCreateTime(DateUtils.getNowDate());
        return cbFileOfMaterialsMapper.insertCbFileOfMaterials(cbFileOfMaterials);
    }

    /**
     * 修改物料档案
     * 
     * @param cbFileOfMaterials 物料档案
     * @return 结果
     */
    @Override
    public int updateCbFileOfMaterials(CbFileOfMaterials cbFileOfMaterials)
    {
        cbFileOfMaterials.setUpdateTime(DateUtils.getNowDate());
        return cbFileOfMaterialsMapper.updateCbFileOfMaterials(cbFileOfMaterials);
    }

    /**
     * 批量删除物料档案
     * 
     * @param ids 需要删除的物料档案主键
     * @return 结果
     */
    @Override
    public int deleteCbFileOfMaterialsByIds(Long[] ids)
    {
        return cbFileOfMaterialsMapper.deleteCbFileOfMaterialsByIds(ids);
    }

    /**
     * 删除物料档案信息
     * 
     * @param id 物料档案主键
     * @return 结果
     */
    @Override
    public int deleteCbFileOfMaterialsById(Long id)
    {
        return cbFileOfMaterialsMapper.deleteCbFileOfMaterialsById(id);
    }

    /**
     * 导入物料档案数据
     *
     * @param cbFMList        物料档案数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName        操作用户
     * @return 结果
     */
    @Override
    public String importCbFileOfMaterials(List<CbFileOfMaterials> cbFMList, Boolean isUpdateSupport, String operName) {

        if (StringUtils.isNull(cbFMList) || cbFMList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CbFileOfMaterials cbFileOfMaterials : cbFMList){
            try{
                BeanValidators.validateWithException(validator, cbFileOfMaterials);
                cbFileOfMaterials.setCreateBy(operName);
                this.insertCbFileOfMaterials(cbFileOfMaterials);
                successNum++;
                successMsg.append("<br/>" + successNum + "、数据全部导入成功");
            }catch (Exception e){
                failureNum++;
                String msg = "<br/>" + failureNum + "、数据 导入失败：";
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

    /**
     * 查询物料档案
     *
     * @param materialCoding 物料档案-物料编码
     * @return 物料档案
     */
    @Override
    public CbFileOfMaterials selectCbFileOfMaterialsByMaterialCoding(String materialCoding) {
        return cbFileOfMaterialsMapper.selectCbFileOfMaterialsByMaterialCoding(materialCoding);
    }
}
