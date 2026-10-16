package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.b0;

/* loaded from: classes.dex */
class i0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e5 f4279a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0.q0 f4280b;

    public i0(b0.q0 q0Var, e5 e5Var) {
        this.f4280b = q0Var;
        this.f4279a = e5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4279a.a(b0.this.f3671u.floor_names);
            this.f4279a.a(b0.this.f3671u.activeFloorName);
            if (this.f4279a.b()) {
                return;
            }
            this.f4279a.a(true);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
