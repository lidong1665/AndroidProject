package com.chni.lidong.androidtestdemo.webService.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chni.lidong.androidtestdemo.R;
import com.chni.lidong.androidtestdemo.webService.model.CarType;

/**
 * Created by Administrator on 2016/1/11.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>   {
    private  CarType mDataset;

    public MyAdapter(CarType mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.my_adapter_detail, null);
        // 创建一个ViewHolder
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.getTable().get(position).getName());
        holder.mTextViewName.setText(mDataset.getTable().get(position).getImgname());
    }

    @Override
    public int getItemCount() {
        return mDataset.getTable().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mTextView;
        public TextView mTextViewName;
        public ViewHolder(View itemView)
        {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView6);
            mTextViewName = (TextView) itemView.findViewById(R.id.textView7);

        }

    }
}
