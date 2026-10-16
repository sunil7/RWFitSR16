package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class n implements ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14762a;

    /* renamed from: b, reason: collision with root package name */
    public final ObservableAmb$AmbInnerObserver[] f14763b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f14764c = new AtomicInteger();

    public n(rg.s sVar, int i3) {
        this.f14762a = sVar;
        this.f14763b = new ObservableAmb$AmbInnerObserver[i3];
    }

    public final boolean a(int i3) {
        AtomicInteger atomicInteger = this.f14764c;
        int i10 = atomicInteger.get();
        int i11 = 0;
        if (i10 != 0) {
            return i10 == i3;
        }
        if (!atomicInteger.compareAndSet(0, i3)) {
            return false;
        }
        ObservableAmb$AmbInnerObserver[] observableAmb$AmbInnerObserverArr = this.f14763b;
        int length = observableAmb$AmbInnerObserverArr.length;
        while (i11 < length) {
            int i12 = i11 + 1;
            if (i12 != i3) {
                observableAmb$AmbInnerObserverArr[i11].dispose();
            }
            i11 = i12;
        }
        return true;
    }

    @Override // ug.b
    public final void dispose() {
        AtomicInteger atomicInteger = this.f14764c;
        if (atomicInteger.get() != -1) {
            atomicInteger.lazySet(-1);
            for (ObservableAmb$AmbInnerObserver observableAmb$AmbInnerObserver : this.f14763b) {
                observableAmb$AmbInnerObserver.dispose();
            }
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14764c.get() == -1;
    }
}
