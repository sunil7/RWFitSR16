package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class x0 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14992a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14993b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14994c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14995d;
    public ug.b e;

    /* renamed from: f, reason: collision with root package name */
    public long f14996f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14997g;

    public x0(rg.s sVar, long j4, Object obj, boolean z5) {
        this.f14992a = sVar;
        this.f14993b = j4;
        this.f14994c = obj;
        this.f14995d = z5;
    }

    @Override // ug.b
    public final void dispose() {
        this.e.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.e.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14997g) {
            return;
        }
        this.f14997g = true;
        rg.s sVar = this.f14992a;
        Object obj = this.f14994c;
        if (obj == null && this.f14995d) {
            sVar.onError(new NoSuchElementException());
            return;
        }
        if (obj != null) {
            sVar.onNext(obj);
        }
        sVar.onComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f14997g) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.f14997g = true;
            this.f14992a.onError(th2);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14997g) {
            return;
        }
        long j4 = this.f14996f;
        if (j4 != this.f14993b) {
            this.f14996f = j4 + 1;
            return;
        }
        this.f14997g = true;
        this.e.dispose();
        rg.s sVar = this.f14992a;
        sVar.onNext(obj);
        sVar.onComplete();
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.e, bVar)) {
            this.e = bVar;
            this.f14992a.onSubscribe(this);
        }
    }
}
