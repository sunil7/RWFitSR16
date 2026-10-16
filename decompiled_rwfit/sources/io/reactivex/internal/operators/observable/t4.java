package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class t4 extends io.reactivex.internal.observers.h implements ug.b, Runnable {

    /* renamed from: o, reason: collision with root package name */
    public static final Object f14904o = new Object();

    /* renamed from: g, reason: collision with root package name */
    public final long f14905g;

    /* renamed from: h, reason: collision with root package name */
    public final TimeUnit f14906h;

    /* renamed from: i, reason: collision with root package name */
    public final rg.x f14907i;

    /* renamed from: j, reason: collision with root package name */
    public final int f14908j;

    /* renamed from: k, reason: collision with root package name */
    public ug.b f14909k;

    /* renamed from: l, reason: collision with root package name */
    public io.reactivex.subjects.d f14910l;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicReference f14911m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f14912n;

    public t4(ah.c cVar, long j4, TimeUnit timeUnit, rg.x xVar, int i3) {
        super(cVar, new io.reactivex.internal.queue.a());
        this.f14911m = new AtomicReference();
        this.f14905g = j4;
        this.f14906h = timeUnit;
        this.f14907i = xVar;
        this.f14908j = i3;
    }

    @Override // ug.b
    public final void dispose() {
        this.f14472d = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        r2.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        r8.f14910l = null;
        r0.clear();
        io.reactivex.internal.disposables.DisposableHelper.dispose(r8.f14911m);
        r0 = r8.f14473f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        r2.onError(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r8 = this;
            io.reactivex.internal.queue.a r0 = r8.f14471c
            ah.c r1 = r8.f14470b
            io.reactivex.subjects.d r2 = r8.f14910l
            r3 = 1
        L7:
            boolean r4 = r8.f14912n
            boolean r5 = r8.e
            java.lang.Object r6 = r0.poll()
            java.lang.Object r7 = io.reactivex.internal.operators.observable.t4.f14904o
            if (r5 == 0) goto L2e
            if (r6 == 0) goto L17
            if (r6 != r7) goto L2e
        L17:
            r1 = 0
            r8.f14910l = r1
            r0.clear()
            java.util.concurrent.atomic.AtomicReference r0 = r8.f14911m
            io.reactivex.internal.disposables.DisposableHelper.dispose(r0)
            java.lang.Throwable r0 = r8.f14473f
            if (r0 == 0) goto L2a
            r2.onError(r0)
            return
        L2a:
            r2.onComplete()
            return
        L2e:
            if (r6 != 0) goto L3a
            int r3 = -r3
            java.util.concurrent.atomic.AtomicInteger r4 = r8.f14469a
            int r3 = r4.addAndGet(r3)
            if (r3 != 0) goto L7
            return
        L3a:
            if (r6 != r7) goto L55
            r2.onComplete()
            if (r4 != 0) goto L4f
            int r2 = r8.f14908j
            io.reactivex.subjects.d r4 = new io.reactivex.subjects.d
            r4.<init>(r2)
            r8.f14910l = r4
            r1.onNext(r4)
            r2 = r4
            goto L7
        L4f:
            ug.b r4 = r8.f14909k
            r4.dispose()
            goto L7
        L55:
            java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
            r2.onNext(r4)
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.t4.f():void");
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14472d;
    }

    @Override // rg.s
    public final void onComplete() {
        this.e = true;
        if (b()) {
            f();
        }
        DisposableHelper.dispose(this.f14911m);
        this.f14470b.onComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        this.f14473f = th2;
        this.e = true;
        if (b()) {
            f();
        }
        DisposableHelper.dispose(this.f14911m);
        this.f14470b.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14912n) {
            return;
        }
        if (c()) {
            this.f14910l.onNext(obj);
            if (this.f14469a.addAndGet(-1) == 0) {
                return;
            }
        } else {
            this.f14471c.offer(NotificationLite.next(obj));
            if (!b()) {
                return;
            }
        }
        f();
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14909k, bVar)) {
            this.f14909k = bVar;
            this.f14910l = new io.reactivex.subjects.d(this.f14908j);
            ah.c cVar = this.f14470b;
            cVar.onSubscribe(this);
            cVar.onNext(this.f14910l);
            if (!this.f14472d) {
                rg.x xVar = this.f14907i;
                long j4 = this.f14905g;
                DisposableHelper.replace(this.f14911m, xVar.e(this, j4, j4, this.f14906h));
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f14472d) {
            this.f14912n = true;
            DisposableHelper.dispose(this.f14911m);
        }
        this.f14471c.offer(f14904o);
        if (b()) {
            f();
        }
    }
}
