package ia;

import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class l implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14396a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14397b;

    public l() {
        c5.b bVar = new c5.b(Looper.getMainLooper(), 4, false);
        Looper.getMainLooper();
        this.f14397b = bVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f14396a) {
            case 0:
                ((c5.b) this.f14397b).post(runnable);
                break;
            default:
                qf.i iVar = (qf.i) this.f14397b;
                if (Thread.currentThread() != iVar.f17955b) {
                    iVar.f17956c.post(runnable);
                    break;
                } else {
                    runnable.run();
                    break;
                }
        }
    }

    public l(qf.i iVar) {
        this.f14397b = iVar;
    }
}
