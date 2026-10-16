package uf;

import com.otaliastudios.cameraview.controls.PictureFormat;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19074a;

    static {
        int[] iArr = new int[PictureFormat.values().length];
        f19074a = iArr;
        try {
            iArr[PictureFormat.JPEG.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19074a[PictureFormat.DNG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
