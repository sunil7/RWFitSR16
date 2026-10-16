package io.reactivex.internal.observers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import rg.s;

/* loaded from: classes2.dex */
public final class LambdaObserver<T> extends AtomicReference<ug.b> implements s, ug.b {
    private static final long serialVersionUID = -7251123623727029452L;
    final vg.a onComplete;
    final vg.g onError;
    final vg.g onNext;
    final vg.g onSubscribe;

    public LambdaObserver(vg.g gVar, vg.g gVar2, vg.a aVar, vg.g gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != io.reactivex.internal.functions.a.e;
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // rg.s
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            ad.a(th2);
            a1.b(th2);
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.f(th2);
        } catch (Throwable th3) {
            ad.a(th3);
            a1.b(new CompositeException(th2, th3));
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.f(t8);
        } catch (Throwable th2) {
            ad.a(th2);
            get().dispose();
            onError(th2);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.f(this);
            } catch (Throwable th2) {
                ad.a(th2);
                bVar.dispose();
                onError(th2);
            }
        }
    }
}
