package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.media.b;
import android.support.v4.media.g;
import android.support.v4.media.session.e;
import android.util.Log;
import java.util.List;
import n.g0;

/* loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    public static ComponentName a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (queryIntentServices.isEmpty()) {
            return null;
        }
        StringBuilder r = e.r("Expected 1 service that handles ", str, ", found ");
        r.append(queryIntentServices.size());
        throw new IllegalStateException(r.toString());
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName a3 = a(context, "android.intent.action.MEDIA_BUTTON");
        if (a3 != null) {
            intent.setComponent(a3);
            context.startForegroundService(intent);
            return;
        }
        ComponentName a10 = a(context, "android.media.browse.MediaBrowserService");
        if (a10 == null) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        BroadcastReceiver.PendingResult goAsync = goAsync();
        Context applicationContext = context.getApplicationContext();
        g0 g0Var = new g0();
        g0Var.f16174a = new b(g0Var);
        g0Var.f16176c = applicationContext;
        g0Var.f16177d = intent;
        g0Var.e = goAsync;
        g gVar = new g(applicationContext, a10, g0Var);
        g0Var.f16178f = gVar;
        Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        gVar.f311a.f304b.connect();
    }
}
