package com.pop136.customerservice.controller.print;


import com.pop136.core.BeanUtil;
import com.pop136.customerservice.service.customer.CustomerService;
import com.pop136.customerservice.vo.customer.search.CustomerSearchVo;
import com.pop136.customerservice.vo.customer.search.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/poi")
public class PoiController {

  @Autowired
  private CustomerService customerService;

  /**
   * 批次列表
   */
  @RequestMapping(value = "/print",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      method = RequestMethod.GET)
  private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<HashMap<String, Object>> listMap = new ArrayList<>();
    HashMap<String,Object> dataMap = new HashMap<>();

    CustomerSearchVo searchVo = new CustomerSearchVo();
    searchVo.setOwnerId("000101WD");
    searchVo.setPage(1);

    List<CustomerVo> customerVos = customerService.getCustomerList(searchVo);

    for (CustomerVo customerVo : customerVos) {
      BeanUtil.checkPrintParam(customerVo);
      dataMap.put("datetime", customerVo.getLoginDate());
      dataMap.put("person", customerVo.getAccountName());
      dataMap.put("type", customerVo.getReceiveDate());
      dataMap.put("content", customerVo.getCompanyName());
      listMap.add(dataMap);
    }

    String title = "用户列表导出数据";
    String[] rowsName = new String[]{"序号","时间","发言人","类型","消息"};
    List<Object[]> dataList = new ArrayList<Object[]>();
    Object[] objs = null;
    for (int i = 0; i < listMap.size(); i++) {
      HashMap<String, Object> data = listMap.get(i);
      objs = new Object[rowsName.length];
      objs[0] = i;
      objs[1] = data.get("datetime");
      objs[2] = data.get("person");
      objs[3] = data.get("type");
      objs[4] = data.get("content");
      dataList.add(objs);
    }
     PoiPrintUtils ex = new PoiPrintUtils(title, rowsName, dataList);

    ex.export(response);

  }
}
