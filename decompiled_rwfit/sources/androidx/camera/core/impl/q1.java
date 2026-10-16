package androidx.camera.core.impl;

import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final /* synthetic */ class q1 implements p1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1475a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1476b;

    public /* synthetic */ q1(Object obj, int i3) {
        this.f1475a = i3;
        this.f1476b = obj;
    }

    @Override // androidx.camera.core.impl.p1
    public final void a(s1 s1Var, SessionConfig$SessionError sessionConfig$SessionError) {
        switch (this.f1475a) {
            case 0:
                ArrayList arrayList = ((r1) this.f1476b).f1481l;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((p1) obj).a(s1Var, sessionConfig$SessionError);
                }
                return;
            case 1:
                n.g0 g0Var = (n.g0) this.f1476b;
                g0Var.f16175b = g0Var.g();
                n.j jVar = (n.j) g0Var.e;
                if (jVar != null) {
                    androidx.camera.camera2.internal.i iVar = jVar.f16234b;
                    iVar.getClass();
                    try {
                        if (((Boolean) ve.a(new n.j(iVar, 2)).f16358b.get()).booleanValue()) {
                            n.g0 g0Var2 = iVar.f1259x;
                            s1 s1Var2 = (s1) g0Var2.f16175b;
                            iVar.f1240c.execute(new androidx.camera.camera2.internal.b(iVar, androidx.camera.camera2.internal.i.v(g0Var2), s1Var2, (n.f0) g0Var2.f16176c, null, Collections.singletonList(UseCaseConfigFactory$CaptureType.METERING_REPEATING)));
                            return;
                        }
                        return;
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException("Unable to check if MeteringRepeating is attached.", e);
                    }
                }
                return;
            case 2:
                t.b0 b0Var = (t.b0) this.f1476b;
                if (b0Var.b() == null) {
                    return;
                }
                y5.a();
                o1 o1Var = b0Var.f18273t;
                if (o1Var != null) {
                    o1Var.b();
                    b0Var.f18273t = null;
                }
                s0 s0Var = b0Var.f18272s;
                if (s0Var != null) {
                    s0Var.a();
                    b0Var.f18272s = null;
                }
                b0Var.f18269o.d();
                b0Var.d();
                m0 m0Var = (m0) b0Var.f1323f;
                h hVar = b0Var.f1324g;
                hVar.getClass();
                n1 C = b0Var.C(m0Var, hVar);
                b0Var.r = C;
                Object[] objArr = {C.c()};
                ArrayList arrayList2 = new ArrayList(1);
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                arrayList2.add(obj2);
                b0Var.B(Collections.unmodifiableList(arrayList2));
                b0Var.o();
                return;
            case 3:
                t.m0 m0Var2 = (t.m0) this.f1476b;
                if (m0Var2.b() == null) {
                    return;
                }
                u.e eVar = m0Var2.f18365u;
                eVar.getClass();
                y5.a();
                eVar.f18665d = true;
                m0Var2.C(true);
                String d5 = m0Var2.d();
                n0 n0Var = (n0) m0Var2.f1323f;
                h hVar2 = m0Var2.f1324g;
                hVar2.getClass();
                n1 D = m0Var2.D(d5, n0Var, hVar2);
                m0Var2.f18363s = D;
                Object[] objArr2 = {D.c()};
                ArrayList arrayList3 = new ArrayList(1);
                Object obj3 = objArr2[0];
                Objects.requireNonNull(obj3);
                arrayList3.add(obj3);
                m0Var2.B(Collections.unmodifiableList(arrayList3));
                m0Var2.o();
                u.e eVar2 = m0Var2.f18365u;
                eVar2.getClass();
                y5.a();
                eVar2.f18665d = false;
                eVar2.c();
                return;
            default:
                androidx.camera.core.c cVar = (androidx.camera.core.c) this.f1476b;
                if (cVar.b() == null) {
                    return;
                }
                cVar.E((e1) cVar.f1323f, cVar.f1324g);
                cVar.o();
                return;
        }
    }
}
