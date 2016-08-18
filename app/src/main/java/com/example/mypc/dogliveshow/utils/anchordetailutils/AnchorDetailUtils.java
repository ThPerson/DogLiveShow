package com.example.mypc.dogliveshow.utils.anchordetailutils;

import com.example.mypc.dogliveshow.bean.moreanchor.AnchorDetailBean;
import com.example.mypc.dogliveshow.utils.IHomePageService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/12.
 */
public class AnchorDetailUtils {
    private static AnchorDetailUtils ourInstance = new AnchorDetailUtils();

    public static AnchorDetailUtils getInstance() {
        return ourInstance;
    }

    private AnchorDetailUtils() {
    }

    public interface HttpCallback<T>{
       void onSucess(T t);
       void onFail();
    }
    public void getAnchorDetail(HashMap<String,String> params, final HttpCallback<AnchorDetailBean> beanHttpCallback){
        Call<AnchorDetailBean> AnchorBeanCall = AnchorDetailHelper
                .getInstance()
                .creatRetrfitService(IHomePageService.class)
                .getAnchorDetailBean(params);
        AnchorBeanCall.enqueue(new Callback<AnchorDetailBean>() {
            @Override
            public void onResponse(Call<AnchorDetailBean> call, Response<AnchorDetailBean> response) {
                beanHttpCallback.onSucess(response.body());
            }



            @Override
            public void onFailure(Call<AnchorDetailBean> call, Throwable t) {

                beanHttpCallback.onFail();
            }
        });
    }
}
