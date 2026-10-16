package io.reactivex.internal.operators.observable;

import java.util.Collection;

/* loaded from: classes2.dex */
public final class t0 extends io.reactivex.internal.observers.a {

    /* renamed from: f, reason: collision with root package name */
    public final Collection f14896f;

    /* renamed from: g, reason: collision with root package name */
    public final vg.o f14897g;

    public t0(rg.s sVar, vg.o oVar, Collection collection) {
        super(sVar);
        this.f14897g = oVar;
        this.f14896f = collection;
    }

    @Override // io.reactivex.internal.observers.a, yg.f
    public final void clear() {
        this.f14896f.clear();
        super.clear();
    }

    @Override // io.reactivex.internal.observers.a, rg.s
    public final void onComplete() {
        if (this.f14453d) {
            return;
        }
        this.f14453d = true;
        this.f14896f.clear();
        this.f14450a.onComplete();
    }

    @Override // io.reactivex.internal.observers.a, rg.s
    public final void onError(Throwable th2) {
        if (this.f14453d) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.f14453d = true;
        this.f14896f.clear();
        this.f14450a.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14453d) {
            return;
        }
        int i3 = this.e;
        rg.s sVar = this.f14450a;
        if (i3 != 0) {
            sVar.onNext(null);
            return;
        }
        try {
            Object apply = this.f14897g.apply(obj);
            xg.c.b(apply, "The keySelector returned a null key");
            if (this.f14896f.add(apply)) {
                sVar.onNext(obj);
            }
        } catch (Throwable th2) {
            a(th2);
        }
    }

    @Override // yg.f
    public final Object poll() {
        Object poll;
        Object apply;
        do {
            poll = this.f14452c.poll();
            if (poll == null) {
                break;
            }
            apply = this.f14897g.apply(poll);
            xg.c.b(apply, "The keySelector returned a null key");
        } while (!this.f14896f.add(apply));
        return poll;
    }
}
