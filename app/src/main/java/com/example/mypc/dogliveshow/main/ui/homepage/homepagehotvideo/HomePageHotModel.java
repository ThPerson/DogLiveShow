package com.example.mypc.dogliveshow.main.ui.homepage.homepagehotvideo;

import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.utils.homepagehot.HomeHotHttpUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageHotModel implements HomePageHotContract.Model {


    @Override
    public void getData(HashMap<String, String> params, HomeHotHttpUtils.HttpCallback<HomePage> callback) {
        HomeHotHttpUtils.getInstance().getHomePageHotData(params, callback);
    }
}
