package com.qingyunxuetang.qinghealth.service;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.qingyunxuetang.qinghealth.common.util.AssetUtil;
import com.qingyunxuetang.qinghealth.model.NewsDetailModel;


public class NewsDetailBiz {
    public NewsDetailModel loadNewsDetail(Context context) {

        NewsDetailModel newsDetailModel;
        // 从assets目录读取json文件
        AssetManager assetManager = context.getAssets();
        String string = AssetUtil.getString("news_detail.json", assetManager);
        // 解析json为对象
        Gson gson = new Gson();
        newsDetailModel = gson.fromJson(string, NewsDetailModel.class);

        return newsDetailModel;
    }
}
