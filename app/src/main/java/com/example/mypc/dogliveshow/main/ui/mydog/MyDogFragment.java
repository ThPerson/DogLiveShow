package com.example.mypc.dogliveshow.main.ui.mydog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypc.dogliveshow.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyDogFragment extends Fragment {


    @BindView(R.id.civ_user_icon)
    CircleImageView civUserIcon;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.head_setting)
    ImageView headSetting;
    @BindView(R.id.rl_anchor_time)
    RelativeLayout rlAnchorTime;
    @BindView(R.id.rl_my_watch)
    RelativeLayout rlMyWatch;
    @BindView(R.id.rv_anchor_ranking)
    RelativeLayout rvAnchorRanking;
    @BindView(R.id.rl_plat_form)
    RelativeLayout rlPlatForm;
    @BindView(R.id.tv_offline_msg_no)
    TextView tvOfflineMsgNo;
    @BindView(R.id.rl_offline)
    RelativeLayout rlOffline;
    @BindView(R.id.tv_fav_msg_no)
    TextView tvFavMsgNo;
    @BindView(R.id.rl_fav)
    RelativeLayout rlFav;
    @BindView(R.id.rl_history)
    RelativeLayout rlHistory;

    public MyDogFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_dog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.civ_user_icon, R.id.tv_login, R.id.head_setting, R.id.rl_anchor_time, R.id.rl_my_watch, R.id.rv_anchor_ranking, R.id.rl_plat_form, R.id.rl_offline, R.id.rl_fav, R.id.rl_history})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.civ_user_icon:
                Toast.makeText(getActivity(),"点击了...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_login:
                Toast.makeText(getActivity(),"点击了...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.head_setting:
                startActivity(new Intent(getActivity(),MoreSettingActivity.class));
                break;
            case R.id.rl_anchor_time:
                startActivity(new Intent(getActivity(),AnchorTimeActivity.class));
                break;
            case R.id.rl_my_watch:
                Toast.makeText(getActivity(),"点击了...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rv_anchor_ranking:
                Toast.makeText(getActivity(),"点击了...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_plat_form:
                startActivity(new Intent(getActivity(),PlatFormActivity.class));

                break;
            case R.id.rl_offline:
                startActivity(new Intent(getActivity(),OffLineRedioActivity.class));
                break;
            case R.id.rl_fav:
                startActivity(new Intent(getActivity(),FavoriteActivity.class));
                break;
            case R.id.rl_history:
                startActivity(new Intent(getActivity(),HistoryActivity.class));
                break;
        }
    }
}
