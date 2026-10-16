package androidx.camera.core.impl;

/* loaded from: classes.dex */
public class CameraValidator$CameraIdListIncorrectException extends Exception {
    private int mAvailableCameraCount;

    public CameraValidator$CameraIdListIncorrectException(String str, int i3, Throwable th2) {
        super(str, th2);
        this.mAvailableCameraCount = i3;
    }

    public int getAvailableCameraCount() {
        return this.mAvailableCameraCount;
    }
}
