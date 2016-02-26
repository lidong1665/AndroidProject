package com.chni.lidong.androidtestdemo.upload;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;

/**
 * Created by Administrator on 2016/1/28.
 */
public class FileUploadManager {

    private static final String ENDPOINT = "http://192.168.1.122:8080";

    public interface FileUploadService {
        /**
         * 上传一张图片
         * @param description
         * @param imgs
         * @return
         */
        @Multipart
        @POST("/upload")
        Call<String> uploadImage(@Part("fileName") String description,
                                 @Part("file\"; filename=\"image.png\"")RequestBody imgs);

        /**
         * 上传三张图片
         * @param description
         * @param imgs
         * @param imgs1
         * @param imgs3
         * @return
         */
        @Multipart
        @POST("/upload")
        Call<String> uploadImage(@Part("fileName") String description,
                                 @Part("file\"; filename=\"image.png\"")RequestBody imgs,
                                 @Part("file\"; filename=\"image.png\"")RequestBody imgs1,
                                 @Part("file\"; filename=\"image.png\"")RequestBody imgs3);
    }



    private static final Retrofit sRetrofit = new Retrofit .Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .build();

    private static final FileUploadService apiManager = sRetrofit.create(FileUploadService.class);




    public static void upload(String path){

        String descriptionString = "hello, this is description speaking";

        String[] m = new String[2];
        m[0]= "share.png";
        m[1]=  "Screenshot_20160128-140709.png";
        File[]  ssssss= new  File[2];
        File file1 = new File("/storage/emulated/0/sc/share.png");
        File file = new File("/storage/emulated/0/Pictures/ScreenShots/Screenshot_20160128-140709.png");
        ssssss[0]=file;
        ssssss[0]=file1;
        RequestBody requestBody[] = new RequestBody[3];
        RequestBody requestBody1 =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);
        RequestBody requestBody2 =
                RequestBody.create(MediaType.parse("multipart/form-data"), file1);
        requestBody[0]=requestBody1;
        requestBody[1]=requestBody2;
        Call<String> call = apiManager.uploadImage( m[0],requestBody1,requestBody2,null);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                Log.v("Upload", response.message());
                Log.v("Upload", "success");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Upload", t.toString());
            }
        });

    }


    private static String guessMimeType(String path)
    {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = fileNameMap.getContentTypeFor(path);
        if (contentTypeFor == null)
        {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }
}
