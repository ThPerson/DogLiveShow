package com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity.classifycommentatorfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.classifybean.commentatorbean.CommentatorsBean;
import com.example.mypc.dogliveshow.bean.classifybean.commentatorbean.GameinfoBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public class ClassifyCommentatorFragment extends Fragment implements CommentatorContract.View{

    private List<GameinfoBean> gameinfo;

    public ClassifyCommentatorFragment(){}

    private CommentatorContract.Presenter presenter;
    private CommentatorContract.Model model;
    private CommentatorsBean commentatorsbean;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View CommentatorView = inflater.inflate(R.layout.fragment_clssifydetail_lol,container,false);

        initView();
        model = new CommentatorModel();
        presenter = new CommentatorPresenter(this,model);
        presenter.initData(initParams());
        return CommentatorView;
    }

    private HashMap<String,String> initParams() {
        HashMap<String,String> params = new HashMap<>();
        params.put(UrlConfig.CommentatorKey.APPVER,"3.1.0");
        params.put(UrlConfig.CommentatorKey.REQ_FROM,"app");
        params.put(UrlConfig.CommentatorKey.RESULTTYPE,"json");
        params.put(UrlConfig.CommentatorKey.SYSTEM,"android");
        params.put(UrlConfig.CommentatorKey.SYSVER,"4.4.4");
        return params;
    }

    private void initView() {
        gameinfo = new ArrayList<>();
    }

    @Override
    public void onSucessGetCommentator(CommentatorsBean commentatorsBean) {
        commentatorsbean = commentatorsBean;
        gameinfo = commentatorsbean.getGameinfo();
        Log.w("TAG","------------------"+gameinfo.size());

    }

    @Override
    public void onFailGetCommentator(String msg) {

    }
}
