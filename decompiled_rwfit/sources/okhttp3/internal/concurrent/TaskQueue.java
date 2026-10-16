package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.collections.h;
import kotlin.jvm.internal.e;
import okhttp3.internal.Util;
import r5.a;

/* loaded from: classes2.dex */
public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    public static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(a.f(new StringBuilder(), Util.okHttpName, " awaitIdle"), false);
            this.latch = new CountDownLatch(1);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    public TaskQueue(TaskRunner taskRunner, String name) {
        e.f(taskRunner, "taskRunner");
        e.f(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String name, long j4, boolean z5, oh.a block, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j4 = 0;
        }
        if ((i3 & 4) != 0) {
            z5 = true;
        }
        boolean z6 = z5;
        e.f(name, "name");
        e.f(block, "block");
        taskQueue.schedule(new TaskQueue$execute$1(block, name, z6, name, z6), j4);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j4 = 0;
        }
        taskQueue.schedule(task, j4);
    }

    public final void cancelAll() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Thread ");
        Thread currentThread = Thread.currentThread();
        e.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST NOT hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            e.c(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z5 = false;
        for (int size = this.futureTasks.size() - 1; size >= 0; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Task task2 = this.futureTasks.get(size);
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z5 = true;
            }
        }
        return z5;
    }

    public final void execute(String name, long j4, boolean z5, oh.a block) {
        e.f(name, "name");
        e.f(block, "block");
        schedule(new TaskQueue$execute$1(block, name, z5, name, z5), j4);
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> v6;
        synchronized (this.taskRunner) {
            v6 = h.v(this.futureTasks);
        }
        return v6;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task task = this.activeTask;
            if (task instanceof AwaitIdleTask) {
                return ((AwaitIdleTask) task).getLatch();
            }
            for (Task task2 : this.futureTasks) {
                if (task2 instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) task2).getLatch();
                }
            }
            AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }

    public final void schedule(Task task, long j4) {
        e.f(task, "task");
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, j4, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
            } else if (task.getCancelable()) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j4, boolean z5) {
        String str;
        e.f(task, "task");
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        long j10 = nanoTime + j4;
        int indexOf = this.futureTasks.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j10) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j10);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (z5) {
                str = "run again after " + TaskLoggerKt.formatDuration(j10 - nanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j10 - nanoTime);
            }
            TaskLoggerKt.log(task, this, str);
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime$okhttp() - nanoTime > j4) {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            i3 = this.futureTasks.size();
        }
        this.futureTasks.add(i3, task);
        return i3 == 0;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z5) {
        this.cancelActiveTask = z5;
    }

    public final void setShutdown$okhttp(boolean z5) {
        this.shutdown = z5;
    }

    public final void shutdown() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                this.shutdown = true;
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Thread ");
        Thread currentThread = Thread.currentThread();
        e.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST NOT hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String name, long j4, oh.a block, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j4 = 0;
        }
        e.f(name, "name");
        e.f(block, "block");
        taskQueue.schedule(new TaskQueue$schedule$2(block, name, name), j4);
    }

    public final void schedule(String name, long j4, oh.a block) {
        e.f(name, "name");
        e.f(block, "block");
        schedule(new TaskQueue$schedule$2(block, name, name), j4);
    }
}
