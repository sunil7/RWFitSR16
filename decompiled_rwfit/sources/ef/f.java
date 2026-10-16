package ef;

import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Preview;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureAction;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f12618a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f12619b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f12620c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f12621d;

    static {
        int[] iArr = new int[Facing.values().length];
        f12621d = iArr;
        try {
            iArr[Facing.BACK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f12621d[Facing.FRONT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[GestureAction.values().length];
        f12620c = iArr2;
        try {
            iArr2[GestureAction.TAKE_PICTURE_SNAPSHOT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f12620c[GestureAction.TAKE_PICTURE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f12620c[GestureAction.AUTO_FOCUS.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f12620c[GestureAction.ZOOM.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f12620c[GestureAction.EXPOSURE_CORRECTION.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f12620c[GestureAction.FILTER_CONTROL_1.ordinal()] = 6;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f12620c[GestureAction.FILTER_CONTROL_2.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
        int[] iArr3 = new int[Gesture.values().length];
        f12619b = iArr3;
        try {
            iArr3[Gesture.PINCH.ordinal()] = 1;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f12619b[Gesture.TAP.ordinal()] = 2;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f12619b[Gesture.LONG_TAP.ordinal()] = 3;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f12619b[Gesture.SCROLL_HORIZONTAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f12619b[Gesture.SCROLL_VERTICAL.ordinal()] = 5;
        } catch (NoSuchFieldError unused14) {
        }
        int[] iArr4 = new int[Preview.values().length];
        f12618a = iArr4;
        try {
            iArr4[Preview.SURFACE.ordinal()] = 1;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f12618a[Preview.TEXTURE.ordinal()] = 2;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f12618a[Preview.GL_SURFACE.ordinal()] = 3;
        } catch (NoSuchFieldError unused17) {
        }
    }
}
