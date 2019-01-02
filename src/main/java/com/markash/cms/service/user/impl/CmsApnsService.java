package com.markash.cms.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;

/**
 * APNS消息推送
 * @author muanan
 *
 */
@Component
public class CmsApnsService {

	Logger logger = LoggerFactory.getLogger(CmsApnsService.class);

	// 证书路径
	private static final String CERTIFICATE_PATH = ".p12";
	// 证书密码
	private static final String CERTIFICATE_PASSWORD = "123456";

	public static void main(String[] args) {

		// 设置连接
		ApnsService service = APNS.newService().withCert("", "").withSandboxDestination().build();

		// 创建并发消息
		String body = "Can't be simple than this.";
		String payload = APNS.newPayload().alertBody(body).build();
		String token = "fsadfsaf";

		service.push(token, payload);

	}

	/**
	 * 
	 * @param deviceTokens
	 *            -- 设备的Token值
	 * @param alertMsg
	 *            -- push的内容
	 * @param badge
	 *            -- 图标小红圈的数值
	 */
	public void pushNotificationMsg(List<String> deviceTokens, String alertMsg, int badge) {
		// 铃音
		String sound = "default";

		boolean sendCount = deviceTokens.size() > 1;

		try {
			PushNotificationPayload payload = new PushNotificationPayload();
			// 消息内容
			payload.addAlert(alertMsg);
			payload.addBadge(badge);
			if (StringUtils.isNotBlank(sound)) {
				payload.addSound(sound);
			}

			PushNotificationManager pushManager = new PushNotificationManager();
			// true 标识产品发布推送服务， false 标识产品测试推送服务
			pushManager
					.initializeConnection(
							new AppleNotificationServerBasicImpl(CERTIFICATE_PATH, CERTIFICATE_PASSWORD, false));

			List<PushedNotification> notifications = new ArrayList<>();

			// 发送
			if (sendCount) {
				Device device = new BasicDevice();
				device.setToken(deviceTokens.get(0));

				PushedNotification notification = pushManager.sendNotification(device, payload, true);

				notifications.add(notification);
			} else {
				List<Device> devices = new ArrayList<>();
				for (String token : deviceTokens) {
					devices.add(new BasicDevice(token));
				}

				notifications = pushManager.sendNotifications(payload, devices);
			}

			List<PushedNotification> failedNotifications = PushedNotification.findFailedNotifications(notifications);
			List<PushedNotification> successNotifications = PushedNotification
					.findSuccessfulNotifications(notifications);

			int failed = failedNotifications.size();
			int success = successNotifications.size();
			logger.info("消息推送：失败={}， 成功={}。", failed, success);

			pushManager.stopConnection();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}
}
