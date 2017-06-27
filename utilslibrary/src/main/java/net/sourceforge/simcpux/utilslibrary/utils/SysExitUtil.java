package net.sourceforge.simcpux.utilslibrary.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huiping.guo on 17/6/27.
 */

public class SysExitUtil {

    //建立一个public static的list用来放activity
    public static List<Activity> activityList = new ArrayList();

    //finish所有list中的activity
    public static void exitAllActivity() {
        int siz = activityList.size();
        for (int i = 0; i < siz; i++) {
            if (activityList.get(i) != null) {
                ((Activity) activityList.get(i)).finish();
            }
        }
        activityList.clear();
    }

    public static boolean isHaveActivity(Class clazz) {
        for (Activity a : activityList) {
            if (a.getClass().equals(clazz)) {
                return true;
            }
        }
        return false;
    }

}
