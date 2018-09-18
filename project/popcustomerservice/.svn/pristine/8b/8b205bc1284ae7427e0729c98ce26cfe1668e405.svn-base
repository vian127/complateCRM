package com.pop136.customerservice.config;

import com.pop136.customerservice.utils.UserSecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class UserAppConfig extends WebMvcConfigurationSupport {

	/**
	 * 配置拦截器
	 * 
	 * @author lance
	 * @param registry
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/**");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(
				// "/webjars/**",
				"/img/**", "/images/**", "/css/**", "/js/**", "/fonts/**").addResourceLocations(
						// "classpath:/META-INF/resources/webjars/",
						"classpath:/static/img/", "classpath:/static/images/", "classpath:/static/css/",
						"classpath:/static/js/", "classpath:/static/fonts/");
	}

	/**
	 * 添加 cros跨域 配置
	 * @param registry
	 */
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowCredentials(true)
//				.allowedMethods("GET", "POST", "DELETE", "PUT")
				.allowedMethods("*")
				.maxAge(3600);
	}

}
