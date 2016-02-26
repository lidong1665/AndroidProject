package com.chni.lidong.androidtestdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.android.volley.VolleyError;
import com.chni.lidong.androidtestdemo.loading.Main7Activity;
import com.chni.lidong.androidtestdemo.utils.CkeckServerTokenUtils;
import com.chni.lidong.androidtestdemo.utils.HttpUtil;
import com.chni.lidong.androidtestdemo.utils.MyResultCallback;
import com.chni.lidong.androidtestdemo.utils.OkHttpClientManager;
import com.chni.lidong.androidtestdemo.utils.ResponseListener;
import com.squareup.okhttp.Request;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity1 extends AppCompatActivity {

    private ImageView mImageView;
    private ViewAnimator animator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        HttpUtil.initVolleyRequestQueue(this);
        AppBarLayout ss = (AppBarLayout) findViewById(R.id.tt);
        Toolbar toolbar = (Toolbar) ss.findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitle("健康");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        animator = (ViewAnimator) findViewById(R.id.animator);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Button button = (Button) findViewById(R.id.button);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        mImageView = (ImageView) findViewById(R.id.image);


        Bitmap bit=null;
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main7Activity.class));
            }
        });

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String url = "http://114.113.158.209:8088/cuslogin";
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", "lidong1665");
                params.put("password", "325106");
                params.put("orgid", "0010000");
                CkeckServerTokenUtils.handleServerCheck(params);
                final Map<String, String> params1 = new HashMap<String, String>();
		        JSONObject jsonObject1 = new  JSONObject(params);
		        params1.put("data", jsonObject1.toString());
		        Log.v("zgy", params1.toString());
                OkHttpClientManager.postAsyn(url, params1, new MyResultCallback<String>() {
                            @Override
                            public void onError(Request request, Exception e) {
                                Log.i("TAG------------",request.toString()+e.getMessage());
                            }

                            @Override
                            public void onResponse(String response) {
                             Log.i("TAG------------",response);
                            }
                        });

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                OkHttpClientManager.getDisplayImageDelegate().displayImage(mImageView, "http://images.csdn.net/201508171/11.jpg", this);
                animator.setDisplayedChild(1);

//                Picasso.with(getApplicationContext()).
//                        load("http://images.csdn.net/201508171/1.jpg").
//                        into(mImageView, new Callback.EmptyCallback() {
//                            @Override
//                            public void onSuccess() {
//                                super.onSuccess();
//                                // Index 0 is the image view.
//                                animator.setDisplayedChild(0);
//                            }
//
//                            @Override
//                            public void onError() {
//                                super.onError();
//                                animator.setDisplayedChild(2);
//                            }
//                        });
//                Picasso.with(getApplicationContext())
//                        .load("http://images.csdn.net/20150817/1.jpg")
//                        .placeholder(R.drawable.loading_dialog_progressbar)
//                        .error(R.mipmap.ic_launcher)
//                        .into(mImageView,new Callback.EmptyCallback() {
//                            @Override
//                            public void onSuccess() {
//                                super.onSuccess();
//                                // Index 0 is the image view.
//                                animator.setDisplayedChild(0);
//                            }
//                        });


//                Picasso.with(getApplicationContext())
//                        .load("http://images.csdn.net/20150817/1.jpg")
//                        .resize(50, 50)
//                        .centerCrop()
//                        .into(mImageView,new Callback.EmptyCallback() {
//                            @Override
//                            public void onSuccess() {
//                                super.onSuccess();
//                                // Index 0 is the image view.
//                                animator.setDisplayedChild(0);
//                            }
//
//                            @Override
//                            public void onError() {
//                                super.onError();
//                                animator.setDisplayedChild(2);
//                            }
//                        });
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar snackbar =  Snackbar.make(v, "登录成功", Snackbar.LENGTH_LONG);
//
//                Snackbar.SnackbarLayout ve = (Snackbar.SnackbarLayout) snackbar.getView();
//                ve.setBackgroundColor(0xfff44336);
//                ve.setAlpha(0.5f);
//                ViewGroup.LayoutParams vl = ve.getLayoutParams();
//                LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(vl.width,vl.height);
//                ll.gravity = Gravity.BOTTOM;
//                ve.setLayoutParams(ll);
//                snackbar.show();
                startActivity(new Intent(getApplicationContext(), TestTabLayout.class));


                OkHttpClientManager.getAsyn("https://raw.githubusercontent.com/hongyangAndroid/okhttp-utils/master/users.gson",
                        new MyResultCallback<List<User>>() {

                            @Override
                            public void onError(Request request, Exception e) {
                                Log.d("request", request.urlString());
                            }

                            @Override
                            public void onResponse(List<User> response) {
                                Log.d("-------", response.get(0).password);
                                Toast.makeText(getApplicationContext(), response.size() + "", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), com.chni.lidong.androidtestdemo.swiperefreshlistfragment.MainActivity.class));

                String url = "http://114.113.158.209:8088/cuslogin";
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", "13261570828");
                params.put("password", "123456");
                params.put("orgid", "0010000");
                HttpUtil.sendVolleyPostRequest1(url, params, new ResponseListener<String>() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d("0000000000000000000",volleyError.toString());
                    }

                    @Override
                    public void onResponse(String s) {
                      Log.d("0000000000000000000",s);
                    }
                });

                //		String url ="http://114.113.158.209:8088/cuslogin";

//                RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
//                mRequestQueue.start();
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("username", "lidong1665");
//		params.put("password", "123456");
//		params.put("orgid", "0010000");
//		CkeckServerTokenUtils.handleServerCheck(params);
//		Map<String, String> params1 = new HashMap<String, String>();
//		JSONObject jsonObject1 = new  JSONObject(params);
//		params1.put("data", jsonObject1.toString());
//		Log.v("zgy", params1.toString());
//		PostRequest pr = new PostRequest(url, params1, new ResponseListener<String>() {
//
//			@Override
//			public void onResponse(String response) {
//				Log.v("zgy", "==========PostRequest=========" + response) ;
//			}
//
//			@Override
//			public void onErrorResponse(VolleyError response) {
//				 Log.v("zgy", "==========PostRequest=========" + response) ;
//
//			}
//		});
//		mRequestQueue.add(pr);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
