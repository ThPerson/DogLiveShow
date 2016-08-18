package com.example.mypc.dogliveshow.main.ui.activitymore.concern;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.moreanchor.AnchorBean;
import com.example.mypc.dogliveshow.config.UrlConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConcernFragment extends Fragment implements ConcernContract.View {


    @BindView(R.id.tv_my_concern)
    TextView tvMyConcern;
    @BindView(R.id.iv_empty_show)
    ImageView ivEmptyShow;
    @BindView(R.id.recycler_view_concern)
    ListView recyclerViewConcern;
    @BindView(R.id.recy_tuijian_concern)
    RecyclerView recyTuijianConcern;
    private RecyclerView rect_view;
    private ListView myList;
    private ConcernContract.Presenter presenter;
    private ConcernContract.Model model;
    private ConcerAdapter adapter;

    public ConcernFragment() {
        // Required empty public constructor
    }

    private List<AnchorBean.RecZhuboBean.DataListBean> list;
    private List<AnchorBean.RecZhuboBean.DataListBean> mList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_concern, container, false);
        TextView my_concern = (TextView) view.findViewById(R.id.tv_my_concern);
        ImageView ivEmpty = (ImageView) view.findViewById(R.id.iv_empty_show);
        myList = (ListView) view.findViewById(R.id.recycler_view_concern);
        myList.setEmptyView(ivEmpty);
        rect_view = (RecyclerView) view.findViewById(R.id.recy_tuijian_concern);
        model = new ConcernModel();
        presenter = new ConcernPresenter(this, model);
        presenter.getData(getParams());
        LinearLayoutManager llm = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,true);
        rect_view.setLayoutManager(llm);
        list = new ArrayList<>();
        mList = new ArrayList<>();
        adapter = new ConcerAdapter(R.layout.fragment_concer_item,mList);
        rect_view.setAdapter(adapter);
        ButterKnife.bind(this, view);
        return view;
    }
    private HashMap<String, String> getParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.AnchorMoreKey.TYPE, "json");
        params.put(UrlConfig.AnchorMoreKey.APPID, "425a746c-4106-438e-89ea-757a30edeaca");
        return params;
    }
    @Override
    public void onSuccess(AnchorBean bean) {
        for (int i = 0; i < bean.getRecZhubo().getDataList().size() ; i++) {
            list.add(bean.getRecZhubo().getDataList().get(i));
        }
        mList.addAll(list);
        adapter.notifyDataSetChanged();
//        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
//            @Override
//            public void onItemClick(View view, int i) {
//                startActivity(new Intent(getActivity(), AnchorDetailActivity.class));
//            }
//        });

    }

    @Override
    public void onFild(String msg) {

    }
}
