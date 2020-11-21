package com.michael.wanandroid.mvp.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.michael.wanandroid.R;
import com.michael.wanandroid.core.bean.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleListViewHolder> {
    private static final String TAG = "ArticleListAdapter";

    private Context mContext;

    private List<Article>  mArticleBeans;

    public ArticleListAdapter(Context context) {
        mContext = context;
    }

    public void setArticleBeans(List<Article> articleBeans) {
        mArticleBeans = articleBeans;
    }

    @NonNull
    @Override
    public ArticleListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_article_list, null, false);
        return new ArticleListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleListViewHolder articleListViewHolder, int i) {
        Article articleBean = mArticleBeans.get(i);
        if (articleBean != null) {
            articleListViewHolder.mTvTitle.setText(articleBean.getTitle());
            articleListViewHolder.mTvChapterName.setText(articleBean.getSuperChapterName() + "/" + articleBean.getChapterName());
            if (!TextUtils.isEmpty(articleBean.getAuthor())) {
                articleListViewHolder.mTvAuthor.setText(articleBean.getAuthor());
            } else {
                articleListViewHolder.mTvAuthor.setText(articleBean.getShareUser());
            }
            articleListViewHolder.mTvTime.setText(articleBean.getNiceDate());
        }
    }

    @Override
    public int getItemCount() {
        return mArticleBeans == null ? 0 : mArticleBeans.size();
    }

    static class ArticleListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_chapter_name)
        TextView mTvChapterName;

        @BindView(R.id.tv_title)
        TextView mTvTitle;

        @BindView(R.id.tv_time)
        TextView mTvTime;

        @BindView(R.id.tv_author)
        TextView mTvAuthor;

        public ArticleListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
