package com.example.mypc.dogliveshow.main.ui.activitymore.concern;

import com.example.mypc.dogliveshow.base.IBaseModel;
import com.example.mypc.dogliveshow.base.IBasePresenter;
import com.example.mypc.dogliveshow.base.IBaseView;
import com.example.mypc.dogliveshow.bean.moreanchor.AnchorBean;
import com.example.mypc.dogliveshow.utils.concernmore.ConcernUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/16.
 */
public class ConcernContract {

    public interface View extends IBaseView {
        void onSuccess(AnchorBean bean);

        void onFild(String msg);
    }

    public interface Model extends IBaseModel {
        void getData(HashMap<String, String> params, ConcernUtils.HttpCallback<AnchorBean> callback);

    }

    public interface Presenter extends IBasePresenter {
        void getData(HashMap<String,String> params);
    }
}
