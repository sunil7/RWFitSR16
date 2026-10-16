package androidx.emoji2.text;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2046a;

    public /* synthetic */ m(int i3) {
        this.f2046a = i3;
    }

    private final void a() {
    }

    private final void b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z5 = true;
        int i3 = 0;
        switch (this.f2046a) {
            case 0:
                try {
                    int i10 = h1.l.f14255a;
                    h1.k.a("EmojiCompat.EmojiCompatInitializer.run");
                    if (k.f2036j == null) {
                        z5 = false;
                    }
                    if (z5) {
                        k.a().c();
                    }
                    h1.k.b();
                    return;
                } catch (Throwable th2) {
                    int i11 = h1.l.f14255a;
                    h1.k.b();
                    throw th2;
                }
            case 1:
                return;
            case 2:
                ArrayList arrayList = new ArrayList(io.reactivex.internal.schedulers.l.f15096d.keySet());
                int size = arrayList.size();
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) obj;
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        io.reactivex.internal.schedulers.l.f15096d.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
                return;
            default:
                return;
        }
    }

    public String toString() {
        switch (this.f2046a) {
            case 3:
                return "EmptyRunnable";
            default:
                return super.toString();
        }
    }
}
