package com.pop136.customerservice.mapper.agent.user;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import org.springframework.stereotype.Repository;

@Repository
@Table("v_ss_use")
public class UserViewMapper extends AbstractBaseMapper {
    @Override
    public void init() {
        ConditionMapping mapping = new ConditionMapping();
        super.putMapping(DEF_MAPPING_KEY, mapping);
    }

}
