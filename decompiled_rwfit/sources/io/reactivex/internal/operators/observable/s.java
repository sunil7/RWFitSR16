package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class s extends ah.a {

    /* renamed from: b, reason: collision with root package name */
    public final t f14866b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14867c;

    public s(t tVar) {
        this.f14866b = tVar;
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14867c) {
            return;
        }
        this.f14867c = true;
        this.f14866b.f();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f14867c) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.f14867c = true;
            this.f14866b.onError(th2);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14867c) {
            return;
        }
        this.f14867c = true;
        dispose();
        this.f14866b.f();
    }
}
