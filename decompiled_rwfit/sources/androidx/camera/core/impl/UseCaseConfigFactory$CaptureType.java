package androidx.camera.core.impl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class UseCaseConfigFactory$CaptureType {
    public static final UseCaseConfigFactory$CaptureType IMAGE_ANALYSIS;
    public static final UseCaseConfigFactory$CaptureType IMAGE_CAPTURE;
    public static final UseCaseConfigFactory$CaptureType METERING_REPEATING;
    public static final UseCaseConfigFactory$CaptureType PREVIEW;
    public static final UseCaseConfigFactory$CaptureType STREAM_SHARING;
    public static final UseCaseConfigFactory$CaptureType VIDEO_CAPTURE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UseCaseConfigFactory$CaptureType[] f1341a;

    static {
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType = new UseCaseConfigFactory$CaptureType("IMAGE_CAPTURE", 0);
        IMAGE_CAPTURE = useCaseConfigFactory$CaptureType;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType2 = new UseCaseConfigFactory$CaptureType("PREVIEW", 1);
        PREVIEW = useCaseConfigFactory$CaptureType2;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType3 = new UseCaseConfigFactory$CaptureType("IMAGE_ANALYSIS", 2);
        IMAGE_ANALYSIS = useCaseConfigFactory$CaptureType3;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType4 = new UseCaseConfigFactory$CaptureType("VIDEO_CAPTURE", 3);
        VIDEO_CAPTURE = useCaseConfigFactory$CaptureType4;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType5 = new UseCaseConfigFactory$CaptureType("STREAM_SHARING", 4);
        STREAM_SHARING = useCaseConfigFactory$CaptureType5;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType6 = new UseCaseConfigFactory$CaptureType("METERING_REPEATING", 5);
        METERING_REPEATING = useCaseConfigFactory$CaptureType6;
        f1341a = new UseCaseConfigFactory$CaptureType[]{useCaseConfigFactory$CaptureType, useCaseConfigFactory$CaptureType2, useCaseConfigFactory$CaptureType3, useCaseConfigFactory$CaptureType4, useCaseConfigFactory$CaptureType5, useCaseConfigFactory$CaptureType6};
    }

    public static UseCaseConfigFactory$CaptureType valueOf(String str) {
        return (UseCaseConfigFactory$CaptureType) Enum.valueOf(UseCaseConfigFactory$CaptureType.class, str);
    }

    public static UseCaseConfigFactory$CaptureType[] values() {
        return (UseCaseConfigFactory$CaptureType[]) f1341a.clone();
    }
}
