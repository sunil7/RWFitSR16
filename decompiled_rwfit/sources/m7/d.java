package m7;

import com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment;
import com.github.mikephil.charting.components.Legend$LegendOrientation;
import com.github.mikephil.charting.components.Legend$LegendVerticalAlignment;

/* loaded from: classes.dex */
public abstract /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f15988a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f15989b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f15990c;

    static {
        int[] iArr = new int[Legend$LegendOrientation.values().length];
        f15990c = iArr;
        try {
            iArr[Legend$LegendOrientation.VERTICAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15990c[Legend$LegendOrientation.HORIZONTAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[Legend$LegendHorizontalAlignment.values().length];
        f15989b = iArr2;
        try {
            iArr2[Legend$LegendHorizontalAlignment.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f15989b[Legend$LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f15989b[Legend$LegendHorizontalAlignment.CENTER.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        int[] iArr3 = new int[Legend$LegendVerticalAlignment.values().length];
        f15988a = iArr3;
        try {
            iArr3[Legend$LegendVerticalAlignment.TOP.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f15988a[Legend$LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
