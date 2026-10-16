package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class p implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14811a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14812b;

    /* renamed from: c, reason: collision with root package name */
    public final Callable f14813c;

    /* renamed from: d, reason: collision with root package name */
    public Collection f14814d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public ug.b f14815f;

    public p(rg.s sVar, int i3, Callable callable) {
        this.f14811a = sVar;
        this.f14812b = i3;
        this.f14813c = callable;
    }

    public final boolean a() {
        try {
            Object call = this.f14813c.call();
            xg.c.b(call, "Empty buffer supplied");
            this.f14814d = (Collection) call;
            return true;
        } catch (Throwable th2) {
            ad.a(th2);
            this.f14814d = null;
            ug.b bVar = this.f14815f;
            rg.s sVar = this.f14811a;
            if (bVar == null) {
                EmptyDisposable.error(th2, sVar);
                return false;
            }
            bVar.dispose();
            sVar.onError(th2);
            return false;
        }
    }

    @Override // ug.b
    public final void dispose() {
        this.f14815f.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14815f.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        Collection collection = this.f14814d;
        if (collection != null) {
            this.f14814d = null;
            boolean isEmpty = collection.isEmpty();
            rg.s sVar = this.f14811a;
            if (!isEmpty) {
                sVar.onNext(collection);
            }
            sVar.onComplete();
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f14814d = null;
        this.f14811a.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        Collection collection = this.f14814d;
        if (collection != null) {
            collection.add(obj);
            int i3 = this.e + 1;
            this.e = i3;
            if (i3 >= this.f14812b) {
                this.f14811a.onNext(collection);
                this.e = 0;
                a();
            }
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14815f, bVar)) {
            this.f14815f = bVar;
            this.f14811a.onSubscribe(this);
        }
    }
}
