package com.example.mypc.dogliveshow.main.ui.activitymore.concern;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.moreanchor.AnchorBean;
import com.example.mypc.dogliveshow.main.ui.activitymore.anchordetail.AnchorDetailActivity;

import java.util.List;

/**
 * Created by MyPC on 2016/8/16.
 */
public class ConcerAdapter extends BaseQuickAdapter<AnchorBean.RecZhuboBean.DataListBean> {

    public ConcerAdapter(int layoutResId, List<AnchorBean.RecZhuboBean.DataListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder baseViewHolder, final AnchorBean.RecZhuboBean.DataListBean recZhuboBean) {
        baseViewHolder.setText(R.id.tv_concer_name, recZhuboBean.getCommentator());
        String jsdesc = recZhuboBean.getJsdesc();
        if (jsdesc != null) {
            baseViewHolder.setText(R.id.tv_concer_tag, jsdesc);
        }
        baseViewHolder.setText(R.id.tv_concer_title, recZhuboBean.getName());
        baseViewHolder.setText(R.id.tv_concer_tit, "人气" + recZhuboBean.getViewers());
        Glide.with(baseViewHolder.convertView.getContext())
                .load(recZhuboBean.getRawcommentatorimage())
//                .placeholder(R.mipmap.no_result_icon)
                .error(R.mipmap.ic_default)
                .into((ImageView) baseViewHolder.getView(R.id.circle_view_concer));
        baseViewHolder.setOnClickListener(R.id.circle_view_concer, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(baseViewHolder.convertView.getContext(), AnchorDetailActivity.class);
                String id = recZhuboBean.getId();
                String jsid = recZhuboBean.getJsid();
                intent.putExtra("jsid", jsid);
                intent.putExtra("id", id);
                baseViewHolder.convertView.getContext()
                        .startActivity(intent);
            }
        });
        baseViewHolder.setOnClickListener(R.id.tv_guan_zhu, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(baseViewHolder.convertView.getContext(), "关注", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
