package jf;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import ff.n;

/* loaded from: classes2.dex */
public final class d extends b {

    /* renamed from: f, reason: collision with root package name */
    public static final ef.b f15430f = ef.b.a(d.class.getSimpleName());

    @Override // gf.e
    public final void e(gf.b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        if (this.f14057b == 0) {
            n nVar = (n) bVar;
            nVar.Z.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            nVar.Y();
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }
    }

    @Override // jf.b
    public final void m(gf.b bVar, MeteringRectangle meteringRectangle) {
        int intValue = ((Integer) j(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue();
        if (meteringRectangle != null && intValue > 0) {
            ((n) bVar).Z.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        }
        n nVar = (n) bVar;
        TotalCaptureResult totalCaptureResult = nVar.f13631a0;
        Integer num = totalCaptureResult == null ? null : (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        ef.b bVar2 = f15430f;
        bVar2.b(1, "onStarted:", "last precapture trigger is", num);
        if (num != null && num.intValue() == 1) {
            bVar2.b(1, "onStarted:", "canceling precapture.");
            nVar.Z.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
        }
        nVar.Z.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        nVar.Y();
        k(0);
    }
}
