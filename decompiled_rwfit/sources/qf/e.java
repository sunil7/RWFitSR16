package qf;

import com.otaliastudios.cameraview.controls.Grid;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f17944a;

    static {
        int[] iArr = new int[Grid.values().length];
        f17944a = iArr;
        try {
            iArr[Grid.OFF.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17944a[Grid.DRAW_3X3.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f17944a[Grid.DRAW_PHI.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f17944a[Grid.DRAW_4X4.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
