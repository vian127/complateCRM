package com.pop136.customerservice.mapper.agent.user;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import org.springframework.stereotype.Repository;

@Repository
@Table("mp_msgowner")
public class MsgOwnerMapper extends AbstractBaseMapper {
  @Override
  public void init() {
    ConditionMapping mapping = new ConditionMapping( ) ;
    mapping.put("name", new Condition("name" , Condition.SYMBOL.LIKE ) ) ;
    super.putMapping( DEF_MAPPING_KEY , mapping);
    super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
  }


}
