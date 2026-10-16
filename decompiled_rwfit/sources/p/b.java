package p;

import androidx.camera.core.impl.SurfaceConfig$ConfigType;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f17286a;

    static {
        int[] iArr = new int[SurfaceConfig$ConfigType.values().length];
        f17286a = iArr;
        try {
            iArr[SurfaceConfig$ConfigType.PRIV.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17286a[SurfaceConfig$ConfigType.YUV.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f17286a[SurfaceConfig$ConfigType.JPEG.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
