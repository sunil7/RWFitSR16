package hf;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import ff.n;

/* loaded from: classes2.dex */
public final class b extends gf.d {

    /* renamed from: f, reason: collision with root package name */
    public static final ef.b f14319f = ef.b.a(b.class.getSimpleName());

    @Override // gf.d, gf.e
    public final void e(gf.b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        f14319f.b(1, "onCapture:", "afState:", num, "afMode:", num2);
        if (num == null || num2 == null || num2.intValue() != 1) {
            return;
        }
        int intValue = num.intValue();
        if (intValue == 0 || intValue == 2 || intValue == 4 || intValue == 5 || intValue == 6) {
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }
    }

    @Override // gf.d
    public final boolean m(gf.b bVar) {
        for (int i3 : (int[]) j(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0])) {
            if (i3 == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // gf.d
    public final boolean n(gf.b bVar) {
        TotalCaptureResult totalCaptureResult = ((n) bVar).f13631a0;
        ef.b bVar2 = f14319f;
        boolean z5 = false;
        if (totalCaptureResult == null) {
            bVar2.b(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        boolean z6 = num != null && (num.intValue() == 4 || num.intValue() == 5 || num.intValue() == 0 || num.intValue() == 2 || num.intValue() == 6);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        boolean z8 = num2 != null && num2.intValue() == 1;
        if (z6 && z8) {
            z5 = true;
        }
        bVar2.b(1, "checkShouldSkip:", Boolean.valueOf(z5));
        return z5;
    }

    @Override // gf.d
    public final void p(gf.b bVar) {
        ((n) bVar).Z.set(CaptureRequest.CONTROL_AF_MODE, 1);
        n nVar = (n) bVar;
        nVar.Z.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        nVar.Y();
    }
}
