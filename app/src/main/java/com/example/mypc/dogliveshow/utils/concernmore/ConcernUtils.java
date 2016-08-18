package com.example.mypc.dogliveshow.utils.concernmore;

import com.example.mypc.dogliveshow.bean.moreanchor.AnchorBean;
import com.example.mypc.dogliveshow.utils.IHomePageService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/12.
 */
public class ConcernUtils {
    private static ConcernUtils ourInstance = new ConcernUtils();

    public static ConcernUtils getInstance() {
        return ourInstance;
    }

    private ConcernUtils() {
    }

    public interface HttpCallback<T>{
       void onSucess(T t);
       void onFail();
    }
    public void getConcernData(HashMap<String,String> params, final HttpCallback<AnchorBean> beanHttpCallback){
        Call<AnchorBean> AnchorBeanCall = ConcernHelper
                .getInstance()
                .creatRetrfitService(IHomePageService.class)
                .getAnchorBeanData(params);
        AnchorBeanCall.enqueue(new Callback<AnchorBean>() {
            @Override
            public void onResponse(Call<AnchorBean> call, Response<AnchorBean> response) {
                beanHttpCallback.onSucess(response.body());
            }



            @Override
            public void onFailure(Call<AnchorBean> call, Throwable t) {

                beanHttpCallback.onFail();
            }
        });
    }
}
