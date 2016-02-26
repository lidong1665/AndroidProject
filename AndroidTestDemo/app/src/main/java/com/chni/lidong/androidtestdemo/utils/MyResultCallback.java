package com.chni.lidong.androidtestdemo.utils;

import com.squareup.okhttp.Request;

/**
 * Created by Chen on 2015/10/28.
 */
public abstract class MyResultCallback<T> extends OkHttpClientManager.ResultCallback<T>
{

    @Override
    public void onBefore(Request request)
    {
        super.onBefore(request);

    }

    @Override
    public void onAfter()
    {
        super.onAfter();
    }
}