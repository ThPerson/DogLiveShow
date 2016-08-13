package com.example.mypc.dogliveshow.main.ui.headlinefragment;

import com.example.mypc.dogliveshow.base.IBaseModel;
import com.example.mypc.dogliveshow.base.IBasePresenter;
import com.example.mypc.dogliveshow.base.IBaseView;
import com.example.mypc.dogliveshow.bean.headlinebean.HeadLineBean;
import com.example.mypc.dogliveshow.utils.headlineutils.HttpUtils;

import java.util.HashMap;

/**
 * Created by JiaFan on 2016/8/12 18:20
 * QQ：1319662955
 */
public class HeadLineContract {
    public interface View extends IBaseView{
        void onSuccess(HeadLineBean headLineBean);
        void onFail(String msg);
    }
    public interface Model extends IBaseModel{
        void getHeadLineData(HashMap<String,String> params, HttpUtils.HttpCallBack<HeadLineBean> headLineBeanHttpCallBack);
    }
    public interface Presenter extends IBasePresenter {
        void getHeadLineData(HashMap<String, String> params);
    }
}
