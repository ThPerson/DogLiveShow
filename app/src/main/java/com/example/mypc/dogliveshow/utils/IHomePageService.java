package com.example.mypc.dogliveshow.utils;

import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/12.
 */
public interface IHomePageService {
    @GET(UrlConfig.Path.HOMEPAGE_URL)
    Call<HomePage> getHomePageTitleData(@QueryMap() HashMap<String, String> params);
}
