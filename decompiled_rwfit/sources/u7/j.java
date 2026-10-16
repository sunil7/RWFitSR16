package u7;

import com.github.mikephil.charting.components.Legend$LegendForm;
import com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment;
import com.github.mikephil.charting.components.Legend$LegendOrientation;
import com.github.mikephil.charting.components.Legend$LegendVerticalAlignment;

/* loaded from: classes.dex */
public abstract /* synthetic */ class j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f18952a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f18953b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f18954c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f18955d;

    static {
        int[] iArr = new int[Legend$LegendForm.values().length];
        f18955d = iArr;
        try {
            iArr[Legend$LegendForm.NONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f18955d[Legend$LegendForm.EMPTY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f18955d[Legend$LegendForm.DEFAULT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f18955d[Legend$LegendForm.CIRCLE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f18955d[Legend$LegendForm.SQUARE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f18955d[Legend$LegendForm.LINE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        int[] iArr2 = new int[Legend$LegendOrientation.values().length];
        f18954c = iArr2;
        try {
            iArr2[Legend$LegendOrientation.HORIZONTAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f18954c[Legend$LegendOrientation.VERTICAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        int[] iArr3 = new int[Legend$LegendVerticalAlignment.values().length];
        f18953b = iArr3;
        try {
            iArr3[Legend$LegendVerticalAlignment.TOP.ordinal()] = 1;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f18953b[Legend$LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f18953b[Legend$LegendVerticalAlignment.CENTER.ordinal()] = 3;
        } catch (NoSuchFieldError unused11) {
        }
        int[] iArr4 = new int[Legend$LegendHorizontalAlignment.values().length];
        f18952a = iArr4;
        try {
            iArr4[Legend$LegendHorizontalAlignment.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f18952a[Legend$LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f18952a[Legend$LegendHorizontalAlignment.CENTER.ordinal()] = 3;
        } catch (NoSuchFieldError unused14) {
        }
    }
}
