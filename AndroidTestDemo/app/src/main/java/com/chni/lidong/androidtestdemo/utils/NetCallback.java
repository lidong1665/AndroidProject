package com.chni.lidong.androidtestdemo.utils;

import com.android.volley.VolleyError;

/**
 * @ClassName: NetCallback
 * @Description: 请求成功回调的接口
 * @author lidong 
 * @date 2015年9月8日 上午11:09:29
 *
 */
public interface NetCallback {
	/**
	 * 请求任务成功时回调的方法
	 * @param response
	 */
	public void taskSuccess(String response);
	/**
	 * 任务出错
	 * @param error
	 */
	public void taskError(VolleyError error);
}
