package io.reactivex.internal.operators.observable;

import com.google.android.exoplayer2.Format;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class w4 extends a {

    /* renamed from: b, reason: collision with root package name */
    public final long f14983b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14984c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeUnit f14985d;
    public final rg.x e;

    /* renamed from: f, reason: collision with root package name */
    public final long f14986f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14987g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f14988h;

    public w4(rg.l lVar, long j4, long j10, TimeUnit timeUnit, rg.x xVar, long j11, int i3, boolean z5) {
        super(lVar);
        this.f14983b = j4;
        this.f14984c = j10;
        this.f14985d = timeUnit;
        this.e = xVar;
        this.f14986f = j11;
        this.f14987g = i3;
        this.f14988h = z5;
    }

    @Override // rg.l
    public final void subscribeActual(rg.s sVar) {
        ah.c cVar = new ah.c(sVar);
        long j4 = this.f14983b;
        long j10 = this.f14984c;
        TimeUnit timeUnit = this.f14985d;
        rg.x xVar = this.e;
        rg.q qVar = this.f14546a;
        if (j4 != j10) {
            qVar.subscribe(new v4(cVar, j4, j10, timeUnit, xVar.a(), this.f14987g));
            return;
        }
        long j11 = this.f14986f;
        if (j11 == Format.OFFSET_SAMPLE_RELATIVE) {
            qVar.subscribe(new t4(cVar, j4, timeUnit, xVar, this.f14987g));
        } else {
            qVar.subscribe(new s4(cVar, j4, timeUnit, xVar, this.f14987g, j11, this.f14988h));
        }
    }
}
