package r2;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import de.o;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import o2.m;
import p2.l;
import y2.k;
import y2.s;

/* loaded from: classes.dex */
public final class g implements p2.a {

    /* renamed from: k, reason: collision with root package name */
    public static final String f18040k = m.i("SystemAlarmDispatcher");

    /* renamed from: a, reason: collision with root package name */
    public final Context f18041a;

    /* renamed from: b, reason: collision with root package name */
    public final o f18042b;

    /* renamed from: c, reason: collision with root package name */
    public final s f18043c;

    /* renamed from: d, reason: collision with root package name */
    public final p2.b f18044d;
    public final l e;

    /* renamed from: f, reason: collision with root package name */
    public final b f18045f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f18046g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f18047h;

    /* renamed from: i, reason: collision with root package name */
    public Intent f18048i;

    /* renamed from: j, reason: collision with root package name */
    public SystemAlarmService f18049j;

    public g(SystemAlarmService systemAlarmService) {
        Context applicationContext = systemAlarmService.getApplicationContext();
        this.f18041a = applicationContext;
        this.f18045f = new b(applicationContext);
        this.f18043c = new s();
        l a3 = l.a(systemAlarmService);
        this.e = a3;
        p2.b bVar = a3.f17429f;
        this.f18044d = bVar;
        this.f18042b = a3.f17428d;
        bVar.b(this);
        this.f18047h = new ArrayList();
        this.f18048i = null;
        this.f18046g = new Handler(Looper.getMainLooper());
    }

    @Override // p2.a
    public final void a(String str, boolean z5) {
        String str2 = b.f18020d;
        Intent intent = new Intent(this.f18041a, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z5);
        e(new androidx.activity.f(this, intent, 0, 5));
    }

    public final void b(int i3, Intent intent) {
        m g10 = m.g();
        String str = f18040k;
        int i10 = 0;
        g10.d(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i3)), new Throwable[0]);
        c();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            m.g().k(str, "Unknown command. Ignoring", new Throwable[0]);
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            c();
            synchronized (this.f18047h) {
                try {
                    ArrayList arrayList = this.f18047h;
                    int size = arrayList.size();
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) obj).getAction())) {
                            return;
                        }
                    }
                } finally {
                }
            }
        }
        intent.putExtra("KEY_START_ID", i3);
        synchronized (this.f18047h) {
            try {
                boolean isEmpty = this.f18047h.isEmpty();
                this.f18047h.add(intent);
                if (isEmpty) {
                    f();
                }
            } finally {
            }
        }
    }

    public final void c() {
        if (this.f18046g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final void d() {
        m.g().d(f18040k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f18044d.e(this);
        ScheduledExecutorService scheduledExecutorService = this.f18043c.f19981a;
        if (!scheduledExecutorService.isShutdown()) {
            scheduledExecutorService.shutdownNow();
        }
        this.f18049j = null;
    }

    public final void e(Runnable runnable) {
        this.f18046g.post(runnable);
    }

    public final void f() {
        c();
        PowerManager.WakeLock a3 = k.a(this.f18041a, "ProcessCommand");
        try {
            a3.acquire();
            this.e.f17428d.p(new f(this, 0));
        } finally {
            a3.release();
        }
    }
}
