package com.example.mypc.dogliveshow.main.ui.mydog;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.bean.maydogbean.PlatFormBean;
import com.example.mypc.dogliveshow.config.UrlConfig;
import com.example.mypc.dogliveshow.main.ui.mydog.platform.DownloadService;
import com.example.mypc.dogliveshow.main.ui.mydog.platform.PlatFormAdapter;
import com.example.mypc.dogliveshow.main.ui.mydog.platform.PlatFormContact;
import com.example.mypc.dogliveshow.main.ui.mydog.platform.PlatFormModel;
import com.example.mypc.dogliveshow.main.ui.mydog.platform.PlatFormPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class PlatFormActivity extends AppCompatActivity implements PlatFormContact.View {

    @BindView(R.id.iv_plat_form_back)
    ImageView ivPlatFormBack;
    @BindView(R.id.rv_plat_form)
    RecyclerView rvPlatForm;

    private PlatFormContact.Presenter presenter;
    private PlatFormContact.Model model;
    private Handler handler = new Handler() {
    };
    private List<PlatFormBean> list;
    private PlatFormAdapter adapter;
    private LinearLayoutManager manager;
    private MyReceiver receiver;
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plat_form);
        ButterKnife.bind(this);
        initView();
        model = new PlatFormModel();
        presenter = new PlatFormPresenter(model, this);
        presenter.getData(initPlatFormParams());

    }


    private void initView() {
        mProgressDialog = new ProgressDialog(this);
        list = new ArrayList<>();
        receiver = new MyReceiver();
        registerReceiver(receiver, new IntentFilter("completed"));
        adapter = new PlatFormAdapter(R.layout.item_plat_form, list);
        manager = new LinearLayoutManager(this);
        rvPlatForm.setLayoutManager(manager);
        rvPlatForm.setAdapter(adapter);

        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Toast.makeText(PlatFormActivity.this, "开始下载-->" + list.get(i).getName(), Toast.LENGTH_SHORT).show();
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 设置水平进度条
                mProgressDialog.setCancelable(true);// 设置是否可以通过点击Back键取消
                mProgressDialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
                mProgressDialog.setIcon(R.mipmap.ic_launcher);// 设置提示的title的图标，默认是没有的
                mProgressDialog.setTitle("提示");
                mProgressDialog.setMax(100);
                mProgressDialog.show();
                Intent intent = new Intent(PlatFormActivity.this, DownloadService.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("url",list.get(i).getAndroiddownloadurl());
//                bundle.putString("name",list.get(i).getAndroidPackageName());
                intent.putExtra("url",list.get(i).getAndroiddownloadurl());

                intent.putExtra("receiver", new DownloadReceiver(new Handler()));
                startService(intent);
            }
        });
    }

    //url值
    private HashMap<String, String> initPlatFormParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.PlatFormKey.USER_ID, "-1");
        params.put(UrlConfig.PlatFormKey.OS, "android");
        params.put(UrlConfig.PlatFormKey.USERKEY, "fb8352549a374bfd4775884a08167d2078a8b93e");
        params.put(UrlConfig.PlatFormKey.NAME, "all");
        params.put(UrlConfig.PlatFormKey.SYSTEM, "android");
        params.put(UrlConfig.PlatFormKey.VERSION, "3.1.0");
        params.put(UrlConfig.PlatFormKey.APPID, "fb8352549a374bfd4775884a08167d2078a8b93e");
        return params;
    }

    @OnClick(R.id.iv_plat_form_back)
    public void onClick() {
        onBackPressed();
    }

    @Override
    public void onSuccess(final List<PlatFormBean> platFormBean) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                list.addAll(platFormBean);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(PlatFormActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("completed".equals(action)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PlatFormActivity.this);
                builder.setTitle("消息提示:");
                builder.setMessage("安装包已经下载完成!");
                builder.setPositiveButton("OK",null);
                builder.show();
            }
        }
    }
    private class DownloadReceiver extends ResultReceiver {
        public DownloadReceiver(Handler handler) {
            super(handler);
        }
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if (resultCode == DownloadService.UPDATE_PROGRESS) {
                int progress = resultData.getInt("progress");
                mProgressDialog.setProgress(progress);
                if (progress == 100) {
                    mProgressDialog.dismiss();
                }
            }
        }
    }
}
