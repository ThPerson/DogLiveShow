package com.example.mypc.dogliveshow.main.ui.mydog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.mypc.dogliveshow.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivity extends AppCompatActivity {

    @BindView(R.id.iv_history_back)
    ImageView ivHistoryBack;
    @BindView(R.id.ll_history_empty)
    LinearLayout llHistoryEmpty;
    @BindView(R.id.lv_history)
    ListView lvHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        lvHistory.setEmptyView(llHistoryEmpty);
    }

    @OnClick(R.id.iv_history_back)
    public void onClick() {
        onBackPressed();
    }
}
