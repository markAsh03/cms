package com.markash.cms.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

/**
 * MD5
 * 
 * @author muanan
 *
 */
public class MD5Util {

	/**
	 * MD5 加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encoderByMd5(String str) {
		Assert.isBlank(str, "参数不能为空");
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return Base64.encodeBase64String(md5.digest(str.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 原始值和加密后的值比较
	 * 
	 * @param original
	 * @param afterStr
	 * @return
	 */
	public static boolean encoderMd5Equals(String original, String afterStr) {
		return MD5Util.encoderByMd5(original).equals(afterStr);
	}
}
