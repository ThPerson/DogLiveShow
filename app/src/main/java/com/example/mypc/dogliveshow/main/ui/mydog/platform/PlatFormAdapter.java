package com.example.mypc.dogliveshow.main.ui.mydog.platform;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.maydogbean.PlatFormBean;
import com.example.mypc.dogliveshow.utils.GlideRoundTransform;

import java.util.List;

/**
 * Created by JiaFan on 2016/8/15 15:27
 * QQ：1319662955
 */
public class PlatFormAdapter extends BaseQuickAdapter<PlatFormBean> {

    public PlatFormAdapter(int layoutResId, List<PlatFormBean> data) {
        super(layoutResId, data);
        Log.i("TAG",data.size()+"-----------====");
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, PlatFormBean platFormBean) {

        baseViewHolder.setText(R.id.tv_displayname,platFormBean.getName());
        baseViewHolder.setText(R.id.tv_description,platFormBean.getDescription());
        Glide.with(baseViewHolder.convertView.getContext())
                .load(platFormBean.getIconurl())
                .placeholder(R.mipmap.loading_icon_default_2)
                .error(R.mipmap.loading_icon_default_2)
                .transform(new GlideRoundTransform(baseViewHolder.convertView.getContext(),10))
                .into((ImageView) baseViewHolder.getView(R.id.iv_plat_icon));

    }


}
