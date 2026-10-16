package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class c0 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14589a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14590b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14591c;

    /* renamed from: d, reason: collision with root package name */
    public ug.b f14592d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f14593f;

    public /* synthetic */ c0(Object obj, Object obj2, vg.b bVar, int i3) {
        this.f14589a = i3;
        this.f14593f = obj;
        this.f14590b = bVar;
        this.f14591c = obj2;
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f14589a) {
            case 0:
                this.f14592d.dispose();
                break;
            case 1:
                this.f14592d.dispose();
                break;
            case 2:
                this.f14592d.dispose();
                break;
            case 3:
                this.f14592d.dispose();
                break;
            default:
                this.f14592d.dispose();
                break;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f14589a) {
        }
        return this.f14592d.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14589a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    Object obj = this.f14591c;
                    rg.s sVar = (rg.s) this.f14593f;
                    sVar.onNext(obj);
                    sVar.onComplete();
                    break;
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    ((rg.z) this.f14593f).onSuccess(this.f14591c);
                    break;
                }
                break;
            case 2:
                if (!this.e) {
                    this.e = true;
                    Object obj2 = this.f14591c;
                    this.f14591c = null;
                    rg.h hVar = (rg.h) this.f14593f;
                    if (obj2 == null) {
                        hVar.onComplete();
                        break;
                    } else {
                        hVar.onSuccess(obj2);
                        break;
                    }
                }
                break;
            case 3:
                if (!this.e) {
                    this.e = true;
                    Object obj3 = this.f14590b;
                    this.f14590b = null;
                    if (obj3 == null) {
                        obj3 = this.f14591c;
                    }
                    rg.z zVar = (rg.z) this.f14593f;
                    if (obj3 == null) {
                        zVar.onError(new NoSuchElementException());
                        break;
                    } else {
                        zVar.onSuccess(obj3);
                        break;
                    }
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    ((rg.s) this.f14593f).onComplete();
                    break;
                }
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14589a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    ((rg.s) this.f14593f).onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            case 1:
                if (!this.e) {
                    this.e = true;
                    ((rg.z) this.f14593f).onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            case 2:
                if (!this.e) {
                    this.e = true;
                    this.f14591c = null;
                    ((rg.h) this.f14593f).onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            case 3:
                if (!this.e) {
                    this.e = true;
                    ((rg.z) this.f14593f).onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            default:
                if (!this.e) {
                    this.e = true;
                    ((rg.s) this.f14593f).onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14589a) {
            case 0:
                if (!this.e) {
                    try {
                        ((vg.b) this.f14590b).i(this.f14591c, obj);
                        break;
                    } catch (Throwable th2) {
                        this.f14592d.dispose();
                        onError(th2);
                        return;
                    }
                }
                break;
            case 1:
                if (!this.e) {
                    try {
                        ((vg.b) this.f14590b).i(this.f14591c, obj);
                        break;
                    } catch (Throwable th3) {
                        this.f14592d.dispose();
                        onError(th3);
                        return;
                    }
                }
                break;
            case 2:
                if (!this.e) {
                    Object obj2 = this.f14591c;
                    if (obj2 == null) {
                        this.f14591c = obj;
                        break;
                    } else {
                        try {
                            Object a3 = ((vg.c) this.f14590b).a(obj2, obj);
                            xg.c.b(a3, "The reducer returned a null value");
                            this.f14591c = a3;
                            break;
                        } catch (Throwable th4) {
                            ad.a(th4);
                            this.f14592d.dispose();
                            onError(th4);
                            return;
                        }
                    }
                }
                break;
            case 3:
                if (!this.e) {
                    if (this.f14590b == null) {
                        this.f14590b = obj;
                        break;
                    } else {
                        this.e = true;
                        this.f14592d.dispose();
                        ((rg.z) this.f14593f).onError(new IllegalArgumentException("Sequence contains more than one element!"));
                        break;
                    }
                }
                break;
            default:
                rg.s sVar = (rg.s) this.f14593f;
                Iterator it = (Iterator) this.f14590b;
                if (!this.e) {
                    try {
                        Object next = it.next();
                        xg.c.b(next, "The iterator returned a null value");
                        try {
                            Object a10 = ((vg.c) this.f14591c).a(obj, next);
                            xg.c.b(a10, "The zipper function returned a null value");
                            sVar.onNext(a10);
                            try {
                                if (!it.hasNext()) {
                                    this.e = true;
                                    this.f14592d.dispose();
                                    sVar.onComplete();
                                    break;
                                }
                            } catch (Throwable th5) {
                                ad.a(th5);
                                this.e = true;
                                this.f14592d.dispose();
                                sVar.onError(th5);
                                return;
                            }
                        } catch (Throwable th6) {
                            ad.a(th6);
                            this.e = true;
                            this.f14592d.dispose();
                            sVar.onError(th6);
                            return;
                        }
                    } catch (Throwable th7) {
                        ad.a(th7);
                        this.e = true;
                        this.f14592d.dispose();
                        sVar.onError(th7);
                    }
                }
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14589a) {
            case 0:
                if (DisposableHelper.validate(this.f14592d, bVar)) {
                    this.f14592d = bVar;
                    ((rg.s) this.f14593f).onSubscribe(this);
                    break;
                }
                break;
            case 1:
                if (DisposableHelper.validate(this.f14592d, bVar)) {
                    this.f14592d = bVar;
                    ((rg.z) this.f14593f).onSubscribe(this);
                    break;
                }
                break;
            case 2:
                if (DisposableHelper.validate(this.f14592d, bVar)) {
                    this.f14592d = bVar;
                    ((rg.h) this.f14593f).onSubscribe(this);
                    break;
                }
                break;
            case 3:
                if (DisposableHelper.validate(this.f14592d, bVar)) {
                    this.f14592d = bVar;
                    ((rg.z) this.f14593f).onSubscribe(this);
                    break;
                }
                break;
            default:
                if (DisposableHelper.validate(this.f14592d, bVar)) {
                    this.f14592d = bVar;
                    ((rg.s) this.f14593f).onSubscribe(this);
                    break;
                }
                break;
        }
    }

    public c0(rg.z zVar, Object obj) {
        this.f14589a = 3;
        this.f14593f = zVar;
        this.f14591c = obj;
    }

    public c0(rg.h hVar, vg.c cVar) {
        this.f14589a = 2;
        this.f14593f = hVar;
        this.f14590b = cVar;
    }

    public c0(rg.s sVar, Iterator it, vg.c cVar) {
        this.f14589a = 4;
        this.f14593f = sVar;
        this.f14590b = it;
        this.f14591c = cVar;
    }
}
