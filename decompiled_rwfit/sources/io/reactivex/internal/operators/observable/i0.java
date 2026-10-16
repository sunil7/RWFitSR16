package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes2.dex */
public final class i0 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14685a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14686b;

    /* renamed from: c, reason: collision with root package name */
    public long f14687c;

    /* renamed from: d, reason: collision with root package name */
    public ug.b f14688d;

    public /* synthetic */ i0(Object obj, int i3) {
        this.f14685a = i3;
        this.f14686b = obj;
    }

    @Override // ug.b
    public final void dispose() {
        switch (this.f14685a) {
            case 0:
                this.f14688d.dispose();
                break;
            case 1:
                this.f14688d.dispose();
                break;
            default:
                this.f14688d.dispose();
                this.f14688d = DisposableHelper.DISPOSED;
                break;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        switch (this.f14685a) {
        }
        return this.f14688d.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        switch (this.f14685a) {
            case 0:
                Long valueOf = Long.valueOf(this.f14687c);
                rg.s sVar = (rg.s) this.f14686b;
                sVar.onNext(valueOf);
                sVar.onComplete();
                break;
            case 1:
                ((rg.s) this.f14686b).onComplete();
                break;
            default:
                this.f14688d = DisposableHelper.DISPOSED;
                ((rg.z) this.f14686b).onSuccess(Long.valueOf(this.f14687c));
                break;
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        switch (this.f14685a) {
            case 0:
                ((rg.s) this.f14686b).onError(th2);
                break;
            case 1:
                ((rg.s) this.f14686b).onError(th2);
                break;
            default:
                this.f14688d = DisposableHelper.DISPOSED;
                ((rg.z) this.f14686b).onError(th2);
                break;
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        switch (this.f14685a) {
            case 0:
                this.f14687c++;
                break;
            case 1:
                long j4 = this.f14687c;
                if (j4 == 0) {
                    ((rg.s) this.f14686b).onNext(obj);
                    break;
                } else {
                    this.f14687c = j4 - 1;
                    break;
                }
            default:
                this.f14687c++;
                break;
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        switch (this.f14685a) {
            case 0:
                if (DisposableHelper.validate(this.f14688d, bVar)) {
                    this.f14688d = bVar;
                    ((rg.s) this.f14686b).onSubscribe(this);
                    break;
                }
                break;
            case 1:
                if (DisposableHelper.validate(this.f14688d, bVar)) {
                    this.f14688d = bVar;
                    ((rg.s) this.f14686b).onSubscribe(this);
                    break;
                }
                break;
            default:
                if (DisposableHelper.validate(this.f14688d, bVar)) {
                    this.f14688d = bVar;
                    ((rg.z) this.f14686b).onSubscribe(this);
                    break;
                }
                break;
        }
    }

    public i0(rg.s sVar, long j4) {
        this.f14685a = 1;
        this.f14686b = sVar;
        this.f14687c = j4;
    }
}
