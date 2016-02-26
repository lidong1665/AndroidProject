package com.chni.lidong.androidtestdemo.utils;

import com.chni.lidong.androidtestdemo.db.entity.Chni_User;
import com.chni.lidong.androidtestdemo.db.entity.MyProduct;
import com.squareup.okhttp.RequestBody;

import java.util.List;
import java.util.Map;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PartMap;
import retrofit.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2015/12/21.
 */
public class ApiManager {
//    private static final String ENDPOINT = "http://api.openweathermap.org/data/2.5";
//    private static final String ENDPOINT = "http://114.113.158.208:9098/shopxx";
    private static final String ENDPOINT = "http://114.113.158.209:8088";


    /**
     * 服务接口
     */
    private interface ApiManagerService {

        @GET("/weather")
        WeatherData getWeather(@Query("APPID") String AppID,@Query("q") String place, @Query("units") String units);

        /**
         * retrofit 支持 rxjava 整合
         * 这种方法适用于新接口
         */
        @GET("/weather")
        Observable<WeatherData> getWeatherData(@Query("APPID") String AppID,@Query("q") String place, @Query("units") String units);

        @GET("/product/FindGoodList2.jhtml")
        List<MyProduct> getMyProduces(@Query("pageNumber") Integer pageNumber,@Query("pageSize") String pageSize);

        @GET("/product/FindGoodList2.jhtml")
        Observable<List<MyProduct>> getMyProducesData(@Query("pageNumber") Integer pageNumber,@Query("pageSize") String pageSize);

        @FormUrlEncoded
        @POST("/cuslogin")
        Observable<Chni_User>  login (@Field("data") String data);

        @Multipart
        @POST("/check/checkin.action")
        Observable<Chni_User> checkIn(@PartMap Map<String, RequestBody> params);

    }

    private static final Retrofit sRetrofit = new Retrofit .Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .build();

    private static final ApiManagerService apiManager = sRetrofit.create(ApiManagerService.class);

    /**
     * 将服务接口返回的数据，封装成{@link rx.Observable}
     * 这种写法适用于将旧代码封装
     * @param city
     * @return
     */
    public static Observable<WeatherData> getWeatherData(final String city) {
        return Observable.create(new Observable.OnSubscribe<WeatherData>() {
            @Override
            public void call(Subscriber<? super WeatherData> subscriber) {
                //订阅者回调 onNext 和 onCompleted
                subscriber.onNext(apiManager.getWeather("ee9c42978f2e9be685994bf32b87cdc0", city, "metric"));
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io());
    }

    public static Observable<WeatherData> getWeatherData1(final String city) {
        return apiManager.getWeatherData("ee9c42978f2e9be685994bf32b87cdc0", city, "metric");
    }

    //String url = ServerConfig.URL_PATH+"/product/FindGoodList2.jhtml?pageNumber="+pageNumber+"&pageSize=10";
    public static Observable<List<MyProduct>> getMyProduces(final Integer pageNumber){
         return  apiManager.getMyProducesData(pageNumber, "10");
//        return Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                //订阅者回调 onNext 和 onCompleted
//                subscriber.onNext(apiManager.getMyProduces(pageNumber,"10"));
//                subscriber.onCompleted();
//            }
//        }).subscribeOn(Schedulers.io());
    }
    public static Observable<List<MyProduct>> getMyProduces1(final Integer pageNumber){
//        return  apiManager.getMyProduces(pageNumber,"10");
        return Observable.create(new Observable.OnSubscribe<List<MyProduct>>() {
            @Override
            public void call(Subscriber<? super List<MyProduct>> subscriber) {
                //订阅者回调 onNext 和 onCompleted
                subscriber.onNext(apiManager.getMyProduces(pageNumber, "10"));
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io());
    }


    public static Observable<Chni_User> login( final String data){
        return apiManager.login(data);
    }


}
