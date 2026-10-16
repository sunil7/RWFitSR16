package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableWithLatestFrom$WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements rg.s, ug.b {
    private static final long serialVersionUID = -312246233408980075L;
    final rg.s actual;
    final vg.c combiner;

    /* renamed from: s, reason: collision with root package name */
    final AtomicReference<ug.b> f14544s = new AtomicReference<>();
    final AtomicReference<ug.b> other = new AtomicReference<>();

    public ObservableWithLatestFrom$WithLatestFromObserver(rg.s sVar, vg.c cVar) {
        this.actual = sVar;
        this.combiner = cVar;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this.f14544s);
        DisposableHelper.dispose(this.other);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f14544s.get());
    }

    @Override // rg.s
    public void onComplete() {
        DisposableHelper.dispose(this.other);
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.other);
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        U u10 = get();
        if (u10 != null) {
            try {
                Object a3 = this.combiner.a(t8, u10);
                xg.c.b(a3, "The combiner returned a null value");
                this.actual.onNext(a3);
            } catch (Throwable th2) {
                ad.a(th2);
                dispose();
                this.actual.onError(th2);
            }
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this.f14544s, bVar);
    }

    public void otherError(Throwable th2) {
        DisposableHelper.dispose(this.f14544s);
        this.actual.onError(th2);
    }

    public boolean setOther(ug.b bVar) {
        return DisposableHelper.setOnce(this.other, bVar);
    }
}
