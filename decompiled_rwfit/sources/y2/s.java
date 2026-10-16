package y2;

import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class s {
    public static final String e = o2.m.i("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f19981a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f19982b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f19983c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f19984d;

    public s() {
        p pVar = new p();
        pVar.f19978a = 0;
        this.f19982b = new HashMap();
        this.f19983c = new HashMap();
        this.f19984d = new Object();
        this.f19981a = Executors.newSingleThreadScheduledExecutor(pVar);
    }

    public final void a(String str, r2.e eVar) {
        synchronized (this.f19984d) {
            o2.m.g().d(e, "Starting timer for " + str, new Throwable[0]);
            b(str);
            r rVar = new r(this, str);
            this.f19982b.put(str, rVar);
            this.f19983c.put(str, eVar);
            this.f19981a.schedule(rVar, Const.FENCE_STATED_MIN_TIME, TimeUnit.MILLISECONDS);
        }
    }

    public final void b(String str) {
        synchronized (this.f19984d) {
            try {
                if (((r) this.f19982b.remove(str)) != null) {
                    o2.m.g().d(e, "Stopping timer for " + str, new Throwable[0]);
                    this.f19983c.remove(str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
