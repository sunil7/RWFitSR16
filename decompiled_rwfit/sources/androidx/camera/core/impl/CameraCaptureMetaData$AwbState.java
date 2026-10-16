package androidx.camera.core.impl;

import com.tencent.connect.common.Constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class CameraCaptureMetaData$AwbState {
    public static final CameraCaptureMetaData$AwbState CONVERGED;
    public static final CameraCaptureMetaData$AwbState INACTIVE;
    public static final CameraCaptureMetaData$AwbState LOCKED;
    public static final CameraCaptureMetaData$AwbState METERING;
    public static final CameraCaptureMetaData$AwbState UNKNOWN;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraCaptureMetaData$AwbState[] f1335a;

    static {
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState = new CameraCaptureMetaData$AwbState(Constants.APP_VERSION_UNKNOWN, 0);
        UNKNOWN = cameraCaptureMetaData$AwbState;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState2 = new CameraCaptureMetaData$AwbState("INACTIVE", 1);
        INACTIVE = cameraCaptureMetaData$AwbState2;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState3 = new CameraCaptureMetaData$AwbState("METERING", 2);
        METERING = cameraCaptureMetaData$AwbState3;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState4 = new CameraCaptureMetaData$AwbState("CONVERGED", 3);
        CONVERGED = cameraCaptureMetaData$AwbState4;
        CameraCaptureMetaData$AwbState cameraCaptureMetaData$AwbState5 = new CameraCaptureMetaData$AwbState("LOCKED", 4);
        LOCKED = cameraCaptureMetaData$AwbState5;
        f1335a = new CameraCaptureMetaData$AwbState[]{cameraCaptureMetaData$AwbState, cameraCaptureMetaData$AwbState2, cameraCaptureMetaData$AwbState3, cameraCaptureMetaData$AwbState4, cameraCaptureMetaData$AwbState5};
    }

    public static CameraCaptureMetaData$AwbState valueOf(String str) {
        return (CameraCaptureMetaData$AwbState) Enum.valueOf(CameraCaptureMetaData$AwbState.class, str);
    }

    public static CameraCaptureMetaData$AwbState[] values() {
        return (CameraCaptureMetaData$AwbState[]) f1335a.clone();
    }
}
