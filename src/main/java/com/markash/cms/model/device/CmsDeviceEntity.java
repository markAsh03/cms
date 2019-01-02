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
@TableName("tb_device")
public class CmsDeviceEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2412283525807859298L;

	@TableId(type = IdType.INPUT)
	private Long deviceId;

	private String deviceToken;

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

	/**
	 * @return the deviceToken
	 */
	public String getDeviceToken() {
		return deviceToken;
	}

	/**
	 * @param deviceToken
	 *            the deviceToken to set
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

}
