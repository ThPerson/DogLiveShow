package com.example.mypc.dogliveshow.main.ui.classifyfragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.classifybean.DataListBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ClassifyFragment extends Fragment implements ClassifyContract.View{

    private ClassifyAdapter classifyAdapter;
    private GridLayoutManager layoutManager;
    private ClassifyContract.Model model;
    private ClassifyContract.Presenter presenter;
    private List<DataListBean> mList;
    private Handler mHandler = new Handler();
    public ClassifyFragment(){}

    @BindView(R.id.classify_recycler_view)
    RecyclerView recyclerClassify;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View framentView = inflater.inflate(R.layout.fragment_classify,container,false);
        ButterKnife.bind(this,framentView);
        initView();
        model = new ClassifyModel();
        presenter = new ClassifyPresenter(this,model);
        presenter.initData(initParams());
        return framentView;
    }

    private HashMap<String,String> initParams() {
        HashMap<String,String> params = new HashMap<>();
        params.put(UrlConfig.ClassifyKey.APPVER,"3.1.0");
        params.put(UrlConfig.ClassifyKey.PAGENO,"1");
        params.put(UrlConfig.ClassifyKey.PAGESIZE,"100");
        params.put(UrlConfig.ClassifyKey.SYSTEM,"android");
        params.put(UrlConfig.ClassifyKey.SYSVER,"4.4.4");
        params.put(UrlConfig.ClassifyKey.TYPE,"json");
        return params;
    }

    private void initView() {
        mList = new ArrayList<>();
        classifyAdapter = new ClassifyAdapter(R.layout.item_classify_list,mList);
        layoutManager = new GridLayoutManager(getContext(),3);
        recyclerClassify.setLayoutManager(layoutManager);
        recyclerClassify.setAdapter(classifyAdapter);
    }

    

    @Override
    public void onSuccessGetClassify(final List<DataListBean> dataListBeen) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mList.addAll(dataListBeen);
                Log.e("TAG","-------------------------"+mList.size());
                classifyAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onFailGetClassify(String msg) {
        Toast.makeText(getContext(), ""+msg, Toast.LENGTH_SHORT).show();
    }
}
