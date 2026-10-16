package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n1 extends m1 {
    public static n1 d(a2 a2Var, Size size) {
        if (((n.r) a2Var.k(a2.E0, null)) == null) {
            throw new IllegalStateException("Implementation is missing option unpacker for " + ((String) a2Var.k(y.i.R0, a2Var.toString())));
        }
        n1 n1Var = new n1();
        s1 s1Var = (s1) a2Var.k(a2.C0, null);
        d1 d1Var = d1.f1373c;
        int i3 = s1.a().f1490g.f1368c;
        if (s1Var != null) {
            i3 = s1Var.f1490g.f1368c;
            for (CameraDevice.StateCallback stateCallback : s1Var.f1487c) {
                ArrayList arrayList = n1Var.f1443c;
                if (!arrayList.contains(stateCallback)) {
                    arrayList.add(stateCallback);
                }
            }
            for (CameraCaptureSession.StateCallback stateCallback2 : s1Var.f1488d) {
                ArrayList arrayList2 = n1Var.f1444d;
                if (!arrayList2.contains(stateCallback2)) {
                    arrayList2.add(stateCallback2);
                }
            }
            n1Var.f1442b.a(s1Var.f1490g.f1369d);
            d1Var = s1Var.f1490g.f1367b;
        }
        c0 c0Var = n1Var.f1442b;
        c0Var.getClass();
        c0Var.f1355b = x0.i(d1Var);
        if (a2Var instanceof e1) {
            Rational rational = q.c.f17609a;
            if (((PreviewPixelHDRnetQuirk) p.a.f17285a.f(PreviewPixelHDRnetQuirk.class)) != null && !q.c.f17609a.equals(new Rational(size.getWidth(), size.getHeight()))) {
                x0 f2 = x0.f();
                f2.m(m.b.Y(CaptureRequest.TONEMAP_MODE), 2);
                n1Var.f1442b.c(new m.b(d1.a(f2), 12));
            }
        }
        n1Var.f1442b.f1356c = ((Integer) a2Var.k(m.b.f15877c, Integer.valueOf(i3))).intValue();
        CameraDevice.StateCallback stateCallback3 = (CameraDevice.StateCallback) a2Var.k(m.b.e, new n.v());
        ArrayList arrayList3 = n1Var.f1443c;
        if (!arrayList3.contains(stateCallback3)) {
            arrayList3.add(stateCallback3);
        }
        CameraCaptureSession.StateCallback stateCallback4 = (CameraCaptureSession.StateCallback) a2Var.k(m.b.f15879f, new n.u());
        ArrayList arrayList4 = n1Var.f1444d;
        if (!arrayList4.contains(stateCallback4)) {
            arrayList4.add(stateCallback4);
        }
        n.x xVar = new n.x((CameraCaptureSession.CaptureCallback) a2Var.k(m.b.f15880g, new n.p()));
        n1Var.f1442b.b(xVar);
        ArrayList arrayList5 = n1Var.e;
        if (!arrayList5.contains(xVar)) {
            arrayList5.add(xVar);
        }
        c cVar = a2.M0;
        Integer num = (Integer) a2Var.k(cVar, 0);
        int intValue = num.intValue();
        if (intValue != 0) {
            c0 c0Var2 = n1Var.f1442b;
            c0Var2.getClass();
            if (intValue != 0) {
                c0Var2.f1355b.m(cVar, num);
            }
        }
        int D = a2Var.D();
        if (D != 0) {
            c0 c0Var3 = n1Var.f1442b;
            c0Var3.getClass();
            if (D != 0) {
                c0Var3.f1355b.m(a2.L0, Integer.valueOf(D));
            }
        }
        x0 f10 = x0.f();
        c cVar2 = m.b.f15881h;
        f10.m(cVar2, (String) a2Var.k(cVar2, null));
        c cVar3 = m.b.f15878d;
        Long l3 = (Long) a2Var.k(cVar3, -1L);
        l3.getClass();
        f10.m(cVar3, l3);
        n1Var.f1442b.c(f10);
        n1Var.f1442b.c(g0.d.d(a2Var).c());
        return n1Var;
    }

    public final void a(e0 e0Var) {
        this.f1442b.c(e0Var);
    }

    public final void b(g0 g0Var, t.t tVar, int i3) {
        e a3 = f.a(g0Var);
        if (tVar == null) {
            throw new NullPointerException("Null dynamicRange");
        }
        a3.f1377b = tVar;
        a3.e = Integer.valueOf(i3);
        this.f1441a.add(a3.a());
        this.f1442b.f1354a.add(g0Var);
    }

    public final s1 c() {
        return new s1(new ArrayList(this.f1441a), new ArrayList(this.f1443c), new ArrayList(this.f1444d), new ArrayList(this.e), this.f1442b.d(), this.f1445f, this.f1446g, this.f1447h);
    }
}
