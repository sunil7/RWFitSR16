package jf;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import ff.n;

/* loaded from: classes2.dex */
public final class i extends b {

    /* renamed from: f, reason: collision with root package name */
    public static final ef.b f15440f = ef.b.a(i.class.getSimpleName());

    @Override // jf.b
    public final void m(gf.b bVar, MeteringRectangle meteringRectangle) {
        f15440f.b(2, "onStarted:", "with area:", meteringRectangle);
        int intValue = ((Integer) j(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (meteringRectangle != null && intValue > 0) {
            n nVar = (n) bVar;
            nVar.Z.set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{meteringRectangle});
            nVar.Y();
        }
        k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }
}
