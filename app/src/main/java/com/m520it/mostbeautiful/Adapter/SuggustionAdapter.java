package com.m520it.mostbeautiful.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.activity.SuggestionActivity;

import java.util.ArrayList;

/**
 * @author ben
 * @time 2016/11/13  10:41
 * @desc ${TODD}
 */
public class SuggustionAdapter extends MBBaseAdapter<String> {

    public SuggustionAdapter(Context c) {
        super(c);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder ;
        if(convertView == null) {
            holder = new Viewholder();
            convertView = mInflater.inflate(R.layout.suggestion_reply_item,parent,false);
            holder.dateTv = (TextView) convertView.findViewById(R.id.date_tv);
            holder.replyTv = (TextView) convertView.findViewById(R.id.reply_tv);
            convertView.setTag(holder);
        }else {
            holder = (Viewholder) convertView.getTag();
        }
        //在activity获取当前时间
        ArrayList<String> dates = ((SuggestionActivity) mContext).getDate();
        holder.dateTv.setText(dates.get(position));
        holder.replyTv.setText(mDatas.get(position));
        return convertView;
    }

    class Viewholder {
        TextView dateTv;//当前时间
        TextView replyTv;//回复
    }
}
