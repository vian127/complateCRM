package com.pop136.customerservice.filter;

import com.pop136.customerservice.service.common.RedisService;
import com.pop136.customerservice.utils.Constants;
import com.pop136.customerservice.utils.StringUtil;
import com.pop136.customerservice.utils.UserLocal;
import com.pop136.customerservice.vo.user.UserComm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter(urlPatterns = "/app/*")
@Order(value = 1)
@Configuration
public class UserFilter implements Filter {

    @Autowired
    private RedisService redisService;

    private static final Set<String> NOT_ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("/welcome","/msg", "/feedBack", "/customer", "/contact", "/msgTemplate")));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init-----------filter");
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String ori_path = "";
        String path = "";
        ori_path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");

        boolean allowedPath = NOT_ALLOWED_PATHS.contains(ori_path);

        String[] path_array = ori_path.split("/");
        if (path_array.length > 1 && !allowedPath) {
            path = "/" + path_array[1];
        }
        allowedPath = NOT_ALLOWED_PATHS.contains(path);

        if (!allowedPath) {
            System.out.println("这里是不需要处理的url进入的方法");
            chain.doFilter(req, res);
        } else {
            String app = request.getHeader("app");
            String userRedis = "";
            if (!StringUtil.checkString(app).equals("")) {
                // app登录
                String usertoken = request.getHeader("userToken");
                userRedis = Constants.REDIS_ACCOUNT_PREFIX + StringUtil.checkString(usertoken);
            } else {
                // weixin登录
                String usertoken = request.getHeader("userToken");
                userRedis = Constants.REDIS_ACCOUNT_PREFIX + StringUtil.checkString(usertoken);
                // account = (U031) SessionUtil.getCache(StringUtil.checkString(usertoken),
                // account);
            }
            UserComm userComm = (UserComm) redisService.getObject(userRedis);
            if (userComm != null) {
                UserLocal.set(userComm);
            } else {
                response.sendRedirect(request.getContextPath() + "/index");
            }
            System.out.println("这里是需要处理的url进入的方法");
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy----------filter");
    }
}