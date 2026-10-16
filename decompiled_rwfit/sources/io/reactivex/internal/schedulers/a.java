package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import rg.w;

/* loaded from: classes2.dex */
public final class a extends w {

    /* renamed from: a, reason: collision with root package name */
    public final wg.b f15058a;

    /* renamed from: b, reason: collision with root package name */
    public final ug.a f15059b;

    /* renamed from: c, reason: collision with root package name */
    public final wg.b f15060c;

    /* renamed from: d, reason: collision with root package name */
    public final c f15061d;
    public volatile boolean e;

    public a(c cVar) {
        this.f15061d = cVar;
        wg.b bVar = new wg.b();
        this.f15058a = bVar;
        ug.a aVar = new ug.a();
        this.f15059b = aVar;
        wg.b bVar2 = new wg.b();
        this.f15060c = bVar2;
        bVar2.c(bVar);
        bVar2.c(aVar);
    }

    @Override // rg.w
    public final ug.b a(Runnable runnable, long j4, TimeUnit timeUnit) {
        return this.e ? EmptyDisposable.INSTANCE : this.f15061d.d(runnable, j4, timeUnit, this.f15059b);
    }

    @Override // rg.w
    public final void b(Runnable runnable) {
        if (this.e) {
            return;
        }
        this.f15061d.d(runnable, 0L, TimeUnit.MILLISECONDS, this.f15058a);
    }

    @Override // ug.b
    public final void dispose() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.f15060c.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.e;
    }
}
