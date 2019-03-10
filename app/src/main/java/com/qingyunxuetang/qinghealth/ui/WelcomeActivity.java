package com.qingyunxuetang.qinghealth.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.qingyunxuetang.qinghealth.R;
import com.qingyunxuetang.qinghealth.ui.main.MainActivity;

import java.lang.ref.WeakReference;

public class WelcomeActivity extends Activity {

    final static int START_HOME = 1001;
    MyHandler handler = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // 延迟2000毫秒发送消息
        handler.sendEmptyMessageDelayed(START_HOME, 2000);
    }
    static class MyHandler extends Handler {
        // 使用弱引用避免handler内存泄漏
        WeakReference<Activity> wrfActivity;
        public MyHandler(Activity activity){
            wrfActivity = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            wrfActivity.get().finish();
            Intent intent = new Intent(wrfActivity.get(), MainActivity.class);
            wrfActivity.get().startActivity(intent);
        }
    }
}
