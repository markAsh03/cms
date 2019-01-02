/**
 * 
 */
package com.markash.cms.model.device;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author muanan
 *
 */
@TableName("tb_user_device")
public class CmsUserDeviceEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 662473459694617772L;

	@TableId
	private Long userDeviceId;

	private Long userId;

	private Long deviceId;

	/**
	 * @return the userDeviceId
	 */
	public Long getUserDeviceId() {
		return userDeviceId;
	}

	/**
	 * @param userDeviceId
	 *            the userDeviceId to set
	 */
	public void setUserDeviceId(Long userDeviceId) {
		this.userDeviceId = userDeviceId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the deviceId
	 */
	public Long getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId
	 *            the deviceId to set
	 */
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

}
