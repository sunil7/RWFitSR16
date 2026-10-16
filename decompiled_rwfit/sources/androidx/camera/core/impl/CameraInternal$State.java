package androidx.camera.core.impl;

/* loaded from: classes.dex */
public enum CameraInternal$State {
    RELEASED(false),
    RELEASING(true),
    CLOSED(false),
    PENDING_OPEN(false),
    CLOSING(true),
    OPENING(true),
    OPEN(true),
    CONFIGURED(true);

    private final boolean mHoldsCameraSlot;

    CameraInternal$State(boolean z5) {
        this.mHoldsCameraSlot = z5;
    }

    public boolean holdsCameraSlot() {
        return this.mHoldsCameraSlot;
    }
}
