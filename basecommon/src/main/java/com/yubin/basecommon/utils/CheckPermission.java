package com.yubin.basecommon.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;

/**
 * author : Yubin.Ying
 * time : 2018/12/12
 */
public class CheckPermission {

    private static final int REQUEST_PERMISSIONS = 100;
    private Activity mContext;
    private String[] pers;

    public CheckPermission(Activity activity, String[] pers) {
        mContext = activity;
        this.pers = pers;
    }

    public void checkPermissions() {
        if (AndPermission.hasPermission(mContext, pers)) {
        } else {
            AndPermission.with(mContext)
                    .requestCode(REQUEST_PERMISSIONS)
                    .permission(pers)
                    .callback(new PermissionListener() {
                        @Override
                        public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                            if (AndPermission.hasPermission(mContext, pers)) {

                            }
                        }

                        @Override
                        public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                            if (AndPermission.hasPermission(mContext, pers)) {

                                return;
                            }
                            AndPermission.defaultSettingDialog(mContext, REQUEST_PERMISSIONS)
                                    .setTitle("权限申请失败")
                                    .setMessage("您已禁用 \"读写手机存储\" 权限，请在设置中授权！")
                                    .setPositiveButton("好，去设置")
                                    .show();
                        }
                    })
                    .rationale(new RationaleListener() {
                        @Override
                        public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                            AndPermission.rationaleDialog(mContext, rationale).show();
                        }
                    })
                    .start();
        }
    }
}
