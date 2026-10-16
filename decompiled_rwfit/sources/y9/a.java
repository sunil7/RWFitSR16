package y9;

import aa.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import q9.v;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f20039a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f20040b;

    public final void a(Context context, v vVar) {
        try {
            context.unbindService(vVar);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    public final boolean b(Context context, String str, Intent intent, v vVar, Executor executor) {
        boolean bindService;
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((c.a(context).f144a.getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (executor == null) {
            executor = null;
        }
        if (Build.VERSION.SDK_INT < 29 || executor == null) {
            return context.bindService(intent, vVar, 4225);
        }
        bindService = context.bindService(intent, 4225, executor, vVar);
        return bindService;
    }
}
