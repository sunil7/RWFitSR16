package wh;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final y f19687a = new y(new byte[0], 0, 0, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f19688b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f19689c;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f19688b = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i3 = 0; i3 < highestOneBit; i3++) {
            atomicReferenceArr[i3] = new AtomicReference();
        }
        f19689c = atomicReferenceArr;
    }

    public static final void a(y segment) {
        kotlin.jvm.internal.e.f(segment, "segment");
        if (segment.f19685f != null || segment.f19686g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f19684d) {
            return;
        }
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.e.e(currentThread, "Thread.currentThread()");
        AtomicReference atomicReference = f19689c[(int) (currentThread.getId() & (f19688b - 1))];
        y yVar = (y) atomicReference.get();
        if (yVar == f19687a) {
            return;
        }
        int i3 = yVar != null ? yVar.f19683c : 0;
        if (i3 >= 65536) {
            return;
        }
        segment.f19685f = yVar;
        segment.f19682b = 0;
        segment.f19683c = i3 + 8192;
        while (!atomicReference.compareAndSet(yVar, segment)) {
            if (atomicReference.get() != yVar) {
                segment.f19685f = null;
                return;
            }
        }
    }

    public static final y b() {
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.e.e(currentThread, "Thread.currentThread()");
        AtomicReference atomicReference = f19689c[(int) (currentThread.getId() & (f19688b - 1))];
        y yVar = f19687a;
        y yVar2 = (y) atomicReference.getAndSet(yVar);
        if (yVar2 == yVar) {
            return new y();
        }
        if (yVar2 == null) {
            atomicReference.set(null);
            return new y();
        }
        atomicReference.set(yVar2.f19685f);
        yVar2.f19685f = null;
        yVar2.f19683c = 0;
        return yVar2;
    }
}
