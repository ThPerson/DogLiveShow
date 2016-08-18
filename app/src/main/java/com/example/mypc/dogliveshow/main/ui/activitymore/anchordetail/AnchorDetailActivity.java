package com.example.mypc.dogliveshow.main.ui.activitymore.anchordetail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.base.BaseActivity;
import com.example.mypc.dogliveshow.bean.moreanchor.AnchorDetailBean;
import com.example.mypc.dogliveshow.config.UrlConfig;
import com.example.mypc.dogliveshow.main.ui.homepage.PlayVideoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class AnchorDetailActivity extends BaseActivity implements AnchorDetailContract.View {


    @BindView(R.id.circ_view_head_image)
    CircleImageView circViewHeadImage;
    @BindView(R.id.tv_anchor_detail_name)
    TextView tvAnchorDetailName;
    @BindView(R.id.anchor_detail_guanhu)
    TextView anchorDetailGuanhu;
    @BindView(R.id.lineat_layout_head)
    LinearLayout lineatLayoutHead;
    @BindView(R.id.tv_anchor_detail_game)
    TextView tvAnchorDetailGame;
    @BindView(R.id.tv_anchor_detail_pingtai)
    TextView tvAnchorDetailPingtai;
    @BindView(R.id.relative_layout_fab)
    RelativeLayout relativeLayoutFab;
    @BindView(R.id.iv_on_back)
    ImageView ivOnBack;
    @BindView(R.id.iv_glide_doutai)
    ImageView ivGlideDoutai;
    @BindView(R.id.btn_jump_play)
    ImageView btnJumpPlay;
    @BindView(R.id.tv_islive_show)
    TextView tvIsliveShow;
    @BindView(R.id.tv_anchor_detail_title)
    TextView tvAnchorDetailTitle;
    @BindView(R.id.tv_anchor_detail)
    TextView tvAnchorDetail;
    @BindView(R.id.tv_anchor_detail_viewer)
    TextView tvAnchorDetailViewer;
    @BindView(R.id.btn_rb_hot)
    RadioButton btnRbHot;
    @BindView(R.id.btn_rb_new)
    RadioButton btnRbNew;
    @BindView(R.id.relative_empty)
    RelativeLayout relativeEmpty;
    @BindView(R.id.anchor_detail_list)
    ListView anchorDetailList;
    private Handler handler = new Handler();
    private AnchorDetailContract.Presenter presenter;
    private AnchorDetailContract.Model model;
    private List<AnchorDetailBean.VideosBean.GameinfoBean> list;
    private String id;
    private AnchorDetailListAdapter anchorDetailListAdapter;
    private String jsid;

    @Override
    public int getLayoutID() {
        return R.layout.activity_anchor_detail;

    }

    //http://zhibo.sogou.com/searchgame?product=video_search&resulttype=json&req_from=app&sp=jsid%3A%3Bliveid%3A11846132523836372988%3Bsorttype%3A1%3B
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        list = new ArrayList<>();
        id = intent.getStringExtra("id");
        jsid = intent.getStringExtra("jsid");
        model = new AnchorDetailModel();
        presenter = new AnchorDetailPresenter(this, model);
        presenter.getData(getParams());
        anchorDetailList.setEmptyView(relativeEmpty);


    }

    private HashMap<String, String> getParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.AnchorDetailKey.PRODUCT, "video_search");
        params.put(UrlConfig.AnchorDetailKey.RESULTTYPE, "json");
        params.put(UrlConfig.AnchorDetailKey.REQ_FROM, "app");
        params.put(UrlConfig.AnchorDetailKey.SP, "jsid%"+jsid+"%3Bliveid%3A" + id + "%3Bsorttype%3A1%3B");
        return params;
    }


    @Override
    public void onSuccess(final AnchorDetailBean bean) {
        if (bean.getVideos() != null) {
            anchorDetailListAdapter = new AnchorDetailListAdapter(bean.getVideos().getGameinfo());
            anchorDetailList.setAdapter(anchorDetailListAdapter);
            anchorDetailListAdapter.notifyDataSetChanged();
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                String rawcoverimage = bean.getLives().getGameinfo().get(0).getRawcoverimage();
                String rawcommentatorimage = bean.getLives().getGameinfo().get(0).getRawcommentatorimage();
                Glide.with(AnchorDetailActivity.this).load(rawcoverimage).into(ivGlideDoutai);
                Glide.with(AnchorDetailActivity.this).load(rawcommentatorimage).into(circViewHeadImage);
                tvAnchorDetailName.setText(bean.getLives().getGameinfo().get(0).getCommentator());
                tvAnchorDetailGame.setText(bean.getLives().getGameinfo().get(0).getSourcename());
                tvAnchorDetailPingtai.setText(bean.getLives().getGameinfo().get(0).getName());
                tvAnchorDetailTitle.setText(bean.getLives().getGameinfo().get(0).getTitle());
                tvAnchorDetail.setText(bean.getLives().getGameinfo().get(0).getSourcename());
                tvAnchorDetailViewer.setText(bean.getLives().getGameinfo().get(0).getViewers());

                btnJumpPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AnchorDetailActivity.this, PlayVideoActivity.class);
                        String roomid = bean.getLives().getGameinfo().get(0).getRoomid();
                        String sourcesite = bean.getLives().getGameinfo().get(0).getSourcesite();
                        intent.putExtra("roomid", roomid);
                        intent.putExtra("sourcesite", sourcesite);
                        if ("www.quanmin.tv".equals(sourcesite)) {
                            startActivity(intent);
                        } else if ("www.kktv5.com".equals(sourcesite)) {
                            startActivity(intent);
                        } else {
                            Toast.makeText(AnchorDetailActivity.this, "播放视频", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    @Override
    public void onFild(String msg) {
        Toast.makeText(this, "nononononononononononono", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.anchor_detail_guanhu, R.id.iv_on_back, R.id.btn_rb_hot, R.id.btn_rb_new})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.anchor_detail_guanhu:
                Toast.makeText(this, "关注", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_on_back:
                onBackPressed();
                break;
            case R.id.btn_rb_hot:
                Toast.makeText(this, "最热", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_rb_new:
                Toast.makeText(this, "最新", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
