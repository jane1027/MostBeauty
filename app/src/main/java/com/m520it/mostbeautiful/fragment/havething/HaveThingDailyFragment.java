package com.m520it.mostbeautiful.fragment.havething;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.NetWorkUrl;


/**
 * @author 温思园
 * @ 2016/11/9 20:49
 * @ ${}
 */

public class HaveThingDailyFragment extends HaveThingBaseFragment {

    private ListView mHavethingDailyLv;
    private RelativeLayout mRlHavethingToday;
    public int visItemCount;
    private int visibleLastIndex;
    private String mData;
    protected int page = 1;
    protected int page_size = 30;
    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what) {
            case Actions.HAVETHING_DAILY_ACTION:
                try {
                    mData = (String) msg.obj;
                    mRlHavethingToday.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                    mRlHavethingToday.setVisibility(View.GONE);
                }
                handleHeadgear(msg.obj);
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_have_thing_daily, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initController();
        initUI();
    }

    @Override
    protected void initController() {
        netWork(Actions.HAVETHING_DAILY_ACTION, NetWorkUrl.HAVETHING_DAILY_URL);
    }



    @Override
    protected void initUI() {
        init();
        mRlHavethingToday = (RelativeLayout) mActivity.findViewById(R.id.rl_havething_daily);
        mNoneRl = (RelativeLayout) mActivity.findViewById(R.id.none_rl);
        mNoneRl.setVisibility(View.VISIBLE);
        mHavethingDailyLv = (ListView) mActivity.findViewById(R.id.havething_daily_lv);
        //去掉滚动bar
        mHavethingDailyLv.setVerticalScrollBarEnabled(false);
        mHavethingDailyLv.setAdapter(mAdapter);
        /***----设置滚动监听---***/
        scrollListen(mHavethingDailyLv);
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

    /***----自己的加载更多网络请求---***/
    public void specialNetWork() {
        /***----这里有点问题---***/
        page = (mDatas.size()+1)/page_size;
        Log.i("===page","page="+page);
//        netWork(Actions.HAVETHING_DAILY_ACTION, NetWorkUrl.getHaveThingDailyUrl(page,page_size));
    }
}
