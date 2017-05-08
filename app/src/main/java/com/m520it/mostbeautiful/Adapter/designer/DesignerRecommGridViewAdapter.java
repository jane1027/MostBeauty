package com.m520it.mostbeautiful.Adapter.designer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.m520it.mostbeautiful.Adapter.MBBaseAdapter;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.designer.RecommCategoriesValue;

/**
 * @author Jacob.Huang
 * @time 2016/11/12  14:44
 * @desc ${TODD}
 */
public class DesignerRecommGridViewAdapter extends MBBaseAdapter<RecommCategoriesValue> {
    public DesignerRecommGridViewAdapter(Context c) {
        super(c);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv=null;
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.fragment_recomm_gridview_item, parent, false);
             tv = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(tv);
        }else {
            tv= (TextView) convertView.getTag();
        }
        tv.setText(mDatas.get(position).getName());
        return convertView;
    }
}
