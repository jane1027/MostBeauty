package com.m520it.mostbeautiful.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.HaveThingTopBean;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.NetWorkUrl;
import com.m520it.mostbeautiful.listener.IResponseListener;
import com.m520it.mostbeautiful.util.NetWorkUtil;
import com.m520it.mostbeautiful.util.Utils;

import java.util.List;

/**
 * @author 温思园
 * @ 2016/11/12 20:48
 * @ ${有物 头部的popWindow}
 */

public class HaveThingPopWindow implements IResponseListener {
    //        private ViewGroup mVg;
    private PopupWindow mPopupWindow;
    private Context mContext;
    private GridView mHavethingTypeGv;
    private List<HaveThingTopBean.DataBean.CategoriesBean.SubCategoriesBean> mDatas;
    private String mTypeName;
    private MyAdapter mAdapter;

    public HaveThingPopWindow(Context context) {
        mContext = context;
        //            mVg = vg;
        initController();
        initView();
        initEvent();
    }

    private void initController() {
        NetWorkUtil util = new NetWorkUtil();
        util.doGet(Actions.HAVETHING_TOP_ACTION, NetWorkUrl.HAVETHING_TOP_URL);
        util.setListener(this);
    }

    //创建 PopupWindow
    private void initView() {
        //充气布局
        View contentView = LayoutInflater.from(mContext).
                inflate(R.layout.havething_type_pop, null, false);
        mPopupWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mHavethingTypeGv = (GridView) contentView.findViewById(R.id.havething_type_gv);
        //PopupWindow 内部的控件点击并且刷新状态
        mPopupWindow.setFocusable(true);//控件可点击
        mPopupWindow.setOutsideTouchable(true);//控件外可点击
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());//控件需要背景才能点击
        mPopupWindow.update();
    }

    private void initData(int action,Object obj) {
        try {
            String reslut = (String) obj;
            HaveThingTopBean haveThingTopBean = JSON.parseObject(reslut, HaveThingTopBean.class);
            HaveThingTopBean.DataBean dataBean = haveThingTopBean.getData();
            List<HaveThingTopBean.DataBean.CategoriesBean> categories = dataBean.getCategories();
            for (HaveThingTopBean.DataBean.CategoriesBean bean : categories) {
                if (bean.getName().equals(mTypeName)) {
                    mDatas = bean.getSub_categories();
                    String name = mDatas.get(0).getName();
                    mAdapter.notifyDataSetChanged();
                    break;
                }
            }
        } catch (Exception e) {
            Toast.makeText(mContext, "数据异常", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        //        mDatas = new ArrayList<>();
//        mDatas.add("全部");
//        mDatas.add("功能包");
//        mDatas.add("项链");
//        mDatas.add("高跟鞋");
//        mDatas.add("胸针");
//        mDatas.add("数码配件");
    }

    private void initEvent() {
        mAdapter = new MyAdapter();
        mHavethingTypeGv.setAdapter(mAdapter);
    }

    /**
     * PopupWindow 展示的方法
     *
     * @param anchor PopupWindow 的父控件
     */
    public void onShow(View anchor) {
        //xoff,yoff 展示在父控件的哪个位置
        if (mPopupWindow != null) {
            //mPopupWindow.showAsDropDown(anchor);//相对于某个控件的正左下方
            mPopupWindow.showAsDropDown(anchor, 0, -Utils.convertDpToPixel(mContext, 35));//有偏移
            //showAtLocation(parent,gravity,x,y);//相对于父控件的位置(例Gravity.CENTER,Gravity.BOTTOM等),可以设置偏移或无偏移
            mAdapter.notifyDataSetChanged();
        }
    }

    //关闭PopupWindow的方法
    public void onDismiss() {
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
        }
    }

    @Override
    public void onNetworkResponsed(int action, Object... values) {
        initData(action,values[0]);
    }

    public void setTypeName(String typeName) {
        mTypeName = typeName;
    }

    private class MyAdapter extends BaseAdapter {
//        List<HaveThingTopBean.DataBean.CategoriesBean.SubCategoriesBean> mDatas;
//        MyAdapter(ArrayList<String> datas) {
//            mDatas = datas;
//        }

        @Override
        public int getCount() {
            return (mDatas==null?0:mDatas.size())+1;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.havething_popwindow_item, parent, false);
            TextView text = (TextView) convertView.findViewById(R.id.havething_popwindow_tv);
            if(position==0) {
                text.setText("全部");
            }else{
                text.setText(mDatas.get(position-1).getName());
            }
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点到了"+position, Toast.LENGTH_SHORT).show();
                    onDismiss();
                }
            });
            return convertView;
        }
    }
}
