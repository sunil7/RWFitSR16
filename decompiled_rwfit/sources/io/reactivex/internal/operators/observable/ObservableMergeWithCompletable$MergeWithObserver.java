package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.gd;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableMergeWithCompletable$MergeWithObserver<T> extends AtomicInteger implements rg.s, ug.b {
    private static final long serialVersionUID = -4592979584110982903L;
    final rg.s actual;
    volatile boolean mainDone;
    volatile boolean otherDone;
    final AtomicReference<ug.b> mainDisposable = new AtomicReference<>();
    final OtherObserver otherObserver = new OtherObserver(this);
    final AtomicThrowable error = new AtomicThrowable();

    public static final class OtherObserver extends AtomicReference<ug.b> implements rg.b {
        private static final long serialVersionUID = -2935427570954647017L;
        final ObservableMergeWithCompletable$MergeWithObserver<?> parent;

        public OtherObserver(ObservableMergeWithCompletable$MergeWithObserver<?> observableMergeWithCompletable$MergeWithObserver) {
            this.parent = observableMergeWithCompletable$MergeWithObserver;
        }

        @Override // rg.b, rg.h
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // rg.b
        public void onError(Throwable th2) {
            this.parent.otherError(th2);
        }

        @Override // rg.b
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableMergeWithCompletable$MergeWithObserver(rg.s sVar) {
        this.actual = sVar;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.mainDisposable.get());
    }

    @Override // rg.s
    public void onComplete() {
        this.mainDone = true;
        if (this.otherDone) {
            gd.a(this.actual, this, this.error);
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.mainDisposable);
        gd.b(this.actual, th2, this, this.error);
    }

    @Override // rg.s
    public void onNext(T t8) {
        gd.c(this.actual, t8, this, this.error);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this.mainDisposable, bVar);
    }

    public void otherComplete() {
        this.otherDone = true;
        if (this.mainDone) {
            gd.a(this.actual, this, this.error);
        }
    }

    public void otherError(Throwable th2) {
        DisposableHelper.dispose(this.mainDisposable);
        gd.b(this.actual, th2, this, this.error);
    }
}
