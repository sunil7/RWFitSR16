package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class u3 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final long f14924b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f14925c;

    /* renamed from: d, reason: collision with root package name */
    public final rg.x f14926d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14927f;

    public u3(int i3, long j4, TimeUnit timeUnit, rg.l lVar, rg.x xVar, boolean z5) {
        super(lVar);
        this.f14924b = j4;
        this.f14925c = timeUnit;
        this.f14926d = xVar;
        this.e = i3;
        this.f14927f = z5;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        this.f14546a.subscribe(new ObservableSkipLastTimed$SkipLastTimedObserver(sVar, this.f14924b, this.f14925c, this.f14926d, this.e, this.f14927f));
    }
}
