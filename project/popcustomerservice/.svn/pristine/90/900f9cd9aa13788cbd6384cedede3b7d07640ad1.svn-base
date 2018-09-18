package com.pop136.customerservice.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.pop136.customerservice.controller.BaseApiAction;
import com.pop136.customerservice.service.common.DataDictService;
import com.pop136.customerservice.utils.JsonParseUtil;
import com.pop136.customerservice.vo.common.DatadictVo;
import com.pop136.customerservice.vo.customer.search.CustomerSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典表 controller
 */
@RestController
@RequestMapping("/datadict")
public class DataDictController extends BaseApiAction {

  @Autowired
  private DataDictService dataDictService;

  /**
   * 获取 客户 城市列表
   */
  @RequestMapping(value = "/getArea",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
      method = RequestMethod.POST)
  @ResponseBody
  public String getArea(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
    String fatherid = JsonParseUtil.parseRequiredStringValue(jsonObject, "fatherid");

    List<DatadictVo> datadictVos =  dataDictService.findAreaList(fatherid);

    return success(datadictVos);
  }


  /**
   * 获取 客户  标签列表
   */
  @RequestMapping(value = "/getTag",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
      method = RequestMethod.POST)
  @ResponseBody
  public String getTag(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
    String fatherid = JsonParseUtil.parseRequiredStringValue(jsonObject, "fatherid");
    String type = JsonParseUtil.parseRequiredStringValue(jsonObject, "type");

    Map<String, Object> param = new HashMap<>();
    param.put("fatherid", fatherid);
    param.put("stype", type);


    List<DatadictVo> dataDictVos =  dataDictService.findTagList(param);


    return success(dataDictVos);
  }


}
