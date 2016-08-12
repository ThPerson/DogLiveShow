package com.example.mypc.dogliveshow.utils.homepagehade;

import android.util.Log;

import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.utils.IHomePageService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/12.
 */
public class HomeHttpUtils {
    private static HomeHttpUtils ourInstance = new HomeHttpUtils();

    public static HomeHttpUtils getInstance() {
        return ourInstance;
    }

    private HomeHttpUtils() {
    }

    public interface HttpCallback<T>{
       void onSucess(T t);
       void onFail();
    }
    public void getHomePageTitleData(HashMap<String,String> params, final HttpCallback<HomePage> beanHttpCallback){
        Call<HomePage> homePageTitleBeanCall = HomePageHeadHelper
                .getInstance()
                .creatRetrfitService(IHomePageService.class)
                .getHomePageTitleData(params);
        homePageTitleBeanCall.enqueue(new Callback<HomePage>() {
            @Override
            public void onResponse(Call<HomePage> call, Response<HomePage> response) {
                HomePage body = response.body();
                beanHttpCallback.onSucess(response.body());
            }



            @Override
            public void onFailure(Call<HomePage> call, Throwable t) {
                beanHttpCallback.onFail();
            }
        });
    }
}
