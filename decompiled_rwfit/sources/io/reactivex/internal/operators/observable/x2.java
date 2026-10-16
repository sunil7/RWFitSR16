package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class x2 implements vg.g {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f15000a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f15001b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y2 f15002c;

    public x2(y2 y2Var, rg.s sVar, AtomicBoolean atomicBoolean) {
        this.f15002c = y2Var;
        this.f15000a = sVar;
        this.f15001b = atomicBoolean;
    }

    @Override // vg.g
    public final void f(Object obj) {
        try {
            this.f15002c.f15022c.c((ug.b) obj);
            y2 y2Var = this.f15002c;
            rg.s sVar = this.f15000a;
            ug.a aVar = y2Var.f15022c;
            ObservableRefCount$ConnectionObserver observableRefCount$ConnectionObserver = new ObservableRefCount$ConnectionObserver(y2Var, sVar, aVar, io.reactivex.disposables.a.a(new x3(3, y2Var, aVar)));
            sVar.onSubscribe(observableRefCount$ConnectionObserver);
            y2Var.f15021b.subscribe(observableRefCount$ConnectionObserver);
        } finally {
            this.f15002c.e.unlock();
            this.f15001b.set(false);
        }
    }
}
