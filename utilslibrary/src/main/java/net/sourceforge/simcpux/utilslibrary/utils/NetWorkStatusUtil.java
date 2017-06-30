package net.sourceforge.simcpux.utilslibrary.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * Created by huiping.guo on 17/6/29.
 */

public class NetWorkStatusUtil {
    public static int initialTimeoutMs=1;
    public static final int NETWORKTYPE_UNKNOWN=0;
    public static final int NETWORKTYPE_WAP=1;
    public static final int NETWORKTYPE_WIFI=2;
    public static final int NETWORKTYPE_4G=3;
    public static final int NETWORKTYPE_3G=4;
    public static final int NETWORKTYPE_2G=5;
    //获取网络的状态
    public static int getNetWorkStatus(Context context){
        int mNetWorkType=0;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null){
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null && networkInfo.isConnected()){
                int type = networkInfo.getType();
                if(type == ConnectivityManager.TYPE_WIFI){
                    mNetWorkType=NETWORKTYPE_WIFI;
                }else if(type == ConnectivityManager.TYPE_MOBILE){

                    mNetWorkType=isFastMobileNetWork(networkInfo);
                }
            }
        }
        return mNetWorkType;
    }


    public static boolean getNetWorkEnable(Context context){
        int mNetWorkType = getNetWorkStatus(context);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null){
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null){
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    public static int isFastMobileNetWork(NetworkInfo networkInfo){
        String subTypeName = networkInfo.getSubtypeName();
        int networkType = networkInfo.getSubtype();
        switch (networkType){
            case TelephonyManager.NETWORK_TYPE_1xRTT://50-100kbps
            case TelephonyManager.NETWORK_TYPE_CDMA://14-64kbps  电信2g
            case TelephonyManager.NETWORK_TYPE_EDGE://50-100kbps  移动2g
            case TelephonyManager.NETWORK_TYPE_IDEN://25kbps
            case TelephonyManager.NETWORK_TYPE_GPRS://100kbps  联通2g
                return NETWORKTYPE_2G;
            case TelephonyManager.NETWORK_TYPE_EVDO_0://400-1000kbps
            case TelephonyManager.NETWORK_TYPE_EVDO_A://600-1400kbps  电信3g
            case TelephonyManager.NETWORK_TYPE_HSDPA://2-14Mbps
            case TelephonyManager.NETWORK_TYPE_HSPA://700-1700kbps
            case TelephonyManager.NETWORK_TYPE_HSUPA://1-23Mbps
            case TelephonyManager.NETWORK_TYPE_UMTS://400-700kbps
            case TelephonyManager.NETWORK_TYPE_EHRPD://1-2Mbps
            case TelephonyManager.NETWORK_TYPE_EVDO_B://5Mbps
            case TelephonyManager.NETWORK_TYPE_HSPAP://10-20Mbps
                return NETWORKTYPE_3G;
            case TelephonyManager.NETWORK_TYPE_LTE://10+Mbps
                return NETWORKTYPE_4G;
            default:
                // http://baike.baidu.com/item/TD-SCDMA 中国移动 联通 电信 三种3G制式
                if (subTypeName.equalsIgnoreCase("TD-SCDMA") || subTypeName.equalsIgnoreCase("WCDMA") || subTypeName.equalsIgnoreCase("CDMA2000"))
                {
                    return NETWORKTYPE_3G;
                }
                return NETWORKTYPE_UNKNOWN;
        }
    }

    private static void setInitialTimeoutMs(Context context,int wifi,int g4,int g3,int g2){
        int mNetWorkType=getNetWorkStatus(context);
        switch (mNetWorkType){
            case NETWORKTYPE_WIFI:
                initialTimeoutMs=wifi;
                break;
            case NETWORKTYPE_4G:
                initialTimeoutMs=g4;
                break;
            case NETWORKTYPE_3G:
                initialTimeoutMs=g3;
                break;
            case NETWORKTYPE_2G:
                initialTimeoutMs=g2;
                break;
            default:
                initialTimeoutMs=wifi;
                break;
        }
    }
}
