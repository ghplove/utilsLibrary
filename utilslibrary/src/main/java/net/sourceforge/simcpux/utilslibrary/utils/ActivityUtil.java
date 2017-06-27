package net.sourceforge.simcpux.utilslibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;

/**
 * Created by huiping.guo on 17/6/27.
 */

public class ActivityUtil {

    public static Activity castToActivity(Context context) {
        try {
            ContextWrapper baseContext = (ContextWrapper) context;
            while (!(baseContext instanceof Activity)) {
                ContextWrapper contextWrapper = (ContextWrapper) baseContext.getBaseContext();
                if (contextWrapper == baseContext) {
                    throw new RuntimeException("Context 转Activity 异常");
                }
                baseContext = contextWrapper;
            }
            return (Activity) baseContext;
        } catch (Throwable throwable) {
            throw new RuntimeException("Context 转Activity 异常");
        }
    }

    public static Activity getActivity(View view) {
        Context context = view.getContext();
        return castToActivity(context);
    }
}
