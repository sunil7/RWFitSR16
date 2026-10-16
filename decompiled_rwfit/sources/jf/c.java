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
public final class c extends a {

    /* renamed from: k, reason: collision with root package name */
    public static final ef.b f15427k = ef.b.a(c.class.getSimpleName());

    /* renamed from: i, reason: collision with root package name */
    public boolean f15428i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15429j;

    @Override // gf.e
    public final void e(gf.b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        f15427k.b(1, "onCaptureCompleted:", "aeState:", num, "aeTriggerState:", num2);
        if (num == null) {
            return;
        }
        if (this.f14057b == 0) {
            int intValue = num.intValue();
            if (intValue != 2) {
                if (intValue == 3) {
                    this.f15425f = false;
                    k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
                } else if (intValue != 4) {
                    if (intValue == 5) {
                        k(1);
                    }
                }
            }
            if (num2 != null && num2.intValue() == 1) {
                this.f15425f = true;
                k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
            }
        }
        if (this.f14057b == 1) {
            int intValue2 = num.intValue();
            if (intValue2 != 2) {
                if (intValue2 == 3) {
                    this.f15425f = false;
                    k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
                    return;
                } else if (intValue2 != 4) {
                    return;
                }
            }
            this.f15425f = true;
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }
    }

    @Override // gf.e
    public final void h(gf.b bVar) {
        ((n) bVar).Z.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, null);
    }

    @Override // jf.a
    public final boolean m(gf.b bVar) {
        boolean z5 = false;
        boolean z6 = ((Integer) j(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2;
        Integer num = (Integer) ((n) bVar).Z.get(CaptureRequest.CONTROL_AE_MODE);
        boolean z8 = num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5);
        this.f15429j = !z6;
        boolean z10 = ((Integer) j(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue() > 0;
        this.f15428i = z10;
        if (z8 && (this.f15429j || z10)) {
            z5 = true;
        }
        f15427k.b(1, "checkIsSupported:", Boolean.valueOf(z5), "trigger:", Boolean.valueOf(this.f15429j), "areas:", Boolean.valueOf(this.f15428i));
        return z5;
    }

    @Override // jf.a
    public final boolean n(gf.b bVar) {
        TotalCaptureResult totalCaptureResult = ((n) bVar).f13631a0;
        ef.b bVar2 = f15427k;
        boolean z5 = false;
        if (totalCaptureResult == null) {
            bVar2.b(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if (num != null && num.intValue() == 2) {
            z5 = true;
        }
        bVar2.b(1, "checkShouldSkip:", Boolean.valueOf(z5));
        return z5;
    }

    @Override // jf.a
    public final void o(gf.b bVar, List list) {
        f15427k.b(1, "onStarted:", "with areas:", list);
        if (this.f15428i && !list.isEmpty()) {
            ((n) bVar).Z.set(CaptureRequest.CONTROL_AE_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(((Integer) j(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue(), list.size())).toArray(new MeteringRectangle[0]));
        }
        if (this.f15429j) {
            ((n) bVar).Z.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        }
        ((n) bVar).Y();
        if (this.f15429j) {
            k(0);
        } else {
            k(1);
        }
    }
}
