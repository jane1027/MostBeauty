package com.m520it.mostbeautiful.fragment.havething;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.m520it.mostbeautiful.Adapter.HaveThingAdapter;
import com.m520it.mostbeautiful.R;
import com.m520it.mostbeautiful.bean.HaveThingFragmentBean;
import com.m520it.mostbeautiful.fragment.BaseFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

/**
 * 有物
 */
public class HaveThingFragment extends BaseFragment {

    private ArrayList<HaveThingFragmentBean> mPagers;
    private FragmentActivity mActivity;
    private SmartTabLayout mHaveThingStl;
    private ViewPager mHavethingVp;
    private HaveThingAdapter mHaveThingAdapter;
    private View mInflate;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        if(mInflate==null){
//            mInflate = inflater.inflate(R.layout.fragment_have_thing, container, false);
//        }
            mInflate = inflater.inflate(R.layout.fragment_have_thing, container, false);
        return mInflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
        mPagers = new ArrayList<>();
        String[] titles = getResources().getStringArray(R.array.havething_titles);
        for (int i = 0; i < titles.length; i++) {
            HaveThingFragmentBean infoBean = null;
            switch (i) {
                case 0 :
                    infoBean = new HaveThingFragmentBean(new HaveThingDailyFragment(),titles[i]);
                    break;
                case 1 :
                    infoBean = new HaveThingFragmentBean(new HaveThingHeadgearFragment(),titles[i]);
                    break;
                case 2:
                    infoBean = new HaveThingFragmentBean(new HaveThingBagFragment(),titles[i]);
                    break;
                case 3 :
                    infoBean = new HaveThingFragmentBean(new HaveThingShoeFragment(),titles[i]);
                    break;
                case 4:
                    infoBean = new HaveThingFragmentBean(new HaveThingMenFragment(),titles[i]);
                    break;
                case 5 :
                    infoBean = new HaveThingFragmentBean(new HaveThingOrnamentFragment(),titles[i]);
                    break;
                case 6 :
                    infoBean = new HaveThingFragmentBean(new HaveThingElseFragment(),titles[i]);
                    break;
            }
            mPagers.add(infoBean);
        }
//        mHaveThingAdapter = new HaveThingAdapter(getChildFragmentManager(),mPagers);
        mHaveThingAdapter = new HaveThingAdapter(getFragmentManager(),mPagers);
        mHavethingVp.setAdapter(mHaveThingAdapter);
        //自动绑定数据
        mHaveThingStl.setViewPager(mHavethingVp);

    }

    @Override
    protected void initUI() {
        mActivity = getActivity();
        mHaveThingStl = (SmartTabLayout) mActivity.findViewById(R.id.havething_stl);
        mHavethingVp = (ViewPager) getActivity().findViewById(R.id.havething_vp);
    }
}
