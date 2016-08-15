package com.example.mypc.dogliveshow.utils.classifyutils.commentator;

import com.example.mypc.dogliveshow.bean.classifybean.commentbean.CommentBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/14.
 */
public interface ICommentatorService {
    @GET(UrlConfig.Path.CLASSIFY_COMMENTATOR_URL)
    Call<CommentBean> getCommentatorBean(@QueryMap HashMap<String,String> params);
}
