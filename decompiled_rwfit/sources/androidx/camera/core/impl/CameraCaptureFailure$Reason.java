package androidx.camera.core.impl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class CameraCaptureFailure$Reason {
    public static final CameraCaptureFailure$Reason ERROR;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraCaptureFailure$Reason[] f1332a;

    static {
        CameraCaptureFailure$Reason cameraCaptureFailure$Reason = new CameraCaptureFailure$Reason("ERROR", 0);
        ERROR = cameraCaptureFailure$Reason;
        f1332a = new CameraCaptureFailure$Reason[]{cameraCaptureFailure$Reason};
    }

    public static CameraCaptureFailure$Reason valueOf(String str) {
        return (CameraCaptureFailure$Reason) Enum.valueOf(CameraCaptureFailure$Reason.class, str);
    }

    public static CameraCaptureFailure$Reason[] values() {
        return (CameraCaptureFailure$Reason[]) f1332a.clone();
    }
}
