package androidx.concurrent.futures;

import n0.h;
import n0.i;
import n0.j;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public Object f1605a;

    /* renamed from: b, reason: collision with root package name */
    public i f1606b;

    /* renamed from: c, reason: collision with root package name */
    public j f1607c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1608d;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            r4.f1608d = r0
            n0.i r1 = r4.f1606b
            r2 = 0
            if (r1 == 0) goto L1d
            n0.h r1 = r1.f16358b
            r1.getClass()
            if (r5 != 0) goto L11
            java.lang.Object r5 = n0.f.f16352g
        L11:
            com.google.android.gms.internal.mlkit_vision_barcode.ue r3 = n0.f.f16351f
            boolean r5 = r3.b(r1, r2, r5)
            if (r5 == 0) goto L1d
            n0.f.c(r1)
            goto L1e
        L1d:
            r0 = 0
        L1e:
            if (r0 == 0) goto L26
            r4.f1605a = r2
            r4.f1606b = r2
            r4.f1607c = r2
        L26:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.b.a(java.lang.Object):boolean");
    }

    public final boolean b(Throwable th2) {
        this.f1608d = true;
        i iVar = this.f1606b;
        boolean z5 = iVar != null && iVar.f16358b.i(th2);
        if (z5) {
            this.f1605a = null;
            this.f1606b = null;
            this.f1607c = null;
        }
        return z5;
    }

    public final void finalize() {
        j jVar;
        i iVar = this.f1606b;
        if (iVar != null) {
            h hVar = iVar.f16358b;
            if (!hVar.isDone()) {
                final String str = "The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f1605a;
                hVar.i(new Throwable(str) { // from class: androidx.concurrent.futures.CallbackToFutureAdapter$FutureGarbageCollectedException
                    @Override // java.lang.Throwable
                    public synchronized Throwable fillInStackTrace() {
                        return this;
                    }
                });
            }
        }
        if (this.f1608d || (jVar = this.f1607c) == null) {
            return;
        }
        jVar.j(null);
    }
}
