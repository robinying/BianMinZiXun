package com.yubin.bianminzixun.ui;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.yubin.basecommon.utils.BasePreference;
import com.yubin.bianminzixun.MainActivity;
import com.yubin.bianminzixun.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.yubin.basecommon.view.CountDownView;
import com.yubin.basecommon.utils.CheckPermission;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.splash_pic)
    ImageView splashPic;
    @BindView(R.id.countdown)
    CountDownView countdown;
    private Context mContext;
    private static String[] pers = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_NETWORK_STATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mContext = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            CheckPermission checkPermission = new CheckPermission(this, pers);
            checkPermission.checkPermissions();
        }
        countdown.setOnFinishAction(new CountDownView.Action() {
            @Override
            public void onAction() {
                WelcomeActivity.show(mContext);
            }
        });
        countdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        countdown.start();
    }
}
