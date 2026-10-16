package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import yg.e;

/* loaded from: classes2.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final Integer f15046a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public SpscArrayQueue(int i3) {
        super(1 << (32 - Integer.numberOfLeadingZeros(i3 - 1)));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i3 / 4, f15046a.intValue());
    }

    public int calcElementOffset(long j4, int i3) {
        return ((int) j4) & i3;
    }

    @Override // yg.f
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // yg.f
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    public E lvElement(int i3) {
        return get(i3);
    }

    @Override // yg.f
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i3 = this.mask;
        long j4 = this.producerIndex.get();
        int calcElementOffset = calcElementOffset(j4, i3);
        if (j4 >= this.producerLookAhead) {
            long j10 = this.lookAheadStep + j4;
            if (lvElement(calcElementOffset(j10, i3)) == null) {
                this.producerLookAhead = j10;
            } else if (lvElement(calcElementOffset) != null) {
                return false;
            }
        }
        soElement(calcElementOffset, e);
        soProducerIndex(j4 + 1);
        return true;
    }

    @Override // yg.f
    public E poll() {
        long j4 = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j4);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j4 + 1);
        soElement(calcElementOffset, null);
        return lvElement;
    }

    public void soConsumerIndex(long j4) {
        this.consumerIndex.lazySet(j4);
    }

    public void soElement(int i3, E e) {
        lazySet(i3, e);
    }

    public void soProducerIndex(long j4) {
        this.producerIndex.lazySet(j4);
    }

    public int calcElementOffset(long j4) {
        return ((int) j4) & this.mask;
    }

    public boolean offer(E e, E e10) {
        return offer(e) && offer(e10);
    }
}
