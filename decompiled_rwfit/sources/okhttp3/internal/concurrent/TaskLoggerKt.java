package okhttp3.internal.concurrent;

import android.support.v4.media.session.e;
import com.google.android.exoplayer2.PlaybackException;
import java.util.Arrays;
import java.util.logging.Level;
import oh.a;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes2.dex */
public final class TaskLoggerKt {
    public static final String formatDuration(long j4) {
        return String.format("%6s", Arrays.copyOf(new Object[]{j4 <= ((long) (-999500000)) ? e.n(new StringBuilder(), (j4 - 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS, " s ") : j4 <= ((long) (-999500)) ? e.n(new StringBuilder(), (j4 - 500000) / PlaybackException.CUSTOM_ERROR_CODE_BASE, " ms") : j4 <= 0 ? e.n(new StringBuilder(), (j4 - 500) / 1000, " µs") : j4 < ((long) 999500) ? e.n(new StringBuilder(), (j4 + 500) / 1000, " µs") : j4 < ((long) 999500000) ? e.n(new StringBuilder(), (j4 + 500000) / PlaybackException.CUSTOM_ERROR_CODE_BASE, " ms") : e.n(new StringBuilder(), (j4 + 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS, " s ")}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        TaskRunner.Companion.getLogger().fine(taskQueue.getName$okhttp() + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + task.getName());
    }

    public static final <T> T logElapsed(Task task, TaskQueue queue, a block) {
        long j4;
        kotlin.jvm.internal.e.f(task, "task");
        kotlin.jvm.internal.e.f(queue, "queue");
        kotlin.jvm.internal.e.f(block, "block");
        boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j4 = queue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, queue, "starting");
        } else {
            j4 = -1;
        }
        try {
            T t8 = (T) block.invoke();
            if (isLoggable) {
                log(task, queue, "finished run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - j4));
            }
            return t8;
        } catch (Throwable th2) {
            if (isLoggable) {
                log(task, queue, "failed a run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - j4));
            }
            throw th2;
        }
    }

    public static final void taskLog(Task task, TaskQueue queue, a messageBlock) {
        kotlin.jvm.internal.e.f(task, "task");
        kotlin.jvm.internal.e.f(queue, "queue");
        kotlin.jvm.internal.e.f(messageBlock, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, queue, (String) messageBlock.invoke());
        }
    }
}
