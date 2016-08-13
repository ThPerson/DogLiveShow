package com.example.mypc.dogliveshow.main.ui.headlinefragment;

import com.example.mypc.dogliveshow.bean.headlinebean.HeadLineBean;
import com.example.mypc.dogliveshow.utils.headlineutils.HttpUtils;

import java.util.HashMap;

/**
 * Created by JiaFan on 2016/8/12 18:21
 * QQ：1319662955
 */
public class HeadLineModel implements HeadLineContract.Model{
    @Override
    public void getHeadLineData(HashMap<String, String> params, HttpUtils.HttpCallBack<HeadLineBean> headLineBeanHttpCallBack) {
        HttpUtils.getInstance().getHeadLineData(params,headLineBeanHttpCallBack);
    }
}
