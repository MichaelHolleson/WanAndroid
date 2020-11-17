package com.michael.wanandroid.api;


import com.michael.wanandroid.api.response.ArticleListResp;
import com.michael.wanandroid.api.response.BannerResp;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    String BASE_URL = "https://www.wanandroid.com";

    @GET("article/list/{index}/json")
    Observable<ArticleListResp> getArticleList(@Path("index") int index);

    @GET("banner/json")
    Observable<BannerResp> getBanner();



}
