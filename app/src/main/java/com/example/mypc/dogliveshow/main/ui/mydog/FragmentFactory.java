package com.example.mypc.dogliveshow.main.ui.mydog;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

/**
 * Created by JiaFan on 2016/8/14 12:54
 * QQ：1319662955
 */
public class FragmentFactory {
    private static SparseArray<Fragment> fragments = new SparseArray<>();

    public static Fragment createFragment(int position){
        Fragment fragment = fragments.get(position);
        if (fragment == null){
            switch (position){
                case 0:
                    fragment = new DownloadingFragment();
                    break;
                case 1:
                    fragment = new DownloadOkFragment();
                    break;
            }
            fragments.put(position,fragment);
        }
        return fragment;
    }
}
