/**
 * 
 */
package com.markash.cms.service.device.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.markash.cms.dao.CmsDeviceDao;
import com.markash.cms.model.device.CmsDeviceEntity;
import com.markash.cms.service.device.CmsDeviceService;

/**
 * @author muanan
 *
 */
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
	public CmsDeviceEntity queryByDeviceId(Long deviceId) {
		return this.selectById(deviceId);
	}
}
