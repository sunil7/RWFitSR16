package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import com.google.android.gms.internal.mlkit_vision_barcode.gd;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
final class ObservableWithLatestFromMany$WithLatestFromObserver<T, R> extends AtomicInteger implements rg.s, ug.b {
    private static final long serialVersionUID = 1577321883966341961L;
    final rg.s actual;
    final vg.o combiner;

    /* renamed from: d, reason: collision with root package name */
    final AtomicReference<ug.b> f14545d;
    volatile boolean done;
    final AtomicThrowable error;
    final ObservableWithLatestFromMany$WithLatestInnerObserver[] observers;
    final AtomicReferenceArray<Object> values;

    public ObservableWithLatestFromMany$WithLatestFromObserver(rg.s sVar, vg.o oVar, int i3) {
        this.actual = sVar;
        this.combiner = oVar;
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArr = new ObservableWithLatestFromMany$WithLatestInnerObserver[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            observableWithLatestFromMany$WithLatestInnerObserverArr[i10] = new ObservableWithLatestFromMany$WithLatestInnerObserver(this, i10);
        }
        this.observers = observableWithLatestFromMany$WithLatestInnerObserverArr;
        this.values = new AtomicReferenceArray<>(i3);
        this.f14545d = new AtomicReference<>();
        this.error = new AtomicThrowable();
    }

    public void cancelAllBut(int i3) {
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArr = this.observers;
        for (int i10 = 0; i10 < observableWithLatestFromMany$WithLatestInnerObserverArr.length; i10++) {
            if (i10 != i3) {
                observableWithLatestFromMany$WithLatestInnerObserverArr[i10].dispose();
            }
        }
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this.f14545d);
        for (ObservableWithLatestFromMany$WithLatestInnerObserver observableWithLatestFromMany$WithLatestInnerObserver : this.observers) {
            observableWithLatestFromMany$WithLatestInnerObserver.dispose();
        }
    }

    public void innerComplete(int i3, boolean z5) {
        if (z5) {
            return;
        }
        this.done = true;
        cancelAllBut(i3);
        gd.a(this.actual, this, this.error);
    }

    public void innerError(int i3, Throwable th2) {
        this.done = true;
        DisposableHelper.dispose(this.f14545d);
        cancelAllBut(i3);
        gd.b(this.actual, th2, this, this.error);
    }

    public void innerNext(int i3, Object obj) {
        this.values.set(i3, obj);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f14545d.get());
    }

    @Override // rg.s
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        cancelAllBut(-1);
        gd.a(this.actual, this, this.error);
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.done) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.done = true;
        cancelAllBut(-1);
        gd.b(this.actual, th2, this, this.error);
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.done) {
            return;
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.values;
        int length = atomicReferenceArray.length();
        Object[] objArr = new Object[length + 1];
        int i3 = 0;
        objArr[0] = t8;
        while (i3 < length) {
            Object obj = atomicReferenceArray.get(i3);
            if (obj == null) {
                return;
            }
            i3++;
            objArr[i3] = obj;
        }
        try {
            Object apply = this.combiner.apply(objArr);
            xg.c.b(apply, "combiner returned a null value");
            gd.c(this.actual, apply, this, this.error);
        } catch (Throwable th2) {
            ad.a(th2);
            dispose();
            onError(th2);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this.f14545d, bVar);
    }

    public void subscribe(rg.q[] qVarArr, int i3) {
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArr = this.observers;
        AtomicReference<ug.b> atomicReference = this.f14545d;
        for (int i10 = 0; i10 < i3 && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i10++) {
            qVarArr[i10].subscribe(observableWithLatestFromMany$WithLatestInnerObserverArr[i10]);
        }
    }
}
