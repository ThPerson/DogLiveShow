package com.example.mypc.dogliveshow.utils.classifyutils.commentutils;

import com.example.mypc.dogliveshow.bean.classifybean.commentatorbean.CommentatorBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/13.
 */
public interface ICommentator {
    //栏目分类-->直播接口
    @GET(UrlConfig.Path.CLASSIFY_COMMENTATOR_URL)
    Call<CommentatorBean> getCommentatorBean(@QueryMap() HashMap<String,String> params);
}
