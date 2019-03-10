package com.qingyunxuetang.qinghealth.service;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qingyunxuetang.qinghealth.common.util.AssetUtil;
import com.qingyunxuetang.qinghealth.model.NewsListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻列表业务逻辑层
 */
public class NewsListService {

    public List<NewsListModel> loadNewsList(Context context){
        List<NewsListModel> newsListModels = new ArrayList<>();
        AssetManager assetManager = context.getAssets();
        String string = AssetUtil.getString("news_list.json", assetManager);
        Gson gson = new Gson();
        newsListModels = gson.fromJson(string, new TypeToken<List<NewsListModel>>() {
        }.getType());

        return newsListModels;
    }
}
