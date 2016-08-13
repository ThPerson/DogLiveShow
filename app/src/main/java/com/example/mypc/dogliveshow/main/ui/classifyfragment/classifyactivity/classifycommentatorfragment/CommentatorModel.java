package com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity.classifycommentatorfragment;

import com.example.mypc.dogliveshow.bean.classifybean.commentatorbean.CommentatorBean;
import com.example.mypc.dogliveshow.utils.classifyutils.commentutils.Commentatorutil;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/13.
 */
public class CommentatorModel implements CommentatorContract.Model {

    @Override
    public void getCommentator(HashMap<String, String> params, Commentatorutil.CommentCallback<CommentatorBean> callback) {
        Commentatorutil.getInstance().getCommentatorData(params,callback);
    }
}
