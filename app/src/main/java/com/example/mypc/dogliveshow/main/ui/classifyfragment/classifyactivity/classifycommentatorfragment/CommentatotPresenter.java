package com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity.classifycommentatorfragment;

import com.example.mypc.dogliveshow.bean.classifybean.commentbean.CommentBean;
import com.example.mypc.dogliveshow.utils.classifyutils.commentator.CommentatorUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/14.
 */
public class CommentatotPresenter implements CommentatorContract.Presenter {
    private CommentatorContract.View view;
    private CommentatorContract.Model model;
    public CommentatotPresenter(CommentatorContract.View view, CommentatorContract.Model model){
        this.view = view;
        this.model = model;
    }
    @Override
    public void initData(HashMap<String, String> params) {
        model.getCommentator(params, new CommentatorUtils.CommenCallback<CommentBean>() {
            @Override
            public void onSuccess(CommentBean commentBean) {
                view.onSuccessGetCommentator(commentBean.getCommentators());
            }

            @Override
            public void onFail() {
                view.onFailGetCommentator("网络连接错误...");
            }
        });
    }
}
