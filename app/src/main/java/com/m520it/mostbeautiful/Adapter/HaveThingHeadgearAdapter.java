package com.m520it.mostbeautiful.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.activity.CommentActivity;
import com.m520it.mostbeautiful.activity.DesignDetailsActivity;
import com.m520it.mostbeautiful.activity.HaveThingDetailActivity;
import com.m520it.mostbeautiful.bean.HaveThingHeadgearBean;
import com.m520it.mostbeautiful.cons.Consts;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author 温思园
 * @ 2016/11/10 13:19
 * @ ${首饰}
 */

public class HaveThingHeadgearAdapter extends
        MBBaseAdapter<HaveThingHeadgearBean.DataBean.ProductsBean> {

    private Context mContext;
    public HaveThingHeadgearAdapter(Context c) {
        super(c);
        mContext = c;
    }

    @Override
    public void setDatas(List<HaveThingHeadgearBean.DataBean.ProductsBean> datas) {
        mDatas = datas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.havething_common_item, null);
            holder = new ViewHolder();
            holder.iconIv = (ImageView) convertView.findViewById(R.id.iv_headgear_item_icon);
            holder.nameTv1 = (TextView) convertView.findViewById(R.id.tv_headgear_item_name1);
            holder.headIv = (CircleImageView) convertView.findViewById(R.id.iv_headgear_item_head);
            holder.nameTv2 = (TextView) convertView.findViewById(R.id.tv_headgear_item_name2);
            holder.introduceTv = (TextView) convertView.findViewById(R.id.tv_headgear_item_introduce);
            //表情
            holder.goodIv = (ImageView) convertView.findViewById(R.id.iv_headgear_item_like);
            holder.noGoodIv = (ImageView) convertView.findViewById(R.id.iv_headgear_item_dislike);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        HaveThingHeadgearBean.DataBean.ProductsBean bean = mDatas.get(position);
        Picasso.with(mContext).load(bean.getCover_images().get(0)).
                placeholder(R.drawable.jiazz).
                error(R.drawable.jiazz).
                into(holder.iconIv);
        //点击事件
        clickIcon(position,holder.iconIv);
        holder.nameTv1.setText(bean.getName());
        Picasso.with(mContext).load(bean.getDesigner().getAvatar_url()).
                placeholder(R.drawable.jiazz).
                error(R.drawable.jiazz).
                into(holder.headIv);
        //头像点击事件
        clickHead(position,holder.headIv);
        holder.nameTv2.setText(bean.getDesigner().getName());
        holder.introduceTv.setText(bean.getDesigner().getLabel());
        clickGood(position,holder.goodIv);
        clickGood(position,holder.noGoodIv);
        return convertView;
    }



    /**
     * 头像点击,跳转到设计师详情页
     */
    private void clickHead(final int position, CircleImageView headIv) {
        headIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long designerId= mDatas.get(position).getDesigner().getId();
//                long designerId= mDatas.get(position).getId();
//                Log.v("打印","111111---"+designerId);
                Intent intent = new Intent(mContext, DesignDetailsActivity.class);
                intent.putExtra("id",designerId);
                mContext.startActivity(intent);
            }
        });
    }

    /**
     * 产品图片点击,跳转到产品详情页面
     */
    private void clickIcon(final int position, ImageView iconIv) {
        iconIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int detailId = mDatas.get(position).getId();
                Intent intent = new Intent(mContext, HaveThingDetailActivity.class);
                intent.putExtra(Consts.TO_HAVETHINGDETAIL_ACTIVITY,detailId);
                mContext.startActivity(intent);
            }
        });
    }

    /**
     * 两个小图标点击,跳转到商品详情页
     */
    private void clickGood(final int position, ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int detailId = mDatas.get(position).getId();
                Intent intent = new Intent(mContext, CommentActivity.class);
                intent.putExtra(CommentActivity.TO_COMMENT,detailId);
                mContext.startActivity(intent);
            }
        });
    }

    private class ViewHolder {
        ImageView iconIv;//大图片
        TextView nameTv1;//大图片名称
        CircleImageView headIv;//头像
        TextView nameTv2;//大图片名称
        TextView introduceTv;//介绍
        ImageView goodIv;//点赞图
        ImageView noGoodIv;//点赞图
    }
}
