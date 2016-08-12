package com.example.mypc.dogliveshow.main.ui.homepage.homepagehead;

import com.example.mypc.dogliveshow.bean.homepagetitle.DataListTitleBean;
import com.example.mypc.dogliveshow.utils.homepagehade.HomePageHeadHelper;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;


/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageHeadModel implements HomePageHeadContract.Model {

    @Override
    public void getData(HashMap<String, String> params, Callback<List<DataListTitleBean>> callback) {
        HomePageHeadHelper.newInstance().getService().getHomePageTitleData(params).enqueue(callback);
    }


}
