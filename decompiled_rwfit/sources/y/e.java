package y;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.c2;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.e1;
import androidx.camera.core.impl.k1;
import androidx.camera.core.impl.l1;
import androidx.camera.core.impl.n0;
import androidx.camera.core.impl.o;
import androidx.camera.core.impl.o0;
import androidx.camera.core.impl.p0;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.x0;
import androidx.camera.core.internal.CameraUseCaseAdapter$CameraException;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import n.i0;
import n.s;
import t.j0;
import t.m;
import t.m0;
import t.r0;
import t.t;

/* loaded from: classes.dex */
public final class e implements m {

    /* renamed from: a, reason: collision with root package name */
    public final v f19838a;

    /* renamed from: b, reason: collision with root package name */
    public final v f19839b;

    /* renamed from: c, reason: collision with root package name */
    public final ef.i f19840c;

    /* renamed from: d, reason: collision with root package name */
    public final s f19841d;
    public final a e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f19842f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f19843g;

    /* renamed from: h, reason: collision with root package name */
    public final f8.f f19844h;

    /* renamed from: i, reason: collision with root package name */
    public List f19845i;

    /* renamed from: j, reason: collision with root package name */
    public final q f19846j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f19847k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f19848l;

    /* renamed from: m, reason: collision with root package name */
    public e0 f19849m;

    /* renamed from: n, reason: collision with root package name */
    public androidx.camera.core.f f19850n;

    /* renamed from: o, reason: collision with root package name */
    public g0.c f19851o;

    /* renamed from: p, reason: collision with root package name */
    public final k1 f19852p;

    /* renamed from: q, reason: collision with root package name */
    public final l1 f19853q;
    public final l1 r;

    /* renamed from: s, reason: collision with root package name */
    public final r0 f19854s;

    /* renamed from: t, reason: collision with root package name */
    public final r0 f19855t;

    public e(v vVar, v vVar2, l1 l1Var, l1 l1Var2, f8.f fVar, ef.i iVar, s sVar) {
        r0 r0Var = r0.f18382a;
        this.f19842f = new ArrayList();
        this.f19843g = new ArrayList();
        this.f19845i = Collections.EMPTY_LIST;
        this.f19847k = new Object();
        this.f19848l = true;
        this.f19849m = null;
        this.f19838a = vVar;
        this.f19839b = vVar2;
        this.f19854s = r0Var;
        this.f19855t = r0Var;
        this.f19844h = fVar;
        this.f19840c = iVar;
        this.f19841d = sVar;
        q qVar = l1Var.f1434c;
        this.f19846j = qVar;
        qVar.q();
        this.f19852p = new k1(vVar.m());
        this.f19853q = l1Var;
        this.r = l1Var2;
        this.e = s(l1Var, l1Var2);
    }

    public static Matrix k(Rect rect, Size size) {
        pd.a("Cannot compute viewport crop rects zero sized sensor rect.", rect.width() > 0 && rect.height() > 0);
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    public static m0 p() {
        Object obj;
        Object obj2;
        Object obj3;
        g0.d dVar = new g0.d(3);
        androidx.camera.core.impl.c cVar = i.R0;
        x0 x0Var = dVar.f13764b;
        x0Var.m(cVar, "ImageCapture-Extra");
        androidx.camera.core.impl.c cVar2 = n0.f1450d;
        x0Var.getClass();
        Object obj4 = null;
        try {
            obj = x0Var.e(cVar2);
        } catch (IllegalArgumentException unused) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            x0Var.m(o0.f1462q0, num);
        } else {
            j0 j0Var = m0.f18359x;
            try {
                obj2 = x0Var.e(n0.e);
            } catch (IllegalArgumentException unused2) {
                obj2 = null;
            }
            if (Objects.equals(obj2, 1)) {
                x0Var.m(o0.f1462q0, 4101);
                x0Var.m(o0.f1463r0, t.f18405c);
            } else {
                x0Var.m(o0.f1462q0, 256);
            }
        }
        n0 n0Var = new n0(d1.a(x0Var));
        p0.Q(n0Var);
        m0 m0Var = new m0(n0Var);
        try {
            obj3 = x0Var.e(p0.f1470w0);
        } catch (IllegalArgumentException unused3) {
            obj3 = null;
        }
        Size size = (Size) obj3;
        if (size != null) {
            new Rational(size.getWidth(), size.getHeight());
        }
        androidx.camera.core.impl.c cVar3 = f.Q0;
        Object c9 = a6.c();
        try {
            c9 = x0Var.e(cVar3);
        } catch (IllegalArgumentException unused4) {
        }
        pd.e((Executor) c9, "The IO executor can't be null");
        androidx.camera.core.impl.c cVar4 = n0.f1449c;
        if (x0Var.f1374a.containsKey(cVar4)) {
            Integer num2 = (Integer) x0Var.e(cVar4);
            if (num2 == null || !(num2.intValue() == 0 || num2.intValue() == 1 || num2.intValue() == 3 || num2.intValue() == 2)) {
                throw new IllegalArgumentException("The flash mode is not allowed to set: " + num2);
            }
            if (num2.intValue() == 3) {
                try {
                    obj4 = x0Var.e(n0.f1454i);
                } catch (IllegalArgumentException unused5) {
                }
                if (obj4 == null) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set to FLASH_MODE_SCREEN without setting ScreenFlash");
                }
            }
        }
        return m0Var;
    }

    public static a s(l1 l1Var, l1 l1Var2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l1Var.f1432a.c());
        sb2.append(l1Var2 == null ? "" : l1Var2.f1432a.c());
        return new a(sb2.toString(), l1Var.f1434c.f1474a);
    }

    public static HashMap t(ArrayList arrayList, c2 c2Var, s sVar) {
        a2 e;
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            androidx.camera.core.f fVar = (androidx.camera.core.f) obj;
            if (fVar instanceof g0.c) {
                g0.c cVar = (g0.c) fVar;
                e1 e1Var = new e1(d1.a(new m.a(1).f15876b));
                p0.Q(e1Var);
                androidx.camera.core.c cVar2 = new androidx.camera.core.c(e1Var);
                cVar2.f1308p = androidx.camera.core.c.f1306w;
                a2 e10 = cVar2.e(false, c2Var);
                if (e10 == null) {
                    e = null;
                } else {
                    x0 i10 = x0.i(e10);
                    i10.f1374a.remove(i.S0);
                    e = ((g0.d) cVar.k(i10)).b();
                }
            } else {
                e = fVar.e(false, c2Var);
            }
            a2 e11 = fVar.e(true, sVar);
            d dVar = new d();
            dVar.f19836a = e;
            dVar.f19837b = e11;
            hashMap.put(fVar, dVar);
        }
        return hashMap;
    }

    public static boolean x(androidx.camera.core.impl.h hVar, s1 s1Var) {
        d1 d1Var = s1Var.f1490g.f1367b;
        m.b bVar = hVar.f1408d;
        if (bVar.g().size() != s1Var.f1490g.f1367b.g().size()) {
            return true;
        }
        for (androidx.camera.core.impl.c cVar : bVar.g()) {
            if (!d1Var.f1374a.containsKey(cVar) || !Objects.equals(d1Var.e(cVar), bVar.e(cVar))) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList z(List list, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(list);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((androidx.camera.core.f) obj).getClass();
            Iterator it = list.iterator();
            if (it.hasNext()) {
                throw android.support.v4.media.session.e.d(it);
            }
        }
        return arrayList2;
    }

    public final void A(LinkedHashSet linkedHashSet, boolean z5) {
        int i3;
        HashMap hashMap;
        int i10;
        int i11;
        androidx.camera.core.impl.h hVar;
        m.b bVar;
        HashMap hashMap2;
        int i12;
        boolean z6;
        synchronized (this.f19847k) {
            w();
            synchronized (this.f19847k) {
                try {
                    if (!this.f19845i.isEmpty()) {
                        Iterator it = linkedHashSet.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z6 = false;
                                break;
                            }
                            androidx.camera.core.f fVar = (androidx.camera.core.f) it.next();
                            if (fVar instanceof m0) {
                                a2 a2Var = fVar.f1323f;
                                androidx.camera.core.impl.c cVar = n0.e;
                                if (a2Var.b(cVar)) {
                                    Integer num = (Integer) a2Var.e(cVar);
                                    num.getClass();
                                    if (num.intValue() == 1) {
                                        z6 = true;
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (z6) {
                            throw new IllegalArgumentException("Ultra HDR image capture does not support for use with CameraEffect.");
                        }
                    }
                } finally {
                }
            }
            if (!z5) {
                w();
            }
            g0.c q5 = q(linkedHashSet, z5);
            androidx.camera.core.f j4 = j(linkedHashSet, q5);
            ArrayList arrayList = new ArrayList(linkedHashSet);
            if (j4 != null) {
                arrayList.add(j4);
            }
            if (q5 != null) {
                arrayList.add(q5);
                arrayList.removeAll(q5.f13753p.f13773a);
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            arrayList2.removeAll(this.f19843g);
            ArrayList arrayList3 = new ArrayList(arrayList);
            arrayList3.retainAll(this.f19843g);
            ArrayList arrayList4 = new ArrayList(this.f19843g);
            arrayList4.removeAll(arrayList);
            HashMap t8 = t(arrayList2, (c2) this.f19846j.k(o.f1457l0, c2.f1361a), this.f19841d);
            Map map = Collections.EMPTY_MAP;
            try {
                synchronized (this.f19847k) {
                    try {
                        i3 = this.f19844h.f13516b == 2 ? 1 : 0;
                    } finally {
                    }
                }
                HashMap o3 = o(i3, this.f19838a.h(), arrayList2, arrayList3, t8);
                if (this.f19839b != null) {
                    synchronized (this.f19847k) {
                        try {
                            if (this.f19844h.f13516b == 2) {
                                hashMap2 = o3;
                                i12 = 1;
                            } else {
                                hashMap2 = o3;
                                i12 = 0;
                            }
                        } finally {
                        }
                    }
                    v vVar = this.f19839b;
                    Objects.requireNonNull(vVar);
                    hashMap = hashMap2;
                    map = o(i12, vVar.h(), arrayList2, arrayList3, t8);
                } else {
                    hashMap = o3;
                }
                B(hashMap, arrayList);
                ArrayList z8 = z(this.f19845i, arrayList);
                ArrayList arrayList5 = new ArrayList(linkedHashSet);
                arrayList5.removeAll(arrayList);
                ArrayList z10 = z(z8, arrayList5);
                if (z10.size() > 0) {
                    a0.e("CameraUseCaseAdapter", "Unused effects: " + z10);
                }
                int size = arrayList4.size();
                int i13 = 0;
                while (i13 < size) {
                    Object obj = arrayList4.get(i13);
                    i13++;
                    ((androidx.camera.core.f) obj).A(this.f19838a);
                }
                this.f19838a.d(arrayList4);
                if (this.f19839b != null) {
                    int size2 = arrayList4.size();
                    int i14 = 0;
                    while (i14 < size2) {
                        Object obj2 = arrayList4.get(i14);
                        i14++;
                        v vVar2 = this.f19839b;
                        Objects.requireNonNull(vVar2);
                        ((androidx.camera.core.f) obj2).A(vVar2);
                    }
                    v vVar3 = this.f19839b;
                    Objects.requireNonNull(vVar3);
                    vVar3.d(arrayList4);
                }
                if (arrayList4.isEmpty()) {
                    int size3 = arrayList3.size();
                    int i15 = 0;
                    while (i15 < size3) {
                        Object obj3 = arrayList3.get(i15);
                        i15++;
                        androidx.camera.core.f fVar2 = (androidx.camera.core.f) obj3;
                        if (!hashMap.containsKey(fVar2) || (bVar = (hVar = (androidx.camera.core.impl.h) hashMap.get(fVar2)).f1408d) == null) {
                            i11 = size3;
                        } else {
                            i11 = size3;
                            if (x(hVar, fVar2.f1330m)) {
                                fVar2.f1324g = fVar2.v(bVar);
                                if (this.f19848l) {
                                    this.f19838a.k(fVar2);
                                    v vVar4 = this.f19839b;
                                    if (vVar4 != null) {
                                        vVar4.k(fVar2);
                                    }
                                }
                            }
                        }
                        size3 = i11;
                    }
                }
                int size4 = arrayList2.size();
                int i16 = 0;
                while (i16 < size4) {
                    Object obj4 = arrayList2.get(i16);
                    i16++;
                    androidx.camera.core.f fVar3 = (androidx.camera.core.f) obj4;
                    d dVar = (d) t8.get(fVar3);
                    Objects.requireNonNull(dVar);
                    v vVar5 = this.f19839b;
                    if (vVar5 != null) {
                        i10 = size4;
                        fVar3.a(this.f19838a, vVar5, dVar.f19836a, dVar.f19837b);
                        androidx.camera.core.impl.h hVar2 = (androidx.camera.core.impl.h) hashMap.get(fVar3);
                        hVar2.getClass();
                        fVar3.f1324g = fVar3.w(hVar2, (androidx.camera.core.impl.h) map.get(fVar3));
                    } else {
                        i10 = size4;
                        fVar3.a(this.f19838a, null, dVar.f19836a, dVar.f19837b);
                        androidx.camera.core.impl.h hVar3 = (androidx.camera.core.impl.h) hashMap.get(fVar3);
                        hVar3.getClass();
                        fVar3.f1324g = fVar3.w(hVar3, null);
                    }
                    size4 = i10;
                }
                if (this.f19848l) {
                    this.f19838a.e(arrayList2);
                    v vVar6 = this.f19839b;
                    if (vVar6 != null) {
                        vVar6.e(arrayList2);
                    }
                }
                int size5 = arrayList2.size();
                int i17 = 0;
                while (i17 < size5) {
                    Object obj5 = arrayList2.get(i17);
                    i17++;
                    ((androidx.camera.core.f) obj5).p();
                }
                this.f19842f.clear();
                this.f19842f.addAll(linkedHashSet);
                this.f19843g.clear();
                this.f19843g.addAll(arrayList);
                this.f19850n = j4;
                this.f19851o = q5;
            } catch (IllegalArgumentException e) {
                if (!z5) {
                    w();
                    if (this.f19844h.f13516b != 2) {
                        A(linkedHashSet, true);
                        return;
                    }
                }
                throw e;
            }
        }
    }

    public final void B(HashMap hashMap, ArrayList arrayList) {
        synchronized (this.f19847k) {
            try {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    androidx.camera.core.f fVar = (androidx.camera.core.f) obj;
                    Rect g10 = this.f19838a.m().g();
                    androidx.camera.core.impl.h hVar = (androidx.camera.core.impl.h) hashMap.get(fVar);
                    hVar.getClass();
                    fVar.y(k(g10, hVar.f1405a));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c(Collection collection) {
        synchronized (this.f19847k) {
            try {
                this.f19838a.b(this.f19846j);
                v vVar = this.f19839b;
                if (vVar != null) {
                    vVar.b(this.f19846j);
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.f19842f);
                linkedHashSet.addAll(collection);
                try {
                    A(linkedHashSet, this.f19839b != null);
                } catch (IllegalArgumentException e) {
                    throw new CameraUseCaseAdapter$CameraException(e);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // t.m
    public final u getCameraInfo() {
        return this.f19853q;
    }

    public final void i() {
        synchronized (this.f19847k) {
            try {
                if (!this.f19848l) {
                    if (!this.f19843g.isEmpty()) {
                        this.f19838a.b(this.f19846j);
                        v vVar = this.f19839b;
                        if (vVar != null) {
                            vVar.b(this.f19846j);
                        }
                    }
                    this.f19838a.e(this.f19843g);
                    v vVar2 = this.f19839b;
                    if (vVar2 != null) {
                        vVar2.e(this.f19843g);
                    }
                    synchronized (this.f19847k) {
                        try {
                            if (this.f19849m != null) {
                                this.f19838a.m().e(this.f19849m);
                            }
                        } finally {
                        }
                    }
                    ArrayList arrayList = this.f19843g;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        ((androidx.camera.core.f) obj).p();
                    }
                    this.f19848l = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final androidx.camera.core.f j(LinkedHashSet linkedHashSet, g0.c cVar) {
        boolean z5;
        boolean z6;
        androidx.camera.core.f fVar;
        synchronized (this.f19847k) {
            try {
                ArrayList arrayList = new ArrayList(linkedHashSet);
                if (cVar != null) {
                    arrayList.add(cVar);
                    arrayList.removeAll(cVar.f13753p.f13773a);
                }
                synchronized (this.f19847k) {
                    z5 = false;
                    z6 = ((Integer) this.f19846j.k(o.f1458m0, 0)).intValue() == 1;
                }
                if (z6) {
                    int size = arrayList.size();
                    boolean z8 = false;
                    boolean z10 = false;
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        androidx.camera.core.f fVar2 = (androidx.camera.core.f) obj;
                        if (!(fVar2 instanceof androidx.camera.core.c) && !(fVar2 instanceof g0.c)) {
                            if (fVar2 instanceof m0) {
                                z8 = true;
                            }
                        }
                        z10 = true;
                    }
                    if (!z8 || z10) {
                        int size2 = arrayList.size();
                        boolean z11 = false;
                        int i10 = 0;
                        while (i10 < size2) {
                            Object obj2 = arrayList.get(i10);
                            i10++;
                            androidx.camera.core.f fVar3 = (androidx.camera.core.f) obj2;
                            if (!(fVar3 instanceof androidx.camera.core.c) && !(fVar3 instanceof g0.c)) {
                                if (fVar3 instanceof m0) {
                                    z11 = true;
                                }
                            }
                            z5 = true;
                        }
                        if (z5 && !z11) {
                            androidx.camera.core.f fVar4 = this.f19850n;
                            fVar = fVar4 instanceof m0 ? fVar4 : p();
                        }
                    } else {
                        androidx.camera.core.f fVar5 = this.f19850n;
                        if (!(fVar5 instanceof androidx.camera.core.c)) {
                            m.a aVar = new m.a(1);
                            aVar.f15876b.m(i.R0, "Preview-Extra");
                            e1 e1Var = new e1(d1.a(aVar.f15876b));
                            p0.Q(e1Var);
                            androidx.camera.core.c cVar2 = new androidx.camera.core.c(e1Var);
                            cVar2.f1308p = androidx.camera.core.c.f1306w;
                            cVar2.D(new n.x0(4));
                            fVar = cVar2;
                        }
                    }
                }
                fVar = null;
            } finally {
            }
        }
        return fVar;
    }

    public final HashMap o(int i3, u uVar, ArrayList arrayList, ArrayList arrayList2, HashMap hashMap) {
        ef.i iVar;
        Rect rect;
        boolean z5;
        ArrayList arrayList3 = new ArrayList();
        String c9 = uVar.c();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        Iterator it = arrayList2.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            iVar = this.f19840c;
            if (!hasNext) {
                break;
            }
            androidx.camera.core.f fVar = (androidx.camera.core.f) it.next();
            int A = fVar.f1323f.A();
            androidx.camera.core.impl.h hVar = fVar.f1324g;
            Size size = hVar != null ? hVar.f1405a : null;
            i0 i0Var = (i0) ((HashMap) iVar.f12629b).get(c9);
            androidx.camera.core.impl.i c10 = i0Var != null ? androidx.camera.core.impl.i.c(i3, A, size, i0Var.i(A)) : null;
            int A2 = fVar.f1323f.A();
            androidx.camera.core.impl.h hVar2 = fVar.f1324g;
            Size size2 = hVar2 != null ? hVar2.f1405a : null;
            hVar2.getClass();
            androidx.camera.core.impl.a aVar = new androidx.camera.core.impl.a(c10, A2, size2, hVar2.f1406b, g0.c.G(fVar), fVar.f1324g.f1408d, (Range) fVar.f1323f.k(a2.H0, null));
            arrayList3.add(aVar);
            hashMap3.put(aVar, fVar);
            hashMap2.put(fVar, fVar.f1324g);
        }
        if (!arrayList.isEmpty()) {
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            try {
                rect = this.f19838a.m().g();
            } catch (NullPointerException unused) {
                rect = null;
            }
            he.b bVar = new he.b(uVar, rect != null ? v.d.d(rect) : null);
            int size3 = arrayList.size();
            boolean z6 = false;
            int i10 = 0;
            while (i10 < size3) {
                Object obj = arrayList.get(i10);
                i10++;
                androidx.camera.core.f fVar2 = (androidx.camera.core.f) obj;
                d dVar = (d) hashMap.get(fVar2);
                ArrayList arrayList4 = arrayList3;
                a2 m10 = fVar2.m(uVar, dVar.f19836a, dVar.f19837b);
                hashMap4.put(m10, fVar2);
                hashMap5.put(m10, bVar.b(m10));
                a2 a2Var = fVar2.f1323f;
                if (a2Var instanceof e1) {
                    z6 = ((e1) a2Var).D() == 2;
                }
                arrayList3 = arrayList4;
            }
            ArrayList arrayList5 = arrayList3;
            int size4 = arrayList.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size4) {
                    z5 = false;
                    break;
                }
                Object obj2 = arrayList.get(i11);
                i11++;
                androidx.camera.core.f fVar3 = (androidx.camera.core.f) obj2;
                if (fVar3 != null) {
                    if (fVar3.f1323f.b(a2.K0)) {
                        if (fVar3.f1323f.p() == UseCaseConfigFactory$CaptureType.VIDEO_CAPTURE) {
                            z5 = true;
                            break;
                        }
                    } else {
                        Log.e("CameraUseCaseAdapter", fVar3 + " UseCase does not have capture type.");
                    }
                }
            }
            iVar.getClass();
            pd.a("No new use cases to be bound.", !hashMap5.isEmpty());
            i0 i0Var2 = (i0) ((HashMap) iVar.f12629b).get(c9);
            if (i0Var2 == null) {
                throw new IllegalArgumentException(l0.n("No such camera id in supported combination list: ", c9));
            }
            Pair g10 = i0Var2.g(i3, arrayList5, hashMap5, z6, z5);
            for (Map.Entry entry : hashMap4.entrySet()) {
                hashMap2.put((androidx.camera.core.f) entry.getValue(), (androidx.camera.core.impl.h) ((Map) g10.first).get(entry.getKey()));
            }
            for (Map.Entry entry2 : ((Map) g10.second).entrySet()) {
                if (hashMap3.containsKey(entry2.getKey())) {
                    hashMap2.put((androidx.camera.core.f) hashMap3.get(entry2.getKey()), (androidx.camera.core.impl.h) entry2.getValue());
                }
            }
        }
        return hashMap2;
    }

    public final g0.c q(LinkedHashSet linkedHashSet, boolean z5) {
        boolean z6;
        synchronized (this.f19847k) {
            try {
                HashSet u10 = u(linkedHashSet, z5);
                if (u10.size() < 2) {
                    w();
                    return null;
                }
                g0.c cVar = this.f19851o;
                if (cVar != null && cVar.f13753p.f13773a.equals(u10)) {
                    g0.c cVar2 = this.f19851o;
                    Objects.requireNonNull(cVar2);
                    return cVar2;
                }
                int[] iArr = {1, 2, 4};
                HashSet hashSet = new HashSet();
                Iterator it = u10.iterator();
                while (it.hasNext()) {
                    androidx.camera.core.f fVar = (androidx.camera.core.f) it.next();
                    for (int i3 = 0; i3 < 3; i3++) {
                        int i10 = iArr[i3];
                        Iterator it2 = fVar.j().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z6 = false;
                                break;
                            }
                            int intValue = ((Integer) it2.next()).intValue();
                            if ((i10 & intValue) == intValue) {
                                z6 = true;
                                break;
                            }
                        }
                        if (z6) {
                            if (hashSet.contains(Integer.valueOf(i10))) {
                                return null;
                            }
                            hashSet.add(Integer.valueOf(i10));
                        }
                    }
                }
                return new g0.c(this.f19838a, this.f19839b, this.f19854s, this.f19855t, u10, this.f19841d);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void r() {
        synchronized (this.f19847k) {
            try {
                if (this.f19848l) {
                    this.f19838a.d(new ArrayList(this.f19843g));
                    v vVar = this.f19839b;
                    if (vVar != null) {
                        vVar.d(new ArrayList(this.f19843g));
                    }
                    synchronized (this.f19847k) {
                        androidx.camera.core.impl.t m10 = this.f19838a.m();
                        this.f19849m = m10.a();
                        m10.d();
                    }
                    this.f19848l = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final HashSet u(LinkedHashSet linkedHashSet, boolean z5) {
        int i3;
        HashSet hashSet = new HashSet();
        synchronized (this.f19847k) {
            Iterator it = this.f19845i.iterator();
            if (it.hasNext()) {
                if (it.next() == null) {
                    throw null;
                }
                throw new ClassCastException();
            }
            i3 = z5 ? 3 : 0;
        }
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            androidx.camera.core.f fVar = (androidx.camera.core.f) it2.next();
            pd.a("Only support one level of sharing for now.", !(fVar instanceof g0.c));
            Iterator it3 = fVar.j().iterator();
            while (true) {
                if (it3.hasNext()) {
                    int intValue = ((Integer) it3.next()).intValue();
                    if ((i3 & intValue) == intValue) {
                        hashSet.add(fVar);
                        break;
                    }
                }
            }
        }
        return hashSet;
    }

    public final List v() {
        ArrayList arrayList;
        synchronized (this.f19847k) {
            arrayList = new ArrayList(this.f19842f);
        }
        return arrayList;
    }

    public final void w() {
        synchronized (this.f19847k) {
            this.f19846j.q();
        }
    }

    public final void y(ArrayList arrayList) {
        synchronized (this.f19847k) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.f19842f);
            linkedHashSet.removeAll(arrayList);
            A(linkedHashSet, this.f19839b != null);
        }
    }
}
