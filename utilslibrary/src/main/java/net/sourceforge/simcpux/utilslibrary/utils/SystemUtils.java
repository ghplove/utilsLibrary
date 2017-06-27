package net.sourceforge.simcpux.utilslibrary.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import java.util.List;

/**
 * Created by huiping.guo on 17/6/27.
 */

public class SystemUtils {

    /**
     * 获取包名
     */
    public static String getPackName(Context context) {
        String packName = context.getPackageName();
        return TextUtils.isEmpty(packName) ? "" : packName;
    }


    /**
     * 启动其他应用
     */
    public static void openApp(Context mContext, String pkgName) {
        PackageManager pkgManager = mContext.getPackageManager();
        Intent intent = new Intent();
        intent = pkgManager.getLaunchIntentForPackage(pkgName);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
                | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(intent);
    }

    /**
     * 应用程序是否在栈顶
     */
    public static boolean isTopActivity(Activity activity, String activityFullName) {
        ActivityManager activityManager = (ActivityManager) activity
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasksInfo = activityManager.getRunningTasks(1);
        if (tasksInfo.size() > 0) {
            String name = tasksInfo.get(0).topActivity.getClassName();
            // 应用程序位于堆栈的顶层
            if (activityFullName.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
