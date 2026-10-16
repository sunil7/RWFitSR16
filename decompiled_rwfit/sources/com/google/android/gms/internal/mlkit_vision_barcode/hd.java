package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class hd {
    public static boolean a(boolean z5, boolean z6, ah.c cVar, yg.e eVar, ug.b bVar, io.reactivex.internal.observers.h hVar) {
        if (hVar.f14472d) {
            eVar.clear();
            bVar.dispose();
            return true;
        }
        if (!z5) {
            return false;
        }
        Throwable th2 = hVar.f14473f;
        if (th2 != null) {
            eVar.clear();
            if (bVar != null) {
                bVar.dispose();
            }
            cVar.onError(th2);
            return true;
        }
        if (!z6) {
            return false;
        }
        if (bVar != null) {
            bVar.dispose();
        }
        cVar.onComplete();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        r1 = r7.f14469a.addAndGet(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (r1 != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(io.reactivex.internal.queue.a r8, ah.c r9, ug.b r10, io.reactivex.internal.observers.h r11) {
        /*
            r0 = 1
            r1 = r0
        L2:
            boolean r2 = r11.e
            boolean r3 = r8.isEmpty()
            r5 = r8
            r4 = r9
            r6 = r10
            r7 = r11
            boolean r8 = a(r2, r3, r4, r5, r6, r7)
            if (r8 == 0) goto L13
            goto L32
        L13:
            boolean r2 = r7.e
            java.lang.Object r8 = r5.poll()
            if (r8 != 0) goto L1d
            r3 = r0
            goto L1f
        L1d:
            r9 = 0
            r3 = r9
        L1f:
            boolean r9 = a(r2, r3, r4, r5, r6, r7)
            r10 = r3
            if (r9 == 0) goto L27
            goto L32
        L27:
            if (r10 == 0) goto L38
            int r8 = -r1
            java.util.concurrent.atomic.AtomicInteger r9 = r7.f14469a
            int r1 = r9.addAndGet(r8)
            if (r1 != 0) goto L33
        L32:
            return
        L33:
            r9 = r4
            r8 = r5
            r10 = r6
            r11 = r7
            goto L2
        L38:
            r7.a(r4, r8)
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.hd.b(io.reactivex.internal.queue.a, ah.c, ug.b, io.reactivex.internal.observers.h):void");
    }
}
