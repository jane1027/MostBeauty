package com.m520it.mostbeautiful.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.cons.Consts;
import com.m520it.mostbeautiful.util.ActivityUtil;
import com.m520it.mostbeautiful.util.SPUtil;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.m520it.mostbeautiful.R.id.username_tv;

/**
 * @author SmRo
 */
public class EditorActivity extends BaseActivity implements View.OnClickListener {

    private TextView mUsernameTv;
    private TextView mSex;
    private TextView mBirthTv;
    private TextView mInfoEmailTv;
    private TextView mInfoPhoneTv;
    private Button out;
    private ImageView mCircleBackNormal;
    private CircleImageView mPortraitCiv;
    private RelativeLayout mChangeIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initdatas();
    }

    @Override
    protected void initUI() {
        setContentView(R.layout.mine_editor_activity);
        transparentHeading();
        mChangeIcon = (RelativeLayout)findViewById(R.id.change_icon);
        mChangeIcon.setOnClickListener(this);
        mUsernameTv = (TextView)findViewById(username_tv);
        mSex = (TextView)findViewById(R.id.sex);
        mBirthTv = (TextView)findViewById(R.id.birth_tv);
        mInfoEmailTv = (TextView)findViewById(R.id.info_email_tv);
        mInfoPhoneTv = (TextView)findViewById(R.id.info_phone_tv);
        out = (Button) findViewById(R.id.out);
        out.setOnClickListener(this);
        mCircleBackNormal = (ImageView)findViewById(R.id.ic_circle_back_normal);
        mCircleBackNormal.setOnClickListener(this);
        mPortraitCiv = (CircleImageView)findViewById(R.id.mine_portrait_civ);

    }
    /***----回显---***/
    private void initdatas() {
        /***----获取数据---***/
        String userName = SPUtil.getString(this, Consts.USERNAME);
        String pwd =SPUtil.getString(this, Consts.PASSWORD);
        String sex =SPUtil.getString(this,Consts.SEX);
        String mYear =SPUtil.getString(this,Consts.YEAR);
        String mMonth =SPUtil.getString(this,Consts.MONTH);
        String mDay =SPUtil.getString(this,Consts.DAY);
        String email =SPUtil.getString(this,Consts.EMAIL);
        String phone =SPUtil.getString(this,Consts.PHONE);
        /***----判断是否有用户---***/
        if(!ifValueWasEmpty(userName,pwd,sex,mYear,mMonth,mDay,email,phone)){
            mPortraitCiv.setImageResource(SPUtil.getInt(this,Consts.USERIC));
            mUsernameTv.setText(userName);
            mSex.setText(sex);
            mBirthTv.setText(mYear+"-"+mMonth+"-"+mDay);
            mInfoEmailTv.setText(email);
            mInfoPhoneTv.setText(phone);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_circle_back_normal :
                /**-- 回退到MineFragment页面的同时  更新登陆等更改的个人信息 --**/
//                ActivityUtil.start(this,MainActivity.class,true);
                finish();
                // TODO: 2016/11/9 注意 此处可能还缺少从设置页面跳转到这个页面时，默认的显示MineFragment页面
                break;
            case R.id.change_icon :
                /**-- 更改头像 --**/
//                tip("更换头像");
                /***----选择头像---***/
                int icId = R.drawable.girl1;
                SPUtil.putInt(getApplicationContext(),Consts.USERIC,icId);
                mPortraitCiv.setImageResource(icId);
                break;
            case R.id.out:
                ActivityUtil.start(this,ConfirmActivity.class,true);
                break;
        }
    }


}
