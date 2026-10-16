package com.google.android.gms.internal.mlkit_vision_barcode;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.XXApplication;

/* loaded from: classes.dex */
public abstract class u1 {
    public static com.example.test.utils.a a(Context context) {
        PackageInfo packageInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.loadLabel(packageManager).toString();
        applicationInfo.loadIcon(packageManager);
        String str = packageInfo.versionName;
        com.example.test.utils.a aVar = new com.example.test.utils.a();
        aVar.f8718a = str;
        return aVar;
    }

    public static boolean b(XXApplication xXApplication) {
        int myPid = Process.myPid();
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) xXApplication.getApplicationContext().getSystemService(Const.STR_PROCESS_TAG)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                str = runningAppProcessInfo.processName;
            }
        }
        return str.equals(xXApplication.getPackageName());
    }
}
