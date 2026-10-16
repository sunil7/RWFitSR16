package androidx.camera.core.impl;

import com.tencent.connect.common.Constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class CameraCaptureMetaData$AeState {
    public static final CameraCaptureMetaData$AeState CONVERGED;
    public static final CameraCaptureMetaData$AeState FLASH_REQUIRED;
    public static final CameraCaptureMetaData$AeState INACTIVE;
    public static final CameraCaptureMetaData$AeState LOCKED;
    public static final CameraCaptureMetaData$AeState SEARCHING;
    public static final CameraCaptureMetaData$AeState UNKNOWN;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraCaptureMetaData$AeState[] f1333a;

    static {
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState = new CameraCaptureMetaData$AeState(Constants.APP_VERSION_UNKNOWN, 0);
        UNKNOWN = cameraCaptureMetaData$AeState;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState2 = new CameraCaptureMetaData$AeState("INACTIVE", 1);
        INACTIVE = cameraCaptureMetaData$AeState2;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState3 = new CameraCaptureMetaData$AeState("SEARCHING", 2);
        SEARCHING = cameraCaptureMetaData$AeState3;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState4 = new CameraCaptureMetaData$AeState("FLASH_REQUIRED", 3);
        FLASH_REQUIRED = cameraCaptureMetaData$AeState4;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState5 = new CameraCaptureMetaData$AeState("CONVERGED", 4);
        CONVERGED = cameraCaptureMetaData$AeState5;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState6 = new CameraCaptureMetaData$AeState("LOCKED", 5);
        LOCKED = cameraCaptureMetaData$AeState6;
        f1333a = new CameraCaptureMetaData$AeState[]{cameraCaptureMetaData$AeState, cameraCaptureMetaData$AeState2, cameraCaptureMetaData$AeState3, cameraCaptureMetaData$AeState4, cameraCaptureMetaData$AeState5, cameraCaptureMetaData$AeState6};
    }

    public static CameraCaptureMetaData$AeState valueOf(String str) {
        return (CameraCaptureMetaData$AeState) Enum.valueOf(CameraCaptureMetaData$AeState.class, str);
    }

    public static CameraCaptureMetaData$AeState[] values() {
        return (CameraCaptureMetaData$AeState[]) f1333a.clone();
    }
}
