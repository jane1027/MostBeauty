package com.m520it.mostbeautiful.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.detailinfo.CommentsBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author SmRo
 * @time 2016/11/13  上午10:23
 * @desc ${TODD}
 */
public class HaveThingCommentAdapter extends BaseAdapter {

    private ArrayList<CommentsBean> mDatas;
    private Context mContext;

    public HaveThingCommentAdapter(Context context) {
        mContext = context;
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


    public long getTime(long time) {
        long times = System.currentTimeMillis() - time;
        return times / 1000 / 60 / 60;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("it520", "getView: position" + position);
        Log.d("it520", "getView: size" + mDatas.size());
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.have_thing_detail_listview_comment_item, null);
            holder.user_icon = (CircleImageView) convertView.findViewById(R.id.user_icon);
            holder.user_name_tv = (TextView) convertView.findViewById(R.id.user_name_tv);
            holder.comment_tv = (TextView) convertView.findViewById(R.id.comment_tv);
            holder.comment_time_tv = (TextView) convertView.findViewById(R.id.comment_time_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CommentsBean bean = mDatas.get(position);
        Picasso.with(mContext).load(bean.getAuthor().getAvatar_url())
                .placeholder(R.drawable.no_wifi_icon_white)
                .error(R.drawable.no_wifi_icon_white)
                .into(holder.user_icon);
        holder.user_name_tv.setText(bean.getAuthor().getUsername());
        holder.comment_tv.setText(bean.getContent());
        holder.comment_time_tv.setText(getTime(bean.getCreated_at()) + "小时前");
        return convertView;
    }


    class ViewHolder {
        CircleImageView user_icon;
        TextView user_name_tv;
        TextView comment_tv;
        TextView comment_time_tv;
    }

    public void setData(List<CommentsBean> commentsBeen) {
        mDatas = (ArrayList<CommentsBean>) commentsBeen;
    }
}
