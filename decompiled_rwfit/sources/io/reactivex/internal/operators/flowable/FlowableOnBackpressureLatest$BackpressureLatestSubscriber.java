package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.ed;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class FlowableOnBackpressureLatest$BackpressureLatestSubscriber<T> extends AtomicInteger implements rg.f, ci.c {
    private static final long serialVersionUID = 163080509307634843L;
    final ci.b actual;
    volatile boolean cancelled;
    volatile boolean done;
    Throwable error;

    /* renamed from: s, reason: collision with root package name */
    ci.c f14477s;
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<T> current = new AtomicReference<>();

    public FlowableOnBackpressureLatest$BackpressureLatestSubscriber(ci.b bVar) {
        this.actual = bVar;
    }

    @Override // ci.c
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.f14477s.cancel();
        if (getAndIncrement() == 0) {
            this.current.lazySet(null);
        }
    }

    public boolean checkTerminated(boolean z5, boolean z6, ci.b bVar, AtomicReference<T> atomicReference) {
        if (this.cancelled) {
            atomicReference.lazySet(null);
            return true;
        }
        if (!z5) {
            return false;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            atomicReference.lazySet(null);
            bVar.onError(th2);
            return true;
        }
        if (!z6) {
            return false;
        }
        bVar.onComplete();
        return true;
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        ci.b bVar = this.actual;
        AtomicLong atomicLong = this.requested;
        AtomicReference<T> atomicReference = this.current;
        int i3 = 1;
        do {
            long j4 = 0;
            while (true) {
                if (j4 == atomicLong.get()) {
                    break;
                }
                boolean z5 = this.done;
                T andSet = atomicReference.getAndSet(null);
                boolean z6 = andSet == null;
                if (checkTerminated(z5, z6, bVar, atomicReference)) {
                    return;
                }
                if (z6) {
                    break;
                }
                bVar.onNext(andSet);
                j4++;
            }
            if (j4 == atomicLong.get()) {
                if (checkTerminated(this.done, atomicReference.get() == null, bVar, atomicReference)) {
                    return;
                }
            }
            if (j4 != 0) {
                ed.b(atomicLong, j4);
            }
            i3 = addAndGet(-i3);
        } while (i3 != 0);
    }

    @Override // ci.b
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // ci.b
    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    @Override // ci.b
    public void onNext(T t8) {
        this.current.lazySet(t8);
        drain();
    }

    @Override // ci.b
    public void onSubscribe(ci.c cVar) {
        if (SubscriptionHelper.validate(this.f14477s, cVar)) {
            this.f14477s = cVar;
            this.actual.onSubscribe(this);
            cVar.request(Format.OFFSET_SAMPLE_RELATIVE);
        }
    }

    @Override // ci.c
    public void request(long j4) {
        if (SubscriptionHelper.validate(j4)) {
            ed.a(this.requested, j4);
            drain();
        }
    }
}
