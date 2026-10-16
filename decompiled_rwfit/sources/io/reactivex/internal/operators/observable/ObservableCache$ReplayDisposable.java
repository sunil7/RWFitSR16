package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class ObservableCache$ReplayDisposable<T> extends AtomicInteger implements ug.b {
    private static final long serialVersionUID = 7058506693698832024L;
    volatile boolean cancelled;
    final rg.s child;
    Object[] currentBuffer;
    int currentIndexInBuffer;
    int index;
    final a0 state;

    public ObservableCache$ReplayDisposable(rg.s sVar, a0 a0Var) {
        this.child = sVar;
        this.state = a0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ug.b
    public void dispose() {
        ObservableCache$ReplayDisposable[] observableCache$ReplayDisposableArr;
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        a0 a0Var = this.state;
        while (true) {
            AtomicReference atomicReference = a0Var.f14555h;
            ObservableCache$ReplayDisposable[] observableCache$ReplayDisposableArr2 = (ObservableCache$ReplayDisposable[]) atomicReference.get();
            int length = observableCache$ReplayDisposableArr2.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (observableCache$ReplayDisposableArr2[i3].equals(this)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                observableCache$ReplayDisposableArr = a0.f14547j;
            } else {
                ObservableCache$ReplayDisposable[] observableCache$ReplayDisposableArr3 = new ObservableCache$ReplayDisposable[length - 1];
                System.arraycopy(observableCache$ReplayDisposableArr2, 0, observableCache$ReplayDisposableArr3, 0, i3);
                System.arraycopy(observableCache$ReplayDisposableArr2, i3 + 1, observableCache$ReplayDisposableArr3, i3, (length - i3) - 1);
                observableCache$ReplayDisposableArr = observableCache$ReplayDisposableArr3;
            }
            while (!atomicReference.compareAndSet(observableCache$ReplayDisposableArr2, observableCache$ReplayDisposableArr)) {
                if (atomicReference.get() != observableCache$ReplayDisposableArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // ug.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    public void replay() {
        if (getAndIncrement() != 0) {
            return;
        }
        rg.s sVar = this.child;
        int i3 = 1;
        while (!this.cancelled) {
            int i10 = this.state.f14552d;
            if (i10 != 0) {
                Object[] objArr = this.currentBuffer;
                if (objArr == null) {
                    objArr = this.state.f14550b;
                    this.currentBuffer = objArr;
                }
                int length = objArr.length - 1;
                int i11 = this.index;
                int i12 = this.currentIndexInBuffer;
                while (i11 < i10) {
                    if (this.cancelled) {
                        return;
                    }
                    if (i12 == length) {
                        objArr = (Object[]) objArr[length];
                        i12 = 0;
                    }
                    if (NotificationLite.accept(objArr[i12], sVar)) {
                        return;
                    }
                    i12++;
                    i11++;
                }
                if (this.cancelled) {
                    return;
                }
                this.index = i11;
                this.currentIndexInBuffer = i12;
                this.currentBuffer = objArr;
            }
            i3 = addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }
}
