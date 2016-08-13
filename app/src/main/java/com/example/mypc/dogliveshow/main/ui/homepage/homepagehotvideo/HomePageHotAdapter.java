package com.example.mypc.dogliveshow.main.ui.homepage.homepagehotvideo;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by MyPC on 2016/8/13.
 */
public class HomePageHotAdapter extends BaseQuickAdapter<HomePage.HotLiveBean.DataListBean.MyArrayListBean> {
    public HomePageHotAdapter(int layoutResId, List<HomePage.HotLiveBean.DataListBean.MyArrayListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, HomePage.HotLiveBean.DataListBean.MyArrayListBean myArrayListBean) {

        baseViewHolder.setText(R.id.tv_game_name, myArrayListBean.getMap().getName());
        baseViewHolder.setText(R.id.tv_head_title, myArrayListBean.getMap().getTitle());
        baseViewHolder.setText(R.id.tv_pingtai_name, myArrayListBean.getMap().getSourcename() + "·" + myArrayListBean.getMap().getCommentator());
        myArrayListBean.getMap().getViewers();
        DecimalFormat df = new DecimalFormat("###.0");
        String format = df.format(Integer.parseInt(myArrayListBean.getMap().getViewers()) / 10000);
        if (Integer.parseInt(myArrayListBean.getMap().getViewers()) >= 10000) {
            baseViewHolder.setText(R.id.tv_online_people, (format + "万人"));
        } else {
            baseViewHolder.setText(R.id.tv_online_people, (Integer.parseInt(myArrayListBean.getMap().getViewers()) + "人"));
        }
        Glide.with(baseViewHolder.convertView.getContext())
                .load(myArrayListBean.getMap().getRawcoverimage())
                .error(R.mipmap.no_result_icon)
                .into((ImageView) baseViewHolder.getView(R.id.iv_media_preview));
    }
}
