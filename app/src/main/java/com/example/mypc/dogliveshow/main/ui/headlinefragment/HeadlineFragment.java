package com.example.mypc.dogliveshow.main.ui.headlinefragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.headlinebean.DataListBean;
import com.example.mypc.dogliveshow.bean.headlinebean.HeadLineBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeadlineFragment extends Fragment implements HeadLineContract.View {

    @BindView(R.id.lv_head_line)
    ListView lvHeadLine;

    private HeadLineContract.Model model;
    private HeadLineContract.Presenter presenter;
    private Handler handler = new Handler() {
    };
    private List<DataListBean> dataBeanList;
    private HeadLineAdapter headLineAdapter;

    public HeadlineFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_headline, container, false);
        ButterKnife.bind(this, view);
        initView();
        model = new HeadLineModel();
        presenter = new HeadLinePresenter(model, this);
        presenter.getHeadLineData(initHeadLineParams());
        lvHeadLine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),HeadLineWeb.class);
                intent.putExtra("url",dataBeanList.get(position).getDetailUrl());
                startActivity(intent);
            }
        });
        return view;
    }

    //初始化
    private void initView() {
        dataBeanList = new ArrayList<>();
        headLineAdapter = new HeadLineAdapter(dataBeanList);
        lvHeadLine.setAdapter(headLineAdapter);

    }

    //url值
    private HashMap<String, String> initHeadLineParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.HeadLineKey.USER_ID, "-1");
        params.put(UrlConfig.HeadLineKey.OS, "android");
        params.put(UrlConfig.HeadLineKey.USERKEY, "fb8352549a374bfd4775884a08167d2078a8b93e");
        params.put(UrlConfig.HeadLineKey.ORDER_ID, "-1");
        params.put(UrlConfig.HeadLineKey.PAGE_SIZE, "20");
        params.put(UrlConfig.HeadLineKey.CATE_ID, "0");
        params.put(UrlConfig.HeadLineKey.IS_NEW, "0");
        params.put(UrlConfig.HeadLineKey.SYSTEM, "android");
        params.put(UrlConfig.HeadLineKey.VERSION, "3.1.0");
        params.put(UrlConfig.HeadLineKey.APPID, "fb8352549a374bfd4775884a08167d2078a8b93e");
        return params;
    }

    @Override
    public void onSuccess(final HeadLineBean headLineBean) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                dataBeanList.addAll(headLineBean.getDataList());
                headLineAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(getContext(), "" + msg, Toast.LENGTH_SHORT).show();
    }
}
