package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.c0;
import androidx.camera.core.impl.c2;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.e1;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.o0;
import androidx.camera.core.impl.o1;
import androidx.camera.core.impl.p0;
import androidx.camera.core.impl.q1;
import androidx.camera.core.impl.s0;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.x0;
import androidx.camera.core.impl.z1;
import c0.k;
import c0.n;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import t.f1;
import t.v0;
import t.w0;

/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: v, reason: collision with root package name */
    public static final v0 f1305v = new v0();

    /* renamed from: w, reason: collision with root package name */
    public static final w.c f1306w = a6.d();

    /* renamed from: o, reason: collision with root package name */
    public w0 f1307o;

    /* renamed from: p, reason: collision with root package name */
    public w.c f1308p;

    /* renamed from: q, reason: collision with root package name */
    public n1 f1309q;
    public s0 r;

    /* renamed from: s, reason: collision with root package name */
    public n f1310s;

    /* renamed from: t, reason: collision with root package name */
    public f1 f1311t;

    /* renamed from: u, reason: collision with root package name */
    public o1 f1312u;

    public final void C() {
        o1 o1Var = this.f1312u;
        if (o1Var != null) {
            o1Var.b();
            this.f1312u = null;
        }
        s0 s0Var = this.r;
        if (s0Var != null) {
            s0Var.a();
            this.r = null;
        }
        n nVar = this.f1310s;
        if (nVar != null) {
            nVar.b();
            this.f1310s = null;
        }
        this.f1311t = null;
    }

    public final void D(w0 w0Var) {
        y5.a();
        if (w0Var == null) {
            this.f1307o = null;
            this.f1321c = UseCase$State.INACTIVE;
            p();
            return;
        }
        this.f1307o = w0Var;
        this.f1308p = f1306w;
        h hVar = this.f1324g;
        if ((hVar != null ? hVar.f1405a : null) != null) {
            E((e1) this.f1323f, hVar);
            o();
        }
        n();
    }

    public final void E(e1 e1Var, h hVar) {
        y5.a();
        v b3 = b();
        Objects.requireNonNull(b3);
        C();
        pd.f(null, this.f1310s == null);
        Matrix matrix = this.f1327j;
        boolean f2 = b3.f();
        Size size = hVar.f1405a;
        Rect rect = this.f1326i;
        if (rect == null) {
            rect = size != null ? new Rect(0, 0, size.getWidth(), size.getHeight()) : null;
        }
        Objects.requireNonNull(rect);
        int g10 = g(b3, l(b3));
        p0 p0Var = (p0) this.f1323f;
        androidx.camera.core.impl.c cVar = p0.f1468u0;
        n nVar = new n(1, 34, hVar, matrix, f2, rect, g10, ((Integer) p0Var.k(cVar, -1)).intValue(), b3.f() && l(b3));
        this.f1310s = nVar;
        m5.a aVar = new m5.a(this, 12);
        y5.a();
        nVar.a();
        nVar.f3340m.add(aVar);
        f1 c9 = this.f1310s.c(b3, true);
        this.f1311t = c9;
        this.r = c9.f18328k;
        if (this.f1307o != null) {
            v b10 = b();
            n nVar2 = this.f1310s;
            if (b10 != null && nVar2 != null) {
                y5.c(new k(nVar2, g(b10, l(b10)), ((Integer) ((p0) this.f1323f).k(cVar, -1)).intValue()));
            }
            w0 w0Var = this.f1307o;
            w0Var.getClass();
            f1 f1Var = this.f1311t;
            f1Var.getClass();
            this.f1308p.execute(new n5.a(7, w0Var, f1Var));
        }
        n1 d5 = n1.d(e1Var, hVar.f1405a);
        c0 c0Var = d5.f1442b;
        c0Var.getClass();
        c0Var.f1355b.m(d0.f1365j, hVar.f1407c);
        int D = e1Var.D();
        if (D != 0) {
            c0Var.getClass();
            if (D != 0) {
                c0Var.f1355b.m(a2.L0, Integer.valueOf(D));
            }
        }
        m.b bVar = hVar.f1408d;
        if (bVar != null) {
            c0Var.c(bVar);
        }
        if (this.f1307o != null) {
            d5.b(this.r, hVar.f1406b, ((Integer) ((p0) this.f1323f).k(p0.f1469v0, -1)).intValue());
        }
        o1 o1Var = this.f1312u;
        if (o1Var != null) {
            o1Var.b();
        }
        o1 o1Var2 = new o1(new q1(this, 4));
        this.f1312u = o1Var2;
        d5.f1445f = o1Var2;
        this.f1309q = d5;
        Object[] objArr = {d5.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        B(Collections.unmodifiableList(arrayList));
    }

    @Override // androidx.camera.core.f
    public final a2 e(boolean z5, c2 c2Var) {
        f1305v.getClass();
        e1 e1Var = v0.f18421a;
        e0 a3 = c2Var.a(e1Var.p(), 1);
        if (z5) {
            a3 = e0.t(a3, e1Var);
        }
        if (a3 == null) {
            return null;
        }
        return new e1(d1.a(((m.a) k(a3)).f15876b));
    }

    @Override // androidx.camera.core.f
    public final Set j() {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        return hashSet;
    }

    @Override // androidx.camera.core.f
    public final z1 k(e0 e0Var) {
        return new m.a(x0.i(e0Var));
    }

    @Override // androidx.camera.core.f
    public final a2 s(u uVar, z1 z1Var) {
        ((x0) z1Var.a()).m(o0.f1462q0, 34);
        return z1Var.b();
    }

    public final String toString() {
        return "Preview:".concat(f());
    }

    @Override // androidx.camera.core.f
    public final h v(m.b bVar) {
        this.f1309q.a(bVar);
        Object[] objArr = {this.f1309q.c()};
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
    public final h w(h hVar, h hVar2) {
        E((e1) this.f1323f, hVar);
        return hVar;
    }

    @Override // androidx.camera.core.f
    public final void x() {
        C();
    }

    @Override // androidx.camera.core.f
    public final void z(Rect rect) {
        this.f1326i = rect;
        v b3 = b();
        n nVar = this.f1310s;
        if (b3 == null || nVar == null) {
            return;
        }
        y5.c(new k(nVar, g(b3, l(b3)), ((Integer) ((p0) this.f1323f).k(p0.f1468u0, -1)).intValue()));
    }
}
