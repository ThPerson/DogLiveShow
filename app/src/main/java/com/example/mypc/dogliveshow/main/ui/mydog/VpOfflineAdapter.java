package com.example.mypc.dogliveshow.main.ui.mydog;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by JiaFan on 2016/8/14 11:44
 * QQ：1319662955
 */
public class VpOfflineAdapter extends FragmentPagerAdapter{
    private List<String> mList;
    public VpOfflineAdapter(FragmentManager fm, List<String> mList) {
        super(fm);
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = FragmentFactory.createFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
