package n;

import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;

/* loaded from: classes.dex */
public abstract /* synthetic */ class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f16289a;

    static {
        int[] iArr = new int[UseCaseConfigFactory$CaptureType.values().length];
        f16289a = iArr;
        try {
            iArr[UseCaseConfigFactory$CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16289a[UseCaseConfigFactory$CaptureType.VIDEO_CAPTURE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16289a[UseCaseConfigFactory$CaptureType.STREAM_SHARING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16289a[UseCaseConfigFactory$CaptureType.PREVIEW.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f16289a[UseCaseConfigFactory$CaptureType.IMAGE_ANALYSIS.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
