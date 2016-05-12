package com.wengzhipeng.permissionmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.SparseArray;

/**
 * Created by wengzhipeng on 16/5/12.
 */
public class PermissionHelper {
    private SparseArray<IPermissionCallback> mCallbacks;

    private static class PermissionHelperHolder {
        private static final PermissionHelper INSTANCE = new PermissionHelper();
    }

    private PermissionHelper() {
        mCallbacks = new SparseArray<>();
    }

    /**
     * 获取权限管理帮助类实例
     *
     * @return PermissionHelper实例
     */
    public static PermissionHelper getInstance() {
        return PermissionHelperHolder.INSTANCE;
    }

    /**
     * 判断Activity是否已经获取相应权限
     *
     * @param activity   上下文
     * @param permission 权限名称，由PermissionRequest获取
     * @return true or false
     */
    public boolean hasSelfPermission(Activity activity, String permission) {
        return PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(activity, permission);
    }

    /**
     * 判断Activity是否已经获取相应一些权限
     *
     * @param activity    上下文
     * @param permissions 权限名称列表，每个权限由PermissionRequest获取
     * @return true or false
     */
    public boolean hasSelfPermissions(Activity activity, String... permissions) {
        for (String permission : permissions) {
            if (!hasSelfPermission(activity, permission)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否应该展示权限获取提示框
     *
     * @param activity   上下文
     * @param permission 权限名称，由PermissionRequest获取
     * @return true or false
     */
    public static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
    }

    /**
     * 是否应该展示权限获取提示框
     *
     * @param activity    上下文
     * @param permissions 权限名称列表，每个权限由PermissionRequest获取
     * @return true or false
     */
    public static boolean shouldShowRequestPermissionRationales(Activity activity, String... permissions) {
        for (String permission : permissions) {
            if (shouldShowRequestPermissionRationale(activity, permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 请求权限
     *
     * @param activity    上下文
     * @param requestCode 请求码
     * @param callback    回调
     * @param permissions 权限名称列表，每个权限由PermissionRequest获取
     */
    public void requestPermissions(final Activity activity, final int requestCode, IPermissionCallback callback, final String... permissions) {
        if (callback != null) {
            mCallbacks.put(requestCode, callback);
        }
        ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }

    /**
     * 检查权限是否被允许
     *
     * @param grantResults 权限结果列表
     * @return true or false
     */
    public static boolean verifyPermissions(int... grantResults) {
        if (grantResults.length == 0) {
            return false;
        }
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 权限请求回调，此方法须由Activity的onRequestPermissionsResult方法调用
     *
     * @param requestCode  请求码
     * @param permissions  权限
     * @param grantResults 权限请求结果
     */
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        IPermissionCallback callback = mCallbacks.get(requestCode);
        if (callback != null) {
            callback.onPermissionCallback(requestCode, permissions, grantResults);
            mCallbacks.remove(requestCode);
        }
    }

}
