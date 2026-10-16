package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;

/* loaded from: classes.dex */
public class w extends v {
    @Override // androidx.camera.camera2.internal.compat.v, ef.i
    public final void H(String str, androidx.camera.core.impl.utils.executor.b bVar, CameraDevice.StateCallback stateCallback) {
        try {
            ((CameraManager) this.f12629b).openCamera(str, bVar, stateCallback);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.v, ef.i
    public final CameraCharacteristics t(String str) {
        try {
            return ((CameraManager) this.f12629b).getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }
}
