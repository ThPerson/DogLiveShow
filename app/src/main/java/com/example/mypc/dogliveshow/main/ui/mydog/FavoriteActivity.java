package com.example.mypc.dogliveshow.main.ui.mydog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.dao.User;
import com.example.mypc.dogliveshow.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FavoriteActivity extends AppCompatActivity {

    @BindView(R.id.iv_favorite_back)
    ImageView ivFavoriteBack;
//    @BindView(R.id.tv_favorite_editor)
//    TextView tvFavoriteEditor;
    @BindView(R.id.ll_favorite_empty)
    LinearLayout llFavoriteEmpty;
    @BindView(R.id.lv_favorite)
    ListView lvFavorite;
    private List<String> list = new ArrayList<>();
    private List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        ButterKnife.bind(this);
        lvFavorite.setEmptyView(llFavoriteEmpty);

        users = UserDao.quaryAll(this);
        for(int i = 0; i<users.size(); i++){
            list.add(users.get(i).getFavContent());
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter(FavoriteActivity.this,android.R.layout.simple_list_item_1,list);
        lvFavorite.setAdapter(adapter);

        lvFavorite.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FavoriteActivity.this,"shoucang",Toast.LENGTH_SHORT).show();
            }
        });

        lvFavorite.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());
                builder.setTitle("消息框");
                builder.setMessage("确定要删除这条收藏码?");
                builder.setNegativeButton("取消",null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UserDao.del(FavoriteActivity.this,users.get(position).getFavContent());
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(FavoriteActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                return true;
            }
        });
    }

    @OnClick({R.id.iv_favorite_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_favorite_back:
                onBackPressed();
                break;
//            case R.id.tv_favorite_editor:
//                Toast.makeText(FavoriteActivity.this,"编辑",Toast.LENGTH_SHORT).show();
//                break;
        }
    }


}
