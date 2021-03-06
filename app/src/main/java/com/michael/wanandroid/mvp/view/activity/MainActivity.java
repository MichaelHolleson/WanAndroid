package com.michael.wanandroid.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;

import com.michael.wanandroid.R;
import com.michael.wanandroid.base.BaseActivity;
import com.michael.wanandroid.mvp.view.fragment.HomeFragment;
import com.michael.wanandroid.mvp.view.fragment.MineFragment;
import com.michael.wanandroid.mvp.view.fragment.ProjectFragment;
import com.michael.wanandroid.mvp.view.fragment.TreeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private static final String TAG_FRAGMENT_HOME = "HOME";

    private static final String TAG_FRAGMENT_TREE = "TREE";

    private static final String TAG_FRAGMENT_PROJECT = "PROJECT";

    private static final String TAG_FRAGMENT_MINE = "MINE";

    private String mFragmentTag;

    private FragmentManager mFragmentManager;

    @BindView(R.id.bnv_main)
    BottomNavigationView mBottomNavigationView;

    @BindView(R.id.tv_main_title)
    TextView mTvMainTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFragmentManager = getSupportFragmentManager();
        switchFragment(TAG_FRAGMENT_HOME);
        mTvMainTitle.setText("首页");

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        switchFragment(TAG_FRAGMENT_HOME);
                        mTvMainTitle.setText("首页");
                        break;
                    case R.id.navigation_tree:
                        switchFragment(TAG_FRAGMENT_TREE);
                        mTvMainTitle.setText("知识体系");
                        break;
                    case R.id.navigation_project:
                        switchFragment(TAG_FRAGMENT_PROJECT);
                        mTvMainTitle.setText("项目");
                        break;
                    case R.id.navigation_mine:
                        switchFragment(TAG_FRAGMENT_MINE);
                        mTvMainTitle.setText("我的");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    private void switchFragment(String fragmentTag) {
        if (!TextUtils.isEmpty(mFragmentTag) && mFragmentTag.equals(fragmentTag)) {
            return;
        }

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        Fragment lastFragment = mFragmentManager.findFragmentByTag(mFragmentTag);
        if (lastFragment != null) {
            fragmentTransaction.hide(lastFragment);
        }

        Fragment fragment = mFragmentManager.findFragmentByTag(fragmentTag);
        if (fragment == null) {
            if (TAG_FRAGMENT_HOME.equals(fragmentTag)) {
                fragment = HomeFragment.getInstance();
            } else if (TAG_FRAGMENT_TREE.equals(fragmentTag)) {
                fragment = TreeFragment.getInstance();
            } else if (TAG_FRAGMENT_PROJECT.equals(fragmentTag)) {
                fragment = ProjectFragment.getInstance();
            } else if (TAG_FRAGMENT_MINE.equals(fragmentTag)) {
                fragment = MineFragment.getInstance();
            }
            fragmentTransaction.add(R.id.fl_main, fragment, fragmentTag);
        } else {
            fragmentTransaction.show(fragment);
        }

        fragmentTransaction.commit();

        mFragmentTag = fragmentTag;
    }

}
