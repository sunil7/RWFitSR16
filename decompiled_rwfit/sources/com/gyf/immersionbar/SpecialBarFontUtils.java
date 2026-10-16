package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class SpecialBarFontUtils {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    private static Method mSetStatusBarColorIcon;
    private static Method mSetStatusBarDarkIcon;
    private static Field mStatusBarColorFiled;

    static {
        try {
            mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    private static boolean changeMeizuFlag(WindowManager.LayoutParams layoutParams, String str, boolean z5) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i3 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i10 = declaredField2.getInt(layoutParams);
            int i11 = z5 ? i3 | i10 : (~i3) & i10;
            if (i10 == i11) {
                return false;
            }
            declaredField2.setInt(layoutParams, i11);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
            return false;
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static boolean isBlackColor(int i3, int i10) {
        return toGrey(i3) < i10;
    }

    @SuppressLint({"PrivateApi"})
    public static void setMIUIBarDark(Window window, String str, boolean z5) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i3 = cls2.getField(str).getInt(cls2);
                Class cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                if (z5) {
                    method.invoke(window, Integer.valueOf(i3), Integer.valueOf(i3));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i3));
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void setStatusBarColor(Window window, int i3) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i3) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i3));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i3) {
        Method method = mSetStatusBarColorIcon;
        if (method == null) {
            boolean isBlackColor = isBlackColor(i3, 50);
            if (mStatusBarColorFiled == null) {
                setStatusBarDarkIcon(activity, isBlackColor);
                return;
            } else {
                setStatusBarDarkIcon(activity, isBlackColor, isBlackColor);
                setStatusBarDarkIcon(activity.getWindow(), i3);
                return;
            }
        }
        try {
            method.invoke(activity, Integer.valueOf(i3));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e10) {
            e10.printStackTrace();
        }
    }

    public static int toGrey(int i3) {
        return (((i3 & 255) * 15) + ((((65280 & i3) >> 8) * 75) + (((i3 & 16711680) >> 16) * 38))) >> 7;
    }

    public static void setStatusBarDarkIcon(Window window, int i3) {
        try {
            setStatusBarColor(window, i3);
            setStatusBarDarkIcon(window.getDecorView(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z5) {
        setStatusBarDarkIcon(activity, z5, true);
    }

    private static void setStatusBarDarkIcon(View view, boolean z5) {
        int i3;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z5) {
            i3 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i3 = (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        }
        if (i3 != systemUiVisibility) {
            view.setSystemUiVisibility(i3);
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z5) {
        setStatusBarDarkIcon(window.getDecorView(), z5);
        setStatusBarColor(window, 0);
    }

    private static void setStatusBarDarkIcon(Activity activity, boolean z5, boolean z6) {
        Method method = mSetStatusBarDarkIcon;
        if (method == null) {
            if (z6) {
                setStatusBarDarkIcon(activity.getWindow(), z5);
                return;
            }
            return;
        }
        try {
            method.invoke(activity, Boolean.valueOf(z5));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e10) {
            e10.printStackTrace();
        }
    }
}
