package com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity.classifycommentatorfragment;

import com.example.mypc.dogliveshow.base.IBaseModel;
import com.example.mypc.dogliveshow.base.IBasePresenter;
import com.example.mypc.dogliveshow.base.IBaseView;
import com.example.mypc.dogliveshow.bean.classifybean.commentatorbean.CommentatorBean;
import com.example.mypc.dogliveshow.bean.classifybean.commentatorbean.CommentatorsBean;
import com.example.mypc.dogliveshow.utils.classifyutils.commentutils.Commentatorutil;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/13.
 */
public class CommentatorContract {
    public interface View extends IBaseView{
        public void onSucessGetCommentator(CommentatorsBean commentatorsBean);
        public void onFailGetCommentator(String msg);
    }
    public interface Model extends IBaseModel{
        public void getCommentator(HashMap<String,String> params, Commentatorutil.CommentCallback<CommentatorBean> callback);
    }
    public interface Presenter extends IBasePresenter{
        public void initData(HashMap<String,String> params);
    }
}
