package com.pop136.customerservice.service.marketing;

import com.pop136.customerservice.entity.marketing.MsgTemplate;
import com.pop136.customerservice.mapper.agent.marketing.MsgTemplateMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import com.pop136.customerservice.vo.marketing.search.MsgTemplateSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgTemplateService extends AbstractBaseService {

  @Autowired
  private MsgTemplateMapper msgTemplateMapper;


  public void init() {
    setMapper(msgTemplateMapper);
  }


  public List<MsgTemplate> findTemplateList(MsgTemplateSearchVo searchVo) {
    return msgTemplateMapper.findTemplateList(searchVo);
  }

  public String getTemplateCount(MsgTemplateSearchVo searchVo) {
    return msgTemplateMapper.getTemplateCount(searchVo);
  }

  public List<MsgTemplate> getSelectList() {
    return msgTemplateMapper.getSelectList();
  }
}
