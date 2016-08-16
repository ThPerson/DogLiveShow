package com.example.mypc.dogliveshow.main.ui.mydog.platform;

import android.util.Log;

import com.example.mypc.dogliveshow.bean.maydogbean.PlatFormBean;
import com.example.mypc.dogliveshow.utils.mydogutils.HttpUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by JiaFan on 2016/8/15 14:30
 * QQ：1319662955
 */
public class PlatFormPresenter implements PlatFormContact.Presenter {
    private PlatFormContact.Model model;
    private PlatFormContact.View view;

    public PlatFormPresenter(PlatFormContact.Model model, PlatFormContact.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData(HashMap<String, String> params) {
        model.getData(params, new HttpUtils.HttpCallBack<List<PlatFormBean>>() {
            @Override
            public void onSucess(List<PlatFormBean> platFormBeen) {
                Log.i("TAG","000000===="+platFormBeen.size());
                view.onSuccess(platFormBeen);
            }

            @Override
            public void onFail() {
                view.onFail("网络访问失败!");
            }
        });
    }
}
