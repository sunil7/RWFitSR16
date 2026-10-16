package com.google.android.gms.internal.mlkit_vision_common;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public abstract class j0 {
    public static int a(int i3, int i10, boolean z5) {
        int i11 = z5 ? ((i10 - i3) + 360) % 360 : (i10 + i3) % 360;
        if (a0.d(2, "CameraOrientationUtil")) {
            StringBuilder s7 = com.google.android.gms.internal.mlkit_vision_barcode.l0.s(i3, "getRelativeImageRotation: destRotationDegrees=", i10, ", sourceRotationDegrees=", ", isOppositeFacing=");
            s7.append(z5);
            s7.append(", result=");
            s7.append(i11);
            a0.a("CameraOrientationUtil", s7.toString());
        }
        return i11;
    }

    public static int b(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 1) {
            return 90;
        }
        if (i3 == 2) {
            return 180;
        }
        if (i3 == 3) {
            return SubsamplingScaleImageView.ORIENTATION_270;
        }
        throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "Unsupported surface rotation: "));
    }
}
