package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class g3 implements rg.q {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f14654a;

    /* renamed from: b, reason: collision with root package name */
    public final c3 f14655b;

    public g3(AtomicReference atomicReference, c3 c3Var) {
        this.f14654a = atomicReference;
        this.f14655b = c3Var;
    }

    @Override // rg.q
    public final void subscribe(rg.s sVar) {
        ObservableReplay$ReplayObserver observableReplay$ReplayObserver;
        loop0: while (true) {
            AtomicReference atomicReference = this.f14654a;
            observableReplay$ReplayObserver = (ObservableReplay$ReplayObserver) atomicReference.get();
            if (observableReplay$ReplayObserver != null) {
                break;
            }
            ObservableReplay$ReplayObserver observableReplay$ReplayObserver2 = new ObservableReplay$ReplayObserver(this.f14655b.call());
            while (!atomicReference.compareAndSet(null, observableReplay$ReplayObserver2)) {
                if (atomicReference.get() != null) {
                    break;
                }
            }
            observableReplay$ReplayObserver = observableReplay$ReplayObserver2;
            break loop0;
        }
        ObservableReplay$InnerDisposable observableReplay$InnerDisposable = new ObservableReplay$InnerDisposable(observableReplay$ReplayObserver, sVar);
        sVar.onSubscribe(observableReplay$InnerDisposable);
        observableReplay$ReplayObserver.add(observableReplay$InnerDisposable);
        if (observableReplay$InnerDisposable.isDisposed()) {
            observableReplay$ReplayObserver.remove(observableReplay$InnerDisposable);
        } else {
            observableReplay$ReplayObserver.buffer.replay(observableReplay$InnerDisposable);
        }
    }
}
