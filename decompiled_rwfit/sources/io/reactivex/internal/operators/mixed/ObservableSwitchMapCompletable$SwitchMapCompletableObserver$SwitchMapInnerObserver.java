package io.reactivex.internal.operators.mixed;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver extends AtomicReference<ug.b> implements rg.b {
    private static final long serialVersionUID = -8003404460084760287L;
    final c parent;

    public ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver(c cVar) {
        this.parent = cVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // rg.b, rg.h
    public void onComplete() {
        c cVar = this.parent;
        AtomicReference atomicReference = cVar.e;
        while (!atomicReference.compareAndSet(this, null)) {
            if (atomicReference.get() != this) {
                return;
            }
        }
        if (cVar.f14500f) {
            Throwable terminate = cVar.f14499d.terminate();
            if (terminate == null) {
                cVar.f14496a.onComplete();
            } else {
                cVar.f14496a.onError(terminate);
            }
        }
    }

    @Override // rg.b
    public void onError(Throwable th2) {
        c cVar = this.parent;
        AtomicReference atomicReference = cVar.e;
        while (true) {
            if (atomicReference.compareAndSet(this, null)) {
                if (cVar.f14499d.addThrowable(th2)) {
                    if (cVar.f14498c) {
                        if (cVar.f14500f) {
                            cVar.f14496a.onError(cVar.f14499d.terminate());
                            return;
                        }
                        return;
                    }
                    cVar.dispose();
                    Throwable terminate = cVar.f14499d.terminate();
                    if (terminate != io.reactivex.internal.util.b.f15123a) {
                        cVar.f14496a.onError(terminate);
                        return;
                    }
                    return;
                }
            } else if (atomicReference.get() != this) {
                break;
            }
        }
        a1.b(th2);
    }

    @Override // rg.b
    public void onSubscribe(ug.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
