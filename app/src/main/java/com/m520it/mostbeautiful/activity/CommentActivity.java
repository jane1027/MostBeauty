package com.m520it.mostbeautiful.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.m520it.mostbeautiful.Adapter.HaveThingCommentAdapter;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.detailinfo.DataBean;
import com.m520it.mostbeautiful.bean.detailinfo.HaveThingDetailBean;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.NetWorkUrl;
import com.m520it.mostbeautiful.util.FixedViewUtil;
import com.m520it.mostbeautiful.util.NetWorkUtil;

/**
 * @author SmRo
 * @time 2016/11/13  上午11:48
 * @desc ${TODD}
 */
public class CommentActivity extends BaseActivity {

    public static final String TO_COMMENT = "comment";
    private HaveThingCommentAdapter mCommentAdapter;
    private ListView mCommentLv;
    private DataBean mDataBean;
    private int mDetailId;
    private ImageView mIc_circle_back_normal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        mDetailId = intent.getIntExtra(TO_COMMENT, 0);
        initUI();
        transparentHeading();
        initController();

    }

    @Override
    protected void initController() {
        NetWorkUtil netWorkUtil = new NetWorkUtil();
        String url = NetWorkUrl.HAVETHING_DETAIL_BASE_URL + mDetailId + NetWorkUrl.HAVETHING_DETAIL_URL;
        Log.d("it520", "initController: url    "+url);
        netWorkUtil.doGet(Actions.HAVETHING_DAILY_DETAIL_ACTION,url);
        netWorkUtil.setListener(this);
    }
    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what) {
            case Actions.HAVETHING_DAILY_DETAIL_ACTION:
                if (msg.obj != null) {
                    Log.d("it520", "handlerMessage: " + msg.obj);
                    String data = (String) msg.obj;
                    getData(data);
                    initData();
                }
                break;
        }
    }

    private void getData(String data) {

        HaveThingDetailBean detailBean = JSON.parseObject(data, HaveThingDetailBean.class);
        mDataBean = detailBean.getData();
    }

    @Override
    protected void initData() {
        mCommentLv.setAdapter(mCommentAdapter);
        mCommentAdapter.setData(mDataBean.getComments());
        mCommentAdapter.notifyDataSetChanged();
        FixedViewUtil.setListViewHeightBasedOnChildren(mCommentLv);
    }
    @Override
    protected void initUI() {
        setContentView(R.layout.activity_have_thing_detail_comment);
        transparentHeading();
        mCommentLv = (ListView) findViewById(R.id.comment_lv);//评价详情
        mCommentAdapter = new HaveThingCommentAdapter(this);

        mIc_circle_back_normal = (ImageView)findViewById(R.id.ic_circle_back_normal);
        mIc_circle_back_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ActivityUtil.start(CommentActivity.this,HaveThingDetailActivity.class,true);
                finish();
            }
        });

    }
}
