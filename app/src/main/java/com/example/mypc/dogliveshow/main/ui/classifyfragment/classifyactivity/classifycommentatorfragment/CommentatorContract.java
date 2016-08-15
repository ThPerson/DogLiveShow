package com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity.classifycommentatorfragment;

import com.example.mypc.dogliveshow.base.IBaseModel;
import com.example.mypc.dogliveshow.base.IBasePresenter;
import com.example.mypc.dogliveshow.base.IBaseView;
import com.example.mypc.dogliveshow.bean.classifybean.commentbean.CommentBean;
import com.example.mypc.dogliveshow.bean.classifybean.commentbean.CommentatorsBean;
import com.example.mypc.dogliveshow.utils.classifyutils.commentator.CommentatorUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/14.
 */
public class CommentatorContract {
    public interface View extends IBaseView{
        public void onSuccessGetCommentator(CommentatorsBean commentatorsBean);
        public void onFailGetCommentator(String msg);
    }
    public interface Model extends IBaseModel{
        public void getCommentator(HashMap<String,String> params, CommentatorUtils.CommenCallback<CommentBean> callback);
    }
    public interface Presenter extends IBasePresenter{
        public void initData(HashMap<String,String> params);
    }
}
