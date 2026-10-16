package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;
import yg.e;

/* loaded from: classes2.dex */
public final class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f15047a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f15048b;

    public a() {
        AtomicReference atomicReference = new AtomicReference();
        this.f15047a = atomicReference;
        AtomicReference atomicReference2 = new AtomicReference();
        this.f15048b = atomicReference2;
        MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode = new MpscLinkedQueue$LinkedQueueNode();
        atomicReference2.lazySet(mpscLinkedQueue$LinkedQueueNode);
    }

    @Override // yg.f
    public final void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // yg.f
    public final boolean isEmpty() {
        return ((MpscLinkedQueue$LinkedQueueNode) this.f15048b.get()) == ((MpscLinkedQueue$LinkedQueueNode) this.f15047a.get());
    }

    @Override // yg.f
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode = new MpscLinkedQueue$LinkedQueueNode(obj);
        ((MpscLinkedQueue$LinkedQueueNode) this.f15047a.getAndSet(mpscLinkedQueue$LinkedQueueNode)).soNext(mpscLinkedQueue$LinkedQueueNode);
        return true;
    }

    @Override // yg.f
    public final Object poll() {
        MpscLinkedQueue$LinkedQueueNode lvNext;
        AtomicReference atomicReference = this.f15048b;
        MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode = (MpscLinkedQueue$LinkedQueueNode) atomicReference.get();
        MpscLinkedQueue$LinkedQueueNode lvNext2 = mpscLinkedQueue$LinkedQueueNode.lvNext();
        if (lvNext2 != null) {
            Object andNullValue = lvNext2.getAndNullValue();
            atomicReference.lazySet(lvNext2);
            return andNullValue;
        }
        if (mpscLinkedQueue$LinkedQueueNode == ((MpscLinkedQueue$LinkedQueueNode) this.f15047a.get())) {
            return null;
        }
        do {
            lvNext = mpscLinkedQueue$LinkedQueueNode.lvNext();
        } while (lvNext == null);
        Object andNullValue2 = lvNext.getAndNullValue();
        atomicReference.lazySet(lvNext);
        return andNullValue2;
    }
}
