package n;

import android.hardware.camera2.CameraCaptureSession;
import android.util.ArrayMap;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.w1;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f16290a = new q();

    public void a(androidx.camera.core.impl.n0 n0Var, androidx.camera.core.impl.c0 c0Var) {
        androidx.camera.core.impl.d0 d0Var = (androidx.camera.core.impl.d0) n0Var.k(a2.D0, null);
        d1 d1Var = d1.f1373c;
        androidx.camera.core.impl.c cVar = androidx.camera.core.impl.d0.f1363h;
        HashSet hashSet = new HashSet();
        androidx.camera.core.impl.x0 f2 = androidx.camera.core.impl.x0.f();
        ArrayList arrayList = new ArrayList();
        androidx.camera.core.impl.z0 a3 = androidx.camera.core.impl.z0.a();
        ArrayList arrayList2 = new ArrayList(hashSet);
        d1 a10 = d1.a(f2);
        ArrayList arrayList3 = new ArrayList(arrayList);
        w1 w1Var = w1.f1513b;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = a3.f1514a;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        int i3 = -1;
        new androidx.camera.core.impl.d0(arrayList2, a10, -1, arrayList3, false, new w1(arrayMap), null);
        if (d0Var != null) {
            c0Var.a(d0Var.f1369d);
            d1Var = d0Var.f1367b;
            i3 = d0Var.f1368c;
        }
        c0Var.f1355b = androidx.camera.core.impl.x0.i(d1Var);
        c0Var.f1356c = ((Integer) n0Var.k(m.b.f15877c, Integer.valueOf(i3))).intValue();
        c0Var.b(new x((CameraCaptureSession.CaptureCallback) n0Var.k(m.b.f15880g, new p())));
        c0Var.c(g0.d.d(n0Var).c());
    }
}
