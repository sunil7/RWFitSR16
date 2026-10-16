package io.reactivex.internal.operators.mixed;

import com.google.android.gms.internal.mlkit_vision_barcode.a1;
import com.google.android.gms.internal.mlkit_vision_barcode.ad;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rg.g;
import rg.h;
import rg.i;
import rg.s;
import vg.o;

/* loaded from: classes2.dex */
final class ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements s, ug.b {
    static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver<>(null);
    private static final long serialVersionUID = -5402190102429853762L;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final s downstream;
    final AtomicThrowable errors = new AtomicThrowable();
    final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();
    final o mapper;
    ug.b upstream;

    public static final class SwitchMapMaybeObserver<R> extends AtomicReference<ug.b> implements h {
        private static final long serialVersionUID = 8042919737683345351L;
        volatile R item;
        final ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<?, R> parent;

        public SwitchMapMaybeObserver(ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver<?, R> observableSwitchMapMaybe$SwitchMapMaybeMainObserver) {
            this.parent = observableSwitchMapMaybe$SwitchMapMaybeMainObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // rg.h
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // rg.h
        public void onError(Throwable th2) {
            this.parent.innerError(this, th2);
        }

        @Override // rg.h
        public void onSubscribe(ug.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // rg.h
        public void onSuccess(R r) {
            this.item = r;
            this.parent.drain();
        }
    }

    public ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver(s sVar, o oVar, boolean z5) {
        this.downstream = sVar;
        this.mapper = oVar;
        this.delayErrors = z5;
    }

    @Override // ug.b
    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        disposeInner();
    }

    public void disposeInner() {
        AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
        SwitchMapMaybeObserver<Object> switchMapMaybeObserver = INNER_DISPOSED;
        SwitchMapMaybeObserver<Object> switchMapMaybeObserver2 = (SwitchMapMaybeObserver) atomicReference.getAndSet(switchMapMaybeObserver);
        if (switchMapMaybeObserver2 == null || switchMapMaybeObserver2 == switchMapMaybeObserver) {
            return;
        }
        switchMapMaybeObserver2.dispose();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        s sVar = this.downstream;
        AtomicThrowable atomicThrowable = this.errors;
        AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
        int i3 = 1;
        while (!this.cancelled) {
            if (atomicThrowable.get() != null && !this.delayErrors) {
                sVar.onError(atomicThrowable.terminate());
                return;
            }
            boolean z5 = this.done;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
            boolean z6 = switchMapMaybeObserver == null;
            if (z5 && z6) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    sVar.onError(terminate);
                    return;
                } else {
                    sVar.onComplete();
                    return;
                }
            }
            if (z6 || switchMapMaybeObserver.item == null) {
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            } else {
                while (!atomicReference.compareAndSet(switchMapMaybeObserver, null) && atomicReference.get() == switchMapMaybeObserver) {
                }
                sVar.onNext(switchMapMaybeObserver.item);
            }
        }
    }

    public void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
        AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
        while (!atomicReference.compareAndSet(switchMapMaybeObserver, null)) {
            if (atomicReference.get() != switchMapMaybeObserver) {
                return;
            }
        }
        drain();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0027, code lost:
    
        com.google.android.gms.internal.mlkit_vision_barcode.a1.b(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void innerError(io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver.SwitchMapMaybeObserver<R> r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver$SwitchMapMaybeObserver<R>> r0 = r2.inner
        L2:
            r1 = 0
            boolean r1 = r0.compareAndSet(r3, r1)
            if (r1 == 0) goto L21
            io.reactivex.internal.util.AtomicThrowable r3 = r2.errors
            boolean r3 = r3.addThrowable(r4)
            if (r3 == 0) goto L27
            boolean r3 = r2.delayErrors
            if (r3 != 0) goto L1d
            ug.b r3 = r2.upstream
            r3.dispose()
            r2.disposeInner()
        L1d:
            r2.drain()
            return
        L21:
            java.lang.Object r1 = r0.get()
            if (r1 == r3) goto L2
        L27:
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver.innerError(io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver$SwitchMapMaybeObserver, java.lang.Throwable):void");
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // rg.s
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (!this.errors.addThrowable(th2)) {
            a1.b(th2);
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
        SwitchMapMaybeObserver<R> switchMapMaybeObserver = this.inner.get();
        if (switchMapMaybeObserver != null) {
            switchMapMaybeObserver.dispose();
        }
        try {
            Object apply = this.mapper.apply(t8);
            xg.c.b(apply, "The mapper returned a null MaybeSource");
            i iVar = (i) apply;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = new SwitchMapMaybeObserver<>(this);
            while (true) {
                SwitchMapMaybeObserver<R> switchMapMaybeObserver3 = this.inner.get();
                if (switchMapMaybeObserver3 == INNER_DISPOSED) {
                    return;
                }
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
                while (!atomicReference.compareAndSet(switchMapMaybeObserver3, switchMapMaybeObserver2)) {
                    if (atomicReference.get() != switchMapMaybeObserver3) {
                        break;
                    }
                }
                ((g) iVar).b(switchMapMaybeObserver2);
                return;
            }
        } catch (Throwable th2) {
            ad.a(th2);
            this.upstream.dispose();
            this.inner.getAndSet(INNER_DISPOSED);
            onError(th2);
        }
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
