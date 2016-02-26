package com.chni.lidong.androidtestdemo.swiperefreshlistfragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chni.lidong.androidtestdemo.R;
import com.chni.lidong.androidtestdemo.db.entity.Chni_User;
import com.chni.lidong.androidtestdemo.utils.ApiManager;
import com.chni.lidong.androidtestdemo.utils.CkeckServerTokenUtils;
import com.chni.lidong.androidtestdemo.utils.SystemAttrUtlis;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static com.chni.lidong.androidtestdemo.utils.MD5Utils.MD5s;

public class RxJavaDemo extends AppCompatActivity {

    private static final String LOG_TAG = "RxJavaDemo";
    private static final String[] CITIES = {"Budapest,hu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_demo2);
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
        initView();
    }

    private void initView() {
        findViewById(R.id.tv_demo);
        /**
         * 多个 city 请求
         * map，flatMap 对 Observable进行变换
         */
//        Observable.from(CITIES).flatMap(new Func1<String, Observable<WeatherData>>() {
//            @Override
//            public Observable<WeatherData> call(String s) {
//                return ApiManager.getWeatherData(s);
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(/*onNext*/new Action1<WeatherData>() {
//                    @Override
//                    public void call(WeatherData weatherData) {
//                        Log.d(LOG_TAG, weatherData.toString());
//                    }
//                }, /*onError*/new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//
//                    }
//                });

        /**
         * 单个 city 请求
         */
//        ApiManager.getWeatherData(CITIES[0]).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<WeatherData>() {
//                    @Override
//                    public void call(WeatherData weatherData) {
//                        Log.d(LOG_TAG, weatherData.toString());
//                        ((TextView) findViewById(R.id.tv_demo)).setText(weatherData.toString());
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Log.e(LOG_TAG, throwable.getMessage(), throwable);
//                    }
//                });
//        ApiManager.getWeatherData1(CITIES[0]).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<WeatherData>() {
//                    @Override
//                    public void call(WeatherData weatherData) {
//                        Log.d(LOG_TAG, weatherData.toString());
//                        ((TextView) findViewById(R.id.tv_demo1)).setText(weatherData.toString());
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Log.e(LOG_TAG, throwable.getMessage(), throwable);
//                    }
//                });

//        ApiManager.getMyProduces(1).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<List<MyProduct>>() {
//                    @Override
//                    public void call(List<MyProduct> weatherData) {
////                        Log.d(LOG_TAG, weatherData.toString());
//                        ((TextView) findViewById(R.id.tv_demo1)).setText(weatherData.size()+"");
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Log.e(LOG_TAG, throwable.getMessage(), throwable);
//                    }
//                });
//        ApiManager.getMyProduces(1).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<List<MyProduct>>() {
//                    @Override
//                    public void call(List<MyProduct> weatherData) {
////                        Log.d(LOG_TAG, weatherData.toString());
//                        ((TextView) findViewById(R.id.tv_demo)).setText(weatherData.toArray().toString());
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Log.e(LOG_TAG, throwable.getMessage(), throwable);
//                    }
//                });
        String t = SystemAttrUtlis.getPostTimeNow();
        String s = "0010000app";
        String ko = "0000";
        String time = t;
        String token = MD5s(t + s);
        String data = "";
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", "lidong");
        params.put("password", "325106");
        params.put("orgid", "0010000");
        CkeckServerTokenUtils.handleServerCheck(params);
        final Map<String, String> params1 = new HashMap<String, String>();
        JSONObject jsonObject1 = new  JSONObject(params);
        data=jsonObject1.toString();
        Log.v("zgy", data);
        ApiManager.login(data).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Chni_User>() {
                    @Override
                    public void call(Chni_User ss) {
//                        Log.d(LOG_TAG, weatherData.toString());
                        ((TextView) findViewById(R.id.tv_demo)).setText(ss.getCustomerid());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(LOG_TAG, throwable.getMessage(), throwable);
                    }
                });
    }


}
