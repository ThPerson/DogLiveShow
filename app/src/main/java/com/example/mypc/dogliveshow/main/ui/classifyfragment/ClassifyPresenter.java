package com.example.mypc.dogliveshow.main.ui.classifyfragment;

import com.example.mypc.dogliveshow.bean.classifybean.ClassifyBean;
import com.example.mypc.dogliveshow.utils.classifyutils.HttpUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/12.
 */
public class ClassifyPresenter implements ClassifyContract.Presenter {
    private ClassifyContract.View view;
    private ClassifyContract.Model model;
    public ClassifyPresenter(ClassifyContract.View view, ClassifyContract.Model model){
        this.model = model;
        this.view = view;
    }
    @Override
    public void initData(HashMap<String, String> params) {
        model.getClassify(params, new HttpUtils.HttpCallback<ClassifyBean>() {
            @Override
            public void onSucess(ClassifyBean classifyBean) {
                view.onSuccessGetClassify(classifyBean.getDataList());
            }

            @Override
            public void onFail() {
                view.onFailGetClassify("网络连接错误...");
            }
        });

    }
}
