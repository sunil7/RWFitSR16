package com.google.android.gms.internal.mlkit_vision_barcode;

import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public abstract class cd {
    public static void a(rg.l lVar, rg.s sVar) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        sVar.onSubscribe(blockingObserver);
        lVar.subscribe(blockingObserver);
        while (!blockingObserver.isDisposed()) {
            Object poll = linkedBlockingQueue.poll();
            if (poll == null) {
                try {
                    poll = linkedBlockingQueue.take();
                } catch (InterruptedException e) {
                    blockingObserver.dispose();
                    sVar.onError(e);
                    return;
                }
            }
            if (blockingObserver.isDisposed() || lVar == BlockingObserver.TERMINATED || NotificationLite.acceptFull(poll, sVar)) {
                return;
            }
        }
    }

    public static void b(rg.l lVar, vg.g gVar, vg.g gVar2, vg.a aVar) {
        xg.c.b(gVar, "onNext is null");
        xg.c.b(gVar2, "onError is null");
        xg.c.b(aVar, "onComplete is null");
        a(lVar, new LambdaObserver(gVar, gVar2, aVar, io.reactivex.internal.functions.a.f14445d));
    }
}
