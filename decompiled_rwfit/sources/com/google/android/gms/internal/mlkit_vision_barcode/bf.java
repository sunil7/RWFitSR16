package com.google.android.gms.internal.mlkit_vision_barcode;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;

/* loaded from: classes.dex */
public abstract class bf {
    public static final boolean a(Context context) {
        kotlin.jvm.internal.e.f(context, "<this>");
        Object systemService = context.getSystemService(Const.STR_PROCESS_TAG);
        kotlin.jvm.internal.e.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses2 = activityManager.getRunningAppProcesses();
        kotlin.jvm.internal.e.e(runningAppProcesses2, "getRunningAppProcesses(...)");
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses2) {
            if (runningAppProcessInfo.pid == Process.myPid() && kotlin.jvm.internal.e.a(runningAppProcessInfo.processName, context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(Context context) {
        try {
            Object systemService = context.getApplicationContext().getSystemService("power");
            kotlin.jvm.internal.e.d(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            return ((PowerManager) systemService).isScreenOn();
        } catch (Exception unused) {
            return false;
        }
    }
}
