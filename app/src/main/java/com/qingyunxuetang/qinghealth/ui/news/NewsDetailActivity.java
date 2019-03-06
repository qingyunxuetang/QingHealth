package com.qingyunxuetang.qinghealth.ui.news;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.qingyunxuetang.qinghealth.R;
import com.qingyunxuetang.qinghealth.model.NewsDetailModel;
import com.qingyunxuetang.qinghealth.service.NewsDetailBiz;

public class NewsDetailActivity extends Activity {

    private TextView tvNewsTitle;
    private TextView tvNewsAuthor;
    private TextView tvNewsCreateTime;
    private TextView tvNewsContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        initView();
        NewsDetailModel newsDetailModel = loadNewsDetail();
        setView(newsDetailModel);
    }

    private void setView(NewsDetailModel newsDetailModel) {
        tvNewsTitle.setText(newsDetailModel.title);
        tvNewsAuthor.setText(newsDetailModel.author);
        tvNewsCreateTime.setText(newsDetailModel.createTime);
        tvNewsContent.setText(newsDetailModel.content);
        tvNewsContent.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    private NewsDetailModel loadNewsDetail() {
        NewsDetailBiz newsDetailBiz = new NewsDetailBiz();
        NewsDetailModel newsDetailModel = newsDetailBiz.loadNewsDetail(this.getApplicationContext());
        return newsDetailModel;
    }

    private void initView(){
        tvNewsTitle = findViewById(R.id.tv_news_title);
        tvNewsAuthor = findViewById(R.id.tv_news_author);
        tvNewsCreateTime = findViewById(R.id.tv_news_create_time);
        tvNewsContent = findViewById(R.id.tv_news_content);
    }
}
