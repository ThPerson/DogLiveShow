package com.example.mypc.dogliveshow.main.ui.homepage.homepagehead;

import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.utils.homepagehade.HomeHttpUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageHeadPresenter implements HomePageHeadContract.Persenter{

    private HomePageHeadContract.View view;
    private HomePageHeadContract.Model model;

    public HomePageHeadPresenter(HomePageHeadContract.View view,HomePageHeadContract.Model model){
        this.view = view;
        this.model = model;
    }



    @Override
    public void getData(HashMap<String,String> params) {
        model.getData(params, new HomeHttpUtils.HttpCallback<HomePage>() {

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
