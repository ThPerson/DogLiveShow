package com.example.mypc.dogliveshow.main.ui.activitymore.concern;

import com.example.mypc.dogliveshow.bean.moreanchor.AnchorBean;
import com.example.mypc.dogliveshow.utils.concernmore.ConcernUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/16.
 */
public class ConcernModel implements ConcernContract.Model {
    @Override
    public void getData(HashMap<String, String> params, ConcernUtils.HttpCallback<AnchorBean> callback) {
        ConcernUtils.getInstance().getConcernData(params,callback);
    }
}
