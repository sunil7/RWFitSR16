package rg;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f18136a;

    /* renamed from: b, reason: collision with root package name */
    public final SequentialDisposable f18137b;

    /* renamed from: c, reason: collision with root package name */
    public final long f18138c;

    /* renamed from: d, reason: collision with root package name */
    public long f18139d;
    public long e;

    /* renamed from: f, reason: collision with root package name */
    public long f18140f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ w f18141g;

    public v(w wVar, long j4, Runnable runnable, long j10, SequentialDisposable sequentialDisposable, long j11) {
        this.f18141g = wVar;
        this.f18136a = runnable;
        this.f18137b = sequentialDisposable;
        this.f18138c = j11;
        this.e = j10;
        this.f18140f = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j4;
        this.f18136a.run();
        SequentialDisposable sequentialDisposable = this.f18137b;
        if (sequentialDisposable.isDisposed()) {
            return;
        }
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        w wVar = this.f18141g;
        wVar.getClass();
        long convert = timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        long j10 = x.f18142a;
        long j11 = convert + j10;
        long j12 = this.e;
        long j13 = this.f18138c;
        if (j11 < j12 || convert >= j12 + j13 + j10) {
            j4 = convert + j13;
            long j14 = this.f18139d + 1;
            this.f18139d = j14;
            this.f18140f = j4 - (j13 * j14);
        } else {
            long j15 = this.f18140f;
            long j16 = this.f18139d + 1;
            this.f18139d = j16;
            j4 = (j16 * j13) + j15;
        }
        this.e = convert;
        sequentialDisposable.replace(wVar.a(this, j4 - convert, timeUnit));
    }
}
