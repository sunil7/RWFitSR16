package jf;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import ff.n;
import java.util.List;

/* loaded from: classes2.dex */
public final class e extends a {

    /* renamed from: i, reason: collision with root package name */
    public static final ef.b f15431i = ef.b.a(e.class.getSimpleName());

    @Override // gf.e
    public final void e(gf.b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        f15431i.b(1, "onCaptureCompleted:", "afState:", num);
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue == 4) {
            this.f15425f = true;
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        } else {
            if (intValue != 5) {
                return;
            }
            this.f15425f = false;
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }
    }

    @Override // gf.e
    public final void h(gf.b bVar) {
        ((n) bVar).Z.set(CaptureRequest.CONTROL_AF_TRIGGER, null);
    }

    @Override // jf.a
    public final boolean m(gf.b bVar) {
        Integer num = (Integer) ((n) bVar).Z.get(CaptureRequest.CONTROL_AF_MODE);
        boolean z5 = num != null && (num.intValue() == 1 || num.intValue() == 4 || num.intValue() == 3 || num.intValue() == 2);
        f15431i.b(1, "checkIsSupported:", Boolean.valueOf(z5));
        return z5;
    }

    @Override // jf.a
    public final boolean n(gf.b bVar) {
        TotalCaptureResult totalCaptureResult = ((n) bVar).f13631a0;
        ef.b bVar2 = f15431i;
        boolean z5 = false;
        if (totalCaptureResult == null) {
            bVar2.b(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (num != null && (num.intValue() == 4 || num.intValue() == 2)) {
            z5 = true;
        }
        bVar2.b(1, "checkShouldSkip:", Boolean.valueOf(z5));
        return z5;
    }

    @Override // jf.a
    public final void o(gf.b bVar, List list) {
        f15431i.b(1, "onStarted:", "with areas:", list);
        n nVar = (n) bVar;
        nVar.Z.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        int intValue = ((Integer) j(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        if (!list.isEmpty() && intValue > 0) {
            nVar.Z.set(CaptureRequest.CONTROL_AF_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(intValue, list.size())).toArray(new MeteringRectangle[0]));
        }
        nVar.Y();
    }
}
