package com.example.mypc.dogliveshow.utils.headlineutils;

import com.example.mypc.dogliveshow.bean.headlinebean.HeadLineBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2016/8/3.
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
    public void getHeadLineData(HashMap<String,String> params, final HttpCallBack<HeadLineBean> headLineBeanHttpCallBack){
        Call<HeadLineBean> headLineBean = RetrofitHelper
                .getInstance()
                .creatRetrfitService(HeadLineService.class)
                .getHeadLine(params);
        headLineBean.enqueue(new Callback<HeadLineBean>() {
            @Override
            public void onResponse(Call<HeadLineBean> call, Response<HeadLineBean> response) {
                HeadLineBean headLineBean = response.body();
                headLineBeanHttpCallBack.onSucess(response.body());
            }

            @Override
            public void onFailure(Call<HeadLineBean> call, Throwable t) {
                headLineBeanHttpCallBack.onFail();
            }
        });
    }

}
