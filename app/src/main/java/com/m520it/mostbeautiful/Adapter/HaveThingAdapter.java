package com.m520it.mostbeautiful.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.m520it.mostbeautiful.bean.HaveThingFragmentBean;

import java.util.ArrayList;

/**
 * @author 温思园
 * @ 2016/11/9 20:11
 * @ ${}
 */

public class HaveThingAdapter extends FragmentPagerAdapter {

    private ArrayList<HaveThingFragmentBean> mPagers;
    public HaveThingAdapter(FragmentManager fm,ArrayList<HaveThingFragmentBean> pagers) {
        super(fm);
        this.mPagers = pagers;
    }

    @Override
    public Fragment getItem(int position) {
        return mPagers.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mPagers.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPagers.get(position).getTitle();
    }
}
