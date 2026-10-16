package androidx.camera.core.impl.utils.executor;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class b implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final Executor f1507b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f1506a = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final a f1508c = new a(this);

    /* renamed from: d, reason: collision with root package name */
    public SequentialExecutor$WorkerRunningState f1509d = SequentialExecutor$WorkerRunningState.IDLE;
    public long e = 0;

    public b(Executor executor) {
        executor.getClass();
        this.f1507b = executor;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0067 A[ADDED_TO_REGION] */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void execute(java.lang.Runnable r8) {
        /*
            r7 = this;
            r8.getClass()
            java.util.ArrayDeque r0 = r7.f1506a
            monitor-enter(r0)
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r1 = r7.f1509d     // Catch: java.lang.Throwable -> L6e
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L6e
            if (r1 == r2) goto L70
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState.QUEUED     // Catch: java.lang.Throwable -> L6e
            if (r1 != r2) goto L11
            goto L70
        L11:
            long r3 = r7.e     // Catch: java.lang.Throwable -> L6e
            a8.g r1 = new a8.g     // Catch: java.lang.Throwable -> L6e
            r5 = 3
            r1.<init>(r8, r5)     // Catch: java.lang.Throwable -> L6e
            java.util.ArrayDeque r8 = r7.f1506a     // Catch: java.lang.Throwable -> L6e
            r8.add(r1)     // Catch: java.lang.Throwable -> L6e
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r8 = androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState.QUEUING     // Catch: java.lang.Throwable -> L6e
            r7.f1509d = r8     // Catch: java.lang.Throwable -> L6e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6e
            java.util.concurrent.Executor r0 = r7.f1507b     // Catch: java.lang.Error -> L45 java.lang.RuntimeException -> L47
            androidx.camera.core.impl.utils.executor.a r5 = r7.f1508c     // Catch: java.lang.Error -> L45 java.lang.RuntimeException -> L47
            r0.execute(r5)     // Catch: java.lang.Error -> L45 java.lang.RuntimeException -> L47
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = r7.f1509d
            if (r0 == r8) goto L2f
            goto L6a
        L2f:
            java.util.ArrayDeque r0 = r7.f1506a
            monitor-enter(r0)
            long r5 = r7.e     // Catch: java.lang.Throwable -> L3f
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 != 0) goto L41
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r1 = r7.f1509d     // Catch: java.lang.Throwable -> L3f
            if (r1 != r8) goto L41
            r7.f1509d = r2     // Catch: java.lang.Throwable -> L3f
            goto L41
        L3f:
            r8 = move-exception
            goto L43
        L41:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            return
        L43:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            throw r8
        L45:
            r8 = move-exception
            goto L48
        L47:
            r8 = move-exception
        L48:
            java.util.ArrayDeque r2 = r7.f1506a
            monitor-enter(r2)
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = r7.f1509d     // Catch: java.lang.Throwable -> L56
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L56
            if (r0 == r3) goto L58
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState.QUEUING     // Catch: java.lang.Throwable -> L56
            if (r0 != r3) goto L62
            goto L58
        L56:
            r8 = move-exception
            goto L6c
        L58:
            java.util.ArrayDeque r0 = r7.f1506a     // Catch: java.lang.Throwable -> L56
            boolean r0 = r0.removeLastOccurrence(r1)     // Catch: java.lang.Throwable -> L56
            if (r0 == 0) goto L62
            r0 = 1
            goto L63
        L62:
            r0 = 0
        L63:
            boolean r1 = r8 instanceof java.util.concurrent.RejectedExecutionException     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L6b
            if (r0 != 0) goto L6b
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L56
        L6a:
            return
        L6b:
            throw r8     // Catch: java.lang.Throwable -> L56
        L6c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L56
            throw r8
        L6e:
            r8 = move-exception
            goto L77
        L70:
            java.util.ArrayDeque r1 = r7.f1506a     // Catch: java.lang.Throwable -> L6e
            r1.add(r8)     // Catch: java.lang.Throwable -> L6e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6e
            return
        L77:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6e
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.executor.b.execute(java.lang.Runnable):void");
    }
}
