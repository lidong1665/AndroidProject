package com.chni.lidong.androidtestdemo.data_binding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chni.lidong.androidtestdemo.R;
import com.chni.lidong.androidtestdemo.databinding.ContentDataBindingDemoBinding;
import com.chni.lidong.androidtestdemo.db.entity.User;

/**
 * databinding数据绑定
 */
public class DataBindingDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContentDataBindingDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.content_data_binding_demo);
        User user = new User("Test","Tetstst");
        binding.setUser(user);
    }

}
