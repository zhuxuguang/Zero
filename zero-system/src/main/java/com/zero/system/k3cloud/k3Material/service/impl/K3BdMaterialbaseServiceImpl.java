package com.zero.system.k3cloud.k3Material.service.impl;

import com.zero.common.utils.DateUtils;
import com.zero.system.k3cloud.k3Material.domain.K3BdMaterialbase;
import com.zero.system.k3cloud.k3Material.mapper.K3BdMaterialbaseMapper;
import com.zero.system.k3cloud.k3Material.service.IK3BdMaterialbaseService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 存储物料信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-31
 */
@Service
public class K3BdMaterialbaseServiceImpl implements IK3BdMaterialbaseService 
{
    @Autowired
    private K3BdMaterialbaseMapper k3BdMaterialbaseMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 查询存储物料信息
     * 
     * @param id 存储物料信息主键
     * @return 存储物料信息
     */
    @Override
    public K3BdMaterialbase selectK3BdMaterialbaseById(Long id)
    {
        return k3BdMaterialbaseMapper.selectK3BdMaterialbaseById(id);
    }

    /**
     * 查询存储物料信息列表
     * 
     * @param k3BdMaterialbase 存储物料信息
     * @return 存储物料信息
     */
    @Override
    public List<K3BdMaterialbase> selectK3BdMaterialbaseList(K3BdMaterialbase k3BdMaterialbase)
    {
        return k3BdMaterialbaseMapper.selectK3BdMaterialbaseList(k3BdMaterialbase);
    }

    /**
     * 新增存储物料信息
     * 
     * @param k3BdMaterialbase 存储物料信息
     * @return 结果
     */
    @Override
    public int insertK3BdMaterialbase(K3BdMaterialbase k3BdMaterialbase)
    {
        k3BdMaterialbase.setCreateTime(DateUtils.getNowDate());
        return k3BdMaterialbaseMapper.insertK3BdMaterialbase(k3BdMaterialbase);
    }

    /**
     * 修改存储物料信息
     * 
     * @param k3BdMaterialbase 存储物料信息
     * @return 结果
     */
    @Override
    public int updateK3BdMaterialbase(K3BdMaterialbase k3BdMaterialbase)
    {
        k3BdMaterialbase.setUpdateTime(DateUtils.getNowDate());
        return k3BdMaterialbaseMapper.updateK3BdMaterialbase(k3BdMaterialbase);
    }

    /**
     * 批量删除存储物料信息
     * 
     * @param ids 需要删除的存储物料信息主键
     * @return 结果
     */
    @Override
    public int deleteK3BdMaterialbaseByIds(Long[] ids)
    {
        return k3BdMaterialbaseMapper.deleteK3BdMaterialbaseByIds(ids);
    }

    /**
     * 删除存储物料信息信息
     * 
     * @param id 存储物料信息主键
     * @return 结果
     */
    @Override
    public int deleteK3BdMaterialbaseById(Long id)
    {
        return k3BdMaterialbaseMapper.deleteK3BdMaterialbaseById(id);
    }

    /**
     * 全部删除存储第三方物料类别信息信息
     *
     * @return 结果
     */
    @Override
    public int deleteK3BdMaterialbaseAll() {
        return k3BdMaterialbaseMapper.deleteK3BdMaterialbaseAll();
    }


    @Override
    public void insertK3BdMaterialbaseAll(List<K3BdMaterialbase> k3BdMaterialbaseList) {
        k3BdMaterialbaseMapper.insertK3BdMaterialbaseAll(k3BdMaterialbaseList);
    }

    /**
     * 使用sqlSessionFactory实现批量插入
     *
     * @param list
     */
    @Override
    public void saveBeach(List<K3BdMaterialbase> list) {
        // ExecutorType.SIMPLE: 这个执行器类型不做特殊的事情。它为每个语句的执行创建一个新的预处理语句。
        // ExecutorType.REUSE: 这个执行器类型会复用预处理语句。
        // ExecutorType.BATCH: 这个执行器会批量执行所有更新语句,如果 SELECT 在它们中间执行还会标定它们是 必须的,来保证一个简单并易于理解的行为。
        // 关闭session的自动提交
        System.out.println("实现层" + list.size());
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            K3BdMaterialbaseMapper k3BdMaterialbaseMapper = sqlSession.getMapper(K3BdMaterialbaseMapper.class);
            list.stream().forEach(k3BdMaterialbase -> k3BdMaterialbaseMapper.saveInfo(k3BdMaterialbase));
            // 提交数据
            sqlSession.commit();
            sqlSession.rollback();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 查询存储物料信息
     *
     * @param fmaterialId 存储物料信息主键 物料内码
     * @return 存储物料信息
     */
    @Override
    public K3BdMaterialbase selectK3BMById(Long fmaterialId) {
        return k3BdMaterialbaseMapper.selectK3BMById(fmaterialId);
    }
}
