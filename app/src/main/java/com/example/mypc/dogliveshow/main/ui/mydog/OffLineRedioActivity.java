package com.example.mypc.dogliveshow.main.ui.mydog;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.dogliveshow.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OffLineRedioActivity extends AppCompatActivity {

    @BindView(R.id.iv_offline_download_back)
    ImageView ivOfflineDownloadBack;
    @BindView(R.id.tv_offline_download_editor)
    TextView tvOfflineDownloadEditor;
    @BindView(R.id.tablayout_offline)
    TabLayout tablayoutOffline;
    @BindView(R.id.viewpager_offline)
    ViewPager viewpagerOffline;
    private VpOfflineAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_off_line_redio);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        list.add("已下载");
        list.add("下载中");
        adapter = new VpOfflineAdapter(getSupportFragmentManager(),list);
        viewpagerOffline.setAdapter(adapter);
        tablayoutOffline.setupWithViewPager(viewpagerOffline);
    }

    @OnClick({R.id.iv_offline_download_back, R.id.tv_offline_download_editor})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_offline_download_back:
                onBackPressed();
                break;
            case R.id.tv_offline_download_editor:
                break;
        }
    }
}
