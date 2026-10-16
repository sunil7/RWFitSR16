package u7;

import com.github.mikephil.charting.data.LineDataSet$Mode;

/* loaded from: classes.dex */
public abstract /* synthetic */ class l {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18961a;

    static {
        int[] iArr = new int[LineDataSet$Mode.values().length];
        f18961a = iArr;
        try {
            iArr[LineDataSet$Mode.LINEAR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f18961a[LineDataSet$Mode.STEPPED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f18961a[LineDataSet$Mode.CUBIC_BEZIER.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f18961a[LineDataSet$Mode.HORIZONTAL_BEZIER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
