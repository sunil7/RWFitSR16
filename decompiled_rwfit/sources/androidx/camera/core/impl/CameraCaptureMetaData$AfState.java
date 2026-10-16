package androidx.camera.core.impl;

import com.tencent.connect.common.Constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class CameraCaptureMetaData$AfState {
    public static final CameraCaptureMetaData$AfState INACTIVE;
    public static final CameraCaptureMetaData$AfState LOCKED_FOCUSED;
    public static final CameraCaptureMetaData$AfState LOCKED_NOT_FOCUSED;
    public static final CameraCaptureMetaData$AfState PASSIVE_FOCUSED;
    public static final CameraCaptureMetaData$AfState PASSIVE_NOT_FOCUSED;
    public static final CameraCaptureMetaData$AfState SCANNING;
    public static final CameraCaptureMetaData$AfState UNKNOWN;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraCaptureMetaData$AfState[] f1334a;

    static {
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState = new CameraCaptureMetaData$AfState(Constants.APP_VERSION_UNKNOWN, 0);
        UNKNOWN = cameraCaptureMetaData$AfState;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState2 = new CameraCaptureMetaData$AfState("INACTIVE", 1);
        INACTIVE = cameraCaptureMetaData$AfState2;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState3 = new CameraCaptureMetaData$AfState("SCANNING", 2);
        SCANNING = cameraCaptureMetaData$AfState3;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState4 = new CameraCaptureMetaData$AfState("PASSIVE_FOCUSED", 3);
        PASSIVE_FOCUSED = cameraCaptureMetaData$AfState4;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState5 = new CameraCaptureMetaData$AfState("PASSIVE_NOT_FOCUSED", 4);
        PASSIVE_NOT_FOCUSED = cameraCaptureMetaData$AfState5;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState6 = new CameraCaptureMetaData$AfState("LOCKED_FOCUSED", 5);
        LOCKED_FOCUSED = cameraCaptureMetaData$AfState6;
        CameraCaptureMetaData$AfState cameraCaptureMetaData$AfState7 = new CameraCaptureMetaData$AfState("LOCKED_NOT_FOCUSED", 6);
        LOCKED_NOT_FOCUSED = cameraCaptureMetaData$AfState7;
        f1334a = new CameraCaptureMetaData$AfState[]{cameraCaptureMetaData$AfState, cameraCaptureMetaData$AfState2, cameraCaptureMetaData$AfState3, cameraCaptureMetaData$AfState4, cameraCaptureMetaData$AfState5, cameraCaptureMetaData$AfState6, cameraCaptureMetaData$AfState7};
    }

    public static CameraCaptureMetaData$AfState valueOf(String str) {
        return (CameraCaptureMetaData$AfState) Enum.valueOf(CameraCaptureMetaData$AfState.class, str);
    }

    public static CameraCaptureMetaData$AfState[] values() {
        return (CameraCaptureMetaData$AfState[]) f1334a.clone();
    }
}
