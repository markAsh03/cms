/**
 * 
 */
package com.markash.cms.service.device.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.markash.cms.dao.CmsUserDeviceDao;
import com.markash.cms.model.device.CmsDeviceEntity;
import com.markash.cms.model.device.CmsUserDeviceEntity;
import com.markash.cms.service.device.CmsDeviceService;
import com.markash.cms.service.device.CmsUserDeviceService;

/**
 * @author muanan
 *
 */
public class CmsUserDeviceServiceImpl extends ServiceImpl<CmsUserDeviceDao, CmsUserDeviceEntity>
		implements CmsUserDeviceService {

	@Autowired
	CmsDeviceService cmsDeviceService;

	/**
	 * 保存
	 */
	@Override
	public CmsUserDeviceEntity save(CmsUserDeviceEntity cmsUserDeviceEntity) {
		this.insert(cmsUserDeviceEntity);
		return cmsUserDeviceEntity;
	}

	/**
	 * 通过UserID查询设备信息
	 */
	@Override
	public List<CmsDeviceEntity> queryDeviceByUserId(String userId) {
		List<CmsUserDeviceEntity> userDeviceList = this
				.selectList(new EntityWrapper<CmsUserDeviceEntity>().eq("userId", userId));
		List<CmsDeviceEntity> deviceList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(userDeviceList)) {
			for (CmsUserDeviceEntity cmsUserDeviceEntity : userDeviceList) {
				deviceList.add(cmsDeviceService.queryByDeviceId(cmsUserDeviceEntity.getDeviceId()));
			}
		}
		return deviceList;
	}

}
