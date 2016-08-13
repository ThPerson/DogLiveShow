package com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity.classifyvideofragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.dogliveshow.R;


public class ClassifyVideoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View CommentView = inflater.inflate(R.layout.fragment_all_comment,container,false);

        return CommentView;
    }


}
