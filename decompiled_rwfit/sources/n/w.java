package n;

import androidx.camera.core.impl.CameraInternal$State;

/* loaded from: classes.dex */
public abstract /* synthetic */ class w {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f16311a;

    static {
        int[] iArr = new int[CameraInternal$State.values().length];
        f16311a = iArr;
        try {
            iArr[CameraInternal$State.PENDING_OPEN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16311a[CameraInternal$State.OPENING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16311a[CameraInternal$State.OPEN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16311a[CameraInternal$State.CONFIGURED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f16311a[CameraInternal$State.CLOSING.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f16311a[CameraInternal$State.RELEASING.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f16311a[CameraInternal$State.CLOSED.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f16311a[CameraInternal$State.RELEASED.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
