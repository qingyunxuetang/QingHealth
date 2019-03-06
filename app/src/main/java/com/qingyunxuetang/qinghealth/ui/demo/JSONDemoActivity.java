package com.qingyunxuetang.qinghealth.ui.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qingyunxuetang.qinghealth.R;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONDemoActivity extends Activity {
    String json = "{\"status\":10000,\"msg\":\"ok\",\"data\":{\"title\":\"马云1995神预言\",\"author\":\"青云\"}}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_demo);
        TextView tvSource = findViewById(R.id.tv_source);
        tvSource.setText("{\"status\":10000,\n\"msg\":\"ok\",\n\"data\":\n{\"title\":\"马云1995神预言\",\n\"author\":\"青云\"}\n}");
        final TextView tvResult = findViewById(R.id.tv_result);
        Button btParse = findViewById(R.id.bt_parse);
        btParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = parseJson();
                tvResult.setText(result);
            }
        });
    }

    private String parseJson(){
        String result = "";
        try {
            JSONObject jsonObject = new JSONObject(json);
            int status = jsonObject.getInt("status");
            String msg = jsonObject.getString("msg");
            JSONObject data = jsonObject.getJSONObject("data");
            String title = data.getString("title");
            String author = data.getString("author");
            StringBuilder resultSB = new StringBuilder();
            resultSB.append("status:");
            resultSB.append(status);
            resultSB.append("\n");
            resultSB.append("msg:");
            resultSB.append(msg);
            resultSB.append("\n");
            resultSB.append("title");
            resultSB.append(title);
            resultSB.append("\n");
            resultSB.append("author");
            resultSB.append(author);
            result = resultSB.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            result = "解析出错";
        }
        return result;
    }
}
