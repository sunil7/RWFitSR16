package ff;

import java.lang.Thread;

/* loaded from: classes2.dex */
public final class t implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f13672a;

    public t(q qVar) {
        this.f13672a = qVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        q.b(this.f13672a, th2, true);
    }
}
