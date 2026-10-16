package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ed;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
final class FlowableOnBackpressureError$BackpressureErrorSubscriber<T> extends AtomicLong implements rg.f, ci.c {
    private static final long serialVersionUID = -3176480756392482682L;
    final ci.b actual;
    boolean done;

    /* renamed from: s, reason: collision with root package name */
    ci.c f14476s;

    public FlowableOnBackpressureError$BackpressureErrorSubscriber(ci.b bVar) {
        this.actual = bVar;
    }

    @Override // ci.c
    public void cancel() {
        this.f14476s.cancel();
    }

    @Override // ci.b
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.actual.onComplete();
    }

    @Override // ci.b
    public void onError(Throwable th2) {
        if (this.done) {
            a1.b(th2);
        } else {
            this.done = true;
            this.actual.onError(th2);
        }
    }

    @Override // ci.b
    public void onNext(T t8) {
        if (this.done) {
            return;
        }
        if (get() == 0) {
            onError(new MissingBackpressureException("could not emit value due to lack of requests"));
        } else {
            this.actual.onNext(t8);
            ed.b(this, 1L);
        }
    }

    @Override // ci.b
    public void onSubscribe(ci.c cVar) {
        if (SubscriptionHelper.validate(this.f14476s, cVar)) {
            this.f14476s = cVar;
            this.actual.onSubscribe(this);
            cVar.request(Format.OFFSET_SAMPLE_RELATIVE);
        }
    }

    @Override // ci.c
    public void request(long j4) {
        if (SubscriptionHelper.validate(j4)) {
            ed.a(this, j4);
        }
    }
}
