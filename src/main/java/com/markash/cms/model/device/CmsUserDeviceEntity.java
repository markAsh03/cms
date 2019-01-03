/**
 * 
 */
package com.markash.cms.model.device;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

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

	@TableId(type = IdType.UUID)
	private String userDeviceId;

	private String userId;

	private String deviceId;

	/**
	 * @return the userDeviceId
	 */
	public String getUserDeviceId() {
		return userDeviceId;
	}

	/**
	 * @param userDeviceId
	 *            the userDeviceId to set
	 */
	public void setUserDeviceId(String userDeviceId) {
		this.userDeviceId = userDeviceId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId
	 *            the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}
