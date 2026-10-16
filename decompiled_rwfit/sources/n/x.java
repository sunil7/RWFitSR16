package n;

import android.hardware.camera2.CameraCaptureSession;

/* loaded from: classes.dex */
public final class x extends androidx.camera.core.impl.k {

    /* renamed from: a, reason: collision with root package name */
    public final CameraCaptureSession.CaptureCallback f16316a;

    public x(CameraCaptureSession.CaptureCallback captureCallback) {
        if (captureCallback == null) {
            throw new NullPointerException("captureCallback is null");
        }
        this.f16316a = captureCallback;
    }
}
