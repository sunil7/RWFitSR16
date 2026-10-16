package n;

import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.a2;
import java.util.UUID;

/* loaded from: classes.dex */
public final class f0 implements a2 {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.camera.core.impl.x0 f16173a;

    public f0() {
        androidx.camera.core.impl.x0 f2 = androidx.camera.core.impl.x0.f();
        f2.m(a2.E0, new r());
        f2.m(androidx.camera.core.impl.o0.f1462q0, 34);
        f2.m(y.i.S0, g0.class);
        f2.m(y.i.R0, g0.class.getCanonicalName() + "-" + UUID.randomUUID());
        this.f16173a = f2;
    }

    @Override // androidx.camera.core.impl.a2
    public final UseCaseConfigFactory$CaptureType p() {
        return UseCaseConfigFactory$CaptureType.METERING_REPEATING;
    }

    @Override // androidx.camera.core.impl.j1
    public final androidx.camera.core.impl.e0 y() {
        return this.f16173a;
    }
}
