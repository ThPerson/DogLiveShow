package com.example.mypc.dogliveshow.utils.classifyutils.commentutils;

import com.example.mypc.dogliveshow.bean.classifybean.commentatorbean.CommentatorBean;
import com.example.mypc.dogliveshow.utils.RetrofitHelper;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/13.
 */
public class Commentatorutil {
    private static Commentatorutil ourInstance = new Commentatorutil();

    public static Commentatorutil getInstance() {
        return ourInstance;
    }

    private Commentatorutil() {
    }
    public interface CommentCallback<T>{
        public void onSucess(T t);
        public void onFail();
    }
    public void getCommentatorData(HashMap<String,String> params, final CommentCallback<CommentatorBean> beanCommentCallback){
        Call<CommentatorBean> beanCall = RetrofitHelper
                .getInstance()
                .creatRetrfitService(ICommentator.class)
                .getCommentatorBean(params);
        beanCall.enqueue(new Callback<CommentatorBean>() {
            @Override
            public void onResponse(Call<CommentatorBean> call, Response<CommentatorBean> response) {
                beanCommentCallback.onSucess(response.body());
            }

            @Override
            public void onFailure(Call<CommentatorBean> call, Throwable t) {
                beanCommentCallback.onFail();
            }
        });
    }
}
