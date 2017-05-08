package com.m520it.mostbeautiful.fragment.havething;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.HavethingTypeName;
import com.m520it.mostbeautiful.cons.NetWorkUrl;
import com.m520it.mostbeautiful.listener.IResponseListener;
import com.m520it.mostbeautiful.view.HaveThingPopWindow;


/**
 * @author 温思园
 * @ 2016/11/9 20:49
 * @ ${}
 */

public class HaveThingHeadgearFragment extends HaveThingBaseFragment implements IResponseListener, View.OnClickListener {

    private TextView mTvHavethingHeadgerText;
    private ImageView mIvHavethingHeadgerArrows;
    private ListView mHavethingHeadgearLv;
//    private List<HaveThingHeadgearBean.DataBean.ProductsBean> mDatas;
    private ImageView mNoneIv;
    protected int page = 1;
    protected int page_size = 30;
    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what) {
            case Actions.HAVETHING_HEADGEAR_ACTION:
                handleHeadgear(msg.obj);
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_have_thing_headgear, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initController();
        initUI();
    }

    /**
     * 请求网络
     */
    @Override
    protected void initController() {
        netWork(Actions.HAVETHING_HEADGEAR_ACTION, NetWorkUrl.HAVETHING_HEADGEAR_URL);
//        NetWorkUtil util = new NetWorkUtil();
//        util.setListener(this);
//        util.doGet(Actions.HAVETHING_HEADGEAR_ACTION, NetWorkUrl.HAVETHING_HEADGEAR_URL);
    }


    @Override
    protected void initUI() {
        init();
        //        mActivity = getActivity();
        mTvHavethingHeadgerText = (TextView) mActivity.findViewById(R.id.tv_havething_headger_text);
        mIvHavethingHeadgerArrows = (ImageView) mActivity.findViewById(R.id.iv_havething_headger_arrows);
        mRlHavethingTop = (RelativeLayout) mActivity.findViewById(R.id.rl_havething_headgear);
        mHavethingHeadgearLv = (ListView) mActivity.findViewById(R.id.havething_headgear_lv);
        mNoneRl = (RelativeLayout) mActivity.findViewById(R.id.none_rl);
        mNoneRl.setVisibility(View.VISIBLE);
        mRlHavethingTop.setOnClickListener(this);
        //去掉滚动bar
        mHavethingHeadgearLv.setVerticalScrollBarEnabled(false);
//        mAdapter = new HaveThingHeadgearAdapter(mActivity);
        mHavethingHeadgearLv.setAdapter(mAdapter);
        /***----设置滚动监听---***/
//        scrollListen(mHavethingHeadgearLv);

    }
    /***----设置滚动监听---***/
    public void scrollListen(ListView lv){

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                loadMore(scrollState);
//                netWork(Actions.HAVETHING_DAILY_ACTION, NetWorkUrl.HAVETHING_DAILY_URL);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                visItemCount = visibleItemCount;
                visibleLastIndex = firstVisibleItem + visibleItemCount - 1;

            }
        });
    }
    /***----加载更多---***/
    public void loadMore(int scrollState){
        if(mAdapter.isEmpty()){
            return;
        }
        int itemsLastIndex = mAdapter.getCount() - 1;    //数据集最后一项的索引
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                && visibleLastIndex == itemsLastIndex) {
            //如果是自动加载,可以在这里放置异步加载数据的代码
            Log.i("LOADMORE", "loading...");
            /***----发送加载更多的网络请求---***/
            //----------------------------------------
            specialNetWork();
        }
    }

    /***----自己的网络请求---***/
    public void specialNetWork(){
        page = (mDatas.size()+1)/page_size;
        Log.i("===page","page="+page);
        netWork(Actions.HAVETHING_HEADGEAR_ACTION, NetWorkUrl.getHaveThingHeardEarUrl(page,page_size));
    }
    @Override
    public void onClick(View v) {
        if(mPopWindow==null) {
            mPopWindow = new HaveThingPopWindow(mActivity);
        }

        mPopWindow.setTypeName(HavethingTypeName.Havething_headgear_name);
        mPopWindow.onShow(v);
    }

}
