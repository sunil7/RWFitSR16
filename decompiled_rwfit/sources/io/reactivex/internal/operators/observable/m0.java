package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class m0 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final ah.c f14743a;

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14744b;

    /* renamed from: c, reason: collision with root package name */
    public ug.b f14745c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f14746d = new AtomicReference();
    public volatile long e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14747f;

    public m0(ah.c cVar, vg.o oVar) {
        this.f14743a = cVar;
        this.f14744b = oVar;
    }

    @Override // ug.b
    public final void dispose() {
        this.f14745c.dispose();
        DisposableHelper.dispose(this.f14746d);
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14745c.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14747f) {
            return;
        }
        this.f14747f = true;
        AtomicReference atomicReference = this.f14746d;
        ug.b bVar = (ug.b) atomicReference.get();
        if (bVar != DisposableHelper.DISPOSED) {
            ((l0) bVar).a();
            DisposableHelper.dispose(atomicReference);
            this.f14743a.onComplete();
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        DisposableHelper.dispose(this.f14746d);
        this.f14743a.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14747f) {
            return;
        }
        long j4 = this.e + 1;
        this.e = j4;
        ug.b bVar = (ug.b) this.f14746d.get();
        if (bVar != null) {
            bVar.dispose();
        }
        try {
            Object apply = this.f14744b.apply(obj);
            xg.c.b(apply, "The ObservableSource supplied is null");
            rg.q qVar = (rg.q) apply;
            l0 l0Var = new l0(this, j4, obj);
            AtomicReference atomicReference = this.f14746d;
            while (!atomicReference.compareAndSet(bVar, l0Var)) {
                if (atomicReference.get() != bVar) {
                    return;
                }
            }
            qVar.subscribe(l0Var);
        } catch (Throwable th2) {
            ad.a(th2);
            dispose();
            this.f14743a.onError(th2);
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14745c, bVar)) {
            this.f14745c = bVar;
            this.f14743a.onSubscribe(this);
        }
    }
}
