package com.example.mypc.dogliveshow.main.ui.homepage.homepagehotvideo;

import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.utils.homepagehot.HomeHotHttpUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageHotPresenter implements HomePageHotContract.Persenter{

    private HomePageHotContract.View view;
    private HomePageHotContract.Model model;

    public HomePageHotPresenter(HomePageHotContract.View view, HomePageHotContract.Model model){
        this.view = view;
        this.model = model;
    }



    @Override
    public void getData(HashMap<String,String> params) {
        model.getData(params, new HomeHotHttpUtils.HttpCallback<HomePage>() {

            @Override
            public void onSucess(HomePage homePage) {
                view.onSuccess(homePage);
            }

            @Override
            public void onFail() {
                view.onFild("网络连接错误...");
            }
        });
    }
}
