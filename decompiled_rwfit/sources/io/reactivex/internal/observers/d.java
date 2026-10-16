package io.reactivex.internal.observers;

import java.util.concurrent.CountDownLatch;
import rg.z;

/* loaded from: classes2.dex */
public final class d extends CountDownLatch implements z, rg.b, rg.h {

    /* renamed from: a, reason: collision with root package name */
    public Object f14458a;

    /* renamed from: b, reason: collision with root package name */
    public Throwable f14459b;

    /* renamed from: c, reason: collision with root package name */
    public ug.b f14460c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f14461d;

    public final Object a() {
        if (getCount() != 0) {
            try {
                await();
            } catch (InterruptedException e) {
                this.f14461d = true;
                ug.b bVar = this.f14460c;
                if (bVar != null) {
                    bVar.dispose();
                }
                throw io.reactivex.internal.util.b.b(e);
            }
        }
        Throwable th2 = this.f14459b;
        if (th2 == null) {
            return this.f14458a;
        }
        throw io.reactivex.internal.util.b.b(th2);
    }

    @Override // rg.b, rg.h
    public final void onComplete() {
        countDown();
    }

    @Override // rg.z
    public final void onError(Throwable th2) {
        this.f14459b = th2;
        countDown();
    }

    @Override // rg.z
    public final void onSubscribe(ug.b bVar) {
        this.f14460c = bVar;
        if (this.f14461d) {
            bVar.dispose();
        }
    }

    @Override // rg.z, rg.h
    public final void onSuccess(Object obj) {
        this.f14458a = obj;
        countDown();
    }
}
