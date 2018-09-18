package com.pop136.customerservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.pop136.customerservice.service.common.RedisService;
import com.pop136.customerservice.service.user.UserService;
import com.pop136.customerservice.utils.BusinessException;
import com.pop136.customerservice.utils.Constants;
import com.pop136.customerservice.utils.JsonParseUtil;
import com.pop136.customerservice.utils.SessionUtil;
import com.pop136.customerservice.vo.user.UserComm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/web")
@RestController
public class LoginController extends  BaseApiAction {

  @Autowired
  private UserService userService;

  @Autowired
  private RedisService redisService;

  @RequestMapping(value = "/login",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
      method = RequestMethod.POST)
  @ResponseBody
  public String login(@RequestBody JSONObject jsonObject) throws Exception{

    Map<String, Object> result = new HashMap<>();

    String userName = JsonParseUtil.parseRequiredStringValue(jsonObject, "userName");
    String passWord = JsonParseUtil.parseRequiredStringValue(jsonObject, "password");
    // 逻辑处理
    UserComm userComm =  userService.login(userName, passWord);

    if (userComm.getUserRoleID() == null || userComm.getUserRoleID().equals("")){


      return  success("用户");
//      throw new BusinessException("用户名/密码错误,请检查");
    }

    String userToken  = SessionUtil.generateSessionId();
    String userRedis = Constants.REDIS_ACCOUNT_PREFIX + userToken;
    redisService.addObject(userRedis,userComm);

    result.put("userToken", userToken);

    return success(result);
  }

}
