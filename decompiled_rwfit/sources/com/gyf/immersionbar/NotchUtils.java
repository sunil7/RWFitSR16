package com.gyf.immersionbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class NotchUtils {
    private static final String NOTCH_HUA_WEI = "com.huawei.android.util.HwNotchSizeUtil";
    private static final String NOTCH_OPPO = "com.oppo.feature.screen.heteromorphism";
    private static final String NOTCH_VIVO = "android.util.FtFeature";
    private static final String NOTCH_XIAO_MI = "ro.miui.notch";
    private static final String SYSTEM_PROPERTIES = "android.os.SystemProperties";

    private static int dp2px(Context context, int i3) {
        return (int) TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }

    private static DisplayCutout getDisplayCutout(Activity activity) {
        Window window;
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT < 28 || activity == null || (window = activity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
            return null;
        }
        displayCutout = rootWindowInsets.getDisplayCutout();
        return displayCutout;
    }

    private static int[] getHuaWeiNotchSize(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
            return (int[]) loadClass.getMethod("getNotchSize", null).invoke(loadClass, null);
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return iArr;
        }
    }

    public static int getNotchHeight(Activity activity) {
        int safeInsetLeft;
        int safeInsetLeft2;
        int safeInsetRight;
        int safeInsetTop;
        int statusBarHeight = ImmersionBar.getStatusBarHeight(activity);
        DisplayCutout displayCutout = getDisplayCutout(activity);
        if (Build.VERSION.SDK_INT >= 28 && displayCutout != null) {
            if (activity.getResources().getConfiguration().orientation == 1) {
                safeInsetTop = displayCutout.getSafeInsetTop();
                return safeInsetTop;
            }
            safeInsetLeft = displayCutout.getSafeInsetLeft();
            if (safeInsetLeft == 0) {
                safeInsetRight = displayCutout.getSafeInsetRight();
                return safeInsetRight;
            }
            safeInsetLeft2 = displayCutout.getSafeInsetLeft();
            return safeInsetLeft2;
        }
        int xiaoMiNotchHeight = hasNotchAtXiaoMi(activity) ? getXiaoMiNotchHeight(activity) : 0;
        if (hasNotchAtHuaWei(activity)) {
            xiaoMiNotchHeight = getHuaWeiNotchSize(activity)[1];
        }
        if (hasNotchAtVIVO(activity) && (xiaoMiNotchHeight = dp2px(activity, 32)) < statusBarHeight) {
            xiaoMiNotchHeight = statusBarHeight;
        }
        if (!hasNotchAtOPPO(activity)) {
            return xiaoMiNotchHeight;
        }
        if (80 < statusBarHeight) {
            return statusBarHeight;
        }
        return 80;
    }

    private static int getXiaoMiNotchHeight(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static boolean hasNotchAtAndroidP(View view) {
        return getDisplayCutout(view) != null;
    }

    private static boolean hasNotchAtHuaWei(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", null).invoke(loadClass, null)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    private static boolean hasNotchAtOPPO(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature(NOTCH_OPPO);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean hasNotchAtVIVO(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_VIVO);
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean hasNotchAtXiaoMi(android.content.Context r4) {
        /*
            java.lang.String r0 = "Xiaomi"
            java.lang.String r1 = android.os.Build.MANUFACTURER
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto L38
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = "android.os.SystemProperties"
            java.lang.Class r4 = r4.loadClass(r0)     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = "getInt"
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L38
            java.lang.Class[] r2 = new java.lang.Class[]{r2, r3}     // Catch: java.lang.Throwable -> L38
            java.lang.reflect.Method r0 = r4.getMethod(r0, r2)     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = "ro.miui.notch"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L38
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r3}     // Catch: java.lang.Throwable -> L38
            java.lang.Object r4 = r0.invoke(r4, r2)     // Catch: java.lang.Throwable -> L38
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L38
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L38
            goto L39
        L38:
            r4 = r1
        L39:
            r0 = 1
            if (r4 != r0) goto L3d
            r1 = r0
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.NotchUtils.hasNotchAtXiaoMi(android.content.Context):boolean");
    }

    public static boolean hasNotchScreen(Activity activity) {
        if (activity != null) {
            return hasNotchAtXiaoMi(activity) || hasNotchAtHuaWei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVIVO(activity) || hasNotchAtAndroidP(activity);
        }
        return false;
    }

    private static boolean hasNotchAtAndroidP(Activity activity) {
        return getDisplayCutout(activity) != null;
    }

    private static DisplayCutout getDisplayCutout(View view) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT < 28 || view == null || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return null;
        }
        displayCutout = rootWindowInsets.getDisplayCutout();
        return displayCutout;
    }

    public static boolean hasNotchScreen(View view) {
        if (view != null) {
            return hasNotchAtXiaoMi(view.getContext()) || hasNotchAtHuaWei(view.getContext()) || hasNotchAtOPPO(view.getContext()) || hasNotchAtVIVO(view.getContext()) || hasNotchAtAndroidP(view);
        }
        return false;
    }
}
