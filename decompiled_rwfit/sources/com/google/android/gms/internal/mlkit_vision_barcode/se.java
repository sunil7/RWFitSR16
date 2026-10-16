package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

/* loaded from: classes.dex */
public abstract class se {
    public static CameraUnavailableException a(CameraAccessExceptionCompat cameraAccessExceptionCompat) {
        int reason = cameraAccessExceptionCompat.getReason();
        int i3 = 1;
        if (reason != 1) {
            i3 = 2;
            if (reason != 2) {
                i3 = 3;
                if (reason != 3) {
                    i3 = 4;
                    if (reason != 4) {
                        i3 = 5;
                        if (reason != 5) {
                            i3 = reason != 10001 ? 0 : 6;
                        }
                    }
                }
            }
        }
        return new CameraUnavailableException(i3, cameraAccessExceptionCompat);
    }
}
