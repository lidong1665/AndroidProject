package com.chni.lidong.androidtestdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.chni.lidong.androidtestdemo.utils.BaseFragment;
import com.chni.lidong.androidtestdemo.utils.MD5Utils;
import com.chni.lidong.androidtestdemo.utils.SystemAttrUtlis;
import com.chni.lidong.androidtestdemo.utils.UIHelper;

/**
 * Created by Chen on 2015/10/27.
 */
public class CustomListFragment extends BaseFragment {

    private static final String FRAGMENT_INDEX = "fragment_index";
    private final int FIRST_FRAGMENT = 0;
    private final int SECOND_FRAGMENT = 1;
    private final int THIRD_FRAGMENT = 2;

    private LinearLayout mFragmentView;

    private int mCurIndex = -1;
    /** 标志位，标志已经初始化完成 */
    private boolean isPrepared;
    /** 是否已被加载过一次，第二次就不再去请求数据了 */
    private boolean mHasLoadedOnce;
    private WebView wb;

    /**
     * 创建新实例
     *
     * @param index
     * @return
     */
    public static CustomListFragment newInstance(int index) {
        Bundle bundle = new Bundle();
        bundle.putInt(FRAGMENT_INDEX, index);
        CustomListFragment fragment = new CustomListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mFragmentView == null) {
            mFragmentView = (LinearLayout) inflater.inflate(R.layout.fragment, container, false);
            wb = (WebView) mFragmentView.findViewById(R.id.webView);
            //获得索引值
            Bundle bundle = getArguments();
            if (bundle != null) {
                mCurIndex = bundle.getInt(FRAGMENT_INDEX);
            }
            isPrepared = true;
            lazyLoad();
        }

        //因为共用一个Fragment视图，所以当前这个视图已被加载到Activity中，必须先清除后再加入Activity
        ViewGroup parent = (ViewGroup)mFragmentView.getParent();
        if(parent != null) {
            parent.removeView(mFragmentView);
        }
        return mFragmentView;
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //显示加载进度对话框
                UIHelper.showDialogForLoading(getActivity(), "正在加载...", true);
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
//                    Thread.sleep(2000);
                    //在这里添加调用接口获取数据的代码
                    doSomething();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }

            @Override
            protected void onPostExecute(Boolean isSuccess) {
                if (isSuccess) {
                    // 加载成功
                    setView();
                    mHasLoadedOnce = true;
                    Snackbar.make(mFragmentView, " 加载成功", Snackbar.LENGTH_SHORT).show();
                } else {
                    // 加载失败
                    Snackbar.make(mFragmentView, "加载失败", Snackbar.LENGTH_SHORT).show();
                }
                //关闭对话框
                UIHelper.hideDialogForLoading();
            }
        }.execute();
    }

    private void doSomething() {

        //http://114.113.158.209:8088/healthmonitbase?customerid=0010000021944
        // &density=480
        // &time=2015-10-20 11:06:59&ko=0000&token=02357f1557b96b27489ae1da8c600ea8

        String time = SystemAttrUtlis.getPostTimeNow();
        String sysCode = "0010000app";
        String token = MD5Utils.MD5s(SystemAttrUtlis.getPostTimeNow() + sysCode);
        final  String url = "http://114.113.158.209:8088/healthmonitbase?customerid=0010000021944" +
                "&density=480" +
                "&time="+time+"&ko=0000&token="+token;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
               wb.loadUrl(url);
            }
        });
    }



    private void setView() {
        // 根据索引加载不同视图
        switch (mCurIndex) {
            case FIRST_FRAGMENT:
                //mFragmentView.setText("第一个");
                break;

            case SECOND_FRAGMENT:
                //mFragmentView.setText("第二个");
                break;

            case THIRD_FRAGMENT:
                //mFragmentView.setText("第三个");
                break;
        }
    }
}
