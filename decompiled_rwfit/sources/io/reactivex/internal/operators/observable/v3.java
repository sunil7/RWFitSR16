package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class v3 implements rg.s {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayCompositeDisposable f14947a;

    /* renamed from: b, reason: collision with root package name */
    public final w3 f14948b;

    /* renamed from: c, reason: collision with root package name */
    public final ah.c f14949c;

    /* renamed from: d, reason: collision with root package name */
    public ug.b f14950d;

    public v3(ArrayCompositeDisposable arrayCompositeDisposable, w3 w3Var, ah.c cVar) {
        this.f14947a = arrayCompositeDisposable;
        this.f14948b = w3Var;
        this.f14949c = cVar;
    }

    @Override // rg.s
    public final void onComplete() {
        this.f14948b.f14982d = true;
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f14947a.dispose();
        this.f14949c.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        this.f14950d.dispose();
        this.f14948b.f14982d = true;
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14950d, bVar)) {
            this.f14950d = bVar;
            this.f14947a.setResource(1, bVar);
        }
    }
}
