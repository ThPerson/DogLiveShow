package com.example.mypc.dogliveshow.main.ui.homepage.homepagehead;

import com.example.mypc.dogliveshow.base.IBaseModel;
import com.example.mypc.dogliveshow.base.IBasePresenter;
import com.example.mypc.dogliveshow.base.IBaseView;
import com.example.mypc.dogliveshow.bean.homepagetitle.DataListTitleBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageHeadContract {
    public interface View extends IBaseView {
        void onSuccess(List<DataListTitleBean> list);

        void onFild(String msg);
    }

    public interface Model extends IBaseModel {
        void getData(HashMap<String, String> params, Callback<List<DataListTitleBean>> callback);
    }

    public interface Persenter extends IBasePresenter {
        void getData();
    }
}
