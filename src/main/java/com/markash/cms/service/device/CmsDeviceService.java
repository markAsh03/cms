package com.markash.cms.service.device;

import com.baomidou.mybatisplus.service.IService;
import com.markash.cms.model.device.CmsDeviceEntity;

public interface CmsDeviceService extends IService<CmsDeviceEntity> {

	/**
	 * 设备信息保存
	 * 
	 * @param deviceEntity
	 * @return
	 */
	public CmsDeviceEntity save(CmsDeviceEntity deviceEntity);

	/**
	 * 通过设备ID查询设备信息
	 * 
	 * @param deviceId
	 * @return
	 */
	public CmsDeviceEntity queryByDeviceId(String deviceId);

	/**
	 * 通过设备Token查询设备信息
	 * 
	 * @param deviceToken
	 * @return
	 */
	public CmsDeviceEntity queryByDeviceToken(String deviceToken);
}
