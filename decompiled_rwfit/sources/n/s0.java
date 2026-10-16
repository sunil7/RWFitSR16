package n;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import com.google.android.gms.internal.mlkit_vision_common.y5;

/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final h f16297a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.b0 f16298b = new androidx.lifecycle.b0(0);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16299c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.camera.core.impl.utils.executor.b f16300d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.concurrent.futures.b f16301f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16302g;

    public s0(h hVar, androidx.camera.camera2.internal.compat.n nVar, androidx.camera.core.impl.utils.executor.b bVar) {
        this.f16297a = hVar;
        this.f16300d = bVar;
        this.f16299c = com.google.android.gms.internal.mlkit_vision_common.o.a(new af.a(nVar, 19));
        hVar.k(new g() { // from class: n.q0
            @Override // n.g
            public final boolean a(TotalCaptureResult totalCaptureResult) {
                s0 s0Var = s0.this;
                if (s0Var.f16301f != null) {
                    Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
                    if ((num != null && num.intValue() == 2) == s0Var.f16302g) {
                        s0Var.f16301f.a(null);
                        s0Var.f16301f = null;
                    }
                }
                return false;
            }
        });
    }

    public static void a(androidx.lifecycle.b0 b0Var, Integer num) {
        if (y5.b()) {
            b0Var.k(num);
        } else {
            b0Var.i(num);
        }
    }
}
