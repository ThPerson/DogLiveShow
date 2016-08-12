package com.example.mypc.dogliveshow.main.ui.homepage.homepagehead;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.homepagetitle.DataListTitleBean;

import java.util.List;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageTitleAdapter extends BaseQuickAdapter<DataListTitleBean> {
    public HomePageTitleAdapter(int layoutResId, List<DataListTitleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DataListTitleBean dataListTitleBean) {
        String name = dataListTitleBean.getMyArrayList().get(0).getMap().getName();
        String commentator = dataListTitleBean.getMyArrayList().get(0).getMap().getCommentator();
        String rawcommentatorimage = dataListTitleBean.getMyArrayList().get(0).getMap().getRawcommentatorimage();
        Log.i(TAG, "convert: " +name);
        baseViewHolder.setText(R.id.tv_item_up,commentator);
        baseViewHolder.setText(R.id.tv_item_down,name);
        Glide.with(baseViewHolder.convertView.getContext())
                .load(rawcommentatorimage)
                .placeholder(R.mipmap.no_result_icon)
                .into((ImageView) baseViewHolder.getView(R.id.civ_head_image));
    }
}
