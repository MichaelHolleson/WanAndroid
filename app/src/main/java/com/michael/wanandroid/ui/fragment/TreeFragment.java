package com.michael.wanandroid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michael.wanandroid.R;
import com.michael.wanandroid.base.BaseFragment;

public class TreeFragment extends BaseFragment {

    public static TreeFragment getInstance() {
        TreeFragment fragment = new TreeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tree, null, false);

        return view;
    }

}
