package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import com.google.android.gms.internal.mlkit_vision_barcode.ed;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
final class FlowableOnBackpressureBuffer$BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements rg.f {
    private static final long serialVersionUID = -2514538129242366402L;
    final ci.b actual;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final vg.a onOverflow;
    boolean outputFused;
    final yg.e queue;
    final AtomicLong requested = new AtomicLong();

    /* renamed from: s, reason: collision with root package name */
    ci.c f14474s;

    public FlowableOnBackpressureBuffer$BackpressureBufferSubscriber(ci.b bVar, int i3, boolean z5, boolean z6, vg.a aVar) {
        this.actual = bVar;
        this.onOverflow = aVar;
        this.delayError = z6;
        this.queue = z5 ? new io.reactivex.internal.queue.b(i3) : new SpscArrayQueue(i3);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, ci.c
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.f14474s.cancel();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public boolean checkTerminated(boolean z5, boolean z6, ci.b bVar) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        }
        if (!z5) {
            return false;
        }
        if (this.delayError) {
            if (!z6) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                bVar.onError(th2);
            } else {
                bVar.onComplete();
            }
            return true;
        }
        Throwable th3 = this.error;
        if (th3 != null) {
            this.queue.clear();
            bVar.onError(th3);
            return true;
        }
        if (!z6) {
            return false;
        }
        bVar.onComplete();
        return true;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, yg.f
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            yg.e eVar = this.queue;
            ci.b bVar = this.actual;
            int i3 = 1;
            while (!checkTerminated(this.done, eVar.isEmpty(), bVar)) {
                long j4 = this.requested.get();
                long j10 = 0;
                while (j10 != j4) {
                    boolean z5 = this.done;
                    Object poll = eVar.poll();
                    boolean z6 = poll == null;
                    if (checkTerminated(z5, z6, bVar)) {
                        return;
                    }
                    if (z6) {
                        break;
                    }
                    bVar.onNext(poll);
                    j10++;
                }
                if (j10 == j4 && checkTerminated(this.done, eVar.isEmpty(), bVar)) {
                    return;
                }
                if (j10 != 0 && j4 != Format.OFFSET_SAMPLE_RELATIVE) {
                    this.requested.addAndGet(-j10);
                }
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, yg.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // ci.b
    public void onComplete() {
        this.done = true;
        if (this.outputFused) {
            this.actual.onComplete();
        } else {
            drain();
        }
    }

    @Override // ci.b
    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        if (this.outputFused) {
            this.actual.onError(th2);
        } else {
            drain();
        }
    }

    @Override // ci.b
    public void onNext(T t8) {
        if (this.queue.offer(t8)) {
            if (this.outputFused) {
                this.actual.onNext(null);
                return;
            } else {
                drain();
                return;
            }
        }
        this.f14474s.cancel();
        MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
        try {
            this.onOverflow.run();
        } catch (Throwable th2) {
            ad.a(th2);
            missingBackpressureException.initCause(th2);
        }
        onError(missingBackpressureException);
    }

    @Override // ci.b
    public void onSubscribe(ci.c cVar) {
        if (SubscriptionHelper.validate(this.f14474s, cVar)) {
            this.f14474s = cVar;
            this.actual.onSubscribe(this);
            cVar.request(Format.OFFSET_SAMPLE_RELATIVE);
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, yg.f
    public T poll() throws Exception {
        return (T) this.queue.poll();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, ci.c
    public void request(long j4) {
        if (this.outputFused || !SubscriptionHelper.validate(j4)) {
            return;
        }
        ed.a(this.requested, j4);
        drain();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, yg.c
    public int requestFusion(int i3) {
        if ((i3 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }
}
