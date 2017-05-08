package com.m520it.mostbeautiful.bean;

import android.support.v4.app.Fragment;

/**
 * @author 温思园
 * @ 2016/11/9 19:44
 * @ ${有物}
 */

public class HaveThingFragmentBean {

    Fragment mFragment;
    String mTitle;

    public HaveThingFragmentBean(Fragment fragment, String title) {
        mFragment = fragment;
        this.mTitle = title;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }
}
