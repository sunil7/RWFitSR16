package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.c2;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.g0;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.p0;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.x0;
import androidx.camera.core.impl.z1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import n.m0;
import t.g1;
import y.i;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: d, reason: collision with root package name */
    public a2 f1322d;
    public final Object e;

    /* renamed from: f, reason: collision with root package name */
    public a2 f1323f;

    /* renamed from: g, reason: collision with root package name */
    public h f1324g;

    /* renamed from: h, reason: collision with root package name */
    public a2 f1325h;

    /* renamed from: i, reason: collision with root package name */
    public Rect f1326i;

    /* renamed from: k, reason: collision with root package name */
    public v f1328k;

    /* renamed from: l, reason: collision with root package name */
    public v f1329l;

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f1319a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final Object f1320b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public UseCase$State f1321c = UseCase$State.INACTIVE;

    /* renamed from: j, reason: collision with root package name */
    public Matrix f1327j = new Matrix();

    /* renamed from: m, reason: collision with root package name */
    public s1 f1330m = s1.a();

    /* renamed from: n, reason: collision with root package name */
    public s1 f1331n = s1.a();

    public f(a2 a2Var) {
        this.e = a2Var;
        this.f1323f = a2Var;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.camera.core.impl.a2, java.lang.Object] */
    public final void A(v vVar) {
        x();
        synchronized (this.f1320b) {
            try {
                v vVar2 = this.f1328k;
                if (vVar == vVar2) {
                    this.f1319a.remove(vVar2);
                    this.f1328k = null;
                }
                v vVar3 = this.f1329l;
                if (vVar == vVar3) {
                    this.f1319a.remove(vVar3);
                    this.f1329l = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f1324g = null;
        this.f1326i = null;
        this.f1323f = this.e;
        this.f1322d = null;
        this.f1325h = null;
    }

    public final void B(List list) {
        if (list.isEmpty()) {
            return;
        }
        this.f1330m = (s1) list.get(0);
        if (list.size() > 1) {
            this.f1331n = (s1) list.get(1);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            for (g0 g0Var : ((s1) it.next()).b()) {
                if (g0Var.f1400j == null) {
                    g0Var.f1400j = getClass();
                }
            }
        }
    }

    public final void a(v vVar, v vVar2, a2 a2Var, a2 a2Var2) {
        synchronized (this.f1320b) {
            this.f1328k = vVar;
            this.f1329l = vVar2;
            this.f1319a.add(vVar);
            if (vVar2 != null) {
                this.f1319a.add(vVar2);
            }
        }
        this.f1322d = a2Var;
        this.f1325h = a2Var2;
        this.f1323f = m(vVar.h(), this.f1322d, this.f1325h);
        q();
    }

    public final v b() {
        v vVar;
        synchronized (this.f1320b) {
            vVar = this.f1328k;
        }
        return vVar;
    }

    public final t c() {
        synchronized (this.f1320b) {
            try {
                v vVar = this.f1328k;
                if (vVar == null) {
                    return t.f1492a;
                }
                return vVar.m();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final String d() {
        v b3 = b();
        pd.e(b3, "No camera attached to use case: " + this);
        return b3.h().c();
    }

    public abstract a2 e(boolean z5, c2 c2Var);

    public final String f() {
        String str = (String) this.f1323f.k(i.R0, "<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(str);
        return str;
    }

    public final int g(v vVar, boolean z5) {
        int f2 = vVar.h().f(((p0) this.f1323f).n());
        return (vVar.f() || !z5) ? f2 : v.d.f(-f2);
    }

    public final m0 h() {
        v b3 = b();
        h hVar = this.f1324g;
        Size size = hVar != null ? hVar.f1405a : null;
        if (b3 == null || size == null) {
            return null;
        }
        Rect rect = this.f1326i;
        if (rect == null) {
            rect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        return new m0(g(b3, false), rect, size);
    }

    public final v i() {
        v vVar;
        synchronized (this.f1320b) {
            vVar = this.f1329l;
        }
        return vVar;
    }

    public Set j() {
        return Collections.EMPTY_SET;
    }

    public abstract z1 k(e0 e0Var);

    public final boolean l(v vVar) {
        int intValue = ((Integer) ((p0) this.f1323f).k(p0.f1469v0, -1)).intValue();
        if (intValue == -1 || intValue == 0) {
            return false;
        }
        if (intValue == 1) {
            return true;
        }
        if (intValue == 2) {
            return vVar.h().b() == 0;
        }
        throw new AssertionError(l0.j(intValue, "Unknown mirrorMode: "));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.camera.core.impl.e0, androidx.camera.core.impl.j1, java.lang.Object] */
    public final a2 m(u uVar, a2 a2Var, a2 a2Var2) {
        x0 f2;
        if (a2Var2 != null) {
            f2 = x0.i(a2Var2);
            f2.f1374a.remove(i.R0);
        } else {
            f2 = x0.f();
        }
        androidx.camera.core.impl.c cVar = p0.f1466s0;
        ?? r12 = this.e;
        boolean b3 = r12.b(cVar);
        TreeMap treeMap = f2.f1374a;
        if (b3 || r12.b(p0.f1470w0)) {
            androidx.camera.core.impl.c cVar2 = p0.A0;
            if (treeMap.containsKey(cVar2)) {
                treeMap.remove(cVar2);
            }
        }
        androidx.camera.core.impl.c cVar3 = p0.A0;
        if (r12.b(cVar3)) {
            androidx.camera.core.impl.c cVar4 = p0.f1472y0;
            if (treeMap.containsKey(cVar4) && ((f0.b) r12.e(cVar3)).f12639b != null) {
                treeMap.remove(cVar4);
            }
        }
        Iterator it = r12.g().iterator();
        while (it.hasNext()) {
            e0.M(f2, f2, r12, (androidx.camera.core.impl.c) it.next());
        }
        if (a2Var != null) {
            for (androidx.camera.core.impl.c cVar5 : a2Var.g()) {
                if (!cVar5.f1351a.equals(i.R0.f1351a)) {
                    e0.M(f2, f2, a2Var, cVar5);
                }
            }
        }
        if (treeMap.containsKey(p0.f1470w0)) {
            androidx.camera.core.impl.c cVar6 = p0.f1466s0;
            if (treeMap.containsKey(cVar6)) {
                treeMap.remove(cVar6);
            }
        }
        androidx.camera.core.impl.c cVar7 = p0.A0;
        if (treeMap.containsKey(cVar7)) {
            ((f0.b) f2.e(cVar7)).getClass();
        }
        return s(uVar, k(f2));
    }

    public final void n() {
        this.f1321c = UseCase$State.ACTIVE;
        p();
    }

    public final void o() {
        Iterator it = this.f1319a.iterator();
        while (it.hasNext()) {
            ((g1) it.next()).i(this);
        }
    }

    public final void p() {
        int ordinal = this.f1321c.ordinal();
        HashSet hashSet = this.f1319a;
        if (ordinal == 0) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((g1) it.next()).c(this);
            }
        } else {
            if (ordinal != 1) {
                return;
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                ((g1) it2.next()).j(this);
            }
        }
    }

    public void q() {
    }

    public void r() {
    }

    public abstract a2 s(u uVar, z1 z1Var);

    public void t() {
    }

    public void u() {
    }

    public abstract h v(m.b bVar);

    public abstract h w(h hVar, h hVar2);

    public abstract void x();

    public void y(Matrix matrix) {
        this.f1327j = new Matrix(matrix);
    }

    public void z(Rect rect) {
        this.f1326i = rect;
    }
}
