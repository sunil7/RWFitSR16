package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import com.google.android.gms.internal.mlkit_vision_barcode.hd;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class v extends io.reactivex.internal.observers.h implements Runnable, ug.b {

    /* renamed from: g, reason: collision with root package name */
    public final Callable f14930g;

    /* renamed from: h, reason: collision with root package name */
    public final long f14931h;

    /* renamed from: i, reason: collision with root package name */
    public final TimeUnit f14932i;

    /* renamed from: j, reason: collision with root package name */
    public final int f14933j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f14934k;

    /* renamed from: l, reason: collision with root package name */
    public final rg.w f14935l;

    /* renamed from: m, reason: collision with root package name */
    public Collection f14936m;

    /* renamed from: n, reason: collision with root package name */
    public ug.b f14937n;

    /* renamed from: o, reason: collision with root package name */
    public ug.b f14938o;

    /* renamed from: p, reason: collision with root package name */
    public long f14939p;

    /* renamed from: q, reason: collision with root package name */
    public long f14940q;

    public v(ah.c cVar, Callable callable, long j4, TimeUnit timeUnit, int i3, boolean z5, rg.w wVar) {
        super(cVar, new io.reactivex.internal.queue.a());
        this.f14930g = callable;
        this.f14931h = j4;
        this.f14932i = timeUnit;
        this.f14933j = i3;
        this.f14934k = z5;
        this.f14935l = wVar;
    }

    @Override // io.reactivex.internal.observers.h
    public final void a(ah.c cVar, Object obj) {
        cVar.onNext((Collection) obj);
    }

    @Override // ug.b
    public final void dispose() {
        if (this.f14472d) {
            return;
        }
        this.f14472d = true;
        this.f14938o.dispose();
        this.f14935l.dispose();
        synchronized (this) {
            this.f14936m = null;
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14472d;
    }

    @Override // rg.s
    public final void onComplete() {
        Collection collection;
        this.f14935l.dispose();
        synchronized (this) {
            collection = this.f14936m;
            this.f14936m = null;
        }
        this.f14471c.offer(collection);
        this.e = true;
        if (b()) {
            hd.b(this.f14471c, this.f14470b, this, this);
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        synchronized (this) {
            this.f14936m = null;
        }
        this.f14470b.onError(th2);
        this.f14935l.dispose();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:53:0x0076
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // rg.s
    public final void onNext(java.lang.Object r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Collection r0 = r7.f14936m     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto Lc
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L7
            return
        L7:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L74
        Lc:
            r0.add(r8)     // Catch: java.lang.Throwable -> L71
            int r8 = r0.size()     // Catch: java.lang.Throwable -> L71
            int r1 = r7.f14933j     // Catch: java.lang.Throwable -> L71
            if (r8 >= r1) goto L19
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L7
            return
        L19:
            r8 = 0
            r7.f14936m = r8     // Catch: java.lang.Throwable -> L71
            long r1 = r7.f14939p     // Catch: java.lang.Throwable -> L71
            r3 = 1
            long r1 = r1 + r3
            r7.f14939p = r1     // Catch: java.lang.Throwable -> L71
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L71
            boolean r8 = r7.f14934k
            if (r8 == 0) goto L2d
            ug.b r8 = r7.f14937n
            r8.dispose()
        L2d:
            r7.e(r0, r7)
            java.util.concurrent.Callable r8 = r7.f14930g     // Catch: java.lang.Throwable -> L62
            java.lang.Object r8 = r8.call()     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = "The buffer supplied is null"
            xg.c.b(r8, r0)     // Catch: java.lang.Throwable -> L62
            java.util.Collection r8 = (java.util.Collection) r8     // Catch: java.lang.Throwable -> L62
            monitor-enter(r7)
            r7.f14936m = r8     // Catch: java.lang.Throwable -> L5b
            long r0 = r7.f14940q     // Catch: java.lang.Throwable -> L5b
            long r0 = r0 + r3
            r7.f14940q = r0     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L5b
            boolean r8 = r7.f14934k
            if (r8 == 0) goto L59
            rg.w r0 = r7.f14935l
            long r2 = r7.f14931h
            java.util.concurrent.TimeUnit r6 = r7.f14932i
            r4 = r2
            r1 = r7
            ug.b r8 = r0.c(r1, r2, r4, r6)
            r1.f14937n = r8
            return
        L59:
            r1 = r7
            return
        L5b:
            r0 = move-exception
            r1 = r7
        L5d:
            r8 = r0
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L60
            throw r8
        L60:
            r0 = move-exception
            goto L5d
        L62:
            r0 = move-exception
            r1 = r7
            r8 = r0
            com.google.android.gms.internal.mlkit_vision_barcode.ad.a(r8)
            ah.c r0 = r1.f14470b
            r0.onError(r8)
            r7.dispose()
            return
        L71:
            r0 = move-exception
            r1 = r7
        L73:
            r8 = r0
        L74:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            throw r8
        L76:
            r0 = move-exception
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.v.onNext(java.lang.Object):void");
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        ah.c cVar = this.f14470b;
        if (DisposableHelper.validate(this.f14938o, bVar)) {
            this.f14938o = bVar;
            try {
                Object call = this.f14930g.call();
                xg.c.b(call, "The buffer supplied is null");
                this.f14936m = (Collection) call;
                cVar.onSubscribe(this);
                TimeUnit timeUnit = this.f14932i;
                rg.w wVar = this.f14935l;
                long j4 = this.f14931h;
                this.f14937n = wVar.c(this, j4, j4, timeUnit);
            } catch (Throwable th2) {
                ad.a(th2);
                bVar.dispose();
                EmptyDisposable.error(th2, cVar);
                this.f14935l.dispose();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Object call = this.f14930g.call();
            xg.c.b(call, "The bufferSupplier returned a null buffer");
            Collection collection = (Collection) call;
            synchronized (this) {
                Collection collection2 = this.f14936m;
                if (collection2 != null && this.f14939p == this.f14940q) {
                    this.f14936m = collection;
                    e(collection2, this);
                }
            }
        } catch (Throwable th2) {
            ad.a(th2);
            dispose();
            this.f14470b.onError(th2);
        }
    }
}
