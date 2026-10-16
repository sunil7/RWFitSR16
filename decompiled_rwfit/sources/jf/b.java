package jf;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.MeteringRectangle;

/* loaded from: classes2.dex */
public abstract class b extends gf.e {
    public final boolean e = true;

    @Override // gf.e
    public final void i(gf.b bVar) {
        this.f14058c = bVar;
        m(bVar, this.e ? new MeteringRectangle((Rect) j(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect()), 0) : null);
    }

    public abstract void m(gf.b bVar, MeteringRectangle meteringRectangle);
}
