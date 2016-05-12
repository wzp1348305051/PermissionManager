package com.wengzhipeng.permissionmanager;

/**
 * Created by wengzhipeng on 16/5/12.
 * 权限回调接口
 */
public interface IPermissionCallback {
    void onPermissionCallback(int requestCode, String[] permissions, int[] grantResults);
}
