package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class z extends a {

    /* renamed from: b, reason: collision with root package name */
    public final long f15026b;

    /* renamed from: c, reason: collision with root package name */
    public final long f15027c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeUnit f15028d;
    public final rg.x e;

    /* renamed from: f, reason: collision with root package name */
    public final Callable f15029f;

    /* renamed from: g, reason: collision with root package name */
    public final int f15030g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f15031h;

    public z(rg.l lVar, long j4, long j10, TimeUnit timeUnit, rg.x xVar, Callable callable, int i3, boolean z5) {
        super(lVar);
        this.f15026b = j4;
        this.f15027c = j10;
        this.f15028d = timeUnit;
        this.e = xVar;
        this.f15029f = callable;
        this.f15030g = i3;
        this.f15031h = z5;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        long j4 = this.f15026b;
        long j10 = this.f15027c;
        rg.x xVar = this.e;
        Callable callable = this.f15029f;
        TimeUnit timeUnit = this.f15028d;
        rg.q qVar = this.f14546a;
        if (j4 == j10 && this.f15030g == Integer.MAX_VALUE) {
            qVar.subscribe(new w(new ah.c(sVar), callable, j4, timeUnit, xVar));
            return;
        }
        rg.w a3 = xVar.a();
        long j11 = this.f15026b;
        long j12 = this.f15027c;
        if (j11 == j12) {
            qVar.subscribe(new v(new ah.c(sVar), callable, j11, timeUnit, this.f15030g, this.f15031h, a3));
        } else {
            qVar.subscribe(new y(new ah.c(sVar), callable, j11, j12, timeUnit, a3));
        }
    }
}
