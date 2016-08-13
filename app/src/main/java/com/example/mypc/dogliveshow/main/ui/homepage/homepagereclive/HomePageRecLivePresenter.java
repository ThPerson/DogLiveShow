package com.example.mypc.dogliveshow.main.ui.homepage.homepagereclive;

import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.utils.homepagereclive.HomeRecLiveHttpUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageRecLivePresenter implements HomePageRecLiveContract.Persenter{

    private HomePageRecLiveContract.View view;
    private HomePageRecLiveContract.Model model;

    public HomePageRecLivePresenter(HomePageRecLiveContract.View view, HomePageRecLiveContract.Model model){
        this.view = view;
        this.model = model;
    }



    @Override
    public void getData(HashMap<String,String> params) {
        model.getData(params, new HomeRecLiveHttpUtils.HttpCallback<HomePage>() {

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
