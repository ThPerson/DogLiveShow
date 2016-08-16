package com.example.mypc.dogliveshow.utils.mydogutils;

import android.util.Log;

import com.example.mypc.dogliveshow.bean.maydogbean.PlatFormBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by JiaFan on 2016/8/15 14:50
 * QQ：1319662955
 */
public class HttpUtils {
    private static HttpUtils instance;

    private HttpUtils(){
    }

    public static synchronized HttpUtils getInstance(){
        if (instance == null){
            instance = new HttpUtils();
        }
        return instance;
    }

    public interface HttpCallBack<T> {
        public void onSucess(T t);

        public void onFail();
    }
    public void getPlatFormData(HashMap<String,String> params, final HttpCallBack<List<PlatFormBean>> platFormBeanHttpCallBack){
        Call<List<PlatFormBean>> platFormBean = RetrofitHelper
                .getInstance()
                .creatRetrfitService(PlatFormService.class)
                .getPlatForm(params);
        platFormBean.enqueue(new Callback<List<PlatFormBean>>() {


            @Override
            public void onResponse(Call<List<PlatFormBean>> call, Response<List<PlatFormBean>> response) {

                List<PlatFormBean> platFormBeen = response.body();
                platFormBeanHttpCallBack.onSucess(platFormBeen);
            }

            @Override
            public void onFailure(Call<List<PlatFormBean>> call, Throwable t) {
                platFormBeanHttpCallBack.onFail();
            }
        });
    }

}

