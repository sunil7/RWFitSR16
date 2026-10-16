package androidx.work;

import h2.b;
import java.util.Collections;
import java.util.List;
import o2.m;

/* loaded from: classes.dex */
public final class WorkManagerInitializer implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2999a = m.i("WrkMgrInitializer");

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r2 = r7.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (p2.l.f17423k != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        p2.l.f17423k = new p2.l(r2, r1, new de.o(r1.f16692b));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        p2.l.f17422j = p2.l.f17423k;
     */
    @Override // h2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object create(android.content.Context r7) {
        /*
            r6 = this;
            o2.m r0 = o2.m.g()
            r1 = 0
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            java.lang.String r2 = androidx.work.WorkManagerInitializer.f2999a
            java.lang.String r3 = "Initializing WorkManager with default configuration."
            r0.d(r2, r3, r1)
            n9.e r0 = new n9.e
            r1 = 16
            r0.<init>(r1)
            o2.b r1 = new o2.b
            r1.<init>(r0)
            java.lang.Object r0 = p2.l.f17424l
            monitor-enter(r0)
            p2.l r2 = p2.l.f17422j     // Catch: java.lang.Throwable -> L2e
            if (r2 == 0) goto L30
            p2.l r3 = p2.l.f17423k     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L26
            goto L30
        L26:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            java.lang.String r1 = "WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information."
            r7.<init>(r1)     // Catch: java.lang.Throwable -> L2e
            throw r7     // Catch: java.lang.Throwable -> L2e
        L2e:
            r7 = move-exception
            goto L52
        L30:
            if (r2 != 0) goto L4c
            android.content.Context r2 = r7.getApplicationContext()     // Catch: java.lang.Throwable -> L2e
            p2.l r3 = p2.l.f17423k     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L48
            p2.l r3 = new p2.l     // Catch: java.lang.Throwable -> L2e
            de.o r4 = new de.o     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.ExecutorService r5 = r1.f16692b     // Catch: java.lang.Throwable -> L2e
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L2e
            r3.<init>(r2, r1, r4)     // Catch: java.lang.Throwable -> L2e
            p2.l.f17423k = r3     // Catch: java.lang.Throwable -> L2e
        L48:
            p2.l r1 = p2.l.f17423k     // Catch: java.lang.Throwable -> L2e
            p2.l.f17422j = r1     // Catch: java.lang.Throwable -> L2e
        L4c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
            p2.l r7 = p2.l.a(r7)
            return r7
        L52:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2e
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkManagerInitializer.create(android.content.Context):java.lang.Object");
    }

    @Override // h2.b
    public final List dependencies() {
        return Collections.EMPTY_LIST;
    }
}
