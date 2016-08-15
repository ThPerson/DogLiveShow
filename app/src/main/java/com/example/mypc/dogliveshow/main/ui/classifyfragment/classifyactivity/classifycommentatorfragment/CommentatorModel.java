package com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity.classifycommentatorfragment;

import com.example.mypc.dogliveshow.bean.classifybean.commentbean.CommentBean;
import com.example.mypc.dogliveshow.utils.classifyutils.commentator.CommentatorUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/14.
 */
public class CommentatorModel implements CommentatorContract.Model {
    @Override
    public void getCommentator(HashMap<String, String> params, CommentatorUtils.CommenCallback<CommentBean> callback) {
        CommentatorUtils.getInstance().getCommentatorData(params,callback);
    }
}
