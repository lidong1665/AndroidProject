package com.chni.lidong.androidtestdemo.upload;

import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;

/**
 * Created by Administrator on 2016/1/28.
 */
public interface FileUploadService {

    @Multipart
    @POST("/upload")
    Call<String> upload(@Part("myfile\"; filename=\"image.png\" ") RequestBody file, @Part("description") RequestBody description);
}
