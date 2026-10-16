package n;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.IncorrectCaptureStateQuirk;
import androidx.camera.camera2.internal.compat.quirk.Preview3AThreadCrashQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.core.impl.i1;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class n0 extends j0 {

    /* renamed from: b, reason: collision with root package name */
    public final g0 f16258b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f16259c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.camera.core.impl.utils.executor.b f16260d;
    public final w.c e;

    /* renamed from: f, reason: collision with root package name */
    public o0 f16261f;

    /* renamed from: g, reason: collision with root package name */
    public y2.f f16262g;

    /* renamed from: h, reason: collision with root package name */
    public n0.i f16263h;

    /* renamed from: i, reason: collision with root package name */
    public androidx.concurrent.futures.b f16264i;

    /* renamed from: j, reason: collision with root package name */
    public x.d f16265j;

    /* renamed from: o, reason: collision with root package name */
    public final w.c f16270o;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f16272q;
    public x.l r;

    /* renamed from: s, reason: collision with root package name */
    public final q.b f16273s;

    /* renamed from: t, reason: collision with root package name */
    public final n6.a f16274t;

    /* renamed from: u, reason: collision with root package name */
    public final com.example.test.utils.s0 f16275u;

    /* renamed from: v, reason: collision with root package name */
    public final com.example.test.utils.w0 f16276v;

    /* renamed from: a, reason: collision with root package name */
    public final Object f16257a = new Object();

    /* renamed from: k, reason: collision with root package name */
    public List f16266k = null;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16267l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f16268m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f16269n = false;

    /* renamed from: p, reason: collision with root package name */
    public final Object f16271p = new Object();

    /* renamed from: w, reason: collision with root package name */
    public final AtomicBoolean f16277w = new AtomicBoolean(false);

    public n0(i1 i1Var, i1 i1Var2, g0 g0Var, androidx.camera.core.impl.utils.executor.b bVar, w.c cVar, Handler handler) {
        this.f16258b = g0Var;
        this.f16259c = handler;
        this.f16260d = bVar;
        this.e = cVar;
        q.b bVar2 = new q.b();
        bVar2.f17606a = i1Var2.d(TextureViewIsClosedQuirk.class);
        bVar2.f17607b = i1Var.d(PreviewOrientationIncorrectQuirk.class);
        bVar2.f17608c = i1Var.d(ConfigureSurfaceToSecondarySessionFailQuirk.class);
        this.f16273s = bVar2;
        this.f16275u = new com.example.test.utils.s0(i1Var.d(CaptureSessionStuckQuirk.class) || i1Var.d(IncorrectCaptureStateQuirk.class));
        this.f16274t = new n6.a(i1Var2);
        com.example.test.utils.w0 w0Var = new com.example.test.utils.w0();
        w0Var.f8766a = i1Var2.d(Preview3AThreadCrashQuirk.class);
        this.f16276v = w0Var;
        this.f16270o = cVar;
    }

    @Override // n.j0
    public final void a(n0 n0Var) {
        Objects.requireNonNull(this.f16261f);
        this.f16261f.a(n0Var);
    }

    @Override // n.j0
    public final void b(n0 n0Var) {
        Objects.requireNonNull(this.f16261f);
        this.f16261f.b(n0Var);
    }

    @Override // n.j0
    public final void c(n0 n0Var) {
        n0.i iVar;
        synchronized (this.f16271p) {
            this.f16273s.b(this.f16272q);
        }
        l("onClosed()");
        synchronized (this.f16257a) {
            try {
                if (this.f16267l) {
                    iVar = null;
                } else {
                    this.f16267l = true;
                    pd.e(this.f16263h, "Need to call openCaptureSession before using this API.");
                    iVar = this.f16263h;
                }
            } finally {
            }
        }
        synchronized (this.f16257a) {
            try {
                List list = this.f16266k;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((androidx.camera.core.impl.g0) it.next()).b();
                    }
                    this.f16266k = null;
                }
            } finally {
            }
        }
        this.f16275u.h();
        if (iVar != null) {
            iVar.f16358b.a(new k0(this, n0Var, 1), a6.a());
        }
    }

    @Override // n.j0
    public final void d(n0 n0Var) {
        Objects.requireNonNull(this.f16261f);
        synchronized (this.f16257a) {
            try {
                List list = this.f16266k;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((androidx.camera.core.impl.g0) it.next()).b();
                    }
                    this.f16266k = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f16275u.h();
        g0 g0Var = this.f16258b;
        g0Var.i(this);
        synchronized (g0Var.f16175b) {
            ((LinkedHashSet) g0Var.e).remove(this);
        }
        this.f16261f.d(n0Var);
    }

    @Override // n.j0
    public final void e(n0 n0Var) {
        ArrayList arrayList;
        l("Session onConfigured()");
        n6.a aVar = this.f16274t;
        g0 g0Var = this.f16258b;
        synchronized (g0Var.f16175b) {
            arrayList = new ArrayList((LinkedHashSet) g0Var.e);
        }
        ArrayList j4 = this.f16258b.j();
        int i3 = 0;
        if (((CaptureSessionOnClosedNotCalledQuirk) aVar.f16381b) != null) {
            LinkedHashSet<n0> linkedHashSet = new LinkedHashSet();
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                n0 n0Var2 = (n0) obj;
                if (n0Var2 == n0Var) {
                    break;
                } else {
                    linkedHashSet.add(n0Var2);
                }
            }
            for (n0 n0Var3 : linkedHashSet) {
                n0Var3.getClass();
                n0Var3.d(n0Var3);
            }
        }
        Objects.requireNonNull(this.f16261f);
        g0 g0Var2 = this.f16258b;
        synchronized (g0Var2.f16175b) {
            ((LinkedHashSet) g0Var2.f16176c).add(this);
            ((LinkedHashSet) g0Var2.e).remove(this);
        }
        g0Var2.i(this);
        this.f16261f.e(n0Var);
        if (((CaptureSessionOnClosedNotCalledQuirk) aVar.f16381b) != null) {
            LinkedHashSet<n0> linkedHashSet2 = new LinkedHashSet();
            int size2 = j4.size();
            while (i3 < size2) {
                Object obj2 = j4.get(i3);
                i3++;
                n0 n0Var4 = (n0) obj2;
                if (n0Var4 == n0Var) {
                    break;
                } else {
                    linkedHashSet2.add(n0Var4);
                }
            }
            for (n0 n0Var5 : linkedHashSet2) {
                n0Var5.getClass();
                n0Var5.c(n0Var5);
            }
        }
    }

    @Override // n.j0
    public final void f(n0 n0Var) {
        Objects.requireNonNull(this.f16261f);
        this.f16261f.f(n0Var);
    }

    @Override // n.j0
    public final void g(n0 n0Var) {
        n0.i iVar;
        synchronized (this.f16257a) {
            try {
                if (this.f16269n) {
                    iVar = null;
                } else {
                    this.f16269n = true;
                    pd.e(this.f16263h, "Need to call openCaptureSession before using this API.");
                    iVar = this.f16263h;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (iVar != null) {
            iVar.f16358b.a(new k0(this, n0Var, 0), a6.a());
        }
    }

    @Override // n.j0
    public final void h(n0 n0Var, Surface surface) {
        Objects.requireNonNull(this.f16261f);
        this.f16261f.h(n0Var, surface);
    }

    public final int i(ArrayList arrayList, androidx.camera.camera2.internal.compat.f fVar) {
        CameraCaptureSession.CaptureCallback c9 = this.f16275u.c(fVar);
        pd.e(this.f16262g, "Need to call openCaptureSession before using this API.");
        return ((ef.i) this.f16262g.f19953b).j(arrayList, this.f16260d, c9);
    }

    public final void j() {
        if (!this.f16277w.compareAndSet(false, true)) {
            l("close() has been called. Skip this invocation.");
            return;
        }
        if (this.f16276v.f8766a) {
            try {
                l("Call abortCaptures() before closing session.");
                pd.e(this.f16262g, "Need to call openCaptureSession before using this API.");
                ((CameraCaptureSession) ((ef.i) this.f16262g.f19953b).f12629b).abortCaptures();
            } catch (Exception e) {
                l("Exception when calling abortCaptures()" + e);
            }
        }
        l("Session call close()");
        this.f16275u.e().a(new l0(this, 1), this.f16260d);
    }

    public final void k(CameraCaptureSession cameraCaptureSession) {
        if (this.f16262g == null) {
            this.f16262g = new y2.f(cameraCaptureSession, this.f16259c);
        }
    }

    public final void l(String str) {
        com.google.android.gms.internal.mlkit_vision_common.a0.a("SyncCaptureSessionImpl", "[" + this + "] " + str);
    }

    public final boolean m() {
        boolean z5;
        synchronized (this.f16257a) {
            z5 = this.f16263h != null;
        }
        return z5;
    }

    public final ob.a n(CameraDevice cameraDevice, o.q qVar, List list) {
        ob.a d5;
        synchronized (this.f16271p) {
            try {
                ArrayList j4 = this.f16258b.j();
                ArrayList arrayList = new ArrayList();
                int size = j4.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = j4.get(i3);
                    i3++;
                    n0 n0Var = (n0) obj;
                    arrayList.add(ve.a(new x.e(n0Var.f16275u.e(), n0Var.f16270o, Const.L_MIN_WIFI_RESULT)));
                }
                x.l lVar = new x.l(new ArrayList(arrayList), false, a6.a());
                this.r = lVar;
                x.d b3 = x.d.b(lVar);
                me.a aVar = new me.a(this, cameraDevice, qVar, list);
                androidx.camera.core.impl.utils.executor.b bVar = this.f16260d;
                b3.getClass();
                d5 = x.i.d(x.i.f(b3, aVar, bVar));
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return d5;
    }

    public final int o(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        CameraCaptureSession.CaptureCallback c9 = this.f16275u.c(captureCallback);
        pd.e(this.f16262g, "Need to call openCaptureSession before using this API.");
        return ((ef.i) this.f16262g.f19953b).L(captureRequest, this.f16260d, c9);
    }

    public final ob.a p(ArrayList arrayList) {
        synchronized (this.f16257a) {
            try {
                if (this.f16268m) {
                    return new x.k(new CancellationException("Opener is disabled"), 1);
                }
                x.d b3 = x.d.b(com.bumptech.glide.c.a(arrayList, this.f16260d, this.e));
                c0.b bVar = new c0.b(14, this, arrayList);
                androidx.camera.core.impl.utils.executor.b bVar2 = this.f16260d;
                b3.getClass();
                x.b f2 = x.i.f(b3, bVar, bVar2);
                this.f16265j = f2;
                return x.i.d(f2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean q() {
        boolean z5;
        synchronized (this.f16271p) {
            try {
                if (m()) {
                    this.f16273s.b(this.f16272q);
                } else {
                    x.l lVar = this.r;
                    if (lVar != null) {
                        lVar.cancel(true);
                    }
                }
                try {
                    synchronized (this.f16257a) {
                        try {
                            if (!this.f16268m) {
                                x.d dVar = this.f16265j;
                                r1 = dVar != null ? dVar : null;
                                this.f16268m = true;
                            }
                            z5 = !m();
                        } finally {
                        }
                    }
                } finally {
                    if (r1 != null) {
                        r1.cancel(true);
                    }
                }
            } finally {
            }
        }
        return z5;
    }

    public final y2.f r() {
        this.f16262g.getClass();
        return this.f16262g;
    }
}
