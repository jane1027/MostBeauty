package com.m520it.mostbeautiful.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.cons.Consts;
import com.m520it.mostbeautiful.util.ActivityUtil;
import com.m520it.mostbeautiful.util.SPUtil;

/**
 * @author SmRo
 */
public class ConfirmActivity extends BaseActivity implements View.OnClickListener {

    private TextView mRegisterTv;
    private EditText mUserEt;
    private EditText mPasswordEt;
    private Button mCancelBtn;
    private Button mConfirmBtn;
    private String mUserName;
    private String mPassword;

    // TODO: 2016/11/9 做到登录页面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initDatas();
    }
    /***----回显---***/
    private void initDatas() {
        /***----获取数据---***/
        mUserName = SPUtil.getString(this,Consts.USERNAME);
        mPassword =SPUtil.getString(this, Consts.PASSWORD);
        /***----判断是否有用户---***/
        if(!ifValueWasEmpty(mUserName,mPassword)){
            mUserEt.setText(mUserName);
            mPasswordEt.setText(mPassword);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        initDatas();
    }

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_confirm);
        transparentHeading();
        mRegisterTv = (TextView) findViewById(R.id.register_tv);
        mRegisterTv.setOnClickListener(this);

        mUserEt = (EditText) findViewById(R.id.user_et);
        mPasswordEt = (EditText) findViewById(R.id.password_et);

        mConfirmBtn = (Button) findViewById(R.id.confirm_btn);
        mConfirmBtn.setOnClickListener(this);
        mCancelBtn = (Button) findViewById(R.id.cancel_btn);
        mCancelBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_tv:
                /**-- 跳转到注册页面 --**/
                ActivityUtil.start(this, RegisterActivity.class, false);
                break;
            case R.id.confirm_btn:
                /**-- 获取账号 密码 确认账号密码 --**/
                mUserName = mUserEt.getText().toString();
                mPassword = mPasswordEt.getText().toString();
                boolean ifValueWasEmpty = ifValueWasEmpty(mUserName, mPassword);
                if(ifValueWasEmpty) {
                    Toast.makeText(ConfirmActivity.this, "请将账号和密码填写完整", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean isIfConfirmName = mUserName.equals(SPUtil.getString(this, Consts.USERNAME));
                boolean isIfConfirmPwd = mPassword.equals(SPUtil.getString(this, Consts.PASSWORD));
                if(isIfConfirmName&&isIfConfirmPwd) {
                    tip("登录成功");
                    SPUtil.putString(this,Consts.USERNAME,mUserName);
                    SPUtil.putString(this,Consts.PASSWORD,mPassword);
                    ActivityUtil.start(this,MainActivity.class,true);
                }else{
                    tip("密码错误，请确认后输入");
                }
                break;
            case R.id.cancel_btn:
                /**-- 取消后销毁此页面 --**/
                finish();
                break;
        }
    }


}
