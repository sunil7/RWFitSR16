package ff;

import java.lang.Thread;

/* loaded from: classes2.dex */
public final class u implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        q.T.b(2, "EXCEPTION:", "In the NoOpExceptionHandler, probably while destroying.", "Thread:", thread, "Error:", th2);
    }
}
