package pe;

import android.os.Handler;
import android.os.Looper;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class h {
    public static final ThreadPoolExecutor e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f17565f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f17566g;

    /* renamed from: c, reason: collision with root package name */
    public final Object f17569c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f17570d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final Handler f17567a = new Handler(Looper.getMainLooper(), new g(0));

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f17568b = new LinkedBlockingQueue();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ye.b("BlockCompleted"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        e = threadPoolExecutor;
        f17565f = 10;
        f17566g = 5;
    }

    public static boolean a(i iVar) {
        if (((MessageSnapshot) iVar.f17573c.peek()).n() != 4) {
            return false;
        }
        e.execute(new androidx.activity.e(iVar, 29));
        return true;
    }

    public final void b() {
        synchronized (this.f17569c) {
            try {
                if (this.f17570d.isEmpty()) {
                    if (this.f17568b.isEmpty()) {
                        return;
                    }
                    int i3 = f17565f;
                    if (i3 > 0) {
                        int min = Math.min(this.f17568b.size(), f17566g);
                        for (int i10 = 0; i10 < min; i10++) {
                            this.f17570d.add(this.f17568b.remove());
                        }
                    } else {
                        this.f17568b.drainTo(this.f17570d);
                        i3 = 0;
                    }
                    Handler handler = this.f17567a;
                    handler.sendMessageDelayed(handler.obtainMessage(2, this.f17570d), i3);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
