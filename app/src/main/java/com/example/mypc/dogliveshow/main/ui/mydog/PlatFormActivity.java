package com.example.mypc.dogliveshow.main.ui.mydog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.mypc.dogliveshow.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlatFormActivity extends AppCompatActivity {

    @BindView(R.id.iv_plat_form_back)
    ImageView ivPlatFormBack;
    @BindView(R.id.lv_plat_form)
    ListView lvPlatForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plat_form);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_plat_form_back)
    public void onClick() {
        onBackPressed();
    }
}
