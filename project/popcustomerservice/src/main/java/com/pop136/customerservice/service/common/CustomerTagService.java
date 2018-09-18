package com.pop136.customerservice.service.common;

import com.pop136.customerservice.entity.tag.TagCustomer;
import com.pop136.customerservice.mapper.agent.common.CustomerTagMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTagService extends AbstractBaseService {

  @Autowired
  private CustomerTagMapper customerTag;


  public void init() {
    setMapper(customerTag);
  }

  public List<TagCustomer> findTagsByCustomerId(String customerid)
  {
    return null;
  }

}
