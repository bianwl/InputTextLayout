package com.lyz.textinputlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lyz.textinputlayoutdemo.util.PatternUtil;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout mTip_userName;
    private TextInputLayout mTip_pwd;
    private Button mLogin;
    private Button mRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
    }

    private void initEvent() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email  = mTip_userName.getEditText().getText().toString();
                String password  = mTip_pwd.getEditText().getText().toString();
                if(!PatternUtil.validateEmail(email) && !PatternUtil.validatePassword(password)){
                    mTip_userName.setError("Not a valid email address!");
                    mTip_pwd.setError("Not a valid password!");
                }else if(!PatternUtil.validateEmail(email)){
                    mTip_userName.setError("Not a valid email address!");
                    mTip_pwd.setErrorEnabled(false);
                }else if(!PatternUtil.validatePassword(password)){
                    mTip_pwd.setError("Not a valid password!");
                    mTip_userName.setErrorEnabled(false);
                }else{
                    mTip_pwd.setErrorEnabled(false);
                    mTip_userName.setErrorEnabled(false);
                }
            }
        });
    }

    private void initView() {
        mTip_userName = (TextInputLayout) findViewById(R.id.id_layout_usernameWrapper);
        mTip_pwd = (TextInputLayout) findViewById(R.id.id_layout_passwordWrapper);
        mLogin = (Button) findViewById(R.id.id_btn_login);
        mRegist = (Button) findViewById(R.id.id_btn_regist);
    }

}
