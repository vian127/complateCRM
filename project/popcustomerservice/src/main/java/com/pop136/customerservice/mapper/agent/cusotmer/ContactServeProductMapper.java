package com.pop136.customerservice.mapper.agent.cusotmer;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.customer.Contact;
import com.pop136.customerservice.entity.customer.ContactServeProduct;
import com.pop136.customerservice.vo.customer.search.ContactSearchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table("ss_contactserve_product")
public class ContactServeProductMapper extends AbstractBaseMapper {
  @Override
  public void init() {
    ConditionMapping mapping = new ConditionMapping( ) ;
    mapping.put("name", new Condition("name" , Condition.SYMBOL.LIKE ) ) ;
    super.putMapping( DEF_MAPPING_KEY , mapping);
    super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
  }

  public List<ContactServeProduct> getProductList(String contactId) {
    return sqlTemplate.selectList("ContactServeProductMapper.getProductList", contactId);
  }
}
