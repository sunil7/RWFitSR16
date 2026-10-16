package com.google.android.gms.internal.mlkit_vision_barcode;

import android.hardware.camera2.CameraCharacteristics;
import java.util.List;

/* loaded from: classes.dex */
public abstract class re {
    public static String a(androidx.camera.camera2.internal.compat.u uVar, Integer num, List list) {
        if (num != null && list.contains("0") && list.contains("1")) {
            if (num.intValue() == 1) {
                if (((Integer) uVar.b("0").a(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                    return "1";
                }
            } else if (num.intValue() == 0 && ((Integer) uVar.b("1").a(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                return "0";
            }
        }
        return null;
    }
}
