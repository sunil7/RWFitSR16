package t;

import android.util.Log;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.c2;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.o1;
import androidx.camera.core.impl.q1;
import androidx.camera.core.impl.z1;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class m0 extends androidx.camera.core.f {

    /* renamed from: x, reason: collision with root package name */
    public static final j0 f18359x = new j0();

    /* renamed from: o, reason: collision with root package name */
    public final int f18360o;

    /* renamed from: p, reason: collision with root package name */
    public final AtomicReference f18361p;

    /* renamed from: q, reason: collision with root package name */
    public final int f18362q;
    public final y.g r;

    /* renamed from: s, reason: collision with root package name */
    public n1 f18363s;

    /* renamed from: t, reason: collision with root package name */
    public u.d f18364t;

    /* renamed from: u, reason: collision with root package name */
    public u.e f18365u;

    /* renamed from: v, reason: collision with root package name */
    public o1 f18366v;

    /* renamed from: w, reason: collision with root package name */
    public final r0 f18367w;

    public m0(androidx.camera.core.impl.n0 n0Var) {
        super(n0Var);
        this.f18361p = new AtomicReference(null);
        this.f18362q = -1;
        this.f18367w = new r0();
        androidx.camera.core.impl.n0 n0Var2 = (androidx.camera.core.impl.n0) this.f1323f;
        androidx.camera.core.impl.c cVar = androidx.camera.core.impl.n0.f1448b;
        if (n0Var2.b(cVar)) {
            this.f18360o = ((Integer) n0Var2.e(cVar)).intValue();
        } else {
            this.f18360o = 1;
        }
        ((Integer) n0Var2.k(androidx.camera.core.impl.n0.f1453h, 0)).getClass();
        this.r = new y.g((k0) n0Var2.k(androidx.camera.core.impl.n0.f1454i, null));
    }

    public static boolean F(int i3, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) ((Pair) it.next()).first).equals(Integer.valueOf(i3))) {
                return true;
            }
        }
        return false;
    }

    public final void C(boolean z5) {
        u.e eVar;
        Log.d("ImageCapture", "clearPipeline");
        y5.a();
        o1 o1Var = this.f18366v;
        if (o1Var != null) {
            o1Var.b();
            this.f18366v = null;
        }
        u.d dVar = this.f18364t;
        if (dVar != null) {
            dVar.a();
            this.f18364t = null;
        }
        if (z5 || (eVar = this.f18365u) == null) {
            return;
        }
        eVar.b();
        this.f18365u = null;
    }

    public final n1 D(String str, androidx.camera.core.impl.n0 n0Var, androidx.camera.core.impl.h hVar) {
        y5.a();
        Log.d("ImageCapture", "createPipeline(cameraId: " + str + ", streamSpec: " + hVar + ")");
        Size size = hVar.f1405a;
        androidx.camera.core.impl.v b3 = b();
        Objects.requireNonNull(b3);
        boolean f2 = b3.f() ^ true;
        if (this.f18364t != null) {
            pd.f(null, f2);
            this.f18364t.a();
        }
        if (((Boolean) this.f1323f.k(androidx.camera.core.impl.n0.f1455j, Boolean.FALSE)).booleanValue()) {
            b().n().q();
        }
        this.f18364t = new u.d(n0Var, size, f2);
        if (this.f18365u == null) {
            this.f18365u = new u.e(this.f18367w);
        }
        u.e eVar = this.f18365u;
        u.d dVar = this.f18364t;
        eVar.getClass();
        y5.a();
        eVar.f18663b = dVar;
        dVar.setOnImageCloseListener(eVar);
        u.d dVar2 = this.f18364t;
        n1 d5 = n1.d(dVar2.f18658a, hVar.f1405a);
        u.a aVar = dVar2.f18661d;
        androidx.camera.core.impl.s0 s0Var = aVar.f18649a;
        Objects.requireNonNull(s0Var);
        t tVar = t.f18406d;
        androidx.camera.core.impl.e a3 = androidx.camera.core.impl.f.a(s0Var);
        a3.f1377b = tVar;
        d5.f1441a.add(a3.a());
        androidx.camera.core.impl.s0 s0Var2 = aVar.f18650b;
        if (s0Var2 != null) {
            d5.f1447h = androidx.camera.core.impl.f.a(s0Var2).a();
        }
        if (this.f18360o == 2 && !hVar.e) {
            c().i(d5);
        }
        m.b bVar = hVar.f1408d;
        if (bVar != null) {
            d5.f1442b.c(bVar);
        }
        o1 o1Var = this.f18366v;
        if (o1Var != null) {
            o1Var.b();
        }
        o1 o1Var2 = new o1(new q1(this, 3));
        this.f18366v = o1Var2;
        d5.f1445f = o1Var2;
        return d5;
    }

    public final int E() {
        int i3;
        synchronized (this.f18361p) {
            i3 = this.f18362q;
            if (i3 == -1) {
                i3 = ((Integer) ((androidx.camera.core.impl.n0) this.f1323f).k(androidx.camera.core.impl.n0.f1449c, 2)).intValue();
            }
        }
        return i3;
    }

    @Override // androidx.camera.core.f
    public final a2 e(boolean z5, c2 c2Var) {
        f18359x.getClass();
        androidx.camera.core.impl.n0 n0Var = j0.f18351a;
        androidx.camera.core.impl.e0 a3 = c2Var.a(n0Var.p(), this.f18360o);
        if (z5) {
            a3 = androidx.camera.core.impl.e0.t(a3, n0Var);
        }
        if (a3 == null) {
            return null;
        }
        return new androidx.camera.core.impl.n0(androidx.camera.core.impl.d1.a(((g0.d) k(a3)).f13764b));
    }

    @Override // androidx.camera.core.f
    public final Set j() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        return hashSet;
    }

    @Override // androidx.camera.core.f
    public final z1 k(androidx.camera.core.impl.e0 e0Var) {
        return new g0.d(androidx.camera.core.impl.x0.i(e0Var), 3);
    }

    @Override // androidx.camera.core.f
    public final void q() {
        pd.e(b(), "Attached camera cannot be null");
        if (E() == 3) {
            androidx.camera.core.impl.v b3 = b();
            if ((b3 != null ? b3.h().b() : -1) != 0) {
                throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
            }
        }
    }

    @Override // androidx.camera.core.f
    public final void r() {
        com.google.android.gms.internal.mlkit_vision_common.a0.a("ImageCapture", "onCameraControlReady");
        synchronized (this.f18361p) {
            try {
                if (this.f18361p.get() == null) {
                    c().h(E());
                }
            } finally {
            }
        }
        c().c(this.r);
    }

    @Override // androidx.camera.core.f
    public final a2 s(androidx.camera.core.impl.u uVar, z1 z1Var) {
        Object obj;
        Object obj2;
        Object obj3;
        if (uVar.i().d(SoftwareJpegEncodingPreferredQuirk.class)) {
            Boolean bool = Boolean.FALSE;
            androidx.camera.core.impl.e0 a3 = z1Var.a();
            androidx.camera.core.impl.c cVar = androidx.camera.core.impl.n0.f1452g;
            Object obj4 = Boolean.TRUE;
            androidx.camera.core.impl.d1 d1Var = (androidx.camera.core.impl.d1) a3;
            d1Var.getClass();
            try {
                obj4 = d1Var.e(cVar);
            } catch (IllegalArgumentException unused) {
            }
            if (bool.equals(obj4)) {
                com.google.android.gms.internal.mlkit_vision_common.a0.e("ImageCapture", "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                if (com.google.android.gms.internal.mlkit_vision_common.a0.d(4, "ImageCapture")) {
                    Log.i("ImageCapture", "Requesting software JPEG due to device quirk.");
                }
                ((androidx.camera.core.impl.x0) z1Var.a()).m(androidx.camera.core.impl.n0.f1452g, Boolean.TRUE);
            }
        }
        androidx.camera.core.impl.e0 a10 = z1Var.a();
        Boolean bool2 = Boolean.TRUE;
        androidx.camera.core.impl.c cVar2 = androidx.camera.core.impl.n0.f1452g;
        Object obj5 = Boolean.FALSE;
        androidx.camera.core.impl.d1 d1Var2 = (androidx.camera.core.impl.d1) a10;
        d1Var2.getClass();
        try {
            obj5 = d1Var2.e(cVar2);
        } catch (IllegalArgumentException unused2) {
        }
        boolean equals = bool2.equals(obj5);
        Object obj6 = null;
        boolean z5 = false;
        if (equals) {
            if (b() != null) {
                b().n().q();
            }
            try {
                obj3 = d1Var2.e(androidx.camera.core.impl.n0.f1450d);
            } catch (IllegalArgumentException unused3) {
                obj3 = null;
            }
            Integer num = (Integer) obj3;
            if (num == null || num.intValue() == 256) {
                z5 = true;
            } else {
                com.google.android.gms.internal.mlkit_vision_common.a0.e("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z5) {
                com.google.android.gms.internal.mlkit_vision_common.a0.e("ImageCapture", "Unable to support software JPEG. Disabling.");
                ((androidx.camera.core.impl.x0) a10).m(androidx.camera.core.impl.n0.f1452g, Boolean.FALSE);
            }
        }
        androidx.camera.core.impl.e0 a11 = z1Var.a();
        androidx.camera.core.impl.c cVar3 = androidx.camera.core.impl.n0.f1450d;
        androidx.camera.core.impl.d1 d1Var3 = (androidx.camera.core.impl.d1) a11;
        d1Var3.getClass();
        try {
            obj = d1Var3.e(cVar3);
        } catch (IllegalArgumentException unused4) {
            obj = null;
        }
        Integer num2 = (Integer) obj;
        if (num2 != null) {
            if (b() != null) {
                b().n().q();
            }
            ((androidx.camera.core.impl.x0) z1Var.a()).m(androidx.camera.core.impl.o0.f1462q0, Integer.valueOf(z5 ? 35 : num2.intValue()));
        } else {
            androidx.camera.core.impl.e0 a12 = z1Var.a();
            androidx.camera.core.impl.c cVar4 = androidx.camera.core.impl.n0.e;
            androidx.camera.core.impl.d1 d1Var4 = (androidx.camera.core.impl.d1) a12;
            d1Var4.getClass();
            try {
                obj2 = d1Var4.e(cVar4);
            } catch (IllegalArgumentException unused5) {
                obj2 = null;
            }
            if (Objects.equals(obj2, 1)) {
                ((androidx.camera.core.impl.x0) z1Var.a()).m(androidx.camera.core.impl.o0.f1462q0, 4101);
                ((androidx.camera.core.impl.x0) z1Var.a()).m(androidx.camera.core.impl.o0.f1463r0, t.f18405c);
            } else if (z5) {
                ((androidx.camera.core.impl.x0) z1Var.a()).m(androidx.camera.core.impl.o0.f1462q0, 35);
            } else {
                androidx.camera.core.impl.e0 a13 = z1Var.a();
                androidx.camera.core.impl.c cVar5 = androidx.camera.core.impl.p0.f1473z0;
                androidx.camera.core.impl.d1 d1Var5 = (androidx.camera.core.impl.d1) a13;
                d1Var5.getClass();
                try {
                    obj6 = d1Var5.e(cVar5);
                } catch (IllegalArgumentException unused6) {
                }
                List list = (List) obj6;
                if (list == null) {
                    ((androidx.camera.core.impl.x0) z1Var.a()).m(androidx.camera.core.impl.o0.f1462q0, 256);
                } else if (F(256, list)) {
                    ((androidx.camera.core.impl.x0) z1Var.a()).m(androidx.camera.core.impl.o0.f1462q0, 256);
                } else if (F(35, list)) {
                    ((androidx.camera.core.impl.x0) z1Var.a()).m(androidx.camera.core.impl.o0.f1462q0, 35);
                }
            }
        }
        return z1Var.b();
    }

    public final String toString() {
        return "ImageCapture:".concat(f());
    }

    @Override // androidx.camera.core.f
    public final void u() {
        y.g gVar = this.r;
        gVar.b();
        gVar.a();
        u.e eVar = this.f18365u;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // androidx.camera.core.f
    public final androidx.camera.core.impl.h v(m.b bVar) {
        this.f18363s.a(bVar);
        Object[] objArr = {this.f18363s.c()};
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
        n1 D = D(d(), (androidx.camera.core.impl.n0) this.f1323f, hVar);
        this.f18363s = D;
        Object[] objArr = {D.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        B(Collections.unmodifiableList(arrayList));
        n();
        return hVar;
    }

    @Override // androidx.camera.core.f
    public final void x() {
        y.g gVar = this.r;
        gVar.b();
        gVar.a();
        u.e eVar = this.f18365u;
        if (eVar != null) {
            eVar.b();
        }
        C(false);
        c().c(null);
    }
}
