package lf;

import com.otaliastudios.cameraview.engine.offset.Reference;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f15869a;

    static {
        int[] iArr = new int[Reference.values().length];
        f15869a = iArr;
        try {
            iArr[Reference.VIEW.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15869a[Reference.OUTPUT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f15869a[Reference.SENSOR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
