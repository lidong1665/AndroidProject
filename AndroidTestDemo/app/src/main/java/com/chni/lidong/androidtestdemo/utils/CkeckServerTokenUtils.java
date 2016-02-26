package com.chni.lidong.androidtestdemo.utils;

import java.util.Map;

import static com.chni.lidong.androidtestdemo.utils.MD5Utils.MD5s;

public class CkeckServerTokenUtils {
	
	public static void handleServerCheck(Map<String, String> paramsMap) {
		String t = SystemAttrUtlis.getPostTimeNow();
		String s = "0010000app";
		paramsMap.put("time", t);
		paramsMap.put("ko", "0000");
		paramsMap.put("token", MD5s(t + s));
		System.out.println(paramsMap.toString());
	}
}
