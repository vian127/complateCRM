package com.pop136.customerservice.mapper.agent.marketing;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.marketing.MsgTemplate;
import com.pop136.customerservice.vo.marketing.search.MsgTemplateSearchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table("ss_msgtemplate")
public class MsgTemplateMapper extends AbstractBaseMapper {
  @Override
  public void init() {
    ConditionMapping mapping = new ConditionMapping( ) ;
    mapping.put("name", new Condition("name" , Condition.SYMBOL.LIKE ) ) ;
    super.putMapping( DEF_MAPPING_KEY , mapping);
    super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
  }


  /**
   * 获取 模版列表
   * @param searchVo
   * @return
   */
  public List<MsgTemplate> findTemplateList(MsgTemplateSearchVo searchVo) {
    return sqlTemplate.selectList("MsgTemplateMapper.findTemplateList", searchVo);
  }

  public String getTemplateCount(MsgTemplateSearchVo searchVo) {
    return sqlTemplate.selectOne("MsgTemplateMapper.getTemplateCount", searchVo);
  }

  public List<MsgTemplate> getSelectList() {
    return sqlTemplate.selectList("MsgTemplateMapper.findSelectList");
  }
}
