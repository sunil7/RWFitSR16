package ef;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class e implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12616a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12617b;

    public /* synthetic */ e(ThreadFactory threadFactory) {
        this.f12616a = 4;
        this.f12617b = threadFactory;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f12616a) {
            case 0:
                return new Thread(runnable, "FrameExecutor #" + ((AtomicInteger) this.f12617b).getAndIncrement());
            case 1:
                Thread thread = new Thread(runnable);
                thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(((AtomicInteger) this.f12617b).getAndIncrement())));
                return thread;
            case 2:
                Thread thread2 = new Thread(runnable);
                Locale locale = Locale.US;
                thread2.setName("CameraX-core_camera_" + ((AtomicInteger) this.f12617b).getAndIncrement());
                return thread2;
            case 3:
                Thread thread3 = new Thread(runnable);
                Locale locale2 = Locale.US;
                thread3.setName("CameraX-camerax_io_" + ((AtomicInteger) this.f12617b).getAndIncrement());
                return thread3;
            default:
                return ((ThreadFactory) this.f12617b).newThread(new a8.g(runnable, 2));
        }
    }

    public e(int i3) {
        this.f12616a = i3;
        switch (i3) {
            case 1:
                this.f12617b = new AtomicInteger(0);
                break;
            case 2:
                this.f12617b = new AtomicInteger(0);
                break;
            case 3:
                this.f12617b = new AtomicInteger(0);
                break;
            default:
                this.f12617b = new AtomicInteger(1);
                break;
        }
    }
}
