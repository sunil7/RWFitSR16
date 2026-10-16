package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
abstract class ObservableReplay$BoundedReplayBuffer<T> extends AtomicReference<ObservableReplay$Node> implements e3 {
    private static final long serialVersionUID = 2346567790059478686L;
    int size;
    ObservableReplay$Node tail;

    public ObservableReplay$BoundedReplayBuffer() {
        ObservableReplay$Node observableReplay$Node = new ObservableReplay$Node(null);
        this.tail = observableReplay$Node;
        set(observableReplay$Node);
    }

    public final void addLast(ObservableReplay$Node observableReplay$Node) {
        this.tail.set(observableReplay$Node);
        this.tail = observableReplay$Node;
        this.size++;
    }

    public final void collect(Collection<? super T> collection) {
        ObservableReplay$Node head = getHead();
        while (true) {
            head = head.get();
            if (head == null) {
                return;
            }
            Object leaveTransform = leaveTransform(head.value);
            if (NotificationLite.isComplete(leaveTransform) || NotificationLite.isError(leaveTransform)) {
                return;
            } else {
                collection.add((Object) NotificationLite.getValue(leaveTransform));
            }
        }
    }

    @Override // io.reactivex.internal.operators.observable.e3
    public final void complete() {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.complete())));
        truncateFinal();
    }

    public Object enterTransform(Object obj) {
        return obj;
    }

    @Override // io.reactivex.internal.operators.observable.e3
    public final void error(Throwable th2) {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.error(th2))));
        truncateFinal();
    }

    public ObservableReplay$Node getHead() {
        return get();
    }

    public boolean hasCompleted() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isComplete(leaveTransform(obj));
    }

    public boolean hasError() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isError(leaveTransform(obj));
    }

    public Object leaveTransform(Object obj) {
        return obj;
    }

    @Override // io.reactivex.internal.operators.observable.e3
    public final void next(T t8) {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.next(t8))));
        truncate();
    }

    public final void removeFirst() {
        this.size--;
        setFirst(get().get());
    }

    public final void removeSome(int i3) {
        ObservableReplay$Node observableReplay$Node = get();
        while (i3 > 0) {
            observableReplay$Node = observableReplay$Node.get();
            i3--;
            this.size--;
        }
        setFirst(observableReplay$Node);
    }

    @Override // io.reactivex.internal.operators.observable.e3
    public final void replay(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        if (observableReplay$InnerDisposable.getAndIncrement() != 0) {
            return;
        }
        int i3 = 1;
        do {
            ObservableReplay$Node observableReplay$Node = (ObservableReplay$Node) observableReplay$InnerDisposable.index();
            if (observableReplay$Node == null) {
                observableReplay$Node = getHead();
                observableReplay$InnerDisposable.index = observableReplay$Node;
            }
            while (!observableReplay$InnerDisposable.isDisposed()) {
                ObservableReplay$Node observableReplay$Node2 = observableReplay$Node.get();
                if (observableReplay$Node2 == null) {
                    observableReplay$InnerDisposable.index = observableReplay$Node;
                    i3 = observableReplay$InnerDisposable.addAndGet(-i3);
                } else {
                    if (NotificationLite.accept(leaveTransform(observableReplay$Node2.value), observableReplay$InnerDisposable.child)) {
                        observableReplay$InnerDisposable.index = null;
                        return;
                    }
                    observableReplay$Node = observableReplay$Node2;
                }
            }
            return;
        } while (i3 != 0);
    }

    public final void setFirst(ObservableReplay$Node observableReplay$Node) {
        set(observableReplay$Node);
    }

    public final void trimHead() {
        ObservableReplay$Node observableReplay$Node = get();
        if (observableReplay$Node.value != null) {
            ObservableReplay$Node observableReplay$Node2 = new ObservableReplay$Node(null);
            observableReplay$Node2.lazySet(observableReplay$Node.get());
            set(observableReplay$Node2);
        }
    }

    public abstract void truncate();

    public void truncateFinal() {
        trimHead();
    }
}
