package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class c4 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14602b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14603c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeUnit f14604d;
    public final rg.x e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c4(int i3, long j4, TimeUnit timeUnit, rg.l lVar, rg.x xVar) {
        super(lVar);
        this.f14602b = i3;
        this.f14603c = j4;
        this.f14604d = timeUnit;
        this.e = xVar;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        switch (this.f14602b) {
            case 0:
                ah.c cVar = new ah.c(sVar);
                rg.w a3 = this.e.a();
                this.f14546a.subscribe(new ObservableThrottleFirstTimed$DebounceTimedObserver(cVar, this.f14603c, this.f14604d, a3));
                break;
            default:
                ah.c cVar2 = new ah.c(sVar);
                rg.w a10 = this.e.a();
                this.f14546a.subscribe(new n0(cVar2, this.f14603c, this.f14604d, a10));
                break;
        }
    }
}
