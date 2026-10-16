package bd;

import ad.h;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public abstract class a extends h {

    /* renamed from: b, reason: collision with root package name */
    public final int[] f3207b;
    public final int[] e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f3210f;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f3206a = new int[4];

    /* renamed from: c, reason: collision with root package name */
    public final float[] f3208c = new float[4];

    /* renamed from: d, reason: collision with root package name */
    public final float[] f3209d = new float[4];

    public a() {
        int[] iArr = new int[8];
        this.f3207b = iArr;
        this.e = new int[iArr.length / 2];
        this.f3210f = new int[iArr.length / 2];
    }

    public static void h(int[] iArr, float[] fArr) {
        int i3 = 0;
        float f2 = fArr[0];
        for (int i10 = 1; i10 < iArr.length; i10++) {
            float f10 = fArr[i10];
            if (f10 < f2) {
                i3 = i10;
                f2 = f10;
            }
        }
        iArr[i3] = iArr[i3] - 1;
    }

    public static void i(int[] iArr, float[] fArr) {
        int i3 = 0;
        float f2 = fArr[0];
        for (int i10 = 1; i10 < iArr.length; i10++) {
            float f10 = fArr[i10];
            if (f10 > f2) {
                i3 = i10;
                f2 = f10;
            }
        }
        iArr[i3] = iArr[i3] + 1;
    }

    public static boolean j(int[] iArr) {
        float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f2 >= 0.7916667f && f2 <= 0.89285713f) {
            int i3 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            int i10 = Integer.MIN_VALUE;
            for (int i11 : iArr) {
                if (i11 > i10) {
                    i10 = i11;
                }
                if (i11 < i3) {
                    i3 = i11;
                }
            }
            if (i10 < i3 * 10) {
                return true;
            }
        }
        return false;
    }
}
