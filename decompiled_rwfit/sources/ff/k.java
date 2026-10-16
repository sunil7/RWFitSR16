package ff;

import com.otaliastudios.cameraview.controls.PictureFormat;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f13623a;

    static {
        int[] iArr = new int[PictureFormat.values().length];
        f13623a = iArr;
        try {
            iArr[PictureFormat.JPEG.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f13623a[PictureFormat.DNG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
