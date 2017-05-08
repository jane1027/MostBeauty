package com.m520it.mostbeautiful.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.cons.Consts;
import com.m520it.mostbeautiful.util.ActivityUtil;
import com.m520it.mostbeautiful.util.SPUtil;


public class RegisterActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText mRegisterUserEt;
    private EditText mRegisterPasswordEt;
    private EditText mConfirmPasswordEt;
    private RadioGroup mSex;
    private Spinner mRegisterYearSp;
    private Spinner mRegisterDaySp;
    private Spinner mRegisterMonSp;
    private EditText mRegisterEmailEt;
    private EditText mRegisterPhoneEt;
    private Button mRegisterConfirmBtn;
    private Button mRegisterCancelBtn;
    private String mYear;
    private String mMonth;
    private String mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_register);
        transparentHeading();
        mRegisterUserEt = (EditText)findViewById(R.id.register_user_et);
        mRegisterPasswordEt = (EditText)findViewById(R.id.register_password_et);
        mConfirmPasswordEt = (EditText)findViewById(R.id.confirm_password_et);

        mSex = (RadioGroup)findViewById(R.id.sex);

        mRegisterYearSp = (Spinner)findViewById(R.id.register_year_sp);
        mRegisterYearSp.setOnItemSelectedListener(this);
        mRegisterMonSp = (Spinner)findViewById(R.id.register_mon_sp);
        mRegisterMonSp.setOnItemSelectedListener(this);
        mRegisterDaySp = (Spinner)findViewById(R.id.register_day_sp);
        mRegisterDaySp.setOnItemSelectedListener(this);

        mRegisterEmailEt = (EditText)findViewById(R.id.register_email_et);
        mRegisterPhoneEt = (EditText)findViewById(R.id.register_phone_et);

        mRegisterConfirmBtn = (Button)findViewById(R.id.register_confirm_btn);
        mRegisterConfirmBtn.setOnClickListener(this);
        mRegisterCancelBtn = (Button)findViewById(R.id.register_cancel_btn);
        mRegisterCancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_confirm_btn:
                /***----点击确定，注册完成---***/
                String userName = mRegisterUserEt.getText().toString();//用户名
                String pwd = mRegisterPasswordEt.getText().toString();//密码
                String secondPwd = mConfirmPasswordEt.getText().toString();//确认密码
                int checkedRadioButtonId = mSex.getCheckedRadioButtonId();//性别
                String sex = "男";
                if(checkedRadioButtonId==R.id.female){
                    sex = "女";
                }
                String email = mRegisterEmailEt.getText().toString();//email
                /***----email跟电话应该用正则表达式去判断，现在暂时没做---***/

                String phone = mRegisterPhoneEt.getText().toString();//电话
                /***----判断是否为空---***/
                if(ifValueWasEmpty(userName,pwd,secondPwd,mYear,mMonth,mDay,email,phone)){
                    tip("请将信息填写完整");
                    return;
                }
                /***----判断两次输入的密码是否一致---***/
                if(!pwd.equals(secondPwd)){
                    tip("两次密码输入不一致");
                    return;
                }

                /***----不为空保存到SharePreference---***/
                SPUtil.putString(getApplicationContext(),Consts.USERNAME,userName);
                SPUtil.putString(getApplicationContext(), Consts.PASSWORD,pwd);
                SPUtil.putString(getApplicationContext(),Consts.SEX,sex);
                SPUtil.putString(getApplicationContext(),Consts.YEAR,mYear);
                SPUtil.putString(getApplicationContext(),Consts.MONTH,mMonth);
                SPUtil.putString(getApplicationContext(),Consts.DAY,mDay);
                SPUtil.putString(getApplicationContext(),Consts.EMAIL,email);
                SPUtil.putString(getApplicationContext(),Consts.PHONE,phone);
                
                /***----注册成功跳转到登录页面---***/
                ActivityUtil.start(this,ConfirmActivity.class,true);
                break;
            case R.id.register_cancel_btn:
                /***----取消跳转到登录页面---***/
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case  R.id.register_year_sp:
                mYear = mRegisterYearSp.getSelectedItem().toString();
                Toast.makeText(RegisterActivity.this, "mYear="+mYear, Toast.LENGTH_SHORT).show();
                mRegisterYearSp.setSelection(position,true);
                break;
            case  R.id.register_mon_sp:
                mMonth = mRegisterMonSp.getSelectedItem().toString();
                Toast.makeText(RegisterActivity.this, "mMonth="+mMonth, Toast.LENGTH_SHORT).show();
                mRegisterMonSp.setSelection(position,true);
                break;
            case  R.id.register_day_sp:
                mDay = mRegisterDaySp.getSelectedItem().toString();
                Toast.makeText(RegisterActivity.this, "mDay="+mDay, Toast.LENGTH_SHORT).show();
                mRegisterDaySp.setSelection(position,true);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
