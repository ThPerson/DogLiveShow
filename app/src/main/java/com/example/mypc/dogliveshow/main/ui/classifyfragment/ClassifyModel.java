package com.example.mypc.dogliveshow.main.ui.classifyfragment;

import com.example.mypc.dogliveshow.bean.classifybean.ClassifyBean;
import com.example.mypc.dogliveshow.utils.classifyutils.HttpUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/12.
 */
public class ClassifyModel implements ClassifyContract.Model {
    @Override
    public void getClassify(HashMap<String, String> params, HttpUtils.HttpCallback<ClassifyBean> callback) {
        HttpUtils.getInstance().getClassifyData(params,callback);
    }
}
