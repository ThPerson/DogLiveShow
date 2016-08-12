package com.example.mypc.dogliveshow.main.ui;


import android.os.Bundle;
import android.os.Handler;
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
import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.config.UrlConfig;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehead.HomePageHeadContract;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehead.HomePageHeadModel;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehead.HomePageHeadPresenter;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehead.HomePageTitleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
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
    private HomePageHeadContract.Model model;
    private HomePageHeadContract.Persenter persenter;
    private List<HomePage.ConLiveBean.DataListBean.MyArrayListBean> mList;
    private List<HomePage.ConLiveBean.DataListBean.MyArrayListBean> xList;
    private Handler handler = new Handler();

    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this, view);
        model = new HomePageHeadModel();
        mList = new ArrayList<>();
        xList = new ArrayList<>();
        persenter = new HomePageHeadPresenter(this, model);
        persenter.getData(getParams());
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager llm = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,true);
        recyHomeHeadTitle.setLayoutManager(sgm);
        homePageTitleAdapter = new HomePageTitleAdapter(R.layout.home_page_head_item, xList);
        recyHomeHeadTitle.setAdapter(homePageTitleAdapter);
        return view;
    }

    @OnClick({R.id.iv_search_view, R.id.tv_btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_search_view:
                Toast.makeText(getActivity(), "搜素", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_btn_more:
                Toast.makeText(getActivity(), "更多", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private HashMap<String, String> getParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.HomePageTitleKey.TYPE, "json");
        params.put(UrlConfig.HomePageTitleKey.DATATYPE, "0");
        params.put(UrlConfig.HomePageTitleKey.PAGENO2, "1");
        params.put(UrlConfig.HomePageTitleKey.PAGESIZE2, "6");
        params.put(UrlConfig.HomePageTitleKey.PAGENO3, "1");
        params.put(UrlConfig.HomePageTitleKey.PAGESIZE3, "100");
        params.put(UrlConfig.HomePageTitleKey.SYSTEM, "android");
        params.put(UrlConfig.HomePageTitleKey.VERSION, "3.1.0");
        params.put(UrlConfig.HomePageTitleKey.APPID, "ec1179d6bfd406ba4fac855010ee80c728df297d");
        return params;
    }


    @Override
    public void onSuccess(final HomePage list) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                mList.add(list.getConLive().getDataList().get(0).getMyArrayList().get(0));
                mList.add(list.getConLive().getDataList().get(0).getMyArrayList().get(1));
                mList.add(list.getConLive().getDataList().get(0).getMyArrayList().get(2));
                mList.add(list.getConLive().getDataList().get(0).getMyArrayList().get(3));
                xList.addAll(mList);
                homePageTitleAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onFild(String msg) {

    }
}
