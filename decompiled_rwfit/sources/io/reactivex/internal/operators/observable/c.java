package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class c extends ah.a implements Iterator {

    /* renamed from: b, reason: collision with root package name */
    public rg.j f14586b;

    /* renamed from: c, reason: collision with root package name */
    public final Semaphore f14587c = new Semaphore(0);

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f14588d = new AtomicReference();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        rg.j jVar = this.f14586b;
        if (jVar != null && NotificationLite.isError(jVar.f18127a)) {
            throw io.reactivex.internal.util.b.b(this.f14586b.a());
        }
        if (this.f14586b == null) {
            try {
                this.f14587c.acquire();
                rg.j jVar2 = (rg.j) this.f14588d.getAndSet(null);
                this.f14586b = jVar2;
                if (NotificationLite.isError(jVar2.f18127a)) {
                    throw io.reactivex.internal.util.b.b(jVar2.a());
                }
            } catch (InterruptedException e) {
                dispose();
                this.f14586b = new rg.j(NotificationLite.error(e));
                throw io.reactivex.internal.util.b.b(e);
            }
        }
        return this.f14586b.b();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.f14586b.f18127a;
        if (obj == null || NotificationLite.isError(obj)) {
            obj = null;
        }
        this.f14586b = null;
        return obj;
    }

    @Override // rg.s
    public final void onComplete() {
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        if (this.f14588d.getAndSet((rg.j) obj) == null) {
            this.f14587c.release();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Read-only iterator.");
    }
}
