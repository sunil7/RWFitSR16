package t0;

import android.view.View;
import com.google.android.gms.internal.mlkit_vision_barcode.pf;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public p0.f f18444a;

    /* renamed from: b, reason: collision with root package name */
    public String f18445b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f18446c = new ArrayList();

    public final float a(float f2) {
        p0.f fVar = this.f18444a;
        pf pfVar = (pf) fVar.f17322i;
        if (pfVar != null) {
            pfVar.c(f2, (double[]) fVar.f17320g);
        } else {
            double[] dArr = (double[]) fVar.f17320g;
            dArr[0] = ((float[]) fVar.f17318d)[0];
            dArr[1] = ((float[]) fVar.e)[0];
            dArr[2] = ((float[]) fVar.f17316b)[0];
        }
        double[] dArr2 = (double[]) fVar.f17320g;
        return (float) ((((n.l) fVar.f17315a).k(f2, dArr2[1]) * ((double[]) fVar.f17320g)[2]) + dArr2[0]);
    }

    public final float b(float f2) {
        char c9;
        char c10;
        p0.f fVar = this.f18444a;
        pf pfVar = (pf) fVar.f17322i;
        double d5 = 0.0d;
        if (pfVar != null) {
            double d8 = f2;
            pfVar.f(d8, (double[]) fVar.f17321h);
            ((pf) fVar.f17322i).c(d8, (double[]) fVar.f17320g);
        } else {
            double[] dArr = (double[]) fVar.f17321h;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
            dArr[2] = 0.0d;
        }
        double d10 = f2;
        double d11 = ((double[]) fVar.f17320g)[1];
        n.l lVar = (n.l) fVar.f17315a;
        double k10 = lVar.k(d10, d11);
        double d12 = ((double[]) fVar.f17320g)[1];
        double d13 = ((double[]) fVar.f17321h)[1];
        double h4 = lVar.h(d10) + d12;
        if (d10 <= 0.0d) {
            d10 = 1.0E-5d;
        } else if (d10 >= 1.0d) {
            d10 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch((double[]) lVar.f16246c, d10);
        if (binarySearch <= 0 && binarySearch != 0) {
            int i3 = -binarySearch;
            int i10 = i3 - 1;
            float[] fArr = (float[]) lVar.f16245b;
            float f10 = fArr[i10];
            int i11 = i3 - 2;
            float f11 = fArr[i11];
            c9 = 0;
            c10 = 2;
            double[] dArr2 = (double[]) lVar.f16246c;
            double d14 = dArr2[i10];
            double d15 = dArr2[i11];
            double d16 = (f10 - f11) / (d14 - d15);
            d5 = (f11 - (d16 * d15)) + (d10 * d16);
        } else {
            c9 = 0;
            c10 = 2;
        }
        double cos = Math.cos(6.283185307179586d * h4) * (d5 + d13) * 6.283185307179586d;
        double[] dArr3 = (double[]) fVar.f17321h;
        return (float) ((cos * ((double[]) fVar.f17320g)[c10]) + (k10 * dArr3[c10]) + dArr3[c9]);
    }

    public abstract void c(View view, float f2);

    public final void d() {
        ArrayList arrayList = this.f18446c;
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        Collections.sort(arrayList, new androidx.viewpager2.widget.a(13));
        double[] dArr = new double[size];
        char c9 = 2;
        int i3 = 0;
        Class cls = Double.TYPE;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) cls, size, 3);
        p0.f fVar = new p0.f();
        n.l lVar = new n.l(2);
        lVar.f16245b = new float[0];
        lVar.f16246c = new double[0];
        fVar.f17315a = lVar;
        fVar.f17316b = new float[size];
        fVar.f17319f = new double[size];
        fVar.f17317c = new float[size];
        fVar.f17318d = new float[size];
        fVar.e = new float[size];
        float[] fArr = new float[size];
        this.f18444a = fVar;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
        p0.f fVar2 = this.f18444a;
        double[] dArr3 = (double[]) fVar2.f17319f;
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, dArr3.length, 3);
        float[] fArr2 = (float[]) fVar2.f17316b;
        fVar2.f17320g = new double[fArr2.length + 2];
        fVar2.f17321h = new double[fArr2.length + 2];
        double d5 = dArr3[0];
        float[] fArr3 = (float[]) fVar2.f17317c;
        n.l lVar2 = (n.l) fVar2.f17315a;
        if (d5 > 0.0d) {
            lVar2.e(0.0d, fArr3[0]);
        }
        int length = dArr3.length - 1;
        if (dArr3[length] < 1.0d) {
            lVar2.e(1.0d, fArr3[length]);
        }
        int i10 = 0;
        while (i10 < dArr4.length) {
            double[] dArr5 = dArr4[i10];
            char c10 = c9;
            dArr5[0] = ((float[]) fVar2.f17318d)[i10];
            dArr5[1] = ((float[]) fVar2.e)[i10];
            dArr5[c10] = fArr2[i10];
            lVar2.e(dArr3[i10], fArr3[i10]);
            i10++;
            c9 = c10;
            dArr2 = dArr2;
        }
        double[][] dArr6 = dArr2;
        int i11 = 0;
        double d8 = 0.0d;
        while (true) {
            if (i11 >= ((float[]) lVar2.f16245b).length) {
                break;
            }
            d8 += r5[i11];
            i11++;
        }
        int i12 = 1;
        double d10 = 0.0d;
        while (true) {
            float[] fArr4 = (float[]) lVar2.f16245b;
            if (i12 >= fArr4.length) {
                break;
            }
            int i13 = i12 - 1;
            float f2 = (fArr4[i13] + fArr4[i12]) / 2.0f;
            double[] dArr7 = (double[]) lVar2.f16246c;
            d10 = ((dArr7[i12] - dArr7[i13]) * f2) + d10;
            i12++;
            i3 = i3;
            d8 = d8;
        }
        int i14 = i3;
        double d11 = d8;
        int i15 = i14;
        while (true) {
            float[] fArr5 = (float[]) lVar2.f16245b;
            if (i15 >= fArr5.length) {
                break;
            }
            fArr5[i15] = (float) (fArr5[i15] * (d11 / d10));
            i15++;
        }
        ((double[]) lVar2.f16247d)[i14] = 0.0d;
        int i16 = 1;
        while (true) {
            float[] fArr6 = (float[]) lVar2.f16245b;
            if (i16 >= fArr6.length) {
                break;
            }
            int i17 = i16 - 1;
            float f10 = (fArr6[i17] + fArr6[i16]) / 2.0f;
            double[] dArr8 = (double[]) lVar2.f16246c;
            double d12 = dArr8[i16] - dArr8[i17];
            double[] dArr9 = (double[]) lVar2.f16247d;
            dArr9[i16] = (d12 * f10) + dArr9[i17];
            i16++;
        }
        if (dArr3.length > 1) {
            fVar2.f17322i = pf.a(i14, dArr3, dArr4);
        } else {
            fVar2.f17322i = null;
        }
        pf.a(i14, dArr, dArr6);
    }

    public final String toString() {
        String str = this.f18445b;
        new DecimalFormat("##.##");
        Iterator it = this.f18446c.iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
        return str;
    }
}
