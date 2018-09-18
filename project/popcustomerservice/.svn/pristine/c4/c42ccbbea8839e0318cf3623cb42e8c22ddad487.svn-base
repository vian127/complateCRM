package com.pop136.customerservice.controller.web;

//import com.sun.xml.internal.rngom.ast.builder.CommentList;
import com.alibaba.fastjson.JSONObject;
import com.pop136.customerservice.controller.BaseApiAction;
import com.pop136.customerservice.service.common.RedisService;
import com.pop136.customerservice.service.user.UserService;
import com.pop136.customerservice.utils.BusinessException;
import com.pop136.customerservice.utils.Constants;
import com.pop136.customerservice.utils.JsonParseUtil;
import com.pop136.customerservice.utils.SessionUtil;
import com.pop136.customerservice.vo.user.UserComm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller // 标记为：jsp
public class WebController extends BaseApiAction {

	@Autowired
	private UserService userService;

	@Autowired
	private RedisService redisService;

	/*
	 * @RequestMapping("/html") public String html(){ return "/huodong.html"; }
	 */

	@GetMapping("/templates")
	public String test(HashMap<String, Object> map) {
		// 逻辑处理
		map.put("hello", "欢迎进入HTML页面");
		return "index";
	}

	@GetMapping("/{page}")
	public String remove(@PathVariable("page")String page) {
		// 逻辑处理
		return "/"+page;
	}

	@GetMapping("/web/{views}/{page}")
	public String client( @PathVariable("views")String views, @PathVariable("page")String page) {
		// 逻辑处理
		return "views/"+views+"/"+page;
	}

	@GetMapping("/templates/material")
	public String material(ModelMap map, @RequestParam("productId") String productId,
			@RequestParam("accountId") String accountId) throws IOException {
		return "material/material";
	}

	/*
	 * @RequestMapping("/html") public String html(){ return "/huodong.html"; }
	 */

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

		if (userComm == null || userComm.getUserRoleID() == null ) {

			return error(402, "用户或者密码错误", null);
		}

		String userToken  = SessionUtil.generateSessionId();
		String userRedis = Constants.REDIS_ACCOUNT_PREFIX + userToken;
		redisService.addObject(userRedis,userComm);

		result.put("userToken", userToken);
		result.put("userName", userComm.getUserName());

		return success(result);
	}

	@RequestMapping(value = "/login/out",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			method = RequestMethod.POST)
	@ResponseBody
	public String loginOut(HttpServletRequest request) throws Exception{

		String token = request.getHeader("userToken");

		if (token == null || token.equals("")){
			throw new BusinessException("参数校验异常");
		}

		String userRedis = Constants.REDIS_ACCOUNT_PREFIX + token;
		redisService.remove(userRedis);

		return success(null);
	}


	@GetMapping("/index")
	public String index(HashMap<String, Object> map) {
		// 逻辑处理
		map.put("index", "欢迎进入HTML页面");
		return "login";
	}

	@GetMapping("/welcome")
	public String welcome(HashMap<String, Object> map) {
		// 逻辑处理
		map.put("welcome", "欢迎进入HTML页面");
		return "welcome";
	}

	@GetMapping("/")
	public String first(HashMap<String, Object> map) {
		return "login";
	}

}
