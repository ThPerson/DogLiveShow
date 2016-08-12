package com.example.mypc.dogliveshow.main.ui.classifyfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.classifybean.DataListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class ClassifyFragment extends Fragment {

    private ClassifyAdapter classifyAdapter;
    private GridLayoutManager layoutManager;

    public ClassifyFragment(){}

    @BindView(R.id.classify_recycler_view)
    RecyclerView recyclerClassify;

    private List<DataListBean> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initView();
        return inflater.inflate(R.layout.fragment_classify, container, false);
    }

    private void initView() {
        mList = new ArrayList<>();
        classifyAdapter = new ClassifyAdapter(R.layout.item_classify_list,mList);
        layoutManager = new GridLayoutManager(getContext(),3);
        recyclerClassify.setLayoutManager(layoutManager);
        recyclerClassify.setAdapter(classifyAdapter);
    }


}
