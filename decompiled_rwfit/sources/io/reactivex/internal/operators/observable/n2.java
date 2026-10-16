package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes2.dex */
public final class n2 implements rg.s {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14776a;

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14777b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14778c;

    /* renamed from: d, reason: collision with root package name */
    public final SequentialDisposable f14779d = new SequentialDisposable();
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14780f;

    public n2(rg.s sVar, vg.o oVar, boolean z5) {
        this.f14776a = sVar;
        this.f14777b = oVar;
        this.f14778c = z5;
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14780f) {
            return;
        }
        this.f14780f = true;
        this.e = true;
        this.f14776a.onComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        boolean z5 = this.e;
        rg.s sVar = this.f14776a;
        if (z5) {
            if (this.f14780f) {
                com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                return;
            } else {
                sVar.onError(th2);
                return;
            }
        }
        this.e = true;
        if (this.f14778c && !(th2 instanceof Exception)) {
            sVar.onError(th2);
            return;
        }
        try {
            rg.q qVar = (rg.q) this.f14777b.apply(th2);
            if (qVar != null) {
                qVar.subscribe(this);
                return;
            }
            NullPointerException nullPointerException = new NullPointerException("Observable is null");
            nullPointerException.initCause(th2);
            sVar.onError(nullPointerException);
        } catch (Throwable th3) {
            ad.a(th3);
            sVar.onError(new CompositeException(th2, th3));
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14780f) {
            return;
        }
        this.f14776a.onNext(obj);
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        this.f14779d.replace(bVar);
    }
}
