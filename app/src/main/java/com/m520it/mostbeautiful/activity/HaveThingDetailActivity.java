package com.m520it.mostbeautiful.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.image.SmartImageView;
import com.m520it.mostbeautiful.Adapter.HaveThingCommentAdapter;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.detailinfo.CommentsBean;
import com.m520it.mostbeautiful.bean.detailinfo.DataBean;
import com.m520it.mostbeautiful.bean.detailinfo.DescTypesBean;
import com.m520it.mostbeautiful.bean.detailinfo.DesignerBean;
import com.m520it.mostbeautiful.bean.detailinfo.HaveThingDetailBean;
import com.m520it.mostbeautiful.bean.detailinfo.ReferProductsBean;
import com.m520it.mostbeautiful.cons.Actions;
import com.m520it.mostbeautiful.cons.Consts;
import com.m520it.mostbeautiful.cons.NetWorkUrl;
import com.m520it.mostbeautiful.util.FixedViewUtil;
import com.m520it.mostbeautiful.util.NetWorkUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class HaveThingDetailActivity extends BaseActivity implements View.OnClickListener {

   protected int mDetailId;
   protected ViewPager mHaveThingDetailHead;
   protected TextView mStyleTv;
   protected TextView mBrightTv;
   protected TextView mSuggestTv;
   protected TextView mDesigerTv;
   protected TextView mDescTv;
   protected ImageView mImageIv;
   protected CircleImageView mDesigerIcon;
   protected TextView mDesigerNameTv;
   protected TextView mDesigerLableTv;
   protected Button mAttentionClick;
   protected TextView mDesigerDescriptionTv;
   protected ImageView mDesigerImageOne;
   protected ImageView mDesigerImageTwo;
   protected ListView mCommentLv;
   protected ArrayList<String> mCover_images;
   protected String mName;
   protected List<DescTypesBean> mDesc_types;
   protected String mDesc;
   protected List<String> mImages;
   protected List<CommentsBean> mComments;
   protected ImageView mImageOne;
   protected ImageView mImageThree;
   protected ImageView mImageTwo;
   protected DesignerBean mDesigner;
   protected List<ReferProductsBean> mRefer_products;
   protected AdAdapter mAdAdapter;
   protected LinearLayout mAdIndicator;
   protected Timer mTimer;
   protected HaveThingCommentAdapter mCommentAdapter;
   protected TextView mDesigerCommentTv;
   protected Button mLookAllComment;
   protected DataBean mDataBean;
    private ImageView mIc_circle_back_normal;
    private ImageView mFeed_dislike;
    private ImageView mFeed_like;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        mDetailId = intent.getIntExtra(Consts.TO_HAVETHINGDETAIL_ACTIVITY, 0);
        initController();
        initUI();
        transparentHeading();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mTimer!=null) {
            mTimer.cancel();
        }
    }

    @Override
    protected void handlerMessage(Message msg) {
        switch (msg.what) {
            case Actions.HAVETHING_DAILY_DETAIL_ACTION:
                if(msg.obj!=null) {
                    Log.d("it520", "handlerMessage: "+msg.obj);
                    String data = (String) msg.obj;
                    getData(data);
                    initData();
                }
                break;
        }
    }

    @Override
    protected void initController() {
        NetWorkUtil netWorkUtil = new NetWorkUtil();
        String url = NetWorkUrl.HAVETHING_DETAIL_BASE_URL + mDetailId + NetWorkUrl.HAVETHING_DETAIL_URL;
        Log.d("it520", "initController: url    "+url);
        netWorkUtil.doGet(Actions.HAVETHING_DAILY_DETAIL_ACTION,url);
        netWorkUtil.setListener(this);
    }

    private void initAdIndicaor(ArrayList<String> datas) {
        for (int i = 0; i < datas.size(); i++) {
            View view = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15, 15);
            params.setMargins(10, 0, 0, 0);
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.ad_indicator_bg);
            view.setEnabled(i == 0);
            mAdIndicator.addView(view);
        }
    }

    private void initBannerTimer(final ArrayList<String> datas) {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                changeBanner(datas);
            }
        }, 3000, 3000);
    }

    private void changeBanner(final ArrayList<String> datas) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int current = mHaveThingDetailHead.getCurrentItem();
                current++;
                if (current == datas.size()) {
                    current = 0;
                }
                mHaveThingDetailHead.setCurrentItem(current);
            }
        });
    }

    @Override
    protected void initData() {

        mAdAdapter.setData(mCover_images);
        mAdAdapter.notifyDataSetChanged();
            initAdIndicaor(mCover_images);
        initBannerTimer(mCover_images);

        mCommentAdapter.setData(mComments);
        mCommentAdapter.notifyDataSetChanged();
        FixedViewUtil.setListViewHeightBasedOnChildren(mCommentLv);

        if (mDesc_types != null && mDesc_types.size() > 0) {
            Picasso.with(this).load(mDesc_types.get(0).getImage_url())
                    .placeholder(R.drawable.no_wifi_icon_white)
                    .error(R.drawable.no_wifi_icon_white).into(mImageOne);

        }

        if (mDesc_types != null && mDesc_types.size() > 0) {
            Picasso.with(this).load(mDesc_types.get(1).getImage_url())
                    .placeholder(R.drawable.no_wifi_icon_white)
                    .error(R.drawable.no_wifi_icon_white).into(mImageTwo);
        }

        if (mDesc_types != null && mDesc_types.size() > 0) {
            Picasso.with(this).load(mDesc_types.get(2).getImage_url())
                    .placeholder(R.drawable.no_wifi_icon_white)
                    .error(R.drawable.no_wifi_icon_white).into(mImageThree);
        }
        mStyleTv.setText(mDesc_types.get(0).getDesc());
        mBrightTv.setText(mDesc_types.get(1).getDesc());
        mSuggestTv.setText(mDesc_types.get(2).getDesc());

        mDesigerTv.setText(mName);
        if (mImages != null && mImages.size() > 0) {
            Picasso.with(this).load(mImages.get(0))
                    .placeholder(R.drawable.no_wifi_icon_white)
                    .error(R.drawable.no_wifi_icon_white).into(mImageIv);
        }
        mDescTv.setText(mDesc);

        if (mDesigner != null ) {
            Picasso.with(this).load(mDesigner.getAvatar_url())
                    .placeholder(R.drawable.no_wifi_icon_white)
                    .error(R.drawable.no_wifi_icon_white).into(mDesigerIcon);
        }
        mDesigerNameTv.setText(mDesigner.getName());
        mDesigerNameTv.setText(mDesigner.getLabel());
        mDesigerDescriptionTv.setText(mDesigner.getDescription());
        if (mRefer_products != null && mRefer_products.size() > 0) {
            Picasso.with(this).load(mRefer_products.get(0).getCover_images().get(0))
                    .placeholder(R.drawable.no_wifi_icon_white)
                    .error(R.drawable.no_wifi_icon_white).into(mDesigerImageOne);
        }

        if (mRefer_products != null && mRefer_products.size() > 0) {
            Picasso.with(this).load(mRefer_products.get(0).getCover_images().get(1))
                    .placeholder(R.drawable.no_wifi_icon_white)
                    .error(R.drawable.no_wifi_icon_white).into(mDesigerImageTwo);
        }

        mDesigerCommentTv.setText("评论（"+mComments.size()+" )");
    }


    private void getData(String data) {

        HaveThingDetailBean detailBean = JSON.parseObject(data, HaveThingDetailBean.class);
        mDataBean = detailBean.getData();
        Log.d("it520", "getData: dataBean" + mDataBean.toString());

        //轮播图
        mCover_images = (ArrayList<String>) mDataBean.getCover_images();

        //轮播图下的描述
        mDesc_types = mDataBean.getDesc_types();
        //商品名称
        mName = mDataBean.getName();
        //商品描述
        mDesc = mDataBean.getDesc();
        //商品图片
        mImages = mDataBean.getImages();
        //评论相关
        mComments = mDataBean.getComments();

        //设计师信息
        mDesigner = mDataBean.getDesigner();

        //设计师的其他作品
        mRefer_products = mDataBean.getRefer_products();

    }

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_have_thing_detail);

        mHaveThingDetailHead = (ViewPager) findViewById(R.id.have_thing_detail_head);//轮播图
        mAdAdapter = new AdAdapter();
        mHaveThingDetailHead.setAdapter(mAdAdapter);
        mHaveThingDetailHead.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int childCount = mAdIndicator.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    mAdIndicator.getChildAt(i).setEnabled(i == position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mAdIndicator = (LinearLayout)findViewById(R.id.ad_indicator);

        mStyleTv = (TextView) findViewById(R.id.style_tv);//风格
        mImageOne = (ImageView) findViewById(R.id.image_one);

        mBrightTv = (TextView) findViewById(R.id.bright_tv);//设计亮点
        mImageTwo = (ImageView) findViewById(R.id.image_two);

        mSuggestTv = (TextView) findViewById(R.id.suggest_tv);//有物建议
        mImageThree = (ImageView) findViewById(R.id.image_three);

        mDesigerTv = (TextView) findViewById(R.id.desiger_tv);//设计师的名字以及作品／name

        mDescTv = (TextView) findViewById(R.id.desc_tv);//商品描述  desc

        mImageIv = (ImageView) findViewById(R.id.image_iv);//image[0]

        mDesigerCommentTv = (TextView)findViewById(R.id.desiger_comment_tv);

        mDesigerIcon = (CircleImageView) findViewById(R.id.desiger_icon);//设计师头像  designer[0]

        mDesigerNameTv = (TextView) findViewById(R.id.desiger_name_tv);//设计师名字

        mDesigerLableTv = (TextView) findViewById(R.id.desiger_lable_tv);//创始人

        mAttentionClick = (Button) findViewById(R.id.attention_click);//点击关注
        mAttentionClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //// TODO: 2016/11/12 点击关注
            }
        });

        mDesigerDescriptionTv = (TextView) findViewById(R.id.desiger_description_tv);//设计师详情信息

        mDesigerImageOne = (ImageView) findViewById(R.id.desiger_image_one);//设计师其他作品1

        mDesigerImageTwo = (ImageView) findViewById(R.id.desiger_image_two);

        mCommentLv = (ListView) findViewById(R.id.comment_lv);//评价详情
        mCommentAdapter = new HaveThingCommentAdapter(this);
        mCommentLv.setAdapter(mCommentAdapter);

        mLookAllComment = (Button)findViewById(R.id.look_all_comment);
        mLookAllComment.setOnClickListener(this);
//        {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HaveThingDetailActivity.this, CommentActivity.class);
//                intent.putExtra(CommentActivity.TO_COMMENT,mDetailId);
//                startActivity(intent);
//            }
//        });

        mIc_circle_back_normal = (ImageView)findViewById(R.id.ic_circle_back_normal);
        mIc_circle_back_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mFeed_dislike = (ImageView)findViewById(R.id.feed_dislike);
        mFeed_like = (ImageView)findViewById(R.id.feed_like);
        mFeed_dislike.setOnClickListener(this);
        mFeed_like.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.look_all_comment:
            case R.id.feed_dislike:
            case R.id.feed_like:
                Intent intent = new Intent(HaveThingDetailActivity.this, CommentActivity.class);
                intent.putExtra(CommentActivity.TO_COMMENT, mDetailId);
                startActivity(intent);
                break;
        }
    }

    private class AdAdapter extends PagerAdapter {

        private ArrayList<String> mDatas;
        private List<SmartImageView> mChildViews;

        @Override
        public int getCount() {
            return mDatas != null ? mDatas.size() : 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        public void setData(ArrayList<String> datas) {
            mDatas = datas;
            mChildViews = new ArrayList<>(mDatas.size());
            for (String data : mDatas) {

                SmartImageView smiv = new SmartImageView(HaveThingDetailActivity.this);

                smiv.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                smiv.setScaleType(ImageView.ScaleType.FIT_XY);
                smiv.setImageUrl(data);
                mChildViews.add(smiv);
            }
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            SmartImageView smartImageView = mChildViews.get(position);
            container.addView(smartImageView);
            return smartImageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            SmartImageView smartImageView = mChildViews.get(position);
            container.removeView(smartImageView);
        }
    }
}
