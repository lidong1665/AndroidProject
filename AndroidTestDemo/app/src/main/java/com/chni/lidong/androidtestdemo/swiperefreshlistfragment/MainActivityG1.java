package com.chni.lidong.androidtestdemo.swiperefreshlistfragment;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chni.lidong.androidtestdemo.R;

import java.util.Calendar;

public class MainActivityG1 extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView textviewX;
    private TextView textviewY;
    private TextView textviewZ;
    private TextView textviewF;

    private int mX, mY, mZ;
    private long lasttimestamp = 0;
    Calendar mCalendar;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_g1);
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

        textviewX = (TextView) findViewById(R.id.textView2);
        textviewY = (TextView) findViewById(R.id.textView3);
        textviewZ = (TextView) findViewById(R.id.textView4);
        textviewF = (TextView) findViewById(R.id.textView5);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);// TYPE_GRAVITY
        if (null == mSensorManager) {
            Log.d(TAG, "deveice not support SensorManager");
        }
        // 参数三，检测的精准度
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);// SENSOR_DELAY_GAME
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor == null) {
            return;
        }

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            int x = (int) event.values[0];
            int y = (int) event.values[1];
            int z = (int) event.values[2];
            mCalendar = Calendar.getInstance();
            long stamp = mCalendar.getTimeInMillis() / 1000l;// 1393844912

            textviewX.setText(String.valueOf(x));
            textviewY.setText(String.valueOf(y));
            textviewZ.setText(String.valueOf(z));

            int second = mCalendar.get(Calendar.SECOND);// 53

            int px = Math.abs(mX - x);
            int py = Math.abs(mY - y);
            int pz = Math.abs(mZ - z);
            Log.d(TAG, "pX:" + px + "  pY:" + py + "  pZ:" + pz + "    stamp:"
                    + stamp + "  second:" + second);
            int maxvalue = getMaxValue(px, py, pz);
            if (maxvalue > 2 && (stamp - lasttimestamp) > 30) {
                lasttimestamp = stamp;
                Log.d(TAG, " sensor isMoveorchanged....");
                textviewF.setText("检测手机在移动..");
            }

            mX = x;
            mY = y;
            mZ = z;

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    /**
     * 获取一个最大值
     *
     * @param px
     * @param py
     * @param pz
     * @return
     */
    public int getMaxValue(int px, int py, int pz) {
        int max = 0;
        if (px > py && px > pz) {
            max = px;
        } else if (py > px && py > pz) {
            max = py;
        } else if (pz > px && pz > py) {
            max = pz;
        }

        return max;
    }
}
