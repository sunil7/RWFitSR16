package n;

import android.hardware.camera2.CameraCharacteristics;

/* loaded from: classes.dex */
public abstract class z {
    public static t.t a(androidx.camera.camera2.internal.compat.n nVar) {
        Long l3 = (Long) nVar.a(CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
        if (l3 != null) {
            return (t.t) o.a.f16616a.get(l3);
        }
        return null;
    }
}
