package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class MpscLinkedQueue$LinkedQueueNode<E> extends AtomicReference<MpscLinkedQueue$LinkedQueueNode<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    public MpscLinkedQueue$LinkedQueueNode() {
    }

    public E getAndNullValue() {
        E lpValue = lpValue();
        spValue(null);
        return lpValue;
    }

    public E lpValue() {
        return this.value;
    }

    public MpscLinkedQueue$LinkedQueueNode<E> lvNext() {
        return get();
    }

    public void soNext(MpscLinkedQueue$LinkedQueueNode<E> mpscLinkedQueue$LinkedQueueNode) {
        lazySet(mpscLinkedQueue$LinkedQueueNode);
    }

    public void spValue(E e) {
        this.value = e;
    }

    public MpscLinkedQueue$LinkedQueueNode(E e) {
        spValue(e);
    }
}
