package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;

/* loaded from: classes2.dex */
final class ObservableReplay$UnboundedReplayBuffer<T> extends ArrayList<Object> implements e3 {
    private static final long serialVersionUID = 7063189396499112664L;
    volatile int size;

    public ObservableReplay$UnboundedReplayBuffer(int i3) {
        super(i3);
    }

    @Override // io.reactivex.internal.operators.observable.e3
    public void complete() {
        add(NotificationLite.complete());
        this.size++;
    }

    @Override // io.reactivex.internal.operators.observable.e3
    public void error(Throwable th2) {
        add(NotificationLite.error(th2));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.observable.e3
    public void next(T t8) {
        add(NotificationLite.next(t8));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.observable.e3
    public void replay(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        if (observableReplay$InnerDisposable.getAndIncrement() != 0) {
            return;
        }
        rg.s sVar = observableReplay$InnerDisposable.child;
        int i3 = 1;
        while (!observableReplay$InnerDisposable.isDisposed()) {
            int i10 = this.size;
            Integer num = (Integer) observableReplay$InnerDisposable.index();
            int intValue = num != null ? num.intValue() : 0;
            while (intValue < i10) {
                if (NotificationLite.accept(get(intValue), sVar) || observableReplay$InnerDisposable.isDisposed()) {
                    return;
                } else {
                    intValue++;
                }
            }
            observableReplay$InnerDisposable.index = Integer.valueOf(intValue);
            i3 = observableReplay$InnerDisposable.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }
}
