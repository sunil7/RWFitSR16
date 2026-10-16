package io.reactivex.internal.operators.observable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class i extends ah.a {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayBlockingQueue f14683b = new ArrayBlockingQueue(1);

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f14684c = new AtomicInteger();

    @Override // rg.s
    public final void onComplete() {
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        rg.j jVar = (rg.j) obj;
        if (this.f14684c.getAndSet(0) != 1 && jVar.b()) {
            return;
        }
        while (true) {
            ArrayBlockingQueue arrayBlockingQueue = this.f14683b;
            if (arrayBlockingQueue.offer(jVar)) {
                return;
            }
            rg.j jVar2 = (rg.j) arrayBlockingQueue.poll();
            if (jVar2 != null && !jVar2.b()) {
                jVar = jVar2;
            }
        }
    }
}
