package g0;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.util.Log;
import android.util.Size;
import androidx.appcompat.app.i0;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.c0;
import androidx.camera.core.impl.c2;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.o0;
import androidx.camera.core.impl.o1;
import androidx.camera.core.impl.p0;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.x0;
import androidx.camera.core.impl.z1;
import androidx.camera.core.processing.SurfaceProcessorNode$Out;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode$Out;
import c0.n;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import de.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import n.s;
import t.f1;
import t.r0;

/* loaded from: classes.dex */
public final class c extends androidx.camera.core.f {
    public o1 A;

    /* renamed from: o, reason: collision with root package name */
    public final e f13752o;

    /* renamed from: p, reason: collision with root package name */
    public final h f13753p;

    /* renamed from: q, reason: collision with root package name */
    public final r0 f13754q;
    public final r0 r;

    /* renamed from: s, reason: collision with root package name */
    public o f13755s;

    /* renamed from: t, reason: collision with root package name */
    public androidx.camera.core.impl.e f13756t;

    /* renamed from: u, reason: collision with root package name */
    public n f13757u;

    /* renamed from: v, reason: collision with root package name */
    public n f13758v;

    /* renamed from: w, reason: collision with root package name */
    public n f13759w;

    /* renamed from: x, reason: collision with root package name */
    public n f13760x;

    /* renamed from: y, reason: collision with root package name */
    public n1 f13761y;

    /* renamed from: z, reason: collision with root package name */
    public n1 f13762z;

    public c(v vVar, v vVar2, r0 r0Var, r0 r0Var2, HashSet hashSet, s sVar) {
        super(H(hashSet));
        this.f13752o = H(hashSet);
        this.f13754q = r0Var;
        this.r = r0Var2;
        this.f13753p = new h(vVar, vVar2, hashSet, sVar, new b9.a(28));
    }

    public static ArrayList G(androidx.camera.core.f fVar) {
        ArrayList arrayList = new ArrayList();
        if (!(fVar instanceof c)) {
            arrayList.add(fVar.f1323f.p());
            return arrayList;
        }
        Iterator it = ((c) fVar).f13753p.f13773a.iterator();
        while (it.hasNext()) {
            arrayList.add(((androidx.camera.core.f) it.next()).f1323f.p());
        }
        return arrayList;
    }

    public static e H(HashSet hashSet) {
        x0 f2 = x0.f();
        new d(f2, 0);
        f2.m(o0.f1462q0, 34);
        ArrayList arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            androidx.camera.core.f fVar = (androidx.camera.core.f) it.next();
            if (fVar.f1323f.b(a2.K0)) {
                arrayList.add(fVar.f1323f.p());
            } else {
                Log.e("StreamSharing", "A child does not have capture type.");
            }
        }
        f2.m(e.f13765b, arrayList);
        f2.m(p0.f1469v0, 2);
        return new e(d1.a(f2));
    }

    public final void C() {
        o1 o1Var = this.A;
        if (o1Var != null) {
            o1Var.b();
            this.A = null;
        }
        n nVar = this.f13757u;
        if (nVar != null) {
            nVar.b();
            this.f13757u = null;
        }
        n nVar2 = this.f13758v;
        if (nVar2 != null) {
            nVar2.b();
            this.f13758v = null;
        }
        n nVar3 = this.f13759w;
        if (nVar3 != null) {
            nVar3.b();
            this.f13759w = null;
        }
        n nVar4 = this.f13760x;
        if (nVar4 != null) {
            nVar4.b();
            this.f13760x = null;
        }
        o oVar = this.f13755s;
        if (oVar != null) {
            ((c0.f) oVar.f12377b).e();
            y5.c(new androidx.activity.b(oVar, 13));
            this.f13755s = null;
        }
        androidx.camera.core.impl.e eVar = this.f13756t;
        if (eVar != null) {
            ((d0.e) eVar.f1378c).d();
            y5.c(new androidx.activity.b(eVar, 24));
            this.f13756t = null;
        }
    }

    public final List D(String str, String str2, a2 a2Var, androidx.camera.core.impl.h hVar, androidx.camera.core.impl.h hVar2) {
        boolean z5;
        y5.a();
        h hVar3 = this.f13753p;
        int i3 = 1;
        int i10 = 0;
        if (hVar2 == null) {
            E(str, str2, a2Var, hVar, null);
            v b3 = b();
            Objects.requireNonNull(b3);
            this.f13755s = new o(b3, new c0.f(hVar.f1406b));
            boolean z6 = this.f1326i != null;
            n nVar = this.f13759w;
            int n4 = ((p0) this.f1323f).n();
            hVar3.getClass();
            HashMap hashMap = new HashMap();
            Iterator it = hVar3.f13773a.iterator();
            while (it.hasNext()) {
                androidx.camera.core.f fVar = (androidx.camera.core.f) it.next();
                a aVar = hVar3.f13782k;
                v vVar = hVar3.f13777f;
                h hVar4 = hVar3;
                boolean z8 = z6;
                hashMap.put(fVar, hVar4.o(fVar, aVar, vVar, nVar, n4, z8));
                z6 = z8;
                hVar3 = hVar4;
            }
            h hVar5 = hVar3;
            o oVar = this.f13755s;
            n nVar2 = this.f13759w;
            ArrayList arrayList = new ArrayList(hashMap.values());
            if (nVar2 == null) {
                throw new NullPointerException("Null surfaceEdge");
            }
            oVar.getClass();
            y5.a();
            oVar.f12379d = new HashMap<e0.b, n>() { // from class: androidx.camera.core.processing.SurfaceProcessorNode$Out
            };
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                int i12 = i11 + i3;
                e0.b bVar = (e0.b) obj;
                SurfaceProcessorNode$Out surfaceProcessorNode$Out = (SurfaceProcessorNode$Out) oVar.f12379d;
                Rect rect = bVar.f12414d;
                Matrix matrix = new Matrix(nVar2.f3330b);
                RectF rectF = new RectF(rect);
                RectF rectF2 = v.d.f19111a;
                ArrayList arrayList2 = arrayList;
                float f2 = i10;
                Size size2 = bVar.e;
                int i13 = size;
                RectF rectF3 = new RectF(f2, f2, size2.getWidth(), size2.getHeight());
                int i14 = bVar.f12415f;
                boolean z10 = bVar.f12416g;
                matrix.postConcat(v.d.a(rectF, rectF3, i14, z10));
                pd.b(v.d.c(v.d.e(v.d.d(rect), i14), false, size2));
                Rect rect2 = new Rect(0, 0, size2.getWidth(), size2.getHeight());
                androidx.camera.core.impl.e a3 = nVar2.f3334g.a();
                a3.f1378c = size2;
                surfaceProcessorNode$Out.put(bVar, new n(bVar.f12412b, bVar.f12413c, a3.b(), matrix, false, rect2, nVar2.f3336i - i14, -1, nVar2.e != z10));
                arrayList = arrayList2;
                size = i13;
                i11 = i12;
                i3 = 1;
                i10 = 0;
            }
            try {
                c0.f fVar2 = (c0.f) oVar.f12377b;
                f1 c9 = nVar2.c((v) oVar.f12378c, true);
                if (fVar2.e.get()) {
                    c9.c();
                } else {
                    fVar2.b(new i0(6, fVar2, c9), new c0.c(c9, 0));
                }
            } catch (ProcessingException e) {
                a0.c("SurfaceProcessorNode", "Failed to send SurfaceRequest to SurfaceProcessor.", e);
            }
            for (Map.Entry<e0.b, n> entry : ((SurfaceProcessorNode$Out) oVar.f12379d).entrySet()) {
                oVar.j(nVar2, entry);
                n value = entry.getValue();
                androidx.camera.camera2.internal.compat.h hVar6 = new androidx.camera.camera2.internal.compat.h(oVar, 5, nVar2, entry);
                value.getClass();
                y5.a();
                value.a();
                value.f3340m.add(hVar6);
            }
            nVar2.f3342o.add(new androidx.activity.k((SurfaceProcessorNode$Out) oVar.f12379d, 1));
            SurfaceProcessorNode$Out surfaceProcessorNode$Out2 = (SurfaceProcessorNode$Out) oVar.f12379d;
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : hashMap.entrySet()) {
                hashMap2.put((androidx.camera.core.f) entry2.getKey(), surfaceProcessorNode$Out2.get(entry2.getValue()));
            }
            hVar5.s(hashMap2);
            Object[] objArr = {this.f13761y.c()};
            ArrayList arrayList3 = new ArrayList(1);
            Object obj2 = objArr[0];
            Objects.requireNonNull(obj2);
            arrayList3.add(obj2);
            return Collections.unmodifiableList(arrayList3);
        }
        E(str, str2, a2Var, hVar, hVar2);
        Matrix matrix2 = this.f1327j;
        v i15 = i();
        Objects.requireNonNull(i15);
        boolean f10 = i15.f();
        Rect rect3 = this.f1326i;
        if (rect3 != null) {
            z5 = false;
        } else {
            Size size3 = hVar2.f1405a;
            z5 = false;
            rect3 = new Rect(0, 0, size3.getWidth(), size3.getHeight());
        }
        Rect rect4 = rect3;
        v i16 = i();
        Objects.requireNonNull(i16);
        int g10 = g(i16, z5);
        v i17 = i();
        Objects.requireNonNull(i17);
        h hVar7 = hVar3;
        n nVar3 = new n(3, 34, hVar2, matrix2, f10, rect4, g10, -1, l(i17));
        this.f13758v = nVar3;
        Objects.requireNonNull(i());
        this.f13760x = nVar3;
        n1 F = F(this.f13758v, a2Var, hVar2);
        this.f13762z = F;
        o1 o1Var = this.A;
        if (o1Var != null) {
            o1Var.b();
        }
        o1 o1Var2 = new o1(new b(this, str, str2, a2Var, hVar, hVar2));
        this.A = o1Var2;
        F.f1445f = o1Var2;
        this.f13756t = new androidx.camera.core.impl.e(b(), i(), new d0.e(hVar.f1406b, this.f13754q, this.r));
        boolean z11 = this.f1326i != null;
        n nVar4 = this.f13759w;
        n nVar5 = this.f13760x;
        int n8 = ((p0) this.f1323f).n();
        hVar7.getClass();
        HashMap hashMap3 = new HashMap();
        Iterator it2 = hVar7.f13773a.iterator();
        while (it2.hasNext()) {
            androidx.camera.core.f fVar3 = (androidx.camera.core.f) it2.next();
            h hVar8 = hVar7;
            e0.b o3 = hVar8.o(fVar3, hVar7.f13782k, hVar7.f13777f, nVar4, n8, z11);
            n nVar6 = nVar4;
            v vVar2 = hVar8.f13778g;
            Objects.requireNonNull(vVar2);
            n nVar7 = nVar5;
            hashMap3.put(fVar3, new d0.a(o3, hVar8.o(fVar3, hVar8.f13783l, vVar2, nVar7, n8, z11)));
            hVar7 = hVar8;
            nVar5 = nVar7;
            nVar4 = nVar6;
        }
        h hVar9 = hVar7;
        androidx.camera.core.impl.e eVar = this.f13756t;
        d0.b bVar2 = new d0.b(this.f13759w, this.f13760x, new ArrayList(hashMap3.values()));
        eVar.getClass();
        d0.e eVar2 = (d0.e) eVar.f1378c;
        y5.a();
        eVar.f1377b = bVar2;
        eVar.f1380f = new HashMap<d0.a, n>() { // from class: androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode$Out
        };
        d0.b bVar3 = (d0.b) eVar.f1377b;
        n nVar8 = bVar3.f12178a;
        ArrayList arrayList4 = bVar3.f12180c;
        int size4 = arrayList4.size();
        int i18 = 0;
        while (i18 < size4) {
            Object obj3 = arrayList4.get(i18);
            int i19 = i18 + 1;
            d0.a aVar2 = (d0.a) obj3;
            DualSurfaceProcessorNode$Out dualSurfaceProcessorNode$Out = (DualSurfaceProcessorNode$Out) eVar.f1380f;
            e0.b bVar4 = aVar2.f12176a;
            Matrix matrix3 = new Matrix();
            Size d5 = v.d.d(bVar4.f12414d);
            ArrayList arrayList5 = arrayList4;
            int i20 = bVar4.f12415f;
            Size e10 = v.d.e(d5, i20);
            Size size5 = bVar4.e;
            int i21 = size4;
            pd.b(v.d.c(e10, false, size5));
            HashMap hashMap4 = hashMap3;
            Rect rect5 = new Rect(0, 0, size5.getWidth(), size5.getHeight());
            androidx.camera.core.impl.e a10 = nVar8.f3334g.a();
            a10.f1378c = size5;
            dualSurfaceProcessorNode$Out.put(aVar2, new n(bVar4.f12412b, bVar4.f12413c, a10.b(), matrix3, false, rect5, nVar8.f3336i - i20, -1, nVar8.e != bVar4.f12416g));
            size4 = i21;
            i18 = i19;
            hashMap3 = hashMap4;
            arrayList4 = arrayList5;
        }
        HashMap hashMap5 = hashMap3;
        try {
            eVar2.c(nVar8.c((v) eVar.f1379d, true));
        } catch (ProcessingException e11) {
            a0.c("DualSurfaceProcessorNode", "Failed to send SurfaceRequest to SurfaceProcessor.", e11);
        }
        n nVar9 = bVar3.f12179b;
        try {
            eVar2.c(nVar9.c((v) eVar.e, false));
        } catch (ProcessingException e12) {
            a0.c("DualSurfaceProcessorNode", "Failed to send SurfaceRequest to SurfaceProcessor.", e12);
        }
        for (Map.Entry<d0.a, n> entry3 : ((DualSurfaceProcessorNode$Out) eVar.f1380f).entrySet()) {
            v vVar3 = (v) eVar.f1379d;
            v vVar4 = (v) eVar.e;
            n nVar10 = nVar9;
            n nVar11 = nVar8;
            eVar.c(vVar3, vVar4, nVar11, nVar10, entry3);
            n value2 = entry3.getValue();
            androidx.camera.core.impl.e eVar3 = eVar;
            n.k kVar = new n.k(eVar3, vVar3, vVar4, nVar11, nVar10, entry3, 2);
            eVar = eVar3;
            value2.getClass();
            y5.a();
            value2.a();
            value2.f3340m.add(kVar);
            nVar8 = nVar11;
            nVar9 = nVar10;
        }
        DualSurfaceProcessorNode$Out dualSurfaceProcessorNode$Out2 = (DualSurfaceProcessorNode$Out) eVar.f1380f;
        HashMap hashMap6 = new HashMap();
        for (Map.Entry entry4 : hashMap5.entrySet()) {
            hashMap6.put((androidx.camera.core.f) entry4.getKey(), dualSurfaceProcessorNode$Out2.get(entry4.getValue()));
        }
        hVar9.s(hashMap6);
        Object[] objArr2 = {this.f13761y.c(), this.f13762z.c()};
        ArrayList arrayList6 = new ArrayList(2);
        for (int i22 = 0; i22 < 2; i22++) {
            Object obj4 = objArr2[i22];
            Objects.requireNonNull(obj4);
            arrayList6.add(obj4);
        }
        return Collections.unmodifiableList(arrayList6);
    }

    public final void E(String str, String str2, a2 a2Var, androidx.camera.core.impl.h hVar, androidx.camera.core.impl.h hVar2) {
        Matrix matrix = this.f1327j;
        v b3 = b();
        Objects.requireNonNull(b3);
        boolean f2 = b3.f();
        Size size = hVar.f1405a;
        Rect rect = this.f1326i;
        if (rect == null) {
            rect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        v b10 = b();
        Objects.requireNonNull(b10);
        int g10 = g(b10, false);
        v b11 = b();
        Objects.requireNonNull(b11);
        n nVar = new n(3, 34, hVar, matrix, f2, rect, g10, -1, l(b11));
        this.f13757u = nVar;
        Objects.requireNonNull(b());
        this.f13759w = nVar;
        n1 F = F(this.f13757u, a2Var, hVar);
        this.f13761y = F;
        o1 o1Var = this.A;
        if (o1Var != null) {
            o1Var.b();
        }
        o1 o1Var2 = new o1(new b(this, str, str2, a2Var, hVar, hVar2));
        this.A = o1Var2;
        F.f1445f = o1Var2;
    }

    public final n1 F(n nVar, a2 a2Var, androidx.camera.core.impl.h hVar) {
        n1 d5 = n1.d(a2Var, hVar.f1405a);
        h hVar2 = this.f13753p;
        Iterator it = hVar2.f13773a.iterator();
        int i3 = -1;
        while (it.hasNext()) {
            int i10 = ((s1) ((androidx.camera.core.f) it.next()).f1323f.e(a2.C0)).f1490g.f1368c;
            Integer valueOf = Integer.valueOf(i3);
            List list = s1.f1484i;
            if (list.indexOf(valueOf) < list.indexOf(Integer.valueOf(i10))) {
                i3 = i10;
            }
        }
        c0 c0Var = d5.f1442b;
        if (i3 != -1) {
            c0Var.f1356c = i3;
        }
        Iterator it2 = hVar2.f13773a.iterator();
        while (it2.hasNext()) {
            s1 c9 = n1.d(((androidx.camera.core.f) it2.next()).f1323f, hVar.f1405a).c();
            d0 d0Var = c9.f1490g;
            c0Var.a(d0Var.f1369d);
            for (androidx.camera.core.impl.k kVar : c9.e) {
                c0Var.b(kVar);
                ArrayList arrayList = d5.e;
                if (!arrayList.contains(kVar)) {
                    arrayList.add(kVar);
                }
            }
            for (CameraCaptureSession.StateCallback stateCallback : c9.f1488d) {
                ArrayList arrayList2 = d5.f1444d;
                if (!arrayList2.contains(stateCallback)) {
                    arrayList2.add(stateCallback);
                }
            }
            for (CameraDevice.StateCallback stateCallback2 : c9.f1487c) {
                ArrayList arrayList3 = d5.f1443c;
                if (!arrayList3.contains(stateCallback2)) {
                    arrayList3.add(stateCallback2);
                }
            }
            c0Var.c(d0Var.f1367b);
        }
        nVar.getClass();
        y5.a();
        nVar.a();
        pd.f("Consumer can only be linked once.", !nVar.f3337j);
        nVar.f3337j = true;
        d5.b(nVar.f3339l, hVar.f1406b, -1);
        c0Var.b(hVar2.f13779h);
        m.b bVar = hVar.f1408d;
        if (bVar != null) {
            c0Var.c(bVar);
        }
        return d5;
    }

    @Override // androidx.camera.core.f
    public final a2 e(boolean z5, c2 c2Var) {
        e eVar = this.f13752o;
        e0 a3 = c2Var.a(eVar.p(), 1);
        if (z5) {
            a3 = e0.t(a3, eVar.f13766a);
        }
        if (a3 == null) {
            return null;
        }
        return ((d) k(a3)).b();
    }

    @Override // androidx.camera.core.f
    public final Set j() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    @Override // androidx.camera.core.f
    public final z1 k(e0 e0Var) {
        return new d(x0.i(e0Var), 0);
    }

    @Override // androidx.camera.core.f
    public final void q() {
        h hVar = this.f13753p;
        Iterator it = hVar.f13773a.iterator();
        while (it.hasNext()) {
            androidx.camera.core.f fVar = (androidx.camera.core.f) it.next();
            f fVar2 = (f) hVar.f13775c.get(fVar);
            Objects.requireNonNull(fVar2);
            fVar.a(fVar2, null, null, fVar.e(true, hVar.e));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01dc  */
    @Override // androidx.camera.core.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.camera.core.impl.a2 s(androidx.camera.core.impl.u r13, androidx.camera.core.impl.z1 r14) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.c.s(androidx.camera.core.impl.u, androidx.camera.core.impl.z1):androidx.camera.core.impl.a2");
    }

    @Override // androidx.camera.core.f
    public final void t() {
        Iterator it = this.f13753p.f13773a.iterator();
        while (it.hasNext()) {
            androidx.camera.core.f fVar = (androidx.camera.core.f) it.next();
            fVar.t();
            fVar.r();
        }
    }

    @Override // androidx.camera.core.f
    public final void u() {
        Iterator it = this.f13753p.f13773a.iterator();
        while (it.hasNext()) {
            ((androidx.camera.core.f) it.next()).u();
        }
    }

    @Override // androidx.camera.core.f
    public final androidx.camera.core.impl.h v(m.b bVar) {
        this.f13761y.a(bVar);
        Object[] objArr = {this.f13761y.c()};
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
        B(D(d(), i() == null ? null : i().h().c(), this.f1323f, hVar, hVar2));
        n();
        return hVar;
    }

    @Override // androidx.camera.core.f
    public final void x() {
        C();
        h hVar = this.f13753p;
        Iterator it = hVar.f13773a.iterator();
        while (it.hasNext()) {
            androidx.camera.core.f fVar = (androidx.camera.core.f) it.next();
            f fVar2 = (f) hVar.f13775c.get(fVar);
            Objects.requireNonNull(fVar2);
            fVar.A(fVar2);
        }
    }
}
