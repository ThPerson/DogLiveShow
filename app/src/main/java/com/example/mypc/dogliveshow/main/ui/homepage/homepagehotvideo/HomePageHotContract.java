package com.example.mypc.dogliveshow.main.ui.homepage.homepagehotvideo;

import com.example.mypc.dogliveshow.base.IBaseModel;
import com.example.mypc.dogliveshow.base.IBasePresenter;
import com.example.mypc.dogliveshow.base.IBaseView;
import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.utils.homepagehot.HomeHotHttpUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageHotContract {
    public interface View extends IBaseView {
        void onSuccess(HomePage list);

        void onFild(String msg);
    }

    public interface Model extends IBaseModel {
        void getData(HashMap<String, String> params, HomeHotHttpUtils.HttpCallback<HomePage> callback);
    }

    public interface Persenter extends IBasePresenter {
        void getData(HashMap<String, String> params);
    }
}
