package t;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.c2;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.o1;
import androidx.camera.core.impl.z1;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class b0 extends androidx.camera.core.f {

    /* renamed from: u, reason: collision with root package name */
    public static final z f18268u = new z();

    /* renamed from: o, reason: collision with root package name */
    public final e0 f18269o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f18270p;

    /* renamed from: q, reason: collision with root package name */
    public fe.b f18271q;
    public n1 r;

    /* renamed from: s, reason: collision with root package name */
    public androidx.camera.core.impl.s0 f18272s;

    /* renamed from: t, reason: collision with root package name */
    public o1 f18273t;

    public b0(androidx.camera.core.impl.m0 m0Var) {
        super(m0Var);
        this.f18270p = new Object();
        if (((Integer) ((androidx.camera.core.impl.m0) this.f1323f).k(androidx.camera.core.impl.m0.f1435b, 0)).intValue() == 1) {
            this.f18269o = new f0();
        } else {
            this.f18269o = new i0((Executor) m0Var.k(y.j.T0, a6.b()));
        }
        this.f18269o.f18303d = D();
        this.f18269o.e = ((Boolean) ((androidx.camera.core.impl.m0) this.f1323f).k(androidx.camera.core.impl.m0.f1439g, Boolean.FALSE)).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.camera.core.impl.n1 C(androidx.camera.core.impl.m0 r14, androidx.camera.core.impl.h r15) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t.b0.C(androidx.camera.core.impl.m0, androidx.camera.core.impl.h):androidx.camera.core.impl.n1");
    }

    public final int D() {
        return ((Integer) ((androidx.camera.core.impl.m0) this.f1323f).k(androidx.camera.core.impl.m0.e, 1)).intValue();
    }

    public final void E(Executor executor, fe.b bVar) {
        synchronized (this.f18270p) {
            try {
                e0 e0Var = this.f18269o;
                af.a aVar = new af.a(bVar, 25);
                synchronized (e0Var.r) {
                    e0Var.f18300a = aVar;
                    e0Var.f18305g = executor;
                }
                if (this.f18271q == null) {
                    n();
                }
                this.f18271q = bVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.f
    public final a2 e(boolean z5, c2 c2Var) {
        f18268u.getClass();
        androidx.camera.core.impl.m0 m0Var = z.f18431a;
        androidx.camera.core.impl.e0 a3 = c2Var.a(m0Var.p(), 1);
        if (z5) {
            a3 = androidx.camera.core.impl.e0.t(a3, m0Var);
        }
        if (a3 == null) {
            return null;
        }
        return new androidx.camera.core.impl.m0(androidx.camera.core.impl.d1.a(((g0.d) k(a3)).f13764b));
    }

    @Override // androidx.camera.core.f
    public final z1 k(androidx.camera.core.impl.e0 e0Var) {
        return new g0.d(androidx.camera.core.impl.x0.i(e0Var), 2);
    }

    @Override // androidx.camera.core.f
    public final void q() {
        this.f18269o.f18316s = true;
    }

    @Override // androidx.camera.core.f
    public final a2 s(androidx.camera.core.impl.u uVar, z1 z1Var) {
        Boolean bool = (Boolean) ((androidx.camera.core.impl.m0) this.f1323f).k(androidx.camera.core.impl.m0.f1438f, null);
        boolean d5 = uVar.i().d(OnePixelShiftQuirk.class);
        e0 e0Var = this.f18269o;
        if (bool != null) {
            d5 = bool.booleanValue();
        }
        e0Var.f18304f = d5;
        synchronized (this.f18270p) {
        }
        return z1Var.b();
    }

    public final String toString() {
        return "ImageAnalysis:".concat(f());
    }

    @Override // androidx.camera.core.f
    public final androidx.camera.core.impl.h v(m.b bVar) {
        this.r.a(bVar);
        Object[] objArr = {this.r.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        B(Collections.unmodifiableList(arrayList));
        androidx.camera.core.impl.e a3 = this.f1324g.a();
        a3.e = bVar;
        return a3.b();
    }

    @Override // androidx.camera.core.f
    public final androidx.camera.core.impl.h w(androidx.camera.core.impl.h hVar, androidx.camera.core.impl.h hVar2) {
        androidx.camera.core.impl.m0 m0Var = (androidx.camera.core.impl.m0) this.f1323f;
        d();
        n1 C = C(m0Var, hVar);
        this.r = C;
        Object[] objArr = {C.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        B(Collections.unmodifiableList(arrayList));
        return hVar;
    }

    @Override // androidx.camera.core.f
    public final void x() {
        y5.a();
        o1 o1Var = this.f18273t;
        if (o1Var != null) {
            o1Var.b();
            this.f18273t = null;
        }
        androidx.camera.core.impl.s0 s0Var = this.f18272s;
        if (s0Var != null) {
            s0Var.a();
            this.f18272s = null;
        }
        e0 e0Var = this.f18269o;
        e0Var.f18316s = false;
        e0Var.d();
    }

    @Override // androidx.camera.core.f
    public final void y(Matrix matrix) {
        super.y(matrix);
        e0 e0Var = this.f18269o;
        synchronized (e0Var.r) {
            e0Var.f18310l = matrix;
            e0Var.f18311m = new Matrix(e0Var.f18310l);
        }
    }

    @Override // androidx.camera.core.f
    public final void z(Rect rect) {
        this.f1326i = rect;
        e0 e0Var = this.f18269o;
        synchronized (e0Var.r) {
            e0Var.f18308j = rect;
            e0Var.f18309k = new Rect(e0Var.f18308j);
        }
    }
}
