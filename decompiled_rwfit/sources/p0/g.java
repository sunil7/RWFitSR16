package p0;

import com.google.android.gms.internal.mlkit_vision_barcode.pf;

/* loaded from: classes.dex */
public final class g extends pf {

    /* renamed from: a, reason: collision with root package name */
    public double[] f17323a;

    /* renamed from: b, reason: collision with root package name */
    public double[][] f17324b;

    /* renamed from: c, reason: collision with root package name */
    public double[] f17325c;

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double b(double d5) {
        double d8;
        double d10;
        double e;
        double[] dArr = this.f17323a;
        int length = dArr.length;
        double d11 = dArr[0];
        double[][] dArr2 = this.f17324b;
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
                        double d15 = (d5 - d13) / (d14 - d13);
                        return (dArr2[i11][0] * d15) + ((1.0d - d15) * dArr2[i10][0]);
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
        double[] dArr2 = this.f17323a;
        int length = dArr2.length;
        double[][] dArr3 = this.f17324b;
        int i3 = 0;
        int length2 = dArr3[0].length;
        double d8 = dArr2[0];
        double[] dArr4 = this.f17325c;
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
                double d13 = (d5 - d12) / (d11 - d12);
                while (i3 < length2) {
                    dArr[i3] = (dArr3[i14][i3] * d13) + ((1.0d - d13) * dArr3[i12][i3]);
                    i3++;
                }
                return;
            }
            i12 = i14;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final void d(double d5, float[] fArr) {
        double[] dArr = this.f17323a;
        int length = dArr.length;
        double[][] dArr2 = this.f17324b;
        int i3 = 0;
        int length2 = dArr2[0].length;
        double d8 = dArr[0];
        double[] dArr3 = this.f17325c;
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
                double d13 = (d5 - d12) / (d11 - d12);
                while (i3 < length2) {
                    fArr[i3] = (float) ((dArr2[i14][i3] * d13) + ((1.0d - d13) * dArr2[i12][i3]));
                    i3++;
                }
                return;
            }
            i12 = i14;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0012, code lost:
    
        if (r9 >= r3) goto L4;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final double e(double r9) {
        /*
            r8 = this;
            double[] r0 = r8.f17323a
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r9 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 < 0) goto L15
            goto La
        L15:
            r3 = r2
        L16:
            int r4 = r1 + (-1)
            if (r3 >= r4) goto L34
            int r4 = r3 + 1
            r5 = r0[r4]
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 > 0) goto L32
            r9 = r0[r3]
            double r5 = r5 - r9
            double[][] r9 = r8.f17324b
            r10 = r9[r3]
            r0 = r10[r2]
            r9 = r9[r4]
            r2 = r9[r2]
            double r2 = r2 - r0
            double r2 = r2 / r5
            return r2
        L32:
            r3 = r4
            goto L16
        L34:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.g.e(double):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
    
        if (r12 >= r5) goto L4;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(double r12, double[] r14) {
        /*
            r11 = this;
            double[] r0 = r11.f17323a
            int r1 = r0.length
            double[][] r2 = r11.f17324b
            r3 = 0
            r4 = r2[r3]
            int r4 = r4.length
            r5 = r0[r3]
            int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r7 > 0) goto L11
        Lf:
            r12 = r5
            goto L1a
        L11:
            int r5 = r1 + (-1)
            r5 = r0[r5]
            int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r7 < 0) goto L1a
            goto Lf
        L1a:
            r5 = r3
        L1b:
            int r6 = r1 + (-1)
            if (r5 >= r6) goto L3d
            int r6 = r5 + 1
            r7 = r0[r6]
            int r9 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r9 > 0) goto L3b
            r12 = r0[r5]
            double r7 = r7 - r12
        L2a:
            if (r3 >= r4) goto L3d
            r12 = r2[r5]
            r0 = r12[r3]
            r12 = r2[r6]
            r9 = r12[r3]
            double r9 = r9 - r0
            double r9 = r9 / r7
            r14[r3] = r9
            int r3 = r3 + 1
            goto L2a
        L3b:
            r5 = r6
            goto L1b
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.g.f(double, double[]):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.pf
    public final double[] g() {
        return this.f17323a;
    }
}
