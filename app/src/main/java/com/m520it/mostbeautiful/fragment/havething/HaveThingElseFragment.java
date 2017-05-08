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

import static com.m520it.mostbeautiful.R.id.havething_else_lv;


/**
 * @author 温思园
 * @ 2016/11/9 20:49
 * @ ${}
 */

public class HaveThingElseFragment extends HaveThingBaseFragment implements View.OnClickListener {

    private TextView mHavethingElseTextTv;
    private ListView mHavethingElseLv;

    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what) {
            case Actions.HAVETHING_ELSE_ACTION:
                handleHeadgear(msg.obj);
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_have_thing_else, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initController();
        initUI();
    }

    @Override
    protected void initController() {
        netWork(Actions.HAVETHING_ELSE_ACTION, NetWorkUrl.HAVETHING_ELSE_URL);
    }

    @Override
    protected void initUI() {
        init();
        mHavethingElseTextTv = (TextView) mActivity.findViewById(R.id.tv_havething_else_text);
        ImageView havethingElseArrowsIv = (ImageView) mActivity.findViewById(R.id.iv_havething_else_arrows);
        mRlHavethingTop = (RelativeLayout) mActivity.findViewById(R.id.rl_havething_else);
        mHavethingElseLv = (ListView) mActivity.findViewById(havething_else_lv);
        mNoneRl = (RelativeLayout) mActivity.findViewById(R.id.none_rl);
        mNoneRl.setVisibility(View.VISIBLE);
        mRlHavethingTop.setOnClickListener(this);
        //去掉滚动bar
        mHavethingElseLv.setVerticalScrollBarEnabled(false);
        mHavethingElseLv.setAdapter(mAdapter);
    }
    @Override
    public void onClick(View v) {
        if(mPopWindow==null) {
            mPopWindow = new HaveThingPopWindow(mActivity);
        }
        mPopWindow.setTypeName(HavethingTypeName.Havething_else_name);
        mPopWindow.onShow(v);
    }
}
