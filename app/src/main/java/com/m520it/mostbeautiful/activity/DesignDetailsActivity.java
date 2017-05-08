package com.m520it.mostbeautiful.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.designer.MWbean;
import com.m520it.mostbeautiful.bean.designer.PersonDetail;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.NetWorkUrl;
import com.m520it.mostbeautiful.util.NetWorkUtil;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DesignDetailsActivity extends BaseActivity {
    public static final String DESIGNER_ID = "DESIGNER_ID";

    private PersonDetail mPersonalDetail;
    private ImageView mRecommend_images;
    private TextView mName;
    private TextView mFocus_textView;
    private TextView mLabel;
    private TextView mTittle;
    private CircleImageView mAvatar_url;
    private TextView mDecription;

    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what) {
            case Actions.DESIGN_DETAIL_ACTION :
                handleDetailJson((String) msg.obj);
                break;
        }
    }
    private void handleDetailJson(String JsonStr) {
        MWbean mWbean = JSON.parseObject(JsonStr, MWbean.class);
        mPersonalDetail = JSON.parseObject(mWbean.getData(), PersonDetail.class);

        Picasso.with(this).load(mPersonalDetail.getIntroduce_images().get(0)).
                placeholder(R.drawable.jiazz).
                error(R.drawable.jiazz).into(mRecommend_images);

        Picasso.with(this).load(mPersonalDetail.getAvatar_url()).into(mAvatar_url);
        mName.setText(mPersonalDetail.getName());
        mFocus_textView.setText(mPersonalDetail.getFollow_num()+"   关注者");
        mLabel.setText(mPersonalDetail.getLabel());
        mDecription.setText(mPersonalDetail.getDescription());
       mTittle.setText("\""+mPersonalDetail.getConcept()+"\"");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_details);
        initData();
        initUI();
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        long id = intent.getLongExtra("id", 0);
        NetWorkUtil netWorkUtil = new NetWorkUtil();
        netWorkUtil.setListener(this);
        netWorkUtil.doGet(Actions.DESIGN_DETAIL_ACTION, NetWorkUrl.DESIGN_DETAIL_URL+id);
    }

    @Override
    protected void initUI() {
        mRecommend_images = (ImageView) findViewById(R.id.recommend_images);
        mName = (TextView) findViewById(R.id.name);
        mFocus_textView = (TextView) findViewById(R.id.focus_textView);
        mLabel = (TextView) findViewById(R.id.label);
        mDecription = (TextView) findViewById(R.id.decription);
        mTittle = (TextView) findViewById(R.id.tittle);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        mAvatar_url = (CircleImageView) findViewById(R.id.avatar_url);



    }

    public void focusClick(View view) {
        tip("已添加关注");
    }
}
