package com.chni.lidong.androidtestdemo.utils;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Android的ListView与GridView的万能适配器
 *
 * @author lidong
 * @date 2015-11-08
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<T> mData;
    private int mItemLayoutId;

    public CommonAdapter(Context mContext, List<T> mData, int mItemLayoutId) {
        this.mContext = mContext;
        this.mData = mData;
        this.mItemLayoutId = mItemLayoutId;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        holder = getViewHolder(position, convertView, parent);
        convert(holder, getItem(position));
        return holder.getmConventView();
    }

    /**
     * @param holder
     * @param t
     */
    public abstract void convert(ViewHolder holder, T t);

    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.getInstance(mContext, convertView, parent, mItemLayoutId, position);
    }

}
