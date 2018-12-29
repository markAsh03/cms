/**
 * 
 */
package com.markash.cms.service.user;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.markash.cms.model.login.LoginForm;
import com.markash.cms.model.user.CmsUserEntity;

/**
 * @author muanan
 *
 */
public interface CmsUserService extends IService<CmsUserEntity>{

	/**
	 * 通过手机号查询
	 * @param mobile
	 * @return
	 */
	CmsUserEntity queryByMobile(String mobile);
	
	/**
	 * 用户登陆
	 * @param form
	 * @return
	 */
	Map<String, Object> login(LoginForm form);
}
