package io.reactivex.subjects;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rg.s;

/* loaded from: classes2.dex */
public final class d extends c {

    /* renamed from: a, reason: collision with root package name */
    public final io.reactivex.internal.queue.b f15139a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f15140b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f15141c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f15142d;
    public volatile boolean e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f15143f;

    /* renamed from: g, reason: collision with root package name */
    public Throwable f15144g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f15145h;

    /* renamed from: i, reason: collision with root package name */
    public final BasicIntQueueDisposable f15146i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15147j;

    public d(int i3) {
        xg.c.c(i3, "capacityHint");
        this.f15139a = new io.reactivex.internal.queue.b(i3);
        this.f15141c = new AtomicReference();
        this.f15142d = true;
        this.f15140b = new AtomicReference();
        this.f15145h = new AtomicBoolean();
        this.f15146i = new BasicIntQueueDisposable<Object>() { // from class: io.reactivex.subjects.UnicastSubject$UnicastQueueDisposable
            private static final long serialVersionUID = 7926949470189395511L;

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
            public void clear() {
                d.this.f15139a.clear();
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
            public void dispose() {
                if (d.this.e) {
                    return;
                }
                d.this.e = true;
                d.this.c();
                d.this.f15140b.lazySet(null);
                if (d.this.f15146i.getAndIncrement() == 0) {
                    d.this.f15140b.lazySet(null);
                    d.this.f15139a.clear();
                }
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
            public boolean isDisposed() {
                return d.this.e;
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
            public boolean isEmpty() {
                return d.this.f15139a.isEmpty();
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
            public Object poll() throws Exception {
                return d.this.f15139a.poll();
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.c
            public int requestFusion(int i10) {
                if ((i10 & 2) == 0) {
                    return 0;
                }
                d.this.f15147j = true;
                return 2;
            }
        };
    }

    public final void c() {
        AtomicReference atomicReference = this.f15141c;
        Runnable runnable = (Runnable) atomicReference.get();
        if (runnable != null) {
            while (!atomicReference.compareAndSet(runnable, null)) {
                if (atomicReference.get() != runnable) {
                    return;
                }
            }
            runnable.run();
        }
    }

    public final void d() {
        Throwable th2;
        if (this.f15146i.getAndIncrement() != 0) {
            return;
        }
        s sVar = (s) this.f15140b.get();
        int i3 = 1;
        int i10 = 1;
        while (sVar == null) {
            i10 = this.f15146i.addAndGet(-i10);
            if (i10 == 0) {
                return;
            } else {
                sVar = (s) this.f15140b.get();
            }
        }
        if (this.f15147j) {
            io.reactivex.internal.queue.b bVar = this.f15139a;
            boolean z5 = this.f15142d;
            while (!this.e) {
                boolean z6 = this.f15143f;
                if (!z5 && z6 && (th2 = this.f15144g) != null) {
                    this.f15140b.lazySet(null);
                    bVar.clear();
                    sVar.onError(th2);
                    return;
                }
                sVar.onNext(null);
                if (z6) {
                    this.f15140b.lazySet(null);
                    Throwable th3 = this.f15144g;
                    if (th3 != null) {
                        sVar.onError(th3);
                        return;
                    } else {
                        sVar.onComplete();
                        return;
                    }
                }
                i3 = this.f15146i.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
            this.f15140b.lazySet(null);
            bVar.clear();
            return;
        }
        io.reactivex.internal.queue.b bVar2 = this.f15139a;
        boolean z8 = this.f15142d;
        boolean z10 = true;
        int i11 = 1;
        while (!this.e) {
            boolean z11 = this.f15143f;
            Object poll = this.f15139a.poll();
            boolean z12 = poll == null;
            if (z11) {
                if (!z8 && z10) {
                    Throwable th4 = this.f15144g;
                    if (th4 != null) {
                        this.f15140b.lazySet(null);
                        bVar2.clear();
                        sVar.onError(th4);
                        return;
                    }
                    z10 = false;
                }
                if (z12) {
                    this.f15140b.lazySet(null);
                    Throwable th5 = this.f15144g;
                    if (th5 != null) {
                        sVar.onError(th5);
                        return;
                    } else {
                        sVar.onComplete();
                        return;
                    }
                }
            }
            if (z12) {
                i11 = this.f15146i.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                sVar.onNext(poll);
            }
        }
        this.f15140b.lazySet(null);
        bVar2.clear();
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.f15143f || this.e) {
            return;
        }
        this.f15143f = true;
        c();
        d();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        xg.c.b(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f15143f || this.e) {
            a1.b(th2);
            return;
        }
        this.f15144g = th2;
        this.f15143f = true;
        c();
        d();
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        xg.c.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f15143f || this.e) {
            return;
        }
        this.f15139a.offer(obj);
        d();
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (this.f15143f || this.e) {
            bVar.dispose();
        }
    }

    @Override // rg.l
    public final void subscribeActual(s sVar) {
        if (this.f15145h.get() || !this.f15145h.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), sVar);
            return;
        }
        sVar.onSubscribe(this.f15146i);
        this.f15140b.lazySet(sVar);
        if (this.e) {
            this.f15140b.lazySet(null);
        } else {
            d();
        }
    }

    public d(Runnable runnable, int i3) {
        xg.c.c(i3, "capacityHint");
        this.f15139a = new io.reactivex.internal.queue.b(i3);
        this.f15141c = new AtomicReference(runnable);
        this.f15142d = true;
        this.f15140b = new AtomicReference();
        this.f15145h = new AtomicBoolean();
        this.f15146i = new BasicIntQueueDisposable<Object>() { // from class: io.reactivex.subjects.UnicastSubject$UnicastQueueDisposable
            private static final long serialVersionUID = 7926949470189395511L;

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
            public void clear() {
                d.this.f15139a.clear();
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
            public void dispose() {
                if (d.this.e) {
                    return;
                }
                d.this.e = true;
                d.this.c();
                d.this.f15140b.lazySet(null);
                if (d.this.f15146i.getAndIncrement() == 0) {
                    d.this.f15140b.lazySet(null);
                    d.this.f15139a.clear();
                }
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
            public boolean isDisposed() {
                return d.this.e;
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
            public boolean isEmpty() {
                return d.this.f15139a.isEmpty();
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
            public Object poll() throws Exception {
                return d.this.f15139a.poll();
            }

            @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.c
            public int requestFusion(int i10) {
                if ((i10 & 2) == 0) {
                    return 0;
                }
                d.this.f15147j = true;
                return 2;
            }
        };
    }
}
