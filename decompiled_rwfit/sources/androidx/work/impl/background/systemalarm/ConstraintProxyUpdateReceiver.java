package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import e8.a;
import o2.m;
import p2.l;

/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3014a = m.i("ConstrntProxyUpdtRecvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if ("androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            l.a(context).f17428d.p(new a(intent, 9, context, goAsync()));
        } else {
            m.g().d(f3014a, l0.n("Ignoring unknown action ", action), new Throwable[0]);
        }
    }
}
