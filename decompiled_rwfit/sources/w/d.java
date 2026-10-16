package w;

import android.os.Handler;
import de.o;
import i1.h;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class d implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public static volatile d f19277c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19278a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19279b;

    public /* synthetic */ d(Object obj, int i3) {
        this.f19278a = i3;
        this.f19279b = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f19278a) {
            case 0:
                ((ExecutorService) this.f19279b).execute(runnable);
                return;
            case 1:
                ((Handler) ((o) this.f19279b).f12378c).post(runnable);
                return;
            case 2:
                runnable.getClass();
                Handler handler = (Handler) this.f19279b;
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            default:
                ((c5.b) this.f19279b).post(runnable);
                return;
        }
    }

    public d() {
        this.f19278a = 0;
        this.f19279b = Executors.newSingleThreadExecutor(new h(1));
    }
}
