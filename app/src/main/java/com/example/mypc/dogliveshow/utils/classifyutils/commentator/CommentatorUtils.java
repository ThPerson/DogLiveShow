package com.example.mypc.dogliveshow.utils.classifyutils.commentator;

import com.example.mypc.dogliveshow.bean.classifybean.commentbean.CommentBean;
import com.example.mypc.dogliveshow.utils.classifyutils.RetrofitHelper;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/14.
 */
public class CommentatorUtils {
    private static CommentatorUtils ourInstance = new CommentatorUtils();

    public static CommentatorUtils getInstance() {
        return ourInstance;
    }

    private CommentatorUtils() {
    }
    public interface CommenCallback<T>{
        public void onSuccess(T t);
        public void onFail();
    }
    public void getCommentatorData(HashMap<String,String> params, final CommenCallback<CommentBean> commentBeanCommenCallback){
        Call<CommentBean> commentBeanCall = RetrofitHelper
                .getInstance()
                .creatRetrofitService(ICommentatorService.class)
                .getCommentatorBean(params);
        commentBeanCall.enqueue(new Callback<CommentBean>() {
            @Override
            public void onResponse(Call<CommentBean> call, Response<CommentBean> response) {
                commentBeanCommenCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<CommentBean> call, Throwable t) {
                commentBeanCommenCallback.onFail();
            }
        });
    }
}
