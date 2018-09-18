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
 * 客户标签 values
 */
@Repository
@Table("sslog_tagvalue_customer")
public class TagCustomerLogMapper extends AbstractBaseMapper {
    @Override
    public void init() {
        ConditionMapping mapping = new ConditionMapping( ) ;
        super.putMapping( DEF_MAPPING_KEY , mapping);
        super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
    }

    public List<TagCustomer> findTagCustomerList(TagValueSearchVo searchVo) {
        return sqlTemplate.selectList("TagCustomerMapper.findTagCustomerList", searchVo);
    }

    public void batchInsert(List<TagCustomerLog> tagCustomerLogs) {
        sqlTemplate.update("TagCustomerMapper.tagCustomerLogs", tagCustomerLogs);
    }
}
