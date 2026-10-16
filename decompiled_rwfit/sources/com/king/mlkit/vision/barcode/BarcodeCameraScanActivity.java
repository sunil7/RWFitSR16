package com.king.mlkit.vision.barcode;

import com.king.camera.scan.BaseCameraScanActivity;
import de.o;
import java.util.List;
import kc.a;

/* loaded from: classes.dex */
public abstract class BarcodeCameraScanActivity extends BaseCameraScanActivity<List<a>> {
    @Override // com.king.camera.scan.BaseCameraScanActivity
    public o G0() {
        return new o(0, new int[0]);
    }

    @Override // com.king.camera.scan.BaseCameraScanActivity
    public int H0() {
        return R$layout.ml_barcode_camera_scan;
    }

    @Override // com.king.camera.scan.BaseCameraScanActivity
    public void J0() {
        int i3 = R$id.viewfinderView;
        if (i3 != -1 && i3 != 0) {
        }
        super.J0();
    }
}
