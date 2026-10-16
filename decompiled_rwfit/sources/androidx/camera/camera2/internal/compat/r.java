package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;

/* loaded from: classes.dex */
public final class r extends q {
    @Override // androidx.camera.camera2.internal.compat.q
    public final void D(o.q qVar) {
        SessionConfiguration sessionConfiguration = (SessionConfiguration) qVar.f16636a.a();
        sessionConfiguration.getClass();
        try {
            ((CameraDevice) this.f36a).createCaptureSession(sessionConfiguration);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }
}
