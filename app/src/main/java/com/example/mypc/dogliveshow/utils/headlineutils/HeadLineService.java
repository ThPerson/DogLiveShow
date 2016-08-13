package com.example.mypc.dogliveshow.utils.headlineutils;

import com.example.mypc.dogliveshow.bean.headlinebean.HeadLineBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by JiaFan on 2016/8/12 18:05
 * QQ：1319662955
 */
public interface HeadLineService {
    @GET(UrlConfig.Path.HEAD_LINE_URL)
    Call<HeadLineBean> getHeadLine(@QueryMap() HashMap<String, String> params);
}
