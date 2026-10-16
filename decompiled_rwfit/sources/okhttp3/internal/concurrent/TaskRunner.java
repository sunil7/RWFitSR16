package okhttp3.internal.concurrent;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.h;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class TaskRunner {
    public static final Companion Companion = new Companion(null);
    public static final TaskRunner INSTANCE = new TaskRunner(new RealBackend(Util.threadFactory(Util.okHttpName + " TaskRunner", true)));
    private static final Logger logger;
    private final Backend backend;
    private final List<TaskQueue> busyQueues;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    private int nextQueueName;
    private final List<TaskQueue> readyQueues;
    private final Runnable runnable;

    public interface Backend {
        void beforeTask(TaskRunner taskRunner);

        void coordinatorNotify(TaskRunner taskRunner);

        void coordinatorWait(TaskRunner taskRunner, long j4);

        void execute(Runnable runnable);

        long nanoTime();
    }

    public static final class Companion {
        private Companion() {
        }

        public final Logger getLogger() {
            return TaskRunner.logger;
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public static final class RealBackend implements Backend {
        private final ThreadPoolExecutor executor;

        public RealBackend(ThreadFactory threadFactory) {
            e.f(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, SubsamplingScaleImageView.TILE_SIZE_AUTO, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void beforeTask(TaskRunner taskRunner) {
            e.f(taskRunner, "taskRunner");
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorNotify(TaskRunner taskRunner) {
            e.f(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void coordinatorWait(TaskRunner taskRunner, long j4) throws InterruptedException {
            e.f(taskRunner, "taskRunner");
            long j10 = j4 / 1000000;
            long j11 = j4 - (1000000 * j10);
            if (j10 > 0 || j4 > 0) {
                taskRunner.wait(j10, (int) j11);
            }
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public void execute(Runnable runnable) {
            e.f(runnable, "runnable");
            this.executor.execute(runnable);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public long nanoTime() {
            return System.nanoTime();
        }

        public final void shutdown() {
            this.executor.shutdown();
        }
    }

    static {
        Logger logger2 = Logger.getLogger(TaskRunner.class.getName());
        e.e(logger2, "Logger.getLogger(TaskRunner::class.java.name)");
        logger = logger2;
    }

    public TaskRunner(Backend backend) {
        e.f(backend, "backend");
        this.backend = backend;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new Runnable() { // from class: okhttp3.internal.concurrent.TaskRunner$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                Task awaitTaskToRun;
                long j4;
                while (true) {
                    synchronized (TaskRunner.this) {
                        awaitTaskToRun = TaskRunner.this.awaitTaskToRun();
                    }
                    if (awaitTaskToRun == null) {
                        return;
                    }
                    TaskQueue queue$okhttp = awaitTaskToRun.getQueue$okhttp();
                    e.c(queue$okhttp);
                    boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
                    if (isLoggable) {
                        j4 = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime();
                        TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, "starting");
                    } else {
                        j4 = -1;
                    }
                    try {
                        TaskRunner.this.runTask(awaitTaskToRun);
                        if (isLoggable) {
                            TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, "finished run in " + TaskLoggerKt.formatDuration(queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j4));
                        }
                    } finally {
                    }
                }
            }
        };
    }

    private final void afterRun(Task task, long j4) {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        TaskQueue queue$okhttp = task.getQueue$okhttp();
        e.c(queue$okhttp);
        if (!(queue$okhttp.getActiveTask$okhttp() == task)) {
            throw new IllegalStateException("Check failed.");
        }
        boolean cancelActiveTask$okhttp = queue$okhttp.getCancelActiveTask$okhttp();
        queue$okhttp.setCancelActiveTask$okhttp(false);
        queue$okhttp.setActiveTask$okhttp(null);
        this.busyQueues.remove(queue$okhttp);
        if (j4 != -1 && !cancelActiveTask$okhttp && !queue$okhttp.getShutdown$okhttp()) {
            queue$okhttp.scheduleAndDecide$okhttp(task, j4, true);
        }
        if (queue$okhttp.getFutureTasks$okhttp().isEmpty()) {
            return;
        }
        this.readyQueues.add(queue$okhttp);
    }

    private final void beforeRun(Task task) {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        task.setNextExecuteNanoTime$okhttp(-1L);
        TaskQueue queue$okhttp = task.getQueue$okhttp();
        e.c(queue$okhttp);
        queue$okhttp.getFutureTasks$okhttp().remove(task);
        this.readyQueues.remove(queue$okhttp);
        queue$okhttp.setActiveTask$okhttp(task);
        this.busyQueues.add(queue$okhttp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runTask(Task task) {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        Thread currentThread2 = Thread.currentThread();
        e.e(currentThread2, "currentThread");
        String name = currentThread2.getName();
        currentThread2.setName(task.getName());
        try {
            long runOnce = task.runOnce();
            synchronized (this) {
                afterRun(task, runOnce);
            }
            currentThread2.setName(name);
        } catch (Throwable th2) {
            synchronized (this) {
                afterRun(task, -1L);
                currentThread2.setName(name);
                throw th2;
            }
        }
    }

    public final List<TaskQueue> activeQueues() {
        ArrayList s7;
        synchronized (this) {
            s7 = h.s(this.busyQueues, this.readyQueues);
        }
        return s7;
    }

    public final Task awaitTaskToRun() {
        boolean z5;
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        while (!this.readyQueues.isEmpty()) {
            long nanoTime = this.backend.nanoTime();
            Iterator<TaskQueue> it = this.readyQueues.iterator();
            long j4 = Format.OFFSET_SAMPLE_RELATIVE;
            Task task = null;
            while (true) {
                if (!it.hasNext()) {
                    z5 = false;
                    break;
                }
                Task task2 = it.next().getFutureTasks$okhttp().get(0);
                long max = Math.max(0L, task2.getNextExecuteNanoTime$okhttp() - nanoTime);
                if (max > 0) {
                    j4 = Math.min(max, j4);
                } else {
                    if (task != null) {
                        z5 = true;
                        break;
                    }
                    task = task2;
                }
            }
            if (task != null) {
                beforeRun(task);
                if (z5 || (!this.coordinatorWaiting && !this.readyQueues.isEmpty())) {
                    this.backend.execute(this.runnable);
                }
                return task;
            }
            if (this.coordinatorWaiting) {
                if (j4 < this.coordinatorWakeUpAt - nanoTime) {
                    this.backend.coordinatorNotify(this);
                }
                return null;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = nanoTime + j4;
            try {
                try {
                    this.backend.coordinatorWait(this, j4);
                } catch (InterruptedException unused) {
                    cancelAll();
                }
            } finally {
                this.coordinatorWaiting = false;
            }
        }
        return null;
    }

    public final void cancelAll() {
        for (int size = this.busyQueues.size() - 1; size >= 0; size--) {
            this.busyQueues.get(size).cancelAllAndDecide$okhttp();
        }
        for (int size2 = this.readyQueues.size() - 1; size2 >= 0; size2--) {
            TaskQueue taskQueue = this.readyQueues.get(size2);
            taskQueue.cancelAllAndDecide$okhttp();
            if (taskQueue.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.remove(size2);
            }
        }
    }

    public final Backend getBackend() {
        return this.backend;
    }

    public final void kickCoordinator$okhttp(TaskQueue taskQueue) {
        e.f(taskQueue, "taskQueue");
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder("Thread ");
            Thread currentThread = Thread.currentThread();
            e.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        if (taskQueue.getActiveTask$okhttp() == null) {
            if (taskQueue.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.remove(taskQueue);
            } else {
                Util.addIfAbsent(this.readyQueues, taskQueue);
            }
        }
        if (this.coordinatorWaiting) {
            this.backend.coordinatorNotify(this);
        } else {
            this.backend.execute(this.runnable);
        }
    }

    public final TaskQueue newQueue() {
        int i3;
        synchronized (this) {
            i3 = this.nextQueueName;
            this.nextQueueName = i3 + 1;
        }
        return new TaskQueue(this, l0.j(i3, "Q"));
    }
}
