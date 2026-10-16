package androidx.camera.camera2.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class CaptureSession$State {
    public static final CaptureSession$State CLOSED;
    public static final CaptureSession$State GET_SURFACE;
    public static final CaptureSession$State INITIALIZED;
    public static final CaptureSession$State OPENED;
    public static final CaptureSession$State OPENING;
    public static final CaptureSession$State RELEASED;
    public static final CaptureSession$State RELEASING;
    public static final CaptureSession$State UNINITIALIZED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CaptureSession$State[] f1133a;

    static {
        CaptureSession$State captureSession$State = new CaptureSession$State("UNINITIALIZED", 0);
        UNINITIALIZED = captureSession$State;
        CaptureSession$State captureSession$State2 = new CaptureSession$State("INITIALIZED", 1);
        INITIALIZED = captureSession$State2;
        CaptureSession$State captureSession$State3 = new CaptureSession$State("GET_SURFACE", 2);
        GET_SURFACE = captureSession$State3;
        CaptureSession$State captureSession$State4 = new CaptureSession$State("OPENING", 3);
        OPENING = captureSession$State4;
        CaptureSession$State captureSession$State5 = new CaptureSession$State("OPENED", 4);
        OPENED = captureSession$State5;
        CaptureSession$State captureSession$State6 = new CaptureSession$State("CLOSED", 5);
        CLOSED = captureSession$State6;
        CaptureSession$State captureSession$State7 = new CaptureSession$State("RELEASING", 6);
        RELEASING = captureSession$State7;
        CaptureSession$State captureSession$State8 = new CaptureSession$State("RELEASED", 7);
        RELEASED = captureSession$State8;
        f1133a = new CaptureSession$State[]{captureSession$State, captureSession$State2, captureSession$State3, captureSession$State4, captureSession$State5, captureSession$State6, captureSession$State7, captureSession$State8};
    }

    public static CaptureSession$State valueOf(String str) {
        return (CaptureSession$State) Enum.valueOf(CaptureSession$State.class, str);
    }

    public static CaptureSession$State[] values() {
        return (CaptureSession$State[]) f1133a.clone();
    }
}
