package androidx.camera.core.impl.utils.executor;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1505a;

    public a(b bVar) {
        this.f1505a = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
    
        r3.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        com.google.android.gms.internal.mlkit_vision_common.a0.c("SequentialExecutor", "Exception while executing runnable " + r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if (r1 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r9 = this;
            r0 = 0
            r1 = r0
        L2:
            androidx.camera.core.impl.utils.executor.b r2 = r9.f1505a     // Catch: java.lang.Throwable -> L49
            java.util.ArrayDeque r2 = r2.f1506a     // Catch: java.lang.Throwable -> L49
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L49
            if (r0 != 0) goto L28
            androidx.camera.core.impl.utils.executor.b r0 = r9.f1505a     // Catch: java.lang.Throwable -> L1c
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = r0.f1509d     // Catch: java.lang.Throwable -> L1c
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r4 = androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L1c
            if (r3 != r4) goto L1e
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L3e
        L14:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L3e
        L1c:
            r0 = move-exception
            goto L63
        L1e:
            long r5 = r0.e     // Catch: java.lang.Throwable -> L1c
            r7 = 1
            long r5 = r5 + r7
            r0.e = r5     // Catch: java.lang.Throwable -> L1c
            r0.f1509d = r4     // Catch: java.lang.Throwable -> L1c
            r0 = 1
        L28:
            androidx.camera.core.impl.utils.executor.b r3 = r9.f1505a     // Catch: java.lang.Throwable -> L1c
            java.util.ArrayDeque r3 = r3.f1506a     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L1c
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L1c
            if (r3 != 0) goto L3f
            androidx.camera.core.impl.utils.executor.b r0 = r9.f1505a     // Catch: java.lang.Throwable -> L1c
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L1c
            r0.f1509d = r3     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L3e
            goto L14
        L3e:
            return
        L3f:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L49
            r1 = r1 | r2
            r3.run()     // Catch: java.lang.Throwable -> L49 java.lang.RuntimeException -> L4b
            goto L2
        L49:
            r0 = move-exception
            goto L65
        L4b:
            r2 = move-exception
            java.lang.String r4 = "SequentialExecutor"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r5.<init>()     // Catch: java.lang.Throwable -> L49
            java.lang.String r6 = "Exception while executing runnable "
            r5.append(r6)     // Catch: java.lang.Throwable -> L49
            r5.append(r3)     // Catch: java.lang.Throwable -> L49
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L49
            com.google.android.gms.internal.mlkit_vision_common.a0.c(r4, r3, r2)     // Catch: java.lang.Throwable -> L49
            goto L2
        L63:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            throw r0     // Catch: java.lang.Throwable -> L49
        L65:
            if (r1 == 0) goto L6e
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L6e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.executor.a.a():void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Error e) {
            synchronized (this.f1505a.f1506a) {
                this.f1505a.f1509d = SequentialExecutor$WorkerRunningState.IDLE;
                throw e;
            }
        }
    }
}
