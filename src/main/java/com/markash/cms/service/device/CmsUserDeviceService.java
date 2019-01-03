/**
 * 
 */
package com.markash.cms.service.device;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.markash.cms.model.device.CmsDeviceEntity;
import com.markash.cms.model.device.CmsUserDeviceEntity;

/**
 * @author muanan
 *
 */
public interface CmsUserDeviceService extends IService<CmsUserDeviceEntity> {

	/**
	 * 保存
	 * 
	 * @param cmsUserDeviceEntity
	 * @return
	 */
	CmsUserDeviceEntity saveOrUpdate(CmsUserDeviceEntity cmsUserDeviceEntity);

	/**
	 * 通过UserID查询设备信息
	 * 
	 * @param userId
	 * @return
	 */
	List<CmsDeviceEntity> queryDeviceByUserId(String userId);

	/**
	 * 保存或更新用户设备信息
	 * 
	 * @param requstParams
	 */
	void saveOrUpdateUserDevice(CmsUserDeviceEntity cmsUserDeviceEntity);

	/**
	 * 查询用户设备关系
	 * 
	 * @param userId
	 * @return
	 */
	CmsUserDeviceEntity queryUserDeviceRelation(String userId);
}
