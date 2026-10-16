package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;

/* loaded from: classes2.dex */
public final class q0 implements rg.s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14834a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.s f14835b;

    /* renamed from: c, reason: collision with root package name */
    public final SequentialDisposable f14836c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14837d;
    public final rg.q e;

    public q0(rg.s sVar, rg.q qVar) {
        this.f14834a = 1;
        this.f14835b = sVar;
        this.e = qVar;
        this.f14837d = true;
        this.f14836c = new SequentialDisposable();
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14834a) {
            case 0:
                if (!this.f14837d) {
                    this.f14837d = true;
                    ((rg.l) ((o) this.e).f14787b).subscribe(new n3(this, 2));
                    break;
                }
                break;
            default:
                if (!this.f14837d) {
                    this.f14835b.onComplete();
                    break;
                } else {
                    this.f14837d = false;
                    this.e.subscribe(this);
                    break;
                }
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14834a) {
            case 0:
                if (!this.f14837d) {
                    this.f14837d = true;
                    this.f14835b.onError(th2);
                    break;
                } else {
                    com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
                    break;
                }
            default:
                this.f14835b.onError(th2);
                break;
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14834a) {
            case 0:
                onComplete();
                break;
            default:
                if (this.f14837d) {
                    this.f14837d = false;
                }
                this.f14835b.onNext(obj);
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14834a) {
            case 0:
                this.f14836c.update(bVar);
                break;
            default:
                this.f14836c.update(bVar);
                break;
        }
    }

    public q0(o oVar, SequentialDisposable sequentialDisposable, rg.s sVar) {
        this.f14834a = 0;
        this.e = oVar;
        this.f14836c = sequentialDisposable;
        this.f14835b = sVar;
    }
}
