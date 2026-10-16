package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;

/* loaded from: classes2.dex */
public final class r0 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14850a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f14851b;

    /* renamed from: c, reason: collision with root package name */
    public ug.b f14852c;

    public r0(rg.s sVar) {
        this.f14850a = sVar;
    }

    @Override // ug.b
    public final void dispose() {
        this.f14852c.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14852c.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f14851b) {
            return;
        }
        this.f14851b = true;
        this.f14850a.onComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.f14851b) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
        } else {
            this.f14851b = true;
            this.f14850a.onError(th2);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        rg.j jVar = (rg.j) obj;
        if (this.f14851b) {
            if (NotificationLite.isError(jVar.f18127a)) {
                com.google.android.gms.internal.mlkit_vision_barcode.a1.b(jVar.a());
            }
        } else {
            if (NotificationLite.isError(jVar.f18127a)) {
                this.f14852c.dispose();
                onError(jVar.a());
                return;
            }
            Object obj2 = jVar.f18127a;
            if (obj2 == null) {
                this.f14852c.dispose();
                onComplete();
                return;
            }
            rg.s sVar = this.f14850a;
            if (obj2 == null || NotificationLite.isError(obj2)) {
                obj2 = null;
            }
            sVar.onNext(obj2);
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14852c, bVar)) {
            this.f14852c = bVar;
            this.f14850a.onSubscribe(this);
        }
    }
}
