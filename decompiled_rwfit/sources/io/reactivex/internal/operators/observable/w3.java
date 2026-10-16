package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class w3 implements rg.s {

    /* renamed from: a, reason: collision with root package name */
    public final ah.c f14979a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayCompositeDisposable f14980b;

    /* renamed from: c, reason: collision with root package name */
    public ug.b f14981c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f14982d;
    public boolean e;

    public w3(ah.c cVar, ArrayCompositeDisposable arrayCompositeDisposable) {
        this.f14979a = cVar;
        this.f14980b = arrayCompositeDisposable;
    }

    @Override // rg.s
    public final void onComplete() {
        this.f14980b.dispose();
        this.f14979a.onComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f14980b.dispose();
        this.f14979a.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.e) {
            this.f14979a.onNext(obj);
        } else if (this.f14982d) {
            this.e = true;
            this.f14979a.onNext(obj);
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14981c, bVar)) {
            this.f14981c = bVar;
            this.f14980b.setResource(0, bVar);
        }
    }
}
