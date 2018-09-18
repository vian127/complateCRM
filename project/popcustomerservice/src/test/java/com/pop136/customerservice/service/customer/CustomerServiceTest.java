package com.pop136.customerservice.service.customer;

import com.pop136.customerservice.CustomerServiceApplication;
import com.pop136.customerservice.mapper.agent.marketing.MsgSendMapper;
import com.pop136.customerservice.mapper.agent.tag.TagCustomerMapper;
import com.pop136.customerservice.vo.marketing.MsgSendVo;
import com.pop136.customerservice.vo.marketing.search.MsgSendSearchVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CustomerServiceApplication.class)
public class CustomerServiceTest {

  @Autowired
  private TagCustomerMapper tagCustomerMapper;

  @Autowired
  private MsgSendMapper sendMapper;

  @Test
  public void getCustomerTagVal() throws Exception {
    MsgSendSearchVo msgSendSearchVo = new MsgSendSearchVo();

    List<MsgSendVo> msgList = sendMapper.findMsgList(msgSendSearchVo);
    System.out.println(msgList);


  }

}