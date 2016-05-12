package com.wengzhipeng.permissionmanager;

import android.Manifest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wengzhipeng on 16/5/12.
 * Android 6.0及以上需动态获取的权限类
 */
public class PermissionRequest {
    public static final String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public static final String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;

    public static final String CAMERA = Manifest.permission.CAMERA;

    public static final String READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public static final String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static final String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;

    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

    public static final String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;

    public static final String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public static final String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;

    public static final String USE_SIP = Manifest.permission.USE_SIP;
    public static final String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;

    public static final String BODY_SENSORS = Manifest.permission.BODY_SENSORS;

    public static final String SEND_SMS = Manifest.permission.SEND_SMS;
    public static final String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public static final String READ_SMS = Manifest.permission.READ_SMS;
    public static final String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public static final String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;

    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;

    private static Map<String, String> mDescriptionMap;
    static {
        mDescriptionMap = new HashMap<>();
        mDescriptionMap.put(READ_CALENDAR, "读取日历信息");
        mDescriptionMap.put(WRITE_CALENDAR, "写入日历信息");
        mDescriptionMap.put(CAMERA, "相机");
        mDescriptionMap.put(READ_CONTACTS, "读取联系人");
        mDescriptionMap.put(WRITE_CONTACTS, "写入联系人");
        mDescriptionMap.put(GET_ACCOUNTS, "获取账号");
        mDescriptionMap.put(ACCESS_FINE_LOCATION, "获取精确位置");
        mDescriptionMap.put(ACCESS_COARSE_LOCATION, "获取粗略位置");
        mDescriptionMap.put(RECORD_AUDIO, "录音");
        mDescriptionMap.put(READ_PHONE_STATE, "读取手机状态");
        mDescriptionMap.put(CALL_PHONE, "拨打电话");
        mDescriptionMap.put(READ_CALL_LOG, "读取通话日志");
        mDescriptionMap.put(WRITE_CALL_LOG, "写入通话日志");
        mDescriptionMap.put(USE_SIP, "使用SIP");
        mDescriptionMap.put(PROCESS_OUTGOING_CALLS, "监听、控制、取消呼出电话");
        mDescriptionMap.put(BODY_SENSORS, "体传感器");
        mDescriptionMap.put(SEND_SMS, "发送短信");
        mDescriptionMap.put(RECEIVE_SMS, "接收短信");
        mDescriptionMap.put(READ_SMS, "读取短信");
        mDescriptionMap.put(RECEIVE_WAP_PUSH, "接收WAP推送");
        mDescriptionMap.put(RECEIVE_MMS, "接收彩信");
        mDescriptionMap.put(READ_EXTERNAL_STORAGE, "读取外置存储");
        mDescriptionMap.put(WRITE_EXTERNAL_STORAGE, "写入外置存储");
    }

    /**
     * 获取权限描述
     * @param permission 权限
     * @return 权限描述
     */
    public static String getPermissionDescription(String permission) {
        String description = mDescriptionMap.get(permission);
        return description == null ? "" : description;
    }

}
