package com.example.mypc.dogliveshow.main.ui;


import android.content.Intent;
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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;
import com.example.mypc.dogliveshow.config.UrlConfig;
import com.example.mypc.dogliveshow.main.ui.activitymore.MoreGuanActivity;
import com.example.mypc.dogliveshow.main.ui.homepage.PlayVideoActivity;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehead.HomePageHeadContract;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehead.HomePageHeadModel;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehead.HomePageHeadPresenter;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehead.HomePageTitleAdapter;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehotvideo.HomePageHotAdapter;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehotvideo.HomePageHotContract;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehotvideo.HomePageHotModel;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagehotvideo.HomePageHotPresenter;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagereclive.HomePageRecLiveAdapter;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagereclive.HomePageRecLiveContract;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagereclive.HomePageRecLiveModel;
import com.example.mypc.dogliveshow.main.ui.homepage.homepagereclive.HomePageRecLivePresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements HomePageHeadContract.View, HomePageRecLiveContract.View,HomePageHotContract.View {


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
    private HomePageRecLiveAdapter recLiveAdapter;
    private HomePageHotAdapter hotAdapter;
    private HomePageHeadContract.Model model;
    private HomePageHeadContract.Persenter persenter;
    private HomePageRecLiveContract.Model recModel;
    private HomePageRecLiveContract.Persenter recLivePresenter;
    private HomePageHotContract.Model hotModel;
    private HomePageHotContract.Persenter hotPersenter;
    private List<HomePage.ConLiveBean.DataListBean.MyArrayListBean> mList;
    private List<HomePage.ConLiveBean.DataListBean.MyArrayListBean> xList;
    private List<HomePage.RecLiveBean.DataListBean.MyArrayListBean> recList;
    private List<HomePage.RecLiveBean.DataListBean.MyArrayListBean> xRecList;
    private List<HomePage.HotLiveBean.DataListBean.MyArrayListBean> hotList;
    private List<HomePage.HotLiveBean.DataListBean.MyArrayListBean> xHotList;
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


        getHeadImage();
        getRecLiveRes();
        getHomeHot();
        return view;
    }

    private void getHeadImage() {
        mList = new ArrayList<>();
        xList = new ArrayList<>();
        model = new HomePageHeadModel();
        persenter = new HomePageHeadPresenter(this, model);
        persenter.getData(getParams());
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyHomeHeadTitle.setLayoutManager(sgm);
        homePageTitleAdapter = new HomePageTitleAdapter(R.layout.home_page_head_item, xList);
        recyHomeHeadTitle.setAdapter(homePageTitleAdapter);

    }

    private void getRecLiveRes() {
        recList = new ArrayList<>();
        xRecList = new ArrayList<>();
        recModel = new HomePageRecLiveModel();
        recLivePresenter = new HomePageRecLivePresenter(this, recModel);
        recLivePresenter.getData(getParams());
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerHomePageForyou.setLayoutManager(sgm);
        recLiveAdapter = new HomePageRecLiveAdapter(R.layout.home_rec_live_item, xRecList);
        recyclerHomePageForyou.setAdapter(recLiveAdapter);
    }
    private void getHomeHot() {
        hotList = new ArrayList<>();
        xHotList = new ArrayList<>();
        hotModel = new HomePageHotModel();
        hotPersenter = new HomePageHotPresenter(this, hotModel);
        hotPersenter.getData(getParams());
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerHotFire.setLayoutManager(sgm);
        hotAdapter = new HomePageHotAdapter(R.layout.home_rec_live_item, xHotList);
        recyclerHotFire.setAdapter(hotAdapter);
    }

    @OnClick({R.id.iv_search_view, R.id.tv_btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_search_view:
                Toast.makeText(getActivity(), "搜素", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_btn_more:
                startActivity(new Intent(getActivity(), MoreGuanActivity.class));
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


    private void setHeadRecLive(final HomePage list) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <list.getRecLive().getDataList().get(0).getMyArrayList().size() ; i++) {
                    recList.add(list.getRecLive().getDataList().get(0).getMyArrayList().get(i));
                }
                xRecList.addAll(recList);
                recLiveAdapter.notifyDataSetChanged();
                recLiveAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        String roomid = list.getRecLive().getDataList().get(0).getMyArrayList().get(i).getMap().getRoomid();
                        String sourcesite = list.getRecLive().getDataList().get(0).getMyArrayList().get(i).getMap().getSourcesite();
                        Intent intent = new Intent(getActivity(),PlayVideoActivity.class);
                        intent.putExtra("roomid",roomid);
                        intent.putExtra("sourcesite",sourcesite);
                        if("www.quanmin.tv".equals(sourcesite)){
                            startActivity(intent);
                        }else if("www.kktv5.com".equals(sourcesite)){
                            startActivity(intent);
                        }else{
                            Toast.makeText(getActivity(),"i+++++"+i,Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

    private void setHeadTitleImage(final HomePage list) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < list.getConLive().getDataList().get(0).getMyArrayList().size(); i++) {
                    mList.add(list.getConLive().getDataList().get(0).getMyArrayList().get(i));
                }
                xList.addAll(mList);
                homePageTitleAdapter.notifyDataSetChanged();
                homePageTitleAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        String roomid = list.getConLive().getDataList().get(0).getMyArrayList().get(i).getMap().getRoomid();
                        String sourcesite = list.getConLive().getDataList().get(0).getMyArrayList().get(i).getMap().getSourcesite();
                        Intent intent = new Intent(getActivity(),PlayVideoActivity.class);
                        intent.putExtra("roomid",roomid);
                        intent.putExtra("sourcesite",sourcesite);
                        if("www.quanmin.tv".equals(sourcesite)){
                            startActivity(intent);
                        }else if("www.kktv5.com".equals(sourcesite)){
                            startActivity(intent);
                        }else{
                            Toast.makeText(getActivity(),"i+++++"+i,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
    private void setHeadHotImage(final HomePage list) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < list.getHotLive().getDataList().get(0).getMyArrayList().size(); i++) {
                    hotList.add(list.getHotLive().getDataList().get(0).getMyArrayList().get(i));
                }
                xHotList.addAll(hotList);
                hotAdapter.notifyDataSetChanged();
                hotAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        String roomid = list.getHotLive().getDataList().get(0).getMyArrayList().get(i).getMap().getRoomid();
                        String sourcesite = list.getHotLive().getDataList().get(0).getMyArrayList().get(i).getMap().getSourcesite();
                        Intent intent = new Intent(getActivity(),PlayVideoActivity.class);
                        intent.putExtra("roomid",roomid);
                        intent.putExtra("sourcesite",sourcesite);
                        if("www.quanmin.tv".equals(sourcesite)){
                            startActivity(intent);
                        }else if("www.kktv5.com".equals(sourcesite)){
                            startActivity(intent);
                        }else{
                            Toast.makeText(getActivity(),"i+++++"+i,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onSuccess(HomePage list) {
        if (list.getConLive() != null) {
            setHeadTitleImage(list);
        } else if (list.getRecLive() != null) {
            setHeadRecLive(list);

        }else if(list.getHotLive()!=null){
            setHeadHotImage(list);
        }

    }


    @Override
    public void onFild(String msg) {

    }
}
