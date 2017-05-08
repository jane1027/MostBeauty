package com.m520it.mostbeautiful.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.paintpage.PrintData;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.NetWorkUrl;
import com.m520it.mostbeautiful.util.NetWorkUtil;

import java.util.ArrayList;

/**
 * @author jane
 * @time 2016/11/7  20:46
 * @desc ${TODD}
 */
public class Splashactivity extends BaseActivity implements Animation.AnimationListener {
    private ImageView mImageView;
    private NetWorkUtil mNetWorkUtil;
    public static final String ARTICLES_DATAS = "ARTICLES_DATAS";
    private ArrayList<PrintData.DataBean.ArticlesBean> mArticles;

    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what) {
            case Actions.PAINT_ACTION:
                try {
                    //从网络加载数据,并传到下一页
                    String json = (String) msg.obj;
                    PrintData paintDatas = JSON.parseObject(json, PrintData.class);
                    mArticles = (ArrayList<PrintData.DataBean.ArticlesBean>) paintDatas.getData().getArticles();
                    Intent intent = new Intent(this,MainActivity.class);
                    intent.putExtra(ARTICLES_DATAS, mArticles);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    //类型转换错误,证明msg类型时Error类型,网络连接失败,直接跳转到下一页
                    Intent intent = new Intent(this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initUI();
    }

    @Override
    protected void initUI() {
        mImageView = (ImageView) findViewById(R.id.splash_iv);
        AlphaAnimation animation = new AlphaAnimation(0.5f,1.0f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(this);
        mImageView.startAnimation(animation);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        //加载PaintFragment数据
        mNetWorkUtil = new NetWorkUtil();
        mNetWorkUtil.setListener(this);
        String urlPath = NetWorkUrl.PAINT_URL+"?page=1&is_new_user=true&page_size=30&user_id=0&device_id=864394010541904&platform=android&lang=zh&appVersion=1.2.4&appVersionCode=10240&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
        mNetWorkUtil.doGet(Actions.PAINT_ACTION,urlPath);
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}
