package com.example.mypc.dogliveshow.utils.mydogutils;

import com.example.mypc.dogliveshow.bean.maydogbean.PlatFormBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by JiaFan on 2016/8/15 14:38
 * QQ：1319662955
 */
public interface PlatFormService {
    @GET(UrlConfig.Path.PLAT_FORM_URL)
    Call<List<PlatFormBean>> getPlatForm(@QueryMap() HashMap<String, String> params);
}
