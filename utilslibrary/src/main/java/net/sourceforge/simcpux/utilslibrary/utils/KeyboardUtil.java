package net.sourceforge.simcpux.utilslibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by huiping.guo on 17/6/27.
 */

public class KeyboardUtil {

    public static String SHOW_SOFT_INPUT_METHOD_16 = "setShowSoftInputOnFocus";
    public static String SHOW_SOFT_INPUT_METHOD_14 = "setSoftInputShownOnFocus";

    /**
     * 隐藏键盘
     */
    public static void closeKeyboard(Context context, View view) {
        if(view!=null){
            InputMethodManager inputmanger = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 显示键盘
     */
    public static void showKeyboard(Context context, View view) {
        if(view!=null) {
            InputMethodManager inputmanger = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.showSoftInput(view, InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }


    /**
     * 设置系统键盘不再显示
     */
    public final static void hideSoftInputMethod(Window window, EditText ed) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        int currentVersion = android.os.Build.VERSION.SDK_INT;
        String methodName = null;
        if (currentVersion >= 16) {// 4.2
            methodName = SHOW_SOFT_INPUT_METHOD_16;
        } else if (currentVersion >= 14) {// 4.0
            methodName = SHOW_SOFT_INPUT_METHOD_14;
        }

        if (methodName == null) {
            ed.setInputType(InputType.TYPE_NULL);
        } else {
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnFocus;
            try {
                setShowSoftInputOnFocus = cls.getMethod(methodName, boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(ed, false);
            } catch (NoSuchMethodException e) {
                ed.setInputType(InputType.TYPE_NULL);
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
