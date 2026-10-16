package jf;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import ff.n;

/* loaded from: classes2.dex */
public final class f extends b {

    /* renamed from: f, reason: collision with root package name */
    public static final ef.b f15432f = ef.b.a(f.class.getSimpleName());

    @Override // jf.b
    public final void m(gf.b bVar, MeteringRectangle meteringRectangle) {
        boolean z5 = false;
        int intValue = ((Integer) j(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        boolean z6 = true;
        if (meteringRectangle != null && intValue > 0) {
            ((n) bVar).Z.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{meteringRectangle});
            z5 = true;
        }
        n nVar = (n) bVar;
        TotalCaptureResult totalCaptureResult = nVar.f13631a0;
        Integer num = totalCaptureResult == null ? null : (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER);
        f15432f.b(2, "onStarted:", "last focus trigger is", num);
        if (num == null || num.intValue() != 1) {
            z6 = z5;
        } else {
            nVar.Z.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        }
        if (z6) {
            nVar.Y();
        }
        k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }
}
