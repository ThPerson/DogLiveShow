package com.example.mypc.dogliveshow.main.ui.mydog.platform;

import com.example.mypc.dogliveshow.base.IBaseModel;
import com.example.mypc.dogliveshow.base.IBasePresenter;
import com.example.mypc.dogliveshow.base.IBaseView;
import com.example.mypc.dogliveshow.bean.maydogbean.PlatFormBean;
import com.example.mypc.dogliveshow.utils.mydogutils.HttpUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by JiaFan on 2016/8/15 14:30
 * QQ：1319662955
 */
public class PlatFormContact {
    public interface View extends IBaseView {
        void onSuccess(List<PlatFormBean> platFormBean);
        void onFail(String msg);
    }
    public interface Model extends IBaseModel {
        void getData(HashMap<String,String> params, HttpUtils.HttpCallBack<List<PlatFormBean>> platFormBeanHttpCallBack);
    }
    public interface Presenter extends IBasePresenter {
        void getData(HashMap<String, String> params);
    }
}
