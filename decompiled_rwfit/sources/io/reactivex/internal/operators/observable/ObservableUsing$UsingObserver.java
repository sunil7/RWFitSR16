package io.reactivex.internal.operators.observable;

import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class ObservableUsing$UsingObserver<T, D> extends AtomicBoolean implements rg.s, ug.b {
    private static final long serialVersionUID = 5904473792286235046L;
    final rg.s actual;
    final vg.g disposer;
    final boolean eager;
    final D resource;

    /* renamed from: s, reason: collision with root package name */
    ug.b f14541s;

    public ObservableUsing$UsingObserver(rg.s sVar, D d5, vg.g gVar, boolean z5) {
        this.actual = sVar;
        this.resource = d5;
        this.disposer = gVar;
        this.eager = z5;
    }

    @Override // ug.b
    public void dispose() {
        disposeAfter();
        this.f14541s.dispose();
    }

    public void disposeAfter() {
        if (compareAndSet(false, true)) {
            try {
                this.disposer.f(this.resource);
            } catch (Throwable th2) {
                ad.a(th2);
                com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            }
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return get();
    }

    @Override // rg.s
    public void onComplete() {
        if (!this.eager) {
            this.actual.onComplete();
            this.f14541s.dispose();
            disposeAfter();
            return;
        }
        if (compareAndSet(false, true)) {
            try {
                this.disposer.f(this.resource);
            } catch (Throwable th2) {
                ad.a(th2);
                this.actual.onError(th2);
                return;
            }
        }
        this.f14541s.dispose();
        this.actual.onComplete();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (!this.eager) {
            this.actual.onError(th2);
            this.f14541s.dispose();
            disposeAfter();
            return;
        }
        if (compareAndSet(false, true)) {
            try {
                this.disposer.f(this.resource);
            } catch (Throwable th3) {
                ad.a(th3);
                th2 = new CompositeException(th2, th3);
            }
        }
        this.f14541s.dispose();
        this.actual.onError(th2);
    }

    @Override // rg.s
    public void onNext(T t8) {
        this.actual.onNext(t8);
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14541s, bVar)) {
            this.f14541s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
