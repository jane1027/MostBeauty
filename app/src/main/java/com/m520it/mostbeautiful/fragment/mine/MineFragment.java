package com.m520it.mostbeautiful.fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.activity.ConfirmActivity;
import com.m520it.mostbeautiful.activity.MimeSettingActivity;
import com.m520it.mostbeautiful.activity.SuggestionActivity;
import com.m520it.mostbeautiful.cons.Consts;
import com.m520it.mostbeautiful.fragment.BaseFragment;
import com.m520it.mostbeautiful.util.ActivityUtil;
import com.m520it.mostbeautiful.util.SPUtil;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {

    private ImageView mMeSetting;
    private CircleImageView mMinePortraitCiv;
    private int mIcId;
    private RelativeLayout paint;
    private RelativeLayout design;
    private RelativeLayout wish;
    private RelativeLayout message;
    private RelativeLayout mSuggestQuestion;
    private RelativeLayout mOtherApp;
    private FragmentManager mFragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, null, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initUI();
        initDatas();
        initVent();
    }


    @Override
    public void onResume() {
        super.onResume();
        mMinePortraitCiv.setImageResource(SPUtil.getInt(getActivity(),Consts.USERIC));
    }

    private void initVent() {

    }

    @Override
    protected void initUI() {
        /**-- 设置id --**/
        mMeSetting = (ImageView) getActivity().findViewById(R.id.me_setting);
        mMeSetting.setOnClickListener(this);

        /**--头像id --**/
        mMinePortraitCiv = (CircleImageView) getActivity().findViewById(R.id.mine_portrait_civ);
        mMinePortraitCiv.setOnClickListener(this);
        
        /***----内容列表---***/
        paint = (RelativeLayout) getActivity().findViewById(R.id.paint);
        paint.setOnClickListener(this);
        design = (RelativeLayout) getActivity().findViewById(R.id.design);
        design.setOnClickListener(this);
        wish = (RelativeLayout) getActivity().findViewById(R.id.wish);
        wish.setOnClickListener(this);
        message = (RelativeLayout) getActivity().findViewById(R.id.message);
        message.setOnClickListener(this);
        mSuggestQuestion = (RelativeLayout) getActivity().findViewById(R.id.suggest_question);
        mSuggestQuestion.setOnClickListener(this);
        mOtherApp = (RelativeLayout) getActivity().findViewById(R.id.other_app);
        mOtherApp.setOnClickListener(this);
        mFragmentManager = getActivity().getSupportFragmentManager();


    }
    private void initDatas() {
        String userName = SPUtil.getString(getActivity(),Consts.USERNAME);
        if(userName.isEmpty()){
            return;
        }
        mIcId = SPUtil.getInt(getActivity(), Consts.USERIC);
        mMinePortraitCiv.setImageResource(mIcId);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.me_setting:
                /**-- 跳转到个人设置页面 --**/
                ActivityUtil.start(getActivity(), MimeSettingActivity.class, false);
                break;
            case R.id.mine_portrait_civ:
                /**-- 点击头像判断是否已经登录  是的话 进入编辑资料页面  否的话  进入登录页面 --**/
                String username = SPUtil.getString(getActivity(),Consts.USERNAME);
                if (TextUtils.isEmpty(username)) {
                    ActivityUtil.start(getActivity(), ConfirmActivity.class, false);
                    return;
                }
                /**-- 跳转到个人设置页面 --**/
                ActivityUtil.start(getActivity(), MimeSettingActivity.class, false);
                break;
            case R.id.paint:
                Toast.makeText(getActivity(), "paint", Toast.LENGTH_SHORT).show();
//                transaction.replace(R.id.top_bar, new PaintFragment());
                break;
            case R.id.design:
                Toast.makeText(getActivity(), "design", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wish:
                Toast.makeText(getActivity(), "wish", Toast.LENGTH_SHORT).show();
                break;
            case R.id.message:
                Toast.makeText(getActivity(), "message", Toast.LENGTH_SHORT).show();
                break;
            case R.id.suggest_question:
//                Toast.makeText(getActivity(), "mSuggestQuestion", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SuggestionActivity.class);
                startActivity(intent);
                break;
            case R.id.other_app:
                Toast.makeText(getActivity(), "other_app", Toast.LENGTH_SHORT).show();
                break;
        }
        transaction.commit();
    }
}
