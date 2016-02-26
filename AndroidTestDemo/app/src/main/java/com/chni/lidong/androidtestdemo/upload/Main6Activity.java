package com.chni.lidong.androidtestdemo.upload;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.chni.lidong.androidtestdemo.R;

import java.io.File;
import java.io.FileOutputStream;

public class Main6Activity extends AppCompatActivity {

    Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
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

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             new Thread(){
                 @Override
                 public void run() {
                     super.run();
                     FileUploadManager.upload(getScreenBitmap());
                 }
             }.start();
            }
        });
    }

    public String getScreenBitmap() {
        String path = "";
        // 构建Bitmap
        WindowManager windowManager = this.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        int w = display.getWidth();
        int h = display.getHeight();
        Bitmap Bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        // 获取屏幕
        View decorview = this.getWindow().getDecorView();
        decorview.setDrawingCacheEnabled(true);
        Bmp = decorview.getDrawingCache();
        Log.d("tst", Bmp.toString());
        // 图片存储路径
        try {
            String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath();
            Log.d("tst", sdcard);

            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/sc/");
            if (file.exists() && file.isDirectory()) {
                file.delete();
            }
            file.mkdirs();
            Log.d("tst", Environment.getExternalStorageDirectory().getAbsolutePath() + "/sc/" + "share1.png");
            File file1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/sc/" + "share1.png");
            Log.d("tst", "android.os.Build.MODEL=" + android.os.Build.MODEL);
            boolean mkdir1 = file1.isFile();
            boolean mkdir2 = file1.exists();
            Log.d("tst", mkdir1 + "");
            Log.d("tst", mkdir2 + "");
            if (file1.exists() && file.isFile()) {
                file1.delete();
            }
            file1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/sc/" + "share1.png");
            path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/sc/" + "share1.png";
            FileOutputStream fos = new FileOutputStream(file1);
            Bmp.compress(Bitmap.CompressFormat.PNG, 80, fos);
            fos.flush();
            fos.close();
            Log.d("tst", "写入OK");
            Log.d("tst", fos.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

}
