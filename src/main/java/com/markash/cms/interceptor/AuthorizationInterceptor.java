/**
 * 
 */
package com.markash.cms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.markash.cms.annotation.Login;
import com.markash.cms.exception.BusException;
import com.markash.cms.model.user.CmsTokenEntity;
import com.markash.cms.service.user.CmsTokenService;
import com.markash.cms.utils.Assert;

/**
 * 权限认证
 * 
 * @author muanan
 *
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private CmsTokenService cmsTokenService;

	public static final String USER_KEY = "userId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Login login = null;
		if (handler instanceof HandlerMethod) {
			login = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
		} else {
			return true;
		}

		if (null == login) {
			return true;
		}

		// 从header中获取token
		String token = request.getHeader("token");
		if (StringUtils.isBlank(token)) {
			token = request.getParameter("token");
		}

		Assert.isBlank(token, "token不能为空");

		CmsTokenEntity tokenEntity = cmsTokenService.queryByToken(token);
		if (null == tokenEntity || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
			throw new BusException("token失效,请重新登陆", 401);
		}

		// 设置UserID到request中，根据user ID获取用户信息
		request.setAttribute(USER_KEY, tokenEntity.getUserId());

		return true;
	}
}
