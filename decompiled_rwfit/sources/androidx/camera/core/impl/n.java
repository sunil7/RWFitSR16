package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;

/* loaded from: classes.dex */
public interface n {
    w1 a();

    long d();

    CameraCaptureMetaData$AeState g();

    CameraCaptureMetaData$AwbState h();

    default CaptureResult i() {
        return null;
    }

    CameraCaptureMetaData$AfState k();
}
