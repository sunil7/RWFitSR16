package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OverwritingInputMerger;
import androidx.work.impl.workers.DiagnosticsWorker;
import java.util.Collections;
import java.util.List;
import o2.m;
import o2.n;
import o2.o;
import p2.e;
import p2.l;
import x2.h;

/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3022a = m.i("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String str = f3022a;
        m.g().d(str, "Requesting diagnostics", new Throwable[0]);
        try {
            l a3 = l.a(context);
            n nVar = new n(DiagnosticsWorker.class);
            ((h) nVar.f195b).f19752d = OverwritingInputMerger.class.getName();
            List singletonList = Collections.singletonList((o) nVar.a());
            if (singletonList.isEmpty()) {
                throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
            }
            new e(a3, null, ExistingWorkPolicy.KEEP, singletonList).a();
        } catch (IllegalStateException e) {
            m.g().f(str, "WorkManager is not initialized", e);
        }
    }
}
