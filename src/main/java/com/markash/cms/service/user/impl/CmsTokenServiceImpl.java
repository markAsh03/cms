package com.markash.cms.service.user.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.markash.cms.dao.CmsTokenDao;
import com.markash.cms.model.user.CmsTokenEntity;
import com.markash.cms.service.user.CmsTokenService;

@Service
public class CmsTokenServiceImpl extends ServiceImpl<CmsTokenDao, CmsTokenEntity> implements CmsTokenService {

	// 过期时间
	private static final long EXPIRE = 60 * 60 * 1000;

	@Override
	public CmsTokenEntity queryByToken(String token) {
		return this.selectOne(new EntityWrapper<CmsTokenEntity>().eq("token", token));
	}

	@Override
	public CmsTokenEntity createToken(long userId) {
		Date now = new Date();
		// 过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE);
		String token = this.generateToken();
		// 保存或更新token
		CmsTokenEntity tokenEntity = new CmsTokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		tokenEntity.setUpdateTime(now);
		tokenEntity.setExpireTime(expireTime);
		this.insertOrUpdate(tokenEntity);
		return tokenEntity;
	}

	/**
	 * 获取随机数token
	 * 
	 * @return
	 */
	private String generateToken() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	@Override
	public void expireToken(long userId) {
		Date now = new Date();
		CmsTokenEntity tokenEntity = new CmsTokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setExpireTime(now);
		tokenEntity.setUpdateTime(now);
		this.insertOrUpdate(tokenEntity);
	}

}
