package tf;

import com.otaliastudios.cameraview.overlay.Overlay$Target;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18624a;

    static {
        int[] iArr = new int[Overlay$Target.values().length];
        f18624a = iArr;
        try {
            iArr[Overlay$Target.PREVIEW.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f18624a[Overlay$Target.VIDEO_SNAPSHOT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f18624a[Overlay$Target.PICTURE_SNAPSHOT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
