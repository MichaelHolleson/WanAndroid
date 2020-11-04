package com.michael.wanandroid.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.MenuItem;

import com.michael.wanandroid.R;
import com.michael.wanandroid.base.BaseActivity;
import com.michael.wanandroid.ui.fragment.HomeFragment;
import com.michael.wanandroid.ui.fragment.MineFragment;
import com.michael.wanandroid.ui.fragment.ProjectFragment;
import com.michael.wanandroid.ui.fragment.TreeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

//import butterknife.BindView;
//import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private static final String TAG_FRAGMENT_HOME = "HOME";

    private static final String TAG_FRAGMENT_TREE = "TREE";

    private static final String TAG_FRAGMENT_PROJECT = "PROJECT";

    private static final String TAG_FRAGMENT_MINE = "MINE";

    private String mFragmentTag;

    private FragmentManager mFragmentManager;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView mBottomNavigationView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        switchFragment(TAG_FRAGMENT_HOME);
                        break;
                    case R.id.navigation_tree:
                        switchFragment(TAG_FRAGMENT_TREE);
                        break;
                    case R.id.navigation_project:
                        switchFragment(TAG_FRAGMENT_PROJECT);
                        break;
                    case R.id.navigation_mine:
                        switchFragment(TAG_FRAGMENT_MINE);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        mFragmentManager = getSupportFragmentManager();
        switchFragment(TAG_FRAGMENT_HOME);
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
            fragmentTransaction.add(R.id.frameLayout, fragment, fragmentTag);
        } else {
            fragmentTransaction.show(fragment);
        }

        fragmentTransaction.commit();

        mFragmentTag = fragmentTag;
    }

}
