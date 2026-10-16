package io.reactivex.internal.observers;

import com.google.android.gms.internal.mlkit_vision_barcode.hd;
import java.util.concurrent.atomic.AtomicInteger;
import rg.s;

/* loaded from: classes2.dex */
public abstract class h implements s {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f14469a = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    public final ah.c f14470b;

    /* renamed from: c, reason: collision with root package name */
    public final io.reactivex.internal.queue.a f14471c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f14472d;
    public volatile boolean e;

    /* renamed from: f, reason: collision with root package name */
    public Throwable f14473f;

    public h(ah.c cVar, io.reactivex.internal.queue.a aVar) {
        this.f14470b = cVar;
        this.f14471c = aVar;
    }

    public void a(ah.c cVar, Object obj) {
    }

    public final boolean b() {
        return this.f14469a.getAndIncrement() == 0;
    }

    public final boolean c() {
        AtomicInteger atomicInteger = this.f14469a;
        return atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1);
    }

    public final void d(Object obj, ug.b bVar) {
        AtomicInteger atomicInteger = this.f14469a;
        int i3 = atomicInteger.get();
        ah.c cVar = this.f14470b;
        io.reactivex.internal.queue.a aVar = this.f14471c;
        if (i3 == 0 && atomicInteger.compareAndSet(0, 1)) {
            a(cVar, obj);
            if (atomicInteger.addAndGet(-1) == 0) {
                return;
            }
        } else {
            aVar.offer(obj);
            if (!b()) {
                return;
            }
        }
        hd.b(aVar, cVar, bVar, this);
    }

    public final void e(Object obj, ug.b bVar) {
        AtomicInteger atomicInteger = this.f14469a;
        int i3 = atomicInteger.get();
        ah.c cVar = this.f14470b;
        io.reactivex.internal.queue.a aVar = this.f14471c;
        if (i3 != 0 || !atomicInteger.compareAndSet(0, 1)) {
            aVar.offer(obj);
            if (!b()) {
                return;
            }
        } else if (aVar.isEmpty()) {
            a(cVar, obj);
            if (atomicInteger.addAndGet(-1) == 0) {
                return;
            }
        } else {
            aVar.offer(obj);
        }
        hd.b(aVar, cVar, bVar, this);
    }
}
