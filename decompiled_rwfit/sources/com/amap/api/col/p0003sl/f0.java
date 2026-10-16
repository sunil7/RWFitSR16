package com.amap.api.col.p0003sl;

import com.autonavi.base.ae.gmap.GLMapEngine;

/* loaded from: classes.dex */
class f0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4051a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0 f4052b;

    public f0(b0 b0Var, int i3) {
        this.f4052b = b0Var;
        this.f4051a = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z5;
        GLMapEngine gLMapEngine;
        z5 = this.f4052b.f3661o0;
        if (!z5 || (gLMapEngine = this.f4052b.f3634c0) == null) {
            return;
        }
        gLMapEngine.setHighlightSubwayEnable(this.f4051a, false);
    }
}
