package com.chni.lidong.androidtestdemo.webService;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.chni.lidong.androidtestdemo.R;
import com.chni.lidong.androidtestdemo.webService.adapter.MyAdapter;
import com.chni.lidong.androidtestdemo.webService.model.CarType;
import com.google.gson.Gson;

import org.ksoap2.serialization.SoapObject;

/**
 * 访问WebService的demo
 */
public class WebServiceDemo extends AppCompatActivity {
    //WSDL文档中的命名空间
    private static final String nameSpace = "http://www.ichehang.com/";
    //WSDL文档中的URL
    private static final String endPoint = "http://app.ichehang.com/AppService.asmx";
    //调用的方法
    private static final String methodName = "GetBrandNew";
    private RecyclerView recyclerView;
    private CarType carType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        SoapObject data = WebServiceUtil.getData(endPoint, nameSpace, methodName);
        Log.d("WebServiceDemo",data.getPropertyCount()+"      "+data.getProperty(0) + "");
        parseData( data);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // 设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyAdapter(carType));
    }

    private void parseData(SoapObject data) {
         carType = new Gson().fromJson(data.getProperty(0).toString(), CarType.class);
    }
}
