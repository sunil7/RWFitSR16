package com.example.baselibrary.utils;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7267a;

    public c(int i3) {
        this.f7267a = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.f7268a.post(new androidx.activity.e(this, 10));
    }
}
