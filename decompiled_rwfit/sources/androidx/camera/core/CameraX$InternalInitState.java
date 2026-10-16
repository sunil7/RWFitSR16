package androidx.camera.core;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class CameraX$InternalInitState {
    public static final CameraX$InternalInitState INITIALIZED;
    public static final CameraX$InternalInitState INITIALIZING;
    public static final CameraX$InternalInitState INITIALIZING_ERROR;
    public static final CameraX$InternalInitState SHUTDOWN;
    public static final CameraX$InternalInitState UNINITIALIZED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraX$InternalInitState[] f1284a;

    static {
        CameraX$InternalInitState cameraX$InternalInitState = new CameraX$InternalInitState("UNINITIALIZED", 0);
        UNINITIALIZED = cameraX$InternalInitState;
        CameraX$InternalInitState cameraX$InternalInitState2 = new CameraX$InternalInitState("INITIALIZING", 1);
        INITIALIZING = cameraX$InternalInitState2;
        CameraX$InternalInitState cameraX$InternalInitState3 = new CameraX$InternalInitState("INITIALIZING_ERROR", 2);
        INITIALIZING_ERROR = cameraX$InternalInitState3;
        CameraX$InternalInitState cameraX$InternalInitState4 = new CameraX$InternalInitState("INITIALIZED", 3);
        INITIALIZED = cameraX$InternalInitState4;
        CameraX$InternalInitState cameraX$InternalInitState5 = new CameraX$InternalInitState("SHUTDOWN", 4);
        SHUTDOWN = cameraX$InternalInitState5;
        f1284a = new CameraX$InternalInitState[]{cameraX$InternalInitState, cameraX$InternalInitState2, cameraX$InternalInitState3, cameraX$InternalInitState4, cameraX$InternalInitState5};
    }

    public static CameraX$InternalInitState valueOf(String str) {
        return (CameraX$InternalInitState) Enum.valueOf(CameraX$InternalInitState.class, str);
    }

    public static CameraX$InternalInitState[] values() {
        return (CameraX$InternalInitState[]) f1284a.clone();
    }
}
