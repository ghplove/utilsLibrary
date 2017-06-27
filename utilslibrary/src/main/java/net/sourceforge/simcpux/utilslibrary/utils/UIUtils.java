package net.sourceforge.simcpux.utilslibrary.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by huiping.guo on 17/6/27.
 */

public class UIUtils {

    public static String SHOW_SOFT_INPUT_METHOD_16 = "setShowSoftInputOnFocus";
    public static String SHOW_SOFT_INPUT_METHOD_14 = "setSoftInputShownOnFocus";


    /**
     * 读取 显示度量
     */
    private static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    /**
     * 获取屏幕宽度
     */
    public final static int getWindowsWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public final static int getWindowsHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    /**
     * 状态栏高度
     */
    public static int getStatusBarHeight(Context mContext) {
        int STATUS_BAR_HEIGHT = 0;
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            STATUS_BAR_HEIGHT = mContext.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return STATUS_BAR_HEIGHT;
    }

}
