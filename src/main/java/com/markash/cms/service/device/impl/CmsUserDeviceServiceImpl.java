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

	@Autowired
	CmsUserDeviceService cmsUserDeviceService;

	/**
	 * 保存
	 */
	@Override
	public CmsUserDeviceEntity saveOrUpdate(CmsUserDeviceEntity cmsUserDeviceEntity) {
		this.insertOrUpdate(cmsUserDeviceEntity);
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

	/**
	 * 根据用户查询用户设备
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public CmsUserDeviceEntity queryUserDeviceRelation(String userId) {
		return this.selectOne(new EntityWrapper<CmsUserDeviceEntity>().eq("userId", userId));
	}

	/**
	 * 保存或更新用户设备信息
	 */
	@Override
	public void saveOrUpdateUserDevice(CmsUserDeviceEntity cmsUserDeviceEntity) {
		// 设备Token
		String deviceToken = cmsUserDeviceEntity.getDeviceId();
		CmsDeviceEntity cmsDeviceEntity = cmsDeviceService.queryByDeviceToken(deviceToken);
		if (null == cmsDeviceEntity) {
			cmsDeviceEntity = new CmsDeviceEntity();
			cmsDeviceEntity.setDeviceToken(deviceToken);
			cmsDeviceEntity = cmsDeviceService.save(cmsDeviceEntity);
		}
		// 用户ID
		String userId = cmsUserDeviceEntity.getUserId();

		// 查询用户设备关系
		cmsUserDeviceEntity = cmsUserDeviceService.queryUserDeviceRelation(userId);

		cmsUserDeviceEntity.setDeviceId(cmsDeviceEntity.getDeviceId());
		cmsUserDeviceEntity.setUserId(userId);
		cmsUserDeviceService.saveOrUpdate(cmsUserDeviceEntity);
	}

}
