package t;

import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class i0 extends e0 {

    /* renamed from: t, reason: collision with root package name */
    public final Executor f18346t;

    /* renamed from: u, reason: collision with root package name */
    public final Object f18347u = new Object();

    /* renamed from: v, reason: collision with root package name */
    public p0 f18348v;

    /* renamed from: w, reason: collision with root package name */
    public h0 f18349w;

    public i0(Executor executor) {
        this.f18346t = executor;
    }

    @Override // t.e0
    public final p0 a(androidx.camera.core.impl.r0 r0Var) {
        return r0Var.k();
    }

    @Override // t.e0
    public final void d() {
        synchronized (this.f18347u) {
            try {
                p0 p0Var = this.f18348v;
                if (p0Var != null) {
                    p0Var.close();
                    this.f18348v = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // t.e0
    public final void f(p0 p0Var) {
        synchronized (this.f18347u) {
            try {
                if (!this.f18316s) {
                    p0Var.close();
                    return;
                }
                if (this.f18349w != null) {
                    if (p0Var.u().d() <= this.f18349w.f18423b.u().d()) {
                        p0Var.close();
                    } else {
                        p0 p0Var2 = this.f18348v;
                        if (p0Var2 != null) {
                            p0Var2.close();
                        }
                        this.f18348v = p0Var;
                    }
                    return;
                }
                h0 h0Var = new h0(p0Var, this);
                this.f18349w = h0Var;
                ob.a b3 = b(h0Var);
                n.m0 m0Var = new n.m0(h0Var, 19);
                b3.a(new x.h(0, b3, m0Var), a6.a());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
