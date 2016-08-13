package com.example.mypc.dogliveshow.utils.classifyutils;

import com.example.mypc.dogliveshow.bean.classifybean.ClassifyBean;
import com.example.mypc.dogliveshow.utils.RetrofitHelper;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/12.
 */
public class HttpUtils {
    private static HttpUtils ourInstance = new HttpUtils();

    public static HttpUtils getInstance() {
        return ourInstance;
    }

    private HttpUtils() {
    }

    public interface HttpCallback<T>{
        public void onSucess(T t);
        public void onFail();
    }
    public void getClassifyData(HashMap<String,String> params, final HttpCallback<ClassifyBean> beanHttpCallback){
        Call<ClassifyBean> classifyBeanCall = RetrofitHelper
                .getInstance()
                .creatRetrfitService(IClassifyService.class)
                .getClassifyBean(params);
        classifyBeanCall.enqueue(new Callback<ClassifyBean>() {
            @Override
            public void onResponse(Call<ClassifyBean> call, Response<ClassifyBean> response) {
                beanHttpCallback.onSucess(response.body());
            }

            @Override
            public void onFailure(Call<ClassifyBean> call, Throwable t) {
                beanHttpCallback.onFail();
            }
        });
    }
}
