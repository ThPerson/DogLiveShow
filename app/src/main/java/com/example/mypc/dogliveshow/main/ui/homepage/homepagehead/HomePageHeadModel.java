package com.example.mypc.dogliveshow.main.ui.homepage.homepagehead;

import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.utils.homepagehade.HomeHttpUtils;

import java.util.HashMap;


/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageHeadModel implements HomePageHeadContract.Model {

    @Override
    public void getData(HashMap<String, String> params, HomeHttpUtils.HttpCallback<HomePage> callback) {
        HomeHttpUtils.getInstance().getHomePageTitleData(params, callback);
    }


}
