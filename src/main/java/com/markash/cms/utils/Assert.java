/**
 * 
 */
package com.markash.cms.utils;

import org.apache.commons.lang.StringUtils;

import com.markash.cms.exception.BusException;

/**
 * 数据校验
 * 
 * @author muanan
 *
 */
public abstract class Assert {

	public static void isBlank(String str, String msg) {
		if (StringUtils.isBlank(str)) {
			throw new BusException(msg);
		}
	}

	public static void isNull(Object obj, String msg) {
		if (null == obj) {
			throw new BusException(msg);
		}
	}
}
