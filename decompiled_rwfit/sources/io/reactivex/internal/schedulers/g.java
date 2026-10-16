package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rg.w;

/* loaded from: classes2.dex */
public final class g extends w {

    /* renamed from: b, reason: collision with root package name */
    public final f f15080b;

    /* renamed from: c, reason: collision with root package name */
    public final h f15081c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f15082d = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    public final ug.a f15079a = new ug.a();

    public g(f fVar) {
        h hVar;
        h hVar2;
        this.f15080b = fVar;
        if (fVar.f15076c.f19103b) {
            hVar2 = i.f15086f;
        } else {
            while (true) {
                if (fVar.f15075b.isEmpty()) {
                    hVar = new h(fVar.f15078f);
                    fVar.f15076c.c(hVar);
                    break;
                } else {
                    hVar = (h) fVar.f15075b.poll();
                    if (hVar != null) {
                        break;
                    }
                }
            }
            hVar2 = hVar;
        }
        this.f15081c = hVar2;
    }

    @Override // rg.w
    public final ug.b a(Runnable runnable, long j4, TimeUnit timeUnit) {
        return this.f15079a.f19103b ? EmptyDisposable.INSTANCE : this.f15081c.d(runnable, j4, timeUnit, this.f15079a);
    }

    @Override // ug.b
    public final void dispose() {
        if (this.f15082d.compareAndSet(false, true)) {
            this.f15079a.dispose();
            f fVar = this.f15080b;
            fVar.getClass();
            long nanoTime = System.nanoTime() + fVar.f15074a;
            h hVar = this.f15081c;
            hVar.f15083c = nanoTime;
            fVar.f15075b.offer(hVar);
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f15082d.get();
    }
}
