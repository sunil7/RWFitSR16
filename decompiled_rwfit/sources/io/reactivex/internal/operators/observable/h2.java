package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class h2 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14671a;

    /* renamed from: b, reason: collision with root package name */
    public final vg.o f14672b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.o f14673c;

    /* renamed from: d, reason: collision with root package name */
    public final Callable f14674d;
    public ug.b e;

    public h2(rg.s sVar, vg.o oVar, vg.o oVar2, Callable callable) {
        this.f14671a = sVar;
        this.f14672b = oVar;
        this.f14673c = oVar2;
        this.f14674d = callable;
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
        rg.s sVar = this.f14671a;
        try {
            Object call = this.f14674d.call();
            xg.c.b(call, "The onComplete ObservableSource returned is null");
            sVar.onNext((rg.q) call);
            sVar.onComplete();
        } catch (Throwable th2) {
            ad.a(th2);
            sVar.onError(th2);
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        rg.s sVar = this.f14671a;
        try {
            Object apply = this.f14673c.apply(th2);
            xg.c.b(apply, "The onError ObservableSource returned is null");
            sVar.onNext((rg.q) apply);
            sVar.onComplete();
        } catch (Throwable th3) {
            ad.a(th3);
            sVar.onError(new CompositeException(th2, th3));
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        rg.s sVar = this.f14671a;
        try {
            Object apply = this.f14672b.apply(obj);
            xg.c.b(apply, "The onNext ObservableSource returned is null");
            sVar.onNext((rg.q) apply);
        } catch (Throwable th2) {
            ad.a(th2);
            sVar.onError(th2);
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.e, bVar)) {
            this.e = bVar;
            this.f14671a.onSubscribe(this);
        }
    }
}
