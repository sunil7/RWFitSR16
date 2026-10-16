package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class z0 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.h f15032a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15033b;

    /* renamed from: c, reason: collision with root package name */
    public ug.b f15034c;

    /* renamed from: d, reason: collision with root package name */
    public long f15035d;
    public boolean e;

    public z0(rg.h hVar, long j4) {
        this.f15032a = hVar;
        this.f15033b = j4;
    }

    @Override // ug.b
    public final void dispose() {
        this.f15034c.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f15034c.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.f15032a.onComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.e) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.e = true;
            this.f15032a.onError(th2);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.e) {
            return;
        }
        long j4 = this.f15035d;
        if (j4 != this.f15033b) {
            this.f15035d = j4 + 1;
            return;
        }
        this.e = true;
        this.f15034c.dispose();
        this.f15032a.onSuccess(obj);
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f15034c, bVar)) {
            this.f15034c = bVar;
            this.f15032a.onSubscribe(this);
        }
    }
}
