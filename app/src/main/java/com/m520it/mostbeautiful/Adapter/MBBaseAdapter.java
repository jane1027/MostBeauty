package com.m520it.mostbeautiful.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author jane
 * @time 2016/11/8  11:51
 * @desc ${TODD}
 */
public abstract class MBBaseAdapter<T> extends BaseAdapter {
    protected List<T> mDatas;
    protected Context mContext;
    protected LayoutInflater mInflater;

    public MBBaseAdapter(Context c) {
        mContext = c;
        mInflater = LayoutInflater.from(mContext);
    }

    public  void setDatas(List<T> datas) {
    mDatas=datas;
    }

    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }
}
