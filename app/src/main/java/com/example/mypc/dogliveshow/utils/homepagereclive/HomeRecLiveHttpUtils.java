package com.example.mypc.dogliveshow.utils.homepagereclive;

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
public class HomeRecLiveHttpUtils {
    private static HomeRecLiveHttpUtils ourInstance = new HomeRecLiveHttpUtils();

    public static HomeRecLiveHttpUtils getInstance() {
        return ourInstance;
    }

    private HomeRecLiveHttpUtils() {
    }

    public interface HttpCallback<T>{
       void onSucess(T t);
       void onFail();
    }
    public void getHomePageTitleData(HashMap<String,String> params, final HttpCallback<HomePage> beanHttpCallback){
        Call<HomePage> homePageTitleBeanCall = HomePageRecLiveHelper
                .getInstance()
                .creatRetrfitService(IHomePageService.class)
                .getHomePageTitleData(params);
        homePageTitleBeanCall.enqueue(new Callback<HomePage>() {
            @Override
            public void onResponse(Call<HomePage> call, Response<HomePage> response) {
                beanHttpCallback.onSucess(response.body());
            }



            @Override
            public void onFailure(Call<HomePage> call, Throwable t) {
                beanHttpCallback.onFail();
            }
        });
    }
}
