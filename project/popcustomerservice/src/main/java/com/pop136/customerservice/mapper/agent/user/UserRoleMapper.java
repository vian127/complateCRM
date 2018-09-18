package com.pop136.customerservice.mapper.agent.user;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.user.UserRole;
import com.pop136.customerservice.vo.user.UserVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table("mp_userrole")
public class UserRoleMapper extends AbstractBaseMapper {
    @Override
    public void init() {
        ConditionMapping mapping = new ConditionMapping();
        mapping.put("name", new Condition("name", Condition.SYMBOL.LIKE));
        super.putMapping(DEF_MAPPING_KEY, mapping);
        super.setUnityFlterCondition(new Condition[]{new Condition("deleteflag", 0, Condition.SYMBOL.EQ)});
    }

    /**
     * 获取 用户Role详情
     *
     * @return
     */

    public UserRole findUserRoleById(String id)
    {
        return sqlTemplate.selectOne("UserRoleMapper.findUserRoleById", id);
    }

    public List<UserVo> getAllFrameWorkById(List frameworkIds)
    {
        return sqlTemplate.selectList("UserRoleMapper.getAllFrameWorkById", frameworkIds);
    }

    public List<UserVo> getAllFrameWorkId(int fatherid)
    {
        return sqlTemplate.selectList("UserRoleMapper.getAllFrameWorkId", fatherid);
    }


}
