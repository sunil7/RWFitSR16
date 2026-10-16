package a8;

import android.os.Process;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Deque;
import q9.n;

/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f131a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f132b;

    public /* synthetic */ g(Runnable runnable, int i3) {
        this.f131a = i3;
        this.f132b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f131a) {
            case 0:
                try {
                    this.f132b.run();
                    break;
                } catch (Exception e) {
                    Log.e("TransportRuntime.".concat("Executor"), "Background execution failure.", e);
                    return;
                }
            case 1:
                Deque deque = (Deque) gc.f.f14031b.get();
                n.e(deque);
                Runnable runnable = this.f132b;
                deque.add(runnable);
                if (deque.size() <= 1) {
                    do {
                        runnable.run();
                        deque.removeFirst();
                        runnable = (Runnable) deque.peekFirst();
                    } while (runnable != null);
                }
                break;
            case 2:
                gc.f.f14031b.set(new ArrayDeque());
                this.f132b.run();
                break;
            case 3:
                this.f132b.run();
                break;
            default:
                Process.setThreadPriority(10);
                this.f132b.run();
                break;
        }
    }
}
