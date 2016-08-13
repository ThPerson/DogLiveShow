package com.example.mypc.dogliveshow.main.ui.homepage.homepagereclive;

import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.utils.homepagereclive.HomeRecLiveHttpUtils;

import java.util.HashMap;


/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageRecLiveModel implements HomePageRecLiveContract.Model {



    @Override
    public void getData(HashMap<String, String> params, HomeRecLiveHttpUtils.HttpCallback<HomePage> callback) {
        HomeRecLiveHttpUtils.getInstance().getHomePageTitleData(params, callback);
    }
}
