package com.chni.lidong.androidtestdemo.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.format.Time;

import java.text.SimpleDateFormat;

/**
 * 获得系统的基本属性
 * @author zty
 *
 */
public class SystemAttrUtlis {
		// 获取系统当前时间
		@SuppressLint("SimpleDateFormat")
		public static String[] getSystemTimeNow() {
			String[] str = new String[2];
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			str[0] = formatter.format(System.currentTimeMillis()).substring(0, 10);
			str[1] = formatter.format(System.currentTimeMillis()).substring(11, 19);
			return str;
		}
		/**
		 * 获取当前时间 TODO delete
		 * @return
		 */
		public static String getTimeNow() {
			String str = null;
			Time t = new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料。
			t.setToNow(); // 取得系统时间。
			int year = t.year;
			int month = t.month + 1;
			String m = month < 10 ? "0" + month : "" + month;
			int date = t.monthDay;
			String d = date < 10 ? "0" + date : "" + date;
			int hour = t.hour; // 0-23
			String h = hour < 10 ? "0" + hour : "" + hour;
			int minute = t.minute;
			String min = minute < 10 ? "0" + minute : "" + minute;
			int second = t.second;
			String s = second < 10 ? "0" + second : "" + second;
			str = year + "-" + m + "-" + d + "%20" + h + ":" + min + ":" + s;
			return str;
		}
		
		@SuppressLint("SimpleDateFormat")
		public static String getPostTimeNow() {
			String str = null;
			Time t = new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料。
			t.setToNow(); // 取得系统时间。
			int year = t.year;
			int month = t.month + 1;
			String m = month < 10 ? "0" + month : "" + month;
			int date = t.monthDay;
			String d = date < 10 ? "0" + date : "" + date;
			int hour = t.hour; // 0-23
			String h = hour < 10 ? "0" + hour : "" + hour;
			int minute = t.minute;
			String min = minute < 10 ? "0" + minute : "" + minute;
			int second = t.second;
			String s = second < 10 ? "0" + second : "" + second;
			str = year + "-" + m + "-" + d + " " + h + ":" + min + ":" + s;
			return str;
		}
		
		/**
		 * TODO delete
		 * @param act
		 * @return
		 */
		public int GetLocalhostVersion(Activity act) {
			int version = -1;
			try {
				// get ths versionCode from mainfext.xml
				PackageInfo info = act.getApplicationContext().getPackageManager().getPackageInfo(act.getApplicationContext().getPackageName(), 0);
				version = info.versionCode;
			} catch (NameNotFoundException e) {
				e.printStackTrace();
				return -1;
			}
			return version;
		}
		
}
