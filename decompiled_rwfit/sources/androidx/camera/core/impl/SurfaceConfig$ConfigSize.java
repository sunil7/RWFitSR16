package androidx.camera.core.impl;

/* loaded from: classes.dex */
public enum SurfaceConfig$ConfigSize {
    VGA(0),
    s720p(1),
    PREVIEW(2),
    s1440p(3),
    RECORD(4),
    MAXIMUM(5),
    ULTRA_MAXIMUM(6),
    NOT_SUPPORT(7);

    final int mId;

    SurfaceConfig$ConfigSize(int i3) {
        this.mId = i3;
    }

    public int getId() {
        return this.mId;
    }
}
