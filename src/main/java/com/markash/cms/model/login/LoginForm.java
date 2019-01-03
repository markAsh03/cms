/**
 * 
 */
package com.markash.cms.model.login;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

/**
 * @author muanan
 *
 */
public class LoginForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5833521925735712021L;

	// 手机号码
	@NotBlank(message = "手机号码不能为空")
	private String phone;
	// 密码
	@NotBlank(message = "密码不能为空")
	private String password;
	// 设备ID
	private String deviceId;
	// 省
	private String province;
	// 市
	private String city;
	// 区
	private String district;
	// 
	private String locationLat;
	//
	private String locationLon;
	// 客户端类型
	private String client;
	
	private String vcode;

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the locationLat
	 */
	public String getLocationLat() {
		return locationLat;
	}

	/**
	 * @param locationLat the locationLat to set
	 */
	public void setLocationLat(String locationLat) {
		this.locationLat = locationLat;
	}

	/**
	 * @return the locationLon
	 */
	public String getLocationLon() {
		return locationLon;
	}

	/**
	 * @param locationLon the locationLon to set
	 */
	public void setLocationLon(String locationLon) {
		this.locationLon = locationLon;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the vcode
	 */
	public String getVcode() {
		return vcode;
	}

	/**
	 * @param vcode the vcode to set
	 */
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
	
}
