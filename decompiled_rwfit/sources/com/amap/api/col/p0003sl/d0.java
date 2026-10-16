package com.amap.api.col.p0003sl;

import android.os.Message;

/* loaded from: classes.dex */
class d0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ double f3879a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ double f3880b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ b0 f3881c;

    public d0(b0 b0Var, double d5, double d8) {
        this.f3881c = b0Var;
        this.f3879a = d5;
        this.f3880b = d8;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message obtain = Message.obtain();
        obtain.what = 19;
        obtain.arg1 = (int) this.f3879a;
        obtain.arg2 = (int) this.f3880b;
        this.f3881c.E0.sendMessage(obtain);
    }
}
