package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
class e0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c5 f3953a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0 f3954b;

    public e0(b0 b0Var, c5 c5Var) {
        this.f3954b = b0Var;
        this.f3953a = c5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z5;
        z5 = this.f3954b.f3664q;
        if (z5) {
            return;
        }
        try {
            b0 b0Var = this.f3954b;
            v1 v1Var = b0Var.f3671u;
            if (v1Var != null) {
                b0Var.setIndoorBuildingInfo(v1Var);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f3953a.setVisibility(8);
    }
}
