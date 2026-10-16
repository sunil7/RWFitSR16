package u7;

import com.github.mikephil.charting.charts.CombinedChart;

/* loaded from: classes.dex */
public abstract /* synthetic */ class f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18944a;

    static {
        int[] iArr = new int[CombinedChart.DrawOrder.values().length];
        f18944a = iArr;
        try {
            iArr[CombinedChart.DrawOrder.BAR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f18944a[CombinedChart.DrawOrder.BUBBLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f18944a[CombinedChart.DrawOrder.LINE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f18944a[CombinedChart.DrawOrder.CANDLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f18944a[CombinedChart.DrawOrder.SCATTER.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
