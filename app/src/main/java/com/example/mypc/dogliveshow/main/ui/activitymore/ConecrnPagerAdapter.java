package com.example.mypc.dogliveshow.main.ui.activitymore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by MyPC on 2016/8/16.
 */
public class ConecrnPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;
    public ConecrnPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.mList= list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
