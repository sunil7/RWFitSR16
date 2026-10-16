package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class q2 extends zg.a {

    /* renamed from: a, reason: collision with root package name */
    public final rg.l f14838a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f14839b;

    /* renamed from: c, reason: collision with root package name */
    public final p2 f14840c;

    public q2(p2 p2Var, rg.l lVar, AtomicReference atomicReference) {
        this.f14840c = p2Var;
        this.f14838a = lVar;
        this.f14839b = atomicReference;
    }

    @Override // zg.a
    public final void c(vg.g gVar) {
        o2 o2Var;
        loop0: while (true) {
            AtomicReference atomicReference = this.f14839b;
            o2Var = (o2) atomicReference.get();
            if (o2Var != null && !o2Var.isDisposed()) {
                break;
            }
            o2 o2Var2 = new o2(atomicReference);
            while (!atomicReference.compareAndSet(o2Var, o2Var2)) {
                if (atomicReference.get() != o2Var) {
                    break;
                }
            }
            o2Var = o2Var2;
            break loop0;
        }
        AtomicBoolean atomicBoolean = o2Var.f14796c;
        boolean z5 = false;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            z5 = true;
        }
        try {
            gVar.f(o2Var);
            if (z5) {
                this.f14838a.subscribe(o2Var);
            }
        } catch (Throwable th2) {
            ad.a(th2);
            throw io.reactivex.internal.util.b.b(th2);
        }
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        this.f14840c.subscribe(sVar);
    }
}
