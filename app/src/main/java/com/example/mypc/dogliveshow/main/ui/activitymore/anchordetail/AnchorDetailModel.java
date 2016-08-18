package com.example.mypc.dogliveshow.main.ui.activitymore.anchordetail;

import com.example.mypc.dogliveshow.bean.moreanchor.AnchorDetailBean;
import com.example.mypc.dogliveshow.utils.anchordetailutils.AnchorDetailUtils;

import java.util.HashMap;

/**
 * Created by MyPC on 2016/8/16.
 */
public class AnchorDetailModel implements AnchorDetailContract.Model {
    @Override
    public void getData(HashMap<String, String> params, AnchorDetailUtils.HttpCallback<AnchorDetailBean> callback) {
        AnchorDetailUtils.getInstance().getAnchorDetail(params,callback);
    }
}
