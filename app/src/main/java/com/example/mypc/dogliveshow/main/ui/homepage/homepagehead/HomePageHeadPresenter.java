package com.example.mypc.dogliveshow.main.ui.homepage.homepagehead;

import com.example.mypc.dogliveshow.bean.homepagetitle.DataListTitleBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public void getData() {
        HashMap<String,String> params = new HashMap<>();
        params.put(UrlConfig.HomePageTitleKey.TYPE,"json");
        params.put(UrlConfig.HomePageTitleKey.DATATYPE,"0");
        params.put(UrlConfig.HomePageTitleKey.PAGENO2,"1");
        params.put(UrlConfig.HomePageTitleKey.PAGESIZE2,"6");
        params.put(UrlConfig.HomePageTitleKey.PAGENO3,"1");
        params.put(UrlConfig.HomePageTitleKey.PAGESIZE3,"100");
        params.put(UrlConfig.HomePageTitleKey.SYSTEM,"android");
        params.put(UrlConfig.HomePageTitleKey.VERSION,"3.1.0");
        params.put(UrlConfig.HomePageTitleKey.APPID,"ec1179d6bfd406ba4fac855010ee80c728df297d");

        model.getData(params, new Callback<List<DataListTitleBean>>() {
            @Override
            public void onResponse(Call<List<DataListTitleBean>> call, Response<List<DataListTitleBean>> response) {
                List<DataListTitleBean> titleBeen = response.body();
                view.onSuccess(titleBeen);
            }

            @Override
            public void onFailure(Call<List<DataListTitleBean>> call, Throwable t) {
                view.onFild("加载失败");
            }
        });
    }
}
