package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import java.util.Set;

/* loaded from: classes.dex */
public final class x extends w {
    @Override // ef.i
    public final Set w() {
        try {
            return ((CameraManager) this.f12629b).getConcurrentCameraIds();
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }
}
