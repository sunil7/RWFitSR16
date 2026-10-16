package t0;

import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.pf;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public pf f18451a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f18452b = new int[10];

    /* renamed from: c, reason: collision with root package name */
    public float[] f18453c = new float[10];

    /* renamed from: d, reason: collision with root package name */
    public int f18454d;
    public String e;

    public final float a(float f2) {
        return (float) this.f18451a.b(f2);
    }

    public void b(float f2, int i3) {
        int[] iArr = this.f18452b;
        if (iArr.length < this.f18454d + 1) {
            this.f18452b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f18453c;
            this.f18453c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f18452b;
        int i10 = this.f18454d;
        iArr2[i10] = i3;
        this.f18453c[i10] = f2;
        this.f18454d = i10 + 1;
    }

    public abstract void c(View view, float f2);

    public void d(int i3) {
        int i10;
        int i11 = this.f18454d;
        if (i11 == 0) {
            return;
        }
        int[] iArr = this.f18452b;
        float[] fArr = this.f18453c;
        int[] iArr2 = new int[iArr.length + 10];
        iArr2[0] = i11 - 1;
        iArr2[1] = 0;
        int i12 = 2;
        while (i12 > 0) {
            int i13 = i12 - 1;
            int i14 = iArr2[i13];
            int i15 = i12 - 2;
            int i16 = iArr2[i15];
            if (i14 < i16) {
                int i17 = iArr[i16];
                int i18 = i14;
                int i19 = i18;
                while (i18 < i16) {
                    int i20 = iArr[i18];
                    if (i20 <= i17) {
                        int i21 = iArr[i19];
                        iArr[i19] = i20;
                        iArr[i18] = i21;
                        float f2 = fArr[i19];
                        fArr[i19] = fArr[i18];
                        fArr[i18] = f2;
                        i19++;
                    }
                    i18++;
                }
                int i22 = iArr[i19];
                iArr[i19] = iArr[i16];
                iArr[i16] = i22;
                float f10 = fArr[i19];
                fArr[i19] = fArr[i16];
                fArr[i16] = f10;
                iArr2[i15] = i19 - 1;
                iArr2[i13] = i14;
                int i23 = i12 + 1;
                iArr2[i12] = i16;
                i12 += 2;
                iArr2[i23] = i19 + 1;
            } else {
                i12 = i15;
            }
        }
        int i24 = 1;
        for (int i25 = 1; i25 < this.f18454d; i25++) {
            int[] iArr3 = this.f18452b;
            if (iArr3[i25 - 1] != iArr3[i25]) {
                i24++;
            }
        }
        double[] dArr = new double[i24];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i24, 1);
        int i26 = 0;
        for (0; i10 < this.f18454d; i10 + 1) {
            if (i10 > 0) {
                int[] iArr4 = this.f18452b;
                i10 = iArr4[i10] == iArr4[i10 - 1] ? i10 + 1 : 0;
            }
            dArr[i26] = this.f18452b[i10] * 0.01d;
            dArr2[i26][0] = this.f18453c[i10];
            i26++;
        }
        this.f18451a = pf.a(i3, dArr, dArr2);
    }

    public final String toString() {
        String str = this.e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i3 = 0; i3 < this.f18454d; i3++) {
            StringBuilder u10 = l0.u(str, "[");
            u10.append(this.f18452b[i3]);
            u10.append(" , ");
            u10.append(decimalFormat.format(this.f18453c[i3]));
            u10.append("] ");
            str = u10.toString();
        }
        return str;
    }
}
