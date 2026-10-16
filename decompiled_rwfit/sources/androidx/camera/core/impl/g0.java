package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: k, reason: collision with root package name */
    public static final Size f1388k = new Size(0, 0);

    /* renamed from: l, reason: collision with root package name */
    public static final boolean f1389l = com.google.android.gms.internal.mlkit_vision_common.a0.d(3, "DeferrableSurface");

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicInteger f1390m = new AtomicInteger(0);

    /* renamed from: n, reason: collision with root package name */
    public static final AtomicInteger f1391n = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    public final Object f1392a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public int f1393b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1394c = false;

    /* renamed from: d, reason: collision with root package name */
    public androidx.concurrent.futures.b f1395d;
    public final n0.i e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.concurrent.futures.b f1396f;

    /* renamed from: g, reason: collision with root package name */
    public final n0.i f1397g;

    /* renamed from: h, reason: collision with root package name */
    public final Size f1398h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1399i;

    /* renamed from: j, reason: collision with root package name */
    public Class f1400j;

    public g0(Size size, int i3) {
        this.f1398h = size;
        this.f1399i = i3;
        final int i10 = 0;
        n0.i a3 = ve.a(new n0.g(this) { // from class: androidx.camera.core.impl.f0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g0 f1387b;

            {
                this.f1387b = this;
            }

            @Override // n0.g
            public final Object b(androidx.concurrent.futures.b bVar) {
                switch (i10) {
                    case 0:
                        g0 g0Var = this.f1387b;
                        synchronized (g0Var.f1392a) {
                            g0Var.f1395d = bVar;
                        }
                        return "DeferrableSurface-termination(" + g0Var + ")";
                    default:
                        g0 g0Var2 = this.f1387b;
                        synchronized (g0Var2.f1392a) {
                            g0Var2.f1396f = bVar;
                        }
                        return "DeferrableSurface-close(" + g0Var2 + ")";
                }
            }
        });
        this.e = a3;
        final int i11 = 1;
        this.f1397g = ve.a(new n0.g(this) { // from class: androidx.camera.core.impl.f0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g0 f1387b;

            {
                this.f1387b = this;
            }

            @Override // n0.g
            public final Object b(androidx.concurrent.futures.b bVar) {
                switch (i11) {
                    case 0:
                        g0 g0Var = this.f1387b;
                        synchronized (g0Var.f1392a) {
                            g0Var.f1395d = bVar;
                        }
                        return "DeferrableSurface-termination(" + g0Var + ")";
                    default:
                        g0 g0Var2 = this.f1387b;
                        synchronized (g0Var2.f1392a) {
                            g0Var2.f1396f = bVar;
                        }
                        return "DeferrableSurface-close(" + g0Var2 + ")";
                }
            }
        });
        if (com.google.android.gms.internal.mlkit_vision_common.a0.d(3, "DeferrableSurface")) {
            e(f1391n.incrementAndGet(), f1390m.get(), "Surface created");
            a3.f16358b.a(new androidx.appcompat.app.i0(1, this, Log.getStackTraceString(new Exception())), a6.a());
        }
    }

    public void a() {
        androidx.concurrent.futures.b bVar;
        synchronized (this.f1392a) {
            try {
                if (this.f1394c) {
                    bVar = null;
                } else {
                    this.f1394c = true;
                    this.f1396f.a(null);
                    if (this.f1393b == 0) {
                        bVar = this.f1395d;
                        this.f1395d = null;
                    } else {
                        bVar = null;
                    }
                    if (com.google.android.gms.internal.mlkit_vision_common.a0.d(3, "DeferrableSurface")) {
                        com.google.android.gms.internal.mlkit_vision_common.a0.a("DeferrableSurface", "surface closed,  useCount=" + this.f1393b + " closed=true " + this);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (bVar != null) {
            bVar.a(null);
        }
    }

    public final void b() {
        androidx.concurrent.futures.b bVar;
        synchronized (this.f1392a) {
            try {
                int i3 = this.f1393b;
                if (i3 == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                int i10 = i3 - 1;
                this.f1393b = i10;
                if (i10 == 0 && this.f1394c) {
                    bVar = this.f1395d;
                    this.f1395d = null;
                } else {
                    bVar = null;
                }
                if (com.google.android.gms.internal.mlkit_vision_common.a0.d(3, "DeferrableSurface")) {
                    com.google.android.gms.internal.mlkit_vision_common.a0.a("DeferrableSurface", "use count-1,  useCount=" + this.f1393b + " closed=" + this.f1394c + " " + this);
                    if (this.f1393b == 0) {
                        e(f1391n.get(), f1390m.decrementAndGet(), "Surface no longer in use");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (bVar != null) {
            bVar.a(null);
        }
    }

    public final ob.a c() {
        synchronized (this.f1392a) {
            try {
                if (this.f1394c) {
                    return new x.k(new DeferrableSurface$SurfaceClosedException("DeferrableSurface already closed.", this), 1);
                }
                return f();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d() {
        synchronized (this.f1392a) {
            try {
                int i3 = this.f1393b;
                if (i3 == 0 && this.f1394c) {
                    throw new DeferrableSurface$SurfaceClosedException("Cannot begin use on a closed surface.", this);
                }
                this.f1393b = i3 + 1;
                if (com.google.android.gms.internal.mlkit_vision_common.a0.d(3, "DeferrableSurface")) {
                    if (this.f1393b == 1) {
                        e(f1391n.get(), f1390m.incrementAndGet(), "New surface in use");
                    }
                    com.google.android.gms.internal.mlkit_vision_common.a0.a("DeferrableSurface", "use count+1, useCount=" + this.f1393b + " " + this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void e(int i3, int i10, String str) {
        if (!f1389l && com.google.android.gms.internal.mlkit_vision_common.a0.d(3, "DeferrableSurface")) {
            com.google.android.gms.internal.mlkit_vision_common.a0.a("DeferrableSurface", "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        com.google.android.gms.internal.mlkit_vision_common.a0.a("DeferrableSurface", str + "[total_surfaces=" + i3 + ", used_surfaces=" + i10 + "](" + this + "}");
    }

    public abstract ob.a f();
}
