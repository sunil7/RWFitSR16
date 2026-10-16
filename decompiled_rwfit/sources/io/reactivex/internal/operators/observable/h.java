package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class h implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final i f14659a;

    /* renamed from: b, reason: collision with root package name */
    public final rg.l f14660b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14661c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14662d = true;
    public boolean e = true;

    /* renamed from: f, reason: collision with root package name */
    public Throwable f14663f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14664g;

    public h(rg.l lVar, i iVar) {
        this.f14660b = lVar;
        this.f14659a = iVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Throwable th2 = this.f14663f;
        if (th2 != null) {
            throw io.reactivex.internal.util.b.b(th2);
        }
        if (!this.f14662d) {
            return false;
        }
        if (!this.e) {
            return true;
        }
        boolean z5 = this.f14664g;
        i iVar = this.f14659a;
        AtomicInteger atomicInteger = iVar.f14684c;
        if (!z5) {
            this.f14664g = true;
            atomicInteger.set(1);
            new a3(this.f14660b, 7).subscribe(iVar);
        }
        try {
            atomicInteger.set(1);
            rg.j jVar = (rg.j) iVar.f14683b.take();
            boolean b3 = jVar.b();
            Object obj = jVar.f18127a;
            if (b3) {
                this.e = false;
                if (obj == null || NotificationLite.isError(obj)) {
                    obj = null;
                }
                this.f14661c = obj;
                return true;
            }
            this.f14662d = false;
            if (obj == null) {
                return false;
            }
            Throwable a3 = jVar.a();
            this.f14663f = a3;
            throw io.reactivex.internal.util.b.b(a3);
        } catch (InterruptedException e) {
            iVar.dispose();
            this.f14663f = e;
            throw io.reactivex.internal.util.b.b(e);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        Throwable th2 = this.f14663f;
        if (th2 != null) {
            throw io.reactivex.internal.util.b.b(th2);
        }
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }
        this.e = true;
        return this.f14661c;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Read only iterator");
    }
}
