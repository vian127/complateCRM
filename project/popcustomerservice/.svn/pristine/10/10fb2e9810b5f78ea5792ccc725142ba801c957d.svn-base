package com.pop136.customerservice.mapper.agent.user;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.user.Account;
import com.pop136.customerservice.entity.user.FrameWork;
import com.pop136.customerservice.entity.user.User;
import com.pop136.customerservice.entity.user.UserRole;
import com.pop136.customerservice.vo.user.UserValueVo;
import com.pop136.customerservice.vo.user.UserVo;
import com.pop136.customerservice.vo.user.search.UserValueSearchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table("mp_user")
public class UserMapper extends AbstractBaseMapper {
    @Override
    public void init() {
        ConditionMapping mapping = new ConditionMapping();
        mapping.put("name", new Condition("name", Condition.SYMBOL.LIKE));
        super.putMapping(DEF_MAPPING_KEY, mapping);
        super.setUnityFlterCondition(new Condition[]{new Condition("deleteflag", 0, Condition.SYMBOL.EQ)});
    }


    public List<UserValueVo> findUserListByNameAndPasswd(UserValueSearchVo searchVo) {
        return sqlTemplate.selectList("UserMapper.findUserByNameAndPasswd", searchVo);
    }

    public UserValueVo findUserByNameAndPasswd(UserValueSearchVo searchVo) {
        return sqlTemplate.selectOne("UserMapper.findUserByNameAndPasswd", searchVo);
    }

    /**
     * 获取 用户详情
     *
     * @return
     */
    public User getUserInfo(String roleId) {

        List<Object> result = sqlTemplate.selectList("UserMapper.getUserInfo", roleId);
        return result.isEmpty() ? null : (User) result.get(0);
    }

    public Account finAccountById(String id)
    {
        return sqlTemplate.selectOne("UserMapper.finAccountById", id);
    }

    public User findUserById(String id)
    {
        return sqlTemplate.selectOne("UserMapper.findUserById", id);
    }

    public List<FrameWork> findFrameWorkById(String id)
    {
        return sqlTemplate.selectList("UserMapper.findFrameWorkById", id);
    }


}
