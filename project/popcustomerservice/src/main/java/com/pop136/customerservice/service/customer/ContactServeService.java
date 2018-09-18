package com.pop136.customerservice.service.customer;

import com.pop136.customerservice.mapper.agent.cusotmer.ContactServeMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServeService extends AbstractBaseService {

  @Autowired
  private ContactServeMapper contactMapper;


  public void init() {
    setMapper(contactMapper);
  }


}
