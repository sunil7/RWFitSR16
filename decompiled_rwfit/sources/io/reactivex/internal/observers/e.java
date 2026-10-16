package io.reactivex.internal.observers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.NoSuchElementException;
import rg.s;
import rg.z;

/* loaded from: classes2.dex */
public final class e implements s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14462a;

    /* renamed from: b, reason: collision with root package name */
    public ug.b f14463b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14464c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14465d;
    public Object e;

    public /* synthetic */ e(Object obj, int i3, Object obj2, Object obj3) {
        this.f14462a = i3;
        this.f14464c = obj;
        this.f14465d = obj2;
        this.e = obj3;
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f14462a) {
            case 0:
                try {
                    ((vg.a) this.e).run();
                } catch (Throwable th2) {
                    ad.a(th2);
                    a1.b(th2);
                }
                this.f14463b.dispose();
                break;
            case 1:
                this.f14463b.dispose();
                this.f14463b = DisposableHelper.DISPOSED;
                break;
            default:
                this.f14463b.dispose();
                break;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f14462a) {
            case 1:
                if (this.f14463b == DisposableHelper.DISPOSED) {
                }
                break;
        }
        return this.f14463b.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14462a) {
            case 0:
                if (this.f14463b != DisposableHelper.DISPOSED) {
                    ((s) this.f14464c).onComplete();
                    break;
                }
                break;
            case 1:
                this.f14463b = DisposableHelper.DISPOSED;
                Object obj = this.e;
                z zVar = (z) this.f14464c;
                if (obj == null) {
                    Object obj2 = this.f14465d;
                    if (obj2 == null) {
                        zVar.onError(new NoSuchElementException());
                        break;
                    } else {
                        zVar.onSuccess(obj2);
                        break;
                    }
                } else {
                    this.e = null;
                    zVar.onSuccess(obj);
                    break;
                }
            default:
                Object obj3 = this.e;
                if (obj3 != null) {
                    this.e = null;
                    ((z) this.f14464c).onSuccess(obj3);
                    break;
                }
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14462a) {
            case 0:
                if (this.f14463b == DisposableHelper.DISPOSED) {
                    a1.b(th2);
                    break;
                } else {
                    ((s) this.f14464c).onError(th2);
                    break;
                }
            case 1:
                this.f14463b = DisposableHelper.DISPOSED;
                this.e = null;
                ((z) this.f14464c).onError(th2);
                break;
            default:
                if (this.e == null) {
                    a1.b(th2);
                    break;
                } else {
                    this.e = null;
                    ((z) this.f14464c).onError(th2);
                    break;
                }
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14462a) {
            case 0:
                ((s) this.f14464c).onNext(obj);
                break;
            case 1:
                this.e = obj;
                break;
            default:
                Object obj2 = this.e;
                if (obj2 != null) {
                    try {
                        Object a3 = ((vg.c) this.f14465d).a(obj2, obj);
                        xg.c.b(a3, "The reducer returned a null value");
                        this.e = a3;
                        break;
                    } catch (Throwable th2) {
                        ad.a(th2);
                        this.f14463b.dispose();
                        onError(th2);
                    }
                }
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14462a) {
            case 0:
                s sVar = (s) this.f14464c;
                try {
                    ((vg.g) this.f14465d).f(bVar);
                    if (DisposableHelper.validate(this.f14463b, bVar)) {
                        this.f14463b = bVar;
                        sVar.onSubscribe(this);
                        break;
                    }
                } catch (Throwable th2) {
                    ad.a(th2);
                    bVar.dispose();
                    this.f14463b = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th2, sVar);
                    return;
                }
                break;
            case 1:
                if (DisposableHelper.validate(this.f14463b, bVar)) {
                    this.f14463b = bVar;
                    ((z) this.f14464c).onSubscribe(this);
                    break;
                }
                break;
            default:
                if (DisposableHelper.validate(this.f14463b, bVar)) {
                    this.f14463b = bVar;
                    ((z) this.f14464c).onSubscribe(this);
                    break;
                }
                break;
        }
    }

    public e(z zVar, Object obj) {
        this.f14462a = 1;
        this.f14464c = zVar;
        this.f14465d = obj;
    }
}
