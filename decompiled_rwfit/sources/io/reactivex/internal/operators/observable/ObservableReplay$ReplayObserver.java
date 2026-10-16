package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableReplay$ReplayObserver<T> extends AtomicReference<ug.b> implements rg.s, ug.b {
    static final ObservableReplay$InnerDisposable[] EMPTY = new ObservableReplay$InnerDisposable[0];
    static final ObservableReplay$InnerDisposable[] TERMINATED = new ObservableReplay$InnerDisposable[0];
    private static final long serialVersionUID = -533785617179540163L;
    final e3 buffer;
    boolean done;
    final AtomicReference<ObservableReplay$InnerDisposable[]> observers = new AtomicReference<>(EMPTY);
    final AtomicBoolean shouldConnect = new AtomicBoolean();

    public ObservableReplay$ReplayObserver(e3 e3Var) {
        this.buffer = e3Var;
    }

    public boolean add(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        while (true) {
            ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr = this.observers.get();
            if (observableReplay$InnerDisposableArr == TERMINATED) {
                return false;
            }
            int length = observableReplay$InnerDisposableArr.length;
            ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr2 = new ObservableReplay$InnerDisposable[length + 1];
            System.arraycopy(observableReplay$InnerDisposableArr, 0, observableReplay$InnerDisposableArr2, 0, length);
            observableReplay$InnerDisposableArr2[length] = observableReplay$InnerDisposable;
            AtomicReference<ObservableReplay$InnerDisposable[]> atomicReference = this.observers;
            while (!atomicReference.compareAndSet(observableReplay$InnerDisposableArr, observableReplay$InnerDisposableArr2)) {
                if (atomicReference.get() != observableReplay$InnerDisposableArr) {
                    break;
                }
            }
            return true;
        }
    }

    @Override // ug.b
    public void dispose() {
        this.observers.set(TERMINATED);
        DisposableHelper.dispose(this);
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.observers.get() == TERMINATED;
    }

    @Override // rg.s
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.buffer.complete();
        replayFinal();
    }

    @Override // rg.s
    public void onError(Throwable th2) {
        if (this.done) {
            com.google.android.gms.internal.mlkit_vision_barcode.a1.b(th2);
            return;
        }
        this.done = true;
        this.buffer.error(th2);
        replayFinal();
    }

    @Override // rg.s
    public void onNext(T t8) {
        if (this.done) {
            return;
        }
        this.buffer.next(t8);
        replay();
    }

    @Override // rg.s
    public void onSubscribe(ug.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            replay();
        }
    }

    public void remove(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr;
        while (true) {
            ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr2 = this.observers.get();
            int length = observableReplay$InnerDisposableArr2.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (observableReplay$InnerDisposableArr2[i3].equals(observableReplay$InnerDisposable)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                observableReplay$InnerDisposableArr = EMPTY;
            } else {
                ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArr3 = new ObservableReplay$InnerDisposable[length - 1];
                System.arraycopy(observableReplay$InnerDisposableArr2, 0, observableReplay$InnerDisposableArr3, 0, i3);
                System.arraycopy(observableReplay$InnerDisposableArr2, i3 + 1, observableReplay$InnerDisposableArr3, i3, (length - i3) - 1);
                observableReplay$InnerDisposableArr = observableReplay$InnerDisposableArr3;
            }
            AtomicReference<ObservableReplay$InnerDisposable[]> atomicReference = this.observers;
            while (!atomicReference.compareAndSet(observableReplay$InnerDisposableArr2, observableReplay$InnerDisposableArr)) {
                if (atomicReference.get() != observableReplay$InnerDisposableArr2) {
                    break;
                }
            }
            return;
        }
    }

    public void replay() {
        for (ObservableReplay$InnerDisposable observableReplay$InnerDisposable : this.observers.get()) {
            this.buffer.replay(observableReplay$InnerDisposable);
        }
    }

    public void replayFinal() {
        for (ObservableReplay$InnerDisposable observableReplay$InnerDisposable : this.observers.getAndSet(TERMINATED)) {
            this.buffer.replay(observableReplay$InnerDisposable);
        }
    }
}
