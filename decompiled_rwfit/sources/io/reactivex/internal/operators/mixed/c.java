package io.reactivex.internal.operators.mixed;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
import rg.s;
import vg.o;

/* loaded from: classes2.dex */
public final class c implements s, ug.b {

    /* renamed from: h, reason: collision with root package name */
    public static final ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver f14495h = new ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver(null);

    /* renamed from: a, reason: collision with root package name */
    public final rg.b f14496a;

    /* renamed from: b, reason: collision with root package name */
    public final o f14497b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14498c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicThrowable f14499d = new AtomicThrowable();
    public final AtomicReference e = new AtomicReference();

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f14500f;

    /* renamed from: g, reason: collision with root package name */
    public ug.b f14501g;

    public c(rg.b bVar, o oVar, boolean z5) {
        this.f14496a = bVar;
        this.f14497b = oVar;
        this.f14498c = z5;
    }

    @Override // ug.b
    public final void dispose() {
        this.f14501g.dispose();
        AtomicReference atomicReference = this.e;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver = f14495h;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2 = (ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver) atomicReference.getAndSet(observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver);
        if (observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2 == null || observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2 == observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver) {
            return;
        }
        observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2.dispose();
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.e.get() == f14495h;
    }

    @Override // rg.s
    public final void onComplete() {
        this.f14500f = true;
        if (this.e.get() == null) {
            Throwable terminate = this.f14499d.terminate();
            if (terminate == null) {
                this.f14496a.onComplete();
            } else {
                this.f14496a.onError(terminate);
            }
        }
    }

    @Override // rg.s
    public final void onError(Throwable th2) {
        AtomicThrowable atomicThrowable = this.f14499d;
        if (!atomicThrowable.addThrowable(th2)) {
            a1.b(th2);
            return;
        }
        if (this.f14498c) {
            onComplete();
            return;
        }
        AtomicReference atomicReference = this.e;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver = f14495h;
        ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2 = (ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver) atomicReference.getAndSet(observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver);
        if (observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2 != null && observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2 != observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver) {
            observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2.dispose();
        }
        Throwable terminate = atomicThrowable.terminate();
        if (terminate != io.reactivex.internal.util.b.f15123a) {
            this.f14496a.onError(terminate);
        }
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        try {
            Object apply = this.f14497b.apply(obj);
            xg.c.b(apply, "The mapper returned a null CompletableSource");
            rg.c cVar = (rg.c) apply;
            ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver = new ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver(this);
            while (true) {
                AtomicReference atomicReference = this.e;
                ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2 = (ObservableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver) atomicReference.get();
                if (observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2 == f14495h) {
                    return;
                }
                while (!atomicReference.compareAndSet(observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2, observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver)) {
                    if (atomicReference.get() != observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2) {
                        break;
                    }
                }
                if (observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2 != null) {
                    observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver2.dispose();
                }
                ((rg.a) cVar).b(observableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver);
                return;
            }
        } catch (Throwable th2) {
            ad.a(th2);
            this.f14501g.dispose();
            onError(th2);
        }
    }

    @Override // rg.s
    public final void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.f14501g, bVar)) {
            this.f14501g = bVar;
            this.f14496a.onSubscribe(this);
        }
    }
}
