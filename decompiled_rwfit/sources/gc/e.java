package gc;

import android.content.Context;
import q9.n;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f14028b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static e f14029c;

    /* renamed from: a, reason: collision with root package name */
    public pb.f f14030a;

    public static e c() {
        e eVar;
        synchronized (f14028b) {
            n.g("MlKitContext has not been initialized", f14029c != null);
            eVar = f14029c;
            n.e(eVar);
        }
        return eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        monitor-enter(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        r1 = new java.util.HashMap(r8.f17507b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        monitor-exit(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        r8.f(r1, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static gc.e d(android.content.Context r8) {
        /*
            java.lang.Object r0 = gc.e.f14028b
            monitor-enter(r0)
            gc.e r1 = gc.e.f14029c     // Catch: java.lang.Throwable -> L7c
            r2 = 1
            r3 = 0
            if (r1 != 0) goto Lb
            r1 = r2
            goto Lc
        Lb:
            r1 = r3
        Lc:
            java.lang.String r4 = "MlKitContext is already initialized"
            q9.n.g(r4, r1)     // Catch: java.lang.Throwable -> L7c
            gc.e r1 = new gc.e     // Catch: java.lang.Throwable -> L7c
            r1.<init>()     // Catch: java.lang.Throwable -> L7c
            gc.e.f14029c = r1     // Catch: java.lang.Throwable -> L7c
            android.content.Context r4 = r8.getApplicationContext()     // Catch: java.lang.Throwable -> L7c
            if (r4 == 0) goto L1f
            r8 = r4
        L1f:
            aa.b r4 = new aa.b     // Catch: java.lang.Throwable -> L7c
            pb.m r5 = new pb.m     // Catch: java.lang.Throwable -> L7c
            r5.<init>()     // Catch: java.lang.Throwable -> L7c
            r4.<init>(r8, r5)     // Catch: java.lang.Throwable -> L7c
            java.util.ArrayList r4 = r4.a()     // Catch: java.lang.Throwable -> L7c
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L7c
            r5.<init>()     // Catch: java.lang.Throwable -> L7c
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L7c
            r6.<init>()     // Catch: java.lang.Throwable -> L7c
            r5.addAll(r4)     // Catch: java.lang.Throwable -> L7c
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L7c
            pb.a r8 = pb.a.b(r8, r4, r7)     // Catch: java.lang.Throwable -> L7c
            r6.add(r8)     // Catch: java.lang.Throwable -> L7c
            java.lang.Class<gc.e> r8 = gc.e.class
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L7c
            pb.a r8 = pb.a.b(r1, r8, r3)     // Catch: java.lang.Throwable -> L7c
            r6.add(r8)     // Catch: java.lang.Throwable -> L7c
            pb.f r8 = new pb.f     // Catch: java.lang.Throwable -> L7c
            r8.<init>(r5, r6)     // Catch: java.lang.Throwable -> L7c
            r1.f14030a = r8     // Catch: java.lang.Throwable -> L7c
            java.util.concurrent.atomic.AtomicReference r1 = r8.f17510f     // Catch: java.lang.Throwable -> L7c
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L7c
        L5b:
            r4 = 0
            boolean r4 = r1.compareAndSet(r4, r3)     // Catch: java.lang.Throwable -> L7c
            if (r4 == 0) goto L72
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L7c
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L6f
            java.util.HashMap r3 = r8.f17507b     // Catch: java.lang.Throwable -> L6f
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L6f
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L6f
            r8.f(r1, r2)     // Catch: java.lang.Throwable -> L7c
            goto L78
        L6f:
            r1 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L6f
            throw r1     // Catch: java.lang.Throwable -> L7c
        L72:
            java.lang.Object r4 = r1.get()     // Catch: java.lang.Throwable -> L7c
            if (r4 == 0) goto L5b
        L78:
            gc.e r8 = gc.e.f14029c     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
            return r8
        L7c:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: gc.e.d(android.content.Context):gc.e");
    }

    public final Object a(Class cls) {
        n.g("MlKitContext has been deleted", f14029c == this);
        n.e(this.f14030a);
        return this.f14030a.a(cls);
    }

    public final Context b() {
        return (Context) a(Context.class);
    }
}
