package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class a4 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final long f14564b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14565c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeUnit f14566d;
    public final rg.x e;

    /* renamed from: f, reason: collision with root package name */
    public final int f14567f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f14568g;

    public a4(rg.l lVar, long j4, long j10, TimeUnit timeUnit, rg.x xVar, int i3, boolean z5) {
        super(lVar);
        this.f14564b = j4;
        this.f14565c = j10;
        this.f14566d = timeUnit;
        this.e = xVar;
        this.f14567f = i3;
        this.f14568g = z5;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        this.f14546a.subscribe(new ObservableTakeLastTimed$TakeLastTimedObserver(sVar, this.f14564b, this.f14565c, this.f14566d, this.e, this.f14567f, this.f14568g));
    }
}
