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

import java.util.ArrayList;
import java.util.List;

/**
 * 使用ListView控件
 */
public class NewsListActivity2 extends Activity {

    private ListView lvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list2);
        initView();
        List<NewsListModel> newsListModels = loadNewsListModels();
        setView(newsListModels);
    }

    private void initView(){
        lvNews = findViewById(R.id.lv_news);
    }

    private List<NewsListModel> loadNewsListModels(){
        List<NewsListModel> newsListModels = new ArrayList<>();
        NewsListModel newsListModel1 = new NewsListModel();
        newsListModel1.title = "推荐一本好书：这样写出好故事";
        newsListModel1.brief = "卡夫卡说：“我么应该只读那些会咬人和蜇人的书”。只有好故事才会折磨读者！";
        newsListModel1.author = "青云";
        newsListModel1.createTime = "2019-01-25";
        newsListModels.add(newsListModel1);

        NewsListModel newsListModel2 = new NewsListModel();
        newsListModel2.title = "推荐一部电影：我妻子的一切";
        newsListModel2.brief = "电影刚开始，男女主角在日本偶尔相遇，然后陷入爱河。";
        newsListModel2.author = "青云";
        newsListModel2.createTime = "2019-01-14";
        newsListModels.add(newsListModel2);
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
            View newsListItemView = LayoutInflater.from(NewsListActivity2.this).inflate(R.layout.item_news_list, null);
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
