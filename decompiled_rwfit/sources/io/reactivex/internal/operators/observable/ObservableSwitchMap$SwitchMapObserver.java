package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableSwitchMap$SwitchMapObserver<T, R> extends AtomicInteger implements rg.s, ug.b {
    static final ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> CANCELLED;
    private static final long serialVersionUID = -3491074160481096299L;
    final rg.s actual;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final vg.o mapper;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14535s;
    volatile long unique;
    final AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
    final AtomicThrowable errors = new AtomicThrowable();

    static {
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> observableSwitchMap$SwitchMapInnerObserver = new ObservableSwitchMap$SwitchMapInnerObserver<>(null, -1L, 1);
        CANCELLED = observableSwitchMap$SwitchMapInnerObserver;
        observableSwitchMap$SwitchMapInnerObserver.cancel();
    }

    public ObservableSwitchMap$SwitchMapObserver(rg.s sVar, vg.o oVar, int i3, boolean z5) {
        this.actual = sVar;
        this.mapper = oVar;
        this.bufferSize = i3;
        this.delayErrors = z5;
    }

    @Override // ug.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.f14535s.dispose();
        disposeInner();
    }

    public void disposeInner() {
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> observableSwitchMap$SwitchMapInnerObserver;
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver2 = this.active.get();
        ObservableSwitchMap$SwitchMapInnerObserver<Object, Object> observableSwitchMap$SwitchMapInnerObserver3 = CANCELLED;
        if (observableSwitchMap$SwitchMapInnerObserver2 == observableSwitchMap$SwitchMapInnerObserver3 || (observableSwitchMap$SwitchMapInnerObserver = (ObservableSwitchMap$SwitchMapInnerObserver) this.active.getAndSet(observableSwitchMap$SwitchMapInnerObserver3)) == observableSwitchMap$SwitchMapInnerObserver3 || observableSwitchMap$SwitchMapInnerObserver == null) {
            return;
        }
        observableSwitchMap$SwitchMapInnerObserver.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0010 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drain() {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapObserver.drain():void");
    }

    public void innerError(ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver, Throwable th2) {
        if (observableSwitchMap$SwitchMapInnerObserver.index != this.unique || !this.errors.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        if (!this.delayErrors) {
            this.f14535s.dispose();
        }
        observableSwitchMap$SwitchMapInnerObserver.done = true;
        drain();
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // rg.s
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.done || !this.errors.addThrowable(th2)) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        if (!this.delayErrors) {
            disposeInner();
        }
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onNext(T t8) {
        long j4 = this.unique + 1;
        this.unique = j4;
        ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver = this.active.get();
        if (observableSwitchMap$SwitchMapInnerObserver != null) {
            observableSwitchMap$SwitchMapInnerObserver.cancel();
        }
        try {
            Object apply = this.mapper.apply(t8);
            xg.c.b(apply, "The ObservableSource returned is null");
            rg.q qVar = (rg.q) apply;
            ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver2 = new ObservableSwitchMap$SwitchMapInnerObserver<>(this, j4, this.bufferSize);
            while (true) {
                ObservableSwitchMap$SwitchMapInnerObserver<T, R> observableSwitchMap$SwitchMapInnerObserver3 = this.active.get();
                if (observableSwitchMap$SwitchMapInnerObserver3 == CANCELLED) {
                    return;
                }
                AtomicReference<ObservableSwitchMap$SwitchMapInnerObserver<T, R>> atomicReference = this.active;
                while (!atomicReference.compareAndSet(observableSwitchMap$SwitchMapInnerObserver3, observableSwitchMap$SwitchMapInnerObserver2)) {
                    if (atomicReference.get() != observableSwitchMap$SwitchMapInnerObserver3) {
                        break;
                    }
                }
                qVar.subscribe(observableSwitchMap$SwitchMapInnerObserver2);
                return;
            }
        } catch (Throwable th2) {
            ad.a(th2);
            this.f14535s.dispose();
            onError(th2);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14535s, bVar)) {
            this.f14535s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
