package androidx.camera.core;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class CameraState$Type {
    public static final CameraState$Type CLOSED;
    public static final CameraState$Type CLOSING;
    public static final CameraState$Type OPEN;
    public static final CameraState$Type OPENING;
    public static final CameraState$Type PENDING_OPEN;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraState$Type[] f1283a;

    static {
        CameraState$Type cameraState$Type = new CameraState$Type("PENDING_OPEN", 0);
        PENDING_OPEN = cameraState$Type;
        CameraState$Type cameraState$Type2 = new CameraState$Type("OPENING", 1);
        OPENING = cameraState$Type2;
        CameraState$Type cameraState$Type3 = new CameraState$Type("OPEN", 2);
        OPEN = cameraState$Type3;
        CameraState$Type cameraState$Type4 = new CameraState$Type("CLOSING", 3);
        CLOSING = cameraState$Type4;
        CameraState$Type cameraState$Type5 = new CameraState$Type("CLOSED", 4);
        CLOSED = cameraState$Type5;
        f1283a = new CameraState$Type[]{cameraState$Type, cameraState$Type2, cameraState$Type3, cameraState$Type4, cameraState$Type5};
    }

    public static CameraState$Type valueOf(String str) {
        return (CameraState$Type) Enum.valueOf(CameraState$Type.class, str);
    }

    public static CameraState$Type[] values() {
        return (CameraState$Type[]) f1283a.clone();
    }
}
