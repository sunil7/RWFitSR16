package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Looper;

/* loaded from: classes.dex */
final class ja extends rc {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m9 f4335a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f4336b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ka f4337c;

    public ja(ka kaVar, m9 m9Var, boolean z5) {
        this.f4337c = kaVar;
        this.f4335a = m9Var;
        this.f4336b = z5;
    }

    @Override // com.amap.api.col.p0003sl.rc
    public final void runTask() {
        Context context;
        try {
            synchronized (Looper.getMainLooper()) {
                ha.a(this.f4335a);
            }
            if (this.f4336b) {
                context = this.f4337c.f4430d;
                la.a(context);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
