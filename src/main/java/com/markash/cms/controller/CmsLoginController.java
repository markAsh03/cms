/**
 * 
 */
package com.markash.cms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markash.cms.annotation.Login;
import com.markash.cms.model.common.R;
import com.markash.cms.model.login.LoginForm;
import com.markash.cms.service.user.CmsTokenService;
import com.markash.cms.service.user.CmsUserService;
import com.markash.cms.utils.ValidatorUtil;

/**
 * @author muanan
 * 
 */
@RestController
@RequestMapping("cms")
public class CmsLoginController {
	
	@Autowired
	private CmsUserService cmsUserService;

	@Autowired
	private CmsTokenService cmsTokenService;

	/**
	 * 用户登陆
	 * @param form
	 * @return
	 */
	@PostMapping("login")
	public R login(@RequestBody LoginForm form) {
		
		// 表单数据校验
		ValidatorUtil.validateEntity(form);
		// 用户登录
		Map<String, Object> map = cmsUserService.login(form);
		// 数据封装返回
		return R.ok(map);
	}
	
	@Login
	@PostMapping("logout")
	public R logout(@RequestAttribute("userId") long userId) {
		// 退出操作
		cmsTokenService.expireToken(userId);
		return R.ok();
	}
}
