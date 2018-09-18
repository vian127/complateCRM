package com.pop136.customerservice.mapper.agent.marketing;

import com.github.pagehelper.PageHelper;
import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.marketing.MsgBatch;
import com.pop136.customerservice.vo.marketing.search.MsgBatchSearchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table("ss_msgbatch")
public class MsgBatchMapper extends AbstractBaseMapper {
  @Override
  public void init() {
    ConditionMapping mapping = new ConditionMapping( ) ;
    mapping.put("name", new Condition("name" , Condition.SYMBOL.LIKE ) ) ;
    super.putMapping( DEF_MAPPING_KEY , mapping);
    super.setUnityFlterCondition( new Condition[]{ new Condition("deleteflag" , 0 , Condition.SYMBOL.EQ )});
  }


  public List<MsgBatch> getBatchList(MsgBatchSearchVo searchVo) {

    PageHelper.startPage(searchVo.getPage(), searchVo.getSize());

    return sqlTemplate.selectList("MsgBatchMapper.getBatchList", searchVo);
  }

  public String getBatchCount(MsgBatchSearchVo searchVo) {

    return sqlTemplate.selectOne("MsgBatchMapper.getBatchCount", searchVo);
  }
}
