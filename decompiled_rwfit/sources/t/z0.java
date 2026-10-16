package t;

import android.view.Surface;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class z0 implements androidx.camera.core.impl.r0 {

    /* renamed from: d, reason: collision with root package name */
    public final androidx.camera.core.impl.r0 f18435d;
    public final Surface e;

    /* renamed from: f, reason: collision with root package name */
    public w f18436f;

    /* renamed from: a, reason: collision with root package name */
    public final Object f18432a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public int f18433b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18434c = false;

    /* renamed from: g, reason: collision with root package name */
    public final g0 f18437g = new g0(this, 1);

    public z0(androidx.camera.core.impl.r0 r0Var) {
        this.f18435d = r0Var;
        this.e = r0Var.e();
    }

    public final void a() {
        synchronized (this.f18432a) {
            try {
                this.f18434c = true;
                this.f18435d.o();
                if (this.f18433b == 0) {
                    close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final void close() {
        synchronized (this.f18432a) {
            try {
                Surface surface = this.e;
                if (surface != null) {
                    surface.release();
                }
                this.f18435d.close();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final Surface e() {
        Surface e;
        synchronized (this.f18432a) {
            e = this.f18435d.e();
        }
        return e;
    }

    @Override // androidx.camera.core.impl.r0, wa.f
    public final int getHeight() {
        int height;
        synchronized (this.f18432a) {
            height = this.f18435d.getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.r0, wa.f
    public final int getWidth() {
        int width;
        synchronized (this.f18432a) {
            width = this.f18435d.getWidth();
        }
        return width;
    }

    @Override // androidx.camera.core.impl.r0
    public final p0 k() {
        h0 h0Var;
        synchronized (this.f18432a) {
            p0 k10 = this.f18435d.k();
            if (k10 != null) {
                this.f18433b++;
                h0Var = new h0(k10);
                h0Var.addOnImageCloseListener(this.f18437g);
            } else {
                h0Var = null;
            }
        }
        return h0Var;
    }

    @Override // androidx.camera.core.impl.r0
    public final int m() {
        int m10;
        synchronized (this.f18432a) {
            m10 = this.f18435d.m();
        }
        return m10;
    }

    @Override // androidx.camera.core.impl.r0
    public final void o() {
        synchronized (this.f18432a) {
            this.f18435d.o();
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final int q() {
        int q5;
        synchronized (this.f18432a) {
            q5 = this.f18435d.q();
        }
        return q5;
    }

    @Override // androidx.camera.core.impl.r0
    public final p0 r() {
        h0 h0Var;
        synchronized (this.f18432a) {
            p0 r = this.f18435d.r();
            if (r != null) {
                this.f18433b++;
                h0Var = new h0(r);
                h0Var.addOnImageCloseListener(this.f18437g);
            } else {
                h0Var = null;
            }
        }
        return h0Var;
    }

    public void setOnImageCloseListener(w wVar) {
        synchronized (this.f18432a) {
            this.f18436f = wVar;
        }
    }

    @Override // androidx.camera.core.impl.r0
    public final void t(androidx.camera.core.impl.q0 q0Var, Executor executor) {
        synchronized (this.f18432a) {
            this.f18435d.t(new c0.b(20, this, q0Var), executor);
        }
    }
}
