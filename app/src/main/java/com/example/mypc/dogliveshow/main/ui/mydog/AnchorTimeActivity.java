package com.example.mypc.dogliveshow.main.ui.mydog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mypc.dogliveshow.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnchorTimeActivity extends AppCompatActivity {

    @BindView(R.id.iv_anchor_time_back)
    ImageView ivAnchorTimeBack;
    @BindView(R.id.tv_anchor_time_editor)
    TextView tvAnchorTimeEditor;
    @BindView(R.id.lv_anchor_time)
    ListView lvAnchorTime;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anchor_time);
        ButterKnife.bind(this);
        lvAnchorTime.setEmptyView(llEmpty);
    }

    @OnClick({R.id.iv_anchor_time_back, R.id.tv_anchor_time_editor})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_anchor_time_back:
                onBackPressed();
                break;
            case R.id.tv_anchor_time_editor:
                break;
        }
    }
}
