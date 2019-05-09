package com.qingyunxuetang.qinghealth.ui.profile;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.qingyunxuetang.qinghealth.R;
import com.qingyunxuetang.qinghealth.common.base.BaseActivity;
import com.qingyunxuetang.qinghealth.common.util.RegUtil;

public class LoginActivity extends BaseActivity {
    protected static String TAG;

    private View tvLoginRemind;
    private View tvLogin;
    private View rlLoginPwdLayout;
    private EditText etLoginPwd;
    private View ivLoginPwdShow;
    private EditText etLoginName;
    private View ivLoginNameDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();

        tvLoginRemind = findViewById(R.id.login_remind);
        tvLogin = findViewById(R.id.login);
        rlLoginPwdLayout = findViewById(R.id.login_pwd_layout);
        etLoginPwd = findViewById(R.id.login_pwd);
        ivLoginPwdShow = findViewById(R.id.login_pwd_show);
        etLoginName = findViewById(R.id.login_name);
        ivLoginNameDelete = findViewById(R.id.login_name_delete);

        etLoginName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkNameAndPwd();

                if (TextUtils.isEmpty(s.toString())) {

                } else {
                    ivLoginNameDelete.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private boolean checkNameAndPwd() {
        // 密码输入 校验

        String loginPwd = etLoginPwd.getText().toString();
        String loginName = etLoginName.getText().toString();
//        if (!RegUtils.isUserName(loginName)) {
//            tvLogin.setEnabled(false);
//            return;
//        }
        if (TextUtils.isEmpty(loginName)) {
            tvLogin.setEnabled(false);
            return false;
        }
        if (!RegUtil.isPassword(loginPwd)) {
            tvLogin.setEnabled(false);
            return false;
        }
        tvLogin.setEnabled(true);
        return true;
    }

}
