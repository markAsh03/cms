package com.markash.cms.service.user;

import com.baomidou.mybatisplus.service.IService;
import com.markash.cms.model.user.CmsTokenEntity;

public interface CmsTokenService extends IService<CmsTokenEntity> {

	/**
	 * 根据token查询
	 * 
	 * @param token
	 * @return
	 */
	CmsTokenEntity queryByToken(String token);

	/**
	 * 创建token
	 * 
	 * @param userId
	 * @return
	 */
	CmsTokenEntity createToken(String userId);

	/**
	 * 设置token过期
	 * 
	 * @param userId
	 */
	void expireToken(String userId);
}
