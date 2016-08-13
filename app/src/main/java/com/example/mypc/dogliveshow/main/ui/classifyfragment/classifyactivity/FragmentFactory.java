package com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity.classifycommentatorfragment.ClassifyCommentatorFragment;
import com.example.mypc.dogliveshow.main.ui.classifyfragment.classifyactivity.classifyvideofragment.ClassifyVideoFragment;

/**
 * Created by Administrator on 2016/8/13.
 */
public class FragmentFactory {
    private static SparseArray<Fragment> fragmentSparseArray = new SparseArray<>();
    private static final int LOL = 1;
    private static final int COMMENT = 2;

    //创建Fragment对象的工厂方法.
    public static Fragment creatFragment(int position){
        //从集合中取
        Fragment fragment = fragmentSparseArray.get(position);
        if (fragment == null){
            switch (position){
                case LOL:
                    fragment = new ClassifyCommentatorFragment();
                    break;
                case COMMENT:
                    fragment = new ClassifyVideoFragment();
                    break;
            }
            //存储Fragment对象
            fragmentSparseArray.put(position,fragment);
        }
        return fragment;

    }


}
