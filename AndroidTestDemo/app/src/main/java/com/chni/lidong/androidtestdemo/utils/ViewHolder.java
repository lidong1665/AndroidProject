package com.chni.lidong.androidtestdemo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chni.lidong.androidtestdemo.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * @author lidong
 * @className ViewHolder
 * @date 2015-11-09
 */
public class ViewHolder {

    private SparseArray<View> mView;
    private int mPosition;
    private View mConventView;

    /**
     * ViewHolder的构造方法
     *
     * @param context
     * @param group
     * @param layoutId
     * @param position
     */
    private ViewHolder(Context context, ViewGroup group, int layoutId, int position) {
        this.mPosition = position;
        this.mView = new SparseArray<View>();
        mConventView = LayoutInflater.from(context).inflate(layoutId, group, false);
        mConventView.setTag(this);

    }

    /**
     * ViewHolder
     *
     * @return 创建ViewHolder对象
     */
    public static ViewHolder getInstance(Context context, View conventView, ViewGroup group, int layoutId, int position) {
        if (conventView == null) {
            return new ViewHolder(context, group, layoutId, position);
        }
        return (ViewHolder) conventView.getTag();

    }

    /**
     * 根据用户的ID获取View
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int id) {

        View view = mView.get(id);
        if (view == null) {//View
            view = mConventView.findViewById(id);
            mView.put(id, view);
        }
        return (T) view;
    }

    /**
     * 根据用户ID设置文字
     * @param viewId
     * @param text
     */
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 根据viewId设置相应的图片
     * @param viewId
     * @param bitmap
     * @return
     */
    public ViewHolder setBitmap(int viewId,Bitmap bitmap){
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return  this;
    }

    /**
     * 根据图片的url设置相应的图片
     * @param ctx
     * @param viewId
     * @param url
     * @param placeholder
     * @param error
     * @return
     */
    public ViewHolder setImageView(Context ctx ,int viewId,String url,int placeholder,int error){
        ImageView imageView = getView(viewId);
        Picasso.with(ctx)
                .load(url)
                .placeholder(placeholder)
                .error(error)
                .into(imageView);
        return  this;
    }

    /**
     * @return 位置
     */
    public int getPosition() {
        return mPosition;
    }

    /**
     * 获取ConvertView
     * @return
     */
    public View getmConventView() {
        return mConventView;
    }


}
