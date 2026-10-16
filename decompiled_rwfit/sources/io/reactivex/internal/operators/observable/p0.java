package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class p0 implements rg.s, ug.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14816a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14817b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f14818c;

    /* renamed from: d, reason: collision with root package name */
    public final rg.w f14819d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public ug.b f14820f;

    public p0(rg.s sVar, long j4, TimeUnit timeUnit, rg.w wVar, boolean z5) {
        this.f14816a = sVar;
        this.f14817b = j4;
        this.f14818c = timeUnit;
        this.f14819d = wVar;
        this.e = z5;
    }

    @Override // ug.b
    public final void dispose() {
        this.f14820f.dispose();
        this.f14819d.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14819d.isDisposed();
    }

    @Override // rg.s
    public final void onComplete() {
        this.f14819d.a(new i4(this, 1), this.f14817b, this.f14818c);
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f14819d.a(new x3(1, this, th2), this.e ? this.f14817b : 0L, this.f14818c);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        this.f14819d.a(new x3(2, this, obj), this.f14817b, this.f14818c);
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14820f, bVar)) {
            this.f14820f = bVar;
            this.f14816a.onSubscribe(this);
        }
    }
}
