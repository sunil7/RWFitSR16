package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* loaded from: classes2.dex */
public final class z3 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f15040a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15041b;

    /* renamed from: c, reason: collision with root package name */
    public ug.b f15042c;

    /* renamed from: d, reason: collision with root package name */
    public long f15043d;

    public z3(rg.s sVar, long j4) {
        this.f15040a = sVar;
        this.f15043d = j4;
    }

    @Override // ug.b
    public final void dispose() {
        this.f15042c.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f15042c.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f15041b) {
            return;
        }
        this.f15041b = true;
        this.f15042c.dispose();
        this.f15040a.onComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f15041b) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.f15041b = true;
        this.f15042c.dispose();
        this.f15040a.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f15041b) {
            return;
        }
        long j4 = this.f15043d;
        long j10 = j4 - 1;
        this.f15043d = j10;
        if (j4 > 0) {
            boolean z5 = j10 == 0;
            this.f15040a.onNext(obj);
            if (z5) {
                onComplete();
            }
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f15042c, bVar)) {
            this.f15042c = bVar;
            long j4 = this.f15043d;
            rg.s sVar = this.f15040a;
            if (j4 != 0) {
                sVar.onSubscribe(this);
                return;
            }
            this.f15041b = true;
            bVar.dispose();
            EmptyDisposable.complete(sVar);
        }
    }
}
