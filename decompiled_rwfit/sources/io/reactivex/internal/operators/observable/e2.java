package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class e2 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14628a;

    /* renamed from: b, reason: collision with root package name */
    public ug.b f14629b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14630c;

    /* renamed from: d, reason: collision with root package name */
    public Object f14631d;

    public /* synthetic */ e2(Object obj, int i3) {
        this.f14628a = i3;
        this.f14631d = obj;
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f14628a) {
            case 0:
                this.f14629b.dispose();
                this.f14629b = DisposableHelper.DISPOSED;
                break;
            case 1:
                this.f14630c = null;
                this.f14629b.dispose();
                break;
            case 2:
                this.f14629b.dispose();
                break;
            default:
                this.f14629b.dispose();
                break;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f14628a) {
            case 0:
                if (this.f14629b == DisposableHelper.DISPOSED) {
                }
                break;
        }
        return this.f14629b.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14628a) {
            case 0:
                this.f14629b = DisposableHelper.DISPOSED;
                Object obj = this.f14630c;
                rg.h hVar = (rg.h) this.f14631d;
                if (obj == null) {
                    hVar.onComplete();
                    break;
                } else {
                    this.f14630c = null;
                    hVar.onSuccess(obj);
                    break;
                }
            case 1:
                Object obj2 = this.f14630c;
                rg.s sVar = (rg.s) this.f14631d;
                if (obj2 != null) {
                    this.f14630c = null;
                    sVar.onNext(obj2);
                }
                sVar.onComplete();
                break;
            case 2:
                Collection collection = (Collection) this.f14631d;
                this.f14631d = null;
                rg.s sVar2 = (rg.s) this.f14630c;
                sVar2.onNext(collection);
                sVar2.onComplete();
                break;
            default:
                Collection collection2 = (Collection) this.f14630c;
                this.f14630c = null;
                ((rg.z) this.f14631d).onSuccess(collection2);
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14628a) {
            case 0:
                this.f14629b = DisposableHelper.DISPOSED;
                this.f14630c = null;
                ((rg.h) this.f14631d).onError(th2);
                break;
            case 1:
                this.f14630c = null;
                ((rg.s) this.f14631d).onError(th2);
                break;
            case 2:
                this.f14631d = null;
                ((rg.s) this.f14630c).onError(th2);
                break;
            default:
                this.f14630c = null;
                ((rg.z) this.f14631d).onError(th2);
                break;
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14628a) {
            case 0:
                this.f14630c = obj;
                break;
            case 1:
                this.f14630c = obj;
                break;
            case 2:
                ((Collection) this.f14631d).add(obj);
                break;
            default:
                ((Collection) this.f14630c).add(obj);
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14628a) {
            case 0:
                if (DisposableHelper.validate(this.f14629b, bVar)) {
                    this.f14629b = bVar;
                    ((rg.h) this.f14631d).onSubscribe(this);
                    break;
                }
                break;
            case 1:
                if (DisposableHelper.validate(this.f14629b, bVar)) {
                    this.f14629b = bVar;
                    ((rg.s) this.f14631d).onSubscribe(this);
                    break;
                }
                break;
            case 2:
                if (DisposableHelper.validate(this.f14629b, bVar)) {
                    this.f14629b = bVar;
                    ((rg.s) this.f14630c).onSubscribe(this);
                    break;
                }
                break;
            default:
                if (DisposableHelper.validate(this.f14629b, bVar)) {
                    this.f14629b = bVar;
                    ((rg.z) this.f14631d).onSubscribe(this);
                    break;
                }
                break;
        }
    }

    public e2(rg.s sVar, Collection collection) {
        this.f14628a = 2;
        this.f14630c = sVar;
        this.f14631d = collection;
    }

    public e2(rg.z zVar, Collection collection) {
        this.f14628a = 3;
        this.f14631d = zVar;
        this.f14630c = collection;
    }
}
