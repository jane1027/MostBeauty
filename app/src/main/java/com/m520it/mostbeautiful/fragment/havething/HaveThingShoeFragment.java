package com.m520it.mostbeautiful.fragment.havething;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.HavethingTypeName;
import com.m520it.mostbeautiful.cons.NetWorkUrl;
import com.m520it.mostbeautiful.view.HaveThingPopWindow;

import static com.m520it.mostbeautiful.R.id.havething_shoe_lv;


/**
 * @author 温思园
 * @ 2016/11/9 20:49
 * @ ${}
 */

public class HaveThingShoeFragment extends HaveThingBaseFragment
        implements View.OnClickListener {

    private TextView mHavethingShoeTextTv;
    private ListView mHavethingShoeLv;
    private ImageView mHavethingShoeArrowsIv;

    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what) {
            case Actions.HAVETHING_SHOE_ACTION:
                handleHeadgear(msg.obj);
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_have_thing_shoe, container, false);
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
        netWork(Actions.HAVETHING_SHOE_ACTION, NetWorkUrl.HAVETHING_SHOE_URL);
    }

    @Override
    protected void initUI() {
        init();
        mHavethingShoeTextTv = (TextView) mActivity.findViewById(R.id.tv_havething_shoe_text);
        mHavethingShoeArrowsIv = (ImageView) mActivity.findViewById(R.id.iv_havething_shoe_arrows);
        mRlHavethingTop = (RelativeLayout) mActivity.findViewById(R.id.rl_havething_shoe);
        mHavethingShoeLv = (ListView) mActivity.findViewById(havething_shoe_lv);
        mNoneRl = (RelativeLayout) mActivity.findViewById(R.id.none_rl);
        mNoneRl.setVisibility(View.VISIBLE);
        mRlHavethingTop.setOnClickListener(this);
        //去掉滚动bar
        mHavethingShoeLv.setVerticalScrollBarEnabled(false);
        //        mAdapter = new HaveThingHeadgearAdapter(mActivity);
        mHavethingShoeLv.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        if(mPopWindow==null) {
            mPopWindow = new HaveThingPopWindow(mActivity);
        }
        mPopWindow.setTypeName(HavethingTypeName.Havething_shoe_name);
        mPopWindow.onShow(v);
    }
}
