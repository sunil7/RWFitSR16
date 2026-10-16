package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class o3 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14798a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final rg.s f14799b;

    /* renamed from: c, reason: collision with root package name */
    public final vg.c f14800c;

    /* renamed from: d, reason: collision with root package name */
    public Object f14801d;
    public ug.b e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14802f;

    public o3(rg.s sVar, vg.c cVar) {
        this.f14799b = sVar;
        this.f14800c = cVar;
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f14798a) {
            case 0:
                this.e.dispose();
                break;
            default:
                this.e.dispose();
                break;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f14798a) {
        }
        return this.e.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14798a) {
            case 0:
                if (!this.f14802f) {
                    this.f14802f = true;
                    this.f14799b.onComplete();
                    break;
                }
                break;
            default:
                if (!this.f14802f) {
                    this.f14802f = true;
                    this.f14799b.onComplete();
                    break;
                }
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14798a) {
            case 0:
                if (!this.f14802f) {
                    this.f14802f = true;
                    this.f14799b.onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            default:
                if (!this.f14802f) {
                    this.f14802f = true;
                    this.f14799b.onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14798a) {
            case 0:
                if (!this.f14802f) {
                    Object obj2 = this.f14801d;
                    rg.s sVar = this.f14799b;
                    if (obj2 == null) {
                        this.f14801d = obj;
                        sVar.onNext(obj);
                        break;
                    } else {
                        try {
                            Object a3 = this.f14800c.a(obj2, obj);
                            xg.c.b(a3, "The value returned by the accumulator is null");
                            this.f14801d = a3;
                            sVar.onNext(a3);
                            break;
                        } catch (Throwable th2) {
                            ad.a(th2);
                            this.e.dispose();
                            onError(th2);
                            return;
                        }
                    }
                }
                break;
            default:
                if (!this.f14802f) {
                    try {
                        Object a10 = this.f14800c.a(this.f14801d, obj);
                        xg.c.b(a10, "The accumulator returned a null value");
                        this.f14801d = a10;
                        this.f14799b.onNext(a10);
                        break;
                    } catch (Throwable th3) {
                        ad.a(th3);
                        this.e.dispose();
                        onError(th3);
                    }
                }
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14798a) {
            case 0:
                if (DisposableHelper.validate(this.e, bVar)) {
                    this.e = bVar;
                    this.f14799b.onSubscribe(this);
                    break;
                }
                break;
            default:
                if (DisposableHelper.validate(this.e, bVar)) {
                    this.e = bVar;
                    rg.s sVar = this.f14799b;
                    sVar.onSubscribe(this);
                    sVar.onNext(this.f14801d);
                    break;
                }
                break;
        }
    }

    public o3(rg.s sVar, vg.c cVar, Object obj) {
        this.f14799b = sVar;
        this.f14800c = cVar;
        this.f14801d = obj;
    }
}
