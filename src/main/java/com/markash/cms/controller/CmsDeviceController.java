/**
 * 
 */
package com.markash.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.markash.cms.annotation.Login;
import com.markash.cms.model.device.CmsUserDeviceEntity;
import com.markash.cms.service.device.CmsUserDeviceService;

/**
 * 
 * @author muanan
 *
 */
@RestController
@RequestMapping("device")
public class CmsDeviceController {

	private static Logger logger = LoggerFactory.getLogger(CmsDeviceController.class);

	@Autowired
	private CmsUserDeviceService cmsUserDeviceService;

	@Login
	@RequestMapping(value = "getuserdevice", method = RequestMethod.POST)
	public void getUserDeviceToken(@RequestBody CmsUserDeviceEntity cmsUserDeviceEntity) {

		logger.info("获取APP的设备信息, 入参={}。", cmsUserDeviceEntity);
		cmsUserDeviceService.saveOrUpdateUserDevice(cmsUserDeviceEntity);
	}
}
