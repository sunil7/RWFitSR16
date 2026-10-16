package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import o2.m;
import p2.l;

/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3015a = m.i("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        m.g().d(f3015a, String.format("Received intent %s", intent), new Throwable[0]);
        try {
            l a3 = l.a(context);
            BroadcastReceiver.PendingResult goAsync = goAsync();
            synchronized (l.f17424l) {
                try {
                    a3.f17432i = goAsync;
                    if (a3.f17431h) {
                        goAsync.finish();
                        a3.f17432i = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (IllegalStateException e) {
            m.g().f(f3015a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
        }
    }
}
