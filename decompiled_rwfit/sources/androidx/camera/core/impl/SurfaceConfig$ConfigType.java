package androidx.camera.core.impl;

import com.google.android.exoplayer2.metadata.id3.PrivFrame;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class SurfaceConfig$ConfigType {
    public static final SurfaceConfig$ConfigType JPEG;
    public static final SurfaceConfig$ConfigType JPEG_R;
    public static final SurfaceConfig$ConfigType PRIV;
    public static final SurfaceConfig$ConfigType RAW;
    public static final SurfaceConfig$ConfigType YUV;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SurfaceConfig$ConfigType[] f1340a;

    static {
        SurfaceConfig$ConfigType surfaceConfig$ConfigType = new SurfaceConfig$ConfigType(PrivFrame.ID, 0);
        PRIV = surfaceConfig$ConfigType;
        SurfaceConfig$ConfigType surfaceConfig$ConfigType2 = new SurfaceConfig$ConfigType("YUV", 1);
        YUV = surfaceConfig$ConfigType2;
        SurfaceConfig$ConfigType surfaceConfig$ConfigType3 = new SurfaceConfig$ConfigType("JPEG", 2);
        JPEG = surfaceConfig$ConfigType3;
        SurfaceConfig$ConfigType surfaceConfig$ConfigType4 = new SurfaceConfig$ConfigType("JPEG_R", 3);
        JPEG_R = surfaceConfig$ConfigType4;
        SurfaceConfig$ConfigType surfaceConfig$ConfigType5 = new SurfaceConfig$ConfigType("RAW", 4);
        RAW = surfaceConfig$ConfigType5;
        f1340a = new SurfaceConfig$ConfigType[]{surfaceConfig$ConfigType, surfaceConfig$ConfigType2, surfaceConfig$ConfigType3, surfaceConfig$ConfigType4, surfaceConfig$ConfigType5};
    }

    public static SurfaceConfig$ConfigType valueOf(String str) {
        return (SurfaceConfig$ConfigType) Enum.valueOf(SurfaceConfig$ConfigType.class, str);
    }

    public static SurfaceConfig$ConfigType[] values() {
        return (SurfaceConfig$ConfigType[]) f1340a.clone();
    }
}
