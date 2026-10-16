package hf;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import ff.n;

/* loaded from: classes2.dex */
public final class d extends gf.d {

    /* renamed from: f, reason: collision with root package name */
    public static final ef.b f14322f = ef.b.a(d.class.getSimpleName());

    @Override // gf.d, gf.e
    public final void e(gf.b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        f14322f.b(1, "processCapture:", "awbState:", num);
        if (num != null && num.intValue() == 3) {
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }
    }

    @Override // gf.d
    public final boolean m(gf.b bVar) {
        boolean z5 = false;
        boolean z6 = ((Integer) j(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) ((n) bVar).Z.get(CaptureRequest.CONTROL_AWB_MODE);
        if (z6 && num != null && num.intValue() == 1) {
            z5 = true;
        }
        f14322f.b(1, "checkIsSupported:", Boolean.valueOf(z5));
        return z5;
    }

    @Override // gf.d
    public final boolean n(gf.b bVar) {
        TotalCaptureResult totalCaptureResult = ((n) bVar).f13631a0;
        ef.b bVar2 = f14322f;
        boolean z5 = false;
        if (totalCaptureResult == null) {
            bVar2.b(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        if (num != null && num.intValue() == 3) {
            z5 = true;
        }
        bVar2.b(1, "checkShouldSkip:", Boolean.valueOf(z5));
        return z5;
    }

    @Override // gf.d
    public final void p(gf.b bVar) {
        ((n) bVar).Z.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.TRUE);
        ((n) bVar).Y();
    }
}
