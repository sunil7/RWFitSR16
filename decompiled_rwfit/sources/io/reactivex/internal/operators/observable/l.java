package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class l implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14726a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14727b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14728c;

    /* renamed from: d, reason: collision with root package name */
    public ug.b f14729d;
    public boolean e;

    public /* synthetic */ l(rg.z zVar, vg.p pVar, int i3) {
        this.f14726a = i3;
        this.f14727b = zVar;
        this.f14728c = pVar;
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f14726a) {
            case 0:
                this.f14729d.dispose();
                break;
            case 1:
                this.f14729d.dispose();
                break;
            default:
                this.f14729d.dispose();
                break;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f14726a) {
        }
        return this.f14729d.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14726a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    ((rg.z) this.f14727b).onSuccess(Boolean.TRUE);
                    break;
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    ((rg.z) this.f14727b).onSuccess(Boolean.FALSE);
                    break;
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    Object obj = this.f14728c;
                    this.f14728c = null;
                    rg.h hVar = (rg.h) this.f14727b;
                    if (obj != null) {
                        hVar.onSuccess(obj);
                        break;
                    } else {
                        hVar.onComplete();
                        break;
                    }
                }
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14726a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    ((rg.z) this.f14727b).onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            case 1:
                if (!this.e) {
                    this.e = true;
                    ((rg.z) this.f14727b).onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            default:
                if (!this.e) {
                    this.e = true;
                    ((rg.h) this.f14727b).onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14726a) {
            case 0:
                if (!this.e) {
                    try {
                        if (!((vg.p) this.f14728c).l(obj)) {
                            this.e = true;
                            this.f14729d.dispose();
                            ((rg.z) this.f14727b).onSuccess(Boolean.FALSE);
                            break;
                        }
                    } catch (Throwable th2) {
                        ad.a(th2);
                        this.f14729d.dispose();
                        onError(th2);
                        return;
                    }
                }
                break;
            case 1:
                if (!this.e) {
                    try {
                        if (((vg.p) this.f14728c).l(obj)) {
                            this.e = true;
                            this.f14729d.dispose();
                            ((rg.z) this.f14727b).onSuccess(Boolean.TRUE);
                            break;
                        }
                    } catch (Throwable th3) {
                        ad.a(th3);
                        this.f14729d.dispose();
                        onError(th3);
                        return;
                    }
                }
                break;
            default:
                if (!this.e) {
                    if (this.f14728c == null) {
                        this.f14728c = obj;
                        break;
                    } else {
                        this.e = true;
                        this.f14729d.dispose();
                        ((rg.h) this.f14727b).onError(new IllegalArgumentException("Sequence contains more than one element!"));
                        break;
                    }
                }
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14726a) {
            case 0:
                if (DisposableHelper.validate(this.f14729d, bVar)) {
                    this.f14729d = bVar;
                    ((rg.z) this.f14727b).onSubscribe(this);
                    break;
                }
                break;
            case 1:
                if (DisposableHelper.validate(this.f14729d, bVar)) {
                    this.f14729d = bVar;
                    ((rg.z) this.f14727b).onSubscribe(this);
                    break;
                }
                break;
            default:
                if (DisposableHelper.validate(this.f14729d, bVar)) {
                    this.f14729d = bVar;
                    ((rg.h) this.f14727b).onSubscribe(this);
                    break;
                }
                break;
        }
    }

    public l(rg.h hVar) {
        this.f14726a = 2;
        this.f14727b = hVar;
    }
}
