package n;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;
import androidx.camera.core.impl.d1;

/* loaded from: classes.dex */
public final class e0 extends q {

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f16170b;

    static {
        new eb.e(18);
        f16170b = new e0();
    }

    @Override // n.q
    public final void a(androidx.camera.core.impl.n0 n0Var, androidx.camera.core.impl.c0 c0Var) {
        super.a(n0Var, c0Var);
        if (n0Var == null) {
            throw new IllegalArgumentException("config is not ImageCaptureConfig");
        }
        androidx.camera.core.impl.x0 f2 = androidx.camera.core.impl.x0.f();
        androidx.camera.core.impl.c cVar = androidx.camera.core.impl.n0.f1448b;
        if (n0Var.b(cVar)) {
            int intValue = ((Integer) n0Var.e(cVar)).intValue();
            if (((ImageCapturePixelHDRPlusQuirk) p.a.f17285a.f(ImageCapturePixelHDRPlusQuirk.class)) != null) {
                if (intValue == 0) {
                    CaptureRequest.Key key = CaptureRequest.CONTROL_ENABLE_ZSL;
                    f2.m(m.b.Y(key), Boolean.TRUE);
                } else if (intValue == 1) {
                    CaptureRequest.Key key2 = CaptureRequest.CONTROL_ENABLE_ZSL;
                    f2.m(m.b.Y(key2), Boolean.FALSE);
                }
            }
        }
        c0Var.c(new m.b(d1.a(f2), 12));
    }
}
