package com.example.mypc.dogliveshow.main.ui.headlinefragment;

import com.example.mypc.dogliveshow.bean.headlinebean.HeadLineBean;
import com.example.mypc.dogliveshow.main.ui.headlinefragment.HeadLineContract.Presenter;
import com.example.mypc.dogliveshow.utils.headlineutils.HttpUtils;

import java.util.HashMap;

/**
 * Created by JiaFan on 2016/8/12 18:22
 * QQ：1319662955
 */
public class HeadLinePresenter implements Presenter{
    private HeadLineContract.Model model;
    private HeadLineContract.View view;

    public HeadLinePresenter(HeadLineContract.Model model, HeadLineContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getHeadLineData(HashMap<String, String> params) {
        model.getHeadLineData(params, new HttpUtils.HttpCallBack<HeadLineBean>() {
            @Override
            public void onSucess(HeadLineBean headLineBean) {
                view.onSuccess(headLineBean);
            }

            @Override
            public void onFail() {
                view.onFail("网络连接错误");
            }
        });
    }
}
