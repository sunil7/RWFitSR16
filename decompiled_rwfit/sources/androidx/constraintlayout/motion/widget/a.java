package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1727a;

    static {
        int[] iArr = new int[MotionLayout.TransitionState.values().length];
        f1727a = iArr;
        try {
            iArr[MotionLayout.TransitionState.UNDEFINED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1727a[MotionLayout.TransitionState.SETUP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1727a[MotionLayout.TransitionState.MOVING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1727a[MotionLayout.TransitionState.FINISHED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
