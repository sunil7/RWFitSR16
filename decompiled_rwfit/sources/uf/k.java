package uf;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes2.dex */
public final class k extends gf.e {
    @Override // gf.e
    public final void e(gf.b bVar, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            p.f19101d.b(2, "FlashAction:", "Waiting flash, but flashState is null!", "Taking snapshot.");
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        } else if (num.intValue() != 3) {
            p.f19101d.b(1, "FlashAction:", "Waiting flash but flashState is", num, ". Waiting...");
        } else {
            p.f19101d.b(1, "FlashAction:", "Waiting flash and we have FIRED state!", "Taking snapshot.");
            k(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        }
    }

    @Override // gf.e
    public final void i(gf.b bVar) {
        this.f14058c = bVar;
        p.f19101d.b(1, "FlashAction:", "Parameters locked, opening torch.");
        ((ff.n) bVar).Z.set(CaptureRequest.FLASH_MODE, 2);
        ff.n nVar = (ff.n) bVar;
        nVar.Z.set(CaptureRequest.CONTROL_AE_MODE, 1);
        nVar.Y();
    }
}
