package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.fd;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;

/* loaded from: classes2.dex */
public final class f implements rg.s {

    /* renamed from: a, reason: collision with root package name */
    public ug.b f14632a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f14633b;

    @Override // rg.s
    public final void onComplete() {
        this.f14633b = NotificationLite.complete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f14633b = NotificationLite.error(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        this.f14633b = NotificationLite.next(obj);
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        ug.b bVar2 = this.f14632a;
        xg.c.b(bVar, "next is null");
        if (bVar2 == null) {
            this.f14632a = bVar;
            return;
        }
        bVar.dispose();
        if (bVar2 != DisposableHelper.DISPOSED) {
            fd.a(f.class);
        }
    }
}
