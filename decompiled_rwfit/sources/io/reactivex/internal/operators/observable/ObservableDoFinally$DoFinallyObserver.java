package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes2.dex */
final class ObservableDoFinally$DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements rg.s {
    private static final long serialVersionUID = 4109457741734051389L;
    final rg.s actual;

    /* renamed from: d, reason: collision with root package name */
    ug.b f14513d;
    final vg.a onFinally;

    /* renamed from: qd, reason: collision with root package name */
    yg.b f14514qd;
    boolean syncFused;

    public ObservableDoFinally$DoFinallyObserver(rg.s sVar, vg.a aVar) {
        this.actual = sVar;
        this.onFinally = aVar;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public void clear() {
        this.f14514qd.clear();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
    public void dispose() {
        this.f14513d.dispose();
        runFinally();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, ug.b
    public boolean isDisposed() {
        return this.f14513d.isDisposed();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public boolean isEmpty() {
        return this.f14514qd.isEmpty();
    }

    @Override // rg.s
    public void onComplete() {
        this.actual.onComplete();
        runFinally();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        this.actual.onError(th2);
        runFinally();
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.actual.onNext(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14513d, bVar)) {
            this.f14513d = bVar;
            if (bVar instanceof yg.b) {
                this.f14514qd = (yg.b) bVar;
            }
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.f
    public T poll() throws Exception {
        T t8 = (T) this.f14514qd.poll();
        if (t8 == null && this.syncFused) {
            runFinally();
        }
        return t8;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, yg.c
    public int requestFusion(int i3) {
        yg.b bVar = this.f14514qd;
        if (bVar == null || (i3 & 4) != 0) {
            return 0;
        }
        int requestFusion = bVar.requestFusion(i3);
        if (requestFusion != 0) {
            this.syncFused = requestFusion == 1;
        }
        return requestFusion;
    }

    public void runFinally() {
        if (compareAndSet(0, 1)) {
            try {
                this.onFinally.run();
            } catch (Throwable th2) {
                ad.a(th2);
                com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            }
        }
    }
}
