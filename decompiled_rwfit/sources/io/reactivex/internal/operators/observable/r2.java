package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class r2 implements rg.s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14857a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14858b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14859c;

    public /* synthetic */ r2(int i3, Object obj, Object obj2) {
        this.f14857a = i3;
        this.f14858b = obj;
        this.f14859c = obj2;
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14857a) {
            case 0:
                ((io.reactivex.subjects.a) this.f14858b).onComplete();
                break;
            case 1:
                ((ArrayCompositeDisposable) this.f14858b).dispose();
                ((ah.c) this.f14859c).onComplete();
                break;
            default:
                ((rg.s) this.f14858b).onComplete();
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14857a) {
            case 0:
                ((io.reactivex.subjects.a) this.f14858b).onError(th2);
                break;
            case 1:
                ((ArrayCompositeDisposable) this.f14858b).dispose();
                ((ah.c) this.f14859c).onError(th2);
                break;
            default:
                ((rg.s) this.f14858b).onError(th2);
                break;
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14857a) {
            case 0:
                ((io.reactivex.subjects.a) this.f14858b).onNext(obj);
                break;
            case 1:
                ((ArrayCompositeDisposable) this.f14858b).dispose();
                ((ah.c) this.f14859c).onComplete();
                break;
            default:
                ((rg.s) this.f14858b).onNext(obj);
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14857a) {
            case 0:
                DisposableHelper.setOnce((AtomicReference) this.f14859c, bVar);
                break;
            case 1:
                ((ArrayCompositeDisposable) this.f14858b).setResource(1, bVar);
                break;
            default:
                DisposableHelper.replace((AtomicReference) this.f14859c, bVar);
                break;
        }
    }
}
