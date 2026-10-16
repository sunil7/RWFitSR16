package t;

import android.util.Size;
import androidx.camera.core.impl.a2;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.camera.core.impl.m0 f18431a;

    static {
        Object size = new Size(GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
        t tVar = t.f18406d;
        Object bVar = new f0.b(f0.a.f12635b, new f0.c(b0.a.f3042b), null);
        g0.d dVar = new g0.d(2);
        androidx.camera.core.impl.c cVar = androidx.camera.core.impl.p0.f1471x0;
        androidx.camera.core.impl.x0 x0Var = dVar.f13764b;
        x0Var.m(cVar, size);
        x0Var.m(a2.G0, 1);
        x0Var.m(androidx.camera.core.impl.p0.f1466s0, 0);
        x0Var.m(androidx.camera.core.impl.p0.A0, bVar);
        if (!tVar.equals(tVar)) {
            throw new UnsupportedOperationException("ImageAnalysis currently only supports SDR");
        }
        x0Var.m(androidx.camera.core.impl.o0.f1463r0, tVar);
        f18431a = new androidx.camera.core.impl.m0(androidx.camera.core.impl.d1.a(x0Var));
    }
}
