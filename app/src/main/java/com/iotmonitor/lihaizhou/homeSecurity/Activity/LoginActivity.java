package com.iotmonitor.lihaizhou.homeSecurity.Activity;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iotmonitor.lihaizhou.homeSecurity.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.go_to_mainpage)
    Button goMainpageBtn;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.register)
    FloatingActionButton registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.et_username, R.id.et_password, R.id.go_to_mainpage, R.id.forget_password, R.id.register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_username:
                break;
            case R.id.et_password:
                break;
            case R.id.go_to_mainpage:
                Explode explode = new Explode();
                explode.setDuration(500);
                getWindow().setExitTransition(explode);
                getWindow().setEnterTransition(explode);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                startActivity(new Intent(this,MainActivity.class), activityOptionsCompat.toBundle());
                break;
            case R.id.forget_password:
                break;
            case R.id.register:
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, registerBtn, registerBtn.getTransitionName());
                    startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
                }
                else
                {
                    startActivity(new Intent(this, RegisterActivity.class));
                }
                break;
        }
    }
}
