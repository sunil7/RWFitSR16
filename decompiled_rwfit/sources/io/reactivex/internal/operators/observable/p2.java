package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class p2 implements rg.q {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f14824a;

    public p2(AtomicReference atomicReference) {
        this.f14824a = atomicReference;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0008, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // rg.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void subscribe(rg.s r8) {
        /*
            r7 = this;
            io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable r0 = new io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable
            r0.<init>(r8)
            r8.onSubscribe(r0)
        L8:
            java.util.concurrent.atomic.AtomicReference r8 = r7.f14824a
            java.lang.Object r1 = r8.get()
            io.reactivex.internal.operators.observable.o2 r1 = (io.reactivex.internal.operators.observable.o2) r1
            if (r1 == 0) goto L1b
            boolean r2 = r1.isDisposed()
            if (r2 == 0) goto L19
            goto L1b
        L19:
            r3 = r1
            goto L27
        L1b:
            io.reactivex.internal.operators.observable.o2 r2 = new io.reactivex.internal.operators.observable.o2
            r2.<init>(r8)
        L20:
            boolean r3 = r8.compareAndSet(r1, r2)
            if (r3 == 0) goto L51
            r3 = r2
        L27:
            java.util.concurrent.atomic.AtomicReference r4 = r3.f14795b
            java.lang.Object r8 = r4.get()
            r5 = r8
            io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r5 = (io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[]) r5
            io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r8 = io.reactivex.internal.operators.observable.o2.f14793f
            if (r5 != r8) goto L35
            goto L8
        L35:
            int r8 = r5.length
            int r1 = r8 + 1
            io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r6 = new io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[r1]
            r1 = 0
            java.lang.System.arraycopy(r5, r1, r6, r1, r8)
            r6[r8] = r0
        L40:
            boolean r8 = r4.compareAndSet(r5, r6)
            if (r8 == 0) goto L4a
            r0.setParent(r3)
            return
        L4a:
            java.lang.Object r8 = r4.get()
            if (r8 == r5) goto L40
            goto L27
        L51:
            java.lang.Object r3 = r8.get()
            if (r3 == r1) goto L20
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.p2.subscribe(rg.s):void");
    }
}
