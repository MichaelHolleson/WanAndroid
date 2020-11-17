package com.michael.wanandroid.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.michael.wanandroid.R;
import com.michael.wanandroid.api.ApiService;
import com.michael.wanandroid.api.response.ArticleListResp;
import com.michael.wanandroid.base.BaseFragment;
import com.michael.wanandroid.ui.adapter.ArticleListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends BaseFragment {

    private static final String TAG = "HomeFragment";

    @BindView(R.id.srl_home)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.rv_home)
    RecyclerView mRecyclerView;


    private Unbinder mUnbinder;

    private Context mContext;

    private ArticleListAdapter mArticleListAdapter;

    private int mIndex;

    public static HomeFragment getInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null, false);
        mUnbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }


    private void init() {
        mContext = getActivity();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIndex = 0;
                request();
            }
        });

        mArticleListAdapter = new ArticleListAdapter(mContext);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setAdapter(mArticleListAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        request();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }


    private void request() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Observable<ArticleListResp> observable = apiService.getArticleList(mIndex);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticleListResp>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe");

                    }

                    @Override
                    public void onNext(ArticleListResp articleListResp) {
                        Log.d(TAG, "onNext " + articleListResp.toString());
                        mArticleListAdapter.setArticleBeans(articleListResp.data.getDatas());
                        mArticleListAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError " + e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");

                    }
                });
    }

    public static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG + "--->> ", message);
            }
        });
        loggingInterceptor.setLevel(level);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(loggingInterceptor);
        return httpClientBuilder.build();
    }

}
