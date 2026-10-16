package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* loaded from: classes2.dex */
public final class l1 implements rg.f, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14734a;

    /* renamed from: b, reason: collision with root package name */
    public ci.c f14735b;

    public l1(rg.s sVar) {
        this.f14734a = sVar;
    }

    @Override // ug.b
    public final void dispose() {
        this.f14735b.cancel();
        this.f14735b = SubscriptionHelper.CANCELLED;
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14735b == SubscriptionHelper.CANCELLED;
    }

    @Override // ci.b
    public final void onComplete() {
        this.f14734a.onComplete();
    }

    @Override // ci.b
    public final void onError(Throwable th2) {
        this.f14734a.onError(th2);
    }

    @Override // ci.b
    public final void onNext(Object obj) {
        this.f14734a.onNext(obj);
    }

    @Override // ci.b
    public final void onSubscribe(ci.c cVar) {
        if (SubscriptionHelper.validate(this.f14735b, cVar)) {
            this.f14735b = cVar;
            this.f14734a.onSubscribe(this);
            cVar.request(Format.OFFSET_SAMPLE_RELATIVE);
        }
    }
}
