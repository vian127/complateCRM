package com.pop136.customerservice.mapper.agent.marketing;

import com.pop136.core.mybatis.AbstractBaseMapper;
import com.pop136.core.mybatis.annotation.Table;
import com.pop136.core.mybatis.criteria.Condition;
import com.pop136.core.mybatis.criteria.ConditionMapping;
import com.pop136.customerservice.entity.marketing.MsgSend;
import com.pop136.customerservice.vo.marketing.MsgSendVo;
import com.pop136.customerservice.vo.marketing.search.MsgSendSearchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Table("ss_msgsend")
public class MsgSendMapper extends AbstractBaseMapper {
  @Override
  public void init() {
    ConditionMapping mapping = new ConditionMapping( ) ;
    mapping.put("name", new Condition("name" , Condition.SYMBOL.LIKE ) ) ;
    super.putMapping( DEF_MAPPING_KEY , mapping);
  }


  /**
   * 获取 发送记录
   */
  public List<MsgSendVo> findMsgList(MsgSendSearchVo searchVo) {
    return sqlTemplate.selectList("MsgSendMapper.findMsgList", searchVo);
  }

  /**
   * 获取 发送记录总数
   */
  public String getMsgCount(MsgSendSearchVo searchVo) {
    return sqlTemplate.selectOne("MsgSendMapper.getMsgCount", searchVo);
  }
}
