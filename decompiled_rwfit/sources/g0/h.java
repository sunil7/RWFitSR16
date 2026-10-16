package g0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import androidx.camera.core.impl.SessionConfig$SessionError;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.g0;
import androidx.camera.core.impl.p0;
import androidx.camera.core.impl.p1;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.v;
import c0.m;
import c0.n;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import n.s;
import t.g1;
import t.m0;

/* loaded from: classes.dex */
public final class h implements g1 {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f13773a;
    public final s e;

    /* renamed from: f, reason: collision with root package name */
    public final v f13777f;

    /* renamed from: g, reason: collision with root package name */
    public final v f13778g;

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f13780i;

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f13781j;

    /* renamed from: k, reason: collision with root package name */
    public final a f13782k;

    /* renamed from: l, reason: collision with root package name */
    public final a f13783l;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13774b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f13775c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f13776d = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final g f13779h = new g(this, 0);

    public h(v vVar, v vVar2, HashSet hashSet, s sVar, b9.a aVar) {
        this.f13777f = vVar;
        this.f13778g = vVar2;
        this.e = sVar;
        this.f13773a = hashSet;
        HashMap hashMap = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            androidx.camera.core.f fVar = (androidx.camera.core.f) it.next();
            hashMap.put(fVar, fVar.m(vVar.h(), null, fVar.e(true, sVar)));
        }
        this.f13781j = hashMap;
        HashSet hashSet2 = new HashSet(hashMap.values());
        this.f13780i = hashSet2;
        this.f13782k = new a(vVar, hashSet2);
        if (this.f13778g != null) {
            this.f13783l = new a(this.f13778g, hashSet2);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            androidx.camera.core.f fVar2 = (androidx.camera.core.f) it2.next();
            this.f13776d.put(fVar2, Boolean.FALSE);
            this.f13775c.put(fVar2, new f(vVar, this, aVar));
        }
    }

    public static void p(n nVar, g0 g0Var, s1 s1Var) {
        nVar.d();
        try {
            y5.a();
            nVar.a();
            m mVar = nVar.f3339l;
            Objects.requireNonNull(mVar);
            mVar.g(g0Var, new c0.j(mVar, 0));
        } catch (DeferrableSurface$SurfaceClosedException unused) {
            p1 p1Var = s1Var.f1489f;
            if (p1Var != null) {
                p1Var.a(s1Var, SessionConfig$SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        }
    }

    public static g0 q(androidx.camera.core.f fVar) {
        List b3 = fVar instanceof m0 ? fVar.f1330m.b() : Collections.unmodifiableList(fVar.f1330m.f1490g.f1366a);
        pd.f(null, b3.size() <= 1);
        if (b3.size() == 1) {
            return (g0) b3.get(0);
        }
        return null;
    }

    @Override // t.g1
    public final void c(androidx.camera.core.f fVar) {
        y5.a();
        if (r(fVar)) {
            return;
        }
        this.f13776d.put(fVar, Boolean.TRUE);
        g0 q5 = q(fVar);
        if (q5 != null) {
            n nVar = (n) this.f13774b.get(fVar);
            Objects.requireNonNull(nVar);
            p(nVar, q5, fVar.f1330m);
        }
    }

    @Override // t.g1
    public final void i(androidx.camera.core.f fVar) {
        g0 q5;
        y5.a();
        n nVar = (n) this.f13774b.get(fVar);
        Objects.requireNonNull(nVar);
        if (r(fVar) && (q5 = q(fVar)) != null) {
            p(nVar, q5, fVar.f1330m);
        }
    }

    @Override // t.g1
    public final void j(androidx.camera.core.f fVar) {
        y5.a();
        if (r(fVar)) {
            this.f13776d.put(fVar, Boolean.FALSE);
            n nVar = (n) this.f13774b.get(fVar);
            Objects.requireNonNull(nVar);
            y5.a();
            nVar.a();
            nVar.f3339l.a();
        }
    }

    @Override // t.g1
    public final void k(androidx.camera.core.f fVar) {
        y5.a();
        if (r(fVar)) {
            n nVar = (n) this.f13774b.get(fVar);
            Objects.requireNonNull(nVar);
            g0 q5 = q(fVar);
            if (q5 != null) {
                p(nVar, q5, fVar.f1330m);
                return;
            }
            y5.a();
            nVar.a();
            nVar.f3339l.a();
        }
    }

    public final e0.b o(androidx.camera.core.f fVar, a aVar, v vVar, n nVar, int i3, boolean z5) {
        Size size;
        Size size2;
        int f2 = vVar.h().f(i3);
        Matrix matrix = nVar.f3330b;
        RectF rectF = v.d.f19111a;
        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float f13 = fArr[3];
        float f14 = (f11 * f13) + (f10 * f12);
        float f15 = (f10 * f13) - (f11 * f12);
        float f16 = (f13 * f13) + (f12 * f12);
        boolean z6 = false;
        double sqrt = Math.sqrt((f11 * f11) + (f10 * f10)) * Math.sqrt(f16);
        boolean z8 = ((float) Math.toDegrees(Math.atan2(((double) f15) / sqrt, ((double) f14) / sqrt))) > 0.0f;
        a2 a2Var = (a2) this.f13781j.get(fVar);
        Objects.requireNonNull(a2Var);
        nVar.f3330b.getValues(new float[9]);
        int f17 = v.d.f((int) Math.round(Math.atan2(r7[3], r7[0]) * 57.29577951308232d));
        aVar.getClass();
        boolean b3 = v.d.b(f17);
        Rect rect = nVar.f3332d;
        if (b3) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
            z6 = true;
        }
        if (z5) {
            size2 = v.d.d(rect);
            Iterator it = aVar.b(a2Var).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Size d5 = v.d.d(a.a((Size) it.next(), size2));
                if (!a.c(d5, size2)) {
                    size2 = d5;
                    break;
                }
            }
        } else {
            Size d8 = v.d.d(rect);
            List b10 = aVar.b(a2Var);
            Iterator it2 = b10.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    Iterator it3 = b10.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            size = d8;
                            break;
                        }
                        Size size3 = (Size) it3.next();
                        if (!a.c(size3, d8)) {
                            size = size3;
                            break;
                        }
                    }
                } else {
                    size = (Size) it2.next();
                    Rational rational = v.b.f19106a;
                    if (!v.b.a(rational, d8)) {
                        rational = v.b.f19108c;
                        if (!v.b.a(rational, d8)) {
                            rational = a.g(d8);
                        }
                    }
                    if (!aVar.d(rational, size) && !a.c(size, d8)) {
                        break;
                    }
                }
            }
            rect = a.a(d8, size);
            size2 = size;
        }
        Pair pair = new Pair(rect, size2);
        Rect rect2 = (Rect) pair.first;
        Size size4 = (Size) pair.second;
        if (z6) {
            Size size5 = new Size(size4.getHeight(), size4.getWidth());
            rect2 = new Rect(rect2.top, rect2.left, rect2.bottom, rect2.right);
            size4 = size5;
        }
        Pair pair2 = new Pair(rect2, size4);
        Rect rect3 = (Rect) pair2.first;
        Size size6 = (Size) pair2.second;
        int f18 = this.f13777f.h().f(((p0) fVar.f1323f).n());
        f fVar2 = (f) this.f13775c.get(fVar);
        Objects.requireNonNull(fVar2);
        fVar2.f13769c.f13788c = f18;
        int f19 = v.d.f((nVar.f3336i + f18) - f2);
        return new e0.b(UUID.randomUUID(), fVar instanceof androidx.camera.core.c ? 1 : fVar instanceof m0 ? 4 : 2, fVar instanceof m0 ? 256 : 34, rect3, v.d.e(size6, f19), f19, fVar.l(vVar) ^ z8);
    }

    public final boolean r(androidx.camera.core.f fVar) {
        Boolean bool = (Boolean) this.f13776d.get(fVar);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    public final void s(HashMap hashMap) {
        HashMap hashMap2 = this.f13774b;
        hashMap2.clear();
        hashMap2.putAll(hashMap);
        for (Map.Entry entry : hashMap2.entrySet()) {
            androidx.camera.core.f fVar = (androidx.camera.core.f) entry.getKey();
            n nVar = (n) entry.getValue();
            fVar.z(nVar.f3332d);
            fVar.y(nVar.f3330b);
            fVar.f1324g = fVar.w(nVar.f3334g, null);
            fVar.p();
        }
    }
}
