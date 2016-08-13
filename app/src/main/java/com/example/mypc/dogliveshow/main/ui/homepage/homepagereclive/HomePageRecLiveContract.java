package com.example.mypc.dogliveshow.main.ui.homepage.homepagereclive;

import com.example.mypc.dogliveshow.base.IBaseModel;
import com.example.mypc.dogliveshow.base.IBasePresenter;
import com.example.mypc.dogliveshow.base.IBaseView;
import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.utils.homepagereclive.HomeRecLiveHttpUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageRecLiveContract {
    public interface View extends IBaseView {
        void onSuccess(HomePage list);

        void onFild(String msg);
    }

    public interface Model extends IBaseModel {
        void getData(HashMap<String, String> params, HomeRecLiveHttpUtils.HttpCallback<HomePage> callback);
    }

    public interface Persenter extends IBasePresenter {
        void getData(HashMap<String, String> params);
    }
}
