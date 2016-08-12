package com.example.mypc.dogliveshow.main.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.homepagetitle.DataListTitleBean;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehead.HomePageHeadContract;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehead.HomePageTitleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements HomePageHeadContract.View {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_search_view)
    ImageView ivSearchView;
    @BindView(R.id.tv_love_zb)
    TextView tvLoveZb;
    @BindView(R.id.tv_btn_more)
    TextView tvBtnMore;
    @BindView(R.id.relative_title)
    RelativeLayout relativeTitle;
    @BindView(R.id.recy_home_head_title)
    RecyclerView recyHomeHeadTitle;
    @BindView(R.id.recycler_home_page_foryou)
    RecyclerView recyclerHomePageForyou;
    @BindView(R.id.recycler_hot_fire)
    RecyclerView recyclerHotFire;
    private HomePageTitleAdapter homePageTitleAdapter;

    public HomePageFragment() {
        // Required empty public constructor
    }
    private List<DataListTitleBean> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        mList = new ArrayList<>();
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        recyHomeHeadTitle.setLayoutManager(sgm);
        homePageTitleAdapter = new HomePageTitleAdapter(R.layout.home_page_head_item,mList);
        recyHomeHeadTitle.setAdapter(homePageTitleAdapter);
        return view;
    }

    @OnClick({R.id.iv_search_view, R.id.tv_btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_search_view:
                Toast.makeText(getActivity(),"搜素",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_btn_more:
                Toast.makeText(getActivity(),"更多",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onSuccess(List<DataListTitleBean> list) {
        mList.addAll(list);
        homePageTitleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFild(String msg) {

    }
}
