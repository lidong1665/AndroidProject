package com.chni.lidong.androidtestdemo.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:HttpUtil
 * @author ld
 * @date 2015年9月10日 
 */
public class HttpUtil {
	
	private static RequestQueue mRequestQueue;
	/**
	 * 初始化VolleyRequestQueue
	 * 
	 * @param ctx
	 *            上下文
	 */
	public static void initVolleyRequestQueue(Context ctx) {
		mRequestQueue = Volley.newRequestQueue(ctx);
	}

	/**
	 * 
	 * 关闭VolleyRequest的请求
	 * 
	 * @param ctx
	 *            上下文
	 */
	public static void cancelAllVolleyRequestQueue(Context ctx) {
		mRequestQueue.cancelAll(ctx);
	}


	/**
	 * 发送VolleyPost请求（hms）
	 * @param url
	 * @param params
	 * @param listener
	 * @return
	 */
	public static boolean sendVolleyPostRequest1(String url, Map<String, String> params ,ResponseListener<String> listener) {
		mRequestQueue.start();
		boolean flag = false;
		PostRequest sr = null;
		Map<String, String> params1 = new HashMap<String, String>();
		try {
			CkeckServerTokenUtils.handleServerCheck(params);
		JSONObject jsonObject1 = new JSONObject(params);
		params1.put("data", jsonObject1.toString());
		Log.v("zgy", params1.toString());
			sr = new PostRequest(url, params1, listener);
			sr.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
			mRequestQueue.add(sr);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
}
