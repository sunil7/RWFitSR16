package hd;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.zxing.h;
import java.util.Arrays;
import sc.b;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f14308a = {0, 4, 1, 5};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f14309b = {6, 2, 7, 3};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f14310c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f14311d = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    public static final int[] e = {0, 180, SubsamplingScaleImageView.ORIENTATION_270, 90};

    public static int[] a(b bVar, int i3, int i10, int i11, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i12 = 0;
        while (bVar.b(i3, i10) && i3 > 0) {
            int i13 = i12 + 1;
            if (i12 >= 3) {
                break;
            }
            i3--;
            i12 = i13;
        }
        int length = iArr.length;
        int i14 = i3;
        int i15 = 0;
        boolean z5 = false;
        while (i3 < i11) {
            if (bVar.b(i3, i10) != z5) {
                iArr2[i15] = iArr2[i15] + 1;
            } else {
                if (i15 != length - 1) {
                    i15++;
                } else {
                    if (c(iArr2, iArr) < 0.42f) {
                        return new int[]{i14, i3};
                    }
                    i14 += iArr2[0] + iArr2[1];
                    int i16 = i15 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i16);
                    iArr2[i16] = 0;
                    iArr2[i15] = 0;
                    i15--;
                }
                iArr2[i15] = 1;
                z5 = !z5;
            }
            i3++;
        }
        if (i15 != length - 1 || c(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i14, i3 - 1};
    }

    public static h[] b(b bVar, int i3, int i10, int i11, int i12, int i13, int[] iArr) {
        int i14;
        boolean z5;
        int[] a3;
        h[] hVarArr = new h[4];
        int[] iArr2 = iArr;
        int[] iArr3 = new int[iArr2.length];
        int i15 = i11;
        while (true) {
            if (i15 >= i3) {
                i14 = i15;
                z5 = false;
                break;
            }
            int[] a10 = a(bVar, i12, i15, i10, iArr2, iArr3);
            if (a10 != null) {
                int[] iArr4 = a10;
                while (true) {
                    i14 = i15;
                    if (i14 <= 0 || (a3 = a(bVar, i12, i14 - 1, i10, iArr, iArr3)) == null) {
                        break;
                    }
                    iArr4 = a3;
                }
                float f2 = i14;
                hVarArr[0] = new h(iArr4[0], f2);
                hVarArr[1] = new h(iArr4[1], f2);
                z5 = true;
            } else {
                i15 += 5;
                iArr2 = iArr;
            }
        }
        int i16 = i14 + 1;
        if (z5) {
            int[] iArr5 = {(int) hVarArr[0].f11247a, (int) hVarArr[1].f11247a};
            int i17 = i16;
            int i18 = 0;
            while (i17 < i3) {
                int[] a11 = a(bVar, iArr5[0], i17, i10, iArr, iArr3);
                if (a11 != null && Math.abs(iArr5[0] - a11[0]) < 5 && Math.abs(iArr5[1] - a11[1]) < 5) {
                    iArr5 = a11;
                    i18 = 0;
                } else {
                    if (i18 > 25) {
                        break;
                    }
                    i18++;
                }
                i17++;
            }
            i16 = i17 - (i18 + 1);
            float f10 = i16;
            hVarArr[2] = new h(iArr5[0], f10);
            hVarArr[3] = new h(iArr5[1], f10);
        }
        if (i16 - i14 < i13) {
            Arrays.fill(hVarArr, (Object) null);
        }
        return hVarArr;
    }

    public static float c(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i3 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            i3 += iArr[i11];
            i10 += iArr2[i11];
        }
        if (i3 < i10) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i3;
        float f10 = f2 / i10;
        float f11 = 0.8f * f10;
        float f12 = 0.0f;
        for (int i12 = 0; i12 < length; i12++) {
            float f13 = iArr2[i12] * f10;
            float f14 = iArr[i12];
            float f15 = f14 > f13 ? f14 - f13 : f13 - f14;
            if (f15 > f11) {
                return Float.POSITIVE_INFINITY;
            }
            f12 += f15;
        }
        return f12 / f2;
    }
}
