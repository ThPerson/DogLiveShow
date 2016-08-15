package com.example.mypc.dogliveshow.main.ui.mydog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.dogliveshow.R;

/**
 * Created by JiaFan on 2016/8/14 12:56
 * QQ：1319662955
 */
public class DownloadingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_download, container, false);
        return fragmentView;
    }
}
