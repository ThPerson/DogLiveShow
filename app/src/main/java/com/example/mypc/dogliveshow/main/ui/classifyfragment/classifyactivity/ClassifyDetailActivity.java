package com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.base.BaseActivity;

import butterknife.BindView;

public class ClassifyDetailActivity extends BaseActivity {

    @BindView(R.id.tv_classify_play)
    TextView tvClassifyPlay;
    @BindView(R.id.tv_classify_video)
    TextView tvClassifyVideo;
    @BindView(R.id.vp_classify_detail)
    ViewPager mVpClassify;
    private int FLAG = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        tvClassifyPlay.setBackground(getResources().getDrawable(R.mipmap.tab_left_selected));
        tvClassifyPlay.setTextColor(Color.parseColor("#FE7053"));
        //开关点击事件
        tvClassifyPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=0;
                tvClassifyPlay.setTag(FLAG);
                changeBackground(FLAG);
                mVpClassify.setCurrentItem(FLAG);
            }
        });
        tvClassifyVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLAG=1;
                //tvClassifyVideo.setTag(FLAG);
                changeBackground(FLAG);
                mVpClassify.setCurrentItem(FLAG);
            }
        });

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        mVpClassify.setAdapter(adapter);
        //ViewPager页面变化的同时,开关按钮跟着变化
        mVpClassify.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                changeBackground(position);
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_classify_detail;
    }



    //切换
    private void changeBackground(int flag) {
        switch (flag){
            case 0:
                tvClassifyPlay.setBackground(getResources().getDrawable(R.mipmap.tab_left_selected));
                tvClassifyPlay.setTextColor(Color.parseColor("#FE7053"));
                tvClassifyVideo.setBackground(getResources().getDrawable(R.mipmap.tab_right_unselected));
                tvClassifyVideo.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case 1:
                tvClassifyVideo.setBackground(getResources().getDrawable(R.mipmap.tab_right_selected));
                tvClassifyVideo.setTextColor(Color.parseColor("#FE7053"));
                tvClassifyPlay.setBackground(getResources().getDrawable(R.mipmap.tab_left_unselected));
                tvClassifyPlay.setTextColor(Color.parseColor("#FFFFFF"));
                break;
        }

    }

    public void back(View view) {
        onBackPressed();
    }

    //adapter
    class MyAdapter extends FragmentStatePagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.creatFragment(position+1);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
