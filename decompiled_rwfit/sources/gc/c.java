package gc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final o4.c f14026a = new o4.c("CommonUtils", "");

    public static String a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            String concat = "Exception thrown when trying to get app version ".concat(e.toString());
            o4.c cVar = f14026a;
            if (!Log.isLoggable((String) cVar.f16732a, 6)) {
                return "";
            }
            Log.e("CommonUtils", cVar.r(concat));
            return "";
        }
    }
}
