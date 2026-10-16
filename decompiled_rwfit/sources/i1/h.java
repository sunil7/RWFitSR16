package i1;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class h implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14349a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f14349a) {
            case 0:
                return new g(runnable);
            case 1:
                Thread thread = new Thread(runnable);
                thread.setPriority(10);
                thread.setName("CameraX-camerax_high_priority");
                return thread;
            default:
                return new Thread(new a8.g(runnable, 4), "glide-active-resources");
        }
    }
}
