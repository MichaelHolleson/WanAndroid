package com.michael.wanandroid.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michael.wanandroid.R;
import com.michael.wanandroid.base.BaseFragment;

public class ProjectFragment extends BaseFragment {

    public static ProjectFragment getInstance() {
        ProjectFragment fragment = new ProjectFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_project, null, false);

        return view;
    }
}
