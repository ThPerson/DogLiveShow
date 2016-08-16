package com.example.mypc.dogliveshow.main.ui.mydog.platform;

import com.example.mypc.dogliveshow.bean.maydogbean.PlatFormBean;
import com.example.mypc.dogliveshow.utils.mydogutils.HttpUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by JiaFan on 2016/8/15 14:30
 * QQ：1319662955
 */
public class PlatFormModel implements PlatFormContact.Model{

    @Override
    public void getData(HashMap<String, String> params, HttpUtils.HttpCallBack<List<PlatFormBean>> platFormBeanHttpCallBack) {

        HttpUtils.getInstance().getPlatFormData(params,platFormBeanHttpCallBack);

    }
}
