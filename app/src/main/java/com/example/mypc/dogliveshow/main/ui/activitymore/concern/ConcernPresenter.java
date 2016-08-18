package com.example.mypc.dogliveshow.main.ui.activitymore.concern;

import com.example.mypc.dogliveshow.bean.moreanchor.AnchorBean;
import com.example.mypc.dogliveshow.utils.concernmore.ConcernUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/16.
 */
public class ConcernPresenter implements ConcernContract.Presenter{
    private ConcernContract.View view;
    private ConcernContract.Model model;

    public ConcernPresenter(ConcernContract.View view,ConcernContract.Model model){
        this.view=view;
        this.model = model;
    }
    @Override
    public void getData(HashMap<String,String> params) {
        model.getData(params, new ConcernUtils.HttpCallback<AnchorBean>() {
            @Override
            public void onSucess(AnchorBean anchorBean) {
                view.onSuccess(anchorBean);
            }

            @Override
            public void onFail() {
                view.onFild("网络出问题了....");
            }
        });
    }
}
