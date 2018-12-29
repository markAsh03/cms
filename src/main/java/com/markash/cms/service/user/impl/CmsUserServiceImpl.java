package com.markash.cms.service.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.markash.cms.dao.CmsUserDao;
import com.markash.cms.model.login.LoginForm;
import com.markash.cms.model.user.CmsTokenEntity;
import com.markash.cms.model.user.CmsUserEntity;
import com.markash.cms.service.user.CmsTokenService;
import com.markash.cms.service.user.CmsUserService;
import com.markash.cms.utils.Assert;

@Service
public class CmsUserServiceImpl extends ServiceImpl<CmsUserDao, CmsUserEntity> implements CmsUserService {

	@Autowired
	private CmsTokenService cmsTokenService;

	@Override
	public CmsUserEntity queryByMobile(String mobile) {
		CmsUserEntity userEntity = new CmsUserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	
	@Override
	public Map<String, Object> login(LoginForm form) {
		// 通过手机号查询User信息
		CmsUserEntity user = this.queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号码或密码错误");
		// 判断密码

		// 获取登陆token
		CmsTokenEntity cmsTokenEntity = cmsTokenService.createToken(user.getUserId());
		Map<String, Object> map = new HashMap<>();
		map.put("token", cmsTokenEntity.getToken());
		map.put("expire", cmsTokenEntity.getExpireTime().getTime() - System.currentTimeMillis());
		return map;
	}

}
