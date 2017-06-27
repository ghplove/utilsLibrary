package net.sourceforge.simcpux.utilslibrary.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.util.UUID;

/**
 * Created by huiping.guo on 17/6/27.
 */

public class DeviceUtils {
    /**
     * 获取手机厂商
     */
    public static String getManufacturer(){
        return android.os.Build.MANUFACTURER;
    }

    /**
     * 读取手机型号
     */
    public static String getDeviceModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取用户系统安卓SDK版本大小
     */
    public static int getOsSdk() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 读取手机系统发布版本号
     */
    public static String getDeviceVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 读取手机sdk版本号
     */
    public static String getDeviceSDK() {
        return android.os.Build.VERSION.SDK;
    }

    /**
     * 获取设备IMSI
     */
    public static String getIMSIOld(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getSubscriberId();
    }

    /**
     * 读取设备id
     */
    public static String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    /**
     * 获取UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 读取电话号码
     */
    public static String getPhoneNumber(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getLine1Number();
    }

    /**
     * 获取版本号code
     */
    public static int getVersionCode(Context content) {
        try {
            PackageManager manager = content.getPackageManager();
            PackageInfo info = manager.getPackageInfo(content.getPackageName(), 0);
            int version = info.versionCode;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    /**
     * 获取版本号name
     */
    public static String getVersionName(Context content) {
        try {
            PackageManager manager = content.getPackageManager();
            PackageInfo info = manager.getPackageInfo(content.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取机器iMei值
     * 如果设备不存在imei，生成一个时间戳作为标示
     */
    public static String getImei(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        if (TextUtils.isEmpty(imei)) {
            imei = System.currentTimeMillis() + "";
        }
        return imei;
    }

    /**
     * 获取机器mac值
     */
    public static String getMac(Context context) {
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (wifi == null) {
            return "";
        }
        WifiInfo info = wifi.getConnectionInfo();
        if (info == null || info.getMacAddress() == null) {
            return "";
        }
        return info.getMacAddress().toLowerCase();
    }

}
