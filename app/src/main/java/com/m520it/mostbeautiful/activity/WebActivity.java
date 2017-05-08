package com.m520it.mostbeautiful.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.paintpage.PaintContentData;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.util.NetWorkUtil;
import com.m520it.mostbeautiful.view.ObservableWebView;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author ben
 * @time 2016/11/12  15:00
 * @desc ${TODD}
 */
public class WebActivity extends BaseActivity implements View.OnClickListener {
    public static final String ID = "id";
    private int mId;
    private ObservableWebView mWebView;
    private NetWorkUtil mNetWorkUtil;
    private ImageView mBackIv;
    private boolean isShowing  = false;
    private CircleImageView mCircleImageView;
    private TextView mNameTv;
    private TextView mLocationTv;
    private RelativeLayout mRelativeLayout;
    private PaintContentData mPaintContentDatas;


    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what) {
            case Actions.PAINT_CONTENT_ACTION:
                try {
                    String json = (String) msg.obj;
                    mPaintContentDatas = JSON.parseObject(json, PaintContentData.class);
                    String webUrl = mPaintContentDatas.getData().getWeb_url();
                    mWebView.loadUrl(webUrl);
                    //加载设计师数据
                    String imageUrl = mPaintContentDatas.getData().getDesigners().get(0).getAvatar_url();
                    Picasso.with(this).load(imageUrl).into(mCircleImageView);
                    String name = mPaintContentDatas.getData().getDesigners().get(0).getName();
                    mNameTv.setText(name);
                    String loaction = mPaintContentDatas.getData().getDesigners().get(0).getCity();
                    mLocationTv.setText(loaction);
                    mRelativeLayout.setOnClickListener(this);
                } catch (Exception e) {
                    finish();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initData();
        initUI();
        mNetWorkUtil = new NetWorkUtil();
        mNetWorkUtil.setListener(this);
        String urlPath = "http://design.zuimeia.com/api/v1/article/" + mId
                + "/?device_id=864394010541904&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
        mNetWorkUtil.doGet(Actions.PAINT_CONTENT_ACTION, urlPath);
    }

    @Override
    protected void initData() {
        mId = getIntent().getIntExtra(ID, 0);
    }

    @Override
    protected void initUI() {

        mWebView = (ObservableWebView) findViewById(R.id.webview);
        mBackIv = (ImageView) findViewById(R.id.back_iv);
        mBackIv.setOnClickListener(this);
        mCircleImageView = (CircleImageView) findViewById(R.id.designer_iv);
        mNameTv = (TextView) findViewById(R.id.name_tv);
        mLocationTv = (TextView) findViewById(R.id.loaction_tv);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.designer_rl);

        mWebView.setOnScrollChangedCallback(new ObservableWebView.OnScrollChangedCallback() {
            @Override
            public void onScroll(int dx, int dy) {
                if(dy > 50) {
                    if(!isShowing) {
                        AnimatorSet set = new AnimatorSet();
                        ObjectAnimator anim = ObjectAnimator.ofFloat(mBackIv,"translationY",0,-300f);
                        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mRelativeLayout,"translationY",0,-300f);
                        set.setDuration(500);
                        anim.start();
                        anim2.start();
                        isShowing = !isShowing;
                    }
                }else if(dy < -50) {
                    if(isShowing) {
                        AnimatorSet set = new AnimatorSet();
                        ObjectAnimator anim = ObjectAnimator.ofFloat(mBackIv,"translationY",-100f,30f);
                        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mRelativeLayout,"translationY",-100f,30f);
                        set.setDuration(500);
                        anim.start();
                        anim2.start();
                        isShowing = !isShowing;
                    }
                }
            }
        });
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.designer_rl:
                Intent intent = new Intent(this,DesignDetailsActivity.class);
                long designerId = mPaintContentDatas.getData().getDesigners().get(0).getId();
                intent.putExtra("id",designerId);
                startActivity(intent);
                break;
        }
    }

}
