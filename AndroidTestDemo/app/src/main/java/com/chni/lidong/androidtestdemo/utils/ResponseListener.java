package com.chni.lidong.androidtestdemo.utils;

import com.android.volley.Response;

/**
 * Created by lidong on 2015/2/28.
 */
public interface ResponseListener<T> extends Response.Listener<T>,Response.ErrorListener {

}
