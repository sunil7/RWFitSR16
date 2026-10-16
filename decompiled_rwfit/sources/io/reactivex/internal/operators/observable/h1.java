package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class h1 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14667a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.s f14668b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.o f14669c;

    /* renamed from: d, reason: collision with root package name */
    public ug.b f14670d;

    public /* synthetic */ h1(rg.s sVar, vg.o oVar, int i3) {
        this.f14667a = i3;
        this.f14668b = sVar;
        this.f14669c = oVar;
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f14667a) {
            case 0:
                this.f14670d.dispose();
                this.f14670d = DisposableHelper.DISPOSED;
                break;
            default:
                this.f14670d.dispose();
                break;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f14667a) {
        }
        return this.f14670d.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14667a) {
            case 0:
                ug.b bVar = this.f14670d;
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (bVar != disposableHelper) {
                    this.f14670d = disposableHelper;
                    this.f14668b.onComplete();
                    break;
                }
                break;
            default:
                this.f14668b.onComplete();
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14667a) {
            case 0:
                ug.b bVar = this.f14670d;
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (bVar != disposableHelper) {
                    this.f14670d = disposableHelper;
                    this.f14668b.onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            default:
                rg.s sVar = this.f14668b;
                try {
                    Object apply = this.f14669c.apply(th2);
                    if (apply != null) {
                        sVar.onNext(apply);
                        sVar.onComplete();
                        break;
                    } else {
                        NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                        nullPointerException.initCause(th2);
                        sVar.onError(nullPointerException);
                        break;
                    }
                } catch (Throwable th3) {
                    ad.a(th3);
                    sVar.onError(new CompositeException(th2, th3));
                }
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14667a) {
            case 0:
                if (this.f14670d != DisposableHelper.DISPOSED) {
                    try {
                        for (Object obj2 : (Iterable) this.f14669c.apply(obj)) {
                            try {
                                try {
                                    xg.c.b(obj2, "The iterator returned a null value");
                                    this.f14668b.onNext(obj2);
                                } catch (Throwable th2) {
                                    ad.a(th2);
                                    this.f14670d.dispose();
                                    onError(th2);
                                    return;
                                }
                            } catch (Throwable th3) {
                                ad.a(th3);
                                this.f14670d.dispose();
                                onError(th3);
                                return;
                            }
                        }
                        break;
                    } catch (Throwable th4) {
                        ad.a(th4);
                        this.f14670d.dispose();
                        onError(th4);
                        return;
                    }
                }
                break;
            default:
                this.f14668b.onNext(obj);
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14667a) {
            case 0:
                if (DisposableHelper.validate(this.f14670d, bVar)) {
                    this.f14670d = bVar;
                    this.f14668b.onSubscribe(this);
                    break;
                }
                break;
            default:
                if (DisposableHelper.validate(this.f14670d, bVar)) {
                    this.f14670d = bVar;
                    this.f14668b.onSubscribe(this);
                    break;
                }
                break;
        }
    }
}
