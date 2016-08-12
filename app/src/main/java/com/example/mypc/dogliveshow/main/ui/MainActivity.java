package com.example.mypc.dogliveshow.main.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.base.BaseActivity;
import com.example.mypc.dogliveshow.main.ui.classifyfragment.ClassifyFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fl_layout)
    FrameLayout flLayout;
    @BindView(R.id.btn_home_page)
    RadioButton btnHomePage;
    @BindView(R.id.btn_classify)
    RadioButton btnClassify;
    @BindView(R.id.btn_head_line)
    RadioButton btnHeadLine;
    @BindView(R.id.btn_my_dog)
    RadioButton btnMyDog;
    @BindView(R.id.game_group)
    RadioGroup gameGroup;
    private FragmentManager manager;
    private HomePageFragment homePageFragment;
    private ClassifyFragment classifyFragment;
    private HeadlineFragment headlineFragment;
    private MyDogFragment myDogFragment;
    public static final int SELECTED_HOME = 0;
    public static final int SELECTED_CLASSIFY = 1;
    public static final int SELECTED_HEADLINE = 2;
    public static final int SELECTED_MYDOG = 3;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment();
        selectFragment(SELECTED_HOME);
    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        homePageFragment = new HomePageFragment();
        classifyFragment = new ClassifyFragment();
        headlineFragment = new HeadlineFragment();
        myDogFragment = new MyDogFragment();
        transaction.add(R.id.fl_layout, homePageFragment);
        transaction.add(R.id.fl_layout, classifyFragment);
        transaction.add(R.id.fl_layout, headlineFragment);
        transaction.add(R.id.fl_layout, myDogFragment);
        transaction.commit();
    }

    public void selectFragment(int position) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(homePageFragment).hide(classifyFragment).hide(headlineFragment).hide(myDogFragment);
        switch (position) {
            case SELECTED_HOME:
                transaction.show(homePageFragment);
                break;
            case SELECTED_CLASSIFY:
                transaction.show(classifyFragment);
                break;
            case SELECTED_HEADLINE:
                transaction.show(headlineFragment);
                break;
            case SELECTED_MYDOG:
                transaction.show(myDogFragment);
                break;

        }
        transaction.commit();
    }

    @OnClick({R.id.btn_home_page, R.id.btn_classify, R.id.btn_head_line, R.id.btn_my_dog})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home_page:
                selectFragment(SELECTED_HOME);
                break;
            case R.id.btn_classify:
                selectFragment(SELECTED_CLASSIFY);
                break;
            case R.id.btn_head_line:
                selectFragment(SELECTED_HEADLINE);
                break;
            case R.id.btn_my_dog:
                selectFragment(SELECTED_MYDOG);
                break;

        }
    }
}
