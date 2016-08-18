package com.example.mypc.dogliveshow.main.ui.activitymore.anchordetail;

import com.example.mypc.dogliveshow.bean.moreanchor.AnchorDetailBean;
import com.example.mypc.dogliveshow.utils.anchordetailutils.AnchorDetailUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/16.
 */
public class AnchorDetailPresenter implements AnchorDetailContract.Presenter{
    private AnchorDetailContract.View view;
    private AnchorDetailContract.Model model;

    public AnchorDetailPresenter(AnchorDetailContract.View view, AnchorDetailContract.Model model){
        this.view=view;
        this.model = model;
    }
    @Override
    public void getData(HashMap<String,String> params) {
        model.getData(params, new AnchorDetailUtils.HttpCallback<AnchorDetailBean>() {
            @Override
            public void onSucess(AnchorDetailBean anchorBean) {
                view.onSuccess(anchorBean);
            }

            @Override
            public void onFail() {
                view.onFild("网络出问题了....");
            }
        });
    }
}
