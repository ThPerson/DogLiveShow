package com.example.mypc.dogliveshow.main.ui.classifyfragment;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.dogliveshow.bean.classifybean.DataListBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class ClassifyAdapter extends BaseQuickAdapter<DataListBean> {
    public ClassifyAdapter(int layoutResId, List<DataListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DataListBean dataListBean) {

    }
}
