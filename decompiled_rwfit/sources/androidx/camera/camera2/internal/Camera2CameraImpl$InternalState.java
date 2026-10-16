package androidx.camera.camera2.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Camera2CameraImpl$InternalState {
    public static final Camera2CameraImpl$InternalState CLOSING;
    public static final Camera2CameraImpl$InternalState CONFIGURED;
    public static final Camera2CameraImpl$InternalState INITIALIZED;
    public static final Camera2CameraImpl$InternalState OPENED;
    public static final Camera2CameraImpl$InternalState OPENING;
    public static final Camera2CameraImpl$InternalState PENDING_OPEN;
    public static final Camera2CameraImpl$InternalState RELEASED;
    public static final Camera2CameraImpl$InternalState RELEASING;
    public static final Camera2CameraImpl$InternalState REOPENING;
    public static final Camera2CameraImpl$InternalState REOPENING_QUIRK;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Camera2CameraImpl$InternalState[] f1132a;

    static {
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = new Camera2CameraImpl$InternalState("RELEASED", 0);
        RELEASED = camera2CameraImpl$InternalState;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState2 = new Camera2CameraImpl$InternalState("RELEASING", 1);
        RELEASING = camera2CameraImpl$InternalState2;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState3 = new Camera2CameraImpl$InternalState("INITIALIZED", 2);
        INITIALIZED = camera2CameraImpl$InternalState3;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState4 = new Camera2CameraImpl$InternalState("PENDING_OPEN", 3);
        PENDING_OPEN = camera2CameraImpl$InternalState4;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState5 = new Camera2CameraImpl$InternalState("CLOSING", 4);
        CLOSING = camera2CameraImpl$InternalState5;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState6 = new Camera2CameraImpl$InternalState("REOPENING_QUIRK", 5);
        REOPENING_QUIRK = camera2CameraImpl$InternalState6;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState7 = new Camera2CameraImpl$InternalState("REOPENING", 6);
        REOPENING = camera2CameraImpl$InternalState7;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState8 = new Camera2CameraImpl$InternalState("OPENING", 7);
        OPENING = camera2CameraImpl$InternalState8;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState9 = new Camera2CameraImpl$InternalState("OPENED", 8);
        OPENED = camera2CameraImpl$InternalState9;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState10 = new Camera2CameraImpl$InternalState("CONFIGURED", 9);
        CONFIGURED = camera2CameraImpl$InternalState10;
        f1132a = new Camera2CameraImpl$InternalState[]{camera2CameraImpl$InternalState, camera2CameraImpl$InternalState2, camera2CameraImpl$InternalState3, camera2CameraImpl$InternalState4, camera2CameraImpl$InternalState5, camera2CameraImpl$InternalState6, camera2CameraImpl$InternalState7, camera2CameraImpl$InternalState8, camera2CameraImpl$InternalState9, camera2CameraImpl$InternalState10};
    }

    public static Camera2CameraImpl$InternalState valueOf(String str) {
        return (Camera2CameraImpl$InternalState) Enum.valueOf(Camera2CameraImpl$InternalState.class, str);
    }

    public static Camera2CameraImpl$InternalState[] values() {
        return (Camera2CameraImpl$InternalState[]) f1132a.clone();
    }
}
