package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class s4 extends io.reactivex.internal.observers.h implements ug.b {

    /* renamed from: g, reason: collision with root package name */
    public final long f14878g;

    /* renamed from: h, reason: collision with root package name */
    public final TimeUnit f14879h;

    /* renamed from: i, reason: collision with root package name */
    public final rg.x f14880i;

    /* renamed from: j, reason: collision with root package name */
    public final int f14881j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f14882k;

    /* renamed from: l, reason: collision with root package name */
    public final long f14883l;

    /* renamed from: m, reason: collision with root package name */
    public final rg.w f14884m;

    /* renamed from: n, reason: collision with root package name */
    public long f14885n;

    /* renamed from: o, reason: collision with root package name */
    public long f14886o;

    /* renamed from: p, reason: collision with root package name */
    public ug.b f14887p;

    /* renamed from: q, reason: collision with root package name */
    public io.reactivex.subjects.d f14888q;
    public volatile boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final AtomicReference f14889s;

    public s4(ah.c cVar, long j4, TimeUnit timeUnit, rg.x xVar, int i3, long j10, boolean z5) {
        super(cVar, new io.reactivex.internal.queue.a());
        this.f14889s = new AtomicReference();
        this.f14878g = j4;
        this.f14879h = timeUnit;
        this.f14880i = xVar;
        this.f14881j = i3;
        this.f14883l = j10;
        this.f14882k = z5;
        if (z5) {
            this.f14884m = xVar.a();
        } else {
            this.f14884m = null;
        }
    }

    @Override // ug.b
    public final void dispose() {
        this.f14472d = true;
    }

    public final void f() {
        DisposableHelper.dispose(this.f14889s);
        rg.w wVar = this.f14884m;
        if (wVar != null) {
            wVar.dispose();
        }
    }

    public final void g() {
        io.reactivex.subjects.d dVar;
        io.reactivex.internal.queue.a aVar = this.f14471c;
        ah.c cVar = this.f14470b;
        io.reactivex.subjects.d dVar2 = this.f14888q;
        int i3 = 1;
        while (!this.r) {
            boolean z5 = this.e;
            Object poll = aVar.poll();
            boolean z6 = poll == null;
            boolean z8 = poll instanceof r4;
            if (z5 && (z6 || z8)) {
                this.f14888q = null;
                aVar.clear();
                f();
                Throwable th2 = this.f14473f;
                if (th2 != null) {
                    dVar2.onError(th2);
                    return;
                } else {
                    dVar2.onComplete();
                    return;
                }
            }
            if (z6) {
                i3 = this.f14469a.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else if (z8) {
                r4 r4Var = (r4) poll;
                if (this.f14882k || this.f14886o == r4Var.f14864a) {
                    dVar2.onComplete();
                    this.f14885n = 0L;
                    dVar = new io.reactivex.subjects.d(this.f14881j);
                    this.f14888q = dVar;
                    cVar.onNext(dVar);
                    dVar2 = dVar;
                }
            } else {
                dVar2.onNext(NotificationLite.getValue(poll));
                long j4 = this.f14885n + 1;
                if (j4 >= this.f14883l) {
                    this.f14886o++;
                    this.f14885n = 0L;
                    dVar2.onComplete();
                    dVar = new io.reactivex.subjects.d(this.f14881j);
                    this.f14888q = dVar;
                    this.f14470b.onNext(dVar);
                    if (this.f14882k) {
                        ug.b bVar = (ug.b) this.f14889s.get();
                        bVar.dispose();
                        rg.w wVar = this.f14884m;
                        r4 r4Var2 = new r4(this.f14886o, this);
                        long j10 = this.f14878g;
                        ug.b c9 = wVar.c(r4Var2, j10, j10, this.f14879h);
                        AtomicReference atomicReference = this.f14889s;
                        while (true) {
                            if (atomicReference.compareAndSet(bVar, c9)) {
                                break;
                            } else if (atomicReference.get() != bVar) {
                                c9.dispose();
                                break;
                            }
                        }
                    }
                    dVar2 = dVar;
                } else {
                    this.f14885n = j4;
                }
            }
        }
        this.f14887p.dispose();
        aVar.clear();
        f();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14472d;
    }

    @Override // rg.s
    public final void onComplete() {
        this.e = true;
        if (b()) {
            g();
        }
        this.f14470b.onComplete();
        f();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f14473f = th2;
        this.e = true;
        if (b()) {
            g();
        }
        this.f14470b.onError(th2);
        f();
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.r) {
            return;
        }
        if (c()) {
            io.reactivex.subjects.d dVar = this.f14888q;
            dVar.onNext(obj);
            long j4 = this.f14885n + 1;
            if (j4 >= this.f14883l) {
                this.f14886o++;
                this.f14885n = 0L;
                dVar.onComplete();
                io.reactivex.subjects.d dVar2 = new io.reactivex.subjects.d(this.f14881j);
                this.f14888q = dVar2;
                this.f14470b.onNext(dVar2);
                if (this.f14882k) {
                    ((ug.b) this.f14889s.get()).dispose();
                    rg.w wVar = this.f14884m;
                    r4 r4Var = new r4(this.f14886o, this);
                    long j10 = this.f14878g;
                    DisposableHelper.replace(this.f14889s, wVar.c(r4Var, j10, j10, this.f14879h));
                }
            } else {
                this.f14885n = j4;
            }
            if (this.f14469a.addAndGet(-1) == 0) {
                return;
            }
        } else {
            this.f14471c.offer(NotificationLite.next(obj));
            if (!b()) {
                return;
            }
        }
        g();
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        ug.b e;
        if (DisposableHelper.validate(this.f14887p, bVar)) {
            this.f14887p = bVar;
            ah.c cVar = this.f14470b;
            cVar.onSubscribe(this);
            if (this.f14472d) {
                return;
            }
            io.reactivex.subjects.d dVar = new io.reactivex.subjects.d(this.f14881j);
            this.f14888q = dVar;
            cVar.onNext(dVar);
            r4 r4Var = new r4(this.f14886o, this);
            if (this.f14882k) {
                rg.w wVar = this.f14884m;
                long j4 = this.f14878g;
                e = wVar.c(r4Var, j4, j4, this.f14879h);
            } else {
                rg.x xVar = this.f14880i;
                long j10 = this.f14878g;
                e = xVar.e(r4Var, j10, j10, this.f14879h);
            }
            DisposableHelper.replace(this.f14889s, e);
        }
    }
}
