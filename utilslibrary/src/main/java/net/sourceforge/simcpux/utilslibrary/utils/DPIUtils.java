package net.sourceforge.simcpux.utilslibrary.utils;

import android.content.Context;

/**
 * Created by huiping.guo on 17/6/27.
 */

public class DPIUtils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 sp 的单位 转成为 px(像素)
     */
    public static float sp2px(float spValue, Context context) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return spValue * scale;
    }

    /**
     * 根据手机的分辨率从  px(像素) 的单位 转成为 sp
     */
    public static float px2sp(float pxValue, Context context) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return pxValue / scale;
    }
}
