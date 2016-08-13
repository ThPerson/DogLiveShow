package com.example.mypc.dogliveshow.main.ui.classifyfragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.dogliveshow.R;
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
    protected void convert(final BaseViewHolder baseViewHolder, DataListBean dataListBean) {
        baseViewHolder.setText(R.id.tv_classify_name,dataListBean.getName())
                .setText(R.id.tv_classify_livenum,dataListBean.getLivenum()+"条直播");
        Glide.with(baseViewHolder.convertView.getContext())
                .load(dataListBean.getImgurl())
                .into((ImageView) baseViewHolder.getView(R.id.iv_classify_rel));
        baseViewHolder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(baseViewHolder.convertView.getContext(), "点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
