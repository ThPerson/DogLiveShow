package com.example.mypc.dogliveshow.main.ui.activitymore.anchordetail;

import com.example.mypc.dogliveshow.base.IBaseModel;
import com.example.mypc.dogliveshow.base.IBasePresenter;
import com.example.mypc.dogliveshow.base.IBaseView;
import com.example.mypc.dogliveshow.bean.moreanchor.AnchorDetailBean;
import com.example.mypc.dogliveshow.utils.anchordetailutils.AnchorDetailUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/16.
 */
public class AnchorDetailContract {

    public interface View extends IBaseView {
        void onSuccess(AnchorDetailBean bean);

        void onFild(String msg);
    }

    public interface Model extends IBaseModel {
        void getData(HashMap<String, String> params, AnchorDetailUtils.HttpCallback<AnchorDetailBean> callback);

    }

    public interface Presenter extends IBasePresenter {
        void getData(HashMap<String, String> params);
    }
}
