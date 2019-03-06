package com.qingyunxuetang.qinghealth.ui.news;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qingyunxuetang.qinghealth.R;
import com.qingyunxuetang.qinghealth.model.NewsListModel;


/**
 * 使用LinearLayout，实现单条item的新闻列表
 */
public class NewsListActivity extends Activity {

    private LinearLayout llNewsItem;
    private TextView tvNewsTitle;
    private TextView tvNewsBrief;
    private TextView tvNewsAuthor;
    private TextView tvNewsCreateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        initView();
        NewsListModel newsListModel = loadNewsListModel();
        setView2(newsListModel);
    }

    private void initView(){
        llNewsItem = findViewById(R.id.ll_news_item);
        tvNewsTitle = findViewById(R.id.tv_news_title);
        tvNewsBrief = findViewById(R.id.tv_news_brief);
        tvNewsAuthor = findViewById(R.id.tv_news_author);
        tvNewsCreateTime = findViewById(R.id.tv_news_create_time);

        llNewsItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsListActivity.this, NewsDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private NewsListModel loadNewsListModel(){
        NewsListModel newsListModel = new NewsListModel();
        newsListModel.title = "推荐一本好书：这样写出好故事";
        newsListModel.brief = "卡夫卡说：“我么应该只读那些会咬人和蜇人的书”。只有好故事才会折磨读者！";
        newsListModel.author = "青云";
        newsListModel.createTime = "2019-01-25";
        return newsListModel;
    }

    private void setView2(NewsListModel newsListModel){
        tvNewsTitle.setText(newsListModel.title);
        tvNewsBrief.setText(newsListModel.brief);
        tvNewsAuthor.setText(newsListModel.author);
        tvNewsCreateTime.setText(newsListModel.createTime);
    }

    private void setView(){
        tvNewsTitle.setText("推荐一本好书：这样写出好故事");
        tvNewsBrief.setText("卡夫卡说：“我么应该只读那些会咬人和蜇人的书”。只有好故事才会折磨读者！");
        tvNewsAuthor.setText("青云");
        tvNewsCreateTime.setText("2019-01-25");
    }
}
