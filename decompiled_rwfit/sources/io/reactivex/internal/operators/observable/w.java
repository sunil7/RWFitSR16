package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import com.google.android.gms.internal.mlkit_vision_barcode.hd;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class w extends io.reactivex.internal.observers.h implements Runnable, ug.b {

    /* renamed from: g, reason: collision with root package name */
    public final Callable f14959g;

    /* renamed from: h, reason: collision with root package name */
    public final long f14960h;

    /* renamed from: i, reason: collision with root package name */
    public final TimeUnit f14961i;

    /* renamed from: j, reason: collision with root package name */
    public final rg.x f14962j;

    /* renamed from: k, reason: collision with root package name */
    public ug.b f14963k;

    /* renamed from: l, reason: collision with root package name */
    public Collection f14964l;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicReference f14965m;

    public w(ah.c cVar, Callable callable, long j4, TimeUnit timeUnit, rg.x xVar) {
        super(cVar, new io.reactivex.internal.queue.a());
        this.f14965m = new AtomicReference();
        this.f14959g = callable;
        this.f14960h = j4;
        this.f14961i = timeUnit;
        this.f14962j = xVar;
    }

    @Override // io.reactivex.internal.observers.h
    public final void a(ah.c cVar, Object obj) {
        this.f14470b.onNext((Collection) obj);
    }

    @Override // ug.b
    public final void dispose() {
        DisposableHelper.dispose(this.f14965m);
        this.f14963k.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14965m.get() == DisposableHelper.DISPOSED;
    }

    @Override // rg.s
    public final void onComplete() {
        Collection collection;
        synchronized (this) {
            collection = this.f14964l;
            this.f14964l = null;
        }
        if (collection != null) {
            this.f14471c.offer(collection);
            this.e = true;
            if (b()) {
                hd.b(this.f14471c, this.f14470b, null, this);
            }
        }
        DisposableHelper.dispose(this.f14965m);
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        synchronized (this) {
            this.f14964l = null;
        }
        this.f14470b.onError(th2);
        DisposableHelper.dispose(this.f14965m);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Collection collection = this.f14964l;
                if (collection == null) {
                    return;
                }
                collection.add(obj);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14963k, bVar)) {
            this.f14963k = bVar;
            try {
                Object call = this.f14959g.call();
                xg.c.b(call, "The buffer supplied is null");
                this.f14964l = (Collection) call;
                this.f14470b.onSubscribe(this);
                if (!this.f14472d) {
                    rg.x xVar = this.f14962j;
                    long j4 = this.f14960h;
                    ug.b e = xVar.e(this, j4, j4, this.f14961i);
                    AtomicReference atomicReference = this.f14965m;
                    while (!atomicReference.compareAndSet(null, e)) {
                        if (atomicReference.get() != null) {
                            e.dispose();
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                ad.a(th2);
                dispose();
                EmptyDisposable.error(th2, this.f14470b);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Collection collection;
        try {
            Object call = this.f14959g.call();
            xg.c.b(call, "The bufferSupplier returned a null buffer");
            Collection collection2 = (Collection) call;
            synchronized (this) {
                try {
                    collection = this.f14964l;
                    if (collection != null) {
                        this.f14964l = collection2;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (collection == null) {
                DisposableHelper.dispose(this.f14965m);
            } else {
                d(collection, this);
            }
        } catch (Throwable th3) {
            ad.a(th3);
            this.f14470b.onError(th3);
            dispose();
        }
    }
}
