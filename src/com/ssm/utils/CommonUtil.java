package com.ssm.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.format.datetime.DateFormatter;

public class CommonUtil {
	/**
	 * Determine whether the object is empty
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object) {
		return object == null ? true : false;
	}

	/**
	 * Determine whether the collection is empty or null
	 * 
	 * @param collection
	 * @return
	 */
	public static boolean isNullOrEmpty(Collection collection) {
		return null == collection || 0 == collection.size() ? true : false;
	}

	/**
	 * Determine whether the map is empty or null
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isNullOrEmpty(Map map) {
		return null == map || 0 == map.size() ? true : false;
	}

	/**
	 * Determine whether the object array is empty or null
	 * 
	 * @param objects
	 * @return
	 */
	public static boolean isNullOrEmpty(Object[] objects) {
		return null == objects || 0 == objects.length ? true : false;
	}

	/**
	 * Determine whether the string is empty or null
	 * 
	 * @param subject
	 * @return
	 */
	public static boolean isNullOrEmpty(String subject) {
		return subject == null || "".equals(subject) ? true : false;
	}

	/**
	 * Determine whether the byte array is empty or null
	 * 
	 * @param bt
	 * @return
	 */
	public static boolean isNullOrEmpty(byte[] bt) {
		return bt == null || bt.length == 0 ? true : false;
	}

	/**
	 * generate UUID
	 */
	public static String generateUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}

	/**
	 * get Current Time
	 */
	public static Date getCurrentTime() {
		return new Date();
	}

	/**
	 * get Current Time like HH:mm:ss
	 */
	public static String getCurentTimeHHmmss() {
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(getCurrentTime());
	}
	
	/**
	 * bigDecimal To String
	 */
	public static String bigDecimalToString(BigDecimal curBigDecimal){
		return curBigDecimal.toString();
	}
	
	public static Date formateToDate(String dateStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date result = null;
		try {
			result = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	/**
	 * 生成随机密码
	 */
	private static int getRandom(int count){
		return (int) Math.round(Math.random() * (count));
	}

	private static String string = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String getRandomString(int length) {
		StringBuffer sb = new StringBuffer();
		int len = string.length();
		for (int i = 0; i < length; i++) {
			sb.append(string.charAt(getRandom(len - 1)));
		}
		return sb.toString();
	}
}
