package com.example.mypc.dogliveshow.main.ui.activitymore.anchordetail;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.moreanchor.AnchorDetailBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MyPC on 2016/8/18.
 */
public class AnchorDetailListAdapter extends BaseAdapter {
    List<AnchorDetailBean.VideosBean.GameinfoBean> mList;

    public AnchorDetailListAdapter(List<AnchorDetailBean.VideosBean.GameinfoBean> list) {
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position) != null ? mList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewItemHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.anchor_detail_list_item, null);
            holder = new ViewItemHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewItemHolder) convertView.getTag();
        }
        String rawcoverimage = mList.get(position).getRawcoverimage();
        Log.i("TAG", "getView: "+rawcoverimage);
        String duration = mList.get(position).getDuration();
        String title = mList.get(position).getTitle();
        String viewtimes = mList.get(position).getViewtimes();
        String updatetime = mList.get(position).getUpdatetime();
        holder.tvAnchorDetailDuration.setText(duration);
        holder.tvAnchorDetailList.setText(title);
        holder.tvAnchorDetailListSmall.setText(title);
        holder.tvAnchorWatch.setText(viewtimes);
        holder.tvAnchorDateTime.setText(updatetime);
        Glide.with(parent.getContext()).load(rawcoverimage).into(holder.ivAnchorListItem);

        return convertView;
    }

   static class ViewItemHolder {
        @BindView(R.id.iv_anchor_list_item)
        ImageView ivAnchorListItem;
        @BindView(R.id.tv_anchor_detail_duration)
        TextView tvAnchorDetailDuration;
        @BindView(R.id.tv_anchor_detail_list)
        TextView tvAnchorDetailList;
        @BindView(R.id.tv_anchor_detail_list_small)
        TextView tvAnchorDetailListSmall;
        @BindView(R.id.tv_anchor_watch)
        TextView tvAnchorWatch;
        @BindView(R.id.tv_anchor_date_time)
        TextView tvAnchorDateTime;

        ViewItemHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
