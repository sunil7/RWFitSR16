package t;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class s implements y.i {

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.camera.core.impl.c f18383b = new androidx.camera.core.impl.c("camerax.core.appConfig.cameraFactoryProvider", l.a.class, null);

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.camera.core.impl.c f18384c = new androidx.camera.core.impl.c("camerax.core.appConfig.deviceSurfaceManagerProvider", l.b.class, null);

    /* renamed from: d, reason: collision with root package name */
    public static final androidx.camera.core.impl.c f18385d = new androidx.camera.core.impl.c("camerax.core.appConfig.useCaseConfigFactoryProvider", l.c.class, null);
    public static final androidx.camera.core.impl.c e = new androidx.camera.core.impl.c("camerax.core.appConfig.cameraExecutor", Executor.class, null);

    /* renamed from: f, reason: collision with root package name */
    public static final androidx.camera.core.impl.c f18386f = new androidx.camera.core.impl.c("camerax.core.appConfig.schedulerHandler", Handler.class, null);

    /* renamed from: g, reason: collision with root package name */
    public static final androidx.camera.core.impl.c f18387g = new androidx.camera.core.impl.c("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE, null);

    /* renamed from: h, reason: collision with root package name */
    public static final androidx.camera.core.impl.c f18388h = new androidx.camera.core.impl.c("camerax.core.appConfig.availableCamerasLimiter", q.class, null);

    /* renamed from: i, reason: collision with root package name */
    public static final androidx.camera.core.impl.c f18389i = new androidx.camera.core.impl.c("camerax.core.appConfig.cameraOpenRetryMaxTimeoutInMillisWhileResuming", Long.TYPE, null);

    /* renamed from: j, reason: collision with root package name */
    public static final androidx.camera.core.impl.c f18390j = new androidx.camera.core.impl.c("camerax.core.appConfig.cameraProviderInitRetryPolicy", y0.class, null);

    /* renamed from: k, reason: collision with root package name */
    public static final androidx.camera.core.impl.c f18391k = new androidx.camera.core.impl.c("camerax.core.appConfig.quirksSettings", androidx.camera.core.impl.g1.class, null);

    /* renamed from: a, reason: collision with root package name */
    public final androidx.camera.core.impl.d1 f18392a;

    public s(androidx.camera.core.impl.d1 d1Var) {
        this.f18392a = d1Var;
    }

    public final q a() {
        Object obj;
        try {
            obj = this.f18392a.e(f18388h);
        } catch (IllegalArgumentException unused) {
            obj = null;
        }
        return (q) obj;
    }

    public final l.a f() {
        Object obj;
        try {
            obj = this.f18392a.e(f18383b);
        } catch (IllegalArgumentException unused) {
            obj = null;
        }
        return (l.a) obj;
    }

    public final long i() {
        androidx.camera.core.impl.c cVar = f18389i;
        Object obj = -1L;
        androidx.camera.core.impl.d1 d1Var = this.f18392a;
        d1Var.getClass();
        try {
            obj = d1Var.e(cVar);
        } catch (IllegalArgumentException unused) {
        }
        return ((Long) obj).longValue();
    }

    public final l.b l() {
        Object obj;
        try {
            obj = this.f18392a.e(f18384c);
        } catch (IllegalArgumentException unused) {
            obj = null;
        }
        return (l.b) obj;
    }

    public final l.c m() {
        Object obj;
        try {
            obj = this.f18392a.e(f18385d);
        } catch (IllegalArgumentException unused) {
            obj = null;
        }
        return (l.c) obj;
    }

    @Override // androidx.camera.core.impl.j1
    public final androidx.camera.core.impl.e0 y() {
        return this.f18392a;
    }
}
