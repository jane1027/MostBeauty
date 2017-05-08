package com.m520it.mostbeautiful.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.cons.Consts;
import com.m520it.mostbeautiful.util.ActivityUtil;
import com.m520it.mostbeautiful.util.SPUtil;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author HAIEN
 * @time 2016/11/12 16:24
 * ${TODO}
 */

public class MimeSettingActivity extends BaseActivity implements View.OnClickListener{
    private ImageView mCircleBackNormal;
    private TextView mUsernameTv;
    private CircleImageView mMinePortraitCiv;
    private TextView mSex;
    private TextView mBirthTv;
    private TextView mInfoEmailTv;
    private TextView mInfoPhoneTv;
    private Button out;
    private RelativeLayout mSelfMessage;
    private RelativeLayout clean;
    private RelativeLayout retroaction;
    private RelativeLayout good;
    private RelativeLayout recommend;
    private RelativeLayout about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initdatas();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(null!=mMinePortraitCiv){
            mMinePortraitCiv.setImageResource(SPUtil.getInt(this, Consts.USERIC));
        }

    }

    @Override
    protected void initUI() {
        setContentView(R.layout.mine_setting_activity);
        transparentHeading();
        mCircleBackNormal = (ImageView)findViewById(R.id.ic_circle_back_normal);
        mCircleBackNormal.setOnClickListener(this);


        mSelfMessage = (RelativeLayout)findViewById(R.id.self_message);
        mSelfMessage.setOnClickListener(this);
        clean = (RelativeLayout)findViewById(R.id.clean);
        clean.setOnClickListener(this);
        retroaction = (RelativeLayout)findViewById(R.id.retroaction);
        retroaction.setOnClickListener(this);
        good = (RelativeLayout)findViewById(R.id.good);
        good.setOnClickListener(this);
        recommend = (RelativeLayout)findViewById(R.id.recommend);
        recommend.setOnClickListener(this);
        about = (RelativeLayout)findViewById(R.id.about);
        about.setOnClickListener(this);
        mUsernameTv = (TextView)findViewById(R.id.username_tv);
        mMinePortraitCiv = (CircleImageView)findViewById(R.id.mine_portrait_civ);
        mMinePortraitCiv.setOnClickListener(this);
        mSex = (TextView)findViewById(R.id.sex);
        mBirthTv = (TextView)findViewById(R.id.birth_tv);
        mInfoEmailTv = (TextView)findViewById(R.id.info_email_tv);
        mInfoPhoneTv = (TextView)findViewById(R.id.info_phone_tv);
        out = (Button) findViewById(R.id.out);
        out.setOnClickListener(this);
    }
    /***----回显---***/
    private void initdatas() {
        /***----获取数据---***/
        /*String userName = SPUtil.getString(this, Consts.USERNAME);
        String pwd =SPUtil.getString(this, Consts.PASSWORD);
        String sex =SPUtil.getString(this,Consts.SEX);
        String mYear =SPUtil.getString(this,Consts.YEAR);
        String mMonth =SPUtil.getString(this,Consts.MONTH);
        String mDay =SPUtil.getString(this,Consts.DAY);
        String email =SPUtil.getString(this,Consts.EMAIL);
        String phone =SPUtil.getString(this,Consts.PHONE);
        *//***----判断是否有用户---***//*
        if(!ifValueWasEmpty(userName,pwd,sex,mYear,mMonth,mDay,email,phone)){
            mMinePortraitCiv.setImageResource(SPUtil.getInt(this,Consts.USERIC));
            mUsernameTv.setText(userName);
            mSex.setText(sex);
            mBirthTv.setText(mYear+"-"+mMonth+"-"+mDay);
            mInfoEmailTv.setText(email);
            mInfoPhoneTv.setText(phone);
        }*/
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_circle_back_normal :
                /**-- 回退到MineFragment页面的同时  更新登陆等更改的个人信息 --**/
                ActivityUtil.start(this,MainActivity.class,true);
                // TODO: 2016/11/9 注意 此处可能还缺少从设置页面跳转到这个页面时，默认的显示MineFragment页面
                break;
            case R.id.self_message :
               /***----跳转到编辑页面---***/
                ActivityUtil.start(this,EditorActivity.class,false);
                break;
            case R.id.clean :
               /***----清除缓存---***/
               Toast.makeText(MimeSettingActivity.this, "清除缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.retroaction :
               /***----跳转到反馈页面---***/
                Toast.makeText(MimeSettingActivity.this, "反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.good :
               /***----跳转到好评页面---***/
                Toast.makeText(MimeSettingActivity.this, "好评", Toast.LENGTH_SHORT).show();
                break;
            case R.id.recommend :
               /***----跳转到推荐页面---***/
                Toast.makeText(MimeSettingActivity.this, "推荐", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about :
               /***----跳转到关于我们页面---***/
                Toast.makeText(MimeSettingActivity.this, "关于我们", Toast.LENGTH_SHORT).show();
                break;
            case R.id.out:
                ActivityUtil.start(this,ConfirmActivity.class,true);
                break;
        }
    }

}
