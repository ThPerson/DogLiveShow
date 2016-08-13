package com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity.classifycommentatorfragment;

import com.example.mypc.dogliveshow.bean.classifybean.commentatorbean.CommentatorBean;
import com.example.mypc.dogliveshow.utils.classifyutils.commentutils.Commentatorutil;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/13.
 */
public class CommentatorPresenter implements CommentatorContract.Presenter {

    private CommentatorContract.View view;
    private CommentatorContract.Model model;
    public CommentatorPresenter(CommentatorContract.View view, CommentatorContract.Model model){
        this.model = model;
        this.view = view;
    }

    @Override
    public void initData(HashMap<String, String> params) {
        model.getCommentator(params, new Commentatorutil.CommentCallback<CommentatorBean>() {
            @Override
            public void onSucess(CommentatorBean commentatorBean) {
                view.onSucessGetCommentator(commentatorBean.getCommentators());
            }

            @Override
            public void onFail() {
                view.onFailGetCommentator("网络连接错误");
            }
        });
    }
}
