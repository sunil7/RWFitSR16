package ca;

import android.os.Looper;
import android.os.Process;

/* loaded from: classes.dex */
public final class e extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3417a = 1;

    public /* synthetic */ e() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        wh.e a3;
        switch (this.f3417a) {
            case 0:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
            case 1:
                Looper.prepare();
                Looper.loop();
                return;
            case 2:
            default:
                super.run();
                return;
            case 3:
                break;
        }
        while (true) {
            try {
                synchronized (wh.e.class) {
                    try {
                        wh.e.Companion.getClass();
                        a3 = wh.b.a();
                        if (a3 == wh.e.head) {
                            wh.e.head = null;
                            return;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (a3 != null) {
                    a3.timedOut();
                }
            } catch (InterruptedException unused2) {
                continue;
            }
        }
    }

    public /* synthetic */ e(Runnable runnable, String str) {
        super(runnable, str);
    }

    public /* synthetic */ e(String str) {
        super(str);
    }

    public /* synthetic */ e(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
