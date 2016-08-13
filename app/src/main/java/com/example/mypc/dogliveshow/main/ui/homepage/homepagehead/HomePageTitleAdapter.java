package com.example.mypc.dogliveshow.main.ui.homepage.homepagehead;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;

import java.util.List;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageTitleAdapter extends BaseQuickAdapter<HomePage.ConLiveBean.DataListBean.MyArrayListBean> {
    public HomePageTitleAdapter(int layoutResId, List<HomePage.ConLiveBean.DataListBean.MyArrayListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, HomePage.ConLiveBean.DataListBean.MyArrayListBean myArrayListBean) {
        String name = myArrayListBean.getMap().getName();
        String commentator = myArrayListBean.getMap().getCommentator();
        String rawcommentatorimage = myArrayListBean.getMap().getRawcommentatorimage();
        baseViewHolder.setText(R.id.tv_item_up, commentator);
        baseViewHolder.setText(R.id.tv_item_down, name);
        Glide.with(baseViewHolder.convertView.getContext())
                .load(rawcommentatorimage)
//                .placeholder(R.mipmap.ic_default)
                .error(R.mipmap.no_result_icon)
                .into((ImageView) baseViewHolder.getView(R.id.civ_head_image));

    }


}
