package com.markash.cms.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.markash.cms.dao.CmsUserDao;
import com.markash.cms.exception.BusException;
import com.markash.cms.model.login.LoginForm;
import com.markash.cms.model.user.CmsTokenEntity;
import com.markash.cms.model.user.CmsUserEntity;
import com.markash.cms.service.user.CmsTokenService;
import com.markash.cms.service.user.CmsUserService;
import com.markash.cms.utils.Assert;
import com.markash.cms.utils.MD5Util;

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

	/**
	 * 登陆
	 */
	@Override
	public Map<String, Object> login(LoginForm form) {
		// 通过手机号查询User信息
		CmsUserEntity user = this.queryByMobile(form.getPhone());
		Assert.isNull(user, "手机号码或密码错误");
		// 判断密码
		if (!MD5Util.encoderMd5Equals(form.getPassword(), user.getPassword())) {
			throw new BusException("密码错误，请重新输入");
		}
		// 获取登陆token
		CmsTokenEntity cmsTokenEntity = cmsTokenService.createToken(user.getUserId());
		Map<String, Object> map = new HashMap<>();
		map.put("token", cmsTokenEntity.getToken());
		map.put("expire", cmsTokenEntity.getExpireTime().getTime() - System.currentTimeMillis());
		return map;
	}

	/**
	 * 注册
	 */
	@Override
	public Map<String, Object> regist(LoginForm form) {
		// 根据手机号查询用户信息
		CmsUserEntity user = this.queryByMobile(form.getPhone());
		if (null != user) {
			throw new BusException("该用户已存在");
		}

		user = new CmsUserEntity();
		user.setCreateTime(new Date());
		user.setMobile(form.getPhone());
		user.setPassword(MD5Util.encoderByMd5(form.getPassword()));
		user.setUsername("");

		// 新增用户
		this.insert(user);

		// 模拟登陆
		return this.login(form);
	}

}
