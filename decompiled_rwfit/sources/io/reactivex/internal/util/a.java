package io.reactivex.internal.util;

import java.util.concurrent.CountDownLatch;
import vg.g;

/* loaded from: classes2.dex */
public final class a extends CountDownLatch implements g, vg.a {

    /* renamed from: a, reason: collision with root package name */
    public Throwable f15122a;

    @Override // vg.g
    public final void f(Object obj) {
        this.f15122a = (Throwable) obj;
        countDown();
    }

    @Override // vg.a
    public final void run() {
        countDown();
    }
}
