package ia;

import com.example.test.ui.device.activity.f0;
import com.example.test.ui.device.activity.i0;
import q9.n;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final m f14382a = new m();

    public g() {
    }

    public final void a(Object obj) {
        this.f14382a.h(obj);
    }

    public final boolean b(Exception exc) {
        m mVar = this.f14382a;
        mVar.getClass();
        n.f(exc, "Exception must not be null");
        synchronized (mVar.f14398a) {
            try {
                if (mVar.f14400c) {
                    return false;
                }
                mVar.f14400c = true;
                mVar.f14402f = exc;
                mVar.f14399b.g(mVar);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public g(f0 f0Var) {
        i0 i0Var = new i0(this, 23);
        f0Var.getClass();
        i0 i0Var2 = new i0(i0Var, 22);
        ((m) f0Var.f7859b).b(h.f14383a, i0Var2);
    }
}
