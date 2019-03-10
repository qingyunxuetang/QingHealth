package com.qingyunxuetang.qinghealth.ui.news;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.qingyunxuetang.qinghealth.R;
import com.qingyunxuetang.qinghealth.model.NewsListModel;
import com.qingyunxuetang.qinghealth.service.NewsListService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class NewsListActivity3 extends Activity {

    private ListView lvNews;
    private NewsListService newsListService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list2);
        initView();
        List<NewsListModel> newsListModels = loadNewsListModels();
        setView(newsListModels);
        newsListService = new NewsListService();
    }

    private void initView(){
        lvNews = findViewById(R.id.lv_news);
    }

    private List<NewsListModel> loadNewsListModels(){
        List<NewsListModel> newsListModels = newsListService.loadNewsList(this.getApplicationContext());
        return newsListModels;
    }

    private void setView(List<NewsListModel> newsListModels){
        NewsAdapter newsAdapter = new NewsAdapter(newsListModels);
        lvNews.setAdapter(newsAdapter);
//        newsAdapter.notifyDataSetChanged();
    }

    class NewsAdapter extends BaseAdapter{
        private List<NewsListModel> newsListModels;
        public NewsAdapter(List<NewsListModel> newsListModels){
            if(newsListModels == null) {
                newsListModels = new ArrayList<>();
            }
            this.newsListModels = newsListModels;
        }
        @Override
        public int getCount() {
            return newsListModels.size();
        }

        @Override
        public Object getItem(int position) {
            return newsListModels.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View newsListItemView = LayoutInflater.from(NewsListActivity3.this).inflate(R.layout.item_news_list, null);
            TextView tvNewsTitle = newsListItemView.findViewById(R.id.tv_news_title);
            TextView tvNewsBrief = newsListItemView.findViewById(R.id.tv_news_brief);
            TextView tvNewsAuthor = newsListItemView.findViewById(R.id.tv_news_author);
            TextView tvNewsCreateTime = newsListItemView.findViewById(R.id.tv_news_create_time);
            NewsListModel newsListModel = newsListModels.get(position);
            tvNewsTitle.setText(newsListModel.title);
            tvNewsBrief.setText(newsListModel.brief);
            tvNewsAuthor.setText(newsListModel.author);
            tvNewsCreateTime.setText(newsListModel.createTime);
            return newsListItemView;
        }
    }
}
