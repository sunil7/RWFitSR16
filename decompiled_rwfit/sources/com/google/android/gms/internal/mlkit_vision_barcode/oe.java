package com.google.android.gms.internal.mlkit_vision_barcode;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.InitializationException;

/* loaded from: classes.dex */
public abstract class oe {
    public static boolean a(androidx.camera.camera2.internal.compat.u uVar, String str) {
        if ("robolectric".equals(Build.FINGERPRINT)) {
            return true;
        }
        try {
            int[] iArr = (int[]) uVar.b(str).a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i3 : iArr) {
                    if (i3 == 0) {
                        return true;
                    }
                }
            }
            return false;
        } catch (CameraAccessExceptionCompat e) {
            throw new InitializationException(se.a(e));
        }
    }
}
