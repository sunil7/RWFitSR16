package i1;

import android.os.Process;

/* loaded from: classes.dex */
public final class g extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final int f14348a;

    public g(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f14348a = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f14348a);
        super.run();
    }
}
