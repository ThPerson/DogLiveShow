package com.example.mypc.dogliveshow.utils.homepagehade;

import com.example.mypc.dogliveshow.config.UrlConfig;
import com.example.mypc.dogliveshow.utils.IHomePageService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageHeadHelper {
    private static HomePageHeadHelper helper;
    private final Retrofit retrofit;
    private final IHomePageService service;

    private HomePageHeadHelper(){
        Gson gson = new GsonBuilder().serializeNulls().create();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(UrlConfig.Path.BASE_URL)
                .build();

        service = retrofit.create(IHomePageService.class);
    }
    public IHomePageService getService(){
        return service;
    }
    public static synchronized HomePageHeadHelper newInstance(){
        if (helper == null){
            helper = new HomePageHeadHelper();
        }
        return helper;
    }
}
