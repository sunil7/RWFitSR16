package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class o4 extends io.reactivex.internal.observers.h implements ug.b {

    /* renamed from: g, reason: collision with root package name */
    public final rg.q f14803g;

    /* renamed from: h, reason: collision with root package name */
    public final vg.o f14804h;

    /* renamed from: i, reason: collision with root package name */
    public final int f14805i;

    /* renamed from: j, reason: collision with root package name */
    public final ug.a f14806j;

    /* renamed from: k, reason: collision with root package name */
    public ug.b f14807k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicReference f14808l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f14809m;

    /* renamed from: n, reason: collision with root package name */
    public final AtomicLong f14810n;

    public o4(ah.c cVar, rg.q qVar, vg.o oVar, int i3) {
        super(cVar, new io.reactivex.internal.queue.a());
        this.f14808l = new AtomicReference();
        AtomicLong atomicLong = new AtomicLong();
        this.f14810n = atomicLong;
        this.f14803g = qVar;
        this.f14804h = oVar;
        this.f14805i = i3;
        this.f14806j = new ug.a();
        this.f14809m = new ArrayList();
        atomicLong.lazySet(1L);
    }

    @Override // io.reactivex.internal.observers.h
    public final void a(ah.c cVar, Object obj) {
    }

    @Override // ug.b
    public final void dispose() {
        this.f14472d = true;
    }

    public final void f() {
        io.reactivex.internal.queue.a aVar = this.f14471c;
        ah.c cVar = this.f14470b;
        ArrayList arrayList = this.f14809m;
        int i3 = 1;
        while (true) {
            boolean z5 = this.e;
            Object poll = aVar.poll();
            int i10 = 0;
            boolean z6 = poll == null;
            if (z5 && z6) {
                this.f14806j.dispose();
                DisposableHelper.dispose(this.f14808l);
                Throwable th2 = this.f14473f;
                if (th2 != null) {
                    int size = arrayList.size();
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        ((io.reactivex.subjects.d) obj).onError(th2);
                    }
                } else {
                    int size2 = arrayList.size();
                    while (i10 < size2) {
                        Object obj2 = arrayList.get(i10);
                        i10++;
                        ((io.reactivex.subjects.d) obj2).onComplete();
                    }
                }
                arrayList.clear();
                return;
            }
            if (z6) {
                i3 = this.f14469a.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else if (poll instanceof p4) {
                p4 p4Var = (p4) poll;
                io.reactivex.subjects.d dVar = p4Var.f14829a;
                if (dVar != null) {
                    if (arrayList.remove(dVar)) {
                        p4Var.f14829a.onComplete();
                        if (this.f14810n.decrementAndGet() == 0) {
                            this.f14806j.dispose();
                            DisposableHelper.dispose(this.f14808l);
                            return;
                        }
                    } else {
                        continue;
                    }
                } else if (!this.f14472d) {
                    io.reactivex.subjects.d dVar2 = new io.reactivex.subjects.d(this.f14805i);
                    arrayList.add(dVar2);
                    cVar.onNext(dVar2);
                    try {
                        Object apply = this.f14804h.apply(p4Var.f14830b);
                        xg.c.b(apply, "The ObservableSource supplied is null");
                        rg.q qVar = (rg.q) apply;
                        n4 n4Var = new n4(this, dVar2);
                        if (this.f14806j.c(n4Var)) {
                            this.f14810n.getAndIncrement();
                            qVar.subscribe(n4Var);
                        }
                    } catch (Throwable th3) {
                        ad.a(th3);
                        this.f14472d = true;
                        cVar.onError(th3);
                    }
                }
            } else {
                int size3 = arrayList.size();
                while (i10 < size3) {
                    Object obj3 = arrayList.get(i10);
                    i10++;
                    ((io.reactivex.subjects.d) obj3).onNext(NotificationLite.getValue(poll));
                }
            }
        }
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14472d;
    }

    @Override // rg.s
    public final void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        if (b()) {
            f();
        }
        if (this.f14810n.decrementAndGet() == 0) {
            this.f14806j.dispose();
        }
        this.f14470b.onComplete();
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        if (this.e) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.f14473f = th2;
        this.e = true;
        if (b()) {
            f();
        }
        if (this.f14810n.decrementAndGet() == 0) {
            this.f14806j.dispose();
        }
        this.f14470b.onError(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (c()) {
            ArrayList arrayList = this.f14809m;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                ((io.reactivex.subjects.d) obj2).onNext(obj);
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
        f();
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14807k, bVar)) {
            this.f14807k = bVar;
            this.f14470b.onSubscribe(this);
            if (this.f14472d) {
                return;
            }
            u uVar = new u(this, 1);
            AtomicReference atomicReference = this.f14808l;
            while (!atomicReference.compareAndSet(null, uVar)) {
                if (atomicReference.get() != null) {
                    return;
                }
            }
            this.f14810n.getAndIncrement();
            this.f14803g.subscribe(uVar);
        }
    }
}
