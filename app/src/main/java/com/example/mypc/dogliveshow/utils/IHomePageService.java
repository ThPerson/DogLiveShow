package com.example.mypc.dogliveshow.utils;

import com.example.mypc.dogliveshow.bean.homepagetitle.DataListTitleBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/12.
 */
public interface IHomePageService {
    @GET(UrlConfig.Path.CLASSIFY_URL)
    Call<List<DataListTitleBean>> getHomePageTitleData(@QueryMap() HashMap<String, String> params);
}
