package com.example.mypc.dogliveshow.main.ui.mydog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mypc.dogliveshow.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreSettingActivity extends AppCompatActivity {

    @BindView(R.id.iv_more_setting_back)
    ImageView ivMoreSettingBack;
    @BindView(R.id.tv_clean_size)
    TextView tvCleanSize;
    @BindView(R.id.rl_setting_clean)
    RelativeLayout rlSettingClean;
    @BindView(R.id.iv_on_off_2g)
    ImageView ivOnOff2g;
    @BindView(R.id.iv_on_off_online)
    ImageView ivOnOffOnline;
    @BindView(R.id.rl_sugg)
    RelativeLayout rlSugg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_setting);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_more_setting_back, R.id.rl_setting_clean, R.id.iv_on_off_2g, R.id.iv_on_off_online, R.id.rl_sugg})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_more_setting_back:
                onBackPressed();
                break;
            case R.id.rl_setting_clean:
                break;
            case R.id.iv_on_off_2g:
                break;
            case R.id.iv_on_off_online:
                break;
            case R.id.rl_sugg:
                break;
        }
    }
}
