package m7;

import com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment;
import com.github.mikephil.charting.components.Legend$LegendOrientation;
import com.github.mikephil.charting.components.Legend$LegendVerticalAlignment;

/* loaded from: classes.dex */
public abstract /* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f15985a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f15986b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f15987c;

    static {
        int[] iArr = new int[Legend$LegendOrientation.values().length];
        f15987c = iArr;
        try {
            iArr[Legend$LegendOrientation.VERTICAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15987c[Legend$LegendOrientation.HORIZONTAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[Legend$LegendHorizontalAlignment.values().length];
        f15986b = iArr2;
        try {
            iArr2[Legend$LegendHorizontalAlignment.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f15986b[Legend$LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f15986b[Legend$LegendHorizontalAlignment.CENTER.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        int[] iArr3 = new int[Legend$LegendVerticalAlignment.values().length];
        f15985a = iArr3;
        try {
            iArr3[Legend$LegendVerticalAlignment.TOP.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f15985a[Legend$LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
