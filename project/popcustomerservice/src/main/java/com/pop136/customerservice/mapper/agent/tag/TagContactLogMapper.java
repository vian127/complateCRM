package com.pop136.customerservice.mapper.agent.tag;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.tag.TagCustomer;
import com.pop136.customerservice.entity.tag.TagCustomerLog;
import com.pop136.customerservice.vo.tag.search.TagValueSearchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 客户 联系人 标签 values
 */
@Repository
@Table("sslog_tagvalue_contact")
public class TagContactLogMapper extends AbstractBaseMapper {
    @Override
    public void init() {
        ConditionMapping mapping = new ConditionMapping( ) ;
        super.putMapping( DEF_MAPPING_KEY , mapping);
        super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
    }

}
