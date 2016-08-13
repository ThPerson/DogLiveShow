package com.example.mypc.dogliveshow.utils.classifyutils;

import com.example.mypc.dogliveshow.bean.classifybean.ClassifyBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/12.
 */
public interface IClassifyService {
    @GET(UrlConfig.Path.CLASSIFY_URL)
    Call<ClassifyBean> getClassifyBean(@QueryMap() HashMap<String,String> params);


}
