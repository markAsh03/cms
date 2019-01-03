/**
 * 
 */
package com.markash.cms.service.device.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.markash.cms.dao.CmsDeviceDao;
import com.markash.cms.model.device.CmsDeviceEntity;
import com.markash.cms.service.device.CmsDeviceService;

/**
 * @author muanan
 *
 */
@Service
public class CmsDeviceServiceImpl extends ServiceImpl<CmsDeviceDao, CmsDeviceEntity> implements CmsDeviceService {

	/**
	 * 保存
	 */
	@Override
	public CmsDeviceEntity save(CmsDeviceEntity deviceEntity) {
		this.insert(deviceEntity);
		return deviceEntity;
	}

	@Override
	public CmsDeviceEntity queryByDeviceId(String deviceId) {
		return this.selectById(deviceId);
	}

	@Override
	public CmsDeviceEntity queryByDeviceToken(String deviceToken) {
		return this.selectOne(new EntityWrapper<CmsDeviceEntity>().eq("device_Token", deviceToken));
	}
}
