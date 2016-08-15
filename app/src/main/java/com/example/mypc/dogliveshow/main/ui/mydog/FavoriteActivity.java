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

public class FavoriteActivity extends AppCompatActivity {

    @BindView(R.id.iv_favorite_back)
    ImageView ivFavoriteBack;
    @BindView(R.id.tv_favorite_editor)
    TextView tvFavoriteEditor;
    @BindView(R.id.ll_favorite_empty)
    LinearLayout llFavoriteEmpty;
    @BindView(R.id.lv_favorite)
    ListView lvFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        ButterKnife.bind(this);
        lvFavorite.setEmptyView(llFavoriteEmpty);
    }

    @OnClick({R.id.iv_favorite_back, R.id.tv_favorite_editor})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_favorite_back:
                onBackPressed();
                break;
            case R.id.tv_favorite_editor:
                break;
        }
    }
}
