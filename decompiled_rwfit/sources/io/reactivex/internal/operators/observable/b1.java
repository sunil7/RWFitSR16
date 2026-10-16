package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class b1 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.z f14574a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14575b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14576c;

    /* renamed from: d, reason: collision with root package name */
    public ug.b f14577d;
    public long e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14578f;

    public b1(rg.z zVar, long j4, Object obj) {
        this.f14574a = zVar;
        this.f14575b = j4;
        this.f14576c = obj;
    }

    @Override // ug.b
    public final void dispose() {
        this.f14577d.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14577d.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14578f) {
            return;
        }
        this.f14578f = true;
        rg.z zVar = this.f14574a;
        Object obj = this.f14576c;
        if (obj != null) {
            zVar.onSuccess(obj);
        } else {
            zVar.onError(new NoSuchElementException());
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f14578f) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.f14578f = true;
            this.f14574a.onError(th2);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14578f) {
            return;
        }
        long j4 = this.e;
        if (j4 != this.f14575b) {
            this.e = j4 + 1;
            return;
        }
        this.f14578f = true;
        this.f14577d.dispose();
        this.f14574a.onSuccess(obj);
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14577d, bVar)) {
            this.f14577d = bVar;
            this.f14574a.onSubscribe(this);
        }
    }
}
