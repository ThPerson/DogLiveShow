package com.example.mypc.dogliveshow.main.ui.headlinefragment;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.headlinebean.DataListBean;
import com.example.mypc.dogliveshow.utils.GlideCircleTransform;

import java.util.List;

/**
 * Created by JiaFan on 2016/8/12 18:43
 * QQ：1319662955
 */
public class HeadLineAdapter extends BaseAdapter {
    List<DataListBean> mList;
    private Drawable drawable;
    final int TYPE_1 = 0;

    final int TYPE_2 = 1;

    public HeadLineAdapter(List<DataListBean> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).getPageType() < 3) {
            return TYPE_1;
        } else {
            return TYPE_2;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return mList != null ? mList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ViewHolder3 holder3 = null;
        int type = getItemViewType(position);

        if (convertView == null) {
            switch (type) {
                case TYPE_1:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_headline_type_one, parent, false);
                    holder = new ViewHolder(convertView);

                    convertView.setTag(holder);
                    break;
                case TYPE_2:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_headline_type_three, parent, false);
                    holder3 = new ViewHolder3(convertView);
                    convertView.setTag(holder3);
                    break;
            }
        } else {
            //有convertView，按样式，取得不同的布局
            switch (type)
            {
                case TYPE_1:
                    holder = (ViewHolder) convertView.getTag();
                    break;
                case TYPE_2:
                    holder3 = (ViewHolder3) convertView.getTag();
                    break;
            }
        //设置资源
            switch (type) {
                case TYPE_1:
                    HolderData(position, parent, holder);


                    break;
                case TYPE_2:
                    Holder3Data(position, parent, holder3);


                    break;
            }


        }



        return convertView;
    }

    private void Holder3Data(int position, ViewGroup parent, ViewHolder3 holder3) {
        holder3.tvUserName3.setText(mList.get(position).getUserInfo().getUserName());
        //要转换毫秒
        holder3.tvRecommend3.setText(pushTimeMethod(mList.get(position).getPushTime()));
        //标题
        holder3.tvTitle3.setText(mList.get(position).getName());
        //内容
        holder3.tvExcerpt3.setText(mList.get(position).getExcerpt());
        //作者
        holder3.tvTags3.setText(mList.get(position).getTags());
        //转换查看次数
        holder3.tvSeeCount3.setText(seeCountMethod(mList.get(position).getSeeCount()));
        //评论次数
        if (mList.get(position).getCommentCount() > 0) {
            Resources resources = parent.getContext().getResources();
            if (drawable == null) {
                drawable = resources.getDrawable(R.drawable.comment_count_background);
            }
            holder3.tvCommentCount3.setBackground(drawable);
            holder3.tvCommentCount3.setText(String.valueOf(mList.get(position).getCommentCount()));
        }
        Glide.with(parent.getContext())
                .load(mList.get(position).getUserInfo().getIcon())
                .placeholder(R.mipmap.user_head)
                .transform(new GlideCircleTransform(parent.getContext()))
                .into(holder3.ivUserHead3);
        Glide.with(parent.getContext())
                .load(mList.get(position).getPics().get(0).getSmallUrl())
                .placeholder(R.mipmap.no_copy_back)
                .into(holder3.ivLogo3);
    }

    private void HolderData(int position, ViewGroup parent, ViewHolder holder) {
        holder.tvUserName.setText(mList.get(position).getUserInfo().getUserName());
        //要转换毫秒
        holder.tvRecommend.setText(pushTimeMethod(mList.get(position).getPushTime()));
        //标题
        holder.tvTitle.setText(mList.get(position).getName());
        //内容
        holder.tvExcerpt.setText(mList.get(position).getExcerpt());
        //作者
        holder.tvTags.setText(mList.get(position).getTags());
        //转换查看次数
        holder.tvSeeCount.setText(seeCountMethod(mList.get(position).getSeeCount()));
        //评论次数
        if (mList.get(position).getCommentCount() > 0) {
            Resources resources = parent.getContext().getResources();
            if (drawable == null) {
                drawable = resources.getDrawable(R.drawable.comment_count_background);
            }
            holder.tvCommentCount.setBackground(drawable);
            holder.tvCommentCount.setText(String.valueOf(mList.get(position).getCommentCount()));
        }
        Glide.with(parent.getContext())
                .load(mList.get(position).getUserInfo().getIcon())
                .placeholder(R.mipmap.user_head)
                .transform(new GlideCircleTransform(parent.getContext()))
                .into(holder.ivUserHead);
        Glide.with(parent.getContext())
                .load(mList.get(position).getPics().get(0).getSmallUrl())
                .placeholder(R.mipmap.no_copy_back)
                .into(holder.ivLogo);
    }


    private String seeCountMethod(int seeCount) {
        if (seeCount / 10000 == 0) {
            return seeCount + "次";
        } else {
            return seeCount / 10000 + "万次";
        }
    }

    //毫秒转化方法
    private String pushTimeMethod(int time) {

        long nowTime = System.currentTimeMillis();
        int pushTime = (int) (nowTime - time * 1000);
        if (pushTime / 1000 < 60) {
            return "1分钟前推荐";
        }
        if (pushTime / 1000 / 60 < 60) {
            return pushTime / 1000 / 60 + "分钟前推荐";
        }
        if (pushTime / 1000 / 60 / 60 < 24) {
            return pushTime / 1000 / 60 / 60 + "小时前推荐";
        }
        return "1天前推荐";

    }

    static class ViewHolder {
        private ImageView ivLogo, ivUserHead;
        private TextView tvUserName, tvRecommend, tvTitle, tvExcerpt, tvTags, tvSeeCount, tvCommentCount;

        public ViewHolder(View view) {
            ivLogo = (ImageView) view.findViewById(R.id.iv_item_Head_logo);
            ivUserHead = (ImageView) view.findViewById(R.id.iv_user_head);
            tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
            tvRecommend = (TextView) view.findViewById(R.id.tv_recommend);
            tvTitle = (TextView) view.findViewById(R.id.tv_title_name);
            tvExcerpt = (TextView) view.findViewById(R.id.tv_excerpt);
            tvTags = (TextView) view.findViewById(R.id.tv_tags);
            tvSeeCount = (TextView) view.findViewById(R.id.tv_see_count);
            tvCommentCount = (TextView) view.findViewById(R.id.tv_comment_count);
        }
    }

    static class ViewHolder3 {
        private ImageView ivLogo3, ivUserHead3;
        private TextView tvUserName3, tvRecommend3, tvTitle3, tvExcerpt3, tvTags3, tvSeeCount3, tvCommentCount3;

        public ViewHolder3(View view) {
            ivLogo3 = (ImageView) view.findViewById(R.id.iv_item_Head_logo3);
            ivUserHead3 = (ImageView) view.findViewById(R.id.iv_user_head3);
            tvUserName3 = (TextView) view.findViewById(R.id.tv_user_name3);
            tvRecommend3 = (TextView) view.findViewById(R.id.tv_recommend3);
            tvTitle3 = (TextView) view.findViewById(R.id.tv_title_name3);
            tvExcerpt3 = (TextView) view.findViewById(R.id.tv_excerpt3);
            tvTags3 = (TextView) view.findViewById(R.id.tv_tags3);
            tvSeeCount3 = (TextView) view.findViewById(R.id.tv_see_count3);
            tvCommentCount3 = (TextView) view.findViewById(R.id.tv_comment_count3);
        }
    }
}
