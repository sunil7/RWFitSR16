package com.amap.api.col.p0003sl;

import android.view.MotionEvent;

/* loaded from: classes.dex */
class c0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MotionEvent f3795a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b0 f3796b;

    public c0(b0 b0Var, MotionEvent motionEvent) {
        this.f3796b = b0Var;
        this.f3795a = motionEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f3796b.f3634c0.addGestureSingleTapMessage(this.f3795a.getX(), this.f3795a.getY());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
