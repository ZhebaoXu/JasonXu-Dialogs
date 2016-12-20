package com.jasonxu.dialogfragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jasonxu.dialogfragment.MainActivity;
import com.jasonxu.dialogfragment.R;

/**
 * Created by t_xuz on 8/10/16.
 * 说明:使用fragment来做带有背景色的对话框,同时也可以添加动画来增加用户体验
 *
 */
public class CenterFragmentDialog extends Fragment{
    private MainActivity mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (MainActivity)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cneter_fragment_dialog,container,false);
    }
}
