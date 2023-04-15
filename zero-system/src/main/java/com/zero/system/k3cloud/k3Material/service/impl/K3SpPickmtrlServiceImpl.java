package com.zero.system.k3cloud.k3Material.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.zero.common.utils.DateUtils;
import com.zero.system.k3cloud.k3Organization.domain.K3OrganizationMap;
import com.zero.system.k3cloud.k3Organization.service.IK3OrganizationMapService;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.system.k3cloud.k3Material.mapper.K3SpPickmtrlMapper;
import com.zero.system.k3cloud.k3Material.domain.K3SpPickmtrl;
import com.zero.system.k3cloud.k3Material.service.IK3SpPickmtrlService;

import javax.annotation.Resource;

/**
 * 第三方简单生产领料单Service业务层处理
 * 
 * @author zhuxuguang
 * @date 2023-04-03
 */
@Service
public class K3SpPickmtrlServiceImpl implements IK3SpPickmtrlService 
{
    @Autowired
    private K3SpPickmtrlMapper k3SpPickmtrlMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    //组织间映射
    @Autowired
    private IK3OrganizationMapService k3OrganizationMapService;

    /**
     * 查询第三方简单生产领料单
     * 
     * @param id 第三方简单生产领料单主键
     * @return 第三方简单生产领料单
     */
    @Override
    public K3SpPickmtrl selectK3SpPickmtrlById(Long id)
    {
        return k3SpPickmtrlMapper.selectK3SpPickmtrlById(id);
    }

    /**
     * 查询第三方简单生产领料单列表
     * 
     * @param k3SpPickmtrl 第三方简单生产领料单
     * @return 第三方简单生产领料单
     */
    @Override
    public List<K3SpPickmtrl> selectK3SpPickmtrlList(K3SpPickmtrl k3SpPickmtrl)
    {
        return k3SpPickmtrlMapper.selectK3SpPickmtrlList(k3SpPickmtrl);
    }

    /**
     * 新增第三方简单生产领料单
     * 
     * @param k3SpPickmtrl 第三方简单生产领料单
     * @return 结果
     */
    @Override
    public int insertK3SpPickmtrl(K3SpPickmtrl k3SpPickmtrl)
    {
        k3SpPickmtrl.setCreateTime(DateUtils.getNowDate());
        return k3SpPickmtrlMapper.insertK3SpPickmtrl(k3SpPickmtrl);
    }

    /**
     * 修改第三方简单生产领料单
     * 
     * @param k3SpPickmtrl 第三方简单生产领料单
     * @return 结果
     */
    @Override
    public int updateK3SpPickmtrl(K3SpPickmtrl k3SpPickmtrl)
    {
        k3SpPickmtrl.setUpdateTime(DateUtils.getNowDate());
        return k3SpPickmtrlMapper.updateK3SpPickmtrl(k3SpPickmtrl);
    }

    /**
     * 批量删除第三方简单生产领料单
     * 
     * @param ids 需要删除的第三方简单生产领料单主键
     * @return 结果
     */
    @Override
    public int deleteK3SpPickmtrlByIds(Long[] ids)
    {
        return k3SpPickmtrlMapper.deleteK3SpPickmtrlByIds(ids);
    }

    /**
     * 删除第三方简单生产领料单信息
     * 
     * @param id 第三方简单生产领料单主键
     * @return 结果
     */
    @Override
    public int deleteK3SpPickmtrlById(Long id)
    {
        return k3SpPickmtrlMapper.deleteK3SpPickmtrlById(id);
    }

    /**
     * 全部删除第三方简单生产领料单信息
     *
     * @return 结果
     */
    @Override
    public int deleteK3SpPickmtrlAll() {
        return k3SpPickmtrlMapper.deleteK3SpPickmtrlAll();
    }

    /**
     * 使用sqlSessionFactory实现批量插入
     *
     * @param list
     */
    @Override
    public void saveBeach(List<K3SpPickmtrl> list) {
        // ExecutorType.SIMPLE: 这个执行器类型不做特殊的事情。它为每个语句的执行创建一个新的预处理语句。
        // ExecutorType.REUSE: 这个执行器类型会复用预处理语句。
        // ExecutorType.BATCH: 这个执行器会批量执行所有更新语句,如果 SELECT 在它们中间执行还会标定它们是 必须的,来保证一个简单并易于理解的行为。
        // 关闭session的自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            K3SpPickmtrlMapper k3SpPickmtrlMapper = sqlSession.getMapper(K3SpPickmtrlMapper.class);
            list.stream().forEach(k3SpPickmtrl -> k3SpPickmtrlMapper.saveInfo(k3SpPickmtrl));
            // 提交数据
            sqlSession.commit();
            sqlSession.rollback();
        }catch (Exception e){
            sqlSession.rollback();
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 查询第三方简单生产领料单列表-只查询处在映射关系下的的单据
     *
     * @param
     * @return 第三方简单生产领料单
     */
    @Override
    public List<K3SpPickmtrl> selectKmK3SPList()
    {
        //查询存在映射关系的组织信息
        //需要对传入的List集合数据进行处理,过滤出进行组织映射的组织信息
        //全部映射组织关系
        List<K3OrganizationMap> listK3Om = k3OrganizationMapService.selectK3OrganizationMapAll();
        List<String> mapList = new ArrayList<>();
        for (K3OrganizationMap k3Om : listK3Om){
            mapList.add(k3Om.getK3Forgid());
        }
        return k3SpPickmtrlMapper.selectKmK3SPList(mapList);
    }
}
