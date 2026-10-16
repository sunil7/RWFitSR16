package io.reactivex.internal.observers;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import rg.s;
import vg.p;

/* loaded from: classes2.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<ug.b> implements s, ug.b {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final vg.a onComplete;
    final vg.g onError;
    final p onNext;

    public ForEachWhileObserver(p pVar, vg.g gVar, vg.a aVar) {
        this.onNext = pVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // ug.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // rg.s
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th2) {
            ad.a(th2);
            a1.b(th2);
        }
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.done) {
            a1.b(th2);
            return;
        }
        this.done = true;
        try {
            this.onError.f(th2);
        } catch (Throwable th3) {
            ad.a(th3);
            a1.b(new CompositeException(th2, th3));
        }
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.l(t8)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th2) {
            ad.a(th2);
            dispose();
            onError(th2);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
