package com.yubin.bianminzixun.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yubin.bianminzixun.ui.fragment.WelFragment;

/**
 * author : Yubin.Ying
 * time : 2018/12/12
 */
public class WelFragmentAdapter extends FragmentPagerAdapter {
    private final int pageCount = 3;

    public WelFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return WelFragment.newInstance(i);
    }

    @Override
    public int getCount() {
        return pageCount;
    }
}
