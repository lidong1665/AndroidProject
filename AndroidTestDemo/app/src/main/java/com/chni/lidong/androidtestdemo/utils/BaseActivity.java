package com.chni.lidong.androidtestdemo.utils;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ld on 2015/10/28.
 */
public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public  void showSnackbar(View view,String text){
        Snackbar.make(view,text,Snackbar.LENGTH_SHORT).show();
    }
}
