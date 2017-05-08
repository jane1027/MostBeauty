package com.m520it.mostbeautiful.Adapter.designer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.m520it.mostbeautiful.Adapter.MBBaseAdapter;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.designer.DesignerMw;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author jane
 * @time 2016/11/10  16:23
 * @desc ${TODD}
 */
public class DesignerMostwelAdapter extends MBBaseAdapter<DesignerMw> {


    public DesignerMostwelAdapter(Context c) {
        super(c);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.designer_item_welcome, null);
            holder = new ViewHolder();
            holder.recommend_images = (ImageView) convertView.findViewById(R.id.recommend_images);
            holder.avatar_url = (CircleImageView) convertView.findViewById(R.id.avatar_url);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.label = (TextView) convertView.findViewById(R.id.label);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(mContext).load(mDatas.get(position).getRecommend_images().get(0)).
                placeholder(R.drawable.jiazz).
                error(R.drawable.jiazz).into(holder.recommend_images);

          Picasso.with(mContext).load(mDatas.get(position).getAvatar_url()).into(holder.avatar_url);

       holder.name.setText(mDatas.get(position).getName());
       holder.label.setText(mDatas.get(position).getLabel());
        return convertView;
    }

    class ViewHolder {
        private CircleImageView avatar_url;//头像
        private TextView label;//便签(名字下面的)
        private TextView name;//名字
        private ImageView recommend_images;//大图片地址

    }
}
