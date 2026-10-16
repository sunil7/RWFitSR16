package p0;

import com.google.android.gms.internal.mlkit_vision_barcode.pf;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class h extends pf {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f17326a;

    /* renamed from: b, reason: collision with root package name */
    public final double[][] f17327b;

    /* renamed from: c, reason: collision with root package name */
    public final double[][] f17328c;

    /* renamed from: d, reason: collision with root package name */
    public final double[] f17329d;

    public h(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f17329d = new double[length2];
        int i3 = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i3, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i10 = 0; i10 < length2; i10++) {
            int i11 = 0;
            while (i11 < i3) {
                int i12 = i11 + 1;
                double d5 = dArr[i12] - dArr[i11];
                double[] dArr5 = dArr3[i11];
                double d8 = (dArr2[i12][i10] - dArr2[i11][i10]) / d5;
                dArr5[i10] = d8;
                if (i11 == 0) {
                    dArr4[i11][i10] = d8;
                } else {
                    dArr4[i11][i10] = (dArr3[i11 - 1][i10] + d8) * 0.5d;
                }
                i11 = i12;
            }
            dArr4[i3][i10] = dArr3[length - 2][i10];
        }
        for (int i13 = 0; i13 < i3; i13++) {
            for (int i14 = 0; i14 < length2; i14++) {
                double d10 = dArr3[i13][i14];
                if (d10 == 0.0d) {
                    dArr4[i13][i14] = 0.0d;
                    dArr4[i13 + 1][i14] = 0.0d;
                } else {
                    double d11 = dArr4[i13][i14] / d10;
                    int i15 = i13 + 1;
                    double d12 = dArr4[i15][i14] / d10;
                    double hypot = Math.hypot(d11, d12);
                    if (hypot > 9.0d) {
                        double d13 = 3.0d / hypot;
                        double[] dArr6 = dArr4[i13];
                        double[] dArr7 = dArr3[i13];
                        dArr6[i14] = d11 * d13 * dArr7[i14];
                        dArr4[i15][i14] = d13 * d12 * dArr7[i14];
                    }
                }
            }
        }
        this.f17326a = dArr;
        this.f17327b = dArr2;
        this.f17328c = dArr4;
    }

    public static double h(double d5, double d8, double d10, double d11, double d12, double d13) {
        double d14 = d8 * d8;
        double d15 = d8 * 6.0d;
        double d16 = 6.0d * d14 * d10;
        double d17 = (d16 + ((d15 * d11) + (((-6.0d) * d14) * d11))) - (d15 * d10);
        double d18 = 3.0d * d5;
        return (d5 * d12) + (((((d18 * d12) * d14) + (((d18 * d13) * d14) + d17)) - (((2.0d * d5) * d13) * d8)) - (((4.0d * d5) * d12) * d8));
    }

    public static double i(double d5, double d8, double d10, double d11, double d12, double d13) {
        double d14 = d8 * d8;
        double d15 = d14 * d8;
        double d16 = 3.0d * d14;
        double d17 = d15 * 2.0d * d10;
        double d18 = ((d17 + ((d16 * d11) + (((-2.0d) * d15) * d11))) - (d16 * d10)) + d10;
        double d19 = d5 * d13;
        double d20 = (d19 * d15) + d18;
        double d21 = d5 * d12;
        return (d21 * d8) + ((((d15 * d21) + d20) - (d19 * d14)) - (((d5 * 2.0d) * d12) * d14));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double b(double d5) {
        double d8;
        double d10;
        double e;
        double[] dArr = this.f17326a;
        int length = dArr.length;
        double d11 = dArr[0];
        double[][] dArr2 = this.f17327b;
        if (d5 <= d11) {
            d8 = dArr2[0][0];
            d10 = d5 - d11;
            e = e(d11);
        } else {
            int i3 = length - 1;
            double d12 = dArr[i3];
            if (d5 < d12) {
                int i10 = 0;
                while (i10 < i3) {
                    double d13 = dArr[i10];
                    if (d5 == d13) {
                        return dArr2[i10][0];
                    }
                    int i11 = i10 + 1;
                    double d14 = dArr[i11];
                    if (d5 < d14) {
                        double d15 = d14 - d13;
                        double d16 = (d5 - d13) / d15;
                        double d17 = dArr2[i10][0];
                        double d18 = dArr2[i11][0];
                        double[][] dArr3 = this.f17328c;
                        return i(d15, d16, d17, d18, dArr3[i10][0], dArr3[i11][0]);
                    }
                    i10 = i11;
                }
                return 0.0d;
            }
            d8 = dArr2[i3][0];
            d10 = d5 - d12;
            e = e(d12);
        }
        return (e * d10) + d8;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final void c(double d5, double[] dArr) {
        double[] dArr2 = this.f17326a;
        int length = dArr2.length;
        double[][] dArr3 = this.f17327b;
        int i3 = 0;
        int length2 = dArr3[0].length;
        double d8 = dArr2[0];
        double[] dArr4 = this.f17329d;
        if (d5 <= d8) {
            f(d8, dArr4);
            for (int i10 = 0; i10 < length2; i10++) {
                dArr[i10] = ((d5 - dArr2[0]) * dArr4[i10]) + dArr3[0][i10];
            }
            return;
        }
        int i11 = length - 1;
        double d10 = dArr2[i11];
        if (d5 >= d10) {
            f(d10, dArr4);
            while (i3 < length2) {
                dArr[i3] = ((d5 - dArr2[i11]) * dArr4[i3]) + dArr3[i11][i3];
                i3++;
            }
            return;
        }
        int i12 = 0;
        while (i12 < length - 1) {
            if (d5 == dArr2[i12]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    dArr[i13] = dArr3[i12][i13];
                }
            }
            int i14 = i12 + 1;
            double d11 = dArr2[i14];
            if (d5 < d11) {
                double d12 = dArr2[i12];
                double d13 = d11 - d12;
                double d14 = (d5 - d12) / d13;
                while (i3 < length2) {
                    double d15 = dArr3[i12][i3];
                    double d16 = dArr3[i14][i3];
                    double[][] dArr5 = this.f17328c;
                    dArr[i3] = i(d13, d14, d15, d16, dArr5[i12][i3], dArr5[i14][i3]);
                    i3++;
                }
                return;
            }
            i12 = i14;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final void d(double d5, float[] fArr) {
        double[] dArr = this.f17326a;
        int length = dArr.length;
        double[][] dArr2 = this.f17327b;
        int i3 = 0;
        int length2 = dArr2[0].length;
        double d8 = dArr[0];
        double[] dArr3 = this.f17329d;
        if (d5 <= d8) {
            f(d8, dArr3);
            for (int i10 = 0; i10 < length2; i10++) {
                fArr[i10] = (float) (((d5 - dArr[0]) * dArr3[i10]) + dArr2[0][i10]);
            }
            return;
        }
        int i11 = length - 1;
        double d10 = dArr[i11];
        if (d5 >= d10) {
            f(d10, dArr3);
            while (i3 < length2) {
                fArr[i3] = (float) (((d5 - dArr[i11]) * dArr3[i3]) + dArr2[i11][i3]);
                i3++;
            }
            return;
        }
        int i12 = 0;
        while (i12 < length - 1) {
            if (d5 == dArr[i12]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    fArr[i13] = (float) dArr2[i12][i13];
                }
            }
            int i14 = i12 + 1;
            double d11 = dArr[i14];
            if (d5 < d11) {
                double d12 = dArr[i12];
                double d13 = d11 - d12;
                double d14 = (d5 - d12) / d13;
                while (i3 < length2) {
                    double d15 = dArr2[i12][i3];
                    double d16 = dArr2[i14][i3];
                    double[][] dArr4 = this.f17328c;
                    fArr[i3] = (float) i(d13, d14, d15, d16, dArr4[i12][i3], dArr4[i14][i3]);
                    i3++;
                }
                return;
            }
            i12 = i14;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double e(double d5) {
        double[] dArr = this.f17326a;
        int length = dArr.length;
        double d8 = dArr[0];
        if (d5 >= d8) {
            d8 = dArr[length - 1];
            if (d5 < d8) {
                d8 = d5;
            }
        }
        int i3 = 0;
        while (i3 < length - 1) {
            int i10 = i3 + 1;
            double d10 = dArr[i10];
            if (d8 <= d10) {
                double d11 = dArr[i3];
                double d12 = d10 - d11;
                double[][] dArr2 = this.f17327b;
                double d13 = dArr2[i3][0];
                double d14 = dArr2[i10][0];
                double[][] dArr3 = this.f17328c;
                return h(d12, (d8 - d11) / d12, d13, d14, dArr3[i3][0], dArr3[i10][0]) / d12;
            }
            i3 = i10;
        }
        return 0.0d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final void f(double d5, double[] dArr) {
        double[] dArr2 = this.f17326a;
        int length = dArr2.length;
        double[][] dArr3 = this.f17327b;
        int length2 = dArr3[0].length;
        double d8 = dArr2[0];
        if (d5 > d8) {
            d8 = dArr2[length - 1];
            if (d5 < d8) {
                d8 = d5;
            }
        }
        int i3 = 0;
        while (i3 < length - 1) {
            int i10 = i3 + 1;
            double d10 = dArr2[i10];
            if (d8 <= d10) {
                double d11 = dArr2[i3];
                double d12 = d10 - d11;
                double d13 = (d8 - d11) / d12;
                for (int i11 = 0; i11 < length2; i11++) {
                    double d14 = dArr3[i3][i11];
                    double d15 = dArr3[i10][i11];
                    double[][] dArr4 = this.f17328c;
                    dArr[i11] = h(d12, d13, d14, d15, dArr4[i3][i11], dArr4[i10][i11]) / d12;
                }
                return;
            }
            i3 = i10;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double[] g() {
        return this.f17326a;
    }
}
