package com.chni.lidong.androidtestdemo.supertooltips.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.chni.lidong.androidtestdemo.R;
import com.chni.lidong.androidtestdemo.supertooltips.ToolTip;
import com.chni.lidong.androidtestdemo.supertooltips.ToolTipRelativeLayout;
import com.chni.lidong.androidtestdemo.supertooltips.ToolTipView;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener, ToolTipView.OnToolTipViewClickedListener{
    private ToolTipView mRedToolTipView;
    private ToolTipView mGreenToolTipView;
    private ToolTipView mBlueToolTipView;
    private ToolTipView mPurpleToolTipView;
    private ToolTipView mOrangeToolTipView;
    private ToolTipRelativeLayout mToolTipFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
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
        mToolTipFrameLayout = (ToolTipRelativeLayout) findViewById(R.id.activity_main_tooltipframelayout);
        findViewById(R.id.activity_main_redtv).setOnClickListener(this);
        findViewById(R.id.activity_main_greentv).setOnClickListener(this);
        findViewById(R.id.activity_main_bluetv).setOnClickListener(this);
        findViewById(R.id.activity_main_purpletv).setOnClickListener(this);
        findViewById(R.id.activity_main_orangetv).setOnClickListener(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addRedToolTipView();
            }
        }, 500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addGreenToolTipView();
            }
        }, 700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addOrangeToolTipView();
            }
        }, 900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addBlueToolTipView();
            }
        }, 1100);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addPurpleToolTipView();
            }
        }, 1300);

    }

    private void addRedToolTipView() {
        ToolTip toolTip = new ToolTip()
                .withText("A beautiful Button")
                .withColor(getResources().getColor(R.color.holo_red))
                .withShadow();

        mRedToolTipView = mToolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_redtv));
        mRedToolTipView.setOnToolTipViewClickedListener(this);
    }

    private void addGreenToolTipView() {
        ToolTip toolTip = new ToolTip()
                .withText("Another beautiful Button!")
                .withColor(getResources().getColor(R.color.holo_green));

        mGreenToolTipView = mToolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_greentv));
        mGreenToolTipView.setOnToolTipViewClickedListener(this);
    }

    private void addBlueToolTipView() {
        ToolTip toolTip = new ToolTip()
                .withText("Moarrrr buttons!")
                .withColor(getResources().getColor(R.color.holo_blue))
                .withAnimationType(ToolTip.AnimationType.FROM_TOP);

        mBlueToolTipView = mToolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_bluetv));
        mBlueToolTipView.setOnToolTipViewClickedListener(this);
    }

    private void addPurpleToolTipView() {
        ToolTip toolTip = new ToolTip()
                .withContentView(LayoutInflater.from(this).inflate(R.layout.custom_tooltip, null))
                .withColor(getResources().getColor(R.color.holo_purple))
                .withAnimationType(ToolTip.AnimationType.NONE);

        mPurpleToolTipView = mToolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_purpletv));
        mPurpleToolTipView.setOnToolTipViewClickedListener(this);
    }

    private void addOrangeToolTipView() {
        ToolTip toolTip = new ToolTip()
                .withText("Tap me!")
                .withColor(getResources().getColor(R.color.holo_orange));

        mOrangeToolTipView = mToolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_orangetv));
        mOrangeToolTipView.setOnToolTipViewClickedListener(this);
    }

    @Override
    public void onClick(final View view) {
        int id = view.getId();
        if (id == R.id.activity_main_redtv) {
            if (mRedToolTipView == null) {
                addRedToolTipView();
            } else {
                mRedToolTipView.remove();
                mRedToolTipView = null;
            }

        } else if (id == R.id.activity_main_greentv) {
            if (mGreenToolTipView == null) {
                addGreenToolTipView();
            } else {
                mGreenToolTipView.remove();
                mGreenToolTipView = null;
            }

        } else if (id == R.id.activity_main_bluetv) {
            if (mBlueToolTipView == null) {
                addBlueToolTipView();
            } else {
                mBlueToolTipView.remove();
                mBlueToolTipView = null;
            }

        } else if (id == R.id.activity_main_purpletv) {
            if (mPurpleToolTipView == null) {
                addPurpleToolTipView();
            } else {
                mPurpleToolTipView.remove();
                mPurpleToolTipView = null;
            }

        } else if (id == R.id.activity_main_orangetv) {
            if (mOrangeToolTipView == null) {
                addOrangeToolTipView();
            } else {
                mOrangeToolTipView.remove();
                mOrangeToolTipView = null;
            }

        }
    }

    @Override
    public void onToolTipViewClicked(final ToolTipView toolTipView) {
        if (mRedToolTipView == toolTipView) {
            mRedToolTipView = null;
        } else if (mGreenToolTipView == toolTipView) {
            mGreenToolTipView = null;
        } else if (mBlueToolTipView == toolTipView) {
            mBlueToolTipView = null;
        } else if (mPurpleToolTipView == toolTipView) {
            mPurpleToolTipView = null;
        } else if (mOrangeToolTipView == toolTipView) {
            mOrangeToolTipView = null;
        }
    }

}
