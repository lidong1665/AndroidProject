package com.chni.lidong.androidtestdemo.utils;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Administrator
 *
 */
public class MD5Utils {
	/**
	 * MD5加密  加密错误 返回‘0001’
	 * @param plainText 需要加密的字符
	 * @return
	 */
	public static String MD5s(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			return "0001";
		}
	}

	// Post请求时，对校验码进行MD5加密
	public static String RequestPostCodes(String time, String sysCode) {
		String str = null;
		String c = "0000";
		if ("0001".equals(MD5s(time + sysCode)))
			return null;
		str = ",\"time\":\"" + time + "\",\"ko\":\"" + c + "\",\"token\":\"" + MD5s(time + sysCode) + "\"}";
		return str;
		
		
	}

	// Get请求时，对校验码进行MD5加密
	public static String RequestGetCodes(String time, String sysCode) {
		String str = null;
		String c = "0000";
		if ("0001".equals(MD5s(time + sysCode)))
			return null;
		str = "&time=" + time + "&ko=" + c + "&token=" + MD5s(SystemAttrUtlis.getPostTimeNow() + sysCode);
		return str;
	}

	// 获取系统当前时间

	

	

}
