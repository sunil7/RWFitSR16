package androidx.camera.core;

/* loaded from: classes.dex */
public class CameraUnavailableException extends Exception {
    public static final int CAMERA_DISABLED = 1;
    public static final int CAMERA_DISCONNECTED = 2;
    public static final int CAMERA_ERROR = 3;
    public static final int CAMERA_IN_USE = 4;
    public static final int CAMERA_MAX_IN_USE = 5;
    public static final int CAMERA_UNAVAILABLE_DO_NOT_DISTURB = 6;
    public static final int CAMERA_UNKNOWN_ERROR = 0;
    private final int mReason;

    public CameraUnavailableException(int i3) {
        this.mReason = i3;
    }

    public int getReason() {
        return this.mReason;
    }

    public CameraUnavailableException(int i3, String str) {
        super(str);
        this.mReason = i3;
    }

    public CameraUnavailableException(int i3, String str, Throwable th2) {
        super(str, th2);
        this.mReason = i3;
    }

    public CameraUnavailableException(int i3, Throwable th2) {
        super(th2);
        this.mReason = i3;
    }
}
