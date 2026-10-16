package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public final class y2 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final zg.a f15021b;

    /* renamed from: c, reason: collision with root package name */
    public volatile ug.a f15022c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f15023d;
    public final ReentrantLock e;

    public y2(zg.a aVar) {
        super(aVar);
        this.f15022c = new ug.a();
        this.f15023d = new AtomicInteger();
        this.e = new ReentrantLock();
        this.f15021b = aVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        boolean z5;
        this.e.lock();
        if (this.f15023d.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f15021b.c(new x2(this, sVar, atomicBoolean));
                if (z5) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
        try {
            ug.a aVar = this.f15022c;
            ObservableRefCount$ConnectionObserver observableRefCount$ConnectionObserver = new ObservableRefCount$ConnectionObserver(this, sVar, aVar, io.reactivex.disposables.a.a(new x3(3, this, aVar)));
            sVar.onSubscribe(observableRefCount$ConnectionObserver);
            this.f15021b.subscribe(observableRefCount$ConnectionObserver);
        } finally {
            this.e.unlock();
        }
    }
}
