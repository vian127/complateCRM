package com.pop136.customerservice.service.customer;

import com.pop136.customerservice.entity.customer.ContactServeProduct;
import com.pop136.customerservice.mapper.agent.cusotmer.ContactServeProductMapper;
import com.pop136.customerservice.service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServeProductService extends AbstractBaseService {

  @Autowired
  private ContactServeProductMapper contactMapper;


  public void init() {
    setMapper(contactMapper);
  }


  public List<ContactServeProduct> getProductList(String contactId) {
    return contactMapper.getProductList(contactId);
  }
}
