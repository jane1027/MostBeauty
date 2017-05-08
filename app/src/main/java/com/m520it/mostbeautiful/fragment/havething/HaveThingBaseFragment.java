package com.m520it.mostbeautiful.fragment.havething;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.m520it.mostbeautiful.Adapter.HaveThingHeadgearAdapter;
import com.m520it.mostbeautiful.bean.HaveThingHeadgearBean;
import com.m520it.mostbeautiful.fragment.BaseFragment;
import com.m520it.mostbeautiful.util.NetWorkUtil;
import com.m520it.mostbeautiful.view.HaveThingPopWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 温思园
 * @ 2016/11/11 18:21
 * @ ${有物抽的Fragment}
 */

public class HaveThingBaseFragment extends BaseFragment {

    protected FragmentActivity mActivity;
    protected HaveThingHeadgearAdapter mAdapter;
    protected RelativeLayout mRlHavethingTop;
    protected List<HaveThingHeadgearBean.DataBean.ProductsBean> mDatas;
    protected RelativeLayout mNoneRl;
    protected int visItemCount;
    protected int visibleLastIndex;
    protected HaveThingPopWindow mPopWindow;

    protected void handleHeadgear(Object obj) {
        try {
            String data = (String) obj;
            if (!TextUtils.isEmpty(data)) {
                HaveThingHeadgearBean headgearBean = JSON.parseObject(data, HaveThingHeadgearBean.class);
                HaveThingHeadgearBean.DataBean dataBean = headgearBean.getData();
                List<HaveThingHeadgearBean.DataBean.ProductsBean> products = dataBean.getProducts();
                if(mDatas==null){
                    mDatas = new ArrayList<HaveThingHeadgearBean.DataBean.ProductsBean>();
                    mDatas = products;
                    mAdapter.setDatas(products);
                }else{
                    mDatas.addAll(products);//after
                }
//                mDatas = products; //before
                mAdapter.setDatas(products);
                mAdapter.notifyDataSetChanged();
                if (mNoneRl != null) {
                    mNoneRl.setVisibility(View.GONE);
                }
                if (mRlHavethingTop != null) {
                    mRlHavethingTop.setVisibility(View.VISIBLE);
                }
            }else {
                tip("没有更多数据了");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 请求网络
     */
    protected void netWork(int action, String url) {
        NetWorkUtil util = new NetWorkUtil();
        util.setListener(this);
        util.doGet(action, url);
    }

    @Override
    protected void initUI() {
        //Default Empty implements
    }

    protected void init() {
        mActivity = getActivity();
        mAdapter = new HaveThingHeadgearAdapter(mActivity);
    }
}
