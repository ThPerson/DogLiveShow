package com.example.mypc.dogliveshow.main.ui.activitymore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.base.BaseActivity;
import com.example.mypc.dogliveshow.main.ui.activitymore.anchor.AnchorFragment;
import com.example.mypc.dogliveshow.main.ui.activitymore.concern.ConcernFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MoreGuanActivity extends BaseActivity {


    @BindView(R.id.iv_btn_back)
    ImageView ivBtnBack;
    @BindView(R.id.vp_more_detail)
    ViewPager vpMoreDetail;
    @BindView(R.id.rb_more_guan)
    RadioButton rbMoreGuan;
    @BindView(R.id.rb_zhu_bo)
    RadioButton rbZhuBo;
    @BindView(R.id.rg_btn_group)
    RadioGroup rgBtnGroup;
    private List<Fragment> mList = new ArrayList<>();
    private static int FIRST = 0;
    private static int SECOND = 1;

    @Override
    public int getLayoutID() {
        return R.layout.activity_more_guan;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList.add(new ConcernFragment());
        mList.add(new AnchorFragment());
        vpMoreDetail.setAdapter(new ConecrnPagerAdapter(getSupportFragmentManager(), mList));
        vpMoreDetail.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0){
                    rbMoreGuan.setChecked(true);
                }else{
                    rbZhuBo.setChecked(true);
                }
            }
        });

    }

    @OnClick({R.id.iv_btn_back, R.id.rb_more_guan, R.id.rb_zhu_bo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_btn_back:
                onBackPressed();
                break;
            case R.id.rb_more_guan:
                vpMoreDetail.setCurrentItem(FIRST);
                break;
            case R.id.rb_zhu_bo:
                vpMoreDetail.setCurrentItem(SECOND);
                break;
        }
    }

}
