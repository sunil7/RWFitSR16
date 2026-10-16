package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
class g0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4162a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0 f4163b;

    public g0(b0 b0Var, int i3) {
        this.f4163b = b0Var;
        this.f4162a = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4163b.f3634c0.clearAllMessages(this.f4162a);
            this.f4163b.f3634c0.clearAnimations(this.f4162a, true);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
