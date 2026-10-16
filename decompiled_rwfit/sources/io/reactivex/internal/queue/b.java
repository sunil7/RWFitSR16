package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import yg.e;

/* loaded from: classes2.dex */
public final class b implements e {

    /* renamed from: i, reason: collision with root package name */
    public static final int f15049i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j, reason: collision with root package name */
    public static final Object f15050j = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f15051a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15052b;

    /* renamed from: c, reason: collision with root package name */
    public long f15053c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15054d;
    public AtomicReferenceArray e;

    /* renamed from: f, reason: collision with root package name */
    public final int f15055f;

    /* renamed from: g, reason: collision with root package name */
    public AtomicReferenceArray f15056g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicLong f15057h;

    public b(int i3) {
        AtomicLong atomicLong = new AtomicLong();
        this.f15051a = atomicLong;
        this.f15057h = new AtomicLong();
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, i3) - 1));
        int i10 = numberOfLeadingZeros - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(numberOfLeadingZeros + 1);
        this.e = atomicReferenceArray;
        this.f15054d = i10;
        this.f15052b = Math.min(numberOfLeadingZeros / 4, f15049i);
        this.f15056g = atomicReferenceArray;
        this.f15055f = i10;
        this.f15053c = numberOfLeadingZeros - 2;
        atomicLong.lazySet(0L);
    }

    public final boolean a(Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.e;
        AtomicLong atomicLong = this.f15051a;
        long j4 = atomicLong.get();
        long j10 = 2 + j4;
        int i3 = this.f15054d;
        if (atomicReferenceArray.get(((int) j10) & i3) == null) {
            int i10 = ((int) j4) & i3;
            atomicReferenceArray.lazySet(i10 + 1, obj2);
            atomicReferenceArray.lazySet(i10, obj);
            atomicLong.lazySet(j10);
        } else {
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.e = atomicReferenceArray2;
            int i11 = ((int) j4) & i3;
            atomicReferenceArray2.lazySet(i11 + 1, obj2);
            atomicReferenceArray2.lazySet(i11, obj);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i11, f15050j);
            atomicLong.lazySet(j10);
        }
        return true;
    }

    public final Object b() {
        AtomicReferenceArray atomicReferenceArray = this.f15056g;
        int i3 = (int) this.f15057h.get();
        int i10 = this.f15055f;
        int i11 = i3 & i10;
        Object obj = atomicReferenceArray.get(i11);
        if (obj != f15050j) {
            return obj;
        }
        int i12 = i10 + 1;
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i12);
        atomicReferenceArray.lazySet(i12, null);
        this.f15056g = atomicReferenceArray2;
        return atomicReferenceArray2.get(i11);
    }

    @Override // yg.f
    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // yg.f
    public final boolean isEmpty() {
        return this.f15051a.get() == this.f15057h.get();
    }

    @Override // yg.f
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.e;
        AtomicLong atomicLong = this.f15051a;
        long j4 = atomicLong.get();
        int i3 = this.f15054d;
        int i10 = ((int) j4) & i3;
        if (j4 < this.f15053c) {
            atomicReferenceArray.lazySet(i10, obj);
            atomicLong.lazySet(j4 + 1);
            return true;
        }
        long j10 = this.f15052b + j4;
        if (atomicReferenceArray.get(((int) j10) & i3) == null) {
            this.f15053c = j10 - 1;
            atomicReferenceArray.lazySet(i10, obj);
            atomicLong.lazySet(j4 + 1);
            return true;
        }
        long j11 = j4 + 1;
        if (atomicReferenceArray.get(((int) j11) & i3) == null) {
            atomicReferenceArray.lazySet(i10, obj);
            atomicLong.lazySet(j11);
            return true;
        }
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        this.f15053c = (j4 + i3) - 1;
        atomicReferenceArray2.lazySet(i10, obj);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i10, f15050j);
        atomicLong.lazySet(j11);
        return true;
    }

    @Override // yg.f
    public final Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.f15056g;
        AtomicLong atomicLong = this.f15057h;
        long j4 = atomicLong.get();
        int i3 = this.f15055f;
        int i10 = ((int) j4) & i3;
        Object obj = atomicReferenceArray.get(i10);
        boolean z5 = obj == f15050j;
        if (obj != null && !z5) {
            atomicReferenceArray.lazySet(i10, null);
            atomicLong.lazySet(j4 + 1);
            return obj;
        }
        if (!z5) {
            return null;
        }
        int i11 = i3 + 1;
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i11);
        atomicReferenceArray.lazySet(i11, null);
        this.f15056g = atomicReferenceArray2;
        Object obj2 = atomicReferenceArray2.get(i10);
        if (obj2 != null) {
            atomicReferenceArray2.lazySet(i10, null);
            atomicLong.lazySet(j4 + 1);
        }
        return obj2;
    }
}
