package a1;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import java.util.concurrent.Executor;
import y0.r;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f3a = null;

    public static int a(Context context, String str) {
        if (str != null) {
            return (ic.b() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : new r(context).f19913a.areNotificationsEnabled() ? 0 : -1;
        }
        throw new NullPointerException("permission must be non-null");
    }

    public static int b(Context context, String str) {
        int c9;
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) != -1) {
            String d5 = y0.f.d(str);
            if (d5 != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                int myUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                if (myUid2 != myUid || !k1.b.a(packageName2, packageName)) {
                    c9 = y0.f.c((AppOpsManager) y0.f.a(context, AppOpsManager.class), d5, packageName);
                } else if (Build.VERSION.SDK_INT >= 29) {
                    AppOpsManager c10 = y0.g.c(context);
                    c9 = y0.g.a(c10, d5, Binder.getCallingUid(), packageName);
                    if (c9 == 0) {
                        c9 = y0.g.a(c10, d5, myUid, y0.g.b(context));
                    }
                } else {
                    c9 = y0.f.c((AppOpsManager) y0.f.a(context, AppOpsManager.class), d5, packageName);
                }
                if (c9 != 0) {
                    return -2;
                }
            }
            return 0;
        }
        return -1;
    }

    public static Executor c(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? f.a(context) : new w.d(new Handler(context.getMainLooper()), 2);
    }
}
