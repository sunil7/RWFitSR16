package ye;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f20112a;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f20114c = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    public final ThreadGroup f20113b = Thread.currentThread().getThreadGroup();

    static {
        new AtomicInteger(1);
    }

    public b(String str) {
        int i3 = e.f20123a;
        this.f20112a = l0.n("FileDownloader-", str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f20113b, runnable, this.f20112a + this.f20114c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
