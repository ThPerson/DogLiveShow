package com.example.mypc.dogliveshow.main.ui.homepage.homepagehead;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.homepagetitle.DataListTitleBean;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageHeadFragment extends Fragment implements HomePageHeadContract.View {


    public HomePageHeadFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_page_head, container, false);
    }


    @Override
    public void onSuccess(List<DataListTitleBean> list) {

    }

    @Override
    public void onFild(String msg) {

    }
}
