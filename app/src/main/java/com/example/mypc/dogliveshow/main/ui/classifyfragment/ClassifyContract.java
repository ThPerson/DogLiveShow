package com.example.mypc.dogliveshow.main.ui.classifyfragment;

import com.example.mypc.dogliveshow.base.IBaseModel;
import com.example.mypc.dogliveshow.base.IBasePresenter;
import com.example.mypc.dogliveshow.base.IBaseView;
import com.example.mypc.dogliveshow.bean.classifybean.ClassifyBean;
import com.example.mypc.dogliveshow.bean.classifybean.DataListBean;
import com.example.mypc.dogliveshow.utils.classifyutils.HttpUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class ClassifyContract {
    public interface View extends IBaseView{
        public void onSuccessGetClassify(List<DataListBean> dataListBeen);
        public void onFailGetClassify(String msg);
    }
    public interface Model extends IBaseModel{
        public void getClassify(HashMap<String,String> params, HttpUtils.HttpCallback<ClassifyBean> callback);
    }
    public interface Presenter extends IBasePresenter{
        public void initData(HashMap<String,String> params);
    }
}
