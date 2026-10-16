package w;

import a8.g;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class e implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static volatile e f19280c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19281a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f19282b;

    public e(ExecutorService executorService) {
        this.f19281a = 1;
        this.f19282b = executorService;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f19281a) {
            case 0:
                this.f19282b.execute(runnable);
                break;
            default:
                this.f19282b.execute(new g(runnable, 0));
                break;
        }
    }

    public e() {
        this.f19281a = 0;
        this.f19282b = Executors.newFixedThreadPool(2, new ef.e(3));
    }
}
