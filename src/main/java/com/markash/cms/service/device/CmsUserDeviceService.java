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
	CmsUserDeviceEntity save(CmsUserDeviceEntity cmsUserDeviceEntity);

	/**
	 * 通过UserID查询设备信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<CmsDeviceEntity> queryDeviceByUserId(String userId);
}
